package Chapter10;

class SimpleNumber {
	static int num=0;
	private SimpleNumber() {}
	public void addNum(int n) { num+=n;}
	public void showNum( ) {System.out.println(num);}
	
	public static SimpleNumber getSimpleNumberInst() {
		return new SimpleNumber();
	}
}
public class Que10_1 {

	public static void main(String[] args) {
		SimpleNumber num1 = SimpleNumber.getSimpleNumberInst();
		num1.addNum(20);
		SimpleNumber num2 = SimpleNumber.getSimpleNumberInst();
		num2.addNum(30);
		
		num1.showNum();
		num2.showNum();

	}

}
