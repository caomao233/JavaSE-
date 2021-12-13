package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import role.Role;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Teacher_Set_Over_UI extends JFrame {
	Role instructor;
	private JPanel contentPane;
	JFrame thisFrame=this;
	/**
	 * Create the frame.
	 */
	public Teacher_Set_Over_UI(Role role1) {
		instructor=role1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F85\u8BC4\u5206\u7684\u7B54\u8FA9\u5DF2\u5168\u90E8\u8BC4\u5B8C\uFF01");
		lblNewLabel.setFont(new Font("ºÚÌå", Font.PLAIN, 20));
		lblNewLabel.setBounds(108, 50, 294, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u9000\u56DE\u521D\u59CB\u754C\u9762");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton.setBounds(78, 161, 114, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA\u5E94\u7528\u7A0B\u5E8F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thisFrame.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		btnNewButton_1.setBounds(288, 162, 114, 23);
		contentPane.add(btnNewButton_1);
	}
}
