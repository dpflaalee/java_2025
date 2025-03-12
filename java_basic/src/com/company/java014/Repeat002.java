package com.company.java014;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Milk{
	private int no;
	private String name;
	private int price;
	public Milk() { super(); } public Milk(int no, String name, int price) { super(); this.no = no; this.name = name; this.price = price; }
	@Override public String toString() { return "Milk [no=" + no + ", name=" + name + ", price=" + price + "]"; }
	public int getNo() { return no; } public void setNo(int no) { this.no = no; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getPrice() { return price; } public void setPrice(int price) { this.price = price; }
	
	@Override
	public int hashCode() {
		return Objects.hash(name, no, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return Objects.equals(name, other.name) && no == other.no && price == other.price;
	}//hashcode adn equals
	
	
	
}
public class Repeat002 {
	public static void main(String[] args) {
		List<Milk> list = new ArrayList<Milk>();
		list.add(new Milk(1, "white", 1000));
		list.add(new Milk(2, "chock", 1200));
		list.add(new Milk(3, "banana", 1300));
		
		Iterator<Milk> iter1 = list.iterator();
		while(iter1.hasNext()) { // 처리대상 확인
			Milk temp = iter1.next(); // 꺼내오기
			System.out.println(temp.getNo()+"/"+temp.getName()+"/"+temp.getPrice());
		}
		
		//////////////////////////
		Set<Milk> set = new HashSet<Milk>();
		set.add(new Milk(1, "white", 1000)); //new Milk heap area
		set.add(new Milk(2, "chock", 1200)); // add 주소값
		set.add(new Milk(3, "banana", 1300));// 1.hashCode(Milk) 2 equals
		set.add(new Milk(3, "banana", 1300)); //3개 
		System.out.println(set.size());
		
		Iterator<Milk> iter2 = set.iterator();//모으기
		while(iter2.hasNext()) { // 처리대상 확인
			Milk temp = iter2.next(); // 꺼내오기
			System.out.println(temp.getNo()+"/"+temp.getName()+"/"+temp.getPrice());}
		
		Map<Integer, Milk> map1 = new HashMap<>();
		map1.put(1, new Milk(1,"white", 1000)); // Integer i = 1; Wrapper - Boxing
		// key = Integer i = 1 
		// value : Milk milk = new Milk(1,"white",1000);
		map1.put(2, new Milk(2, "chock", 1200));
		map1.put(3, new Milk(3, "banana", 1300));
		
		System.out.println(map1.entrySet());
		Iterator<Entry <Integer, Milk>> iter3 = map1.entrySet().iterator();
		while(iter3.hasNext()) {
			Entry<Integer, Milk> key_value = iter3.next();
			System.out.println(key_value.getKey());
			System.out.println(key_value.getValue());
			Milk temp = key_value.getValue();
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		
		
	}
}
