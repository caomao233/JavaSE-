package Biz;
import entity.Subject;

import java.sql.SQLException;

import dao.impl.*;
import entity.Teacher;
public class SubjectBiz {//这个类里的函数由谁去调用呢？，在队长里面调用
	//查找数据库，找到三位拥有打分权限的老师
	//0:还没开题,1:完成开题答辩,2:完成中期答辩,3:完成结业答辩,4:提交了开题答辩正在等待是否通过,5:提交了中期答辩正在等待是否通过,6:提交了结业答辩正在等待是否通过,7:还没提交中期，8：还没提交结业
	//当当前状态为1时，代表已经通过开题答辩，还没有完成中期答辩
	//student.join(Student,Subject);//加入 student为Role类
	Teacher[] teachers = new Teacher[3];
	OpenportDaoimpl od=new OpenportDaoimpl();
	MiddleportDaoimpl md=new MiddleportDaoimpl();
	FinalportDaoimpl fd=new FinalportDaoimpl();
	SubjectDaoimpl subd=new SubjectDaoimpl();
	TempointDaoimpl td=new TempointDaoimpl();
	//***************申请答辩*************//在这调用的三个dao的插入函数
	public void applyOpeanReport(Subject stemp){
		if(stemp.getStage()==0){
			od.insertopenport1(stemp);
			od.insertopenport2(stemp);
			od.insertopenport3(stemp);
			stemp.setStage(4);
			subd.updateSubject(stemp);
			//System.out.println("您已完成开题答辩，正在等待老师评价");
		}
	}
	public void applyIntermReport(Subject stemp){
		if(stemp.getStage()==1){
			
			md.insertmiddleport1(stemp);
			md.insertmiddleport2(stemp);
			md.insertmiddleport3(stemp);
			stemp.setStage(5);
			subd.updateSubject(stemp);
			//System.out.println("您已完成中期答辩，正在等待老师评价");
		}
	}
	public void applyGraduationReport(Subject stemp){
		if(stemp.getStage()==2){
			
			fd.insertfinalport1(stemp);	
			fd.insertfinalport2(stemp);
			fd.insertfinalport3(stemp);
			stemp.setStage(6);
			subd.updateSubject(stemp);
			//System.out.println("您已完成结业答辩，正在等待老师评价");
		}
	}
	//*************答辩分数计算****************//这些函数一会在查看类里进行调用，那就是当查看的时候才会改变分数？好像也不太合理，一会把这些函数弄成BOOLEAN型
	public boolean setOpenScore(Subject stemp){ 
		if((stemp.getStage()==4)&&(stemp.getscoretemp().size()==3)){
			//这里要改数据库
			int score=0;
			for(int i=0;i<3;i++){
				score+=stemp.getscoretemp().get(i);
			}
			stemp.setOpenGrade(score/3);//之后就是筛选把平均分六十分之下的项目刷掉，60~70是校级；70~80是市级；80~90是省级；90~100是国家级
			if(stemp.getOpenGrade()<6){//项目没有通过答辩，设置一个状态，当调用查看函数的时候，如果状态为true，那就是项目还在，如果为false那就是项目无了
				stemp.setIsExist(false);
			}
			else if(stemp.getOpenGrade()>=6&&stemp.getOpenGrade()<7){
				stemp.setLevel("校级");
				stemp.setStage(1);//完成开题答辩
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=7&&stemp.getOpenGrade()<8){
				stemp.setLevel("市级");
				stemp.setStage(1);//完成开题答辩
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=8&&stemp.getOpenGrade()<9){
				stemp.setLevel("省级");
				stemp.setStage(1);//完成开题答辩
				stemp.countDu();
			}
			else if(stemp.getOpenGrade()>=9&&stemp.getOpenGrade()<=10){
				stemp.setLevel("国家级");
				stemp.setStage(1);//完成开题答辩
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
			if(stemp.getOpenGrade()<6){//项目没有通过答辩，设置一个状态，当调用查看函数的时候，如果状态为true，那就是项目还在，如果为false那就是项目无了
				stemp.setIsExist(false);
			}
			else{
				stemp.setStage(2);//完成中期答辩
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
			stemp.setOpenGrade(score/3);//之后就是筛选把平均分六十分之下的项目刷掉，60~70是校级；70~80是市级；80~90是省级；90~100是国家级
			if(stemp.getOpenGrade()<6){//项目没有通过答辩，设置一个状态，当调用查看函数的时候，如果状态为true，那就是项目还在，如果为false那就是项目无了
				stemp.setIsExist(false);
			}
			else if(stemp.getOpenGrade()>=6&&stemp.getOpenGrade()<7){
				stemp.setResult("校级奖项");
				stemp.setStage(3);//完成开题答辩
				
			}
			else if(stemp.getOpenGrade()>=7&&stemp.getOpenGrade()<8){
				stemp.setResult("市级奖项");
				stemp.setStage(3);//完成开题答辩
				
			}
			else if(stemp.getOpenGrade()>=8&&stemp.getOpenGrade()<9){
				stemp.setResult("省级奖项");
				stemp.setStage(3);//完成开题答辩
				
			}
			else if(stemp.getOpenGrade()>=9&&stemp.getOpenGrade()<=10){
				stemp.setResult("国家级奖项");
				stemp.setStage(3);//完成开题答辩
				
			}
			td.deleteTempPoint(stemp);
			subd.updateSubject(stemp);
			return true;
		}
		return false;
	}


}