package com.bayviewglen.maingame;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Highscores implements Serializable{

	private int highscore;
	private Calendar date;
	public Highscores(int highscore, String user, int day, int month, int year) {
		super();
		this.highscore = highscore;
		
		date = new GregorianCalendar();
	}
	
	public void updateHighscore(int value){
		highscore = value;
		date = new GregorianCalendar();
	}
	
	public String toString(){
		
		return highscore + "         " + date.toString();
		
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}
	
	
	
	
}
