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
			System.out.println("고양이 이놈!");
		else
			System.out.println("아! 고양이인줄 알았습니다.");
	}
	
	public static void whoAreYou(int man)
	{
		switch(man)
		{
		case Person.MAN:
			System.out.println("남자 손님입니다.");
			break;
		case Person.WOMAN:
			System.out.println("여성 손님입니다.");
			break;
		case Person.BABY:
			System.out.println("아기 손님입니다.");
			break;
		}		
	}
}