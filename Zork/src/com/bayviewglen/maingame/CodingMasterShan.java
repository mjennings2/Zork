package com.bayviewglen.maingame;

public class CodingMasterShan extends NPC {
	public CodingMasterShan(String name) {
		super(name);
	}
	 public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "*Shan is coding like a complete gangsta*\n");
	        if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 Seen anyone who can't code?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 What program are you coding right now?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 Are you ready for the Coding Competition?\n");
	                }
	                displayTextMilitaryStyle(x, "4 Goodbye\n");
	                int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
	                if (input == 1) {
	                    displayTextMilitaryStyle(x, "\"Never, everyone can code.\"\n");
	                    questions[0] = true;
	                } else if (input == 2) {
	                    displayTextMilitaryStyle(x, "\"Terrorist simulator 2015!\"\n");
	                    questions[1] = true;
	                } else if (input == 3) {
	                    displayTextMilitaryStyle(x, "\"Yes Sir!\"\n");
	                    questions[2] = true;
	                } else {
	                    loop = false;
	                }

	            }
	        } else {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 Seen anyone who can't code?\n");
	                }
	                if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 What program are you coding right now?\n");
	                    }
	                    if (!questions[2]) {
	                        displayTextMilitaryStyle(x, "3 Are you ready for the Coding Competition?\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"Yeah, Jackson was here! IS JOKE!\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"Zork.\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"No.\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        

	    }
}