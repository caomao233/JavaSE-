package report;
import java.sql.SQLException;
import java.util.ArrayList;
//����Ӧ�÷ֳ�����״̬��һ�ǻ�û��磬һ�Ǵ�������ڵȴ�ͨ��
//�����ֻ�����ṩ����
//�����������ʦʹ�õ�һ��ҵ��
import java.util.List;
import dao.impl.*;
import java.util.Scanner;

//import entity.Teacher;
import entity.Subject;
import entity.Teacher;
//Ҫ��ɵĹ��ܣ�ѧ����������磬��ѧ�������ﴦ����Ҫ��ѧ���鿴��磬Ҳ��ѧ������У�ʵ����ʦ���ֺ�����������ʦ������֮���޸���Ŀ��״̬
//����������ʽ��һ����������ʦ��һ����ѧ������ʦ�������ȡ�ģ���λ��ѧ�����Լ��������ģ�û����������
public abstract class Report {
	List<Subject> subjectsO=new ArrayList<Subject>();
	List<Subject> subjectsI=new ArrayList<Subject>();
	List<Subject> subjectsG=new ArrayList<Subject>();
	Scanner sc=new Scanner(System.in);
	TempointDaoimpl td=new TempointDaoimpl();
	public void Setsocre(Subject subject,int s) {//��ʦ���ֺ���
		//������ʵ�е����̣�����Ӧ����ѧ���ڽ�ʦ����ɴ���ˣ���ʦ�ص��칫��Ϊ������ϵͳ�д�֡�
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
