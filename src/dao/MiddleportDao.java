package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Subject;
import entity.Teacher;

public interface MiddleportDao {
	public void insertmiddleport1(Subject subject) ;
	public void insertmiddleport2(Subject subject) ;
	public void insertmiddleport3(Subject subject) ;
	public void deletemiddleport(Subject subject,Teacher teacher);
	public List<Subject> getAllmiddletempsubject(Teacher teahcer) ;
}
