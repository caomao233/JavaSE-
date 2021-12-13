package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Subject;
import entity.Teacher;

public interface FinalportDao {
	public void insertfinalport1(Subject subject) ;
	public void insertfinalport2(Subject subject) ;
	public void insertfinalport3(Subject subject) ;
	public void deletefinalport(Subject subject,Teacher teacher) ;
    public List<Subject> getAllfinaltempsubject(Teacher teahcer) ;
}
