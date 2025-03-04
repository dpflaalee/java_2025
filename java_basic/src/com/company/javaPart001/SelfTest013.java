package com.company.javaPart001;
import java.util.Scanner;

public class SelfTest013 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("숫자를 입력하세요"); int dan = sc.nextInt();
    for(int index=1; index<10; index++){
    System.out.println(dan+"x"+index+"="+(dan*index));}
    sc.close();
  }
}
/*  for 응용
  	원하는 단을 입력하세요 _예) 2단
  	2*1 =2
   	2*2 =4 ...
*/