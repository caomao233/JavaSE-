package authority.impl;
import entity.Subject;
import entity.Teacher;
import Biz.TeacherBiz;
import authority.Teacher_right;
import dao.impl.TempointDaoimpl;
/**
 * 
 * ��ʦȨ��
 *
 */
public class Instructor implements Teacher_right {
	TeacherBiz t=new TeacherBiz();
	//�������ݿ⣬�ҵ������ʦ
	Teacher T=new Teacher();
	TempointDaoimpl ted=new TempointDaoimpl();
	
	public void check() {
		t.check(T);
	}
	/*public void teach() {//������Ŀ����
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
