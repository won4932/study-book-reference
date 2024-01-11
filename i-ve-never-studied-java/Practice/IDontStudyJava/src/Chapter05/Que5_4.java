package Chapter05;

public class Que5_4 {

	public static void main(String[] args) {
		int x=0, result=0;
		while(x<99) {
			x++;
		result+=x;
		}
		System.out.println(result);
		
	int y=1;
	while(y<=100) {
		if(y==50)
			System.out.println();
		System.out.print(y++ + " ");
	}
	System.out.println();
	do {
		System.out.print(y+ " ");
		y--;
		if(y==50)
			System.out.println();
	}while(y>0);
	System.out.println();
	
	int z=0; int result2=0;
	while(z<1000) {
		z++;
		if(z%2==0 && z%7==0) {
			System.out.print(z+" "); result2+=z;
		}
		
	}
	}
}
