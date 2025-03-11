package com.company.javaPart002;
class A1 extends Object{
  int a;
  public A1(){super();}
  public A1(int a){super(); this.a=a;}
}
class B1 extends A1{
  int b;
  public B1(){super();}
  public B1(int b){this.b=b;}
  public B1(int a, int b){super(a); this.b=b;}
}
class C1 extends B1{
  int c;
  public void showC(){
    System.out.println("상속받은 A클래스의 a:"+a); //10
    System.out.println("상속받은 B클래스의 b:"+b); //20 
    System.out.println("상속받은 C클래스의 c:"+c); //30
  }
}

public class Test006 {
  //Q1) 여러 객체를 하나의 타입으로 관리할 수 있어 유지 보수에 용이하기 때문이다.
  //Q2) public 클래스명 extends 상위클래스명{}
  public static void main(String[] args) {
    C1 myc= new C1();
    myc.a=10; myc.b=20; myc.c=30; myc.showC();
  }
}
