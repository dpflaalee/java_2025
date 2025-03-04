package com.company.java009;

//class Cat2{}
// The type Cat2 is already defined Modifier2_protected.java파일에서 작성함
//package - default - 기본 - 같은폴더에서 사용가능 - 같은 패키지 안에 들어가있어서 그냥 사용가능

public class Modifier3_package {
	public static void main(String[] args) {
		Cat2 cat2 = new Cat2();
		cat2.show();
		cat2.public_ = 200;
		//cat2.protected_=20; //extends 사용한 Cat2에서만 사용가능
		//cat2.package_=300; //같은 폴더내에서 사용가능
		//cat2.private_=400; //getters+setters
		cat2.show();
	}
}
