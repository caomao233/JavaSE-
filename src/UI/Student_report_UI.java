package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class Student_report_UI extends JFrame {
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Student_report_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u53C2\u52A0\u7B54\u8FA9\u6210\u529F\uFF01");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel.setBounds(113, 61, 189, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u5728\u7B54\u8FA9\u7ED3\u675F\u540E\u7B49\u5F85\u8001\u5E08\u8BC4\u5206\uFF01");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(113, 122, 270, 48);
		contentPane.add(lblNewLabel_1);
	}

}
