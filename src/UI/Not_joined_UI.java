package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import role.Role;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Not_joined_UI extends JFrame {
	JFrame thisFrame=this;
	private JPanel contentPane;
	Role student;

	/**
	 * Create the frame.
	 */
	public Not_joined_UI(Role role1) {
		student=role1;
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
		lblNewLabel_1.setIcon(new ImageIcon(Not_joined_UI.class.getResource("/UI/\u5927\u5DE5l ogo.png")));
		lblNewLabel_1.setBounds(367, 10, 209, 55);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("¡¾"+student.getStudent().getId()+"¡¿"+student.getStudent().getName());
		lblNewLabel_2.setBounds(0, 75, 250, 30);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(51, 153, 255));
		lblNewLabel_2.setFont(new Font("ËÎÌå", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Not_joined_UI.class.getResource("/UI/\u9879\u76EE\u7533\u62A5.png")));
		lblNewLabel_3.setBounds(106, 135, 65, 64);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u9879\u76EE\u7533\u62A5");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Make_UI frame = new Make_UI(student);
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
		btnNewButton.setBounds(92, 209, 98, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Not_joined_UI.class.getResource("/UI/\u52A0\u5165\u9879\u76EE.png")));
		lblNewLabel_4.setBounds(340, 135, 65, 64);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("\u52A0\u5165\u9879\u76EE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Join_UI frame = new Join_UI(student);
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
		btnNewButton_1.setBounds(331, 209, 97, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("\u6CE8\uFF1A1\u3001\u9879\u76EE\u5F00\u9898\u540E\u5219\u4E0D\u80FD\u518D\u52A0\u5165\r\n");
		lblNewLabel_5.setFont(new Font("ËÎÌå", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(340, 248, 193, 23);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("2\u3001\u4E00\u4E2A\u9879\u76EE\u6700\u591A\u67096\u4E2A\u6210\u5458");
		lblNewLabel_6.setFont(new Font("ËÎÌå", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(340, 270, 164, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(Not_joined_UI.class.getResource("/UI/\u80CC\u666F.png")));
		lblNewLabel_6_1.setBounds(0, 0, 586, 363);
		contentPane.add(lblNewLabel_6_1);
	}
}
