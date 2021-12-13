package authority.impl;

import authority.Student_right;

import java.util.Scanner;

import Biz.StudentBiz;
import Biz.SubjectBiz;
import entity.Student;
import entity.Subject;
public class Captain implements Student_right {

	StudentBiz stb=new StudentBiz();
	SubjectBiz sub=new SubjectBiz();
	Scanner sc=new Scanner(System.in);
	//在数据库里找到这个队长，把队长的值导出
	Student s=new Student();
	public void check(Student s) {
		stb.check(s);
	}
	public void go_report(Subject subject,int i){
		if(subject.getStage()==0&&i==1){
			sub.applyOpeanReport(subject);
		}
		if(subject.getStage()==1&&i==2){
			sub.applyIntermReport(subject);

		}
		if(subject.getStage()==2&&i==3){
			
				sub.applyGraduationReport(subject);
		}
	}
	public void study(Student s) {
		stb.study(s);
	}
}
