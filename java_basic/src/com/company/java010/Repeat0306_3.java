package com.company.java010;
/*
	Object
	↑
	Papa2 { int money=10000 / sing() }
	↑
	Son2 { int money=1500 / sing() }
*/
class Papa2 extends Object{
	int money = 10000;
	public Papa2() {super();}
	public void sing() {System.out.println("GOD-거짓말");}
}
class Son2 extends Papa2{
	int money = 1500;
	public Son2() {super();}
	@Override public void sing() {System.out.println("빅뱅-거짓말");}
}
public class Repeat0306_3 {
	public static void main(String[] args) {
		//Q8 부모는 자식을 담을 수 있다 / 업캐스팅 / 타입캐스팅 필요없음
		Papa2 mypapa=new Son2();
		//Q3. Papa mypapa { int money=10000 / sing() } 사용가능
		
		//Q4.인스턴스화한 실제 메모리 빌려온 그림 { int money=1500 / sing() }-{ int money=10000 / --- }
		System.out.println(mypapa.money); //Q5. 10000
		mypapa.sing(); //Q6 빅뱅-거짓말
		
		//Q7.mypapa.money를 이용해 1500 출력
		System.out.println(((Son2)mypapa).money);
		
	}
}
