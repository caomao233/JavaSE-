package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import authority.impl.Captain;
import authority.impl.Instructor;
import authority.impl.Member;
import authority.impl.Normal;
import dao.StudentDao;
import dao.TeacherDao;
import dao.impl.StudentDaoimpl;
import dao.impl.TeacherDaoimpl;
import entity.Student;
import entity.Teacher;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import role.Role;
import java.awt.Toolkit;
public class Login_UI extends JFrame {
	private Role role = null;
	private  JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	String username;
	String password;
	JFrame thisFrame=this;
	private final JLabel lblNewLabel_6 = new JLabel("New label");

	/**
	 * Create the frame.
	 */
	public Login_UI() {
		setTitle("\u767B\u5F55");

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 357, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login_UI.class.getResource("/UI/\u767B\u5F55.png")));
		lblNewLabel_2.setBounds(10, 70, 66, 66);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8D26\u53F7\u767B\u5F55");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 136, 68, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(146, 120, 66, 26);
		contentPane.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(206, 123, 151, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(146, 159, 66, 26);
		contentPane.add(lblNewLabel_4_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(206, 159, 151, 21);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_5 = new JLabel("\u6CE8\uFF1A\u7528\u6237\u540D\u4E3A\u6559\u804C\u5DE5\u53F7\u6216\u5B66\u53F7\r\n");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(146, 178, 248, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u5BC6\u7801\u9ED8\u8BA4\u4E3A123456");
		lblNewLabel_5_1.setForeground(Color.RED);
		lblNewLabel_5_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5_1.setBounds(146, 205, 248, 35);
		contentPane.add(lblNewLabel_5_1);
		
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(336, 247, 144, 17);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.RED);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDao studentDao=new StudentDaoimpl();
				TeacherDao teacherDao=new TeacherDaoimpl();
				
					lblNewLabel_7.setText("?");
					password=textField_1.getText();
					username=textField.getText();
						if(studentDao.judge(username)) {
							Student student=new Student();
								student=studentDao.getStudent(username);
								if(student.isIscaptain()) {
									Role captain = new Role();// 创建负责人角色
									captain.setStudent(student);
									captain.setDescription("负责人");
									Captain dfCaptain=new Captain();//创建负责人权限
									captain.setCaptain(dfCaptain);// 分配权限
									role=captain;// 为用户授权角色
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Student_UI frame = new Student_UI(captain);
												frame.setVisible(true);
											} catch (Exception ex) {
												ex.printStackTrace();
											}
										}
									});
								}
								else if(student.isIsjoin()) {
									Role member = new Role();// 创建成员角色
									member.setDescription("成员");
									member.setStudent(student);
									Member dfMember=new Member();//创建成员权限
									member.setMember(dfMember);// 分配权限
									role=member;// 为用户授权角色
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Student_UI frame = new Student_UI(member);
												frame.setVisible(true);
											} catch (Exception ex) {
												ex.printStackTrace();
											}
										}
									});
								}
								else {
									Role normal = new Role();// 创建未加入角色
									normal.setDescription("未加入");
									normal.setStudent(student);
									Normal dfNormal=new Normal();//创建未加入权限
									normal.setNormal(dfNormal);// 分配权限
									role=normal;// 为用户授权角色
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Not_joined_UI frame = new Not_joined_UI(normal);
												frame.setVisible(true);
											} catch (Exception ex) {
												ex.printStackTrace();
											}
										}
									});		
								}
								thisFrame.dispose();
						}
						else if(password.equals("123456")) {
							if(teacherDao.judge_id(username)) {
								Teacher teacher=new Teacher();
								teacher=teacherDao.getTeacherToid(username);
								Role instructor = new Role();// 创建老师角色
								instructor.setTeacher(teacher);
								instructor.setDescription("老师");
								Instructor dfInstructor=new Instructor();//创建老师权限
								instructor.setInstructor(dfInstructor);// 分配权限
								role=instructor;// 为用户授权角色
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											Teacher_UI frame = new Teacher_UI(instructor);
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
								thisFrame.dispose();
							}
					else {
						lblNewLabel_7.setText("用户名或密码不正确");
					}
				}
				else {
					lblNewLabel_7.setText("用户名或密码不正确");
				}

			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(206, 241, 97, 23);
		contentPane.add(btnNewButton);
		lblNewLabel_6.setIcon(new ImageIcon(Login_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6);
	}
}