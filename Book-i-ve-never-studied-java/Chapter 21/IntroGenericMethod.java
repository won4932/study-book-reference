class AAA
{
	public String toString()
	{
		return "Class AAA";
	}
}

class BBB
{
	public String toString()
	{
		return "Class BBB";
	}
}

class InstanceTypeShower
{
	int showCnt=0;
	
	public <T> void showInstType(T inst)
	{
		System.out.println(inst);
		showCnt++;
	}
	
	void showPrintCnt()
	{
		System.out.println("Show count: "+showCnt);
	}
}

class IntroGenericMethod
{	
	public static void main(String[] args)
	{
		AAA aaa=new AAA();
		BBB bbb=new BBB();
		
		InstanceTypeShower shower=new InstanceTypeShower();
		shower.<AAA>showInstType(aaa);
		shower.<BBB>showInstType(bbb);
		shower.showPrintCnt();
	}
}