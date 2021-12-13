package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TeamDao;
import entity.Subject;
import entity.Teacher;
import entity.Team;
import entity.Student;
public class TeamDaoimpl extends BaseDao implements TeamDao {
	private Connection conn = null; // �������ݿ�����

	private PreparedStatement pstmt = null; // ����ִ��SQL���

	private ResultSet rs = null; // �û������ѯ�����
	/*public List<Team>getallteam(){
		List<Team> teamList = new ArrayList<Team>();
		String sql="select teamname from team ";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			rs = pstmt.executeQuery(); // ִ��SQL���
			while(rs.next()) {
				System.out.println(rs.getString(1));
				//teamList.add(this.getTeams(rs.getString(1)));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
		return teamList;
	}*/
	public void insertTeam(Team Team,Student student,Subject subject) {
		String sql="insert into Team(teamname,s_id,id) value(?,?,?)";
		try {
			conn = getConn(); // �õ����ݿ�����
			pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
			pstmt.setString(1, Team.getName());
			pstmt.setString(2,student.getId() );
			pstmt.setInt(3,subject.getId());
			pstmt.executeUpdate(); // ִ��SQL���
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				super.closeAll(conn, pstmt, rs);
			}
	}
	/*public Team getTeams(String teamname) {
		//List<Team> teamList = new ArrayList<Team>();
		String sql="select * from team where team.teamname=?";
		Team Team = new Team();
		StudentDaoimpl std=new StudentDaoimpl();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		pstmt.setString(1, teamname);
		rs = pstmt.executeQuery(); // ִ��SQL���
		while(rs.next()) {
			Team.setName(rs.getString(1));
			Team.getStudents().add(std.getStudent(rs.getString(2)));
			Team.setSubject(sud.getSubjectToid(rs.getInt(3)));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return Team;
	}*/
	public Team getTeamtoid(int id) {
		String sql="select * from team where team.id=?";
		Team Team = new Team();
		StudentDaoimpl std=new StudentDaoimpl();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery(); // ִ��SQL���
		while(rs.next()) {
			Team.setName(rs.getString(1));
			Team.getStudents().add(std.getStudent(rs.getString(2)));
			Team.setSubject(sud.getSubjectToid(rs.getInt(3)));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return Team;
	}
	public Team getTeam(String teamname) {
		//List<Team> teamList = new ArrayList<Team>();
		String sql="select * from team where team.teamname=?";
		Team Team = new Team();
		StudentDaoimpl std=new StudentDaoimpl();
		SubjectDaoimpl sud=new SubjectDaoimpl();
		try {
		conn = getConn(); // �õ����ݿ�����
		pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
		pstmt.setString(1, teamname);
		rs = pstmt.executeQuery(); // ִ��SQL���
		while(rs.next()) {
			Team.setName(rs.getString(1));
			Team.getStudents().add(std.getStudent(rs.getString(2)));
			Team.setSubject(sud.getSubjectToid(rs.getInt(3)));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			super.closeAll(conn, pstmt, rs);
		}
		return Team;
	}
	/*public void getTeamStudent(Team team) {
		StudentDaoimpl sb=new StudentDaoimpl();
		
		List<Student> studentList =sb.getAllStudent();
		for(int i=0;i<studentList.size();i++) {
			if(studentList.get(i).getTeam().getName().equals(team.getName())) {
				team.getStudents().add(studentList.get(i));
			}
		}
	}*/
    
}
