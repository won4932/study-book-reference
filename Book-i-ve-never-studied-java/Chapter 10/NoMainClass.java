class Employer     /* 고용주 */
{
	private int myMoney;
	
	public Employer(int money)
	{
		myMoney=money;
	}
	public void payForWork(Employee emp, int money)
	{
		if(myMoney<money)
			return;
		emp.earnMoney(money);
		myMoney-=money;
	}
	public void showMyMoney()
	{
		System.out.println(myMoney);
	}	
}

class Employee   /* 고용인 */
{
	private int myMoney;
	
	public Employee(int money)
	{
		myMoney=money;
	}
	public void earnMoney(int money)
	{
		myMoney+=money;
	}
	public void showMyMoney()
	{
		System.out.println(myMoney);
	}	
}
