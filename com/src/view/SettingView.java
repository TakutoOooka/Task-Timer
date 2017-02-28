package com.src.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JButton;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SettingView extends JPanel {
	JLabel hoursLabel;
	JLabel minutesLabel;
	JLabel secLabel;
	JTextField hours;
	JTextField minutes;
	JTextField sec;
	// ImageButton startBtn;
	// ImageButton resetBtn;
	JPanel startBtnPanel;
	JButton startBtn;
	JPanel resetBtnPanel;
	JButton resetBtn;

	GridBagLayout layout;

	public SettingView() {
		super();
		this.setVisible(true);
		// スタートボタンを格納するためのJPanelも定義
		startBtnPanel = new JPanel();
		startBtnPanel.setLayout(new BorderLayout());
		startBtn = new JButton("Start");
		startBtnPanel.add(startBtn, BorderLayout.CENTER);

		// リセットボタンを格納するためのJPanelも定義
		resetBtnPanel = new JPanel();
		resetBtnPanel.setLayout(new BorderLayout());
		resetBtn = new JButton("Reset");
		resetBtnPanel.add(resetBtn, BorderLayout.CENTER);

		hoursLabel = new JLabel("Hours");
		minutesLabel = new JLabel("Minutes");
		secLabel = new JLabel("Seconds");
		hours = new JTextField(3);
		hours.setText("");
		minutes = new JTextField(3);
		minutes.setText("");
		sec = new JTextField(3);
		sec.setText("");

		layout = new GridBagLayout();

		this.setLayout(layout);

		GridBagConstraints gbc = new GridBagConstraints();

		// GridLayout(Button)
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.setConstraints(startBtnPanel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		layout.setConstraints(resetBtnPanel, gbc);

		// GridLayout(JLabel)
		gbc.gridx = 0;
		gbc.gridy = 1;
		layout.setConstraints(hoursLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		layout.setConstraints(minutesLabel, gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		layout.setConstraints(secLabel, gbc);

		// GridLayout(JTextField)
		gbc.gridx = 0;
		gbc.gridy = 2;
		layout.setConstraints(hours, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		layout.setConstraints(minutes, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		layout.setConstraints(sec, gbc);

		this.add(startBtnPanel);
		this.add(resetBtnPanel);
		this.add(hoursLabel);
		this.add(minutesLabel);
		this.add(secLabel);
		this.add(hours);
		this.add(minutes);
		this.add(sec);

		this.repaint();
	}

	public void clearSetting() {
		this.hours.setText("");
		this.minutes.setText("");
		this.sec.setText("");
	}

	public JTextField getHours() {return hours;}
	public JTextField getMinutes() {return minutes;}
	public JTextField getSec() {return sec;}
	public JButton getStartBtn() {return startBtn;}
	public JButton getResetBtn() {return resetBtn;}
}