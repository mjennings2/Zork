package com.bayviewglen.maingame;

import java.util.ArrayList;

public class User {

	private String myUsername;
	private String myPassword;
	private Achivement myAchivements;
	private Highscores myHighscore;
	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	


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
	
	public void addToInventory(Item x){
		inventory.add(x);
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	/*public void displayAllItems(Display x){
		for(Item j : inventory){
		for(int i = 0; i < j.getItemName().length(); i++){
			if(j.getItemName().substring(i, i+1).equals("\n")){
				x.display(j.getItemName().substring(i, i+1));
				sleep(500);
			}else{
				x.display(j.getItemName().substring(i, i+1));
				sleep(50);
			}
		}
		}
	}
	*/
	private static void sleep(int time){
		 try {                                                                                                                                                                                                          
            Thread.sleep(time); //3000 milliseconds is three seconds.                                                                                                                                                   
        } catch (InterruptedException ex) {                                                                                                                                                                            
            Thread.currentThread().interrupt();                                                                                                                                                                        
        }   
	}
	
	
}
