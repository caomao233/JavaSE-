package role;
import authority.impl.Captain;
import authority.impl.Instructor;
import authority.impl.Member;
import authority.impl.Normal;
import entity.Student;
import entity.Subject;
import entity.Teacher;
public class Role {
		private Student student;
		private Teacher teacher;
		public String description;// 角色名
		public Student getStudent() {
			return student;
		}
		public void setStudent(Student student) {
			this.student = student;
		}
		public Teacher getTeacher() {
			return teacher;
		}
		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
		public Captain captain = null;//负责人权限
		public Normal normal = null;//未加入权限
		public Member member = null;//队员权限
		public Instructor instructor = null;//老师权限
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Captain getCaptain() {
			return captain;
		}
		public void setCaptain(Captain captain) {
			this.captain = captain;
		}
		public Normal getNormal() {
			return normal;
		}
		public void setNormal(Normal normal) {
			this.normal = normal;
		}
		public Member getMember() {
			return member;
		}
		public void setMember(Member member) {
			this.member = member;
		}
		public Instructor getInstructor() {
			return instructor;
		}
		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}
		public void join(Subject subject) {//加入
			if(normal!=null)
				normal.join(student, subject);
		}
		public void apply(String subject_name,Teacher teacher) {//申报
			if(normal!=null)
				normal.apply(subject_name, student, teacher);
		}
		public void study() {//提交学习成果
			if(captain!=null)
				captain.study(student);
			else
				member.study(student);
		}
		public void setGsocre(Subject subject,int s) {//结项答辩评分
			instructor.setGsocre(subject, s);
		}
		public void setIsocre(Subject subject,int s) {//中期答辩评分
			instructor.setIsocre(subject, s);
		}
		public void setOsocre(Subject subject,int s) {//开题答辩评分
			instructor.setOsocre(subject, s);
		}
		public void go_report(int i) {//1为开题，2为中期，3为结项
			captain.go_report(student.getS(),i);
		}
		public void check() {
			if(instructor!=null)
				instructor.check();
			else if(captain!=null)
				captain.check(student);
			else if(member!=null)
				member.check(student);
		}
		public void print() {
			System.out.println("?");
		}
}
