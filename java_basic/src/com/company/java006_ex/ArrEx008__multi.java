package com.company.java006_ex;

public class ArrEx008__multi {
	public static void main(String[] args) {
		int[][] arr={	{100,200,300},
						{400,500,600}	};
		for(int i = 0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
		}System.out.println(); System.out.println();
		
		int[][] arr2={	{101,102,103},
						{201,202,203}	};
		for(int i=0; i<arr2.length; i++) {				//몇층
			for(int j=0; j<arr2[i].length; j++) {		//몇칸
				System.out.print(arr2[i][j]+"\t");		//한 층이 끝나고 나면 해야할 일
			}
		}
		
		
		
		
	}//end main
}
