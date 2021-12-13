package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.Student;
import role.Role;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_UI extends JFrame {
	Role student;
	JFrame thisFrame=this;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Student_UI(Role role1) {
		student=role1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		student.check();
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setBounds(10, 10, 357, 55);
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		lblNewLabel_1.setIcon(new ImageIcon(Student_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("【"+student.getStudent().getId()+"】"+student.getStudent().getName());
		lblNewLabel_2.setBounds(0, 75, 250, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("【"+student.getStudent().getS().getId()+"】"+student.getStudent().getS().getName()+"（"+student.getStudent().getS().getLevel()+"）");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2_1.setBackground(new Color(51, 153, 255));
		lblNewLabel_2_1.setBounds(253, 75, 323, 30);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Student_UI.class.getResource("/UI/\u6211\u7684\u9879\u76EE.png")));
		lblNewLabel_3.setBounds(10, 105, 75, 65);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5F53\u524D\u8FDB\u5EA6\uFF1A"+student.getStudent().getS().getDU());
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(95, 105, 118, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(253, 134, 194, 26);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4\u5B66\u4E60\u6210\u679C");
		if(!student.getStudent().getS().getIsExist())
			btnNewButton.setEnabled(false);
		else if(student.getStudent().getS().getDU()==0) {
			btnNewButton.setEnabled(false);
			lblNewLabel_8.setText("请参加开题报告或等待评分");
		}
		else if(student.getStudent().getS().getDU()==50) {
			btnNewButton.setEnabled(false);
			lblNewLabel_8.setText("请参加中期检查或等待评分");
		}
		else if(student.getStudent().getS().getDU()==100) {
			btnNewButton.setEnabled(false);
			lblNewLabel_8.setText("请参加结项答辩或等待评分");
		}

			btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Student_study_UI frame = new Student_study_UI(student);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			}
		});
		btnNewButton.setBounds(95, 130, 118, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("\u5F00\u9898\u62A5\u544A");
		lblNewLabel_5.setFont(new Font("黑体", Font.BOLD, 17));
		lblNewLabel_5.setBounds(10, 190, 88, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u5F53\u524D\u72B6\u6001\uFF1A");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 223, 144, 15);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("\u53C2\u52A0\u7B54\u8FA9");
		btnNewButton_1.setEnabled(false);
		if(student.getStudent().getS().getDU()==0&&student.getCaptain()!=null&&student.getStudent().getS().getStage()==0) 
			btnNewButton_1.setEnabled(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.go_report(1);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Student_report_UI frame = new Student_report_UI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				thisFrame.dispose();
			}
		});
		btnNewButton_1.setBounds(10, 248, 98, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("\u4E2D\u671F\u68C0\u67E5");
		lblNewLabel_5_1.setFont(new Font("黑体", Font.BOLD, 17));
		lblNewLabel_5_1.setBounds(226, 190, 88, 23);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("\u5F53\u524D\u72B6\u6001\uFF1A");
		lblNewLabel_6_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_6_1.setBounds(226, 223, 144, 15);
		contentPane.add(lblNewLabel_6_1);
		
		JButton btnNewButton_1_1 = new JButton("\u53C2\u52A0\u7B54\u8FA9");
		btnNewButton_1_1.setEnabled(false);
		if(student.getStudent().getS().getDU()==50&&student.getCaptain()!=null&&student.getStudent().getS().getStage()==1) 
			btnNewButton_1_1.setEnabled(true);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.go_report(2);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Student_report_UI frame = new Student_report_UI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	thisFrame.dispose();
			}
		});
		btnNewButton_1_1.setBounds(226, 248, 104, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("\u7ED3\u9879\u7B54\u8FA9");
		lblNewLabel_5_1_1.setFont(new Font("黑体", Font.BOLD, 17));
		lblNewLabel_5_1_1.setBounds(426, 190, 88, 23);
		contentPane.add(lblNewLabel_5_1_1);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("\u5F53\u524D\u72B6\u6001\uFF1A");
		lblNewLabel_6_1_1.setFont(new Font("宋体", Font.PLAIN, 13));
		lblNewLabel_6_1_1.setBounds(426, 223, 144, 15);
		contentPane.add(lblNewLabel_6_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("\u53C2\u52A0\u7B54\u8FA9");
		btnNewButton_1_1_1.setEnabled(false);
		if(student.getStudent().getS().getDU()==100&&student.getCaptain()!=null&&student.getStudent().getS().getStage()==2) 
			btnNewButton_1_1.setEnabled(true);
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.go_report(3);
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Student_report_UI frame = new Student_report_UI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	thisFrame.dispose();
			}
		});
		btnNewButton_1_1_1.setBounds(426, 248, 98, 23);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblNewLabel_7 = new JLabel("\u6CE8\uFF1A1\u3001\u53EA\u6709\u9879\u76EE\u8D1F\u8D23\u4EBA\u9009\u62E9\u662F\u5426\u53C2\u52A0\u7B54\u8FA9\r\n");
		lblNewLabel_7.setForeground(new Color(204, 0, 0));
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7.setBounds(10, 270, 482, 15);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("\r\n\t3\u3001\u6BCF\u4E2A\u5C0F\u7EC4\u6210\u5458\u5747\u53EF\u63D0\u4EA4\u5B66\u4E60\u6210\u679C\u6765\u63D0\u9AD8\u8FDB\u5EA6");
		lblNewLabel_7_1_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_7_1_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7_1_1.setBounds(10, 305, 482, 15);
		contentPane.add(lblNewLabel_7_1_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("\t2\u3001\u5F53\u8FDB\u5EA6\u5206\u522B\u4E3A0,50,100\u7684\u65F6\u5019\u80FD\u5206\u522B\u53C2\u52A0\u5F00\u9898\uFF0C\u4E2D\u671F\u548C\u7ED3\u9879\r\n");
		lblNewLabel_7_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_7_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_7_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_7_1.setBounds(10, 288, 482, 15);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_4_1 =  new JLabel("当前状态\uFF1A"+student.getStudent().getS().getSchedule());
		lblNewLabel_4_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(253, 105, 323, 15);
		contentPane.add(lblNewLabel_4_1);

		
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setBounds(426, 280, 150, 40);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6_2 = new JLabel("New label");
		lblNewLabel_6_2.setIcon(new ImageIcon(Student_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6_2.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_2);
		if(student.getStudent().getS().getStage()==0&&student.getStudent().getS().getStage()==0) {
			lblNewLabel_6.setText("当前状态：待参加");
			lblNewLabel_6_1.setText("当前状态：未开始");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getStage()==4&&student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：待评分");
			lblNewLabel_6_1.setText("当前状态：未开始");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getStage()==1) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：未开始");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getDU()==50&&student.getStudent().getS().getStage()==1) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：待参加");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getStage()==5&&student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：待评分");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getStage()==2) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：通过 得分"+student.getStudent().getS().getMiddleGrade());
			lblNewLabel_6_1_1.setText("当前状态：未开始");
		}
		else if(student.getStudent().getS().getDU()==100&&student.getStudent().getS().getStage()==2) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：通过 得分"+student.getStudent().getS().getMiddleGrade());
			lblNewLabel_6_1_1.setText("当前状态：待参加");
		}
		else if(student.getStudent().getS().getStage()==6&&student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：通过 得分"+student.getStudent().getS().getMiddleGrade());
			lblNewLabel_6_1_1.setText("当前状态：待评分");
		}
		else if(student.getStudent().getS().getStage()==3) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：通过 得分"+student.getStudent().getS().getMiddleGrade());
			lblNewLabel_6_1_1.setText("当前状态：通过 得分"+student.getStudent().getS().getFinalGrade());
			lblNewLabel_9.setText(student.getStudent().getS().getResult()+"奖项");
		}
		else if(student.getStudent().getS().getDU()==0&&!student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：未通过");
			lblNewLabel_6_1.setText("当前状态：未开始");
			lblNewLabel_6_1_1.setText("当前状态：未开始");
			lblNewLabel_6.setForeground(new Color(204, 0, 0));
			btnNewButton_1.setEnabled(false);
		}
		else if(student.getStudent().getS().getDU()==50&&!student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：未通过");
			lblNewLabel_6_1_1.setText("当前状态：未开始");	
			lblNewLabel_6_1.setForeground(new Color(204, 0, 0));
			btnNewButton_1_1.setEnabled(false);
		}
		else if(student.getStudent().getS().getDU()==100&&!student.getStudent().getS().getIsExist()) {
			lblNewLabel_6.setText("当前状态：通过 得分"+student.getStudent().getS().getOpenGrade());
			lblNewLabel_6_1.setText("当前状态：通过 得分"+student.getStudent().getS().getMiddleGrade());
			lblNewLabel_6_1_1.setText("当前状态：未通过");
			lblNewLabel_6_1_1.setForeground(new Color(204, 0, 0));
			btnNewButton_1_1_1.setEnabled(false);
		}
	}
		
}
