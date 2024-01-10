package MemberBookVer04;
import java.util.Scanner;

// ��ӱ���� �߰�
// ȸ���� �з����� ������ �Է�

// ȸ���� �Ϲ�����(�⺻) �ʱ�ȭ �� ���
class MemberInfo
{
	String name;
	String phoneNumber;
	String birth;
	
	public MemberInfo(String name, String num, String birth)
	{
		this.name=name;
		phoneNumber=num;
	}
	
	public MemberInfo(String name, String num)
	{
		this.name=name;
		phoneNumber=num;
	}
	
	public void showMemberInfo()
	{
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
	}
}

// ���б����� �� ���������� �Է� �߰�
class MemberUnivInfo extends MemberInfo
{
	String major;
	int year;
	
	public MemberUnivInfo(String name, String num, String major, int year)
	{
		super(name, num);
		this.major=major;
		this.year=year;
	}
	
	// ��¸޼���
	public void showMemberInfo()
	{
		super.showMemberInfo();
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}

// ȸ�缱�ý� ȸ�� ������ �߰�
class MemberCompanyInfo extends MemberInfo
{
	String company;
	
	public MemberCompanyInfo(String name, String num, String company)
	{
		super(name, num);
		this.company=company;
	}
	
	public void showMemberInfo()
	{
		super.showMemberInfo();
		System.out.println("company : "+company);
	}
}

class MemberBookManager
{
	final int MAX_CNT=100;
	//MemberInfo���� infoStorage �迭 ����(�ִ� MAX_CNT)
	MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	int curCnt=0; // �ο��� ������ ���� ����
	
	// �Էºз�
	private MemberInfo readMemberInfo()
	{
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone=MenuViewer.keyboard.nextLine();
		return new MemberInfo(name, phone);
	}
	
	private MemberInfo readUnivMemberInfo()
	{
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("���� : ");
		String major=MenuViewer.keyboard.nextLine();
		System.out.print("�г� : ");
		int year=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new MemberUnivInfo(name, phone, major, year);
	}
	
	private MemberInfo readCompanyMemberInfo()
	{
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("ȸ�� : ");
		String company=MenuViewer.keyboard.nextLine();
		MenuViewer.keyboard.nextLine();
		return new MemberCompanyInfo(name, phone, company);
	}
	
	// ȸ�� �Է¸޼���
	public void inputData()
	{
		System.out.println("������ �Է��� �����մϴ�...");
		System.out.println("1. �Ϲ�, 2. ����, 3. ȸ��");
		System.out.print("����>> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MemberInfo info=null;
		
		switch(choice)
		{
		case 1 :
			info=readMemberInfo();
			break;
		case 2 :
			info=readUnivMemberInfo();
			break;
		case 3 :
			info=readCompanyMemberInfo();
			break;
		}
		
		infoStorage[curCnt++]=info;
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�. \n");
	}
	
	//ȸ�� ã�� �޼���
	public void searchData()
	{
		System.out.println("������ �˻��� �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		
		// dataIdx���� ���� �迭������ ã��
		int dataIdx=search(name);
		// dataIdx �� search(name) ���ϰ��� -1�̸� ������ ����
		if(dataIdx<0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�...\n");
		}
		else
		{
			infoStorage[dataIdx].showMemberInfo();
			System.out.println("������ �˻��� �Ϸ�Ǿ����ϴ�!!\n");
		}
	}
	
	// ȸ������ �޼���
	public void deleteData()
	{
		System.out.println("������ ������ �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		
		int dataIdx=search(name);
		if(dataIdx<0)
		{
			System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�...\n");
		}
		else
		{
			for(int idx=dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("������ ������ �Ϸ�Ǿ����ϴ�!!!\n");
		}
	}
	
	// �̸��� ���ؼ� ã�� �޼���
	private int search(String name)
	{
		//�迭�� ó�����ͳ�����
		for(int idx=0; idx<curCnt; idx++)
		{
			// curInfo��ü�� ȸ������ ������ ��, idx�� ������ ����, ã��
			MemberInfo curInfo=infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		return -1;
	}
}

class MenuViewer
{
	public static Scanner keyboard=new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ������ �˻�");
		System.out.println("3. ������ ����");
		System.out.println("4. ���α׷� ����...");
		System.out.print("���� : ");
	}
}
public class MemberBook04 {
	
	public static void main(String[] args) {
		// manager �ν��Ͻ�ȭ, ��ü���� �� ����
		MemberBookManager manager=new MemberBookManager();
		int choice;
		
		while(true)
			{
				MenuViewer.showMenu();
				choice=MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				
				// 1 - �Է�, 2 - ã��, 3 - ����, 4 - ����
				switch(choice)
				{
					case 1:
						manager.inputData();
						break;
					case 2:
						manager.searchData();
						break;
					case 3:
						manager.deleteData();
						break;
					case 4:
						System.out.println("���α׷��� �����մϴ�.");
						return;
						
				}
			}
	}
}