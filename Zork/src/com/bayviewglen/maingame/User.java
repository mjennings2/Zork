package com.bayviewglen.maingame;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{

	private String myUsername;
	private String myPassword;
	private Achievement myAchievements;
	private Highscores myHighscore;
	public ArrayList<Item> inventory = new ArrayList<Item>();
	private int location;
	private double time;
	private Room[] map;
	private Room[] allRooms;
	public int traitor;


	public User(String username, String password, Achievement achievement, Highscores highscore, int location, int time, Room[] map, Room[] allRooms, int traitor){
		myAchievements = achievement;
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

	public Achievement getMyAchievements() {
		return myAchievements;
	}

	public void setMyAchievements(Achievement myAchievements) {
		this.myAchievements = myAchievements;
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
	
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time2) {
		this.time = time2;
	}

	public Room[] getMap() {
		return map;
	}

	public void setMap(Room[] map) {
		this.map = map;
	}

	public Room[] getAllRooms() {
		return allRooms;
	}

	public void setAllRooms(Room[] allRooms) {
		this.allRooms = allRooms;
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
