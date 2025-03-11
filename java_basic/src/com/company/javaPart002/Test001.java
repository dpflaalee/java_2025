package com.company.javaPart002;
class Coffee2{
  String name = ""; int num, price;
  
  public Coffee2(String name, int num, int price) {
    super();
    this.name = name;
    this.num = num;
    this.price = price;
  }
  public Coffee2(){name="아메리카노"; num=1; price=2000;}
  @Override
  public String toString() {
    return "Coffee2 [name=" + name + ", num=" + num + ", price=" + price + "]";
  }
  void show(){
    System.out.println("=====커피");
    System.out.println("커피명"+name);
    System.out.println("커피잔수:"+num);
    System.out.println("커피가격"+price);
  }
}

public class Test001 {
  public static void main(String[] args) {
    Coffee2 a1 = new Coffee2("카페라떼", 2, 4000);
    a1.show();
    Coffee2 a2 = new Coffee2();
    a2.show();
  }
}
/*
 * =====커피
 * 커피명:카페라떼
 * 커피가격:4000
 * =====커피
 * 커피명:아메리카노
 * 커피잔수:1
 * 커피가격:2000
 * 
 */