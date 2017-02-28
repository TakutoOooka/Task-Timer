package com.src.controller;

import java.awt.event.*;
import javax.swing.JTextField;

import com.src.view.*;

public class SettingController implements KeyListener {
	MainController mainCont;
	SettingView settingView;
	TimeView timeView;
	JTextField hourField;
	JTextField minField;
	JTextField secField;

	public SettingController(MainController mainCont) {
		this.mainCont = mainCont;
		this.settingView = mainCont.getView().getSettingView();

		hourField = settingView.getHours();
		minField = settingView.getMinutes();
		secField = settingView.getSec();

		settingView.getStartBtn().addActionListener(new ActionListener() {
			// Override
			public void actionPerformed(ActionEvent e) {
				if(mainCont.getMoveTimer()) {mainCont.stopTimer();}
				else {mainCont.startTimer();}
			}
		});
		settingView.getResetBtn().addActionListener(new ActionListener() {
			// Override
			public void actionPerformed(ActionEvent e) {
				mainCont.clearAll();
			}
		});

		settingView.getHours().addKeyListener(this);
		settingView.getMinutes().addKeyListener(this);
		settingView.getSec().addKeyListener(this);
	}
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		int mod = e.getModifiersEx();

		// limitTextField();
		if ((mod & InputEvent.SHIFT_DOWN_MASK) != 0){
			switch(keycode) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
			}
		}
		else {
			switch(keycode) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
			}
		}
	}
	public void keyReleased(KeyEvent e) {updateTime();}
	public void keyTyped(KeyEvent e) {}

	private void limitTextField() {
		int checkLength = 2;
		try {
			if(hourField.getText().length() > checkLength){
				hourField.setText("60");
			}
		} catch (StringIndexOutOfBoundsException e) {
			hourField.setText("");
		}
		try {
			if(minField.getText().length() > checkLength){
				minField.setText("59");
			}
		} catch (StringIndexOutOfBoundsException e) {
			minField.setText("");
		}
		try {
			if(secField.getText().length() > checkLength) {
				secField.setText("59");
			}
		} catch (StringIndexOutOfBoundsException e) {
			secField.setText("");
		}
	}
	private void updateTime() {
		String hourSt, minSt, secSt;
		int hour, min, sec;

		// 設定メニューから文字列を読み取り数値に変換
		// まずは各JTextFieldから文字列を読み取る 空白ならデータを0にする
		try {
			hourSt = hourField.getText();
		} catch (StringIndexOutOfBoundsException e) {
			hourSt = "0";
		}
		try {
			minSt = minField.getText();
		} catch (StringIndexOutOfBoundsException e) {
			minSt="0";
		}
		try {
			secSt = secField.getText();
		} catch (StringIndexOutOfBoundsException e) {
			secSt="0";
		}

		// 文字列を数値に変える 60以上なら59とし数値に変換できないものは削除してデータを0とする
		try {
			hour = Integer.parseInt(hourSt);
			if(hour > 60){
				hour = 59;
				hourField.setText(String.valueOf(hour));
			}
		} catch (NumberFormatException e) {
			hour = 0;
			hourField.setText("");
		}
		try {
			min = Integer.parseInt(minSt);
			if(min > 60){
				min = 59;
				minField.setText(String.valueOf(min));
			}
		} catch (NumberFormatException e) {
			min = 0;
			minField.setText("");
		}
		try {
			sec = Integer.parseInt(secSt);
			if(sec > 60){
				 sec = 59;
				 secField.setText(String.valueOf(sec));
			}
		} catch (NumberFormatException e) {
			sec = 0;
			secField.setText("");
		}
		//
		mainCont.changeTimeAction(hour, min, sec); // Model, View にTimeを反映
	}
}