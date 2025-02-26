package com.company.java007;

public class Method003 {
	
	//public static sally sign() {return "sally";};
	public static String sign() {return "sally";};
	public static Integer num() {return (int) (Math.random()*45);}; //Math.random :: 0~0.9999
	public static double pi() {return 3.141592;};
	public static String hello(String str) {return "안녕"+str ;};
	
	//////////////////////////////////////////////
	public static void main(String[] args) {
		//public static 리턴값 메서드명(파라미터){}
		System.out.println("당신의 이름은?" + sign());
		
		int yournum=num();
		System.out.println("랜덤숫자:"+yournum);
		
		System.out.println("파이값:"+pi());
		
		System.out.println(hello("sally"));
		System.out.println(hello("alpha"));
		
	}////////////////////////////////////////////
}
