package com.company.java013;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MapEx001 {
	public static void main(String[] args) {
		Map<String, String> pigu = new HashMap<>();
		pigu.put("피구왕","통키");
		pigu.put("제빵왕","김탁구");
		pigu.put("요리왕","비룡");

		Iterator <Entry<String, String>> iter =pigu.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, String> temp = iter.next();
			System.out.println(temp.getKey()+ ""+temp.getValue());
			System.out.println("---------------------");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("KING의 정보를 제공중입다");
		System.out.print("이름을 입력하세요>"); String name = sc.next();
		System.out.println(name+":"+pigu.get(name));
		
	}
}
/*
1. MAP 만들기
KEY   VALUE
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡

Map<String, String> map = new HashMap<>();

2 다음과 같이 문제풀기
==============================
KING   NAME
==============================
피구왕   통키
---------------------
제빵왕   김탁구
---------------------
요리왕   비룡
---------------------
KING의 정보를 제공중입니다
이름을 입력하세요> 제빵왕

ㅁ제빵왕 : 김탁구
*/