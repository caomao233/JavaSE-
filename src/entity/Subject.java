package entity;

import java.io.FileWriter;

import java.util.ArrayList;
//import java.util.List;

public class Subject{//������δ�类ˢ��������ôֱ��ɾ��������Ӧ��С��Ҳ�����ǳ�Ա��ݣ���Ȼʧ�ܻ�֪ͨ������ɾ��
	String name=new String();
	String level=new String();
	String result=new String();
	int id;
	boolean isexist=true;
	int openGrade=0;
	int middleGrade=0;
	int finalGrade=0;
	
	//��Щ�������������ݿ�������
	ArrayList<Integer> scoertemp=new ArrayList();
	//Teacher teacher=new Teacher();
	String schedule=new String();
	public boolean isIsexist() {
		return isexist;
	}
	public void setIsexist(boolean isexist) {
		this.isexist = isexist;
	}
	public ArrayList<Integer> getScoertemp() {
		return scoertemp;
	}
	public void setScoertemp(ArrayList<Integer> scoertemp) {
		this.scoertemp = scoertemp;
	}
	public void setDU(int dU) {
		DU = dU;
	}
	
	int stage=0;//0:��û����,1:��ɿ�����,2:������ڴ��,3:��ɽ�ҵ���,4:�ύ�˿��������ڵȴ��Ƿ�ͨ��,5:�ύ�����ڴ�����ڵȴ��Ƿ�ͨ��,6:�ύ�˽�ҵ������ڵȴ��Ƿ�ͨ��
				//7�������粻�ϸ�ȡ����Ŀ��������ʦ��������ʦ�����˲��ϸ��ȡ����8��9����Ӧ���ڣ���ҵ�������뿪��ͬ��
	int DU=0;
	//FileWriter out = new FileWriter("D:\\1.txt", true); 
	public void setResult(String str1){
		result=str1;
	}
	public String getResult(){
		return result;
	}
	public void setIsExist(boolean b){
		isexist=b;
	}
	public boolean getIsExist(){
		return isexist;
	}
	public ArrayList<Integer> getscoretemp(){
		return scoertemp;
	}
	public void setLevel(String l){
		level=l;
	}
	public String getLevel(){
		return level;
	}
	public void setStage(int i){
		stage=i;
	}
	public int getStage(){
		return stage;
	}
	/*public Team getTeam(){
		return team;
	}*/
	public void countDu(){
		DU+=10;
	}
	public int getDU(){
		return DU;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOpenGrade() {
		return openGrade;
	}
	public void setOpenGrade(int openGrade) {
		this.openGrade = openGrade;
	}
	public int getMiddleGrade() {
		return middleGrade;
	}
	public void setMiddleGrade(int middleGrade) {
		this.middleGrade = middleGrade;
	}
	public int getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}
	/*public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}*/
	
	/*public void setTeam(Team team) {
		this.team = team;
	}*/
	public String getSchedule() {
		if(this.isexist) {
			if(stage==0){
				return "������Ŀ��û��ʼ";
			}
			else if(stage==1){
				return "������Ŀ�Ѿ�ͨ��������";
			}
			else if(stage==2){
				return "������Ŀ�Ѿ�ͨ�����ڴ��";
			}
			else if(stage==3){
				return "������Ŀ�Ѿ�ͨ����ҵ���";
			}
			else if(stage==4){
				return "���Ŀ��������ڵȴ�����";
			}
			else if(stage==5){
				return "�������ڼ�����ڵȴ�����";
			}
			else if(stage==6){
				return "���Ľ��������ڵȴ�����";
			}
		}
		else {
			return "������Ŀδͨ��";
		}
		return null;
	}
	public void setSchedule(String schedule) {//�����������һ������дд���ļ�����
		this.schedule = schedule;
	}

}
