package Chapter11;

public class Que11_1 {

	public static void main(String[] args) {
		String str = "ABCDEFGHIJKLMNOP";
		String str2 = "990208-1012752";
		StringBuilder sb = new StringBuilder(str);
		StringBuilder sb2 = new StringBuilder(str2);
		str = sb.reverse().toString();
		for (int i = 0; i < sb2.length(); i++) {
			if(sb2.charAt(i)=='-') {
				str2 = sb2.deleteCharAt(6).toString();
			break;
			}
		}
		// Object obj = sb.reverse();
		//System.out.println(obj);
		System.out.println(str);
		System.out.println(str2);
	}

}
