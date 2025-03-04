/*
	1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
	2. 인스턴스메서드, 클래스메서드 구분하시오.
	3. 오류나는 이유는?
 */
package com.company.java009;

class Sawon3{ 
    int pay      =10000;    //인스턴스 변수 heap-new-this,생성자
    static int su=10;     	//클래스변수 method-newX 메모리상에 이미 올라감. 공유하는 목적
    //static int basicpay=pay; //클래스변수 안에 인스턴스 변수를 담을 수 없음 (클래스 변수, 클래스 메서드는 this, 인스턴스 사용불가)   
    static int basicpay2;   //클래스변수 

    
    public static void showSu() {   System.out.println(su);  } //클래스함수 method - newX          
    //public static void showPay() {   System.out.println(this.pay);  }  //클래스함수(static)에서 this, 인스턴스 사용불가
  
    public  void  showAll001() {//인스턴스변수 - heap - new - this,생성자   
       System.out.println(su);  
       System.out.println(this.pay);  
    } 
    public static  void  showAll002() {   //클래스함수 method - newX    
       //showAll001();    //인스턴스변수 사용불가 
       //System.out.println(this.pay); 
    } 
} 

public class MemberVarEx001 {
	  public static void main(String[] args) {//지역변수
		   Sawon3   sola = new Sawon3();  //지역변수
		   sola.showAll001();
		  }
		}
