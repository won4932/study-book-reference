import java.util.Scanner;

enum City
{
	SEOUL(200), BUSAN(100), JEJU(50);
	
	City(int popu) 
	{
		population=popu;
	}
	
	int population;
	public int getPopulation()
	{
		return population;
	}
}

class EnumValueOf
{
	public static void main(String[] args)
	{		
		System.out.print("SEOUL, BUSAN, JEJU >> ");
		Scanner keyboard=new Scanner(System.in);
		
		String where=keyboard.nextLine();
		where=where.toUpperCase();
		
		City dest=City.valueOf(City.class, where);
		
		switch(dest)
		{
		case SEOUL:
			System.out.println("���÷��� ������ �α�: "+dest.getPopulation());
			break;
		case BUSAN:
			System.out.println("���÷��� �λ��� �α�: "+dest.getPopulation());
			break;
		case JEJU:
			System.out.println("���÷��� ������ �α�: "+dest.getPopulation());
			break;
		}
	}
}