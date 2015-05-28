package com.bayviewglen.maingame;

public class DanceHarmstring extends NPC {

	public DanceHarmstring(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Dance is riding around the track*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 What are those syringes doing on the ground? Someone might hit them by accident!\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 What's your favorite shirt color?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Yes, I did. Someone was sneaking around the payload, but I didn't catch their name.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Some of the other biker may have been using them, I'll go pick them up!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"I really like the color blue.\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Have you seen anything suspicious lately?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 What are those syringes doing on the ground? Someone might hit them by accident!\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x, "3 What's your favorite shirt color?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"No! No, nothing…nothing at all… \"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"THOSE AREN'T MINE. I'M CLEAN.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Yellow, of course!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}
	}
}
