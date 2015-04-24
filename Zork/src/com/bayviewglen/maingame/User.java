package com.bayviewglen.maingame;

public class User {

	private String myUsername;
	private String myPassword;
	
	User(String username, String password){
		
		myUsername = username;
		myPassword = password;
		
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
	
}
