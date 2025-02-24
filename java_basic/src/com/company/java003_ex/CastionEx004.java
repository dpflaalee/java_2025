package com.company.java003_ex;

public class CastionEx004 {
	public static void main(String[]args) {
		short sh1 = 1;
		short sh2 = 2;
		short result = (short) (sh1+sh2);
//		자료가 들어가는 공간은 괜찮아도 연산할 때는 int로 변환되어 인식되니까 꼭 주의하기
		System.out.println(result);
	}
}
