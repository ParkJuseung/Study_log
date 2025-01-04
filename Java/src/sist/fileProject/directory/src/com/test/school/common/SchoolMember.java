package sist.fileProject.directory.src.com.test.school.common;

import java.util.List;

import com.test.school.domain.Attendance;
import com.test.school.domain.Score;

public abstract class SchoolMember {

	private String name;
	
	public SchoolMember(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract List<Score> getScore();
	public abstract List<Attendance> getAttendance();
	
}












