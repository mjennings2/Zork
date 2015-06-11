package com.bayviewglen.maingame;

public class JonCitrus extends NPC {

	public JonCitrus(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "Receptionist: Hello?\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Anything on the news that's noteworthy?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 How's the weather looking in San Francisco?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(
							x,
							"\"Nothing in particular, but make sure to check your mission details to see if everyone's acting right!\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x,
							"\"Satellite's still under maintenance, sir, so nothing yet.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Sunny, high of 80.6 degrees.\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x,
							"1 Have you seen anything suspicious lately?\n");
				}
				if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Anything on the news that's noteworthy?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x,
								"3 How's the weather looking in San Francisco?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"EBOLA!!!!!1!\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"MH370!!!!!1!\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"WEED!!!!!1!\"\n");
						questions[2] = true;
					} else {
						loop = false;
				
				}
			}
		}
	}

}
