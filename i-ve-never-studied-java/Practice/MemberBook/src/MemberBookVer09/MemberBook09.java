package MemberBookVer09;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

// GUI�� ���� Swing������Ʈ ����
// �ڵ�����

// �޴� �������̽��� ����
interface INIT_MENU{ int INPUT=1, EXIT=4;}

interface INPUT_SELECT{ int NORMAL=1, UNIV=2, COMPANY=3;}

// �޴����� ���� �� ��������� ����ó��
class MenuChoiceException extends Exception {
	int wrongChoice;
	
	public MenuChoiceException(int choice) {
		super("�߸��� ������ �̷������ϴ�.");
		wrongChoice = choice;
	}
	public void showWrongChoice() {
		System.out.println(wrongChoice + "�� �ش��ϴ� ������ �������� �ʽ��ϴ�.");
	}
}

// ȸ���� �Ϲ�����(�⺻) �ʱ�ȭ �� ���
class MemberInfo implements Serializable{
	String name;
	String phoneNumber;
	
	public MemberInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
	}
	
	public void showMemberInfo() {
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ��ȣ : " + phoneNumber);
	}
	
	public String toString() {
		return "name : " + name + '\n' + "phone : " + phoneNumber+'\n';
	}
	// hashCode() �������̵�
	public int hashCode() {
		return name.hashCode();
	}
	
	// ObjectŬ������ �̿��� ��
	public boolean equals(Object obj) {
		MemberInfo cmp = (MemberInfo)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}

// ���б����� �� ���������� �Է� �߰�
class MemberUnivInfo extends MemberInfo {
	String major;
	int year;
	
	public MemberUnivInfo(String name, String num, String major, int year) {
		super(name, num);
		this.major = major;
		this.year = year;
	}
	
	// ��¸޼���
	public void showMemberInfo() {
		super.showMemberInfo();
		System.out.println("���� : "+major);
		System.out.println("�г� : "+year);
	}
	
	public String toString() {
		return super.toString() + "major : " + major + '\n' + "year : " + year + '\n';
	}
}

// ȸ�缱�ý� ȸ�� ������ �߰�
class MemberCompanyInfo extends MemberInfo {
	String company;
	
	public MemberCompanyInfo(String name, String num, String company) {
		super(name, num);
		this.company = company;
	}
	
	public void showMemberInfo() {
		super.showMemberInfo();
		System.out.println("ȸ�� : "+company);
	}
	
	public String toString() {
		return super.toString() + "company : " + company + '\n';
	} 
}

class MemberBookManager {
	// ���� ������ ���� MemberBook.dat ����
	private final File dataFile = new File("bin\\MemberBookVer08\\MemberBook.dat");
	// HashSet��ü ����
	HashSet<MemberInfo> infoStorage = new HashSet<MemberInfo>();
	
	// MemberBookManager�� static ��ü �ʱ�ȭ
	static MemberBookManager inst = null;
	// �������̽� ������ ���� createManagerInst �߰�
	public static MemberBookManager createManagerInst() {
		if(inst==null)
			inst = new MemberBookManager();
		
		return inst;
	}
	// �ν��Ͻ� ���� ��, ���� ����
	private MemberBookManager() {readFromFile();}
	
	// �Էºз�
	private MemberInfo readMemberInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		return new MemberInfo(name, phone);
	}
	
	private MemberInfo readUnivMemberInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("���� : ");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("�г� : ");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new MemberUnivInfo(name, phone, major, year);
	}
	
	private MemberInfo readCompanyMemberInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("ȸ�� : ");
		String company = MenuViewer.keyboard.nextLine();
		MenuViewer.keyboard.nextLine();
		return new MemberCompanyInfo(name, phone, company);
	}
	
	// ȸ�� �Է¸޼���
	public void inputData() throws MenuChoiceException {
		System.out.println("������ �Է��� �����մϴ�...");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("����>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MemberInfo info = null;
		
		// choice�� ����
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice) { // �������̽� ����
		case INPUT_SELECT.NORMAL :
			info = readMemberInfo();
			break;
		case INPUT_SELECT.UNIV :
			info = readUnivMemberInfo();
			break;
		case INPUT_SELECT.COMPANY :
			info = readCompanyMemberInfo();
			break;
		}
		
		// HashSetŬ������ info��ü �߰�, isAdded�� ���� �ߺ��˻�
		boolean isAdded = infoStorage.add(info);
		if(isAdded==true)
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
		else
			System.out.println("�̹� ����� �������Դϴ�. \n");
	}
	
	//ȸ�� ã�� �޼���
	public String searchData(String name) {
		/* swing���� ��ü
		System.out.println("������ �˻��� �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		*/
		// info��ü�� search������
		MemberInfo info = search(name);
		if(info==null) 
			return null;
		else {
			return info.toString();
		}
	}
	
	// ȸ������ �޼���
	public boolean deleteData(String name) {
		/*
		System.out.println("������ ������ �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		*/
		// iterator()�޼ҵ� ����
		Iterator<MemberInfo> itr = infoStorage.iterator();
		// ���� �� ���� ��Ұ� �����ϸ� true, true�� remove�޼ҵ带 ���� ����
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) {
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	// �̸��� ���ؼ� ã�� �޼���
	private MemberInfo search(String name) {
		// comapreTO�޼���� �̸��� ���ؼ� ��ȯ
		Iterator<MemberInfo> itr = infoStorage.iterator();
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) 
				return curInfo;
		}
		return null;
	}
	
	//����� ��������
	public void storeToFile() {
		try {
			dataFile.createNewFile();
			//���� ��Ʈ�� ��ü����
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			//������ ����
			Iterator<MemberInfo> itr = infoStorage.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//�����б�
	public void readFromFile() {
		if(dataFile.exists()==false)
			return;
		try {
			FileInputStream file = new FileInputStream(dataFile);
			ObjectInputStream in = new ObjectInputStream(file);
			
			while(true) {
				MemberInfo info = (MemberInfo)in.readObject();
				if(info==null)
					break;
				infoStorage.add(info);
			}
			in.close();
		}
		catch(IOException e) {
			return;
		}
		catch(ClassNotFoundException e) {
			return;
		}
	}
}

class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("4. ���α׷� ����...");
		System.out.print("���� : ");
	}
}

