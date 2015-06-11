package com.bayviewglen.maingame;

public class DankSiesta extends NPC {

	public DankSiesta(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Dank is jamming out loudly, clearly entranced in the music*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Hey! Dank! Have you seen anything weird around here lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Dank! Can you hear me?!\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 DANK! HOW LONG HAVE YOU BEEN HERE!?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"(He doesn't hear you, but his playing is on point…)\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"(He doesn't hear you, but his playing is on point…)\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Oh, hey captain. I've only been here for about 5 minutes, I've got more playing to do!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Hey! Dank! Have you seen anything weird around here lately\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Dank! Can you hear me?!\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 DANK! HOW LONG HAVE YOU BEEN HERE!?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"(He doesn't hear you, but his playing is on point…)\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"(He doesn't hear you, but his playing is on point…)\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"(He doesn't hear you, but his playing is on point…)\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}
	}
}
