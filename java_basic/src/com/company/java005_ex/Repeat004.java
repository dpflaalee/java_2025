package com.company.java005_ex;

import java.util.Scanner;

public class Repeat004 {
	public static void main(String[]args) {
		int num=-1, num2=-1; double result = ' ';
		char oper='f';
		Scanner sc = new Scanner(System.in);

		//break(빠져나와) / continue(skip)
		/*
		 * for(;;){ 1-1 무한반복
		 * #todo 숫자1 입력받고 잘못썼으면 다시 입력받기 >> if(잘못썼으면){ 숫자1 입력받기} 
		 * #todo2 숫자2 입력받고 잘못썼으면 다시 입력받기 >> if(잘못썼으면){ 숫자2 입력받기} 
		 * #todo3 연산자 입력받고 잘못썼으면 다시 입력받기 >> if(잘못썼으면){ 연산자 입력받기 }
		 * 1-2 빠져나올 조건-빠져나오기 break
		 */
		
		for(;;) {
			if(!(0<=num && num<=100)) { // 잘쓴범위가 아니라면 입력시도 / 잘쓴범위라면 입력x
				System.out.print("첫번째 수를 입력해주세요"); num=sc.nextInt();
				//잘못 입력받았으면 아래거 진행하면 안됨
				continue;}
			if(!(0<=num2 && num2<=100)) {
				System.out.print("두번째 수를 입력해주세요"); num2=sc.nextInt();
				continue;}
			if(!(oper=='+'||oper=='-'||oper=='*'||oper=='/')) {
				System.out.print("연산자를 입력해주세요"); oper = sc.next().charAt(0); continue;
			}
			sc.close();
			
			break;
		}
		
		if(oper=='+') {result=num+num2;}
		else if(oper=='-'){result=num-num2;}
		else if(oper=='*'){result=num*num2;}
		else if(oper=='/'){result=num/(double)num2;}
		System.out.println(""+num+oper+num2+"="+(oper!='/' ? ""+(int)result: String.format("%.2f", result)));

	}//end main
}
/*
1)  각 연산자에 맞게 계산처리
2)  숫자1, 숫자2는 0~100사이만 입력가능하게 아니면 무한반복
3)  연산자는 +, - ,*, /만 입력가능하게 아니면 무한반복
     

1. 정수를 하나 입력해주세요 > 10
2. 정수를 하나 입력해주세요 > 3
3. 연산자를 입력해주세요(+,-,*,/) > +
10+3=13
*/
