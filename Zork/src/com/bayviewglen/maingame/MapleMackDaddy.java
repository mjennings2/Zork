package com.bayviewglen.maingame;

public class MapleMackDaddy extends NPC {
	public MapleMackDaddy(String name) {
		super(name);
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "Receptionist: Hello?\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Seen anything suspicious around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Why is there no Maple Toffee here?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 Pop Quiz: Where do we store the maple syrup?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Suspicious? On this train? Pft. Yeah right.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Because your mom goes to college.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"In the refrigeration car.\"\n");
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
								"2 Why is there no Maple Toffee here?\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x, "3 Pop Quiz: Where do we store the maple syrup?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Nah bud! No one comes round the maple syrup car anymore. :(\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Just about to make a batch here, eh?\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Under the floor eh bud!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}

	}

}