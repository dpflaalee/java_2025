package com.company.java011;
interface Animal3{String NAME="홍길동"; void eat();}
class Saram3 implements Animal3{
	@Override public void eat() {  
		//NAME="아이유"; // interface의 변수는 상수라서 변경 불가능!
		System.out.println(NAME+"이 밥을 먹어요.");
	}
}
public class Repeat0307_4 {
	public static void main(String[] args) {
		//Animal ani = new Animal(); //interface 에서 new 불가능 
		Animal3 ani = null;
		ani = new Saram3(); ani.eat(); // 홍길동 이 밥을 먹어요
	}
}
