/*
 *  파일이름: FruitSeller.java
 */

package orange.seller;

public class FruitSeller
{
	int numOfApple;
		int myMoney;
		final int APPLE_PRICE;
		
		public FruitSeller(int money, int appleNum, int price)
		{
			myMoney=money;
			numOfApple=appleNum;
			APPLE_PRICE=price;
		}
		
		public int saleApple(int money)
		{
			int num=money/APPLE_PRICE;
			numOfApple-=num;
			myMoney+=money;
			return num;
		}
27.		public void showSaleResult()
28.		{
29.			System.out.println("남은 사과: " + numOfApple);
30.			System.out.println("판매 수익: " + myMoney);
31.		}
32.	}
