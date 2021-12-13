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
		/*******�鿴���е���Ŀ*********/
		List<Subject> ownerList=sud.getAllSubject();
		for(int i=0;i<ownerList.size();i++) {
			System.out.println(ownerList.get(i).getId()+ownerList.get(i).getName());
		}
		/*********�걨һ����Ŀ*****/
		Student student=stud.getStudent("201996070");
		System.out.println("�����������걨����Ŀ��");
		String str=in.next();
		System.out.println("����������ָ����ʦ");
		String str1=in.next();
		Teacher teacher=tead.getTeacherToname(str1);
		stb.applyCreate(str, student, teacher);
		/******�������һ����Ŀ*********/
		Student student1=stud.getStudent("201994079");
		System.out.println("����������������Ŀ��");
		String str2=in.next();
		Subject subject=sud.getSubjectToname(str2);
		stb.applyJoin(student1, subject);
		/*****�鿴�Լ�����Ŀ******/
		System.out.println("����������ѧ��");
		String str3=in.next();
		Student student2=stud.getStudent(str3);
		System.out.println(student2.getS().getName());
		stb.check(student2);
		/*****ѧ��������******/
		Student student3=stud.getStudent("201992274");
		sub.applyOpeanReport(subject);
		/*****��ʦ�鿴�Լ�����Ŀ*****/
		System.out.println("���������Ľ�ְ����");
		String str4=in.next();
		Teacher teacher2=tead.getTeacherToid(str4);
		for(int i=0;i<teacher2.getSubject().size();i++) {
			System.out.println(teacher2.getSubject().get(i).getName());
		}
		//System.out.println("���");
		/*****��ʦ����*****/
		Teacher teacher3=tead.getTeacherToid("10086");
		for(int i=0;i<teacher3.getOpeningReport().getsubjectsO().size();i++) {
			System.out.println("����������");
			int score=in.nextInt();
			rep.Setsocre(teacher3.getOpeningReport().getsubjectsO().get(i), score);
		}
		}
}