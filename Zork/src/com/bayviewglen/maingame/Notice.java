package com.bayviewglen.maingame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Component;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Notice {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notice window = new Notice(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param string 
	 */
	public Notice(String string) {
		initialize(string);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param string 
	 */
	private void initialize(String string) {
		frame = new JFrame();
		frame.setBounds(100, 100, 880, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblInserVarHere = new JLabel(string);
		lblInserVarHere.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblInserVarHere.setMinimumSize(new Dimension(200, 20));
		lblInserVarHere.setBounds(169, 67, 520, 20);
		frame.getContentPane().add(lblInserVarHere);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				
			}
		});
		btnOk.setBounds(372, 154, 115, 29);
		frame.getContentPane().add(btnOk);
	}

}
