package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.SubjectDao;
import dao.TeacherDao;
import entity.Subject;
import entity.Teacher;
import entity.Team;
import dao.impl.TeacherDaoimpl;

public class SubjectDaoimpl extends BaseDao implements SubjectDao{
	private Connection conn = null; // 保存数据库连接
	private PreparedStatement pstmt = null; // 用于执行SQL语句
	private ResultSet rs = null; // 用户保存查询结果集
	private int re1;
	public void insertSubject(Subject subject) {
		try {
			String sql="insert into subject(id,name,level,result,isexist,openGrade,middleGrade,finalGrade,DU,stage) value(?,?,?,?,?,0,0,0,0,0)";
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.setString(3, subject.getLevel());
			pstmt.setString(4, subject.getResult());
			pstmt.setBoolean(5, subject.getIsExist());
			
			//pstmt.setString(9, subject.getTeacher().getId());
			//pstmt.setString(9,subject.getTeam().getName());
			
			re1 = pstmt.executeUpdate(); // 执行SQL语句
			
			//PreparedStatement pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}

	}
	public void updateSubject(Subject subject) {
		try {
			String sql="update subject set name=?,level=?,result=?,isexist=?,openGrade=?,middleGrade=?,finalGrade=?,DU=?,stage=? where subject.id=?";
			conn = getConn(); // 得到数据库连接
			//QueryRunner qr = new QueryRunner(true);
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setString(1, subject.getName());
			pstmt.setString(2, subject.getLevel());
			pstmt.setString(3, subject.getResult());
			pstmt.setBoolean(4, subject.getIsExist());
			pstmt.setInt(5, subject.getOpenGrade());
			pstmt.setInt(6, subject.getMiddleGrade());
			pstmt.setInt(7, subject.getFinalGrade());
			//pstmt.setString(8, subject.getTeacher().getId());
			
			//pstmt.setString(8, subject.getTeam().getName());
			pstmt.setInt(8, subject.getDU());
			System.out.println(subject.getStage());
			pstmt.setInt(9, subject.getStage());
			
			pstmt.setInt(10, subject.getId());
			
			re1 = pstmt.executeUpdate(); // 执行SQL语句
			
			//PreparedStatement pstmt=conn.prepareStatement(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	
	public List<Subject> getAllSubject() {
		List<Subject> ownerList = new ArrayList<Subject>();
		try {
		String preparedSql = "select * from Subject";
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
		rs = pstmt.executeQuery(); // 执行SQL语句
			while (rs.next()) {
				Subject Subject = new Subject();
				Subject.setId(rs.getInt(1));
				Subject.setName(rs.getString(2));
				Subject.setLevel(rs.getString(3));
				Subject.setResult(rs.getString(4));
				Subject.setIsExist(rs.getBoolean(5));
				Subject.setOpenGrade(rs.getInt(6));
				Subject.setMiddleGrade(rs.getInt(7));
				Subject.setFinalGrade(rs.getInt(8));
				//String id=rs.getString(9);
				//TeacherDaoimpl t=new TeacherDaoimpl();
				//Subject.setTeacher(t.getTeacherToid(id));
				Subject.setDU(rs.getInt(9));
				Subject.setStage(rs.getInt(10));
				TempointDaoimpl td=new TempointDaoimpl();
				ArrayList<Integer> tempList =td.gettempscore(Subject);
				for(int i=0;i<tempList.size();i++) {
					Subject.getScoertemp().add(tempList.get(i));
				}
				//System.out.println(Subject.getName());
				ownerList.add(Subject);
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
		List<Subject> ownerList = this.getAllSubject();
		for(int i=0;i<ownerList.size();i++) {
			if(username.equals(ownerList.get(i).getName())) {
				return true;
			}
		}
		return false;
	}
	/*public Subject getSubjectToport(int id,Teacher teacher) {
String sql="select * from subject where subject.id=?";
		
		
		Subject subject = new Subject();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		//PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			//System.out.println(rs.getInt(1));
			subject.setId(rs.getInt(1));
		    subject.setName(rs.getString(2));
			subject.setLevel(rs.getString(3));
			subject.setResult(rs.getString(4));
			subject.setIsExist(rs.getBoolean(5));
			subject.setOpenGrade(rs.getInt(6));
			subject.setMiddleGrade(rs.getInt(7));
			subject.setFinalGrade(rs.getInt(8));
			//Teacher teacher = new Teacher();
			//teacher.setId(rs.getInt(9));
			subject.setTeacher(teacher);
			
			String tname=rs.getString(10);
			TeamDaoimpl te=new TeamDaoimpl();
			subject.setTeam(te.getTeam(tname));
			//team.setName(rs.getString(10));
			subject.setDU(rs.getInt(11));
			TempointDaoimpl td=new TempointDaoimpl();
			ArrayList<Integer> tempList =td.gettempscore(subject);
			for(int i=0;i<tempList.size();i++) {
				subject.getScoertemp().add(tempList.get(i));
			}
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}

		return subject;
	}*/
	public Subject getSubjectToid(int id) {
		//List<Subject> subjectList = new ArrayList<Subject>();
		String sql="select * from subject where subject.id=?";
		
		
		Subject subject = new Subject();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		//PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			//System.out.println(rs.getInt(1));
			subject.setId(rs.getInt(1));
		    subject.setName(rs.getString(2));
			subject.setLevel(rs.getString(3));
			subject.setResult(rs.getString(4));
			subject.setIsExist(rs.getBoolean(5));
			subject.setOpenGrade(rs.getInt(6));
			subject.setMiddleGrade(rs.getInt(7));
			subject.setFinalGrade(rs.getInt(8));
			//Teacher teacher = new Teacher();
			//teacher.setId(rs.getInt(9));
			//String tid=rs.getString(9);
			//TeacherDaoimpl t=new TeacherDaoimpl();
			//subject.setTeacher(t.getTeacherToid(tid));
			
			subject.setDU(rs.getInt(9));
			subject.setStage(rs.getInt(10));
			
			
			TempointDaoimpl td=new TempointDaoimpl();
			ArrayList<Integer> tempList =td.gettempscore(subject);
			for(int i=0;i<tempList.size();i++) {
				subject.getScoertemp().add(tempList.get(i));
			}
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}

		return subject;
	}
	public Subject getSubjectToname(String name) {
		//List<Subject> subjectList = new ArrayList<Subject>();
		String sql="select * from subject where subject.name=?";
		
		
		Subject subject = new Subject();
		try {
		conn = getConn(); // 得到数据库连接
		pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
		//PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery(); // 执行SQL语句
		while(rs.next()) {
			//System.out.println(rs.getInt(1));
			subject.setId(rs.getInt(1));
		    subject.setName(rs.getString(2));
			subject.setLevel(rs.getString(3));
			subject.setResult(rs.getString(4));
			subject.setIsExist(rs.getBoolean(5));
			subject.setOpenGrade(rs.getInt(6));
			subject.setMiddleGrade(rs.getInt(7));
			subject.setFinalGrade(rs.getInt(8));
			//Teacher teacher = new Teacher();
			//teacher.setId(rs.getInt(9));
			//String id=rs.getString(9);
			//TeacherDaoimpl t=new TeacherDaoimpl();
			//subject.setTeacher(t.getTeacherToid(id));
			
			
			//team.setName(rs.getString(10));
			subject.setDU(rs.getInt(9));
			subject.setStage(rs.getInt(10));
			//TempointDaoimpl td=new TempointDaoimpl();
			//subject=td.selectTeam(subject);
			TempointDaoimpl td=new TempointDaoimpl();
			ArrayList<Integer> tempList =td.gettempscore(subject);
			for(int i=0;i<tempList.size();i++) {
				subject.getScoertemp().add(tempList.get(i));
			}
		}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}

		return subject;
	}

	public int updateSubject(String sql, Object[] param) {
		int count = super.executeSQL(sql, param);
		return count;
	}

	
  
    
	
	
	
	
	
}
