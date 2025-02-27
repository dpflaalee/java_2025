package com.company.java007_ex;

import java.util.Arrays;

public class MethodEx005 {
	
		public static void upper(char[] ch) {
			for(int i=0; i<ch.length; i++) {
				ch[i]-=32;
			}

		}
	
	public static void main(String[] args) {
	
		char[]ch= {'a', 'b', 'c'};
		upper(ch);
		System.out.println("main.배열값:"+Arrays.toString(ch));
		
	}//main
	
	
}//class
/*public class MethodEx005{ 
    char[] ch = {'a','b','c'};
    upper(ch);   
    System.out.println("main. 배열값 : "      +  Arrays.toString(ch)          );
}*/