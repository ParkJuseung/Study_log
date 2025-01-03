package sist.directory.domain;

public class Score {
	
	private int kor;
	private int eng;
	private int math;
	private String type;
	private int student_seq;
	
	public Score(int kor, int eng, int math, String type, int student_seq) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.type = type;
		this.student_seq = student_seq;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public String getType() {
		return type;
	}

	public int getStudent_seq() {
		return student_seq;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setStudent_seq(int student_seq) {
		this.student_seq = student_seq;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Score [kor=");
		builder.append(kor);
		builder.append(", eng=");
		builder.append(eng);
		builder.append(", math=");
		builder.append(math);
		builder.append(", type=");
		builder.append(type);
		builder.append(", student_seq=");
		builder.append(student_seq);
		builder.append("]");
		return builder.toString();
	}

}









