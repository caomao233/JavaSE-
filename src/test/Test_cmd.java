package test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Biz.SubjectBiz;
import Biz.TeacherBiz;
import Biz.StudentBiz;
import dao.impl.SubjectDaoimpl;
import entity.Subject;
import entity.Teacher;
import entity.Student;
import entity.Team;
import report.OpeningReport;
import report.Report;
import dao.impl.*;
public class Test_cmd {
	
	public static void main(String[] args) {
		TeacherDaoimpl tead=new TeacherDaoimpl();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		TeamDaoimpl td=new TeamDaoimpl();
		StudentDaoimpl stud=new StudentDaoimpl();
		TempointDaoimpl tempd=new TempointDaoimpl();
		OpenportDaoimpl od=new OpenportDaoimpl();
		MiddleportDaoimpl md=new MiddleportDaoimpl();
		FinalportDaoimpl fd=new FinalportDaoimpl();
		StudentBiz stb=new StudentBiz();
		TeacherBiz teb=new TeacherBiz();
		SubjectBiz sub=new SubjectBiz();
		Report rep=new OpeningReport();
		Scanner in = new Scanner(System.in);
		/*******查看已有的项目*********/
		List<Subject> ownerList=sud.getAllSubject();
		for(int i=0;i<ownerList.size();i++) {
			System.out.println(ownerList.get(i).getId()+ownerList.get(i).getName());
		}
		/*********申报一个项目*****/
		Student student=stud.getStudent("201996070");
		System.out.println("请输入您想申报的项目名");
		String str=in.next();
		System.out.println("请输入您的指导老师");
		String str1=in.next();
		Teacher teacher=tead.getTeacherToname(str1);
		stb.applyCreate(str, student, teacher);
		/******申请加入一个项目*********/
		Student student1=stud.getStudent("201994079");
		System.out.println("请输入您想加入的项目名");
		String str2=in.next();
		Subject subject=sud.getSubjectToname(str2);
		stb.applyJoin(student1, subject);
		/*****查看自己的项目******/
		System.out.println("请输入您的学号");
		String str3=in.next();
		Student student2=stud.getStudent(str3);
		System.out.println(student2.getS().getName());
		stb.check(student2);
		/*****学生申请答辩******/
		Student student3=stud.getStudent("201992274");
		sub.applyOpeanReport(subject);
		/*****老师查看自己的项目*****/
		System.out.println("请输入您的教职工号");
		String str4=in.next();
		Teacher teacher2=tead.getTeacherToid(str4);
		for(int i=0;i<teacher2.getSubject().size();i++) {
			System.out.println(teacher2.getSubject().get(i).getName());
		}
		//System.out.println("这里？");
		/*****老师评分*****/
		Teacher teacher3=tead.getTeacherToid("10086");
		for(int i=0;i<teacher3.getOpeningReport().getsubjectsO().size();i++) {
			System.out.println("请输入评分");
			int score=in.nextInt();
			rep.Setsocre(teacher3.getOpeningReport().getsubjectsO().get(i), score);
		}
		}
}