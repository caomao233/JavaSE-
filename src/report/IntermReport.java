package report;

import entity.Subject;

public class IntermReport extends Report {
	public void Setsocre(Subject subject,int s) {
		subject.getscoretemp().add(s);
	}
}
