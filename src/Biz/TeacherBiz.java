package Biz;

import java.util.Scanner;

import entity.Teacher;
import entity.Subject;
/**
 * 
 *��ʦҵ����
 *
 */
public class TeacherBiz {
	//Teacher t=new Teacher();
	Scanner sc=new Scanner(System.in);
	public String state(int i)
	{
		
		if(i==1){
			String temp;
			temp="��ͨ��������";
			return temp;
		}
		else if(i==0){
			String temp;
			temp="��δͨ��������";
			return temp;
		}
		else if(i==2){
			String temp;
			temp="��ͨ�����ڴ��";
			return temp;
		}
		else if(i==3){
			String temp;
			temp="��ͨ����ҵ���";
			return temp;
		}
		return null;
	}
	public void check(Teacher t) {
		System.out.println("�������鿴�����е���Ŀ���밴1���������鿴ĳ��ר�ŵ���Ŀ���밴2");
		int check=sc.nextInt();
		if(check==1){
			System.out.println("���������е���Ŀ����Ŀ����");
			for(int i=0;i<t.getSubject().size();i++)
			{
				//System.out.println("��Ŀ����"+t.getSubject().get(i).getName()+"\t�ӳ�"+t.getSubject().get(i).getTeam().getStudents().get(0)+"\t��Ŀ����"+state(t.getSubject().get(i).getStage())+"\t��Ŀѧϰ����"+t.getSubject().get(i).getDU());
			}
		System.out.println("�������ָ��ĳ�����飬�밴1");
		//�ܲ���ʵ��ֱ���˳���
		int check2=sc.nextInt();
		if(check2==1)
		{
			System.out.println("����������ָ���Ķ���");
			String str1=sc.next();
			boolean temp1=false;
			Subject s1=new Subject();
			for(int i=0;i<t.getSubject().size();i++){
				if(str1.equals(t.getSubject().get(i).getName())){
					temp1=true;
					s1=t.getSubject().get(i);
					break;
				}
			}
			if(temp1){
				teach(s1);
			}
			else{
				System.out.println("�Բ�����û�������Ŀ");
			}
			
		}
		}
		else if(check==2){
			System.out.println("������������鿴����Ŀ");
			String str1=sc.next();
			boolean temp1=false;
			Subject s1=new Subject();
			for(int i=0;i<t.getSubject().size();i++){
				if(str1.equals(t.getSubject().get(i).getName())){
					temp1=true;
					s1=t.getSubject().get(i);
					break;
				}
			}
			if(temp1){
				//System.out.println("��Ŀ����"+s1.getName()+"\t�ӳ�"+s1.getTeam().getStudents().get(0)+"\t��Ŀ����"+state(s1.getStage())+"\t��Ŀѧϰ����"+s1.getDU());
				System.out.println("�������Ƿ���ָ�����С��,����ǣ��밴1");
				int check2=sc.nextInt();
				if(check2==1){
					teach(s1);
				}
			}
			else{
				System.out.println("�Բ�����û�������Ŀ");
			}
		}
	}
	public void teach(Subject stemp) {//������Ŀ����
		System.out.println("����ģ��ָ������");
		//System.out.println("��ʦ�ټ�С�Ӷӳ�"+stemp.getTeam().getStudents().get(0)+"����֪�ӳ�֪ͨ����С�ӳ�Ա����");
		System.out.println("��ʦ�鿴ѧ����ѧϰ��־");//������ܻ�ͷ��ʵ�ְ�,���ڲ���ʵ�ְ�
		System.out.println("ͨ����ʦ��ָ����С���Ա�Ľ���������");
		stemp.countDu();
	}

}
