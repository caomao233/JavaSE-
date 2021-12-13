package Biz;

import entity.Student;
import entity.Team;
import Biz.SubjectBiz;
import entity.Teacher;
import entity.Subject;

import java.sql.SQLException;
import java.util.Scanner;
import dao.impl.SubjectDaoimpl;
import dao.impl.TeamDaoimpl;
import dao.impl.*;
/**
 * 
 * 学生业务处理
 *
 */
public class StudentBiz {//学生业务里还差答辩调用
	//Student s=new Student();
	SubjectDaoimpl subdao=new SubjectDaoimpl();
	TeamDaoimpl tedao=new TeamDaoimpl();
	StudentDaoimpl studao=new StudentDaoimpl();
	TeacherDaoimpl teadao=new TeacherDaoimpl();
	SubjectBiz subjectbiz=new SubjectBiz();
	Scanner sc=new Scanner(System.in);
	public void check(Student s) {
		//System.out.println("您的项目名称为"+s.getS().getName()+",您所在的小队为"+s.getS().getTeam().getName()+"您的指导老师为"+s.getS().getTeacher().getName());
		System.out.println("您的项目当前进程为:");
		int stage=s.getS().getStage();
		if(stage==0){
			System.out.println("您的项目还没开始");
		}
		else if(stage==1){
			System.out.println("您的项目已经通过开题答辩"+"您项目的评分为"+s.getS().getOpenGrade()+"您的项目评级为"+s.getS().getLevel());
		}
		else if(stage==2){
			System.out.println("您的项目已经通过中期答辩"+"您项目的评分为"+s.getS().getMiddleGrade());
		}
		else if(stage==3){
			System.out.println("您的项目已经通过结业答辩"+"您项目的评分为"+s.getS().getFinalGrade()+"您的项目最终获奖为"+s.getS().getResult());
		}
		else if(stage==4){
			if(subjectbiz.setOpenScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==1){
					
					System.out.println("您的项目已经通过开题答辩"+"您项目的评分为"+s.getS().getOpenGrade()+"您的项目评级为"+s.getS().getLevel());
				}
				else{
					System.out.println("很抱歉您的项目并没有通过开题答辩，您的最终分数为"+s.getS().getOpenGrade());
				}
			}
			else{
				System.out.println("你的项目已经提交开题答辩，目前老师正在评分，请耐心等待");
			}
		}
		else if(stage==5){
			if(subjectbiz.setIntermScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==2){
					
					System.out.println("您的项目已经通过中期答辩"+"您项目的评分为"+s.getS().getMiddleGrade());
				}
				else{
					System.out.println("很抱歉您的项目并没有通过中期答辩，您的最终分数为"+s.getS().getMiddleGrade());
				}
			}
			else{
				System.out.println("你的项目已经提交中期答辩，目前老师正在评分，请耐心等待");
			}
		}
		else if(stage==6){
			if(subjectbiz.setFinalScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==3){
					
					System.out.println("您的项目已经通过结业答辩"+"您项目的评分为"+s.getS().getFinalGrade()+"您所获得的最终奖项为"+s.getS().getResult());
				}
				else{
					System.out.println("很抱歉您的项目并没有通过结业答辩，您的最终分数为"+s.getS().getFinalGrade());
				}
			}
			else{
				System.out.println("你的项目已经提交结业答辩，目前老师正在评分，请耐心等待");
			}
		}
	}
	public boolean applyJoin(Student student,Subject subject){
		if(tedao.getTeamtoid(subject.getId()).isFull()){
			//System.out.println("抱歉这个小队已经满了，请您再考虑一下吧");
			return false;
		}
		else{
			//*****更新学生的表项***********//
			student.setIsjoin(true);
			student.setSubject(subject);
			studao.updateStudent(student);
			//*******添加小队表项********//
			tedao.insertTeam(tedao.getTeamtoid(subject.getId()), student, subject);
			return true;
		}

	}
	public boolean applyCreate(String subject_name,Student student,Teacher teacher){
		//这里要调用数据库
				//申请一个项目，要修改学生的表，插入项目表，插入小队表
				//要在subject表中插入一条表项
				//要在teacher中修改数据
				//要添加team表象
				//要修改student数据
				//**********插入项目*******//
				Subject su=new Subject();
				System.out.println(subdao.getAllSubject().size());
				su.setId(subdao.getAllSubject().size()+1);
				su.setName(subject_name);
				subdao.insertSubject(su);
				//**********修改学生*********//
				student.setS(su);
				//student.setTeam(su.getTeam());
				student.setIscaptain(true);
				student.setIsjoin(true);
				studao.updateStudent(student);
				//*********添加小队********//
				Team team=new Team();
				//team.setSubject(su);
				team.getStudents().add(student);
				team.setName(subject_name);
				tedao.insertTeam(team,student,su);
				//**********往老师里加项目******//
				teadao.insertTeacher(teacher, su);
				return true;
	}
	
	public void study(Student s) {//调用数据库去改
		s.getS().countDu();
		subdao.updateSubject(s.getS());
	}
}
