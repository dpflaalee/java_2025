package com.company.javaPart002;
class Papa extends Object{
  int money = 10000;
  public Papa(){super();}
  public void sing(){System.out.println("GOD-거짓말");}
}
class Son3 extends Papa{
  int money=1500;
  public Son3(){super();}
  @Override public void sing(){
    super.sing(); System.out.println("빅뱅-거짓말");
  }
}
public class Test007 {
  public static void main(String[] args) {
    Papa mypapa=new Son3();
    System.out.println(mypapa.money); // 10000
    mypapa.sing(); // 빅뱅
    System.out.println( ((Son3)mypapa).money);
  }
}
