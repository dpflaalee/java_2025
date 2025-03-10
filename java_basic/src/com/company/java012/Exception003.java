package com.company.java012;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception003 {
	
	public static int nextInt() throws InputMismatchException { //##발생지점
		int a = -1;
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력해주세요");
		a = sc.nextInt();
		
		return a;
	}
	
	public static void main(String[] args) {
		int a= -1;
		while(true) {
			try {
				a=nextInt();
						if (a==1) {break;}
				System.out.println(nextInt());
			} catch (Exception e) {
				System.out.println("오류");
				// TODO: handle exception
			}
		}
		
		
		
		
	}
}
/*

Exception in thread "main" java.util.InputMismatchException
	at java.base/java.util.Scanner.throwFor(Scanner.java:964)
	at java.base/java.util.Scanner.next(Scanner.java:1619)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2284)
	at java.base/java.util.Scanner.nextInt(Scanner.java:2238)
	at com.company.java012.Exception003.nextInt(Exception003.java:12)	##발생지점
	at com.company.java012.Exception003.main(Exception003.java:18)		##호출한애
*/