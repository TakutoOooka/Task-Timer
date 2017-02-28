package com.src.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TaskView extends JPanel {
	JTextArea task;
	public TaskView() {
		super();
		this.setVisible(true);
		this.setLayout(new BorderLayout());

		task = new JTextArea("", 12, 20);
		task.setWrapStyleWord(true);
		task.setTabSize(2);
		this.add("Center", task);
		this.repaint();
	}

	public void clearTask() {task.setText("");}
}