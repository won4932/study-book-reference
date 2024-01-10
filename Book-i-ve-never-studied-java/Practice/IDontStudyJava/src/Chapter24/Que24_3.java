package Chapter24;

import java.io.*;
public class Que24_3 {

	public static void main(String[] args) throws IOException {
		String str="";
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("printf.txt")));
		BufferedReader in = new BufferedReader(new FileReader("printf.txt"));
		out.printf("제 나이는 %d살 입니다.", 24);
		out.println("");
		
		out.println("저는 자바가 좋습니다.");
		out.print("특히 I/O 부분에서 많은 매력을 느낍니다.");
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
