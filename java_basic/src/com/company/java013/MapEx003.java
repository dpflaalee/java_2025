package com.company.java013;

import java.util.HashMap;
import java.util.Map;

class Fruit{
	private int no;
	private String name;
	
	public int getNo() { return no; } public void setNo(int no) { this.no = no; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	
	public Fruit(int no, String name) { super(); this.no = no; this.name = name; }
	public Fruit() { super(); }	

	@Override public String toString() { return "Fruit [no=" + no + ", name=" + name + "]"; }
	
//	@Override public int hashCode() {return Object.hash(name,no);}
//	@Override public boolean equals(Object obj) {
//		if(this==obj) return true;
//		if(obj==null) return false;
//		if(getClass()!=obj.getClass()) return false;
//		Fruit other = (Fruit) obj;
//		return Object.equals(name, other.name)&&no == other.no;
//	}
}

public class MapEx003 {
	public static void main(String[] args) {
		Map <Fruit, Integer> map = new HashMap<>(); // <Fruit> ==> int no / String name
	      map.put( new Fruit(1, "Apple")  , 1);
	      map.put( new Fruit(1, "Apple")  , 1);
	      map.put( new Fruit(2, "Banana") , 2);
	      
          System.out.println("Total : " + map.size());
          //System.out.println(map);

	}
}
/*
연습문제3)  Collection  Framework
패키지명 : com.company.java016_ex
클래스명 : MapEx003
1. HashMap만들고 필요한 속성을 추가하시오.
2. 갯수가 3개가 나오게 하시오
class Fruit{
   private int no;
   private String name;    
}

public class MapEx003 {
   public static void main(String[] args) {
      Map< Fruit, Integer > map = new HashMap<>();
      
      map.put( new Fruit(1, "Apple")  , 1);
      map.put( new Fruit(1, "Apple")  , 1);
      map.put( new Fruit(2, "Banana") , 2);
                           
                             System.out.println("Total : " + map.size());
             }
}

*/