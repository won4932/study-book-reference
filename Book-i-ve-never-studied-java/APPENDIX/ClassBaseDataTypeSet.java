class Animal
{
	private Animal(){}
	public static final Animal DOG=new Animal();
	public static final Animal CAT=new Animal();
	public static final Animal BEAR=new Animal();
}

class Person
{
	private Person(){}
	public static final Person MAN=new Person();
	public static final Person WOMAN=new Person();
	public static final Person BABY=new Person();
}

class ClassBaseDataTypeSet
{	
	public static void main(String[] args)
	{
		Person man=Person.WOMAN;
		
		if(man==Person.MAN)
			System.out.println("남성이군요!");
		else if(man==Person.WOMAN)
			System.out.println("여성이네요!");
		else
			System.out.println("안녕 아가야!");
		
		/*
		if(man==Animal.DOG)
			System.out.println("사람이 멍멍이냐!");
		*/
	}
}