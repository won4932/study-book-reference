package MemberBookVer01;
// �����ε�, StringŬ����
class MemberInfo
{
	String name;
	String phoneNumber;
	String birth;
	// ����� ����(�̸�, ��ȣ, ����) �ʱ�ȭ
	public MemberInfo(String name, String num, String birth)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=birth;
	}
	
	// �̸�, ��ȭ��ȣ �ΰ��� �Է½� �ʱ�ȭ
	public MemberInfo(String name, String num)
	{
		this.name=name;
		phoneNumber=num;
		this.birth=null;
	}
	
	// ������ ȭ���� ����ϴ� �޼���
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
		//�ν��Ͻ� ������ ���ÿ� �ʱ�ȭ
		MemberInfo mInfo1=new MemberInfo("������", "010-323-1111", "921012");
		MemberInfo mInfo2=new MemberInfo("��ȿ��", "321-2222");
		mInfo1.showMemberInfo();
		mInfo2.showMemberInfo();
		
	}

}