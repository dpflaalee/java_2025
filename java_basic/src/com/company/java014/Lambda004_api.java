package com.company.java014;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

//API 함수형 인터페이스
public class Lambda004_api {
	public static void main(String[] args) {
		//#1 Consumer<T>받는 용도
		//void java.util.function.Consumer.accept ( T t )
		//()->{} // 파라미터 O 리턴 X
		Consumer<String> comsumer=(t)->{System.out.println("Hello"+t);};
		Consumer<String> comsumer2 = System.out::println;
		
		comsumer.accept("sally");
		comsumer2.accept("siru");

		
		//Supplier 제공 용도 get
		//T java.util.function.Supplier.get ()
		//()->{} // 파라미터 X 리턴 O 
		Supplier <String> supplier = ()->{return "Hello";};
		Supplier <String> supplier2 = ()->"Hello";
		
		System.out.println(supplier.get());
		System.out.println(supplier2.get());
		
		
		//Predicate 판단용도 test
		// boolean java.util.function.Predicate.test ( T t )
		//파라미터 O 리턴 O
		//Predicate<Integer>predicate=(t)->{return t<0;}; //음수인지 양수인지 판단
		Predicate<Integer>predicate= t -> t<0;
		System.out.println(predicate.test(-1));
		System.out.println(predicate.test(1));
		
		//4. Function - 처리 용도 - apply
//		R java.util.function.Function.apply ( T t )
		//파라미터 O 리턴값...O
//		Function<String, Integer>function=(t)->{return Integer.parseInt(t);}; 
		Function<String, Integer>function=Integer::parseInt; 
		System.out.println(function.apply("10")+3); // 문자열을 Integer.parseInt()
		
		
		//5. Operator - 연산 용도 - apply
//		int java.util.function.IntBinaryOperator.applyAsInt ( int left,  int right )
		//파라미터 O 리턴값 O
		//IntBinaryOperator operator=(left, right)->{return left>right? left : right ;};
		IntBinaryOperator operator=(left, right)-> left>right ? left : right;
		System.out.println(operator.applyAsInt(10,3)); //큰값 리턴
		
		
		
	}
}
/*
1. Consumer - 받는 용도 - accept
2. Supplier - 제공 용도 - get
3. Predicate - 판단하는 용도 - test
4. Function - 처리 용도 - apply
5. Operator - 연산 용도 - apply
*/