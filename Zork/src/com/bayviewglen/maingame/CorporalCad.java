package com.bayviewglen.maingame;

public class CorporalCad extends NPC {

	public CorporalCad(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Corporal Cad is watching TV*\n");
		if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 You! Corporal! Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Whatcha watchin' there, Corporal?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 That TV is too loud, soldier! People are sleeping on this train!\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
				if (input == 1) {
					displayTextMilitaryStyle(x, "\"NOTHING TO REPORT, SIR!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x,
							"\"FOOTBALL! YEAH! I LOVE AMERICA!!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x, "\"SIR! MY APOLOGIES, SIR!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 You! Corporal! Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Whatcha watchin' there, Corporal?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x,
								"3 That TV is too loud, soldier! People are sleeping on this train!\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
					if (input == 1) {
						displayTextMilitaryStyle(
								x,
								"\" I dunno, I think some guy snooping around the payload a little while ago… Don't remember who it was though. Sorry, cap.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Game of Thrones. New season, soooo good.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x,
								"\"After this episode, ok?\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}
	}
}
