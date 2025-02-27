package com.company.java008_ex;

import java.util.Scanner;

class MyPrice001{
	String name; int price;
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품명을 입력하세요:"); this.name = sc.next();
		System.out.print("상품가격을 입력하세요:"); this.price = sc.nextInt();
		sc.close();
	} //입력받는 기능
	void show() {
		System.out.println("상품정보입니다.");
		System.out.println("상품이름:"+this.name+"\t/\t"+"상품가격:"+this.price);
	} //출력받는 기능
}

public class ClassEx002 {

	public static void main(String[] args) {
		MyPrice001 p1 = new MyPrice001();
		p1.input();
		p1.show();
	}
}
/*
A1 a= new A1()
---------------------------------------------------------------[runtime data area]
[method: 정보, static, final :: 공용정보] MyPrice001.class, public ClassEx002.class
---------------------------------------------------------------
[heap:동적 영역]					|[stack:잠깐 빌리기]
24번								p1.show();   1번지 p1.show();{ }
23번{ this.name, this.price }	p1.input();   1번지 p1.input();{ }
1번지{ name=null, price=0 }		←p1:1번지
								| main
---------------------------------------------------------------

*/





/*
class MyPrice001{
  멤버변수 : String name;  int price;
  멤버함수 : void input()  입력받는 기능 / void show()  출력해주는 기능
}
public class ClassEx002{
   public static void main(String[] args) {
        MyPrice001   p1 = new MyPrice001();
        p1.input();
        p1.show();
   }
}
출력내용 : 
  상품이름 입력 >  apple
  상품가격 출력 >  1500

  상품정보입니다
  상품이름 : apple  / 상품가격 : 1500*/