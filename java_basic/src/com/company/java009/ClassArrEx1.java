package com.company.java009;

import com.company.java009_ex.Apple;

public class ClassArrEx1 {
	public static void main(String[] args) {
        Apple[] apples= new Apple[3]; 
        //위의 화면처럼 값 셋팅
        //위의 화면처럼 출력
        apples[0]=new Apple("RED", "iron", 2, 1000); 
        apples[1]=new Apple("GREEN", "hulk", 1, 1500); 
        apples[2]=new Apple("GOLD", "captain", 3, 2000);
        
//        System.out.println(apples[0]);
//        System.out.println(apples[1]);
//        System.out.println(apples[2]);
       // for(int i=0; i<apples.length; i++) { System.out.println(apples[i]); }
        
        //향상된 for( 해당자료형 one : 배열, 동적배열 ) 초기/조건/증감문 필요x
        for(Apple one:apples) {System.out.println(one);}
        
        
        
	}
}
/*
Apple [name=RED, order=iron, num=2, price=1000]
Apple [name=GREEN, order=hulk, num=1, price=1500]
Apple [name=GOLD, order=captain, num=3, price=2000]
*/