class SearchEventHandler implements ActionListener {
	JTextField searchField;
	JTextArea textArea;
	
	public SearchEventHandler(JTextField field, JTextArea area) {
		searchField = field;
		textArea = area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = searchField.getText();
		MemberBookManager manager = MemberBookManager.createManagerInst();
		String srchResult = manager.searchData(name);
		if(srchResult==null) 
			textArea.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�.\n");
		else {
			textArea.append("ã���ô� ������ �˷��帳�ϴ�.\n");
			textArea.append(srchResult);
			textArea.append("\n");
		}
	}
	
}

class DeleteEventHandler implements ActionListener {
	JTextField delField;
	JTextArea textArea;
	
	public DeleteEventHandler(JTextField field, JTextArea area) {
		delField = field;
		textArea = area;
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = delField.getText();
		MemberBookManager manager = MemberBookManager.createManagerInst();
		boolean isDeleted = manager.deleteData(name);
		if(isDeleted) 
			textArea.append("�ش��ϴ� ������ �Ϸ�...\n");
		else 
			textArea.append("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�...\n");
	}
}

class SearchDelFrame extends JFrame {
	JTextField srchField = new JTextField(15);
	JButton srchBtn = new JButton("SEARCH");
	
	JTextField delField = new JTextField(15);
	JButton delBtn = new JButton("DEL");
	
	JTextArea textArea = new JTextArea(20, 25);
	
	public SearchDelFrame() {
		super(title);
		setBounds(100, 200, 330, 450);
		setLayout(new BorderLayout());
		Border border = BorderFactory.createEtchedBorder();
		
		Border srchBorder = BorderFactory.createTitledBorder(border, "Search");
		JPanel srchPanel = new JPanel();
		srchPanel.setBorder(srchBorder);
		srchPanel.setLayout(new FlowLayout());
		srchPanel.add(srchField);
		srchPanel.add(srchBtn);
		
		Border delBorder = BorderFactory.createTitledBorder(border, "Delete");
		JPanel delPanel = new JPanel();
		delPanel.setBorder(delBorder);
		delPanel.setLayout(new FlowLayout());
		delPanel.add(delField);
		delPanel.add(delBtn);
		
		JScrollPane scrollTextArea = new JScrollPane(textArea);
		Border textBorder = BorderFactory.createTitledBorder(border, "Information Board");
		scrollTextArea.setBorder(textBorder);
		
		add(srchPanel, BorderLayout.NORTH);
		add(delPanel, BorderLayout.SOUTH);
		add(scrollTextArea, BorderLayout.CENTER);
		
		srchBtn.addActionListener(new SearchEventHandler(srchField, textArea));
		delBtn.addActionListener(new DeleteEventHandler(delField, textArea));
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
public class MemberBook09 {
	
	public static void main(String[] args) {
		// manager �ν��Ͻ�ȭ, ��ü���� �� ����
		MemberBookManager manager = MemberBookManager.createManagerInst();
		SearchDelFrame winFrame = new SearchDelFrame("MemberBook09");
		int choice;
		while(true) {
			try {
				MenuViewer.showMenu();
				choice=MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				
				// choice�� ����ó��
				if(choice<INIT_MENU.INPUT || choice>INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);
				
				// 1 - �Է�, 2 - ã��, 3 - ����, 4 - ����
				switch(choice)
				{
					case INIT_MENU.INPUT :
						manager.inputData();
						break;
					case INIT_MENU.EXIT :
						manager.storeToFile();
						System.out.println("���α׷��� �����մϴ�.");
						System.exit(0);
						return;
						
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("�޴� ������ ó������ �ٽ� �����մϴ�.\n");
			}
			catch(InputMismatchException e) {
				MenuViewer.keyboard = new Scanner(System.in);
				System.out.println("���ڸ� �Է����ֻ���!!!\n");
			}
		}
	}
}