package report;
import entity.Subject;
public class GraduationReport extends Report {
	/*public void judgeGreat() {
		
	}*/
	public void Setsocre(Subject subject,int s) {
			subject.getscoretemp().add(s);
			
	}
}
