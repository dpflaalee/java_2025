package com.company.java010;

class A{
	private String name;
	
	public A() { super(); }

	public A(String name) { super(); this.name = name; }

	@Override public String toString() { return "A [name=" + name + "]"; }

	public String getName() { return name; }  public void setName(String name) { this.name = name; }
}
public class Repeat0306_2 {
	public static void main(String[] args) {
		A[]arr=new A[3];
		arr[0] = new A(); arr[1]=new A(); arr[2]=new A();
		//System.out.println(Arrays.toString(arr));
		for(A a : arr) {System.out.println(a);}
	}
}
/*출력화면 
A[name = null]
A[name = null]
A[name = null]*/

