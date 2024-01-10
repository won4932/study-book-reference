package MemberBookVer03;
import java.util.Scanner;

// 배열기능 추가로 인한 데이터 입력후 검색,삭제가 가능
// 회원의 정보 초기화 및 출력
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
	//MemberInfo형인 infoStorage 배열 생성(최대 MAX_CNT)
	MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	int curCnt=0; // 인원수 저장을 위한 변수
	
	// 회원 입력메서드
	public void inputData()
	{
		System.out.println("데이터 입력을 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String birth=MenuViewer.keyboard.nextLine();
		
		// 배열에 화원정보 저장
		infoStorage[curCnt++]=new MemberInfo(name, phone, birth);
		System.out.println("데이터 입력이 완료되었습니다.\n");
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
public class MemberBook03 {
	
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
					case 4:
						System.out.println("프로그램을 종료합니다.");
						return;
						
				}
			}
	}
}