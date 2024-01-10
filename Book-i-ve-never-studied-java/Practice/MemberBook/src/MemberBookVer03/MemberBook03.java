package MemberBookVer03;
import java.util.Scanner;

// �迭��� �߰��� ���� ������ �Է��� �˻�,������ ����
// ȸ���� ���� �ʱ�ȭ �� ���
class MemberInfo
{
	String name;
	String phoneNumber;
	String birth;
	
	public MemberInfo(String name, String num, String birth)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=birth;
	}
	
	public MemberInfo(String name, String num)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=null;
	}
	
	public void showMemberInfo()
	{
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
		if(birth!=null)
			System.out.println("birth : "+birth);
		
		System.out.println("");
	}
}


class MemberBookManager
{
	final int MAX_CNT=100;
	//MemberInfo���� infoStorage �迭 ����(�ִ� MAX_CNT)
	MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	int curCnt=0; // �ο��� ������ ���� ����
	
	// ȸ�� �Է¸޼���
	public void inputData()
	{
		System.out.println("������ �Է��� �����մϴ�...");
		
		System.out.print("�̸� : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("������� : ");
		String birth=MenuViewer.keyboard.nextLine();
		
		// �迭�� ȭ������ ����
		infoStorage[curCnt++]=new MemberInfo(name, phone, birth);
		System.out.println("������ �Է��� �Ϸ�Ǿ����ϴ�.\n");
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
public class MemberBook03 {
	
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
					case 4:
						System.out.println("���α׷��� �����մϴ�.");
						return;
						
				}
			}
	}
}