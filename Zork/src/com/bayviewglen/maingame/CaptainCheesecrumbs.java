package com.bayviewglen.maingame;

public class CaptainCheesecrumbs extends NPC {

	public CaptainCheesecrumbs(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Captain Cheesecrumbs is whistling a sea shanty*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Good day Cheesecrumbs, have you seen anything suspicious going on around here lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 How's your, uh, eye doing there?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 A parrot? I didn't think DesLauriers would allow pets on this train...\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Nothing to report, sir!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"In all honesty, I just wear this to look cool. Works, eh?\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"This is actually a genetically engineered attack parrot. DesLauriers' R & D guys have been working on it forever!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Good day Cheesecrumbs, have you seen anything suspicious going on around here lately?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 How's your, uh, eye doing there?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 A parrot? I didn't think DesLauriers would allow pets on this train...\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Aye, I did see some scurvy lad sneakin' around the nuclear hold, I did!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Don't ya know this eyepatch be for pirate night vision? Yarr, silly landlubbers and their pirate stereotypes...\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Are ya questioning me choice of animal accomplice?! Yarr, I oughta make ya walk the plank for this ya sea-dog!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}
	}
}
