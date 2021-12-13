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
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	public void insertopenport1(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'��֮ά')";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void insertopenport2(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'������')";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public void insertopenport3(Subject subject) {
		String sql="insert into openport(id,name,checksir) value(?,?,'��ȫ')";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.executeUpdate(); // ִ��SQL���
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
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1, subject.getId());
			pstmt.setString(2, teacher.getName());
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	//����û��Ҫ����ʦ
	 //public String selectopenprot1()//��������Ǹ������õ�

	    public List<Subject> getAllopeantempsubject(Teacher teahcer) {
			List<Subject> ownerList = new ArrayList<Subject>();
			try {
			String preparedSql = "select * from openport where checksir=?";
			conn = getConn(); // �õ����ݿ�����
			SubjectDaoimpl subdo=new SubjectDaoimpl();
			pstmt = conn.prepareStatement(preparedSql); // �õ�PreparedStatement����
			pstmt.setString(1, teahcer.getName());
			rs = pstmt.executeQuery(); // ִ��SQL���
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