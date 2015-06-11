package com.bayviewglen.maingame;

public class CurlingCarl extends NPC {
	public CurlingCarl(String name) {
		super(name);
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Carl is standing on the ice with a broom*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 What’s that stick for?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Seen anyone suspicious on the ice?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 How ‘bout dem 2015 CANADIAN MIXED DOUBLES TEAM?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Curling!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Suspicious? On this train? Pft. Yeah right.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Their actually pretty good!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 What’s that stick for?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Seen anyone suspicious on the ice?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 How ‘bout dem 2015 CANADIAN MIXED DOUBLES TEAM?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"You brush the ice in order to speeed up the stone.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Yeah, there was an unknown sneaking around.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"They're actually pretty good!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				
			}
		}

	}
}
