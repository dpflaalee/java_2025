package com.company.java014;
interface InterTest21{void test();}
interface InterTest22{void test(int a);}
interface InterTest23{int test();}
interface InterTest24{int test(int a);}
public class Repeat_Lambda {
	public static void main(String[] args) {
		//Q1. test1.test() 안녕
		InterTest21 test1 = ()->{System.out.println("안녕");}; test1.test();
		
		//Q1. test2.test(2) 안녕 안녕
		//void test(int a); 파라미터 o 리턴값 x
		InterTest22 test2 = (a)->{System.out.println("안녕".repeat(a));}; test2.test(2);
		
		//Q1. System.out.println(test3.test()); 3
		//int test(); 파라미터x 리턴값o
		InterTest23 test3 = ()->{return 3;}; System.out.println(test3.test());
		
		//Q1. System.out.println(test4.test(3)); 30
		InterTest24 test4 = (int a)->{return a*10;}; System.out.println(test4.test(3));
	}

}
