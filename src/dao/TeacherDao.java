package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Subject;
import entity.Teacher;

public interface TeacherDao {
	//public void getTeachersSubject(Teacher teacher);
	public void getSetScoreTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher,Subject subjec);
	public Teacher getTeacherToid(String tid);
	public Teacher getTeacherToname(String tname);
	public String tselectsql_name(String tname) throws ClassNotFoundException, SQLException ;
	public List<Teacher> getAllTeacher();
	public boolean judge_id(String username) ;
	public boolean judge_name(String tname) ;
	public Teacher getTeacherTosubid(int id);
}
