package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Subject;
import entity.Teacher;

public interface OpenportDao {
	public void insertopenport1(Subject subject) ;
	public void insertopenport2(Subject subject);
	public void insertopenport3(Subject subject);
	public void deleteopenport(Subject subject,Teacher teacher);
	 public List<Subject> getAllopeantempsubject(Teacher teahcer) ;
}
