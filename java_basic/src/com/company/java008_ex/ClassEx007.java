package com.company.java008_ex;

import java.util.Scanner;

class Calc{
	static String name = "**계산기**";
	int num1, num2;  char op;  double result;
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.숫자입력>"); num1 = sc.nextInt();
		System.out.print("2.숫자입력>"); num2 = sc.nextInt();
		System.out.print("3.연산자입력>"); op = sc.next().charAt(0);
		sc.close();	}   //입력받기
	
	void opcalc() {
		if(op=='+') {result = num1 + num2;}
		else if(op=='-') {result = num1 - num2;}
		else if(op=='*') {result = num1 * num2;}
		else if(op=='/') {result = num1 / (double)num2;}
		else {System.out.println("잘못된 입력입니다.");}	} //+더하기계산, -라면 -계산  , *라면 *계산 , /라면 /계산 
	
	void show() {
		opcalc();
		System.out.print(""+num1+op+num2+"="+(op == '/' ? String.format("%.2f", result) :(int)result)+"\n");
	}   //연산출력
	
	public Calc(int num1, int num2, char op) {	this.num1=num1;	this.num2=num2;	this.op=op;	}
	Calc(){}//생성자
}//end calc

public class ClassEx007 {
	public static void main(String[] args) {
		System.out.println(Calc.name); // 클래스명.static 변수 - new를 이용해서 사용할 필요 없음! 
		
		Calc  c1= new Calc(10,3,'+');  
		c1.show();
		
		Calc  c2= new Calc();  
		c2.input(); c2.show(); 
		
	}//end main
}//end class

/*
  
 소스파일													컴파일	바이트코드  
 ClassEx007.java [ class Calc{} / public ClassEx007{} ] 		ClassEx007.class/Calc.class
 ## Class Loader
 
------------------------------- [ runtime ]
[method : 정보, static, final, 공유] 
Calc.class ClassEx007.class Calc.name(**계산기**) . main
---------------------------------------------
[heap:동적]               | [stack:임시지역변수]
---------------------------------------------
*/