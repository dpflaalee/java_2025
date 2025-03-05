package com.company.javaPart001;

public class SelfTest016 {
  public static void main(String[] args) {
    int[][]arr=new int[2][3];
    int data = 100;
    for(int i=0; i<arr.length;i++){
      for(int index=0;index<arr[i].length;index++){
        arr[i][index]=data++;
        System.out.print((index==0?"":"\t")+arr[i][index]);
      }System.out.println();
    }
  }
}
/*
1. 2*3배열만들기
2. for구문을 이용하여 다음과 같이 데이터 입력
3. for구문을 이용하여 다음과 같이 데이터 출력
   100	101 102
   200	201 202                           */