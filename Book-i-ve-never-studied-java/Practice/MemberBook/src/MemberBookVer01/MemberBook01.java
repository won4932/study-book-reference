package MemberBookVer01;
// 오버로딩, String클래스
class MemberInfo
{
	String name;
	String phoneNumber;
	String birth;
	// 멤버의 정보(이름, 번호, 생일) 초기화
	public MemberInfo(String name, String num, String birth)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=birth;
	}
	
	// 이름, 전화번호 두개만 입력시 초기화
	public MemberInfo(String name, String num)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=null;
	}
	
	// 정보를 화면의 출력하는 메서드
	public void showMemberInfo()
	{
		System.out.println("name : "+name);
		System.out.println("phone : "+phoneNumber);
		if(birth!=null)
			System.out.println("birth : "+birth);
		
		System.out.println("");
	}
}

public class MemberBook01 {

	public static void main(String[] args) 
	{
		//인스턴스 생성과 동시에 초기화
		MemberInfo mInfo1=new MemberInfo("이정훈", "010-323-1111", "921012");
		MemberInfo mInfo2=new MemberInfo("김효준", "321-2222");
		mInfo1.showMemberInfo();
		mInfo2.showMemberInfo();
		
	}

}