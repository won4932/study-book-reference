import java.util.Random;

class SeedChangeRandom
{	
	public static void main(String[] args)
	{
		Random rand=new Random(12);
		rand.setSeed(System.currentTimeMillis());
		
		for(int i=0; i<100; i++)
			System.out.println(rand.nextInt(1000));
	}
}