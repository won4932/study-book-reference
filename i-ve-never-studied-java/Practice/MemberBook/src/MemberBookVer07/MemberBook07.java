package MemberBookVer07;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

// �÷��� �����ӿ�ũ ����
// �ڵ�����

// �޴� �������̽��� ����
interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}

interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

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
class MemberInfo {
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
}

class MemberBookManager {
	// final int MAX_CNT=100;
	//MemberInfo���� infoStorage �迭 ����(�ִ� MAX_CNT)
	// MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	// int curCnt=0; // �ο��� ������ ���� ����
	
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
	private MemberBookManager() {}
	
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
		
		// infoStorage[curCnt++]=info;
		// HashSetŬ������ info��ü �߰�, isAdded�� ���� �ߺ��˻�
		boolean isAdded = infoStorage.add(info);
		if(isAdded==true)
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
		else
			System.out.println("�̹� ����� �������Դϴ�. \n");
	}
	
	//ȸ�� ã�� �޼���
	public void searchData() {
		System.out.println("������ �˻��� �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		
		/*
		// dataIdx���� ���� �迭������ ã��
		int dataIdx=search(name);
		// dataIdx �� search(name) ���ϰ��� -1�̸� ������ ����
		if(dataIdx<0)
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�...\n");
		else {
			infoStorage[dataIdx].showMemberInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�!!\n");
		}
		*/
		// info��ü�� search������
		MemberInfo info = search(name);
		if(info==null) 
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�...\n");
		else {
			info.showMemberInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�!!\n");
		}
	}
	
	// ȸ������ �޼���
	public void deleteData() {
		System.out.println("������ ������ �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name = MenuViewer.keyboard.nextLine();
		
		/*
		int dataIdx=search(name);
		if(dataIdx<0)
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�...\n");
		else {
			for(int idx=dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!!!\n");
		}
		*/
		// iterator()�޼ҵ� ����
		Iterator<MemberInfo> itr = infoStorage.iterator();
		// ���� �� ���� ��Ұ� �����ϸ� true, true�� remove�޼ҵ带 ���� ����
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) {
				itr.remove();
				System.out.println("������ ������ �Ϸ�Ǿ����ϴ�. \n");
				return;
			}
		}
		System.out.println("�ش��ϴ� �����Ͱ� �������� �ʽ��ϴ�....\n");
	}
	
	// �̸��� ���ؼ� ã�� �޼���
	private MemberInfo search(String name) {
		/*
		//�迭�� ó�����ͳ�����
		for(int idx=0; idx<curCnt; idx++) {
			// curInfo��ü�� ȸ������ ������ ��, idx�� ������ ����, ã��
			MemberInfo curInfo=infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		*/
		// comapreTO�޼���� �̸��� ���ؼ� ��ȯ
		Iterator<MemberInfo> itr = infoStorage.iterator();
		while(itr.hasNext()) {
			MemberInfo curInfo = itr.next();
			if(name.compareTo(curInfo.name)==0) 
				return curInfo;
		}
		return null;
	}
}

class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����...");
		System.out.print("���� : ");
	}
}
public class MemberBook07 {
	
	public static void main(String[] args) {
		// manager �ν��Ͻ�ȭ, ��ü���� �� ����
		MemberBookManager manager = MemberBookManager.createManagerInst();
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
					case INIT_MENU.SEARCH :
						manager.searchData();
						break;
					case INIT_MENU.DELETE :
						manager.deleteData();
						break;
					case INIT_MENU.EXIT :
						System.out.println("���α׷��� �����մϴ�.");
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