package entity;
import java.util.*;

//import report.Report;
import report.GraduationReport;
import report.IntermReport;
import report.OpeningReport;
public class Teacher {
	String name=new String();
	String id=new String();
	boolean isSetScoreTeacher;//通过数据库找到是的那三位老师
	List<Subject> subjects=new ArrayList<Subject>();
	GraduationReport gReport=new GraduationReport();
	IntermReport iReport=new IntermReport();
	OpeningReport oReport=new OpeningReport();
	public boolean getisSetScoreTeacher(){
		return isSetScoreTeacher;
	}
	public boolean isSetScoreTeacher() {
		return isSetScoreTeacher;
	}
	public void setisSetScoreTeacher(boolean isSetScoreTeacher) {
		this.isSetScoreTeacher = isSetScoreTeacher;
	}
	public GraduationReport getGraduationReport(){
		return gReport;
	}
	public IntermReport getIntermReport(){
		return iReport;
	}
	public OpeningReport getOpeningReport(){
		return oReport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Subject> getSubject() {
		return subjects;
	}
	public void setSubject(List<Subject> subject) {
		this.subjects = subject;
	}
	
	
}
