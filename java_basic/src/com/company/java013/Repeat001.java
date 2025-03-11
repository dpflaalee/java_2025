package com.company.java013;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class UserIn{
	private String name;
	private int age;
	@Override public String toString() { return "UserInfo [name=" + name + ", age=" + age + "]"; }
	public UserIn(String name, int age) { super(); this.name = name; this.age = age; }
	public UserIn() { super(); }
	
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getAge() { return age; } public void setAge(int age) { this.age = age; }	
}

public class Repeat001 {
	public static void main(String[] args) {
//		2. users ArrayList 만들기
		ArrayList<UserIn> users = new ArrayList();
		users.add(new UserIn("아이언맨" , 50));
		users.add(new UserIn("헐크" , 40));
		users.add(new UserIn("캡틴" , 120));
//		3. 다음의 데이터 넣기
//		   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
//		4. for+size / 향상된 for 이용해서 데이터 출력
		for (UserIn u : users) {System.out.println(u.getName()+"/"+u.getAge());}
		
		HashSet<UserIn> sets = new HashSet<>();
		sets.add(new UserIn("아이언맨", 50));
		sets.add(new UserIn("헐크" , 40));
		sets.add(new UserIn("캡틴" , 120));
		
		for (UserIn s : sets) {System.out.println(s.getName()+"/"+s.getAge());}
		
		//1 set 모으기 iterator / 2 처리대상 확인 hasNext / 꺼내오기 next
		Iterator<UserIn> iter = sets.iterator();
		while(iter.hasNext()) {} 
	}
}
/*
Q1.   다음 빈칸을 채우시오
1. 콜렉션프레임워크
- [     ##1.배열   ]의 단점을 개선한 클래스 [##2.객체-클래스 ]만 저장가능   ( 동적배열 )
- 저장공간의 크기를 [##3. 동적  ]으로 관리함.

2. 핵심 인터페이스 [##4. list set map     ]
- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
  다양한 컬렉션 클래스를 이용함.

  List : ##5.   기차      인덱스여부 [ O ] ,  중복허용여부 [ O ] ,  [ add get size remove contains ] 
  Set  : ##6.   주머니   인덱스여부  [ X ] ,  중복허용여부  [ X ]  ,   [ add for size remove contains ] 
  Map  : ##7.   사전      [ key ] - 쌍(Entry),        [ put get for size remove contains ] 

Q2.  ArrayList, HashSet 을 작성하시오.
1. UserInfo    Dto 클래스만들기    - 속성 :  private  String name; private  int age;
2. users ArrayList 만들기
3. 다음의 데이터 넣기
   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
4. for+size / 향상된 for 이용해서 데이터 출력
 

5. sets  HashSet 만들기
6. 다음의 데이터 넣기
   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
7. for+size / 향상된 for 이용해서 데이터 출력
*/