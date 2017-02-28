package com.src.view;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimeView extends JPanel {
	JLabel timeLabel;
	String hourSt, minSt, secSt;

	public TimeView() {
		super();
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		hourSt = minSt = secSt = "00";
		timeLabel = new JLabel("00:00:00");
		timeLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 40));
		this.add(timeLabel, BorderLayout.CENTER);

		this.repaint();
	}

	public JLabel getTimeLabel() {return timeLabel;}
	public void setTime(int hour, int min, int sec) {
		if(hour < 10) hourSt = "0"+hourSt.toString();
		else hourSt = hourSt.toString();
		if(min < 10) minSt = "0"+minSt.toString();
		else minSt = minSt.toString();
		if(sec < 10) secSt = "0"+secSt.toString();
		else secSt = secSt.toString();

		timeLabel.setText(hourSt+":"+minSt+":"+secSt);
	}
}