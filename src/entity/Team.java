package entity;
import java.util.*;
public class Team {
	String name=new String();
	Subject subject=new Subject();
	List<Student> students=new ArrayList<Student>();
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		subject=subject;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	/*public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}*/
	public boolean isFull() {
		if(students.size()==6){
			return true;
		}
		else{
			return false;
		}
	}
}
