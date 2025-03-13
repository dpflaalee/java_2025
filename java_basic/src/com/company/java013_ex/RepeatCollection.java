package com.company.java013_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Info{
	private int no;
	private String name;
	private int age;
	public Info() { super(); }
	public Info(int no, String name, int age) { super(); this.no = no; this.name = name; this.age = age; }
	@Override public String toString() { return "Info [no=" + no + ", name=" + name + ", age=" + age + "]"; }
	
	public int getNo() { return no; } public void setNo(int no) { this.no = no; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getAge() { return age; } public void setAge(int age) { this.age = age; }
	
}
public class RepeatCollection {
	public static void main(String[] args) {
		List<Info> info = new ArrayList<>();
		info.add(new Info(1,"iron",45));
		info.add(new Info(2,"hulk",38));
		info.add(new Info(3,"captain",120));
		
		Iterator<Info> iter1 = info.iterator();
		System.out.println("======================\n"
				+ "NO	NAME	AGE\n"
				+ "======================");
		int total = 0;
		while(iter1.hasNext()) {
			Info temp = iter1.next();
			total +=temp.getAge();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getAge());
		}
		System.out.println("총나이 :"+total);
		System.out.println("평균나이 :"+total/info.size());
		
		///////////////////////////////////////
		Set<Info> set = new HashSet<>();
		set.add(new Info(1,"iron",45));
		set.add(new Info(2,"hulk",38));
		set.add(new Info(3,"captain",120));
		
		/////////////
		HashMap<Integer ,Info>map = new HashMap<>();
		
		
	}
}
/*
Q7.  ArrayList
 		 * 	 dto 를 이용하여 ArrayList + Iterator  이용해서 만들기  

Q8.   HashSet
		 *   dto 를 이용하여 HashSet   + Iterator  이용해서 만들기  

Q9.   HashMap
		 *   dto 를 이용하여 HashMap   + Iterator  이용해서 만들기  
		 
		 ㅁ 출력된결과
		 ======================
		 NO	NAME	AGE
		 ======================
		 1	iron		45
		 2	hulk		38
		 3	captain	120
		 
		 나이총합 : 203
		 나이평균 : 67.67
*/