package com.company.java012;

public class Exception002 {
	public static void main(String[] args) {
		//////////Exception 해결//////////
		//1. try{에러 날거같아...} catch(에러내용){} finally{무조건 처리, 생략 가능}
		try{ System.out.println(10/0); } 
//		catch(ArithmeticException e) { System.out.println("관리자한테 문의!"); }
		catch(Exception e) { System.out.println("관리자한테 문의!"); }
		finally { System.out.println("무조건 실행"); }
		
		// 업캐스팅 - 부모는 자식을 담을 수 있다
		
		//2. throws
	}
}
/*
									##1 복사 ArithmeticException	>> 보통 그냥 Exception이 부모라 이것만 써도 ㄱㅊ...
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.company.java012.Exception002.main(Exception002.java:7) ##2. 줄수 exception

*/