package Chapter07;
class Que712 {
	int marble=0;
	public Que712(int marble) {
		this.marble = marble;
	}
	void MarbleExchange(Que712 child, int m) {
		if(child.marble<m)
			System.out.println("구슬도 없는게 까불어!");
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
		
		System.out.println("1차 게임에서 어린이1은 어린이2의 구슬 2개를 획득한다.");
		child1.MarbleExchange(child2, 2);
		System.out.println("2차 게임에서 어린이2은 어린이1의 구슬 7개를 획득한다.");
		child2.MarbleExchange(child1, 7);
		System.out.println("3차 게임에서 어린이2은 어린이1의 구슬 12개를 획득한다.");
		child2.MarbleExchange(child1, 12);
		System.out.print("어린이1의 현재 구슬보유수 : ");
		child1.NowMarble();
		System.out.print("어린이2의 현재 구슬보유수 : ");
		child2.NowMarble();
	}

}
