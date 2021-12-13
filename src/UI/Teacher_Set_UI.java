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

import entity.Subject;
import role.Role;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import dao.impl.*;
public class Teacher_Set_UI extends JFrame {
	Role instructor;
	private JPanel contentPane;
	int sum;
	boolean flag=true;
	OpenportDaoimpl od=new OpenportDaoimpl();
	MiddleportDaoimpl md=new MiddleportDaoimpl();
	FinalportDaoimpl fd=new FinalportDaoimpl();
	Subject subject=new Subject();
	/**
	 * Create the frame.
	 */
	public Teacher_Set_UI(Role instructor1,int index,int stage) {
		instructor=instructor1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JFrame thisFrame=this;
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setFont(new Font("楷体", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 357, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teacher_Set_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("【"+instructor.getTeacher().getId()+"】"+instructor.getTeacher().getName());
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 73, 323, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Teacher_Set_UI.class.getResource("/UI/\u7B54\u8FA9\u8BC4\u5206.png")));
		lblNewLabel_4.setBounds(20, 113, 65, 64);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("\u5206\u6570");
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(181, 174, 58, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel("\u3010\u9879\u76EEID\u3011\u9879\u76EE\u540D\u79F0");
		lblNewLabel_3.setFont(new Font("黑体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(181, 115, 209, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("\u7B54\u8FA9\u7C7B\u578B");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(181, 142, 199, 22);
		contentPane.add(lblNewLabel_5);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setSelectedIndex(1);
		comboBox.setBounds(237, 170, 57, 23);
		contentPane.add(comboBox);
		
		sum=instructor.getTeacher().getOpeningReport().getsubjectsO().size()+instructor.getTeacher().getIntermReport().getsubjectsI().size()+instructor.getTeacher().getGraduationReport().getsubjectsG().size();
		JLabel lblNewLabel_8 = new JLabel("共"+sum+"份");
		lblNewLabel_8.setBounds(258, 338, 58, 15);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBounds(236, 254, 97, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6_1 = new JLabel("New label");
		lblNewLabel_6_1.setIcon(new ImageIcon(Teacher_Set_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6_1.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_1);
		switch(stage) {
		case 1: 
				Subject subject=instructor.getTeacher().getOpeningReport().getsubjectsO().get(index);
				lblNewLabel_3.setText("【"+subject.getId()+"】"+subject.getName());
				lblNewLabel_5.setText("开题报告");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean isfinished=false;
						int score=comboBox.getSelectedIndex();
						instructor.setOsocre(subject,score);
						od.deleteopenport(subject, instructor.getTeacher());
						if(index==instructor.getTeacher().getOpeningReport().getsubjectsO().size()-1) {
							instructor.getTeacher().getOpeningReport().getsubjectsO().clear();
							int stage[]= {0};
							if(!instructor.getTeacher().getOpeningReport().getsubjectsO().isEmpty())
								stage[0]=1;
							else if(!instructor.getTeacher().getIntermReport().getsubjectsO().isEmpty())
								stage[0]=2;
							else if(!instructor.getTeacher().getGraduationReport().getsubjectsO().isEmpty())
								stage[0]=3;
							else {
									EventQueue.invokeLater(new Runnable() {
										public void run() {
											try {
												Teacher_Set_Over_UI frame = new Teacher_Set_Over_UI(instructor);
												frame.setVisible(true);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
									isfinished=true;
									thisFrame.dispose();
							}
							if(!isfinished) {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Teacher_Set_UI frame = new Teacher_Set_UI(instructor,0,stage[0]);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							thisFrame.dispose();
						}
						}
						else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Teacher_Set_UI frame = new Teacher_Set_UI(instructor,index+1,stage);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							thisFrame.dispose();
					}
				}
				});
			break;
		case 2 :
			Subject subject1=instructor.getTeacher().getIntermReport().getsubjectsI().get(index);
			lblNewLabel_3.setText("【"+subject1.getId()+"】"+subject1.getName());
			lblNewLabel_5.setText("中期检查");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean isfinished=false;
					int score=comboBox.getSelectedIndex();
					instructor.setIsocre(subject1, stage);
					md.deletemiddleport(subject1, instructor.getTeacher());
					if(index==instructor.getTeacher().getIntermReport().getsubjectsI().size()-1) {
						instructor.getTeacher().getIntermReport().getsubjectsI().clear();
						int stage[]= {0};
						if(!instructor.getTeacher().getOpeningReport().getsubjectsO().isEmpty())
							stage[0]=1;
						else if(!instructor.getTeacher().getIntermReport().getsubjectsI().isEmpty())
							stage[0]=2;
						else if(!instructor.getTeacher().getGraduationReport().getsubjectsG().isEmpty())
							stage[0]=3;
						else {
								EventQueue.invokeLater(new Runnable() {
									public void run() {
										try {
											Teacher_Set_Over_UI frame = new Teacher_Set_Over_UI(instructor);
											frame.setVisible(true);
										} catch (Exception e) {
											e.printStackTrace();
										}
									}
								});
								isfinished=true;
								thisFrame.dispose();
						}
						if(!isfinished) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Teacher_Set_UI frame = new Teacher_Set_UI(instructor,0,stage[0]);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						thisFrame.dispose();
						}
					}
					else {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Teacher_Set_UI frame = new Teacher_Set_UI(instructor,index+1,stage);
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						thisFrame.dispose();
				}
			}
			});
		break;		
		case 3:
			Subject subject11=instructor.getTeacher().getGraduationReport().getsubjectsG().get(index);
			lblNewLabel_3.setText("【"+subject11.getId()+"】"+subject11.getName());
			lblNewLabel_5.setText("结项答辩");
			btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int score=comboBox.getSelectedIndex();
				instructor.setGsocre(subject11, stage);
				fd.deletefinalport(subject11, instructor.getTeacher());
				if(index==instructor.getTeacher().getGraduationReport().getsubjectsG().size()-1) {
					instructor.getTeacher().getGraduationReport().getsubjectsG().clear();
					int stage[]= {0};
					if(!instructor.getTeacher().getOpeningReport().getsubjectsO().isEmpty())
						stage[0]=1;
					else if(!instructor.getTeacher().getIntermReport().getsubjectsI().isEmpty())
						stage[0]=2;
					else if(!instructor.getTeacher().getGraduationReport().getsubjectsG().isEmpty())
						stage[0]=3;
					else {
							EventQueue.invokeLater(new Runnable() {
								public void run() {
									try {
										Teacher_Set_Over_UI frame = new Teacher_Set_Over_UI(instructor);
										frame.setVisible(true);
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							});
							thisFrame.dispose();
					}
				}
				else {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Teacher_Set_UI frame = new Teacher_Set_UI(instructor,index+1,stage);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					thisFrame.dispose();
			}
		}
		});
		break;
		}
	}
}
