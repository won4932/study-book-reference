package Chapter07;
class Que712 {
	int marble=0;
	public Que712(int marble) {
		this.marble = marble;
	}
	void MarbleExchange(Que712 child, int m) {
		if(child.marble<m)
			System.out.println("������ ���°� ��Ҿ�!");
		this.marble+=m;
		child.marble-=m;
	};
	void NowMarble() {
		if(marble<=0)
			marble=0;
		System.out.println(marble);
	};
	
	
}
public class Que7_1 {

	public static void main(String[] args) {
		Que712 child1 = new Que712(15);
		Que712 child2 = new Que712(9);
		
		System.out.println("1�� ���ӿ��� ���1�� ���2�� ���� 2���� ȹ���Ѵ�.");
		child1.MarbleExchange(child2, 2);
		System.out.println("2�� ���ӿ��� ���2�� ���1�� ���� 7���� ȹ���Ѵ�.");
		child2.MarbleExchange(child1, 7);
		System.out.println("3�� ���ӿ��� ���2�� ���1�� ���� 12���� ȹ���Ѵ�.");
		child2.MarbleExchange(child1, 12);
		System.out.print("���1�� ���� ���������� : ");
		child1.NowMarble();
		System.out.print("���2�� ���� ���������� : ");
		child2.NowMarble();
	}

}
