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

// GUI를 위한 Swing컴포넌트 적용
// 코드정리

// 메뉴 인터페이스로 정의
interface INIT_MENU{ int INPUT=1, EXIT=4;}

interface INPUT_SELECT{ int NORMAL=1, UNIV=2, COMPANY=3;}

// 메뉴선택 오류 시 사용자정의 예외처리
class MenuChoiceException extends Exception {
	int wrongChoice;
	
	public MenuChoiceException(int choice) {
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = choice;
	}
	public void showWrongChoice() {
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}
}

// 회원의 일반정보(기본) 초기화 및 출력
class MemberInfo implements Serializable{
	String name;
	String phoneNumber;
	
	public MemberInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
	}
	
	public void showMemberInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
	
	public String toString() {
		return "name : " + name + '\n' + "phone : " + phoneNumber+'\n';
	}
	// hashCode() 오버라이딩
	public int hashCode() {
		return name.hashCode();
	}
	
	// Object클래스를 이용한 비교
	public boolean equals(Object obj) {
		MemberInfo cmp = (MemberInfo)obj;
		if(name.compareTo(cmp.name)==0)
			return true;
		else
			return false;
	}
}

// 대학교선택 시 전공데이터 입력 추가
class MemberUnivInfo extends MemberInfo {
	String major;
	int year;
	
	public MemberUnivInfo(String name, String num, String major, int year) {
		super(name, num);
		this.major = major;
		this.year = year;
	}
	
	// 출력메서드
	public void showMemberInfo() {
		super.showMemberInfo();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+year);
	}
	
	public String toString() {
		return super.toString() + "major : " + major + '\n' + "year : " + year + '\n';
	}
}

// 회사선택시 회사 데이터 추가
class MemberCompanyInfo extends MemberInfo {
	String company;
	
	public MemberCompanyInfo(String name, String num, String company) {
		super(name, num);
		this.company = company;
	}
	
	public void showMemberInfo() {
		super.showMemberInfo();
		System.out.println("회사 : "+company);
	}
	
	public String toString() {
		return super.toString() + "company : " + company + '\n';
	} 
}

class MemberBookManager {
	// 파일 저장을 위한 MemberBook.dat 생성
	private final File dataFile = new File("bin\\MemberBookVer08\\MemberBook.dat");
	// HashSet객체 생성
	HashSet<MemberInfo> infoStorage = new HashSet<MemberInfo>();
	
	// MemberBookManager형 static 객체 초기화
	static MemberBookManager inst = null;
	// 인터페이스 구현을 위한 createManagerInst 추가
	public static MemberBookManager createManagerInst() {
		if(inst==null)
			inst = new MemberBookManager();
		
		return inst;
	}
	// 인스턴스 생성 즉, 접근 제어
	private MemberBookManager() {readFromFile();}
	
	// 입력분류
	private MemberInfo readMemberInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		return new MemberInfo(name, phone);
	}
	
	private MemberInfo readUnivMemberInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer.keyboard.nextLine();
		System.out.print("학년 : ");
		int year = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new MemberUnivInfo(name, phone, major, year);
	}
	
	private MemberInfo readCompanyMemberInfo() {
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.keyboard.nextLine();
		System.out.print("회사 : ");
		String company = MenuViewer.keyboard.nextLine();
		MenuViewer.keyboard.nextLine();
		return new MemberCompanyInfo(name, phone, company);
	}
	
	// 회원 입력메서드
	public void inputData() throws MenuChoiceException {
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		int choice = MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MemberInfo info = null;
		
		// choice값 제한
		if(choice < INPUT_SELECT.NORMAL || choice > INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice) { // 인터페이스 구현
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
		
		// HashSet클래스의 info객체 추가, isAdded를 통한 중복검사
		boolean isAdded = infoStorage.add(info);
		if(isAdded==true)
		System.out.println("데이터 입력이 완료되었습니다. \n");
		else
			System.out.println("이미 저장된 데이터입니다. \n");
	}
	
	//회원 찾기 메서드
	public String searchData(String name) {
		/* swing으로 대체
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		*/
		// info객체로 search재정의
		MemberInfo info = search(name);
		if(info==null) 
			return null;
		else {
			return info.toString();
		}
	}
	
	// 회원삭제 메서드
	public boolean deleteData(String name) {
		/*
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name = MenuViewer.keyboard.nextLine();
		*/
		// iterator()메소드 정의
		Iterator<MemberInfo> itr = infoStorage.iterator();
		// 참조 할 다음 요소가 존재하면 true, true면 remove메소드를 통해 삭제
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) {
				itr.remove();
				return true;
			}
		}
		return false;
	}
	
	// 이름을 통해서 찾는 메서드
	private MemberInfo search(String name) {
		// comapreTO메서드로 이름을 비교해서 반환
		Iterator<MemberInfo> itr = infoStorage.iterator();
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) 
				return curInfo;
		}
		return null;
	}
	
	//종료시 파일저장
	public void storeToFile() {
		try {
			dataFile.createNewFile();
			//파일 스트림 객체생성
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
			//데이터 쓰기
			Iterator<MemberInfo> itr = infoStorage.iterator();
			while(itr.hasNext())
				out.writeObject(itr.next());
			out.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//파일읽기
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("4. 프로그램 종료...");
		System.out.print("선택 : ");
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
			textArea.append("해당하는 데이터가 존재하지 않습니다.\n");
		else {
			textArea.append("찾으시는 정보를 알려드립니다.\n");
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
			textArea.append("해당하는 삭제가 완료...\n");
		else 
			textArea.append("해당하는 데이터가 존재하지 않습니다...\n");
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
		// manager 인스턴스화, 객체생성 후 접근
		MemberBookManager manager = MemberBookManager.createManagerInst();
		SearchDelFrame winFrame = new SearchDelFrame("MemberBook09");
		int choice;
		while(true) {
			try {
				MenuViewer.showMenu();
				choice=MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				
				// choice값 예외처리
				if(choice<INIT_MENU.INPUT || choice>INIT_MENU.EXIT)
					throw new MenuChoiceException(choice);
				
				// 1 - 입력, 2 - 찾기, 3 - 삭제, 4 - 종료
				switch(choice)
				{
					case INIT_MENU.INPUT :
						manager.inputData();
						break;
					case INIT_MENU.EXIT :
						manager.storeToFile();
						System.out.println("프로그램을 종료합니다.");
						System.exit(0);
						return;
						
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
			catch(InputMismatchException e) {
				MenuViewer.keyboard = new Scanner(System.in);
				System.out.println("숫자를 입력해주새요!!!\n");
			}
		}
	}
}