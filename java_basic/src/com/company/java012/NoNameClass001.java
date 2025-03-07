package com.company.java012;
interface Inter1{void method();} // public abstract
class Inter1Impl implements Inter1{
 @Override public void method() { System.out.println("...done!"); } 
}//1-1. 클래스 구현
public class NoNameClass001 {
	public static void main(String[] args) {
		//1. 인터페이스 상속 구현객체
		//1-2. 동작테스트(실체화 객체 테스트)
		Inter1 i1 = new Inter1Impl(); i1.method();
		
		//2. 익명이너클래스
		//Inter1 i2 = new Inter1(); // void method 구현부가 없어서 불가능
		Inter1 i2 = new Inter1() { @Override public void method() { System.out.println("...test"); }
		}; //테스트목적으로, 잘 안쓰는
		i2.method();
	}
}
