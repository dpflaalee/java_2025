package com.company.java010;
class MobileNote7{
	private String iris;
	public String getIris() { return iris; }  public void setIris(String iris) { this.iris = iris; }
	void newshow() {System.out.println("::::NOTE7새로운기능(Overriding)\n"+"= iris 홍채인식기능!\n"+"= myiris : "+iris);} 	
}
class MobileNote8 extends MobileNote7{
	private String face;
	public String getFace() { return face; }  public void setFace(String face) { this.face = face; }
	@Override void newshow() {
		super.newshow();
		System.out.println("::::NOTE8새로운기능(Overriding)\n"+"= face 안면인식기능!\n"+"= face : "+face);} 	
	}
class MobileNote9 extends MobileNote8{
	private int battery = 24;
	@Override void newshow() {
		super.newshow();
		System.out.println("::::NOTE9새로운기능(Overriding)\n"+"= battery 하루종일 사용가능!\n"+"= bettery : "+battery);}	
}

public class Extends003 {
	public static void main(String[] args) {
		MobileNote9 my9 = new MobileNote9();
		my9.setIris("brown");
		my9.setFace("pretty");
		my9.newshow();
	}
}
