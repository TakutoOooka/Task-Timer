package com.src.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SettingController implements ActionListener {
	MainController mainCont;

	public SettingController(MainController mainCont) {
		this.mainCont = mainCont;
	}
	// Override
	public void actionPerformed(ActionEvent e) {}
}