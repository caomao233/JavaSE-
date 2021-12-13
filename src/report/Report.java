package report;
import java.sql.SQLException;
import java.util.ArrayList;
//报告应该分成两种状态，一是还没答辩，一是答辩了正在等待通过
//这个类只负责提供函数
//这个类变成了老师使用的一个业务
import java.util.List;
import dao.impl.*;
import java.util.Scanner;

//import entity.Teacher;
import entity.Subject;
import entity.Teacher;
//要完成的功能，学生申请加入答辩，在学生事务里处理，还要加学生查看答辩，也在学生里进行，实现老师评分函数，三个老师都评分之后修改项目的状态
//设置两个范式，一个放评分老师，一个放学生，老师是随机抽取的，三位，学生是自己申请加入的，没有人数限制
public abstract class Report {
	List<Subject> subjectsO=new ArrayList<Subject>();
	List<Subject> subjectsI=new ArrayList<Subject>();
	List<Subject> subjectsG=new ArrayList<Subject>();
	Scanner sc=new Scanner(System.in);
	TempointDaoimpl td=new TempointDaoimpl();
	public void Setsocre(Subject subject,int s) {//老师给分函数
		//按照现实中的流程，这里应该是学生在教师中完成答辩了，老师回到办公室为他们在系统中打分。
		 td.insertTempPoint(subject, s);

	}
	public List<Subject> getsubjectsO(){
		return subjectsO;
	}
	public List<Subject> getsubjectsI(){
		return subjectsI;
	}
	public List<Subject> getsubjectsG(){
		return subjectsG;
	}
}
