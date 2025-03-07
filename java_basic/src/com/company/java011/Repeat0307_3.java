package com.company.java011;

import java.util.Arrays;

abstract class Fruit{
	@Override public String toString() {
		return "Fruit";}
	public abstract void myfruit();
}
class Apple extends Fruit{
	String point = "빨갛다";
	@Override public String toString() {return "사과는 "+point;}
	@Override public void myfruit() { System.out.println();  }
}
class Banana extends Fruit{
	String point = "노랗다";
	@Override public String toString() {return "바나나는 "+point;}
	@Override public void myfruit() { System.out.println();  }
	
}
class Coconut extends Fruit{
	String point = "코코하다";
	@Override public String toString() {return "코코넛은 "+point;}
	@Override public void myfruit() { System.out.println();  }
	
}
public class Repeat0307_3 {
	public static void main(String[] args) {
		Fruit[]fruits= {new Apple(), new Banana(), new Coconut()};
		System.out.println(Arrays.toString(fruits));
	}
}
//사과는 빨갛다 바나나는 노랗다 코코넛은 코코하다