interface Animal
{
	int DOG=1, CAT=2, BEAR=3;
}

interface Person
{
	int MAN=1, WOMAN=2, BABY=4;
}

class NonSafeInterfaceConst
{	
	public static void main(String[] args)
	{
		whoAreYou(Person.MAN);
		whoAreYou(Animal.DOG);
		
		int myFriend=Person.WOMAN;
		if(myFriend==Animal.CAT)
			System.out.println("����� �̳�!");
		else
			System.out.println("��! ��������� �˾ҽ��ϴ�.");
	}
	
	public static void whoAreYou(int man)
	{
		switch(man)
		{
		case Person.MAN:
			System.out.println("���� �մ��Դϴ�.");
			break;
		case Person.WOMAN:
			System.out.println("���� �մ��Դϴ�.");
			break;
		case Person.BABY:
			System.out.println("�Ʊ� �մ��Դϴ�.");
			break;
		}		
	}
}