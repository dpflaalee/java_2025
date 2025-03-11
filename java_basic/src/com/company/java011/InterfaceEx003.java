package com.company.java011;

import java.util.Arrays;
import java.util.Calendar;

/*연관관계
 					<<interface>>	상수:MONEY=10000 | abstract void eat()
User →					Lunch			
					↑			↑
				Burger			KimchiStew
				price=3900		price=4000
				eat()			eat()			@Override
				Lunch.eat() ==> Burger or KimcheStew								
*/
interface Lunch{int MONEY=10000; void eat();}

class Burger implements Lunch{
	int price;	public Burger() { this.price = 3900; }
	
	@Override	public void eat() {	System.out.println("Burger 냠냠");	}
	@Override	public String toString() {return "Burger";}		} //어떤 객체인지

class KimchiStew implements Lunch{
	int price;	public KimchiStew() { this.price = 4000; }
	
	@Override	public void eat() {	System.out.println("KimchiStew 냠냠");	}
	@Override	public String toString() {	return "KimchiStew";	}		}

class User{
	int money; int cnt;
	
	Lunch[]plate;	User(){this.money=Lunch.MONEY; plate = new Lunch[3]; cnt=0;}
	
	void order(Lunch m) {
		int temp=0;
		//주문 메뉴 값 확인
		if (m instanceof Burger) {System.out.println("버거 하나요"); temp = ((Burger)m).price;} 
		else if (m instanceof KimchiStew) {System.out.println("김치찌개 하나요"); temp = ((KimchiStew)m).price;}
		//수중 금액 확인
		if(money<temp) {System.out.println();return;} money-=temp;	 //주문이 처음에는 3개 공간처리 공간이 없으면 3 6 9 증가처리 // 10000을 넘으면 잔액부족
		//plate에 주문넣기
		plate[cnt++]=m; System.out.println(money+"-"+Arrays.toString(plate));
	}
	
	void show() {
		String order = "주문";
		
		System.out.println(Arrays.toString(plate));
		for(int i=0;i<cnt;i++) {order +=((i!=0)? "," : " ") + plate[i];}
		System.out.println("\n\n"+order);
		System.out.println("주문금액"+(Lunch.MONEY-money));
		System.out.println("잔액"+money);
		
		Calendar today =Calendar.getInstance();
		System.out.println("년"+(today.get(1))+"년"+(today.get(2)+1)+"월"+(today.get(5))+"일");
		
//		for(Lunch m : plate) {m.eat();}
		for(int i=0; i<cnt; i++) {plate[i].eat();}

	}
}

public class InterfaceEx003 {
	public static void main(String[] args) {
		User launchorder = new User();
		launchorder.order(new Burger()); // 버거 하나요 void order (Lunch a){}
		launchorder.order(new KimchiStew()); //김치찌개 하나요  Lunch a = new Burger()
		launchorder.order(new Burger()); //버거 하나요 >> 잔액부족
		
		
		launchorder.show();
		/*
		주문 : Burger, KimchiStew
		주문금액 : 7900
		잔액 : 2100
		2022년 12월 16일
		Burger 냠냠
		KimchiStew 냠냠
		*/
	}
}

