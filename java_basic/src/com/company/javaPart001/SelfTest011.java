package com.company.javaPart001;

import java.util.Scanner;

public class SelfTest011 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    for(;;){
      System.out.print("1~100사이의 숫자를 입력하세요"); int num = sc.nextInt();
      if (0<num&&num<=100) {break;}
    }
  }

}
// * 1~100사이를 입력할때까지 무한반복하기 
// 		 * 만약 1~100사이를 입력하면 빠져나오기	