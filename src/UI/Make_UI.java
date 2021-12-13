package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SubjectDao;
import dao.TeacherDao;
import dao.impl.SubjectDaoimpl;
import dao.impl.TeacherDaoimpl;
import entity.Teacher;
import role.Role;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Make_UI extends JFrame {
	JFrame thisFrame=this;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String subject_name;
	String teacher_name;
	Role student;
	Teacher teacher;
	SubjectDao subjectDao=new SubjectDaoimpl();
	TeacherDao teacherDao=new TeacherDaoimpl();
	/**
	 * Create the frame.
	 */
	public Make_UI(Role role1) {
		student=role1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setBounds(10, 10, 357, 55);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		lblNewLabel_1.setIcon(new ImageIcon(Make_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("【"+student.getStudent().getId()+"】"+student.getStudent().getName());
		lblNewLabel_2.setBounds(0, 75, 250, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 113, 65, 64);
		lblNewLabel_3.setIcon(new ImageIcon(Make_UI.class.getResource("/UI/\u9879\u76EE\u7533\u62A5.png")));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(126, 113, 79, 22);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(213, 115, 144, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6307\u5BFC\u8001\u5E08\uFF1A");
		lblNewLabel_5.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(126, 145, 79, 22);
		contentPane.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 146, 144, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(367, 188, 219, 39);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_6.setText("");
				subject_name=textField.getText();
				teacher_name=textField_1.getText();
				if(subjectDao.judge(subject_name)) {
					lblNewLabel_6.setText("已有该项目名！");
				}
				else {
					if(!teacherDao.judge_name(teacher_name)) {
				    	lblNewLabel_6.setText("无该指导老师！");
					}
					else {
							teacher=teacherDao.getTeacherToname(teacher_name);
						if(teacher.getSubject().size()==3) {
							lblNewLabel_6.setText("该指导老师项目已满！");
						}
						else {
							student.apply(subject_name,teacher);//申报，student
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Restart_UI frame = new Restart_UI();
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							thisFrame.dispose();
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(213, 188, 97, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(Make_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6_1.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_1);

	}
}
