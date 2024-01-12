enum City
{
	SEOUL(200), BUSAN(100), JEJU(50);
	
	City(int popu) 
	{
		population=popu;
	}
	
	int population; 	// 인구
	public int getPopulation()
	{
		return population;
	}
}

class EnumInstMember
{	
	public static void main(String[] args)
	{
		System.out.println("서울의 인구: "+City.SEOUL.getPopulation());
		System.out.println("부산의 인구: "+City.BUSAN.getPopulation());
		System.out.println("제주의 인구: "+City.JEJU.getPopulation());
	}
}