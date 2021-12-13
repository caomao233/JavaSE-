package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Restart_UI extends JFrame {

	private JPanel contentPane;
	JFrame thisFrame=this;

	/**
	 * Create the frame.
	 */
	public Restart_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6210\u529F\uFF01");
		lblNewLabel.setFont(new Font("ºÚÌå", Font.PLAIN, 18));
		lblNewLabel.setBounds(201, 59, 55, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u91CD\u65B0\u767B\u5F55");
		lblNewLabel_1.setFont(new Font("ºÚÌå", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(174, 100, 97, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login_UI frame = new Login_UI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				thisFrame.dispose();
			}
		});
		btnNewButton.setBounds(174, 141, 97, 23);
		contentPane.add(btnNewButton);
	}

}
