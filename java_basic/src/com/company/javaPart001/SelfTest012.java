package com.company.javaPart001;
import java.util.Scanner;

public class SelfTest012 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num=0;
    while (true) {
      System.out.print("1~100 사이의 숫자를 입력하세요"); num=sc.nextInt();
      if (0<num&&num<=100) {break;}
    }
  }
}
