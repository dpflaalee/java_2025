package com.company.java014;
class RefClass{void method(String str){System.out.println(str);}}
interface InterUsing{void inter(RefClass c, String str);}
public class Lambda003 {
	public static void main(String[] args) {
		//1. 익명클래스
		InterUsing a1 = new InterUsing() {
			@Override public void inter(RefClass c, String str) {
				c.method(str);
			}
		}; 
		// RefClass c = new RefClass() , String str ="Hello:)"
		a1.inter(new RefClass(), "Hello:)");
		
		//2. 람다
		InterUsing a2 = (RefClass c, String str)->{c.method(str);};
	
		//3. :: 표현식(강조)
		InterUsing a3 = RefClass :: method;
		a3.inter(new RefClass(), "Hellow");
		
		//3 interface InterBasic {int method(int a, int b}
		InterBasic basic2 = (a, b) -> Math.max(a, b);
		System.out.println(basic2.method(10, 3));
		
		InterBasic basic3 = Math::max;
		System.out.println(basic3.method(10, 3));
		
		//Ex3 아래식을 ::바꾸기 
		InterEx1 ex1 = str -> str.length();
		System.out.println(ex1.method("ABC"));
		
		InterEx1 ex12 = String::length; // String 클래스의 length()사용
		System.out.println(ex12.method("ABC"));
		
		//Ex4 아래식을 ::바꾸기
		InterEx2 ex2 = num ->System.out.println(num);
		ex2.method(100);
		
		InterEx2 ex22  = System.out::println; // System.out의 println() 사용
		ex22.method(100);
		
		
	}
}
interface InterBasic{int method(int a, int b);}
interface InterEx1{int method(String str);}
interface InterEx2{void method(int num);}