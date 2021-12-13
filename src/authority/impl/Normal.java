package authority.impl;

import authority.Student_right;
import entity.Student;
import entity.Subject;
import entity.Teacher;
import Biz.StudentBiz;
public class Normal implements Student_right {

	//要弄一张项目表
	//老规矩找这个学生
	Student s=new Student();
	StudentBiz sib=new StudentBiz();
	public void check(Student s) {
		// TODO Auto-generated method stub

	}
	public void apply(String subject_name,Student student,Teacher teacher){
		sib.applyCreate(subject_name, student, teacher);
	}
	public void join(Student student,Subject subject){
		sib.applyJoin(student, subject);
	}
}
