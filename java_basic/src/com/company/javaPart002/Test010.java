package com.company.javaPart002;

import java.util.Scanner;

public class Test010 {
  public static int nextInt()throws Exception{
   Scanner sc = new Scanner(System.in) ;
   System.out.println("1을 입력하세요");
   return sc.nextInt();   
  }
  
  public static void main(String[] args) {
    int one = 0;
    while(true){
    	try{one = nextInt(); 
    	if(one==1){break;}}catch(Exception e) {System.out.println("잘못된 입력입니다.");}
    	}
    
    
  }//E.M
}//E.C
//throws를 이용하여 코드 수정