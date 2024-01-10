package MemberBookVer04;
import java.util.Scanner;

// 상속기능의 추가
// 회원의 분류별로 데이터 입력

// 회원의 일반정보(기본) 초기화 및 출력
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

// 대학교선택 시 전공데이터 입력 추가
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
	
	// 출력메서드
	public void showMemberInfo()
	{
		super.showMemberInfo();
		System.out.println("major : "+major);
		System.out.println("year : "+year);
	}
}

// 회사선택시 회사 데이터 추가
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
	//MemberInfo형인 infoStorage 배열 생성(최대 MAX_CNT)
	MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	int curCnt=0; // 인원수 저장을 위한 변수
	
	// 입력분류
	private MemberInfo readMemberInfo()
	{
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		return new MemberInfo(name, phone);
	}
	
	private MemberInfo readUnivMemberInfo()
	{
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("전공 : ");
		String major=MenuViewer.keyboard.nextLine();
		System.out.print("학년 : ");
		int year=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		return new MemberUnivInfo(name, phone, major, year);
	}
	
	private MemberInfo readCompanyMemberInfo()
	{
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("회사 : ");
		String company=MenuViewer.keyboard.nextLine();
		MenuViewer.keyboard.nextLine();
		return new MemberCompanyInfo(name, phone, company);
	}
	
	// 회원 입력메서드
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
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
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	
	//회원 찾기 메서드
	public void searchData()
	{
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		// dataIdx값을 통한 배열에서의 찾기
		int dataIdx=search(name);
		// dataIdx 즉 search(name) 리턴값이 -1이면 데이터 없음
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 없습니다...\n");
		}
		else
		{
			infoStorage[dataIdx].showMemberInfo();
			System.out.println("데이터 검색이 완료되었습니다!!\n");
		}
	}
	
	// 회원삭제 메서드
	public void deleteData()
	{
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		int dataIdx=search(name);
		if(dataIdx<0)
		{
			System.out.println("해당하는 데이터가 없습니다...\n");
		}
		else
		{
			for(int idx=dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다!!!\n");
		}
	}
	
	// 이름을 통해서 찾는 메서드
	private int search(String name)
	{
		//배열의 처음부터끝까지
		for(int idx=0; idx<curCnt; idx++)
		{
			// curInfo객체에 회원정보 저장후 비교, idx값 리턴후 삭제, 찾기
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
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료...");
		System.out.print("선택 : ");
	}
}
public class MemberBook04 {
	
	public static void main(String[] args) {
		// manager 인스턴스화, 객체생성 후 접근
		MemberBookManager manager=new MemberBookManager();
		int choice;
		
		while(true)
			{
				MenuViewer.showMenu();
				choice=MenuViewer.keyboard.nextInt();
				MenuViewer.keyboard.nextLine();
				
				// 1 - 입력, 2 - 찾기, 3 - 삭제, 4 - 종료
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
						System.out.println("프로그램을 종료합니다.");
						return;
						
				}
			}
	}
}