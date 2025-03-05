package com.company.javaPart001;

public class SelfTest015 {
  public static void main(String[] args) {
    int [] arr = new int[5];
    int count=1;
    for(int i=0;i<arr.length;i++){
      arr[i]=count++;
    }
    for(int index=0; index<arr.length; index++){
      System.out.print((index==0?"":",")+arr[index]);
    }

  }
}
/*1. 숫자형공간이 5개인  배열 arr 만들기
2. for구문을 이용하여  1~5까지 입력
3. for구문을 이용하여  1~5까지 출력*/