package com.src.controller;

import java.awt.event.*;
import javax.swing.JTextField;

import com.src.view.*;

public class SettingController {
	MainController mainCont;
	SettingView settingView;
	TimeView timeView;
	JTextField hourField;
	JTextField minField;
	JTextField secField;
	// add Value MODE
	public static final int HOUR = 0, MIN = 1, SEC = 2;

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

		settingView.getHours().addKeyListener( new KeyListener() {
			// Override
			public void keyPressed(KeyEvent e) {myKeyPressed(e, HOUR);}
			//Override
			public void keyReleased(KeyEvent e) {updateTime();}
			//Override
			public void keyTyped(KeyEvent e) {}
		});

		settingView.getMinutes().addKeyListener( new KeyListener() {
			// Override
			public void keyPressed(KeyEvent e) {myKeyPressed(e, MIN);}
			//Override
			public void keyReleased(KeyEvent e) {updateTime();}
			//Override
			public void keyTyped(KeyEvent e) {}
		});
		settingView.getSec().addKeyListener( new KeyListener() {
			// Override
			public void keyPressed(KeyEvent e) {myKeyPressed(e, SEC);}
			//Override
			public void keyReleased(KeyEvent e) {updateTime();}
			//Override
			public void keyTyped(KeyEvent e) {}
		});
	}
	private void updateTime() {
		int hour, min, sec;
		int[] times;

		times = readField();
		hour = times[0];
		min = times[1];
		sec = times[2];
		mainCont.changeTimeAction(hour, min, sec); // Model, View にTimeを反映
	}
	private void myKeyPressed(KeyEvent e, int mode) {
		int keycode = e.getKeyCode();
		int mod = e.getModifiersEx();
		int value = 5;
		int shift_value = 1;
		int[] view_value;

		view_value = readField();

		if ((mod & InputEvent.SHIFT_DOWN_MASK) != 0){
			switch(keycode) {
				case KeyEvent.VK_UP:addValue(mode, 1); break;
				case KeyEvent.VK_DOWN:addValue(mode, -1); break;
			}
		}
		else {
			switch(keycode) {
				case KeyEvent.VK_UP:addValue(mode, 5); break;
				case KeyEvent.VK_DOWN:addValue(mode, -5); break;
			}
		}
	}
	private void addValue(int mode, int value) {
		if(mode == HOUR) {addValue(value, 0, 0);}
		else if(mode == MIN) {addValue(0, value, 0);}
		else if(mode == SEC) {addValue(0, 0, value);}
	}
	private void addValue(int hour, int min, int sec) {
		int[] times;
		times = readField();
		times[0] += hour;
		times[1] += min;
		times[2] += sec;

		if(times[0] < 0) times[0] = 0;
		else if(times[0] > 60) times[0] = 59;
		if(times[1] < 0) times[1] = 0;
		else if(times[1] > 60) times[1] = 59;
		if(times[2] < 0) times[2] = 0;
		else if(times[2] > 60) times[2] = 59;
		mainCont.changeTimeAction(times[0], times[1], times[2]);
	}
	private int[] readField() {
		String hourSt="0", minSt="0", secSt="0";
		int checkLength = 2;
		int hour, min, sec;
		// 設定メニューから文字列を読み取り数値に変換
		// まずは各JTextFieldから文字列を読み取る 空白ならデータを0にする
		// 次に文字列を数値に変える 60以上なら59とし数値に変換できないものは削除してデータを0とする
		try {
			hourSt = hourField.getText(); // throw StringIndexOutOfBoundsException
			if(hourSt.length() > checkLength){ // 3文字以上入力されたら59を代入する.
				hourField.setText("59");
				hourSt = "59";
			}

			hour = Integer.parseInt(hourSt); // throw NumberFormatException
			if(hour > 60){
				hour = 59;
				hourField.setText(String.valueOf(hour));
			}
		} catch (StringIndexOutOfBoundsException e) {
			hour = 0;
			hourField.setText("");
		} catch (NumberFormatException e) {
			hour = 0;
			hourField.setText("");
		}
		try {
			minSt = minField.getText(); // throw StringIndexOutOfBoundsException
			if(minSt.length() > checkLength){ // 3文字以上入力されたら59を代入する.
				minField.setText("59");
				minSt = "59";
			}

			min = Integer.parseInt(minSt); // throw NumberFormatException
			if(min > 60){
				min = 59;
				minField.setText(String.valueOf(min));
			}
		} catch (StringIndexOutOfBoundsException e) {
			min = 0;
			minField.setText("");
		} catch (NumberFormatException e) {
			min = 0;
			minField.setText("");
		}
		try {
			secSt = secField.getText(); // throw StringIndexOutOfBoundsException
			if(secSt.length() > checkLength) { // 3文字以上入力されたら59を代入する.
				secField.setText("59");
				secSt = "59";
			}

			sec = Integer.parseInt(secSt); // throw NumberFormatException
			if(sec > 60){
				 sec = 59;
				 secField.setText(String.valueOf(sec));
			}
		} catch (StringIndexOutOfBoundsException e) {
			sec = 0;
			secField.setText("");
		} catch (NumberFormatException e) {
			sec = 0;
			secField.setText("");
		}

		int[] times = {hour, min, sec};
		return times;
	}
}