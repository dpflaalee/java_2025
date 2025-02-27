package com.company.java007;

import java.util.Arrays;

public class Method004 {
	
	/*public static int add(int x, int y) {return x+y;}

	public static int add(byte x, byte y) {return x+y;}
	public static int add(short x, short y) {return x+y;}
	//public static long add(int x, int y) {return x+y;} // 1번과 파라미터의 갯수, 자료형 동일 > 오류
	public static long add(long x, long y) {return x+y;}*/
	public static void show(int a) {System.out.println(a*10);}
	public static void show(int a, int b, int c) {System.out.println(a*100+"\t"+b*100+"\t"+c*100+"\t");}
	
	public static void main(String[] args) {
		//[heap] 1번지 {0번째:1,1번째:2,2번째:3} < [stack]a:1번지  
		
		int[]a= {1,2,3};
		
		show(a[0]); // 10출력
		show(a[0], a[1], a[2]); //100 200 300 출력		
		show(1, 2, 3); //값 - value :: call by value	
		
		System.out.println("main1.배열값:"+Arrays.toString(a)); //
		System.out.println("main2.배열의 주소값:"+System.identityHashCode(a)); //245257410>>계속 변화...
		
		
		//public static void show(int[]a){}
		show(a); //call by reference :: 주소값을 대입하면 주소를 따라가서 메인에 존재하는 값이 변해버림
		System.out.println("main4.배열값:"+Arrays.toString(a));
		
	}//main
	public static void show(int[]a){
		System.out.println("show3.배열의 주소값:"+System.identityHashCode(a));
		//a[0]+=10;
		for(int i=0; i<a.length;i++) {a[i]+=10;}
	}
}//class
