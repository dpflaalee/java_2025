package com.company.javaPart002;
class Sawon005{
  int pay=1000;
  static int su = 10;
 // static int basicpay=pay;// 클래스 변수가 인스턴스 변수를 사용할 수 없음
  static int basicpay2;
  static{basicpay2=20000;}

  public static void showSu(){System.out.println(su);}
  //public static void showPay(){System.out.println(this.pay);} //static 함수에서는 static 멤버만 접근 가능
  public void showAll001(){
    System.out.println(su);
    System.out.println(this.pay);
  }
  public void showAll002(){
    showAll001();
    System.out.println(this.pay);
  }
}
public class Test003 {
  public static void main(String[] args) {
    Sawon005 sola = new Sawon005();
    sola.showAll001();
  }
}
