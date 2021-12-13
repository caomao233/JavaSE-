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
		public String description;// ��ɫ��
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
		public Captain captain = null;//������Ȩ��
		public Normal normal = null;//δ����Ȩ��
		public Member member = null;//��ԱȨ��
		public Instructor instructor = null;//��ʦȨ��
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
		public void join(Subject subject) {//����
			if(normal!=null)
				normal.join(student, subject);
		}
		public void apply(String subject_name,Teacher teacher) {//�걨
			if(normal!=null)
				normal.apply(subject_name, student, teacher);
		}
		public void study() {//�ύѧϰ�ɹ�
			if(captain!=null)
				captain.study(student);
			else
				member.study(student);
		}
		public void setGsocre(Subject subject,int s) {//����������
			instructor.setGsocre(subject, s);
		}
		public void setIsocre(Subject subject,int s) {//���ڴ������
			instructor.setIsocre(subject, s);
		}
		public void setOsocre(Subject subject,int s) {//����������
			instructor.setOsocre(subject, s);
		}
		public void go_report(int i) {//1Ϊ���⣬2Ϊ���ڣ�3Ϊ����
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
