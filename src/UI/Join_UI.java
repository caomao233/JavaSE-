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

import dao.SubjectDao;
import dao.TeacherDao;
import dao.TeamDao;
import dao.impl.SubjectDaoimpl;
import dao.impl.TeacherDaoimpl;
import dao.impl.TeamDaoimpl;
import entity.Subject;
import role.Role;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Join_UI extends JFrame {
	JFrame thisFrame=this;
	private JPanel contentPane;
	private JTextField textField;
	String subject_name;
	Role student;
	Subject subject;
	SubjectDao subjectDao=new SubjectDaoimpl();
	TeamDao	teamDao=new TeamDaoimpl();
	TeacherDao teacherDao=new TeacherDaoimpl();
	/**
	 * Create the frame.
	 */
	public Join_UI(Role role1) {
		student=role1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(10, 10, 357, 55);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		lblNewLabel_1.setIcon(new ImageIcon(Join_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("【"+student.getStudent().getId()+"】"+student.getStudent().getName());
		lblNewLabel_2.setBounds(0, 75, 250, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Join_UI.class.getResource("/UI/\u52A0\u5165\u9879\u76EE.png")));
		lblNewLabel_3.setBounds(10, 104, 65, 65);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel_4.setFont(new Font("黑体", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(107, 104, 76, 40);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(368, 149, 153, 15);
		contentPane.add(lblNewLabel_9);
		
		textField = new JTextField();
		textField.setBounds(193, 114, 162, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(107, 270, 130, 15);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_5 = new JLabel("\u9879\u76EE\u540D\u79F0\uFF1A");
		lblNewLabel_5.setBounds(107, 185, 250, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8D1F\u8D23\u4EBA\uFF1A");
		lblNewLabel_6.setBounds(107, 210, 250, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u6307\u5BFC\u8001\u5E08\uFF1A");
		lblNewLabel_7.setBounds(107, 235, 250, 15);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("\u52A0\u5165");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.join(subject);//加入 
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
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton_1.setBounds(234, 260, 89, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("\u67E5\u627E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subject_name=textField.getText();
				if(!subjectDao.judge(subject_name)) {
					lblNewLabel_9.setText("无该项目");
					btnNewButton_1.setEnabled(false);
				}
				else {
						subject=subjectDao.getSubjectToname(subject_name);
					lblNewLabel_5.setText("\u9879\u76EE\u540D\u79F0\uFF1A"+subject.getName());
					lblNewLabel_6.setText("\u8D1F\u8D23\u4EBA\uFF1A"+teamDao.getTeamtoid(subject.getId()).getStudents().get(0).getName());
					lblNewLabel_7.setText("\u6307\u5BFC\u8001\u5E08\uFF1A"+teacherDao.getTeacherTosubid(subject.getId()).getName());
					if(teamDao.getTeamtoid(subject.getId()).getStudents().size()==6) {
						lblNewLabel_8.setText("\u9879\u76EE\u4EBA\u6570\u5DF2\u6EE1");
						btnNewButton_1.setEnabled(false);
					}
					else {
						lblNewLabel_8.setText("");
						btnNewButton_1.setEnabled(true);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		btnNewButton.setBounds(234, 139, 89, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(Join_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6_1.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("New label");
		lblNewLabel_6_2.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_2);
	}

}
