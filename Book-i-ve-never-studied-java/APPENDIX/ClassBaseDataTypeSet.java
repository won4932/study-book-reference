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
			System.out.println("�����̱���!");
		else if(man==Person.WOMAN)
			System.out.println("�����̳׿�!");
		else
			System.out.println("�ȳ� �ư���!");
		
		/*
		if(man==Animal.DOG)
			System.out.println("����� �۸��̳�!");
		*/
	}
}