package com.company.java008_ex;

class Sawon3{
	/*1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
	  2. 인스턴스메서드, 클래스메서드 구분하시오.
	  3. 오류나는 이유는?*/
//	int pay = 1000;
//	static int su=10; 
//	static int basicpay=pay; 
//	static int basicpay2; 
//	
//	public static void showSu() {   System.out.println(su);  }   
//	public static void showPay() {   System.out.println(this.pay);  }    
//	
//    public  void  showAll001() {   
//        System.out.println(su);  
//        System.out.println(this.pay);       }
//    
//     public static  void  showAll002() {   
//         showAll001();    
//        System.out.println(this.pay);     }
//	
}//end Sawon3

public class ClassEx010 {
	public static void main(String[] args) {
		Sawon3   sola = new Sawon3();  
//		sola.showAll001();
	}//end main
}//end class