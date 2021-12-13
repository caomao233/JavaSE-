package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.TeamDao;
import dao.impl.TeamDaoimpl;
import role.Role;

public class Teacher_Check_UI extends JFrame {
	Role instructor;
	private JPanel contentPane;
	TeamDao	teamDao=new TeamDaoimpl();

	/**
	 * Create the frame.
	 */
	public Teacher_Check_UI(Role instructor1) {
		instructor=instructor1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//instructor.check();
		instructor.print();
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 357, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teacher_Check_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("【"+instructor.getTeacher().getId()+"】"+instructor.getTeacher().getName());
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 73, 323, 30);
		contentPane.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(Teacher_Check_UI.class.getResource("/UI/\u6211\u7684\u9879\u76EE.png")));
		lblNewLabel_3_2.setBounds(20, 109, 65, 64);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_5.setBounds(182, 107, 228, 103);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3.setBounds(182, 107, 323, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(182, 132, 323, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel();
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4_1.setBounds(182, 158, 323, 15);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1 = new JLabel();
		lblNewLabel_3_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(182, 183, 323, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel();
		lblNewLabel_4_2.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4_2.setBounds(182, 208, 323, 15);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel();
		lblNewLabel_4_1_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4_1_1.setBounds(182, 230, 323, 15);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel();
		lblNewLabel_3_1_1.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(182, 255, 323, 15);
		contentPane.add(lblNewLabel_3_1_1);

		JLabel lblNewLabel_4_2_1 = new JLabel();
		lblNewLabel_4_2_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4_2_1.setBounds(182, 280, 323, 15);
		contentPane.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel();
		lblNewLabel_4_1_1_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_4_1_1_1.setBounds(182, 306, 323, 15);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		
		JLabel lblNewLabel_51 = new JLabel();
		lblNewLabel_51.setIcon(new ImageIcon(Teacher_Check_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_51.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_51);
		
		if(instructor.getTeacher().getSubject().isEmpty()) {
			lblNewLabel_5.setText("\u6682\u65E0\u9879\u76EE");
		}
		else {
		 lblNewLabel_3.setText("【"+instructor.getTeacher().getSubject().get(0).getId()+"】"+instructor.getTeacher().getSubject().get(0).getName()+"("+instructor.getTeacher().getSubject().get(0).getLevel()+")"); 

		
		lblNewLabel_4.setText("\u8D1F\u8D23\u4EBA\uFF1A"+teamDao.getTeamtoid(instructor.getTeacher().getSubject().get(0).getId()).getStudents().get(0).getName()); 
		
		lblNewLabel_4_1.setText("\u5F53\u524D\u72B6\u6001\uFF1A"+instructor.getTeacher().getSubject().get(0).getSchedule());

		if(instructor.getTeacher().getSubject().size()<2) {
			
		}
		else {
		lblNewLabel_3_1.setText("【"+instructor.getTeacher().getSubject().get(1).getId()+"】"+instructor.getTeacher().getSubject().get(1).getName()+"("+instructor.getTeacher().getSubject().get(0).getLevel()+")");

		lblNewLabel_4_2.setText("\u8D1F\u8D23\u4EBA\uFF1A"+teamDao.getTeamtoid(instructor.getTeacher().getSubject().get(1).getId()).getStudents().get(0).getName());

		lblNewLabel_4_1_1.setText("\u5F53\u524D\u72B6\u6001\uFF1A"+instructor.getTeacher().getSubject().get(1).getSchedule());

		if(instructor.getTeacher().getSubject().size()<3) {
			
		}
		else {
		lblNewLabel_3_1_1.setText("【"+instructor.getTeacher().getSubject().get(2).getId()+"】"+instructor.getTeacher().getSubject().get(2).getName()+"("+instructor.getTeacher().getSubject().get(0).getLevel()+")");

		lblNewLabel_4_2_1.setText("\u8D1F\u8D23\u4EBA\uFF1A"+teamDao.getTeamtoid(instructor.getTeacher().getSubject().get(2).getId()).getStudents().get(0).getName());
	
		lblNewLabel_4_1_1_1.setText("\u5F53\u524D\u72B6\u6001\uFF1A"+instructor.getTeacher().getSubject().get(2).getSchedule());

		}
		}
		}
	}
}
