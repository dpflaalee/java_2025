package com.company.java008;

class Farm{
	//멤버변수
	String name; // 인스턴스변수 - heap area - new O - this.name
	int age;	 // 인스턴스변수 - heap area - new O - this.age
	static String FarmName="(주)동물농장";  //클래스변수 - method area = new x
	static int num=10; 					//클래스변수 - method area = new x
	
	//멤버함수
	static void num_plus(){num++; /*age++;-->static 아니라 안됨*/}
	
	void show() {
		System.out.println("\n\n::::::::::::::::::");
		System.out.println("::회사명:"+Farm.FarmName);
		System.out.println("::식구수:"+Farm.num);
		System.out.println("::이 름:"+this.name);
		System.out.println("::나 이:"+age);			}
	
}//end farm

public class Class005_Static {
	public static void main(String[] args) {
		System.out.println("Step1. 클래스 변수-static"); Farm.num_plus();
		System.out.println("회사명>"+Farm.FarmName);
		System.out.println("식구수>"+Farm.num);
		//System.out.println("인스턴트명>"+Farm.name); //오류! new 선언해야함

		
		System.out.println("\n\nStep1. 인스턴스 변수-this-각각"); 
		Farm cat = new Farm();
		cat.name = "siru"; cat.age=10; cat.show();
		//cat.FarmName=""; cat.num=11; cat.nem+plus(); // warning & error 이영역에서 접근하면 안됨
		
		Farm dog = new Farm();
		dog.name = "zzang"; dog.age=13; dog.show();
	}
}
/*
------------------------------- runtime 
[method:정보, static, final]		
#1 Farm.class / Class005_Static.class / Farm. Farmname[(주)동물농장], Farm.num[10], Farm.num_plus()
---------------------------------------------
[heap]               | [stack]
1번지 {name=siru, age 11}		1번지
2번지 {name=zzang, age 13}	2번지
					 |#2 main
---------------------------------------------
*/