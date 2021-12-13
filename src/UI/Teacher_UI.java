package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import authority.impl.Instructor;
import entity.Teacher;
import role.Role;

public class Teacher_UI extends JFrame {
	Role instructor;
	private JPanel contentPane;
	JFrame thisFrame=this;
	/**
	 * Create the frame.
	 */
	public Teacher_UI(Role instructor1) {
		instructor=instructor1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("\u5927\u8FDE\u7406\u5DE5\u5927\u5B66\u5927\u5B66\u751F\u521B\u65B0\u521B\u4E1A\u9879\u76EE");
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.BOLD, 22));
		lblNewLabel.setBounds(10, 10, 357, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Teacher_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("¡¾"+instructor.getTeacher().getId()+"¡¿"+instructor.getTeacher().getName());
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 73, 323, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Teacher_UI.class.getResource("/UI/\u6211\u7684\u9879\u76EE.png")));
		lblNewLabel_3.setBounds(106, 135, 65, 64);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u6211\u7684\u9879\u76EE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Teacher_Check_UI frame = new Teacher_Check_UI(instructor);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						thisFrame.dispose();
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		btnNewButton.setBounds(89, 208, 98, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Teacher_UI.class.getResource("/UI/\u7B54\u8FA9\u8BC4\u5206.png")));
		lblNewLabel_4.setBounds(350, 135, 65, 64);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("\u7B54\u8FA9\u8BC4\u5206");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int stage[]= {0};
				if(!instructor.getTeacher().getOpeningReport().getsubjectsO().isEmpty())
					stage[0]=1;
				else if(!instructor.getTeacher().getIntermReport().getsubjectsI().isEmpty())
					stage[0]=2;
				else if(!instructor.getTeacher().getGraduationReport().getsubjectsG().isEmpty())
					stage[0]=3;
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Teacher_Set_UI frame = new Teacher_Set_UI(instructor,0,stage[0]);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
						thisFrame.dispose();
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		btnNewButton_1.setBounds(334, 209, 97, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Teacher_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6);
		
		if(instructor.getTeacher().getOpeningReport().getsubjectsO().isEmpty()&&instructor.getTeacher().getIntermReport().getsubjectsI().isEmpty()&&instructor.getTeacher().getGraduationReport().getsubjectsG().isEmpty())
			btnNewButton_1.setEnabled(false);
	}

}
