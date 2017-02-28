package com.src.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
public class TimeController implements ActionListener {
	Timer timer;
	MainController mainCont;

	public TimeController(MainController mainCont) {
		this.mainCont = mainCont;
		timer = new Timer(1000, this);
	}

	public void startTimer() {timer.start();}
	public void stopTimer() {timer.stop();}

	public void actionPerformed(ActionEvent e) {
		mainCont.takeTimerAction();
	}
}