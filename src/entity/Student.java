package entity;
public class Student {
	String name=new String();
	String id=new String();
	Subject subject=new Subject();
	boolean iscaptain;
	boolean isjoin;
	//Team team=new Team();
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	/*public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Subject getS() {
		return subject;
	}
	public void setS(Subject subject) {
		this.subject = subject;
	}
	public boolean isIscaptain() {
		return iscaptain;
	}
	public void setIscaptain(boolean iscaptain) {
		this.iscaptain = iscaptain;
	}
	public boolean isIsjoin() {
		return isjoin;
	}
	public void setIsjoin(boolean isjoin) {
		this.isjoin = isjoin;
	}

}
