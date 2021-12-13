package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.OpenportDao;
import entity.Subject;
import entity.Teacher;


public class OpenportDaoimpl extends BaseDao implements OpenportDao{
	private Connection conn = null; // 保存数据库连接

	private PreparedStatement pstmt = null; // 用于执行SQL语句

	private ResultSet rs = null; // 用户保存查询结果集
	public void insertopenport1(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'张之维')";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void insertopenport2(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'柳坤生')";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void insertopenport3(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'周全')";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void deleteopenport(Subject subject,Teacher teacher) {
		String sql="delete from openport where openport.id=? and checksir=?";
		try {
			conn = getConn(); // 得到数据库连接
			pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, teacher.getName());
			pstmt.executeUpdate(); // 执行SQL语句
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	//插入没必要传老师
	 //public String selectopenprot1()//这个东西是给老彭用的

	    public List<Subject> getAllopeantempsubject(Teacher teahcer) {
			List<Subject> ownerList = new ArrayList<Subject>();
			try {
			String preparedSql = "select * from openport where checksir=?";
			conn = getConn(); // 得到数据库连接
			SubjectDaoimpl subdo=new SubjectDaoimpl();
			pstmt = conn.prepareStatement(preparedSql); // 得到PreparedStatement对象
			pstmt.setString(1, teahcer.getName());
			rs = pstmt.executeQuery(); // 执行SQL语句
				while (rs.next()) {
					//Subject subject=new Subject();
					ownerList.add(subdo.getSubjectToid(rs.getInt(1)));
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

}