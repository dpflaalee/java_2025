package com.company.java006_ex;

public class ArrEx009_multi {
	public static void main(String[] args) {
		// Q.001
		int [][] arr = new int [2][3];
		//0,0 101 | 0,1 102 | 0,2 103 
		//1,0 104 | 1,1 105 | 1,2 106
		int data = 101;
		for(int index = 0 ; index<arr.length; index++ ) {
			for(int i=0; i<arr[index].length; i++) {
//				arr[index][i]=data++;
				System.out.print((arr[index][i]+data++)+"\t");
			}System.out.println();
		}
		
		//Q.002
		// 0,0 A | 0,1 B | 0,2 C A++
		// 1,0 B | 1,1 C | 1,2 D B++
		char[][]arr2 = new char [2][3];
		char data2='A';
		for(int i=0; i<arr2.length; i++) {
			for(int index=0; index<arr2[i].length; index++) {
				//arr2[i][index]=data2++;
				System.out.print((arr2[i][index]=data2++)+"\t");
			} data2='B'; System.out.println();
		}
//		System.out.println(Arrays.deepToString(arr2));

		
		
	}
}
/*
1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
      A   B   C
      B   C   D


*/