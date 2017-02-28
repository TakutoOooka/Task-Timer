package com.src.model;

public class TimeModel {
	private int sec, min, hour;
	private Boolean timeOver;

	public TimeModel() {
		sec = min = hour = 0;
		timeOver = false;
	}

	public void minusTime() {
		if(sec < 1) {
			if(min < 1) {
				if(hour < 1) {
					timeOver = true;
				} else {hour--; min=59; sec=59;}
			} else {min--; sec=59;}
		} else { sec--; }
	}

	public void setTime(int sec, int min, int hour) {
		this.sec = sec;
		this.min = min;
		this.hour = hour;
	}

	public Boolean getTimeOver() {return timeOver;}
}