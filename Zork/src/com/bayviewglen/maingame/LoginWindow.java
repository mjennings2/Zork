package com.bayviewglen.maingame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Canvas;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JPasswordField;
import javax.swing.JTextPane;

import java.awt.Label;

import javax.swing.ImageIcon;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class LoginWindow {

	public JFrame frame;
	private JTextField username;
	private JPasswordField password;
	private int[] login = new int[1];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow(ArrayList<User> users) {
		initialize(users);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param users 
	 */
	private void initialize(ArrayList<User> users) {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		username = new JTextField();
		username.setBounds(523, 134, 200, 50);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblLogin = new JLabel("Username:");
		lblLogin.setLabelFor(username);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblLogin.setBounds(396, 145, 131, 20);
		frame.getContentPane().add(lblLogin);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(523, 200, 200, 50);
		frame.getContentPane().add(password);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(396, 211, 131, 20);
		frame.getContentPane().add(lblPassword);
		
		JTextPane txtpnWelcomeTo = new JTextPane();
		txtpnWelcomeTo.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		txtpnWelcomeTo.setText("Welcome to Trouble in Nuke on a Train with a Terrorist Town! If you have an account type your username and password above, then press login. To create an account, type the username you want, the password you want, and hit login. (I advise not useing your regular password, its stored in an unencrypted DAT file.)");
		txtpnWelcomeTo.setBounds(15, 378, 760, 189);
		frame.getContentPane().add(txtpnWelcomeTo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Mathew\\gitZork\\Zork\\input\\pictures\\TTTIcon.png"));
		lblNewLabel.setBounds(63, 69, 258, 265);
		frame.getContentPane().add(lblNewLabel);
		
		Button button = new Button("Login");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hi");
				for(int i = 0; i < users.size(); i++){
					if(users.get(i).getMyUsername().equals(username.getText())){
						if(users.get(i).validatePassword(password.getText())){
							login[0] = 100;
						}else{
							Notice window = new Notice("That password is not recodnized for the username \"" + username.getText());
							window.frame.setVisible(true);
						}
					}else if(i == users.size()-1){
						UsernameMissing window = new UsernameMissing(users, username.getText(), password.getText(), login);
						window.frame.setVisible(true);
					}
				}
				
			}
		});
		button.setActionCommand("Login");
		button.setBounds(575, 281, 85, 50);
		frame.getContentPane().add(button);
	}
	
	public int login(){
		return login[0];
	}
	
}
