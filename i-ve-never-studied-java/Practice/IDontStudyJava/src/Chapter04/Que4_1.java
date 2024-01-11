package Chapter04;

public class Que4_1 {
	public void Que414(){
		int result=0;
		result = 3+6;
		System.out.println(result);
		System.out.println(result+9);
		System.out.println(result+9+12);
	}
	
	public void Que415() {
		int A = ((25+5) + (36/4)-72)*5;
		int B = ((25*5) + (36-4)+71)/4;
		int C = (128/4)*2;
		if(A>B && B>C)
			System.out.println("true");
		else
			System.out.println("false");
	}
	public static void main(String[] args) {
		Que4_1 q4 = new Que4_1();
		System.out.println(((25*5)+(36-4)-72)/5);
		q4.Que414();
		q4.Que415();
	}
}
