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



public class Zork implements Serializable{
	private static String[] commands = {"talk","go", "quit", "help", "eat", "use", "pickup", "exit", "shoot"};
	public static boolean loginAllowed = false;
	public static void main(String[] ar gs) throws Exception {
		int traitor = (int) (Math.random() * 27) + 1;
		int location = 0;
		double time[] = {31};
		Room[] randomizedRooms = null;
		Room[] rooms = null;
		boolean[] newUser = {false};
		// TODO Auto-generated method stub
		// open the sound file as a Java input stream
	   
	  
		ArrayList<User> users =  importUsersTest();
		//ArrayList<User> users =  new ArrayList<User>();
		int[] currentUser = new int[1];
		//int[] currentUser= {0};
		//importUsers(users);
		boolean playGame = true;
		NPC[] npcs = new NPC[27];
		
		npcs[1] = new Receptionist("Receptionist");
		/*npcs[2] = new ArmoryGuard("Armory Gaurd");
		npcs[3] = new BigBrother("Big Brother");
		npcs[4] = new BoratBuff("Borat Buff");
		npcs[5] = new CaptainCheesecrumbs("Captain Cheesecrumbs");
		npcs[6] = new CorporalCad("Corporal Cad");
		npcs[7] = new DanceHarmstring("Dance Harmstring");
		npcs[8] = new DankSiesta("Dank Siesta");
		npcs[9] = new DashKetchup("Dash Ketchup");
		npcs[10] = new JonCitrus("Jon Citrus");
		npcs[11] = new MikeSchmidt("Mike Schmidt");
		npcs[12] = new MilesFiles("Miles Files");
		npcs[13] = new MrSkeltal("Mr. Skeltal");
		npcs[14] = new SirPoshingtonIII("Sir Poshington III");
		npcs[15] = new SurferDude("Surfer Dude");
		npcs[16] = new SergeantJohnson("Sergeant");
		npcs[17] = new SergeantMajorSmith("Seargent Major Smith");
		npcs[18] = new Receptionist();
		npcs[19] = new Receptionist();
		npcs[20] = new Receptionist();
		npcs[21] = new Receptionist();
		npcs[22] = new Receptionist();
		npcs[23] = new Receptionist();
		npcs[24] = new Receptionist();
		npcs[25] = new Receptionist();
		npcs[26] = new Receptionist();
		npcs[27] = new Receptionist();
		*/
		
		LoginWindow login = new LoginWindow(users, currentUser, newUser);
		
		login.frame.setVisible(true);
		while(login.login() < 10){
			 sleep(1000);
			}
		
		login.frame.setVisible(false);
		
		
		
		
		Display x = new Display("input/pictures/Title.jpg");
		x.frame.setVisible(true);
		displayTextMilitaryStyle(x,"Hello and welcome to Trouble in Nuke on a Train with a Terrorist Town!\nType commands in the text bar below. Finding out the commands is part of the puzzle!\nLeaving a room is exit, you can go north or south.\nType 'Start' to start, or 'Load' if you would like to continue your previous game.\n");
		sleep(1000);
		location = waitForStartOrLoad(x, time,currentUser,users, newUser);
		if(time[0] == 31){
		x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));

		displayTextMilitaryStyle(x,"Location: Military train bound for San Fransisco. \nOperation Nuke: The train is carrying a nuclear weapon on a flat bed.\nTime to arrival: 30 min.\nYou are in General DesLauriers Office at the south most part of the train.\nHe is giving you special instructions.\nDesLauriers:\n\"Alright Maggot! We've got a Problem!\nThe train is crying!\nWe are carrying a nuclear payload and have caught wind of a traitor in our ranks!\nYour mission: find this traitor and bring him to Java justice!\nHere, take this fire extinguisher just in case, and this pistol for any traitor-hunting duties you may have to fulfill.\nGet to work, soldier!\n");
		
