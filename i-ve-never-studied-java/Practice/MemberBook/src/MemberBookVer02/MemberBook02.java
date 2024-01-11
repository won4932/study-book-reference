package MemberBookVer02;
import java.util.Scanner;

// 콘솔입력 Scanner기능(입력기능추가)
/* 콘솔입력기능의 중점
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
	
	// 입력을 받는 Scanner기능을 하는 Keyboard 객체생성
	static Scanner Keyboard=new Scanner(System.in);
	
	public static void showMenu()
	{
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택 : ");
	}
	
	//데이터 입력
	public static void readDate() 
	{
		System.out.print("이름 : ");
		String name=Keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=Keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth=Keyboard.nextLine();
	}
	
	public static void main(String[] args) {
		int choice;
		while(true)
			{
				showMenu();
				// 키보드로부터 정수형을 입력받아 choice에 저장
				choice=Keyboard.nextInt();
				// 정수+enter키 입력을 받아야되기때문에 nextLine()삽입
				Keyboard.nextLine();
				
				// 1입력시  데이터입력, 2입력시 프로그램 종료
				switch(choice)
				{
					case 1:
						readDate();
						break;
					case 2:
						System.out.println("프로그램을 종료합니다.");
						return;
				}
			}
	}
}