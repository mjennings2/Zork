package com.bayviewglen.maingame;

public class MikeSchmidt extends NPC {

	public MikeSchmidt(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {
		boolean[] questions = { false, false, false };
		boolean loop = true;
		displayTextMilitaryStyle(x,
				"*Mike is staring intently at the cameras, watching for any movement*\n");
		if (isTerrorist) {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(
							x,
							"1 Mike, you're my number one choice for security here, even though it's just a summer job. So, I need to you to tell my if you've seen anything suspicious as of late.\n");
				}
				if (!questions[1]) {
					displayTextMilitaryStyle(x, "2 Anything else to report?\n");
				}
				if (!questions[2]) {
					displayTextMilitaryStyle(x,
							"3 How long have you been in here?\n");
				}
				displayTextMilitaryStyle(x, "4 Goodbye\n");
				int input = waitForProperInput(x, "1 2 3 4");
				if (input == 1) {
					displayTextMilitaryStyle(x,
							"\"Nothing on the cams, corporal.\"\n");
					questions[0] = true;
				} else if (input == 2) {
					displayTextMilitaryStyle(x, "\"Uhhh…Not seeing anything. I'll let you know.\"\n");
					questions[1] = true;
				} else if (input == 3) {
					displayTextMilitaryStyle(x,
							"\"Uhhh…3 days? I mean I only just started this summer and I was on break for a bit.\"\n");
					questions[2] = true;
				} else {
					loop = false;
				}

			}
		} else {
			while (loop) {
				if (!questions[0]) {
					displayTextMilitaryStyle(
							x,
							"1 Mike, you're my number one choice for security here, even though it's just a summer job. So, I need to you to tell my if you've seen anything suspicious as of late.\n");
					if (!questions[1]) {
						displayTextMilitaryStyle(x,
								"2 Anything else to report?\n");
					}
					if (questions[2]) {
						displayTextMilitaryStyle(x,
								"3 How long have you been in here?\n");
					}
					displayTextMilitaryStyle(x, "4 Goodbye\n");
					int input = waitForProperInput(x, "1 2 3 4");
					if (input == 1) {
						displayTextMilitaryStyle(x,
								"\"Nothing on the cams, cap.\"\n");
						questions[0] = true;
					} else if (input == 2) {
						displayTextMilitaryStyle(x,
								"\"Uhhh…wait. Ugh, we lost camera five. We've been losing cameras all day sir.\"\n");
						questions[1] = true;
					} else if (input == 3) {
						displayTextMilitaryStyle(x, "\"For five nights sir, gotta keep watch, y'know.\"\n");
						questions[2] = true;
					} else {
						loop = false;
					}
				}}}}}	
