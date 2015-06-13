package com.bayviewglen.maingame;

public class SergeantMajorSmith extends NPC {

 public SergeantMajorSmith(String name) {
  super(name);

 }

 public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
  boolean[] questions = { false, false, false };
  boolean loop = true;
  displayTextMilitaryStyle(x,
    "*Smith is sitting on a chair in the Barracks*\n");
  if (isTerrorist) {                                       // Find out if the current character is a traitor in this generation of the map
   while (loop) {
    if (!questions[0]) {
     displayTextMilitaryStyle(x, "1 When is your next shift?\n");
    }
    if (!questions[1]) {
     displayTextMilitaryStyle(x, "2 Is anyone missing?\n");
    }
    if (!questions[2]) {
     displayTextMilitaryStyle(x, "3 Seen anything suspicious?\n");
    }
    displayTextMilitaryStyle(x, "4 Goodbye\n");
    int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
    if (input == 1) {
     displayTextMilitaryStyle(x,
       "\"Whenever we get to San Fran!\"\n");
     questions[0] = true;
    } else if (input == 2) {
     displayTextMilitaryStyle(x, "\"Nope.\"\n");
     questions[1] = true;
    } else if (input == 3) {
     displayTextMilitaryStyle(x,
       "\"Suspicious? On this train? Pft. Yeah right.\"\n");
     questions[2] = true;
    } else {
     loop = false;
    }

   }
  } else {
   while (loop) {
    if (!questions[0]) {
     displayTextMilitaryStyle(x, "1 When is your next shift?\n");
    }
    if (!questions[1]) {
      displayTextMilitaryStyle(x, "2 Is anyone missing?\n");
     }
     if (!questions[2]) {
      displayTextMilitaryStyle(x,
        "3 Seen anything suspicious?\n");
     }
     displayTextMilitaryStyle(x, "4 Goodbye\n");
     int input = waitForProperInput(x, "1 2 3 4");                  // Wait for real input to text area
     if (input == 1) {
      displayTextMilitaryStyle(x,
        "\"At 1300.\"\n");
      questions[0] = true;
     } else if (input == 2) {
      displayTextMilitaryStyle(x,
        "\"Yeah, the Sergeant hasn't been around.\"\n");
      questions[1] = true;
     } else if (input == 3) {
      displayTextMilitaryStyle(x, "\"No Sir!\"\n");
      questions[2] = true;
     } else {
      loop = false;
     }
    
   }
  }
 }
}