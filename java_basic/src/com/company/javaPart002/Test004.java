package com.company.javaPart002;
class User4{
  final char division;
  final String jumin;
//  public final void User004(){}
  public User4(char division,  String jumin) {this.division=division; this.jumin=jumin;}
  public User4() {
	  division='A';
	  jumin="123456-1234567";
  }
  @Override public String toString() { return "User4 [division=" + division + ", jumin=" + jumin + "]"; }
  
  
}
public class Test004 {
  public static void main(String[] args) {
    User4 c1 = new User4('B',"200101-2134567");
    System.out.println(c1);
    User4 c2 = new User4();
    System.out.println(c2);
  }
}
