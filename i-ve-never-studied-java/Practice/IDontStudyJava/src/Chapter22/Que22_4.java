package Chapter22;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class StrLenComparator implements Comparator<String> {
	public int compare(String str1, String str2) {
		if(str1.length() > str2.length())
			return 1;
		else if(str1.length() < str2.length())
			return -1;
		else 
			return 0;
	}
}

public class Que22_4 {

	public static void main(String[] args) {
		TreeSet<String> tSet = new TreeSet<String>(new StrLenComparator());//.reversed()
		tSet.add("Orange");
		tSet.add("Apple");
		tSet.add("Dog");
		tSet.add("Individual");
		
		Iterator<String> itr = tSet.descendingIterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
	}

}
