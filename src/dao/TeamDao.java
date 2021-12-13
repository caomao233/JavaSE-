package dao;

import java.sql.SQLException;
import java.util.List;
import entity.Student;
import entity.Team;
import entity.Subject;
public interface TeamDao {
	public void insertTeam(Team Team,Student student,Subject subject);
	public Team getTeamtoid(int id);
	
	//public void getTeamStudent(Team team);
}
