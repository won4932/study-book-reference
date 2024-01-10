package MemberBookVer06;
import java.util.Scanner;

// 예외처리 추가
// 코드정리

// 메뉴 인터페이스로 정의
interface INIT_MENU
{
	int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}

interface INPUT_SELECT
{
	int NORMAL=1, UNIV=2, COMPANY=3;
}

// 메뉴선택 오류 시 예외처리
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
class MemberInfo {
	String name;
	String phoneNumber;
	String birth;
	
	public MemberInfo(String name, String num, String birth) {
		this.name = name;
		phoneNumber = num;
	}
	
	public MemberInfo(String name, String num) {
		this.name = name;
		phoneNumber = num;
	}
	
	public void showMemberInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
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
}

class MemberBookManager {
	final int MAX_CNT=100;
	//MemberInfo형인 infoStorage 배열 생성(최대 MAX_CNT)
	MemberInfo[] infoStorage=new MemberInfo[MAX_CNT];
	int curCnt=0; // 인원수 저장을 위한 변수
	
	// MemberBookManager형 static 객체 초기화
	static MemberBookManager inst = null;
	// 인터페이스 구현을 위한 createManagerInst 추가
	public static MemberBookManager createManagerInst() {
		if(inst==null)
			inst=new MemberBookManager();
		
		return inst;
	}
	// 인스턴스 생성 즉, 접근 제어
	private MemberBookManager() {}
	
	// 입력분류
	private MemberInfo readMemberInfo() {
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String phone=MenuViewer.keyboard.nextLine();
		return new MemberInfo(name, phone);
	}
	
	private MemberInfo readUnivMemberInfo() {
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
	
	private MemberInfo readCompanyMemberInfo() {
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
	public void inputData() throws MenuChoiceException {
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1. 일반, 2. 대학, 3. 회사");
		System.out.print("선택>> ");
		int choice=MenuViewer.keyboard.nextInt();
		MenuViewer.keyboard.nextLine();
		MemberInfo info=null;
		
		// choice값 제한
		if(choice<INPUT_SELECT.NORMAL || choice>INPUT_SELECT.COMPANY)
			throw new MenuChoiceException(choice);
		
		switch(choice) { // 인터페이스 구현
		case INPUT_SELECT.NORMAL :
			info=readMemberInfo();
			break;
		case INPUT_SELECT.UNIV :
			info=readUnivMemberInfo();
			break;
		case INPUT_SELECT.COMPANY :
			info=readCompanyMemberInfo();
			break;
		}
		
		infoStorage[curCnt++]=info;
		System.out.println("데이터 입력이 완료되었습니다. \n");
	}
	
	//회원 찾기 메서드
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		// dataIdx값을 통한 배열에서의 찾기
		int dataIdx=search(name);
		// dataIdx 즉 search(name) 리턴값이 -1이면 데이터 없음
		if(dataIdx<0)
			System.out.println("해당하는 데이터가 없습니다...\n");
		else {
			infoStorage[dataIdx].showMemberInfo();
			System.out.println("데이터 검색이 완료되었습니다!!\n");
		}
	}
	
	// 회원삭제 메서드
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다...");
		
		System.out.print("이름 : ");
		String name=MenuViewer.keyboard.nextLine();
		
		int dataIdx=search(name);
		if(dataIdx<0)
			System.out.println("해당하는 데이터가 없습니다...\n");
		else {
			for(int idx=dataIdx; idx<(curCnt-1); idx++)
				infoStorage[idx]=infoStorage[idx+1];
			
			curCnt--;
			System.out.println("데이터 삭제가 완료되었습니다!!!\n");
		}
	}
	
	// 이름을 통해서 찾는 메서드
	private int search(String name) {
		//배열의 처음부터끝까지
		for(int idx=0; idx<curCnt; idx++) {
			// curInfo객체에 회원정보 저장후 비교, idx값 리턴후 삭제, 찾기
			MemberInfo curInfo=infoStorage[idx];
			if(name.compareTo(curInfo.name)==0)
				return idx;
		}
		return -1;
	}
}

class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 프로그램 종료...");
		System.out.print("선택 : ");
	}
}
public class MemberBook06 {
	
	public static void main(String[] args) {
		// manager 인스턴스화, 객체생성 후 접근
		MemberBookManager manager = MemberBookManager.createManagerInst();
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
					case INIT_MENU.SEARCH :
						manager.searchData();
						break;
					case INIT_MENU.DELETE :
						manager.deleteData();
						break;
					case INIT_MENU.EXIT :
						System.out.println("프로그램을 종료합니다.");
						return;
						
				}
			}
			catch(MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("메뉴 선택을 처음부터 다시 진행합니다.\n");
			}
		}
	}
}