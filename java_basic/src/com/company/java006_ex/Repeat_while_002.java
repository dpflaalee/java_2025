package com.company.java006_ex;

public class Repeat_while_002 {
	public static void main(String[] args) {
		int index=1, sum=0, sum2=0, sum3=0;
		//1-1 for 1~10까지 "3의 배수의 합:18" 출력
		//1~10까지 반복 출력 중 만약 숫자가 3의 배수일 시 sum에 저장하여 더하기
		for(index=1; index<11; index++) {if(index%3==0) {sum=sum+index;}}
		System.out.println("3의 배수의 합:"+sum);
		
		//1-2 while 1~10까지 "3의 배수의 합:18" 출력
		int index2=1; while(index2<11) {if(index2%3==0) {sum2=sum2+index2;} index2++; }
		System.out.println("3의 배수의 합:"+sum2);
		
		//1-3 while for 1~10까지 "3의 배수의 합:18" 출력
		int index3=1; do {if(index3%3==0) {sum3=sum3+index3;} index3++; } while(index3<11);
		System.out.println("3의 배수의 합:"+sum3);
		
	}
}

/*
for , while , do while 3가지 버젼으로 
1~10까지 3의 배수의 합 : 18
*/