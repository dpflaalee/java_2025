package com.company.java009;

import com.company.java009_ex.Cat;

class Cat2 extends Cat{ //cat2 : java009 | cat : java009_ex
	public void show(){
		public_=10;
		protected_=20; // extends 사용가능
		//package_=30; //같은폴더에서 사용가능
		//private_=40; // Cat 클래스에서만 사용 가능 - getter/setter
		
		System.out.println(public_+"/"+protected_);
	}
	
}//extends Cat의 기능 사용[상속]

public class Modifier2_protected {
	public static void main(String[] args) {
		Cat2 cat2 = new Cat2();
		cat2.show();
		cat2.public_ = 100;
		//cat2.protected_=200; // extends(상속)키워드를 받지 않아 사용 불가능 근데... cat2에서는 사용가능한데 여기서는 사용불가
	}
}
/*

-------------------------------------
[method:정보]   Cat2.class   , Modifier2_protected.class}  //##1
-------------------------------------
[heap]                       | [stack]
1번지 : {nation, jumin,name }
                         |  main  //##2
-------------------------------------

*/