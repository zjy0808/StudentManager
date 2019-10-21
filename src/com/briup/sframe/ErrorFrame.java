package com.briup.sframe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
@SuppressWarnings("all")

public class ErrorFrame extends JFrame{
	private JLabel jLabel;
	private JButton jButton;
	private JPanel jPanel;
	
	public ErrorFrame(String msg) {
		setTitle("错误信息");
		setSize(300,160);
		setVisible(true);
		jPanel=new JPanel();
		
		setLayout(new GridLayout(2,1));
		jLabel=new JLabel(msg,JLabel.CENTER);
		jButton=new JButton("OK");
		jButton.setSize(30, 20);
		jPanel.add(jButton);
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ErrorFrame.this.setVisible(false);
			}
		});
		add(jLabel);
		add(jPanel);
	}
}

