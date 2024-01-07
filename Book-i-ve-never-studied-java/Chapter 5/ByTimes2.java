class ByTimes2
{
	public static void main(String[] args)
	{
		int i=2, j;
		while(i<10)
		{
			j=1;
			while(j<10)
			{
				System.out.println(i + " x " + j + " = " + i*j);
				j++;
			}
			i++;
		}
	}
}