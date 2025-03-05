package com.company.java010;
class Color{
	private String name;
	public String getName() { return name; }  public void setName(String name) { this.name = name; }
	
}
class Green extends Color{
	private int num;
	public int getNum() { return num; }  public void setNum(int num) { this.num = num; }

	void show() {
		System.out.println(":::::GREEN\n"+"= NAME:"+super.getName()+"\n= NUM:"+this.num);
	}
	}
public class Extends002 {
	public static void main(String[] args) {
		Green mygreen = new Green();
		mygreen.setName("LIGHT_GREEN");
		mygreen.setNum(5);
		mygreen.show();
	}
}
