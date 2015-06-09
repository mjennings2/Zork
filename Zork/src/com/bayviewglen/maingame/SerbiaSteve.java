package com.bayviewglen.maingame;

public class SerbiaSteve extends NPC {
	public SerbiaSteve(String name) {
		super(name);
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Steve is playing his accordian*?\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Seen anything suspicious around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Are these Kebabs ready?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 Is that shipment of kebabs ready for supply drop?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Yes, someone stole a kebab!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Kebabs are never ready, you know this.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Yes it is ready to be removed!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Seen anything suspicious around here?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Are these Kebabs ready?\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x, "3 Is that shipment of kebabs ready for supply drop?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Yes, someone stole a kebab!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Kebabs are never ready, you know this.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Yes it is ready to be removed!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}

	}
}
