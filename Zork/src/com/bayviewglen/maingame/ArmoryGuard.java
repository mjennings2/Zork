package com.bayviewglen.maingame;

public class ArmoryGuard extends NPC{

	public ArmoryGuard(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

    public void TalkTo(Display x, Boolean isTerrorist) {
        boolean[] questions = {
            false, false, false
        };
        boolean loop = true;
        displayTextMilitaryStyle(x, "Armory Guard: Hello, Captain! /n");
        if (isTerrorist) {
            while (loop) {
                if (!questions[0]) {
                    displayTextMilitaryStyle(x, "1 Anything to report?\n");
                }
                if (!questions[1]) {
                    displayTextMilitaryStyle(x, "2 Your shoes are untied, soldier!\n");
                }
                if (!questions[2]) {
                    displayTextMilitaryStyle(x, "3 Do you have any extra weapons I could use?\n");
                }
                displayTextMilitaryStyle(x, "4 Goodbye\n");
                int input = waitForProperInput(x, "1 2 3 4");
                if (input == 1) {
                    displayTextMilitaryStyle(x, "\"Nothing here, Captain.\"\n");
                    questions[0] = true;
                } else if (input == 2) {
                    displayTextMilitaryStyle(x, "\"We're buddies, eh? No need for all the formality, bro. *bends down to tie shoes*\"\n");
                    questions[1] = true;
                } else if (input == 3) {
                    displayTextMilitaryStyle(x, "\"You're packing a pretty mean .45 there, cap! I don't think you need anything heavier, haha.\"\n");
                    questions[2] = true;
                } else {
                    loop = false;
                }

            }
        } else {
            while (loop) {
                if (!questions[0]) {
                    displayTextMilitaryStyle(x, "1 Anything to report?\n");
                }
                if (!questions[1]) {
                        displayTextMilitaryStyle(x, "2 Your shoes are untied, soldier!\n");
                    }
                    if (!questions[2]) {
                        displayTextMilitaryStyle(x, "3 Do you have any extra weapons for me?\n");
                    }
                    displayTextMilitaryStyle(x, "4 Goodbye\n");
                    int input = waitForProperInput(x, "1 2 3 4");
                    if (input == 1) {
                        displayTextMilitaryStyle(x, "\"Sir! All clear, sir!\"\n");
                        questions[0] = true;
                    } else if (input == 2) {
                        displayTextMilitaryStyle(x, "\"My apologies, sir! *bends down to tie shoes*\"\n");
                        questions[1] = true;
                    } else if (input == 3) {
                        displayTextMilitaryStyle(x, "\"I'm under orders to not give anyone weapons until further notice, sir! DesLauriers' orders! \"\n");
                        questions[2] = true;
                    } else {
                        loop = false;
					}
				}
			}
		
	}}
