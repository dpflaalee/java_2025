package com.company.java006;

import java.util.Arrays;

public class Arr2_002 {
	public static void main(String[] args) {
		int[][]arr=new int[2][3]; // 2층 3칸 공간빌려오기
		
//		ver1
//		arr[0][0]=1;
//		arr[0][1]=2;
//		arr[0][2]=3;
//		
//		arr[1][0]=4;
//		arr[1][1]=5;
//		arr[1][2]=6;
		
		int data = 1;
		//ver2
//		arr[0][0] = data++; arr[0][1] = data++; arr[0][2] = data++;
//		arr[1][0] = data++; arr[1][1] = data++; arr[1][2] = data++;
		
		for(int index=0; index<arr.length; index++) {
			for(int i=0; i<arr[index].length; i++) {
				arr[index][i]=data++;
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
		
	}
}
