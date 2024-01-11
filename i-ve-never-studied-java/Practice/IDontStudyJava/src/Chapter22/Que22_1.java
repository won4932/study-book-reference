package Chapter22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name + "(" + age + "��)";
	}
	
	//������� x
//	@Override
//	public int hashCode() {
//		// TODO Auto-generated method stub
//		return age;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		Person per = (Person)obj;
//		if(per.name.equals(name))
//			return true;
//		else
//			return false;
//	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode()+age%7;
	}
	
	@Override
	public boolean equals(Object obj) {
		Person per = (Person)obj;
		if(per.name.equals(name) && per.age==age)
			return true;
		else
			return false;
	}
	
}

public class Que22_1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(500);
		list.ensureCapacity(list.size()*2);
		
		//Que22_3
		HashSet<Person> hSet = new HashSet<Person>();
		hSet.add(new Person("����ȣ", 10));
		hSet.add(new Person("����ȣ", 20));
		hSet.add(new Person("���ȣ", 20));
		hSet.add(new Person("���ȣ", 15));
		hSet.add(new Person("����ȣ", 20));
		hSet.add(new Person("���ȣ", 20));
		
		System.out.println("����� ������ �� : " + hSet.size());
		
		Iterator<Person> itr = hSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
