package java027_part002_정리문제_etc;

public class Score_ver2 {
	private String name;    
	private int kor, eng, math;   
	private double avg;
	private String pass;
	
	public Score_ver2() { super();  pass= ""; }
	public Score_ver2(String name, int kor, int eng, int math) { this(); this.name = name; this.kor = kor; this.eng = eng; this.math = math; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "Score_ver2 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg
				+ ", pass=" + pass + "]";
	}

}
