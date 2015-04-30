package com.bayviewglen.maingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner; 

import javax.swing.ImageIcon;

import com.bayviewglen.maingame.Display;



public class Zork {
	private static String[] commands = {"go", "quit", "help", "eat", "use", "pickup", "exit", "shoot"};
public static boolean loginAllowed = false;
	public static void main(String[] args) throws Exception {
		int location = 0;
		// TODO Auto-generated method stub
		
		ArrayList<User> users = new ArrayList<User>();
		//int[] currentUser = new int[1];
		int[] currentUser = {0};
		importUsers(users);
		boolean playGame = true;
		
		/*LoginWindow login = new LoginWindow(users, currentUser);
		
		login.frame.setVisible(true);
		while(login.login() < 10){
			 sleep(1000);
		}
		
		login.frame.setVisible(false);
		*/
		
		
		
		Display x = new Display("input/pictures/Title.jpg");
		x.frame.setVisible(true);
		displayTextMilitaryStyle(x,"Hello and welcome to Trouble in Nuke on a Train with a Terrorist Town!\nType commands in the text bar below. Finding out the commands is part of the puzzle!\nLeaving a room is exit, you can go north or south.\nType 'Start' to start\n");
		sleep(1000);
		waitForProperInput(x, "Start");
		x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));
		displayTextMilitaryStyle(x,"Location: Military train bound for San Fransisco. \nOperation Nuke: The train is carrying a nuclear weapon on a flat bed.\nTime to arrival: 30 min.\nYou are in General DesLauriers Office at the south most part of the train.\nHe is giving you special instructions.\nDesLauriers:\n\"Alright Maggot! We've got a Problem!\nThe train is crying!\nWe are carrying a nuclear payload and have caught wind of a traitor in our ranks!\nYour mission: find this traitor and bring him to Java justice!\nHere, take this fire extinguisher just in case, and this pistol for any traitor-hunting duties you may have to fulfill.\nGet to work, soldier!\n");
		
		
		// Declare all Rooms
		Room[] rooms = new Room[3];
		Room[] randomizedRooms = new Room[3];
		Item[] items = {new Item("Piece of paper"), new Item("fire extinguisher")};
		rooms[0] = new Room("Commanders Office", items);
		Item[] items1 = {new Item("KeyCard")};
		rooms[1] = new Room("Commanders Office", items);
		Item[] items2 = {new Item("Gun"), new Item("Combat Knife")};
		rooms[2] = new Room("Armory", items);
		
		// Set rooms locations
		int[] usedRooms = new int[3];
		
		for(int i = 0; i < rooms.length; i++){
			int random = (int)(Math.random()*rooms.length);
			if(i == 0){
				rooms[0].setExit('N', rooms[random]);
				usedRooms[0] = 0;
			}else if(i == rooms.length-1){
				rooms[usedRooms[i]].setExit('S', rooms[usedRooms[i-1]]);
				randomizedRooms[i-1] = rooms[usedRooms[i-1]];
				randomizedRooms[i] = rooms[usedRooms[i]];
			}else{
			
				rooms[usedRooms[i]].setExit('N', rooms[random]);
				rooms[usedRooms[i]].setExit('S', rooms[usedRooms[i-1]]);
				randomizedRooms[i-1] = rooms[usedRooms[i-1]];
			}
			usedRooms[i+1] = random;
		}
		
		
		
		
		while(playGame){
			
			// Commanders office
			if(location == 0){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
				
			
			// Receptionist's Hall
			}else if(location == 1){  
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/test.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}else if(location == 2){
				x.lblNewLabel.setIcon(new ImageIcon("input/pictures/test1.jpg"));
				location = waitForProperInput(x, rooms[0], currentUser, users, location, randomizedRooms);
			}
		}
		saveUsers(users);
		
		
	}

	

	private static int waitForProperInput(Display x, Room room, int[] currentUser, ArrayList<User> users, int location, Room[] randomizedRooms) {
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
		String[] commandWords = {x.textSent.substring(0,x.textSent.indexOf(" ")), x.textSent.substring(x.textSent.indexOf(" ")+1)};
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
						displayTextMilitaryStyle(x, "That command is not recodnized.\n");
					}
				}
			}
			commandWord = true;
			if(goOnToSecond){
				if(commandWords[0].equalsIgnoreCase("pickup")){
					for(int i = 0; i < room.getItems().length; i++){
						if(commandWords[1].equalsIgnoreCase(room.getItems()[i].getName())){
							displayTextMilitaryStyle(x, "You picked up the " + commandWords[1] + ".\n");
							users.get(currentUser[0]).addToInventory(room.getItems()[i]);
							i += room.getItems().length;
						}
					}
				}else if(commandWords[0].equalsIgnoreCase("shoot")){
					if(commandWords[1].equalsIgnoreCase("DesLauriers") || commandWords[1].equalsIgnoreCase("The General") || commandWords[1].equalsIgnoreCase("General DesLaurier")){
						x.lblNewLabel.setIcon(new ImageIcon("input/pictures/Commanders_Desk_Dead.jpg"));
						displayTextMilitaryStyle(x, "You shot the General! You were the traitor all along!\nYou walk behind the desk, and flip a switch\n");
						x.lblNewLabel.setIcon(new ImageIcon("input/pictures/boom.jpg"));
						displayTextMilitaryStyle(x, "Allahu Akbar");
						loop = true;
						commandWord = false;
						goOnToSecond = false;
					}
				}else if(commandWords[0].equalsIgnoreCase("exit")){
					if(commandWords[1].equalsIgnoreCase("North") || commandWords[1].equalsIgnoreCase("South")){
						if(location == 0 && commandWords[1].equalsIgnoreCase("South")){
							displayTextMilitaryStyle(x, "That is invalid.");
						}else if(location == randomizedRooms.length && commandWords[1].equalsIgnoreCase("North")){
							displayTextMilitaryStyle(x, "That is invalid.");
						}else{
							loop = true;
							commandWord = false;
							goOnToSecond = false;
							if(commandWords[1].equalsIgnoreCase("North")){
								displayTextMilitaryStyle(x, "You are now in " + randomizedRooms[location + 1].getRoomName() + ".");
								return location + 1;
							}else{
								displayTextMilitaryStyle(x, "You are now in " + randomizedRooms[location - 1].getRoomName() + ".");
								return location - 1;
							}
						}
					}
				}
			}
			
		
		// TODO Outcome if valid
		//displayTextMilitaryStyle(x, "Ok Soldier\n");
	}
		x.textSent = "";
		return location;
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
			if(commandWords[0].equalsIgnoreCase("start")){
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
