package com.bayviewglen.maingame;

public class SurferDude extends NPC {
	
	public SurferDude(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x,	"*Surfer Dude is tearing up the surfing simulator*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Surfer Dude! Have you seen anything suspicious around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 When the hell did we get a wave simulator installed?!\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 Since when is surfing an appropriate military past-time?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(
							x,
							"\"Saw some cat checkin' out the payload a little while ago, but nothing else bro.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x,
							"\"It looks expensive, but it's pretty awesome.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"It doesn’t really matter what you enjoy when you're off duty.\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
			}
			if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Surfer Dude! Have you seen anything suspicious around here?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 When the hell did we get a wave simulator installed?!\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x,
								"3 Since when is surfing an appropriate military past-time?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Nah maaaaaan, I was just riding the waves!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"I dunno maaaaaaan, but it's siiiiiiiick!\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x,
							"\"Don't be such a bummer, maaaaaaan!\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		
	}
}
