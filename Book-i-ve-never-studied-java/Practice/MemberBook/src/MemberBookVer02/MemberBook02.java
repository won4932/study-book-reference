package MemberBookVer02;
import java.util.Scanner;

// �ܼ��Է� Scanner���(�Է±���߰�)
/* �ܼ��Է±���� ����
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
*/
public class MemberBook02 {
	
	// �Է��� �޴� Scanner����� �ϴ� Keyboard ��ü����
	static Scanner Keyboard=new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ���α׷� ����");
		System.out.print("���� : ");
	}
	
	//������ �Է�
	public static void readDate() 
	{
		System.out.print("�̸� : ");
		String name=Keyboard.nextLine();
		System.out.print("��ȭ��ȣ : ");
		String phone=Keyboard.nextLine();
		System.out.print("������� : ");
		String birth=Keyboard.nextLine();
	}
	
	public static void main(String[] args) {
		int choice;
		while(true)
			{
				showMenu();
				// Ű����κ��� �������� �Է¹޾� choice�� ����
				choice=Keyboard.nextInt();
				// ����+enterŰ �Է��� �޾ƾߵǱ⶧���� nextLine()����
				Keyboard.nextLine();
				
				// 1�Է½�  �������Է�, 2�Է½� ���α׷� ����
				switch(choice)
				{
					case 1:
						readDate();
						break;
					case 2:
						System.out.println("���α׷��� �����մϴ�.");
						return;
				}
			}
	}
}