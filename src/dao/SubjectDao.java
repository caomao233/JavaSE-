package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Subject;
import entity.Teacher;
import entity.Team;

public interface SubjectDao {
	public void insertSubject(Subject subject);
	public void updateSubject(Subject subject) ;
	public List<Subject> getAllSubject();
	public boolean judge(String username);
	public Subject getSubjectToid(int id);
	public Subject getSubjectToname(String name);
	public int updateSubject(String sql, Object[] param);
}
