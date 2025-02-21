package com.company.java005_ex;

public class ForEx004 {
	public static void main(String[]args) {
		//1~10까지 3의 배수 갯수를 출력
		
		int i=0, num=0;

		System.out.print("1부터 10까지 3의 배수:");
		for(i=1;i<=10;i++) {
			if(i%3==0) { num++; System.out.print((i==3 ? "" : ",")+i);	}
		}
		System.out.println();
		System.out.println("갯수:"+num+"개");
		
		//다른방법
//		String result ="3의 배수:";
//		for(i=1;i<=10;i++) {
//			if(i%3==0) { num++; result+=((i==1 ? "" : ",")+i);	}
//		}
//		System.out.println(result+"="+num);
	}
}
