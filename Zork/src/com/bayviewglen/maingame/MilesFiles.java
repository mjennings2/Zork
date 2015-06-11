package com.bayviewglen.maingame;

public class MilesFiles extends NPC {

	public MilesFiles(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x,
				"*Miles is furiously organizing files into neat piles*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Seen anything suspicious going on around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Can you access some personal files? I'm on a mission and-\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 Is that a spot on your desk?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x, "\"Nothing to report, sir!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(
							x,
							"\"Yeah, sure! I…uh…just gotta find them first…yeaaaaah sorry, can't do that now, heh!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\" Ehhh, whatever. I'll clean it up later.\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Seen anything suspicious going on around here?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Can you access some personal files? I'm on a mission and-\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 How are the kids?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Nothing to report, sir!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(
								x,
								"\"Sorry captain, can't do that. DesLauriers has said no files can be viewed at this time. Everything you need is in your mission detail.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"*gasps* NOOOOO! OUT DAMNED SPOT! *furiously cleans spot*\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}
	}
}
