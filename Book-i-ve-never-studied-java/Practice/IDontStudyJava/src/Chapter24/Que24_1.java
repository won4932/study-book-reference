package Chapter24;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

class MyInfo {
	String info;
	public MyInfo(String info) { this.info = info; }
	public String toString() { return info; }
}

public class Que24_1 {
	public static void Que25_5() {
		String work = System.getProperty("user.dir");
		File fi = new File(work);
		System.out.println(work);
		File[] list = fi.listFiles();
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i].getName());
			if(list[i].isDirectory())
				System.out.println("\t \t Dir");
			else
				System.out.println("\t \t FILE");
		}
	}
	public static void main(String[] args) throws IOException {
		OutputStream out = new FileOutputStream("pritln.txt");
		PrintStream st = new PrintStream(out);
		MyInfo mInfo = new MyInfo("저는 자바 프로그래머입니다.");
		st.println("제 소개를 하겠습니다.");
		st.println(mInfo);
		st.printf("나이 %d, 몸무게 %dkg입니다.", 24, 72);
		st.close();
		Que25_5();
	}

}
