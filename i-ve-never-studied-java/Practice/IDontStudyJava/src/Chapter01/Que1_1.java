package Chapter01;

class abcd {
	
}
class Que1_1{
	public void Que112(){
		System.out.println("2+5 = " + 2+5);
		System.out.println("2+5 = " + (2+5));
	}
	
	public void Que113() {
		System.out.println("12");
		System.out.println(12);
		System.out.println(""+1+2);
		System.out.println("1"+2);
		System.out.println(1+"2");
	}

	public static void main(String[] args) {
		Que1_1 c1 = new Que1_1();
		System.out.println("너 자신을 알라 - 소크라테스");
		c1.Que112();
		c1.Que113();
	}

}
