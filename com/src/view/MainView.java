package com.src.view;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JPanel;

public class MainView extends JPanel {
	SettingView settingView;
	TimeView timeView;
	TaskView taskView;
	GridBagLayout layout;

	public MainView() {
		super();
		this.setVisible(true);
		settingView = new SettingView();
		timeView = new TimeView();
		taskView = new TaskView();

		layout = new GridBagLayout();
		this.setLayout(layout);

		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(settingView, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		layout.setConstraints(timeView, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 3;
		layout.setConstraints(taskView, gbc);

		this.add(settingView);
		this.add(timeView);
		this.add(taskView);

		this.repaint();
	}
	public SettingView getSettingView() {return settingView;}
	public TimeView getTimeView() {return timeView;}
	public TaskView getTaskView() {return taskView;}
}