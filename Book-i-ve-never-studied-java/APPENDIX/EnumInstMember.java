enum City
{
	SEOUL(200), BUSAN(100), JEJU(50);
	
	City(int popu) 
	{
		population=popu;
	}
	
	int population; 	// �α�
	public int getPopulation()
	{
		return population;
	}
}

class EnumInstMember
{	
	public static void main(String[] args)
	{
		System.out.println("������ �α�: "+City.SEOUL.getPopulation());
		System.out.println("�λ��� �α�: "+City.BUSAN.getPopulation());
		System.out.println("������ �α�: "+City.JEJU.getPopulation());
	}
}