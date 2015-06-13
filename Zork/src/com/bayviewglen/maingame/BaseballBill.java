package com.bayviewglen.maingame;

public class BaseballBill extends NPC {
	public BaseballBill(String name) {
		super(name);
	}
	 public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "*Bill is casually tossing and catching a baseball*\n");
	        if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What’s that bat for?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 Seen anyone suspicions in the cage?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 How ‘bout dem Blue Jays?\n");
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
	                    displayTextMilitaryStyle(x, "1 What’s that bat for?\n");
	                }
	                if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 Seen anyone suspicions in the cage?\n");
	                    }
	                    if (!questions[2]) {
	                        displayTextMilitaryStyle(x, "3 How ‘bout dem Blue Jays?\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"Hitting the ball!\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"Yeah, there was an unknown sneakin’ around.\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"They're doing well this season!\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        

	    }
}