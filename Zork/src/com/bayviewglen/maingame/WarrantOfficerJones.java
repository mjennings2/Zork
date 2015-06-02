package com.bayviewglen.maingame;

public class WarrantOfficerJones extends NPC {
	public WarrantOfficerJones(String name) {
		super(name);
	}
	 public void TalkTo(Display x, Boolean isTerrorist) {
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "Receptionist: Hello?\n");
	        if (isTerrorist) {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What movie is playing?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 What is your next shift?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 How are the kids?\n");
	                }
	                displayTextMilitaryStyle(x, "4 Goodbye\n");
	                int input = waitForProperInput(x, "1 2 3 4");
	                if (input == 1) {
	                    displayTextMilitaryStyle(x, "\"Team America - I LOVE America!!!!\"\n");
	                    questions[0] = true;
	                } else if (input == 2) {
	                    displayTextMilitaryStyle(x, "\"I'm on the nuke.\"\n");
	                    questions[1] = true;
	                } else if (input == 3) {
	                    displayTextMilitaryStyle(x, "\"Not that I've seen.\"\n");
	                    questions[2] = true;
	                } else {
	                    loop = false;
	                }

	            }
	        } else {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What movie is playing?\n");
	                    if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 What is your next shift?\n");
	                    }
	                    if (questions[2]) {
	                        displayTextMilitaryStyle(x, "3 How are the kids?\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"The Avengers!\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"Guarding the Armory.\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"Not that I've seen.\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        }


	    }
}
