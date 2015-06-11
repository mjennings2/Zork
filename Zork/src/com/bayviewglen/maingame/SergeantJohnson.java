package com.bayviewglen.maingame;

public class SergeantJohnson extends NPC {

 public SergeantJohnson(String name) {
  super(name);

 }

 public void TalkTo(Display x, Boolean isTerrorist) {
  boolean[] questions = { false, false, false };
  boolean loop = true;
  displayTextMilitaryStyle(x,
    "*You see feet from under the shower stall*\n");
  if (isTerrorist) {
   while (loop) {
    if (!questions[0]) {
     displayTextMilitaryStyle(x, "1 Who's in there?\n");
    }
    if (!questions[1]) {
     displayTextMilitaryStyle(x,
       "2 You'd better get out, we are almost to San Fran!\n");
    }
    if (!questions[2]) {
     displayTextMilitaryStyle(x,
       "3 Why is there a trail of blood leading to the shower?\n");
    }
    displayTextMilitaryStyle(x, "4 Goodbye\n");
    int input = waitForProperInput(x, "1 2 3 4");
    if (input == 1) {
     displayTextMilitaryStyle(x,
       "\"Sergeant Johnson, sir!\"\n");
     questions[0] = true;
    } else if (input == 2) {
     displayTextMilitaryStyle(x, "\"No can do! I have to get clean.\"\n");
     questions[1] = true;
    } else if (input == 3) {
     displayTextMilitaryStyle(x,
       "\"Just ignore that...\"\n");
     questions[2] = true;
    } else {
     loop = false;
    }

   }
  } else {
   while (loop) {
    if (!questions[0]) {
     displayTextMilitaryStyle(x, "1 Who's in there?\n");
    }
    if (!questions[1]) {
      displayTextMilitaryStyle(x,
        "2 You'd better get out, we are almost to San Fran!\n");
     }
     if (!questions[2]) {
      displayTextMilitaryStyle(x,
        "3 Why is there a trail of blood leading to the shower?\n");
     }
     displayTextMilitaryStyle(x, "4 Goodbye\n");
     int input = waitForProperInput(x, "1 2 3 4");
     if (input == 1) {
      displayTextMilitaryStyle(x,
        "\"Sergeant Johnson, sir!\"\n");
      questions[0] = true;
     } else if (input == 2) {
      displayTextMilitaryStyle(x,
        "\"Yes sir. Right away sir!\"\n");
      questions[1] = true;
     } else if (input == 3) {
      displayTextMilitaryStyle(x, "\"I am prone to nosebleeds, sir!\"\n");
      questions[2] = true;
     } else {
      loop = false;
    
    }
   }
  }
 }
}