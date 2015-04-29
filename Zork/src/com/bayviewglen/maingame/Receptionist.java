package com.bayviewglen.maingame;

public class Receptionist extends NPC {

    public Receptionist(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    public void TalkTo(Display x, Boolean isTerrorist) {
        boolean[] questions = {
            false, false, false
        };
        boolean loop = true;
        displayTextMilitaryStyle(x, "Receptionist:\n\"Hello!\"\nWhat do you say?\n");
        if (isTerrorist) {
            while (loop) {
                if (!questions[0]) {
                    displayTextMilitaryStyle(x, "1 Are you a terrorest?\n");
                }
                if (!questions[1]) {
                    displayTextMilitaryStyle(x, "2 What are you planning to do in San Francisco?\n");
                }
                if (!questions[2]) {
                    displayTextMilitaryStyle(x, "3 How are the kids.\n");
                }
                displayTextMilitaryStyle(x, "4 Goodbye\n");
                int input = waitForProperInput(x, "1 2 3 4");
                if (input == 1) {
                    displayTextMilitaryStyle(x, "\"EXCUUUUUUUUUUUUUUUSE ME? I AM NO TRAITOR!\"\n");
                    questions[0] = true;
                } else if (input == 2) {
                    displayTextMilitaryStyle(x, "\"Allahu Akbar\"\n");
                    questions[1] = true;
                } else if (input == 3) {
                    displayTextMilitaryStyle(x, "\"I don't have, nor do I need kids.\"\n");
                    questions[2] = true;
                } else {
                    loop = false;
                }

            }
        } else {
            while (loop) {
                if (!questions[0]) {
                    displayTextMilitaryStyle(x, "1 Hey How are you?\n");
                    if (!questions[1]) {
                        displayTextMilitaryStyle(x, "2 What are you planning to do in San Fransisco?\n");
                    }
                    if (questions[2]) {
                        displayTextMilitaryStyle(x, "3 How are the kids.\n");
                    }
                    displayTextMilitaryStyle(x, "4 Goodbye\n");
                    int input = waitForProperInput(x, "1 2 3 4");
                    if (input == 1) {
                        displayTextMilitaryStyle(x, "\"Good thanks for asking\"\n");
                        questions[0] = true;
                    } else if (input == 2) {
                        displayTextMilitaryStyle(x, "\"Go see the golden gate bridge.\"\n");
                        questions[1] = true;
                    } else if (input == 3) {
                        displayTextMilitaryStyle(x, "\"They are good\"\n");
                        questions[2] = true;
                    } else {
                        loop = false;
                    }
                }
            }
        }


    }

}

