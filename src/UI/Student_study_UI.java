package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import role.Role;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Student_study_UI extends JFrame {

	Role student;
	JFrame thisFrame=this;
	private JPanel contentPane;
	private JTextField textField;


	/**
	 * Create the frame.
	 */
	public Student_study_UI(Role role1) {
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
		lblNewLabel_1.setIcon(new ImageIcon(Student_study_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
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
		
		JLabel lblNewLabel_3 = new JLabel("\u5199\u4E0B\u4F60\u7684\u6210\u679C\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 115, 105, 21);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(127, 115, 209, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("黑体", Font.BOLD, 15));
		lblNewLabel_4.setBounds(84, 172, 332, 48);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()==null) {
					lblNewLabel_4.setText("成果不能为空");
					lblNewLabel_4.setForeground(Color.RED);
				}
				else {
					student.study();
					lblNewLabel_4.setText("等待管理员审核");
					try {
						Thread.sleep(1000*4);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					lblNewLabel_4.setText("审核通过");
				}
			}
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton.setBounds(367, 115, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u56DE\u754C\u9762");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Student_UI frame = new Student_UI(student);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				thisFrame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_1.setBounds(64, 219, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u9000\u51FA\u7A0B\u5E8F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisFrame.dispose();
			}
		});
		btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		btnNewButton_2.setBounds(367, 219, 97, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Student_study_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6);

}
}

