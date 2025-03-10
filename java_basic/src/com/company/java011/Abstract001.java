package com.company.java011;
//일반
abstract class Animal{
String name; 
abstract void eat(); // 추상메서드가 있으면 반드시 추상클래스 만들어줘야함
abstract void sleep1(); //추상메서드는 구현부[{} 없음. 공통의속성, 구체적 내용 없음
abstract void poo(); // 추상화, 일반화 , 설계 : 공통 속성 구체적 내용 x
}
class Cat extends Animal{

	@Override
	void eat() { System.out.println(super.name + "고양이 얌냠");}
	@Override	void sleep1() { System.out.println(super.name + "고양이 코");}
	@Override 	void poo() { System.out.println(super.name + "고양이 시원");}
}
class Dog extends Animal{

	@Override
	void eat() { System.out.println(super.name + "강아지 얌냠");}
	@Override	void sleep1() { System.out.println(super.name + "강아지 코");}
	@Override 	void poo() { System.out.println(super.name + "강아지 시원");}
	
public class Abstract001 {
	public static void main(String[] args) {
		//abtaract class : 일반클래스 + 설계
		// Animal ani = new Animal();
		Animal ani = null;
		ani.name = "sally"; ani.eat();	
		ani = new Dog();
		ani.name = "alpha"; ani.eat();
		
		//사용목적
		Animal[] arr = {new Cat(), new Cat(),new Dog(),new Dog()};
		int cnt=0;
		for (Animal a : arr) {a.name="ani"+ ++cnt; a.eat();}}
	}
}
