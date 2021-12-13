package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TeacherDao;
import entity.Teacher;
import entity.Subject; 
public class TeacherDaoimpl extends BaseDao implements TeacherDao {
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	/*public void getTeachersSubject(Teacher teacher) {
		 SubjectDaoimpl sb=new SubjectDaoimpl();
		 
			List<Subject> subjectList =sb.getAllSubject();
			for(int i=0;i<subjectList.size();i++) {
				//System.out.println(subjectList.get(i));
				if(subjectList.get(i).getTeacher().getName().equals(teacher.getName())) {
					teacher.getSubject().add(subjectList.get(i));
				}
			}
	}*/
	public void getSetScoreTeacher(Teacher teacher) {
		//Teacher teacher=this.getTeacherToid(tid);
		if(teacher.isSetScoreTeacher()) {
		OpenportDaoimpl od=new OpenportDaoimpl();
		List<Subject> opensubjectList =od.getAllopeantempsubject(teacher);
		for(int i=0;i<opensubjectList.size();i++) {
			teacher.getOpeningReport().getsubjectsO().add(opensubjectList.get(i));
		}
		MiddleportDaoimpl md=new MiddleportDaoimpl();
		List<Subject> middlesubjectList =md.getAllmiddletempsubject(teacher);
		for(int i=0;i<middlesubjectList.size();i++) {
			teacher.getIntermReport().getsubjectsI().add(middlesubjectList.get(i));
		}
		FinalportDaoimpl fd=new FinalportDaoimpl();
		List<Subject> finalsubjectList =fd.getAllfinaltempsubject(teacher);
		for(int i=0;i<finalsubjectList.size();i++) {
			teacher.getGraduationReport().getsubjectsG().add(finalsubjectList.get(i));
		}
	}
	
	}
	public void insertTeacher(Teacher teacher,Subject subject) {
		String sql="insert into teacher(t_id,t_name,isSetScoreTeacher,id) value(?,?,?,?)";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setString(1, teacher.getId());
			pstmt.setString(2, teacher.getName());
			pstmt.setBoolean(3,teacher.isSetScoreTeacher() );
			pstmt.setInt(4, subject.getId());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void updateTeacher(Teacher teacher,Subject subject) {
		String sql="update teacher set t_name=?,isSetScoreTeacher=?,id=? where t_id=?";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setString(1, teacher.getName());
			pstmt.setBoolean(2, teacher.getisSetScoreTeacher());
			pstmt.setInt(3,subject.getId() );
			pstmt.setString(4, teacher.getId());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public Teacher getTeacherToid(String tid) {
		//List<Teacher> teacherList = new ArrayList<Teacher>();
		String sql="select * from teacher where teacher.t_id=?";
		Teacher teacher = new Teacher();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		pstmt.setString(1, tid);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			teacher.setId(rs.getString(1));
			teacher.setName(rs.getString(2));
			teacher.setisSetScoreTeacher(rs.getBoolean(3));
			teacher.getSubject().add(sud.getSubjectToid(rs.getInt(4)));
			if(teacher.isSetScoreTeacher()) {
				OpenportDaoimpl od=new OpenportDaoimpl();
				List<Subject> opensubjectList =od.getAllopeantempsubject(teacher);
				for(int i=0;i<opensubjectList.size();i++) {
					teacher.getOpeningReport().getsubjectsO().add(opensubjectList.get(i));
				}
				MiddleportDaoimpl md=new MiddleportDaoimpl();
				List<Subject> middlesubjectList =md.getAllmiddletempsubject(teacher);
				for(int i=0;i<middlesubjectList.size();i++) {
					teacher.getIntermReport().getsubjectsI().add(middlesubjectList.get(i));
				}
				FinalportDaoimpl fd=new FinalportDaoimpl();
				List<Subject> finalsubjectList =fd.getAllfinaltempsubject(teacher);
				for(int i=0;i<finalsubjectList.size();i++) {
					teacher.getGraduationReport().getsubjectsG().add(finalsubjectList.get(i));
				}
			}
		}
				


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return teacher;
	}

	public Teacher getTeacherToname(String tname) {
		//List<Teacher> teacherList = new ArrayList<Teacher>();
		String sql="select * from teacher where teacher.t_name=?";
		Teacher teacher = new Teacher();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		pstmt.setString(1, tname);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			teacher.setId(rs.getString(1));
			teacher.setName(rs.getString(2));
			teacher.setisSetScoreTeacher(rs.getBoolean(3));
			//System.out.println(rs.getInt(4));
			teacher.getSubject().add(sud.getSubjectToid(rs.getInt(4)));
			if(teacher.isSetScoreTeacher()) {
				OpenportDaoimpl od=new OpenportDaoimpl();
				List<Subject> opensubjectList =od.getAllopeantempsubject(teacher);
				for(int i=0;i<opensubjectList.size();i++) {
					teacher.getOpeningReport().getsubjectsO().add(opensubjectList.get(i));
				}
				MiddleportDaoimpl md=new MiddleportDaoimpl();
				List<Subject> middlesubjectList =md.getAllmiddletempsubject(teacher);
				for(int i=0;i<middlesubjectList.size();i++) {
					teacher.getIntermReport().getsubjectsI().add(middlesubjectList.get(i));
				}
				FinalportDaoimpl fd=new FinalportDaoimpl();
				List<Subject> finalsubjectList =fd.getAllfinaltempsubject(teacher);
				for(int i=0;i<finalsubjectList.size();i++) {
					teacher.getGraduationReport().getsubjectsG().add(finalsubjectList.get(i));
				}
			}
		}
				


		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return teacher;
	}
	
