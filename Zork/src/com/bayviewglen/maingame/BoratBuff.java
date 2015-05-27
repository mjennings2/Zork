package com.bayviewglen.maingame;

public class BoratBuff extends NPC {

	public BoratBuff(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Borat Buff is getting super swole in the exercise room*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Buff! Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 I forgot, what's your favorite country again?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 Seen any good movies lately?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Nothing, sir.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Uhhh…America I guess?\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Oh man, if you haven't seen the new Avengers, you're missing out!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Buff! Have you seen anything suspicious lately?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 I forgot, what's your favorite country again?\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x, "3 Seen any good movies lately?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"VERY NIIIIIIICE!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"GLORIOUS NATION OF KAZAKHSTAN!\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"WATCH BORAT COMRADE, OF GOOD MOVIE!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}
	}
}
