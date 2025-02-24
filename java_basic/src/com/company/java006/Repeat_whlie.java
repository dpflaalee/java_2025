package com.company.java006;

public class Repeat_whlie {
	public static void main(String[] args) {
		//for		(반복횟수를 알 때)
		for(int i=1; i<4; i++) {System.out.print(i+"\t");} System.out.println();
		
		//while		(반복횟수를 모를때 ex)게시판) 초기값 위로, 증감은 맨 끝으로
		int i=1; while(i<4) {System.out.print(i+"\t"); i++;} System.out.println();
		
		//do while 	(무조건 1회실행은 해야할 때) while 위치를 맨끝
		do{System.out.print(i+"\t"); i++;} while(i<=3);  System.out.println();
		
	}//end main
} // end class
