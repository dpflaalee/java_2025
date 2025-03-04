package com.company.javaPart001;

public class SelfTest014 {
  public static void main(String[] args) {
    System.out.println("2~4단 출력 시~작");
    for(int i=2; i<5; i++){
      for(int index=1;index<10;index++){
        System.out.println(i+"x"+index+"="+(i*index));
      }
    }
  }
}
/*
 * 2~4단까지 출력하세요
 */