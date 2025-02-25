package com.company.java007_ex;

public class ArrEx010_multi {
	public static void main(String[] args) {
		//Q.003
		int [][] arr=new int [4][3];
		int total = 0, count=0;
		double avg = 0.0;
		/*
		 * 0,0 '1' | 0,1 '1' | 0,2 '1' data
		 * 1,0 '2' | 1,1 '2' | 1,2 '2' data++ >> 줄바뀔때마다
		 * 2,0 '3' | 2,1 '3' | 2,2 '3' data++
		 * 3,0 '4' | 3,1 '4' | 3,2 '4' data++
		 */
		int data = 1;
		for(int i=0; i<arr.length; i++) {
			for(int index=0; index<arr[i].length; index++) {
				total+=(arr[i][index]=data); count++;
			} data++; 
		}
		 
		avg=total/(double)count;
		System.out.println("총점:"+total+"\n평균:"+avg);
	}
}
/*	배열을 이용하여 다음의 프로그램을 작성하시오.   
	1. 다음의 주어진조건을 이용하여 총점과 평균을 구하시오.
       int[][] arr = {
         { 1, 1, 1,},
         { 2, 2, 2,},
         { 3, 3, 3,},
         { 4, 4, 4,},
       };
       int total=0;  double avg=0.0;

      출력내용:
      총점 : 30
      평균 : 2.5							*/