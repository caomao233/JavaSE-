package Biz;
import entity.Subject;

import java.sql.SQLException;

import dao.impl.*;
import entity.Teacher;
public class SubjectBiz {//�������ĺ�����˭ȥ�����أ����ڶӳ��������
	//�������ݿ⣬�ҵ���λӵ�д��Ȩ�޵���ʦ
	//0:��û����,1:��ɿ�����,2:������ڴ��,3:��ɽ�ҵ���,4:�ύ�˿��������ڵȴ��Ƿ�ͨ��,5:�ύ�����ڴ�����ڵȴ��Ƿ�ͨ��,6:�ύ�˽�ҵ������ڵȴ��Ƿ�ͨ��,7:��û�ύ���ڣ�8����û�ύ��ҵ
	//����ǰ״̬Ϊ1ʱ�������Ѿ�ͨ�������磬��û��������ڴ��
	//student.join(Student,Subject);//���� studentΪRole��
	Teacher[] teachers = new Teacher[3];
	OpenportDaoimpl od=new OpenportDaoimpl();
	MiddleportDaoimpl md=new MiddleportDaoimpl();
	FinalportDaoimpl fd=new FinalportDaoimpl();
	SubjectDaoimpl subd=new SubjectDaoimpl();
	TempointDaoimpl td=new TempointDaoimpl();
	//***************������*************//������õ�����dao�Ĳ��뺯��
	public void applyOpeanReport(Subject stemp){
		if(stemp.getStage()==0){
			od.insertopenport1(stemp);
			od.insertopenport2(stemp);
			od.insertopenport3(stemp);
			stemp.setStage(4);
			subd.updateSubject(stemp);
			//System.out.println("������ɿ����磬���ڵȴ���ʦ����");
		}
	}
	public void applyIntermReport(Subject stemp){
		if(stemp.getStage()==1){
			
			md.insertmiddleport1(stemp);
			md.insertmiddleport2(stemp);
			md.insertmiddleport3(stemp);
			stemp.setStage(5);
			subd.updateSubject(stemp);
			//System.out.println("����������ڴ�磬���ڵȴ���ʦ����");
		}
	}
	public void applyGraduationReport(Subject stemp){
		if(stemp.getStage()==2){
			
			fd.insertfinalport1(stemp);	
			fd.insertfinalport2(stemp);
			fd.insertfinalport3(stemp);
			stemp.setStage(6);
			subd.updateSubject(stemp);
			//System.out.println("������ɽ�ҵ��磬���ڵȴ���ʦ����");
		}
	}
	//*************����������****************//��Щ����һ���ڲ鿴������е��ã��Ǿ��ǵ��鿴��ʱ��Ż�ı����������Ҳ��̫����һ�����Щ����Ū��BOOLEAN��
	public boolean setOpenScore(Subject stemp){ 
		if((stemp.getStage()==4)&&(stemp.getscoretemp().size()==3)){
			//����Ҫ�����ݿ�
			int score=0;
			for(int i=0;i<3;i++){
				score+=stemp.getscoretemp().get(i);
			}
			stemp.setOpenGrade(score/3);//֮�����ɸѡ��ƽ������ʮ��֮�µ���Ŀˢ����60~70��У����70~80���м���80~90��ʡ����90~100�ǹ��Ҽ�
			if(stemp.getOpenGrade()<6){//��Ŀû��ͨ����磬����һ��״̬�������ò鿴������ʱ�����״̬Ϊtrue���Ǿ�����Ŀ���ڣ����Ϊfalse�Ǿ�����Ŀ����
				stemp.setIsExist(false);
			}
			else if(stemp.getOpenGrade()>=6&&stemp.getOpenGrade()<7){
				stemp.setLevel("У��");
				stemp.setStage(1);//��ɿ�����
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=7&&stemp.getOpenGrade()<8){
				stemp.setLevel("�м�");
				stemp.setStage(1);//��ɿ�����
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=8&&stemp.getOpenGrade()<9){
				stemp.setLevel("ʡ��");
				stemp.setStage(1);//��ɿ�����
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=9&&stemp.getOpenGrade()<=10){
				stemp.setLevel("���Ҽ�");
				stemp.setStage(1);//��ɿ�����
				stemp.countDu();
			}
			td.deleteTempPoint(stemp);
			subd.updateSubject(stemp);
			return true;
		}
		return false;
	}
	public boolean setIntermScore(Subject stemp){
		if((stemp.getStage()==5)&&(stemp.getscoretemp().size()==3)){
			int score=0;
			for(int i=0;i<3;i++){
				score+=stemp.getscoretemp().get(i);
			}
			stemp.setOpenGrade(score/3);
			if(stemp.getOpenGrade()<6){//��Ŀû��ͨ����磬����һ��״̬�������ò鿴������ʱ�����״̬Ϊtrue���Ǿ�����Ŀ���ڣ����Ϊfalse�Ǿ�����Ŀ����
				stemp.setIsExist(false);
			}
			else{
				stemp.setStage(2);//������ڴ��
				stemp.countDu();
			}
			td.deleteTempPoint(stemp);
			subd.updateSubject(stemp);
			
		}
		return false;
	}
	public boolean setFinalScore(Subject stemp){
		if((stemp.getStage()==6)&&(stemp.getscoretemp().size()==3)){
			int score=0;
			for(int i=0;i<3;i++){
				score+=stemp.getscoretemp().get(i);
			}
			stemp.setOpenGrade(score/3);//֮�����ɸѡ��ƽ������ʮ��֮�µ���Ŀˢ����60~70��У����70~80���м���80~90��ʡ����90~100�ǹ��Ҽ�
			if(stemp.getOpenGrade()<6){//��Ŀû��ͨ����磬����һ��״̬�������ò鿴������ʱ�����״̬Ϊtrue���Ǿ�����Ŀ���ڣ����Ϊfalse�Ǿ�����Ŀ����
				stemp.setIsExist(false);
			}
			else if(stemp.getOpenGrade()>=6&&stemp.getOpenGrade()<7){
				stemp.setResult("У������");
				stemp.setStage(3);//��ɿ�����
				
			}
			else if(stemp.getOpenGrade()>=7&&stemp.getOpenGrade()<8){
				stemp.setResult("�м�����");
				stemp.setStage(3);//��ɿ�����
				
			}
			else if(stemp.getOpenGrade()>=8&&stemp.getOpenGrade()<9){
				stemp.setResult("ʡ������");
				stemp.setStage(3);//��ɿ�����
				
			}
			else if(stemp.getOpenGrade()>=9&&stemp.getOpenGrade()<=10){
				stemp.setResult("���Ҽ�����");
				stemp.setStage(3);//��ɿ�����
				
			}
			td.deleteTempPoint(stemp);
			subd.updateSubject(stemp);
			return true;
		}
		return false;
	}


}