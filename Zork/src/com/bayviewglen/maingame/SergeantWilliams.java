package com.bayviewglen.maingame;

public class SergeantWilliams extends NPC {
	public SergeantWilliams(String name) {
		super(name);
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*You see feet under the bathroom stall*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Who's in there?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 How long have you been in there?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 Get out soon Sergeant!!!\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Sergeant Williams!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Only a couple of min!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Right away, sir!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Who's in there?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 How long have you been in there?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 Get out soon Sergeant!!!\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Sergeant Williams!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Only a couple of hours sir!\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Yes Sir, within the hour!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}

	}
}
