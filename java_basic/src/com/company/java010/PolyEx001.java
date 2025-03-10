package com.company.java010;
/*
	Object
	↑
	Papa { int money=10000; / void sing "GOD-거짓말" }
	↑
	Son { int money=1500; / void sing "빅뱅-거짓말" }
*/
class Papa extends Object{  
	   int money = 10000;     
	   public Papa() { super(); }
	   public void sing() {  System.out.println("GOD-거짓말");  }
	}// end class

class Son extends Papa{ 
	   int money = 1500;
	   public Son() { super(); }
	   @Override public void sing() {  System.out.println("빅뱅-거짓말"); }
	} // end class

public class PolyEx001 {
	public static void main(String[] args) {
		
	      Papa mypapa = new Son();    
	      // Q3. Papa mypapa 의미?{ int money=10000; / void sing "GOD-거짓말" }
	      // Q4. 인스턴스화한 실제 메모리 빌려온그림 
	      //{int money=1500; / void sing "빅뱅-거짓말"}-{int money=10000;/-----}
	      
	      
	      System.out.println(mypapa.money); // Q5.  출력   
	      mypapa.sing();  //Q6. 출력 
	       //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.  
	      System.out.println(((Son)mypapa).money );
	      
	}
}
