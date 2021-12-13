package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Subject;

public interface TempointDao {
	public void insertTempPoint(Subject subject,int point);
	public void deleteTempPoint(Subject subject);
	public ArrayList<Integer> gettempscore(Subject subject);
	
}