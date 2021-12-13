package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.BaseDao;
import dao.StudentDao;
import entity.Student;
import entity.Subject;
import entity.Teacher;
import entity.Team;
import dao.impl.SubjectDaoimpl;
import dao.impl.TeamDaoimpl;

public class StudentDaoimpl extends BaseDao implements StudentDao {
	private Connection conn = null; // 保存数据库连接
	private PreparedStatement pstmt = null; // 用于执行SQL语句
	private ResultSet rs = null; // 用户保存查询结果集
	public void updateStudent(Student student) {
		try {
			String sql="update student set s_name=?,iscaption=?,isjoin=?,id=? where s_id=?";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setString(1, student.getName());
			pstmt.setBoolean(2, student.isIscaptain());
			pstmt.setBoolean(3, student.isIsjoin());
			pstmt.setInt(4, student.getS().getId());
			//pstmt.setString(5, student.getTeam().getName());
			//pstmt.setString(5, student.getS().getName());
			pstmt.setString(5, student.getId());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	//public Student getStudentToport(String sid)
	public Student getStudent(String sid) {
		//List<Student> studentList = new ArrayList<Student>();
		String sql="select * from student where student.s_id=?";
		Student student = new Student();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		pstmt.setString(1, sid);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			student.setId(rs.getString(1));
			student.setName(rs.getString(2));
			student.setIscaptain(rs.getBoolean(3));
			student.setIsjoin(rs.getBoolean(4));
			
			int id=rs.getInt(5);
			SubjectDaoimpl sub=new SubjectDaoimpl();
		    student.setS(sub.getSubjectToid(id));
           // student.setTeam(t.getTeam(teamname));
            
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return student;
	}
	public String stuselectsql(String sid) throws ClassNotFoundException, SQLException {
		String sql="select * from student where student.id=subject.id and student.s_id=?";
		conn = getConn(); // 得到数据库连接
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, sid);
		return sql;
	}

	
	public List<Student> getAllStudent() {
		List<Student> ownerList = new ArrayList<Student>();
		try {
		String preparedSql = "select * from Student";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setIscaptain(rs.getBoolean(3));
				student.setIsjoin(rs.getBoolean(4));
                Subject subject=new Subject();
                int id=rs.getInt(5);
    			SubjectDaoimpl sub=new SubjectDaoimpl();
    		    student.setS(sub.getSubjectToid(id));
    		   
				
    		   // String teamname=rs.getString(6);
    			//TeamDaoimpl t=new TeamDaoimpl();
               // student.setTeam(t.getTeam(teamname));
				

				ownerList.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return ownerList;
	}

	public boolean judge(String username) {
		List<Student> ownerList = this.getAllStudent();
		for(int i=0;i<ownerList.size();i++) {
			if(username.equals(ownerList.get(i).getId())) {
				return true;
			}
		}
		return false;
	}

	
	
	
}
