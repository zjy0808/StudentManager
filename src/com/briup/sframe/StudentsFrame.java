package com.briup.sframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.briup.sbean.Student;
import com.briup.service.GradeService;

@SuppressWarnings("all")
public class StudentsFrame extends JFrame {

	private JPanel jPanel1, jPanel2, jPanel3, jPanel4, jPanel5;
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4;
	private JButton addButton, showButton, avgButton;
	private JTextField textField1, textField2;
	private GradeService service = new GradeService();

	public StudentsFrame() {
		setTitle("学生管理系统界面");
		setVisible(true);
		setSize(560, 400);
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel1 = new JPanel();
		jLabel1 = new JLabel("学生成绩录入");
		jLabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		jLabel1.setBounds(350, 20, 400, 100);
		jPanel1.add(jLabel1);
		jPanel1.setBackground(Color.orange);

		jPanel2 = new JPanel();
		jLabel2 = new JLabel("学生姓名：");
		jLabel2.setFont(new Font("黑体", Font.PLAIN, 15));
		jLabel2.setBounds(200, 160, 120, 80);
		textField1 = new JTextField(18);
		jPanel2.add(jLabel2);
		jPanel2.add(textField1);
		jPanel2.setBackground(Color.orange);

		jPanel3 = new JPanel();
		jLabel3 = new JLabel("学生班级：");
		jLabel3.setFont(new Font("黑体", Font.PLAIN, 15));
		jLabel3.setBounds(200, 260, 120, 80);

		jPanel3.add(jLabel3);
		jPanel3.setBackground(Color.orange);

		JComboBox<String> box = new JComboBox<>();
		box.addItem("JD1910");
		box.addItem("JD1911");
		box.addItem("JD1912");
		box.setBounds(350, 180, 300, 36);
		box.setFont(new Font("楷体", Font.BOLD, 18));
		jPanel3.add(box);

		jPanel4 = new JPanel();
		jLabel4 = new JLabel("学生成绩：");
		jLabel4.setFont(new Font("黑体", Font.PLAIN, 15));
		jLabel4.setBounds(200, 260, 120, 80);
		textField2 = new JTextField(18);
		jPanel4.add(jLabel4);
		jPanel4.add(textField2);
		jPanel4.setBackground(Color.orange);

		JTextArea jTextArea = new JTextArea();
		jTextArea.setFont(new Font("宋体", Font.BOLD, 26));
		jTextArea.setBounds(350, 300, 300, 36);
		jPanel1.add(jTextArea);
		jPanel2.add(jTextArea);
		jPanel3.add(jTextArea);
		jPanel4.add(jTextArea);

		jPanel5 = new JPanel();
		JButton showButton = new JButton("展示成绩");
		JButton avgButton = new JButton("平均成绩");
		JButton addButton = new JButton("添加成绩");
		addButton.setFont(new Font("宋体", Font.ITALIC, 14));
		showButton.setFont(new Font("宋体", Font.ITALIC, 14));
		avgButton.setFont(new Font("宋体", Font.ITALIC, 14));

		addButton.setBounds(100, 400, 100, 29);
		showButton.setBounds(200, 400, 100, 29);
		avgButton.setBounds(390, 400, 100, 29);

		jPanel5.setBackground(Color.orange);
		jPanel5.add(addButton);
		jPanel5.add(showButton);
		jPanel5.add(avgButton);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField1.getText();
				String classString = (String) box.getSelectedItem();
				String grade = textField2.getText();
				try {
					service.input(name, classString, grade);
					new SucceeFrame();
					textField1.setText("");
					box.setSelectedIndex(0);
					textField2.setText("");
				} catch (Exception e1) {
					new ErrorFrame(e1.getMessage());//返回异常的详细字符串信息
				}

			}
		});

		showButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<Student> list = service.getStudents();
				Object[][] datas = new Object[list.size()][3];
				for (int i = 0; i < list.size(); i++) {
					datas[i][0] = list.get(i).getName();
					datas[i][1] = list.get(i).getClassString();
					datas[i][2] = list.get(i).getGrade();
				}
				Object[] heads = { "姓名", "班级", "成绩" };
				JTable table = new JTable(datas, heads);

				new GradeFrame(table, StudentsFrame.this);

			}
		});

		avgButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String avg=service.getAvg();
				JTextArea area = new JTextArea(avg);
				area.setEditable(false);
				new GradeFrame(area,StudentsFrame.this);
			}
		});

		setLayout(new GridLayout(5, 1));
		add(jPanel1);
		add(jPanel2);
		add(jPanel3);
		add(jPanel4);
		add(jPanel5);

	}

}
