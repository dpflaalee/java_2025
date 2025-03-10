package com.company.java010;
/*
	Object				
	↑					
	TestA3(int a / toString)		
	↑				
	TestB3(int b / toString)

*/
class TestA3 extends Object{
	int a=10;
	@Override
	public String toString() { return "TestA2 [a=" + a + "]"; }}

class TestB3 extends TestA3{
	int b=20;
	@Override
	public String toString() { return "TestB2 [b=" + b + "]"; }}


public class Poly003 {
	public static void main(String[] args) {
		TestA3 ta = new TestB3();
		TestB3 tb = (TestB3) new TestA3(); // 4. 자식=부모 (다운캐스팅) / 타입캐스팅 필요
		//1. TestB3 tb > TestB3{ int b / toString } - TestA3{ int a / ------ }
		//2. TestA3()는 int a만 처리	  x				 TestA3(){int a / toString}
		//3. TestB3 { int b / toString } 보장안됨
		//Exception in thread "main" java.lang.ClassCastException: 
	}
}
