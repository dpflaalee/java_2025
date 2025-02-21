package com.company.java005_ex;

public class ForEx005 {
	public static void main(String[]args) {
		//소문자 a~z까지 모음의 갯수
		//변수(문자)-입력-처리(출력된 영문자가 모음인지 체크해서 개수 증가시켜야돼)-출력
		int sum=0;
		char index= '\u0000';
		System.out.print("알파벳 모음의 개수=");
		for( index='a'; index<='z'; index++ ) {
			switch(index) {
			case 'a' : case 'e' : case 'i' : case 'o' : case 'u' : 
				sum++; System.out.print((index=='a' ?"":",")+index); 
			break; 
			}
		}
		System.out.println(":"+sum+"개");
		
		//2번방법-출력을 하나만
		sum=0;
		String result = "알파벳 모음의 개수:";
		for( index='a'; index<='z'; index++ ) {
			switch(index) {
			case'a' : case'e': case'i': case'o': case'u':
				sum++; result+=((index=='a'?"":",")+index);
			}
		}
		System.out.println(result+"="+sum);

		
	}
	
}
