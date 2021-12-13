package authority.impl;
import entity.Subject;
import entity.Teacher;
import Biz.TeacherBiz;
import authority.Teacher_right;
import dao.impl.TempointDaoimpl;
/**
 * 
 * 老师权限
 *
 */
public class Instructor implements Teacher_right {
	TeacherBiz t=new TeacherBiz();
	//遍历数据库，找到这个老师
	Teacher T=new Teacher();
	TempointDaoimpl ted=new TempointDaoimpl();
	
	public void check() {
		t.check(T);
	}
	/*public void teach() {//增加项目进度
		t.teach(t.);
	}*/
	public void setGsocre(Subject subject,int s) {
		ted.insertTempPoint(subject, s);
	}
	public void setIsocre(Subject subject,int s) {
		ted.insertTempPoint(subject, s);
	}
	public void setOsocre(Subject subject,int s) {
		ted.insertTempPoint(subject, s);
	}
}
