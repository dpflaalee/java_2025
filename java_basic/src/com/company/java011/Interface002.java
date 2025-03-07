package com.company.java011;
/*
다중상속

*/
class Class1{}
interface Inter21{void method();}
interface Inter22{void method2();}
interface Inter23 extends Inter21, Inter22{} //interface 에서 다중상속 가능
class Using1 extends Class1 implements Inter21, Inter22{

	@Override public void method2() {  }

	@Override public void method() {  }
	
}
public class Interface002 {
	public static void main(String[] args) {
		Using1 my = new Using1();
		if(my instanceof Object) {System.out.println("Object");}
		if(my instanceof Class1) {System.out.println("Class1");}
		if(my instanceof Inter21) {System.out.println("Inter21");}
		if(my instanceof Inter22) {System.out.println("Inter22");}
	
	}
}
