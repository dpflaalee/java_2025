package com.company.javaPart002;

import java.util.Scanner;

public class Test010 {
  public static int nextInt(){
   Scanner sc = new Scanner(System.in) ;
   System.out.println("1을 입력하세요");
   return sc.nextInt();
  }
  public static void main(String[] args) {
    int one = 0;
    while(true){one = nextInt(); if(one==1){break;}}
  }
}
//throws를 이용하여 코드 수정