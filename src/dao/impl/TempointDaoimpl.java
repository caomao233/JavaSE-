package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.OpenportDao;
import dao.TempointDao;
import entity.Student;
import entity.Subject;
import entity.Teacher;
import entity.Team;

public class TempointDaoimpl extends BaseDao implements TempointDao{
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	public void insertTempPoint(Subject subject,int point) {
		String sql="insert into tempoint(id,point) value(?,?)";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1, subject.getId());
			pstmt.setInt(2, point);
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	
	public void deleteTempPoint(Subject subject) {
		String sql="delete from tempoint where tempoint.id=?";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setInt(1,subject.getId());
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	public ArrayList<Integer> gettempscore(Subject subject) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		String sql="select point from tempoint where tempoint.id=?";
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		pstmt.setInt(1,subject.getId());
		rs = pstmt.executeQuery(); // ִ��SQL���
		while (rs.next()) {
			tempList.add(rs.getInt(1));//??????
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return tempList;
		}

}