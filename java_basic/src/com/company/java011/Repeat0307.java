package com.company.java011;
class Parent{int x=100; void method() {System.out.println("Pernt Method");} 	}
class Child extends Parent{int x = 200;	void method() {System.out.println("Child method");}		}
public class Repeat0307 {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		System.out.println("p.x="+ p.x ); //100
		p.method(); //Child method
		System.out.println("c.x="+c.x); //200
		c.method(); //Child method
	}
}
