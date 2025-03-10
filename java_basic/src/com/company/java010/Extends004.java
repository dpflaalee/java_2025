package com.company.java010;

class Aunt extends Object{
	String name="MiMi";
	@Override public String toString() { return name+"옆집이모클래스"; } 
}

class Grand extends Object{
	public void one() {System.out.println("Grand:one");}
	public void two() {System.out.println("Grand:two");}
}

class Father extends Grand{
	public void three() {System.out.println("father:three");}
}

class Uncle extends Grand{
	public void four() {System.out.println("Uncle:four");}
	//오버라이딩 super.one()"uncle:one" 출력
	@Override public void one() {System.out.println("Uncle:one");}
	//오버라이딩 super.two()"uncle:two" 출력
	@Override public void two() {System.out.println("Uncle:two");}
}


public class Extends004 {
	public static void main(String[] args) {
		Father father = new Father(); father.three(); father.two(); father.one();
		System.out.println("Father 부모 메소드 사용가능");
		
		Uncle uncle = new Uncle(); uncle.four(); uncle.two(); uncle.one();
		System.out.println("Uncle 자식메소드가 우선");
		
		Aunt aunt = new Aunt();
		System.out.println(aunt.toString()); System.out.println("aunt");
	}
}
