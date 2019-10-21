package com.briup.sframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.briup.service.LoginService;

@SuppressWarnings("all")

public class LoginFrame extends JFrame {
	private JPanel jPanel1, jPanel2, jPanel3, jPanel4;
	private JLabel jLabel, jLabel2, jLabel3;
	private JButton LoginButton, ResetButton;
	private JTextField textField;
	private JPasswordField passwordField;
	private LoginService service = new LoginService();

	public LoginFrame() {

		setTitle("学生管理系统登录界面");
		setSize(560, 400);
		setLocation(500, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		jPanel1 = new JPanel();
		jLabel = new JLabel("briup学生管理系统", JLabel.CENTER);
		jLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		jPanel1.setBackground(Color.pink);
		jPanel1.add(jLabel);
		add(jPanel1);

		jPanel2 = new JPanel();
		jLabel2 = new JLabel("用户名:", JLabel.LEFT);
		jLabel2.setFont(new Font("黑体", Font.PLAIN, 15));
		textField = new JTextField(18);
		jPanel2.setBackground(Color.pink);
		jPanel2.add(jLabel2);
		jPanel2.add(textField);
		add(jPanel2);

		jPanel3 = new JPanel();
		jLabel3 = new JLabel("密码:", JLabel.LEFT);
		passwordField = new JPasswordField(18);
		jLabel3.setFont(new Font("黑体", Font.PLAIN, 15));
		jPanel3.setBackground(Color.pink);
		jPanel3.add(jLabel3);
		jPanel3.add(passwordField);
		add(jPanel3);

		jPanel4 = new JPanel();
		LoginButton = new JButton("登录");
		ResetButton = new JButton("清除");
		LoginButton.setSize(100, 50);
		ResetButton.setSize(100, 50);
		jPanel4.setBackground(Color.pink);
		jPanel4.add(LoginButton);
		jPanel4.add(ResetButton);
		add(jPanel4);


		LoginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String password = passwordField.getText();
				try {
					service.login(name, password);
					//new StudentsFrame();
					LoginFrame.this.dispose();//关闭login窗口
				} catch (Exception e1) {
					new ErrorFrame(e1.getMessage());
				}
			}

		});

		ResetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");

			}
		});

		setLayout(new GridLayout(4, 1));
	}

	public static void main(String[] args) {
		LoginFrame frame = new LoginFrame();

	}
}