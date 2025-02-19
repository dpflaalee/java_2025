package com.company.java003;

import java.util.Scanner;

public class Operator001 {
	public static void main(String[]args) {
//		   ( )   +-*/%   <<,>>(쉬프트 연산자)   	<,,<=.>=,==,!=		&& || ?:		=,+=
		
		int a= 10, b=3;
		
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println(a/b);
		System.out.println(a%b);
		
		// Q1. 나머지 연산자-짝수 홀수 판별 :: 2로 나눠서 나머지가 0
		System.out.println( 0%2 + " " + 1%2 + " " + 2%2 );
		
		// Q2. 3의 배수 :: 3으로 나눠서 나머지가 0인 값
		System.out.println( 1%3 + " " + 2%3 + " " + 3%3 );
		
		//2. 비교( == , != , < , > , <= , >= )
//		System.out.println(10>3); //true
//		System.out.println(10<3); //false
		
		System.out.println( a%2 == 0 ); //짝수 판별
		System.out.println( a%2 == 1 ); //홀수 판별
		
		System.out.println( b%3 == 0 ); //n의 배수 판별

		//3. 조건( & , &&(and) , | , ||(or) )
//		System.out.println( true & true );
//		System.out.println( true && true );
		System.out.println( false & true ); // 앞-뒤를 다 읽고 결과를 냄
		System.out.println( false && true ); //Dead code 앞쪽에서 false가 뜨면 코드 안읽음 &&연산자를 더 추천
	
		System.out.println( true | true );
		System.out.println( true || true ); //Dead code
		System.out.println( false | true ); 
		System.out.println( false || true );
		
		//4. (조건)? 참:거짓 ==> 삼항연산자
		System.out.println((a>b)? "a>b" : "a<b");
		System.out.println((3%2==0)? "짝수" : "홀수");
				
		// Q1. 2의 배수이면서 5의 배수라면 true/false
		int num = 6;
		System.out.println(num%2==0 && num%5==0);
		
		// Q2. 2의 배수이거나 3의 배수라면 true/false
		System.out.println( num%2==0 || num%3==0 );
		
		// Q3. 숫자를 입력받아 0보타 크면 양수, 0보다 작으면 음수, 아니라면 0
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 :");
		num1=sc.nextInt();
		System.out.println( (num1>0)? "양수" : (num1<0)? "음수" : "0" );
		
		
		//5. 대입 값 > 비교조건 > 대입 :: ( += , -= , *= , /= , %= )
		
		//6. ++ -- (단항 연산자)
		int n1=1 , n2=1, n3=1, n4=1;
		System.out.println(++n1);	//2: 증가 후 출력
		System.out.println(n1);		//2
		
		System.out.println(n2++);	//1 : n2 출력 후 증가
		System.out.println(n2);		//2  
		
		System.out.println(--n3);	//0 : 참조하여 감소>출력
		System.out.println(n3);
		
		System.out.println(n4--);	//1 : 참조하지 않고 출력>감소
		System.out.println(n1);

		
		
		sc.close();
	}
}