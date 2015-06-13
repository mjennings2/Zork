package com.bayviewglen.maingame;

public class HockeyHank extends NPC {
	public HockeyHank(String name) {
		super(name);
	}
	 public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "*Hank is taking shots on the net*\n");
	        if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What’s that stick for?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 Seen anyone suspicious on the ice?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 How ‘bout dem Leafs?\n");
	                }
	                displayTextMilitaryStyle(x, "4 Goodbye\n");
	                int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
	                if (input == 1) {
	                    displayTextMilitaryStyle(x, "\"Baseball!\"\n");
	                    questions[0] = true;
	                } else if (input == 2) {
	                    displayTextMilitaryStyle(x, "\"Suspicious? On this train? Pft. Yeah right.\"\n");
	                    questions[1] = true;
	                } else if (input == 3) {
	                    displayTextMilitaryStyle(x, "\"I don't follow baseball.\"\n");
	                    questions[2] = true;
	                } else {
	                    loop = false;
	                }

	            }
	        } else {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 Hey, How are you?\n");
	                }
	                if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 Seen anyone suspicious on the ice?\n");
	                    }
	                    if (!questions[2]) {
	                        displayTextMilitaryStyle(x, "3 How ‘bout dem Leafs?\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"Handling the puck.\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"Yeah, there was an unknown sneakin’ around.\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"They are suck!\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        

	    }
}
