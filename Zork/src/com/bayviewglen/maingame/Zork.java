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
public static boolean loginAllowed = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ArrayList<User> users = new ArrayList<User>();
		importUsers(users);
		LoginWindow login = new LoginWindow(users);
		login.frame.setVisible(true);
		while(login.login() < 10){
			 sleep(1000);
		}
		
		Display x = new Display("input/pictures/Title.jpg");
		x.frame.setVisible(true);
		displayTextMilitaryStyle(x,"Hello and welcome to Trouble in Nuke on a Train with a Terrorest Town!\nType 'Start' to start\n");
		sleep(1000);
		waitForProperInput(x, "Start");
		x.lblNewLabel.setIcon(new ImageIcon("input/pictures/test.jpg"));
		displayTextMilitaryStyle(x,"You are in Commander DesLauriers Office. He is giving you special Instructions.\nCommander:\nBla Bla Bla Bla Bla Bla Bla\nBla Bla Bla Bla Bla Bla Bla\nBla Bla Bla Bla Bla Bla Bla\nI love scrolling text.\nIs Best\n");
		
		saveUsers(users);
		
	}

	

	private static void displayTextMilitaryStyle(Display x, String str) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < str.length(); i++){
			if(str.substring(i, i+1).equals("\n")){
				x.display(str.substring(i, i+1));
				sleep(500);
			}else{
				x.display(str.substring(i, i+1));
				sleep(50);
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
			if(commandWords[0].equals("Start")){
				loop = true;
			}
		}
		// TODO Outcome if valid
		displayTextMilitaryStyle(x, "Ok Soilder\n");
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
