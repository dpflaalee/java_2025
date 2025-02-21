package com.company.java005_ex;

public class ForEx003 {
	public static void main(String[]args) {
		//1~10까지의 합
		//시작-변화-종료
		int i=0, sum=0;
		//int 1누적/""1출력 
		//int 2누적/"+"2출력 
		//int 3누적/"+"3출력 
		for( i=1; i<=10; i++ ) {
			sum=sum+i; System.out.print(( i==1 ? "" : "+" )+i);
		}
		System.out.println("="+sum);
	}
}
