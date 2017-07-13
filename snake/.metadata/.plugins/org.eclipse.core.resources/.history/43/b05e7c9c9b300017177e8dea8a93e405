package com.snake;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class SnakeJDia extends JDialog implements ActionListener{
	SnakeJPanel sjp;
	JButton b=new JButton("好的");
	JLabel text=new JLabel();
	public SnakeJDia(SnakeJPanel sjp) {
		super();
		this.sjp = sjp;
		setLayout(new FlowLayout());
		this.setSize(200,100);
		setLocation(250, 250);
		b.addActionListener(this);
		add(b);
		text.setText("你的得分："+sjp.fenshu);
		add(text);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		sjp.myclear();
	}
	
	
	

}
