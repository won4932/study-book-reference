import java.math.*;

class WowDoubleError
{
	public static void main(String[] args)
	{
		BigDecimal e1=new BigDecimal(1.6);
		BigDecimal e2=new BigDecimal(0.1);
		
		System.out.println("µÎ ½Ç¼öÀÇ µ¡¼À°á°ú: "+ e1.add(e2));
		System.out.println("µÎ ½Ç¼öÀÇ °ö¼À°á°ú: "+ e1.multiply(e2));
	}
}