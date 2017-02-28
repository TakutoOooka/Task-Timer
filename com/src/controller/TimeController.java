package com.src.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class TimeController implements ActionListener {
	Timer timer;
	Boolean isMove;
	MainController mainCont;

	public TimeController(MainController mainCont) {
		this.mainCont = mainCont;
		isMove = false;
		timer = new Timer(1000, this);
	}

	public Boolean getMove() {return isMove;}
	public void startTimer() {timer.start();}
	public void stopTimer() {timer.stop();}
	public void resetTimer() {
		timer.restart();
		timer.stop();
	}
	// Override
	public void actionPerformed(ActionEvent e) {mainCont.takeTimerAction();}
}