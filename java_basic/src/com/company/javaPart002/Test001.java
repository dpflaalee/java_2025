package com.company.javaPart002;
class Coffee2{
  String name; int num, price;
  
  public Coffee2(String name, int num, int price) {
    super(); this.name = name; this.num = num; this.price = price;  }
  
  public Coffee2(){name="아메리카노"; num=1; price=2000;} //defult 생성자 : 1) 생성자 오버로딩 2) 상속 
  @Override
  public String toString() {
    return "Coffee2 [name=" + name + ", num=" + num + ", price=" + price + "]";  }
  
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
/**************
Repeat001.java                   <  javac Repeat001.java
Coffee.class , Repeat001.class   <  java  Repeat001 
------------------------------------------------------------
[method]
[1번지]Coffee.class  
[2번지]Repeat001.class  ##1
------------------------------------------------------------
[heap]                                |       [stack]
[2000]번지                         <----[a2 | 2000번지]
{ name="아메리카노", num=1 , price=1500 }                                   
[1000]번지                         <----[a1 | 1000번지]
{  name="까페라떼", num=2, price=4000  }   [main          ]
------------------------------------------------------------
*/