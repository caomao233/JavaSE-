package report;

import entity.Subject;

public class OpeningReport extends Report {
	/*public void setLevel() {
		System.out.println("����Ϊ��Щͨ������Ŀ����");
		while(subjects.size()!=0){
			System.out.println("����Ϊ"+subjects.get(0).getTeam().getName()+"С�ӵ�"+subjects.get(0).getName()+"��Ŀ��������");
			String str1=sc.next();
			subjects.get(0).setlevel(str1);
			subjects.remove(0);
		}
	}*/
	//�����ŵ���Ŀҵ������ȥʵ�ְɡ�
	public void Setsocre(Subject subject,int s) {
		subject.getscoretemp().add(s);
	}
}
