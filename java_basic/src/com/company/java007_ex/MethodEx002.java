package com.company.java007_ex;

public class MethodEx002 {
	
	
	public static void test1(int a) { System.out.println(a);}
	public static void test2(double b) { System.out.println(b);}
	public static void hap(int a, int b) { 
		System.out.println(a+(a+=1)+b);
		//int box=0; for(int i=a; i<=b; i++) {box+=i;} System.out.println(box);
	}
	public static void disp(int a, char b) {for(int i=1; i<=a; i++) {System.out.print(b);}}
	
	public static void main(String[] args) {
		test1(10);
		test2(1.2);
		hap(3,5);
		disp(7,'*');
	}
}
/*다음과 같이 test1(), test2(), hap(), disp()메서드를 정의하시오.

public static void main(String[] args) {
    // public static  리턴값 메서드명(파라미터)
    test1(10);    //10 출력
     test2(1.2);   // 1.2 출력
     hap(3,5);     // 3+4+5한값  12 출력
     disp(7, '*');  // *******출력*/