	public String tselectsql_name(String tname) throws ClassNotFoundException, SQLException {
		String sql="select * from teacher where teacher.id=subject.id and teacher.t_name=?";
		conn = getConn(); // 得到数据库连接
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, tname);

		return sql;
	}
	public List<Teacher> getAllTeacher() {
		List<Teacher> ownerList = new ArrayList<Teacher>();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		String preparedSql = "select * from Teacher";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(rs.getString(1));
				teacher.setName(rs.getString(2));
				teacher.setisSetScoreTeacher(rs.getBoolean(3));
				teacher.getSubject().add(sud.getSubjectToid(rs.getInt(4)));
				if(teacher.isSetScoreTeacher()) {
					OpenportDaoimpl od=new OpenportDaoimpl();
					List<Subject> opensubjectList =od.getAllopeantempsubject(teacher);
					for(int i=0;i<opensubjectList.size();i++) {
						teacher.getOpeningReport().getsubjectsO().add(opensubjectList.get(i));
					}
					MiddleportDaoimpl md=new MiddleportDaoimpl();
					List<Subject> middlesubjectList =md.getAllmiddletempsubject(teacher);
					for(int i=0;i<middlesubjectList.size();i++) {
						teacher.getIntermReport().getsubjectsI().add(middlesubjectList.get(i));
					}
					FinalportDaoimpl fd=new FinalportDaoimpl();
					List<Subject> finalsubjectList =fd.getAllfinaltempsubject(teacher);
					for(int i=0;i<finalsubjectList.size();i++) {
						teacher.getGraduationReport().getsubjectsG().add(finalsubjectList.get(i));
					}
				}
				ownerList.add(teacher);
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

	public boolean judge_id(String username) {
		List<Teacher> ownerList = this.getAllTeacher();
		for(int i=0;i<ownerList.size();i++) {
			if(username.equals(ownerList.get(i).getId())) {
				return true;
			}
		}
		return false;
	}
	public boolean judge_name(String tname) {
		List<Teacher> ownerList = this.getAllTeacher();
		for(int i=0;i<ownerList.size();i++) {
			if(tname.equals(ownerList.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
	public Teacher getTeacherTosubid(int id) {
		//List<Teacher> teacherList = new ArrayList<Teacher>();
		String sql="select * from teacher where teacher.id=?";
		Teacher teacher = new Teacher();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			teacher.setId(rs.getString(1));
			teacher.setName(rs.getString(2));
			teacher.setisSetScoreTeacher(rs.getBoolean(3));
			teacher.getSubject().add(sud.getSubjectToid(rs.getInt(4)));
			if(teacher.isSetScoreTeacher()) {
				OpenportDaoimpl od=new OpenportDaoimpl();
				List<Subject> opensubjectList =od.getAllopeantempsubject(teacher);
				for(int i=0;i<opensubjectList.size();i++) {
					teacher.getOpeningReport().getsubjectsO().add(opensubjectList.get(i));
				}
				MiddleportDaoimpl md=new MiddleportDaoimpl();
				List<Subject> middlesubjectList =md.getAllmiddletempsubject(teacher);
				for(int i=0;i<middlesubjectList.size();i++) {
					teacher.getIntermReport().getsubjectsI().add(middlesubjectList.get(i));
				}
				FinalportDaoimpl fd=new FinalportDaoimpl();
				List<Subject> finalsubjectList =fd.getAllfinaltempsubject(teacher);
				for(int i=0;i<finalsubjectList.size();i++) {
					teacher.getGraduationReport().getsubjectsG().add(finalsubjectList.get(i));
				}
			}
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
		super.closeAll(conn, pstmt, rs);
	}
	return teacher;
}
}
