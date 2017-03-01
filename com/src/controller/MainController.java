package com.src.controller;

import com.src.view.*;
import com.src.model.*;

public class MainController {
	MainView mainView;
	TimeView timeView;
	MainModel mainModel;
	TimeModel timeModel;

	SettingController settingCont;
	TimeController timeCont;

	public MainController(MainView v, MainModel m) {
		mainView = v;
		timeView = mainView.getTimeView();
		mainModel = m;
		timeModel = mainModel.getTimeModel();

		settingCont = new SettingController(this);
		timeCont = new TimeController(this);
	}

	public void clearAll() {
		resetTimer();
		mainView.getSettingView().clearSetting();
		changeTimeAction(0, 0, 0);
		mainView.getTaskView().clearTask();
	}
	public void changeTimeAction(int hour, int min, int sec) {
		mainModel.getTimeModel().setTime(hour, min, sec);
		updateView();
	}
	public void takeTimerAction() {
		timeModel.minusTime();
		updateView();
	}
	public void updateView() {
		mainView.getSettingView().setTime(
			timeModel.getHour(),
			timeModel.getMin(),
			timeModel.getSec()
		);
		timeView.setTime(
			timeModel.getHour(),
			timeModel.getMin(),
			timeModel.getSec()
		);
	}
	public void startTimer() {timeCont.startTimer();}
	public void stopTimer() {timeCont.stopTimer();}
	public void resetTimer() {timeCont.resetTimer();}
	public Boolean getMoveTimer() {return timeCont.getMove();}
	public MainView getView() {return mainView;}
	public MainModel getModel() {return mainModel;}
	public 	TimeModel getTimeModel() {return timeModel;}
}