		//npcs[0] = new Receptionist(x, true);
		
		
				// Declare all Rooms
		rooms = new Room[27];
		randomizedRooms = new Room[10];
		String[] lables = {"fire extinguisher" , "extinguisher", "fire-extinguishing system", "fire-extinguishing thing", "fire extinguishing system", "fire extinguishing thing"};
		String [] lables1 = {"paper", "sheet", "piece of paper", "piece paper", "piece", "report", "assignment", "profile sheet"};
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item("Piece of paper", lables1));
		items.add(new Item("fire extinguisher", lables));
		rooms[0] = new Room("Commanders Office", items, 0);
		String[] lables2 = {"card", "keycard", "key", "Acsesscard", "idcard"};
		ArrayList<Item> items1 = new ArrayList<Item>();
		items1.add(new Item("KeyCard",lables2));
		rooms[1] = new Room("Reception hall", items1, 1);
		String[] none = {"none"};
		ArrayList<Item> items2 = new ArrayList<Item>();
		items2.add(new Item("none", none));
		rooms[2] = new Room("Armory", items2, 2);
		rooms[3] = new Room("TVRoom", items2, 3);
		//TODO
		rooms[4] = new Room("Music Car", items2, 4);
		rooms[5] = new Room("Workout Car", items2, 5);
		rooms[6] = new Room("Reporting Car", items2, 6);
		rooms[7] = new Room("Filing Car", items2, 7);
		rooms[8] = new Room("Biking Car", items2, 8);
		rooms[9] = new Room("Propaganda Car", items2, 9);
		
		
		rooms[10] = new Room("Security", items2, 10);
		rooms[11] = new Room("Pokemon", items2, 11);
		rooms[12] = new Room("Pirate Car", items2, 12);
		rooms[13] = new Room("Tea Car", items2, 13);
		rooms[14] = new Room("Doot Doot Car", items2, 14);
		rooms[15] = new Room("Surfer Car", items2, 15);
		rooms[16] = new Room("Barracks Car", items2, 16);
		rooms[17] = new Room("Shower Car", items2, 17);
		rooms[18] = new Room("Toilets Car", items2, 18);
		rooms[19] = new Room("Theatre Car", items2, 19);
		rooms[20] = new Room("Billiards Car", items2, 20);
		rooms[21] = new Room("Baseball Car", items2, 21);
		rooms[22] = new Room("Hockey Car", items2, 22);
		rooms[23] = new Room("Maple Syrup Car", items2, 23);
		rooms[24] = new Room("Kebab Car", items2, 24);
		rooms[25] = new Room("Coding Car", items2, 25);
		rooms[26] = new Room("Sushi Car", items2, 26);
		
		
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
		
		users.get(currentUser[0]).setMap(randomizedRooms);
		users.get(currentUser[0]).setAllRooms(rooms);
		
		}else{
			
			randomizedRooms = users.get(currentUser[0]).getMap();
			rooms = users.get(currentUser[0]).getAllRooms();
			
		}
		while(playGame){
			time[0]--;
			saveUsersTest(users,location,time,currentUser);
			
			if(time[0] <=0){
				
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/boom.jpg"));
				displayTextMilitaryStyle(x, "BOOOOOOOOOOOOOOOOOOOOOOOOOOOM! You took to long and the terrorist exploded the bomb. You lose, plaese play again!");
				
			}else if(time[0] == 20){
				
				displayTextMilitaryStyle(x, "20 Min Remaining");
				
			}else if(time[0] == 10){
				
				displayTextMilitaryStyle(x, "10 Min Remaining");
				
			}else if(time[0] == 5){
				
				displayTextMilitaryStyle(x, "5 Min Remaining");
				
			}else if(time[0] == 2){
				
				displayTextMilitaryStyle(x, "2 Min Remaining");
				
			}else if(time[0] == 1){
				
				displayTextMilitaryStyle(x, "1 Min Remaining");
				
			}
			
			if(time[0] <=0){
			// Commanders office
			}else if(randomizedRooms[location].getRoomName().equals("Commanders Office")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
				
			
			// Receptionist's Hall
			}else if(randomizedRooms[location].getRoomName().equals("Reception hall")){  
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/test1.jpg"));
				
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Armory")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Armory.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("TVRoom")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Cad.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Workout Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Buff.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Reporting Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Bill Nye the News Guy.png"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Filing Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Files2.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Biking Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Road biker.png"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Propaganda Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Propaganda.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Music Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/TrainGuitar.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Security")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/SecurityRoom.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Pokemon")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Pokemon.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Pirate Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Pirate.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Tea Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Tea.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Doot Doot Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Doot.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Surfer Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/surfing.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Barracks Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Barraks.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Shower Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Shower.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Toilets Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/bathroom.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Theatre Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Billiards Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Baseball Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Hockey Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Maple Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Kebab Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Coding Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}else if(randomizedRooms[location].getRoomName().equals("Sushi Car")){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/DOH.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms, npcs, traitor);
			}
			
			
			
			
			
			
			
		}
		saveUsers(users);
		
		
	}

	
	@SuppressWarnings("static-access")
	private static int waitForProperInput(Display x, Room room, int[] currentUser, ArrayList<User> users, int location, Room[] randomizedRooms, NPC[] npcs, int traitor) {
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
		String[] commandWordsTemp = x.textSent.split(" ");
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
					
				}else if(commandWords[0].equalsIgnoreCase("talk")){
					if(commandWords[1].equalsIgnoreCase("to") || commandWords[1].equalsIgnoreCase("with") || commandWords[1].equalsIgnoreCase(npcs[location].name)){
						if((commandWords[2]!=null && commandWords[1].equalsIgnoreCase(npcs[location].name))){
							x.textSent="";
							npcs[randomizedRooms[location].i].TalkTo(x,traitor==location);
						}else if((commandWords[2].equalsIgnoreCase(npcs[randomizedRooms[location].i].name))){
							x.textSent="";
							npcs[location].TalkTo(x,traitor==location);
						}
					}
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



	private static int waitForStartOrLoad(Display x, double[] time, int[] currentUser, ArrayList<User> users, boolean[] newUser) {
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
			if(commandWords[0].equalsIgnoreCase("Start")){
				displayTextMilitaryStyle(x, "Welcome Soilder!\n");
				x.textSent = ("");
				loop = true;
				return 0;
			}else if(commandWords[0].equalsIgnoreCase("Load") && !newUser[0] ){
				displayTextMilitaryStyle(x, "Welcome back Soilder!\n");
				x.textSent = ("");
				loop = true;
				time[0] = users.get(currentUser[0]).getTime();
				return users.get(currentUser[0]).getLocation();
			}else{
				displayTextMilitaryStyle(x, "That is Invalid.\n");
				x.textSent = ("");
			}
		}
		// TODO Outcome if valid
		
		
		displayTextMilitaryStyle(x, "Ok Soldier\n");
		x.textSent = ("");
		return 0;
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

	private static void saveUsersTest(ArrayList<User> users, int location, double[] time, int[] currentUser){
		
		// Serialization code
        try {
            FileOutputStream fileOut = new FileOutputStream("input/userDetails.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            users.get(currentUser[0]).setLocation(location);
            users.get(currentUser[0]).setTime(time[0]);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
		
		
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

	@SuppressWarnings("unchecked")
	private static ArrayList<User> importUsersTest() throws FileNotFoundException {
		ArrayList<User> deserializedUsers = null;
		try {
            FileInputStream fileIn = new FileInputStream("input/userDetails.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedUsers = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
            return deserializedUsers;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
		return deserializedUsers;
		
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
			
			users.add(new User(temp[0], temp[1], new Achivement(achivements), highscore, 0, 0, null, null));
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
