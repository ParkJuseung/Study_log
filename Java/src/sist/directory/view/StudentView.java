package sist.directory.view;

import java.util.List;

import com.test.school.domain.Attendance;
import com.test.school.repository.SchoolDAO;
import com.test.school.student.Student;

public class StudentView {
	
	
	
	public static void printScoreList(int grade, int classNumber) {
		// TODO Auto-generated method stub
		for(Student s : SchoolDAO.studentList) {
			if(s.getGrade() == grade && s.getClassNumber() == classNumber) {
				System.out.println(s.getSlist());
			}
		}
	}

	public static void printAttendance(List<Attendance> alist) {
		// TODO Auto-generated method stub
		for(Attendance a : alist) {
			System.out.println(a);
		}
	}

}
