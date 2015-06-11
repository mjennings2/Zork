package com.bayviewglen.maingame;

public class BilliardsBo extends NPC {
	public BilliardsBo(String name) {
		super(name);
	}
	 public void TalkTo(Display x, Boolean isTerrorist) {
	        boolean[] questions = {
	            false, false, false
	        };
	        boolean loop = true;
	        displayTextMilitaryStyle(x, "*Bo is playing billiards*\n");
	        if (isTerrorist) {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What? Why are you playing by yourself?\n");
	                }
	                if (!questions[1]) {
	                    displayTextMilitaryStyle(x, "2 What is the goal here?\n");
	                }
	                if (!questions[2]) {
	                    displayTextMilitaryStyle(x, "3 Well, Good luck with your game!\n");
	                }
	                displayTextMilitaryStyle(x, "4 Goodbye\n");
	                int input = waitForProperInput(x, "1 2 3 4");
	                if (input == 1) {
	                    displayTextMilitaryStyle(x, "\"DON'T JUDGE ME! I DON'T ASK YOU WHY YOU'RE ASKING QUESTIONS TO EVERYONE ON THIS GOD FORSAKEN TRAIN. END RANT.\"\n");
	                    questions[0] = true;
	                } else if (input == 2) {
	                    displayTextMilitaryStyle(x, "\" It's a countdown, I'm seeing if I can get the time it takes to be equal.\"\n");
	                    questions[1] = true;
	                } else if (input == 3) {
	                    displayTextMilitaryStyle(x, "\"Thanks, I won't be playing for long though!\"\n");
	                    questions[2] = true;
	                } else {
	                    loop = false;
	                }

	            }
	        } else {
	            while (loop) {
	                if (!questions[0]) {
	                    displayTextMilitaryStyle(x, "1 What? Why are you playing by yourself?\n");
	                }
	                if (!questions[1]) {
	                        displayTextMilitaryStyle(x, "2 What is the goal here?\n");
	                    }
	                    if (!questions[2]) {
	                        displayTextMilitaryStyle(x, "3 Well, Good luck with your game!\n");
	                    }
	                    displayTextMilitaryStyle(x, "4 Goodbye\n");
	                    int input = waitForProperInput(x, "1 2 3 4");
	                    if (input == 1) {
	                        displayTextMilitaryStyle(x, "\"DON'T JUDGE ME! I DON'T ASK YOU WHY YOU'RE ASKING QUESTIONS TO EVERYONE ON THIS GOD FORSAKEN TRAIN. END RANT.\"\n");
	                        questions[0] = true;
	                    } else if (input == 2) {
	                        displayTextMilitaryStyle(x, "\"How fast I can get all the balls in.\"\n");
	                        questions[1] = true;
	                    } else if (input == 3) {
	                        displayTextMilitaryStyle(x, "\"Thanks.\"\n");
	                        questions[2] = true;
	                    } else {
	                        loop = false;
	                    }
	                }
	            }
	        

	    }
}