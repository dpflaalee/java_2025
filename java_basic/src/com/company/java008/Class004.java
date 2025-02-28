package com.company.java008;

class Product{
	String name;
	int price;
	
	//alt shift s (밑에서 3번)
	public Product(String name, int price) { super(); this.name = name; this.price = price;	}
	//alt shift s (밑에서 2번)
	public Product() { //super();
		System.out.println("수동생성시 컴파일러 자동생성 취소");} //String = null int 0
	//alt shift s (밑에서 4번)
	@Override
	public String toString() {	return "Product [name=" + name + ", price=" + price + "]"; }
}	//@Override Product(자식클래스)에 맞게 수정-값 출력

public class Class004 {
	public static void main(String[] args) {
		Product p1 = new Product(); // 3번한상태에서 선언하면 오류 2번까지 해야 오류 사라짐
		System.out.println(p1);
	}
}	
/*
------------------------------- runtime 
[method: 정보, static, final] 		Product.class / Class004.class  ##1
-----------------------------------------------------------------
[heap:동적]							| [stack:지역]
1번지{ name=null, price=0 }     		 ← P1 : 1번지    생성자가 하는일 
									| main ##2	
-----------------------------------------------------------------
*/