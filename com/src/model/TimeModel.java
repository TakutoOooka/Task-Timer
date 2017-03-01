package com.src.model;

public class TimeModel {
	private int sec, min, hour;
	private Boolean timeOver;

	public TimeModel() {
		sec = min = hour = 0;
		timeOver = false;
	}

	public void minusTime() {
		timeOver = false;
		if(sec < 1) {
			if(min < 1) {
				if(hour < 1) {
					timeOver = true;
				} else {hour--; min=59; sec=59;}
			} else {min--; sec=59;}
		} else { sec--; }
	}

	public void setTime(int hour, int min, int sec) {
		this.sec = sec;
		this.min = min;
		this.hour = hour;
		if(hour>0 && min>0 && sec>0) timeOver = false;
		else timeOver = true;
	}
	public int getHour() {return hour;}
	public int getMin() {return min;}
	public int getSec() {return sec;}
	public Boolean getTimeOver() {return timeOver;}
}