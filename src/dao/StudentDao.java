package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Student;
import entity.Subject;

public interface StudentDao {
	public void updateStudent(Student student) ;
	public Student getStudent(String sid);
	public String stuselectsql(String sid) throws ClassNotFoundException, SQLException;
	public List<Student> getAllStudent();
	public boolean judge(String username) ;
}
