package com.company.java006;

public class Arr001 {
	public static void main(String[] args) {
		int[] arr = null; //int 자료형[] 연달아서 입력받을게요
		
		int [] arr2 = {1,2,3};
		/* heap(동적메모리)	 stack(임시공간)
		 * 1번지{1,2,3}	 ←	 arr2:1번지
		 */
		
		System.out.println(arr);
		System.out.println(arr2);
		
		System.out.println("1 꺼내기: "+ arr2[0]);
		System.out.println("2 꺼내기: "+ arr2[1]);
		System.out.println("3 꺼내기: "+ arr2[2]);
		
		int []arr3= {1,2,3,4,5};
		System.out.println(arr3[0]);
		
		int [] arr4 = {100,200,300};
		System.out.println(arr4[2]);
		
		double [] arr5= {1.1, 1.2, 1.3};
		System.out.println(arr5[1]);
		
		char [] arr6= {'a','b','c'};
		System.out.println("배열의 갯수"+arr6.length);
		for(int i =0 ; i<arr6.length; i++) {
			System.out.print(arr6[i]+"\t");
		}
		
	}//end main
}
