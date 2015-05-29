package com.bayviewglen.maingame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner; 

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.io.*;
import sun.audio.*;

import com.bayviewglen.maingame.Display;



public class Zork {
	private static String[] commands = {"go", "quit", "help", "eat", "use", "pickup", "exit", "shoot"};
	public static boolean loginAllowed = false;
	public static void main(String[] args) throws Exception {

		int location = 0;
		double time = 31;
		// TODO Auto-generated method stubx
		// open the sound file as a Java input stream
	   
	  
		ArrayList<User> users = new ArrayList<User>();
		int[] currentUser = new int[1];
		//int[] currentUser= {0};
		importUsers(users);
		boolean playGame = true;
		
		LoginWindow login = new LoginWindow(users, currentUser);
		
		login.frame.setVisible(true);
		while(login.login() < 10){
			 sleep(1000);
			}
		
		login.frame.setVisible(false);
		
		
		
		
		Display x = new Display("input/pictures/Title.jpg");
		x.frame.setVisible(true);
		displayTextMilitaryStyle(x,"Hello and welcome to Trouble in Nuke on a Train with a Terrorist Town!\nType commands in the text bar below. Finding out the commands is part of the puzzle!\nLeaving a room is exit, you can go north or south.\nType 'Start' to start\n");
		sleep(1000);
		waitForProperInput(x, "Start");
		x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));

		displayTextMilitaryStyle(x,"Location: Military train bound for San Fransisco. \nOperation Nuke: The train is carrying a nuclear weapon on a flat bed.\nTime to arrival: 30 min.\nYou are in General DesLauriers Office at the south most part of the train.\nHe is giving you special instructions.\nDesLauriers:\n\"Alright Maggot! We've got a Problem!\nThe train is crying!\nWe are carrying a nuclear payload and have caught wind of a traitor in our ranks!\nYour mission: find this traitor and bring him to Java justice!\nHere, take this fire extinguisher just in case, and this pistol for any traitor-hunting duties you may have to fulfill.\nGet to work, soldier!\n");

		                                                                                                                                                                                                                                                                                                               
		
		// Declare all Rooms
		Room[] rooms = new Room[27];
		Room[] randomizedRooms = new Room[10];
		String[] lables = {"fire extinguisher" , "extinguisher", "fire-extinguishing system", "fire-extinguishing thing", "fire extinguishing system", "fire extinguishing thing"};
		String [] lables1 = {"paper", "sheet", "piece of paper", "piece paper", "piece", "report", "assignment", "profile sheet"};
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Piece of paper", lables1));
		items.add(new Item("fire extinguisher", lables));
		rooms[0] = new Room("Commanders Office", items);
		String[] lables2 = {"card", "keycard", "key", "Acsesscard", "idcard"};
		ArrayList<Item> items1 = new ArrayList<Item>();
		items1.add(new Item("KeyCard",lables2));
		rooms[1] = new Room("Reception hall", items1);
		String[] none = {"none"};
		ArrayList<Item> items2 = new ArrayList<Item>();
		items2.add(new Item("none", none));
		rooms[2] = new Room("Armory", items2);
		rooms[3] = new Room("TVRoom", items2);
		//TODO
		rooms[4] = new Room("Music Car", items2);
		rooms[5] = new Room("Workout Car", items2);
		rooms[6] = new Room("Reporting Car", items2);
		rooms[7] = new Room("Filing Car", items2);
		rooms[8] = new Room("Biking Car", items2);
		rooms[9] = new Room("Propaganda Car", items2);
		
		
		rooms[10] = new Room("Security", items2);
		rooms[11] = new Room("Pokemon", items2);
		rooms[12] = new Room("Pirate Car", items2);
		rooms[13] = new Room("Tea Car", items2);
		rooms[14] = new Room("Doot Doot Car", items2);
		rooms[15] = new Room("Surfer Car", items2);
		rooms[16] = new Room("Barracks Car", items2);
		rooms[17] = new Room("Shower Car", items2);
		rooms[18] = new Room("Toilets Car", items2);
		rooms[19] = new Room("Theatre Car", items2);
		rooms[20] = new Room("Billiards Car", items2);
		rooms[21] = new Room("Baseball Car", items2);
		rooms[22] = new Room("Hockey Car", items2);
		rooms[23] = new Room("Maple Syrup Car", items2);
		rooms[24] = new Room("Kebab Car", items2);
		rooms[25] = new Room("Coding Car", items2);
		rooms[26] = new Room("Sushi Car", items2);
		
		
		// Set rooms locations
		int[] usedRooms = new int[12];
		int random = 0;
		for(int i = 0; i <= randomizedRooms.length; i++){
			boolean randomUnused = true;
			while(randomUnused){
				random = (int)(Math.random()*rooms.length);
				if(i != rooms.length-1){
				for(int j = 0; j < usedRooms.length; j++){
					if(usedRooms[j] != random){
						randomUnused = false;
					}else{
						randomUnused = true;
						j += usedRooms.length;
					}
				}
				}else{
					randomUnused = false;
				}
			}
			
			
			
			if(i == 0){
				rooms[0].setExit('N', rooms[random]);
				usedRooms[0] = 0;
				usedRooms[i+1] = random;
			}else if(i == rooms.length-1){
				rooms[usedRooms[i]].setExit('S', rooms[usedRooms[i-1]]);
				randomizedRooms[i-1] = rooms[usedRooms[i-1]];
				randomizedRooms[i] = rooms[usedRooms[i]];
			}else{
			
				rooms[usedRooms[i]].setExit('N', rooms[random]);
				rooms[usedRooms[i]].setExit('S', rooms[usedRooms[i-1]]);
				randomizedRooms[i-1] = rooms[usedRooms[i-1]];
				usedRooms[i+1] = random;
			}
			
		}
		
		
		
		
		while(playGame){
			
			time--;
			if(time <=0){
				
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/boom.jpg"));
				displayTextMilitaryStyle(x, "BOOOOOOOOOOOOOOOOOOOOOOOOOOOM! You took to long and the terrorist exploded the bomb. You lose, plaese play again!");
				
			}else if(time == 20){
				
				displayTextMilitaryStyle(x, "20 Min Remaining");
				
			}else if(time == 10){
				
				displayTextMilitaryStyle(x, "10 Min Remaining");
				
			}else if(time == 5){
				
				displayTextMilitaryStyle(x, "5 Min Remaining");
				
			}else if(time == 2){
				
				displayTextMilitaryStyle(x, "2 Min Remaining");
				
			}else if(time == 1){
				
				displayTextMilitaryStyle(x, "1 Min Remaining");
				
			}
			
			if(time <=0){
			// Commanders office
			}else if(randomizedRooms[location].getRoomName().equals("Commanders Office")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
				
			
			// Receptionist's Hall
			}else if(randomizedRooms[location].getRoomName().equals("Reception hall")){  
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/test1.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Armory")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Armory.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("TVRoom")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Cad.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Workout Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Buff.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Reporting Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Bill Nye the News Guy.png"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Filing Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Files2.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Biking Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Road biker.png"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Propaganda Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Propaganda.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Music Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Security")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/SecurityRoom.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Pokemon")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Pokemon.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Pirate Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Pirate.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Tea Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Tea.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Doot Doot Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Doot.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Surfer Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/surfing.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Barracks Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Barraks.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Shower Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Shower.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Toilets Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/bathroom.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Theatre Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Billiards Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Baseball Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Hockey Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Maple Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Kebab Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Coding Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(randomizedRooms[location].getRoomName().equals("Sushi Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}
			
			
			
			
			/*
			rooms[10] = new Room("Security", items2);
			rooms[11] = new Room("Pokemon", items2);
			rooms[12] = new Room("Pirate Car", items2);
			rooms[13] = new Room("Tea Car", items2);
			rooms[14] = new Room("Doot Doot Car", items2);
			rooms[15] = new Room("Surfer Car", items2);
			rooms[16] = new Room("Barracks Car", items2);
			rooms[17] = new Room("Shower Car", items2);
			rooms[18] = new Room("Toilets Car", items2);
			rooms[19] = new Room("Theatre Car", items2);
			rooms[20] = new Room("Billiards Car", items2);
			rooms[21] = new Room("Baseball Car", items2);
			rooms[22] = new Room("Hockey Car", items2);
			rooms[23] = new Room("Maple Syrup Car", items2);
			rooms[24] = new Room("Kebab Car", items2);
			rooms[25] = new Room("Coding Car", items2);
			rooms[26] = new Room("Sushi Car", items2);
			 */
			
			
		}
		saveUsers(users);
		
		
	}

	
	private static int waitForProperInput(Display x, Room room, int[] currentUser, ArrayList<User> users, int location, Room[] randomizedRooms) {
		// TODO Auto-generated method stub
		boolean loop = false;
		while(!loop){
			System.out.println("Hello");
		while(x.textSent.equals("")){
			 try {                                                                                                                                                                                                          
	                Thread.sleep(1000); //3000 milliseconds is three seconds.                                                                                                                                                   
	            } catch (InterruptedException ex) {                                                                                                                                                                            
	                Thread.currentThread().interrupt();                                                                                                                                                                        
	            }   
		}
		String[] commandWords = null;
		if(x.textSent.indexOf(" ") != -1){
		String[] commandWordsTemp = {x.textSent.substring(0,x.textSent.indexOf(" ")), x.textSent.substring(x.textSent.indexOf(" ")+1)};
		commandWords = commandWordsTemp;
		
		//	Command typed = new Command(commandWords[0], commandWords[1]);
		// TODO Check if command is valid
			boolean commandWord = true, goOnToSecond = false;
			while(commandWord){
				for(int i = 0; i < commands.length; i++){
					if(commandWords[0].equalsIgnoreCase(commands[i])){
						commandWord = false;
						goOnToSecond = true;
						i += commands.length;
					}else if (i == commands.length-1){
						loop = false;
						commandWord = false;
						displayTextMilitaryStyle(x, "That command is not recognized.\n");
					}
				}
			}
			commandWord = true;
			if(goOnToSecond){
				if(commandWords[0].equalsIgnoreCase("pickup")){
					boolean validItem = false;
					for(int i = 0; i < room.getItems().size(); i++){	
						for(int j = 0; j < room.getItems().get(i).getLables().length; j++){
						if(commandWords[1].equalsIgnoreCase(room.getItems().get(i).getLables()[j])){
							
							displayTextMilitaryStyle(x, "You picked up the " + commandWords[1] + ".\n");
							users.get(currentUser[0]).addToInventory(room.getItems().get(i));
							room.getItems().remove(i);
							x.textSent = "";
							i += room.getItems().size();
							loop = false;
							commandWord = true;
							j += room.getItems().get(i).getLables().length;
							validItem = true;
						}
						}
					}
					if(!validItem){
						displayTextMilitaryStyle(x,"That is not a valid Item!");
					}
				}else if(commandWords[0].equalsIgnoreCase("shoot")){
					
				}else if(commandWords[0].equalsIgnoreCase("exit") || commandWords[0].equalsIgnoreCase("go")){
					if(commandWords[1].equalsIgnoreCase("North") || commandWords[1].equalsIgnoreCase("South")){
						if(location == 0 && commandWords[1].equalsIgnoreCase("South")){
							displayTextMilitaryStyle(x, "That is invalid.");
							x.textSent = "";
						}else if(location == randomizedRooms.length-1 && commandWords[1].equalsIgnoreCase("North")){
							displayTextMilitaryStyle(x, "That is invalid.");
							x.textSent = "";
						}else{
							loop = true; 
							commandWord = false;
							goOnToSecond = false;
							if(commandWords[1].equalsIgnoreCase("North")){
								displayTextMilitaryStyle(x, "You are now in " + randomizedRooms[location + 1].getRoomName() + ".\n");
								x.textSent = ("");
								return location + 1;
							}else{
								displayTextMilitaryStyle(x, "You are now in " + randomizedRooms[location - 1].getRoomName() + ".\n");
								x.textSent = ("");
								return location - 1;
							}
						}
					}
				}
			}
		}
			
		x.textSent = "";
		// TODO Outcome if valid
		//displayTextMilitaryStyle(x, "Ok Soldier\n");
	}
		x.textSent = "";
		return location;
	}
	//The method for the test program, you could just copy paste this into your program and put the string for the url in the parameters.
	
	
	public static synchronized void playSound(final String url) {
		
		    
		
	}
	
	
	private static void displayTextMilitaryStyle(Display x, String str) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < str.length(); i++){
			if(str.substring(i, i+1).equals("\n")){
				x.display(str.substring(i, i+1));
				sleep(300);
			}else{
				x.display(str.substring(i, i+1));
				sleep(25);
			}
		}
	}



	private static void waitForProperInput(Display x, String string) {
		// TODO Auto-generated method stub
		boolean loop = false;
		while(!loop){
		while(x.textSent.equals("")){
			 try {                                                                                                                                                                                                          
	                Thread.sleep(1000); //3000 milliseconds is three seconds.                                                                                                                                                   
	            } catch (InterruptedException ex) {                                                                                                                                                                            
	                Thread.currentThread().interrupt();                                                                                                                                                                        
	            }   
		}
		String[] commandWords = x.textSent.split(" ");
	//	Command typed = new Command(commandWords[0], commandWords[1]);
		// TODO Check if command is valid
			if(commandWords[0].equalsIgnoreCase(string)){
				loop = true;
			}
		}
		// TODO Outcome if valid
		displayTextMilitaryStyle(x, "Ok Soldier\n");
		x.textSent = ("");
	}

	

	@SuppressWarnings("unused")
	private static boolean checkIfValid(Display x, String string) {
		// TODO Auto-generated method stub
		String[] conditions = string.split("|");
		String[] inputs = x.textSent.split(" ");
		for(int i = 0; i < conditions.length; i++){ 
			if(!(conditions[i].equals(inputs[i])));
			x.textSent = "";
			return false;
		}
		return true;
	}



	private static void saveUsers(ArrayList<User> users) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer;
		try {
			writer = new FileWriter(new File("input/users.dat"));
			for(User u : users){
				writer.write(u.getMyUsername() + " " + u.getMyPassword() + " ");
				writer.write("" + u.getMyHighscore().getHighscore() + " ");
				writer.write(u.getMyHighscore().getDate().get(Calendar.DAY_OF_MONTH) + " ");
				writer.write(u.getMyHighscore().getDate().get(Calendar.MONTH) + " ");
				writer.write(u.getMyHighscore().getDate().get(Calendar.YEAR) + " ");
				for(int i = 0; i < u.getMyAchivements().getMyAchivements().length; i++){
					writer.write(u.getMyAchivements().achivementAsString(i) + " ");
				}
				writer.write("\n");
			}
			  writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
            
            
          
	}

	private static void importUsers(ArrayList<User> users) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File("input/users.dat"));  
		while(scanner.hasNext()){
			String[] temp = scanner.nextLine().split(" ");
			boolean[] achivements = new boolean[5];
			for(int i = 6; i < temp.length; i++){
				achivements[i-6] = temp[i].equals("true");
			}
			Highscores highscore = new Highscores(Integer.parseInt(temp[2]), temp[0], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
			users.add(new User(temp[0], temp[1], new Achivement(achivements), highscore));
		}
	}
	
	public static void printAllHighscores(ArrayList<User> list){
		
		
		
	}

	public static void sleep(int time){
		 try {                                                                                                                                                                                                          
             Thread.sleep(time); //3000 milliseconds is three seconds.                                                                                                                                                   
         } catch (InterruptedException ex) {                                                                                                                                                                            
             Thread.currentThread().interrupt();                                                                                                                                                                        
         }   
	}
	
}
