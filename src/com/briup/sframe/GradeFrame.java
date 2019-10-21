package com.briup.sframe;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
@SuppressWarnings("all")

public class GradeFrame extends JFrame {
	public GradeFrame(JTable table, JFrame frame) {
		setLayout(new BorderLayout());
		add(table.getTableHeader(), BorderLayout.NORTH); // 将表格的列名进行添加到窗体
		add(table, BorderLayout.CENTER);
		setSize(400,500);
		setVisible(true);
		frame.setVisible(false);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				frame.setVisible(true);
			}
			
		});
	}
	public GradeFrame(JTextArea area,JFrame frame) {
		add(area);
		setSize(300, 400);
		setVisible(true);
		frame.setVisible(false);
		
	}
}
