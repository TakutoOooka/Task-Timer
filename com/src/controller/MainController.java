package com.src.controller;

import com.src.view.MainView;
import com.src.model.MainModel;

public class MainController {
	MainView mainView;
	MainModel mainModel;

	SettingController settingCont;
	TimeController timeCont;

	public MainController(MainView v, MainModel m) {
		mainView = v;
		mainModel = m;

		settingCont = new SettingController(this);
		timeCont = new TimeController(this);
	}

	public void changeValueAction(int delta) {}
	public void changeStateAction() {}
	public void takeTimerAction() {
		mainModel.getTimeModel().minusTime();
	}

	public MainView getView() {return mainView;}
	public MainModel getModel() {return mainModel;}
}