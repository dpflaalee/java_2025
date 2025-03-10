package com.company.java011;

//클래스는 부품객체 > 상태와 행위
interface Animal1{
	String COMPANY = "(주)동물농장"; // static final - method area, new X 
	void eat(); // abstract > 구현부 X = new X > 설계도
}
class Saram implements Animal1{
	@Override
	public void eat() { /*COMPANY="해물탕";	interface의 변수는 상수(final)라 재선언 불가*/ 
		System.out.println("밥 식사..."); }	}

class Pig implements Animal1{
	@Override public void eat() { System.out.println("돼지...");  }

}

public class Interface001 {
	public static void main(String[] args) {
		//Animal1 ani = new Animal1(); 
			//error :: Cannot instantiate the type Animal1 : 인스턴스화 불가능 설계목적
		System.out.println(Animal1.COMPANY); //static이 붙어서 바로 사용가능
		//하나의 자료형으로 여러개의 타입을 관리하려고 사용 : 다형성 : interface abstract extends
		Animal1 [] anis = {new Saram(), new Saram(), new Pig(), new Pig()};
		for(Animal1 a: anis) {a.eat();} // Override - 자식 eat
	}
}
