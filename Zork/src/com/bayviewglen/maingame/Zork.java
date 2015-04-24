package com.bayviewglen.maingame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
		login.frame.setVisible(false);
		String image = "input/pictures/Infantry Car.JPG";
		Display x = new Display(image);
		x.frame.setVisible(true);
		x.display("Hello and welcome to Trouble in Nuke on a Train Town!\n");
		saveUsers(users);
	}

	

	private static void saveUsers(ArrayList<User> users) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer;
		try {
			writer = new FileWriter(new File("input/users.dat"));
			for(User u : users){
				writer.write(u.getMyUsername() + " " + u.getMyPassword() + "\n");
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
			users.add(new User(temp[0], temp[1]));
		}
	}

}
