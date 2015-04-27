package com.bayviewglen.maingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner; 

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
			 try {                                                                                                                                                                                                          
	                Thread.sleep(1000); //3000 milliseconds is three seconds.                                                                                                                                                   
	            } catch (InterruptedException ex) {                                                                                                                                                                            
	                Thread.currentThread().interrupt();                                                                                                                                                                        
	            }   
		}
		
		Display x = new Display("input/pictures/test.jpg");
		x.frame.setVisible(true);
		x.display("Hello and welcome to Trouble in Nuke on a Train Town!\n");
		try {                                                                                                                                                                                                          
            Thread.sleep(1000); //3000 milliseconds is three seconds.                                                                                                                                                   
        } catch (InterruptedException ex) {                                                                                                                                                                            
            Thread.currentThread().interrupt();                                                                                                                                                                        
        }
		waitForProperInput(x, "How do i use the thing method");
		
		x.frame.setVisible(false);
		x = new Display("input/pictures/test1.jpg");
		x.frame.setVisible(true);
		saveUsers(users);
		
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
		loop = checkIfValid(x, "hello hi tie");
		}
		System.out.println("HELLO");
		loop = true;
	}



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

}
