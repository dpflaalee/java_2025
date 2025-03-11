package com.company.java014;
//클래스는 부품객체 : 상태와 행위-tjfrPeh
// interface(public static final / public abstract)
interface Inter1{void method();}
class Inter1Impl implements Inter1{
 @Override public void method() { System.out.println("Hello :D"); }	}
public class Lambda001 {
	public static void main(String[] args) {
		//#1 interace
		Inter1 a1 = new Inter1Impl(); a1.method();
		//#2 익명이너클래스
		Inter1 a2 = new Inter1() {
			@Override public void method() { System.out.println("Hello :D :D"); } 
			};	a2.method();
			
		//#3 lambda 받아서 처리 ()->{}
		Inter1 a3 = ()->{System.out.println("hello");
		};a3.method();
	}
}
