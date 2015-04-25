package com.bayviewglen.maingame;

public class User {

	private String myUsername;
	private String myPassword;
	private Achivement myAchivements;
	private Highscores myHighscore;
	
	


	public User(String username, String password, Achivement achivement, Highscores highscore){
		myAchivements = achivement;
		myUsername = username;
		myPassword = password;
		myHighscore = highscore;
		
		
	}

	public Highscores getMyHighscore() {
		return myHighscore;
	}


	public void setMyHighscore(Highscores myHighscore) {
		this.myHighscore = myHighscore;
	}
	public String getMyUsername() {
		return myUsername;
	}

	public void setMyUsername(String myUsername) {
		this.myUsername = myUsername;
	}

	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
	}
	
	public boolean validatePassword(String password){
		return password.equals(myPassword);
	}

	public String getMyPassword() {
		return myPassword;
	}

	public Achivement getMyAchivements() {
		return myAchivements;
	}

	public void setMyAchivements(Achivement myAchivements) {
		this.myAchivements = myAchivements;
	}
	
	
	
}
