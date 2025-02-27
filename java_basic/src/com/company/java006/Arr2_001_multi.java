package com.company.java006;

import java.util.Arrays;

public class Arr2_001_multi {
	public static void main(String[] args) {
		int [][] arr = {	{1,2,3},		//00 01 02
							{4,5,6}		};	//10 11 12
		
		System.out.println(Arrays.toString(arr));		//[[I@372f7a8d, [I@2f92e0f4]
		System.out.println(Arrays.deepToString(arr));	//[[1, 2, 3], [4, 5, 6]]

		
		//ver1 눈에 보이는대로
		System.out.print(arr[0][0]+"\t"); System.out.print(arr[0][1]+"\t"); System.out.print(arr[0][2]+"\t");
		System.out.println();
		
		System.out.print(arr[1][0]+"\t"); System.out.print(arr[1][1]+"\t"); System.out.print(arr[1][2]+"\t");
		System.out.println();
		
		//ver2 칸정리
		for(int i=0; i<3; i++) {
			System.out.print(arr[0][i]+"\t");
			for(int ch=0; ch<2; ch++) {System.out.print(arr[ch][i]+"\t");}
		} 
		
		
		//ver3 층정리
		
		
		
	}//end main
}
