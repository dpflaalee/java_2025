package com.company.java007_ex;

import java.util.Arrays;
import java.util.Scanner;


public class Repeat_250227 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//001.if ver - 가   'j'이면  java,  'h'이면   html,   'c'이면 css
		System.out.print("1.영문자를 입력하세요:"); char ch = sc.next().charAt(0);
		if(ch=='j' || ch=='J') {System.out.println("java\n");}
		else if (ch=='h' || ch=='H') {System.out.println("html\n");}
		else if(ch=='c' || ch=='C') {System.out.println("css\n");}
		
		System.out.print("2.영문자를 입력하세요:"); ch = sc.next().charAt(0);
		switch(ch) {
		case 'j' : case 'J': System.out.println("java\n"); break;
		case 'h' : case 'H': System.out.println("html\n"); break;
		case 'c' : case 'C': System.out.println("css\n"); break;}
		
		//for, while, do while 3가지 버젼으로    100 200 300  출력
		System.out.println("3.for");
		for(int i=100; i<=300; i+=100) {System.out.print(i+"\t");}
		System.out.println("\n3-1.while");
		int i=100; while(i<=300) {System.out.print(i+"\t"); i+=100;}
		System.out.println("\n3-2.do while");
		i=100; do {System.out.print(i+"\t"); i+=100;}while(i<=300); System.out.println();
		
		System.out.println("\n4.Array");
		char [] arr = new char[3];
		char dataCh='a';
		for(int index = 0; index<arr.length; index++) {
			arr[index]=dataCh; System.out.print((index==0 ? "" : "\t")+arr[index]); dataCh++;}
		
		System.out.println("\n5.이중배열");
		char [][] arr2 = new char[2][3];
		dataCh='a';
		for(int index = 0; index<arr2.length; index++) {
			for(int index2 = 0; index2<arr2[index].length; index2++) {
				 arr2[index][index2]=dataCh; dataCh++;}			}
		System.out.println(Arrays.deepToString(arr2)+"\n");
		
		hi();
		hi(1);
		hi("sally");
		System.out.println(hi("sally"));
		
		sc.close();
		
	}//end main

	public static void	 hi() {System.out.println("hi");}
	public static void	 hi(int num) {System.out.println("hi "+num+"님!");}
	public static String hi(String name) {return "hi "+name;}
	
}// end class

/*public static void main(String[] args){
    hi();   // hi 출력
    hi(1);   // hi 1 님! 출력
    System.out.println( hi("sally") );   // hi sally 출력
    
}*/
