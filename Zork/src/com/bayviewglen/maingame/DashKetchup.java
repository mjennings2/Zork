package com.bayviewglen.maingame;

public class DashKetchup extends NPC {

	public DashKetchup(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "*Dash says nothing, only looking at the red and white balls on the table*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Have you seen anything suspicious around here recently?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Where's your weapon soldier? You're only carrying those little red and white balls!\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 What do you do for fun?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Nothing to report, Captain!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"My .45 is being serviced in the armory, it'll be done within a quarter hour sir!\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Eh, drink. Play billiards. Shoot stuff. Army things, captain!\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Have you seen anything suspicious around here recently?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Where's your weapon soldier? You're only carrying those little red and white balls!\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x, "3 What do you do for fun?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Only my SICK EV-TRAINED POKEMON!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Pfft, filthy casual. These are pokeballs, containing my perfect team.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Battle other trainers, it's fun AND gets me money!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}
	}
}
