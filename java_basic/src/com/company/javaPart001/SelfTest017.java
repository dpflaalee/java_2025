package com.company.javaPart001;

public class SelfTest017 {
  public static void main(String[] args) {
    int [][] arr = new int[4][5];
    int data = 1;
    for(int i=0; i<arr.length; i++){
      for(int index=0; index<arr[i].length; index++){
        arr[i][index]=data++;
        System.out.print((index==0?"":"\t")+arr[i][index]);
      }System.out.println();
    }
  }  
}
/*
1.4*5 배열만들기
2.배열에 1~20까지 데이터 입력
3.다음과 같이 출력하기 

1	2	3	4	5
6	7	8	9	10
11	12	13	14 	15
16	17	18	19	20*/