package Biz;

import java.util.Scanner;

import entity.Teacher;
import entity.Subject;
/**
 * 
 *老师业务处理
 *
 */
public class TeacherBiz {
	//Teacher t=new Teacher();
	Scanner sc=new Scanner(System.in);
	public String state(int i)
	{
		
		if(i==1){
			String temp;
			temp="已通过开题答辩";
			return temp;
		}
		else if(i==0){
			String temp;
			temp="还未通过开题答辩";
			return temp;
		}
		else if(i==2){
			String temp;
			temp="已通过中期答辩";
			return temp;
		}
		else if(i==3){
			String temp;
			temp="已通过结业答辩";
			return temp;
		}
		return null;
	}
	public void check(Teacher t) {
		System.out.println("如果您想查看您所有的项目，请按1，如果您想查看某个专门的项目，请按2");
		int check=sc.nextInt();
		if(check==1){
			System.out.println("您名下所有的项目和项目进度");
			for(int i=0;i<t.getSubject().size();i++)
			{
				//System.out.println("项目名称"+t.getSubject().get(i).getName()+"\t队长"+t.getSubject().get(i).getTeam().getStudents().get(0)+"\t项目进度"+state(t.getSubject().get(i).getStage())+"\t项目学习进度"+t.getSubject().get(i).getDU());
			}
		System.out.println("如果您想指导某个队伍，请按1");
		//能不能实现直接退出？
		int check2=sc.nextInt();
		if(check2==1)
		{
			System.out.println("请输入您想指导的队伍");
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
				System.out.println("对不起，您没有这个项目");
			}
			
		}
		}
		else if(check==2){
			System.out.println("请您输入您想查看的项目");
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
				//System.out.println("项目名称"+s1.getName()+"\t队长"+s1.getTeam().getStudents().get(0)+"\t项目进度"+state(s1.getStage())+"\t项目学习进度"+s1.getDU());
				System.out.println("请问您是否想指导这个小组,如果是，请按1");
				int check2=sc.nextInt();
				if(check2==1){
					teach(s1);
				}
			}
			else{
				System.out.println("对不起，您没有这个项目");
			}
		}
	}
	public void teach(Subject stemp) {//增加项目进度
		System.out.println("文字模拟指导流程");
		//System.out.println("老师召集小队队长"+stemp.getTeam().getStudents().get(0)+"并告知队长通知所有小队成员开会");
		System.out.println("老师查看学生的学习日志");//这个功能回头在实现吧,现在不好实现啊
		System.out.println("通过老师的指导，小组成员的进度增加了");
		stemp.countDu();
	}

}
