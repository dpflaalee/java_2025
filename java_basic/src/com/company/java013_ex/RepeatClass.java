package com.company.java013_ex;
class Milk{
	 private String name;
	 private int price;
	public Milk() { super(); }
	public Milk(String name, int price) {
		super(); this.name = name; this.price = price;
	}
	
	@Override public String toString() { return "Milk [name=" + name + ", price=" + price + "]"; }
	
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getPrice() { return price; } public void setPrice(int price) { this.price = price; }
	 
}
public class RepeatClass {
	public static void main(String[] args) {
		Milk m1 = new Milk("choco" , 1200);
		System.out.println( m1 );  // 출력된 결과 : choco / 1200
		Milk m2 = new Milk();
		System.out.println( m2 );  // 출력된 결과 : white / 1300
	}
}
/*
1) 멤버변수    private  name이름 ,  private  price가격      
				2) 생성자      기본생성자 : 
						   필드생성자 : 이름,  , 가격을 입력받아 처리해주는 생성자	
				3) 멤버함수  ---
*/