package com.company.java014;
interface InterA2{  void hi1();}    
interface InterB2{  void hi2(String name);}  
interface InterC2{  String hi3();}   
interface InterD2{  String hi4(int num, String name);}   

public class LambdaEx001 {
	public static void main(String[] args) {
		//람다 ()->{}
		InterA2 a2 = ()->{System.out.println("hi");}; a2.hi1();
		InterA2 a3 = ()-> System.out.println("hi2"); a3.hi1();
		
		//람다 매개변수o 리턴값x
		InterB2 b1 = (String name)->{System.out.println("h1 "+name);}; b1.hi2("sally");
		InterB2 b2 = name->System.out.println("h1 "+name); b2.hi2("sally"); // 받아서 처리하는 게 하나씩이면 {} 생략가능
		
		//람다 매개변수x 리턴값o
		InterC2 c1 = new InterC2() { @Override public String hi3() { return "Good day"; } }; System.out.println(c1.hi3());
		
		InterC2 c2 = ()->{return "Good day";}; System.out.println(c2.hi3());
		InterC2 c3 = ()->{return "Good day";}; System.out.println(c3.hi3());
		
		InterD2 d1 = (int num, String name)->{	return "Hi"+name+"☆".repeat(num);	}; System.out.println(d1.hi4(3, "sally"));
		
		
	}//E.M
}//E.C
/*
interface InterA2{  void hi1();}    
interface InterB2{  void hi2(String name);}  
interface InterC2{  String hi3();}   
interface InterD2{  String hi4(int num, String name);}   
*/