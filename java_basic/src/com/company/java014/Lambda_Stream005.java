package com.company.java014;

import java.util.Arrays;
import java.util.List;

public class Lambda_Stream005 {
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(arr);
		
//		Arrays.stream(arr).forEach((t)->{System.out.println(t);});
		Arrays.stream(arr).forEach(System.out::println);
							//Consumer <? super Integer> action
		//Consumer <? super Integer> action; //Integer 포함 부모
		//Consumer <Integer> action; //Consumer <Number> action;
//		void java.until.function.Consumer.accept(T t)
		// 파라미터 O 리턴 X
		list.stream();
		
		
	}
}
