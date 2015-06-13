package com.bayviewglen.maingame;

public class SirPoshingtonIII extends NPC {

	public SirPoshingtonIII(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Poshington is drinking his tea, holding one pinky up like a sir*\n");
		if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Mr. Poshington! How lovely to see you again, friend.\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Is it time for tea already?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 How are the tea rations doing?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"That would be SIR Poshington to YOU, plebian.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Of course it is! We have an exotic Green Tea today! It's different, but change is always welcome here!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Well they WOULD be just fine, but unfortunately we haven't ordered any in a while. Would you talk to DesLauriers about that?\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Mr. Poshington! How lovely to see you again, friend.\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Is it time for tea already?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 How are the tea rations doing?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"That would be SIR Poshington the THIRD to YOU, simpleton.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Of course! We have a lovely Earl Grey today, so fragrant!\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Well they WOULD be just fine, but some imbecile was tossing boxes of leaves off the train. I don't trust people who do that!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}
	}
}
