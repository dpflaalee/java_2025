package com.company.java013;

import java.util.ArrayList;

// Dto(데이터 전달 : 생성자, toString, getters setters )

class Milk{
	private int mno;
	private String name;
	private int mprice;
	@Override
	public String toString() {
		return "Milk [mno=" + mno + ", name=" + name + ", mprice=" + mprice + "]";
	}
	public Milk(int mno, String name, int mprice) { super(); this.mno = mno; this.name = name; this.mprice = mprice; }
	public Milk() { super(); }
	
	public int getMno() { return mno; } public void setMno(int mno) { this.mno = mno; }
	public String getName() { return name; } public void setName(String name) { this.name = name; } public int getMprice() { return mprice; } public void setMprice(int mprice) { this.mprice = mprice; }
	
}

public class Collection002 {
	public static void main(String[] args) {
		
		ArrayList<String> temp = new ArrayList<>();
		
		//milks.add(new )
		
		//for(Milk temp : milks) {
		//	System.out.println(temp.getMno()+"/"+temp.getName()+"/"+temp.getMprice());
		}
		
	}

