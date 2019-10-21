package com.briup.sframe;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("all")

public class SucceeFrame extends JFrame {
	private JLabel jLabel;
	private JButton jButton;
	private JPanel jPanel;
	
	public SucceeFrame( ) {
		setTitle("添加成功");
		setSize(300,160);
		setVisible(true);
		init();
	}
	
		public void init(){
		setLayout(new GridLayout(2,1));
		
		jPanel=new JPanel();
		jLabel=new JLabel("添加成功",JLabel.CENTER);
		jButton=new JButton("OK");
			
		jButton.setBounds(500,400,50,60);
		//jButton.setSize(30, 20);
		jPanel.add(jButton);
		
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SucceeFrame.this.setVisible(false);
			}
		});
		add(jLabel);
		add(jPanel);
	}

}
