package com.bayviewglen.maingame;

public class CowboyTanaka extends NPC {
	public CowboyTanaka(String name) {
		super(name);

	}
	 public void TalkTo(Display x, Boolean isTerrorist) {
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "*Tanaka is fileting salmon*?\n");
	        if (isTerrorist) {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 Since when do we have a sushi car?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 Have you seen anything suspicious around here?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 Need any extra sushi supplies?\n");
	                }
	                displayTextMilitaryStyle(x, "4 Goodbye\n");
	                int input = waitForProperInput(x, "1 2 3 4");
	                if (input == 1) {
	                    displayTextMilitaryStyle(x, "\"Let’s see what time is it? Ah about 7 hours.\"\n");
	                    questions[0] = true;
	                } else if (input == 2) {
	                    displayTextMilitaryStyle(x, "\"No!\"\n");
	                    questions[1] = true;
	                } else if (input == 3) {
	                    displayTextMilitaryStyle(x, "\"No thanks, I have everything I need.\"\n");
	                    questions[2] = true;
	                } else {
	                    loop = false;
	                }

	            }
	        } else {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 Since when do we have a sushi car?\n");
	                }
	                if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 Have you seen anything suspicious around here?\n");
	                    }
	                    if (!questions[2]) {
	                        displayTextMilitaryStyle(x, "3 Need any extra sushi supplies?\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"It was added about a week ago.\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"No!\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"Always!\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        }

	    
}
