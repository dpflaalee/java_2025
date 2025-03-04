package com.company.java009;

import com.company.java009_ex.Cat;

public class Modifier1_public_private {
	public static void main(String[]args) {
		Cat cat = new Cat();
		cat.public_=10; 
		//cat.protexted_ 안보임 The field Cat.protected_ is not visible
		//cat.package_ 안보임 The field Cat.package_ is not visible
		//cat.private_ 안보임 The field Cat.private_ is not visible
		cat.setPrivate_(100); 
		System.out.println(cat.public_+"/"+cat.getPrivate_());
		//Private 은 getter+setter을 이용
	}
}
