package entity;

import java.io.FileWriter;

import java.util.ArrayList;
//import java.util.List;

public class Subject{//如果两次答辩被刷下来，那么直接删除对象，相应的小队也不再是成员身份，当然失败会通知他们在删除
	String name=new String();
	String level=new String();
	String result=new String();
	int id;
	boolean isexist=true;
	int openGrade=0;
	int middleGrade=0;
	int finalGrade=0;
	
	//这些东西不用再数据库中体现
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
	
	int stage=0;//0:还没开题,1:完成开题答辩,2:完成中期答辩,3:完成结业答辩,4:提交了开题答辩正在等待是否通过,5:提交了中期答辩正在等待是否通过,6:提交了结业答辩正在等待是否通过
				//7：开题答辩不合格取消项目，三个老师有两个老师给出了不合格就取消；8：9：对应中期，结业，处理与开题同理
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
				return "您的项目还没开始";
			}
			else if(stage==1){
				return "您的项目已经通过开题答辩";
			}
			else if(stage==2){
				return "您的项目已经通过中期答辩";
			}
			else if(stage==3){
				return "您的项目已经通过结业答辩";
			}
			else if(stage==4){
				return "您的开题检查正在等待评分";
			}
			else if(stage==5){
				return "您的中期检查正在等待评分";
			}
			else if(stage==6){
				return "您的结项答辩正在等待评分";
			}
		}
		else {
			return "您的项目未通过";
		}
		return null;
	}
	public void setSchedule(String schedule) {//想在这里设计一个能书写写入文件的类
		this.schedule = schedule;
	}

}
