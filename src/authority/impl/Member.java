package authority.impl;

import Biz.StudentBiz;
import entity.Student;
import authority.Student_right;
/**
 * 队员权限
 */
public class Member implements Student_right {
	StudentBiz s=new StudentBiz();
	Student s1=new Student();
	public void check(Student s1) {
		// TODO Auto-generated method stub
		s.check(s1);
	}
	public void study(Student s1) {
		s.study(s1);
	}

}
