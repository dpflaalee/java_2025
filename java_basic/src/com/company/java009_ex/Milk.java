package com.company.java009_ex;
//public(아무데서나) > protected(extends) > package(같은폴더) > private(클래스내)
public class Milk {
	   private int  mno;   
	   private String mname;  
	   private  int mprice;
	public int getMno() {return mno;}
	public void setMno(int mno) {this.mno = mno;	}
	public String getMname() {return mname;	}
	public void setMname(String mname) {this.mname = mname;}
	public int getMprice() {return mprice;}
	public void setMprice(int mprice) {this.mprice = mprice;}
	@Override
	public String toString() {
		return "Milk [mno=" + mno + ", mname=" + mname + ", mprice=" + mprice + "]";
	}  
	   
//	   getters setters 세팅 후 to string
//	   public int getMno() {return mno;}
//	   public String getMname() {return mname;}
//	   public int getMprice() {return mprice;}

}
