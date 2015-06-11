package com.bayviewglen.maingame;

public class MrSkeltal extends NPC {

	public MrSkeltal(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x, "Receptionist: Hello?\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Mr. Skeltal, have you seen anything suspicious around here?\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x,
							"2 Mr. Skeltal, can you help me on my traitor-finding journey?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x, "3 Have you had your spooks today?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"*Mr. Skeltal says nothing, due to the fact that he is a skeleton*\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"*Mr. Skeltal says nothing, due to the fact that he is a skeleton*\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"*Mr. Skeltal STILL says nothing, due to the fact he is a skeleton*\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(x, "1 Mr. Skeltal, have you seen anything suspicious around here?\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Mr. Skeltal, can you help me on my traitor-finding journey?\n");
					}
					if (!questions[2]) {
						displayTextMilitaryStyle(x, "3 Have you had your spooks today?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Mr. Skeltal has seen nothing. Thanks Mr. Skeltal.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Good calcium and bones to you. Thanks Mr. Skeltal.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"Lots of spooks today. Thanks Mr. Skeltal.\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}
			}
		}
	}
}
