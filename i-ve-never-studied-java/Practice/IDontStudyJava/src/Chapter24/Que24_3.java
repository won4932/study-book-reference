package Chapter24;

import java.io.*;
public class Que24_3 {

	public static void main(String[] args) throws IOException {
		String str="";
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("printf.txt")));
		BufferedReader in = new BufferedReader(new FileReader("printf.txt"));
		out.printf("�� ���̴� %d�� �Դϴ�.", 24);
		out.println("");
		
		out.println("���� �ڹٰ� �����ϴ�.");
		out.print("Ư�� I/O �κп��� ���� �ŷ��� �����ϴ�.");
		out.close();
		while(true) {
			str=in.readLine();
			if(str==null)
				break;
			
			System.out.println(str);
		}
		in.close();
	}

}
