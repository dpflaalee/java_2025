package com.company.java011;
abstract class Shape002{
	abstract void showArea(int w, int h);
	abstract void showArea(int r);
}

class Rectangle002 extends Shape002{
	@Override void showArea(int w, int h) {System.out.println("사각형의 넓이:" + w*h);}
	@Override void showArea(int r) {}
	}

class Triangle002 extends Shape002{
	@Override void showArea(int w, int h) {System.out.println("삼각형의 넓이:" + w*h/2);  }
	@Override void showArea(int r) {}
	}

class Circle002 extends Shape002{
	@Override void showArea(int w, int h) {}
	@Override void showArea(int r) {System.out.println( "원의 넓이:"+ r*r*3.1415965 );		
	}										}

public class Abstract002 {
	public static void main(String[] args) {		
//		Rectangle002 rec = new Rectangle002();
//		rec.showArea(10,10);
//		
//		Triangle002 tri = new Triangle002();
//		tri.showArea(10,10);
//		
//		Circle002 cir = new Circle002();
//		cir.showArea(10);
		
		Shape002 shape = null;
		
		shape = new Rectangle002();
		shape.showArea(10,10); //ver1. abstract 클래스 null로 정의 시 생략가능
		
		//ver2
		//instanceof 어떤 클래스의 종류인지? >> 객체가 어떤클래스인지 어떤 클래스를 상속받았는지 확인
		Shape002 [] s = {new Rectangle002(), new Triangle002(), new Circle002()};
		//Circle ? shape.showArea(r)
		for (int i=0; i<s.length; i++) {
			if(	s[i] instanceof Circle002 ) {s[i].showArea(10);}
			else{s[i].showArea(10,3);}
		}

	}
}
