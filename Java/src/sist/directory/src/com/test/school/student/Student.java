package com.test.school.student;

import java.util.List;

import com.test.school.common.SchoolMember;
import com.test.school.domain.Attendance;
import com.test.school.domain.Score;

/**
 * 학생 정보를 저장하는 클래스
 */
public class Student extends SchoolMember {
	
	private int no; 				//일련번호
	private int grade; 				//학년
	private int classNumber; 		//반
	private int number;				//번호
	private List<Score> slist; 		//성적
	private List<Attendance> alist; //출결
	
	//생성자 > 기본생성자 + 오버로딩
	public Student() {
		this(0, 0, 0, 0, null, null, null);
	}

	public Student(int no, int grade, int classNumber, int number, String name, List<Score> slist, List<Attendance> alist) {
		
		super(name);
				
		this.no = no;
		this.grade = grade;
		this.classNumber = classNumber;
		this.setNumber(number);
		//this.name = name;
		this.slist = slist;
		this.alist = alist;
	}

	public int getNo() {
		return no;
	}

	public int getGrade() {
		return grade;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public String getName() {
		return super.getName();
	}

	public List<Score> getSlist() {
		return slist;
	}

	public List<Attendance> getAlist() {
		return alist;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}

	public void setName(String name) {
		super.setName(name);
	}

	public void setSlist(List<Score> slist) {
		this.slist = slist;
	}

	public void setAlist(List<Attendance> alist) {
		this.alist = alist;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [no=");
		builder.append(no);
		builder.append(", grade=");
		builder.append(grade);
		builder.append(", classNumber=");
		builder.append(classNumber);
		builder.append(", number=");
		builder.append(number);
		builder.append(", name=");
		builder.append(getName());
		builder.append(", slist=");
		builder.append(slist);
		builder.append(", alist=");
		builder.append(alist);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<Score> getScore() {
		
		return null;
	}

	@Override
	public List<Attendance> getAttendance() {
		
		return null;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}















