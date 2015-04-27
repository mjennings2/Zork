package com.bayviewglen.maingame;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Display {
	
	
    private int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	public String textSent = "";
	public JLabel lblNewLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display window = new Display("C:\\Users\\Mathew\\Pictures\\Camera Roll\\WIN_20150402_141452.JPG");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 * @param image 
	 */
	public Display(String image) {
		initialize(image);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param image 
	 */
	private void initialize(String image) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int width = (int) screenSize.getWidth();
	    int height = (int) screenSize.getHeight();

		frame = new JFrame();
		frame.setBounds(0, 0, width, height-55);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
					textSent = textField.getText();
					textField.setText("");
				}
				
			}
		});
//		textField.setBounds(15, (int)(923.0/1025.0 * 1025), (int)(1774.0 / 1920.0 * 1920), (int)(30.0/1025.0 * 1025));

		textField.setBounds(15, (int)(923.0/1025.0 * height-45), 1774, 23);
		textField.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Enter");
		//		button.setBounds((int)(1795.0/1920.0 * 1920), (int)(978.0 / 1025.0 * 1025),(int)(90.0/1920.0 * 1920), (int)(30.0/1025.0*1025));
		JScrollPane scrollPane = new JScrollPane();
		//scrollPane.setBounds(15, (int)(1025*0.71203703703703703703703703703704), 1920-(int)(0.02604166666666666666666666666667 * 1920), (int)(1025*0.18518518518518518518518518518519));
		scrollPane.setBounds(15, (int)((height-55)*0.71203703703703703703703703703704), width-(int)(0.02604166666666666666666666666667 * width), (int)((height-55)*0.18518518518518518518518518518519));
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		DefaultCaret caret = (DefaultCaret)textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		scrollPane.setViewportView(textArea);
		button.setBounds((int)(1795.0/1920.0 * width), (int)(923.0/1025.0 * (height-55)),(int)(90.0/1920.0 * width), (int)(30.0/1025.0*(height-55)));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					textSent = textField.getText();
					textField.setText("");
			}
		});
		
		
		frame.getContentPane().add(button);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(image));
		//lblNewLabel.setBounds(15, 15, 1920-(int)(0.02604166666666666666666666666667 * 1920), (int) (1025 * 0.7024390243902439024390243902439));
		lblNewLabel.setBounds(15, 15, width-(int)(0.02604166666666666666666666666667 * width), (int) ((height-55) * 0.7024390243902439024390243902439));
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void display(String output){
		
		textArea.append(output);
		
	}
	
	public void displayln(String output){
		
		textArea.append(output + "\n");
		
	}
	
	
}
