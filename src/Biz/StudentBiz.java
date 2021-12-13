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
 * ѧ��ҵ����
 *
 */
public class StudentBiz {//ѧ��ҵ���ﻹ�������
	//Student s=new Student();
	SubjectDaoimpl subdao=new SubjectDaoimpl();
	TeamDaoimpl tedao=new TeamDaoimpl();
	StudentDaoimpl studao=new StudentDaoimpl();
	TeacherDaoimpl teadao=new TeacherDaoimpl();
	SubjectBiz subjectbiz=new SubjectBiz();
	Scanner sc=new Scanner(System.in);
	public void check(Student s) {
		//System.out.println("������Ŀ����Ϊ"+s.getS().getName()+",�����ڵ�С��Ϊ"+s.getS().getTeam().getName()+"����ָ����ʦΪ"+s.getS().getTeacher().getName());
		System.out.println("������Ŀ��ǰ����Ϊ:");
		int stage=s.getS().getStage();
		if(stage==0){
			System.out.println("������Ŀ��û��ʼ");
		}
		else if(stage==1){
			System.out.println("������Ŀ�Ѿ�ͨ��������"+"����Ŀ������Ϊ"+s.getS().getOpenGrade()+"������Ŀ����Ϊ"+s.getS().getLevel());
		}
		else if(stage==2){
			System.out.println("������Ŀ�Ѿ�ͨ�����ڴ��"+"����Ŀ������Ϊ"+s.getS().getMiddleGrade());
		}
		else if(stage==3){
			System.out.println("������Ŀ�Ѿ�ͨ����ҵ���"+"����Ŀ������Ϊ"+s.getS().getFinalGrade()+"������Ŀ���ջ�Ϊ"+s.getS().getResult());
		}
		else if(stage==4){
			if(subjectbiz.setOpenScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==1){
					
					System.out.println("������Ŀ�Ѿ�ͨ��������"+"����Ŀ������Ϊ"+s.getS().getOpenGrade()+"������Ŀ����Ϊ"+s.getS().getLevel());
				}
				else{
					System.out.println("�ܱ�Ǹ������Ŀ��û��ͨ�������磬�������շ���Ϊ"+s.getS().getOpenGrade());
				}
			}
			else{
				System.out.println("�����Ŀ�Ѿ��ύ�����磬Ŀǰ��ʦ�������֣������ĵȴ�");
			}
		}
		else if(stage==5){
			if(subjectbiz.setIntermScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==2){
					
					System.out.println("������Ŀ�Ѿ�ͨ�����ڴ��"+"����Ŀ������Ϊ"+s.getS().getMiddleGrade());
				}
				else{
					System.out.println("�ܱ�Ǹ������Ŀ��û��ͨ�����ڴ�磬�������շ���Ϊ"+s.getS().getMiddleGrade());
				}
			}
			else{
				System.out.println("�����Ŀ�Ѿ��ύ���ڴ�磬Ŀǰ��ʦ�������֣������ĵȴ�");
			}
		}
		else if(stage==6){
			if(subjectbiz.setFinalScore(s.getS())){
				if(s.getS().getIsExist()&&s.getS().getStage()==3){
					
					System.out.println("������Ŀ�Ѿ�ͨ����ҵ���"+"����Ŀ������Ϊ"+s.getS().getFinalGrade()+"������õ����ս���Ϊ"+s.getS().getResult());
				}
				else{
					System.out.println("�ܱ�Ǹ������Ŀ��û��ͨ����ҵ��磬�������շ���Ϊ"+s.getS().getFinalGrade());
				}
			}
			else{
				System.out.println("�����Ŀ�Ѿ��ύ��ҵ��磬Ŀǰ��ʦ�������֣������ĵȴ�");
			}
		}
	}
	public boolean applyJoin(Student student,Subject subject){
		if(tedao.getTeamtoid(subject.getId()).isFull()){
			//System.out.println("��Ǹ���С���Ѿ����ˣ������ٿ���һ�°�");
			return false;
		}
		else{
			//*****����ѧ���ı���***********//
			student.setIsjoin(true);
			student.setSubject(subject);
			studao.updateStudent(student);
			//*******���С�ӱ���********//
			tedao.insertTeam(tedao.getTeamtoid(subject.getId()), student, subject);
			return true;
		}

	}
	public boolean applyCreate(String subject_name,Student student,Teacher teacher){
		//����Ҫ�������ݿ�
				//����һ����Ŀ��Ҫ�޸�ѧ���ı�������Ŀ������С�ӱ�
				//Ҫ��subject���в���һ������
				//Ҫ��teacher���޸�����
				//Ҫ���team����
				//Ҫ�޸�student����
				//**********������Ŀ*******//
				Subject su=new Subject();
				System.out.println(subdao.getAllSubject().size());
				su.setId(subdao.getAllSubject().size()+1);
				su.setName(subject_name);
				subdao.insertSubject(su);
				//**********�޸�ѧ��*********//
				student.setS(su);
				//student.setTeam(su.getTeam());
				student.setIscaptain(true);
				student.setIsjoin(true);
				studao.updateStudent(student);
				//*********���С��********//
				Team team=new Team();
				//team.setSubject(su);
				team.getStudents().add(student);
				team.setName(subject_name);
				tedao.insertTeam(team,student,su);
				//**********����ʦ�����Ŀ******//
				teadao.insertTeacher(teacher, su);
				return true;
	}
	
	public void study(Student s) {//�������ݿ�ȥ��
		s.getS().countDu();
		subdao.updateSubject(s.getS());
	}
}
