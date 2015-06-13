package com.bayviewglen.maingame;

public class BigBrother extends NPC {

	public BigBrother(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x,
				"*Big Brother looms on a large screen in the car*\n");
		if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Have you seen any suspicious activity around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Have you checked the cameras on the train recently?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 How many question have you done?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
				if (input == 1) {
					displayTextMilitaryStyle(x, "\"No.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(
							x,
							"\"I talked to Mike in Security about it, but he said there wasn’t anything. Whoever's doing this is obviously very sneaky.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x, "\"Uh…you feeling ok, sir?\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Have you seen any suspicious activity around here?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Have you checked the cameras on the train recently?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x,
								"3 How many question have you done?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
					if (input == 1) {
						displayTextMilitaryStyle(x, "\"I SEE ALL. SUBMIT.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"I HAVE NO NEED TO CHECK CAMERAS. I AM THE CAMERAS.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x,
								"\"I HAVE NO NEED FOR QUESTIONS. I ALREADY KNOW THE ANSWER.\"\n");
						questions[2] = true;
					} else {
						loop = false;
				
				}
			}
		}
	}
}