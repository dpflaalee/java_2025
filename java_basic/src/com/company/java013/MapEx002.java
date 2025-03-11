package com.company.java013;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class UserInfo3{
	String name;	int score;
	public UserInfo3(String name, int score) { super(); this.name = name; this.score = score; }
	@Override
	public String toString() { return "UserInfo3 [name=" + name + ", score=" + score + "]"; }
	UserInfo3(){}
}
public class MapEx002 {
	public static void main(String[] args) {
//		Map <String, Integer> map = new HashMap<>();
//		map.put(1,  new UserInfo3("아이언맨",50));
//		map.put(2,  new UserInfo3("헐크", 40));
//		map.put(3,  new UserInfo3("아이언맨", 50));
//		map.put(4,  new UserInfo3("아이언맨", 50));
//		
//		Integer e =1;
//		
//		//for (Integer key : map.keySet()) {System.out.println(key+"/"+map.get(key));}
//		for(Entry<Integer,UserInfo3)>m : map.entrySet()){
//			System.out.println(m.getKey()+map.getValue());		}
		
	}
}
/*
연습문제2)  Collection  Framework
패키지명 : com.company.java016_ex
클래스명 : MapEx002
Q1. HashMap만들기
Q2. 아래데이터 넣기
map.put(  1,  new UserInfo("아이언맨"    , 50) );  // 1 넣어도 Integer( 클래스, 객체 )
map.put(  2,  new UserInfo("헐크"       , 40) );  // wrapper 클래스
map.put(  3,  new UserInfo("캡틴"       , 120) ); // boxing
map.put(  1,  new UserInfo("아이언맨-new", 50) ); 

Q3. Iterator로 출력하기 - 사용자정보
*/