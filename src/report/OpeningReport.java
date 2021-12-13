package report;

import entity.Subject;

public class OpeningReport extends Report {
	/*public void setLevel() {
		System.out.println("请您为这些通过的项目评级");
		while(subjects.size()!=0){
			System.out.println("请您为"+subjects.get(0).getTeam().getName()+"小队的"+subjects.get(0).getName()+"项目进行评级");
			String str1=sc.next();
			subjects.get(0).setlevel(str1);
			subjects.remove(0);
		}
	}*/
	//评级放到项目业务类里去实现吧。
	public void Setsocre(Subject subject,int s) {
		subject.getscoretemp().add(s);
	}
}
