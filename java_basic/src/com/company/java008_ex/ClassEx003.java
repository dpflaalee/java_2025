package com.company.java008_ex;

class Coffee{
	String name ; int price, num;
	
	public Coffee(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;	}
	
	public Coffee() {	name="아메리카노"; price = 2000; num=1;	}
		
	@Override
	public String toString() {
		return "Coffee [name=" + name + ", price=" + price + ", num=" + num + "]";		}
	
	void show() {
		System.out.println("=====커피");
		System.out.println("커피명:"+name+"\n커피잔수:"+num+"\n커피가격:"+(price*num));
	}//정보출력
}

public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("까페라떼" ,4000 , 2);  a1.show();
		Coffee a2 = new Coffee();                            
		a2.show();
	}
}
/*
	출력내용 :
=====커피
커피명 : 까페라떼
커피잔수 : 2 
커피가격 : 8000
=====커피
커피명 : 아메리카노
커피잔수 : 1
커피가격 : 2000
	*/