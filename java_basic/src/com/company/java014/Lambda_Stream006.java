package com.company.java014;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda_Stream006 {
	public static void main(String[] args) {
		//데이터 종류 상관없이 같은 방식으로 처리
		Integer[]arr= {1,2,5,3,1,2,4,3,5};
		List<Integer>list = Arrays.asList(arr);
		
		// stream
		Stream <Integer> stream_arr = Arrays.stream(arr);
		Stream<Integer> stream_list = list.stream();
		
		// 중간연산
		//boolean java.util.function.Predicate.test <T>
										//void java.util.function.Consumer.accept(T t)
		stream_arr.filter( t-> t%2!=0 ) //홀수 필터링
										.distinct() // 중복 제외
										.sorted() //정렬
										.skip(1) //1번째거 스킵
										.forEach((t)->{System.out.println(t);});  //최종연산
		
		System.out.println(); System.out.println();
		
		stream_list.filter( t-> t%2!=0 ) //홀수 필터링
		.distinct() // 중복 제외
		.sorted() //정렬
		.skip(1) //1번째거 스킵
		.forEach(System.out::println);  //최종연산
		
		//collect
		//System.out.println(stream_arr.collect(Collectors.toList())); // <? super Integer, Object, Boolean> collector
		//1회용
		System.out.println(Arrays.stream(arr).collect(Collectors.toList()));
		System.out.println(list.stream().collect(Collectors.toList()));
		
	}
}
