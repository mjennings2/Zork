package com.bayviewglen.maingame;

public class GeneralDeslaurier extends NPC{

	public GeneralDeslaurier(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public void TalkTo(Display x, Boolean isTerrorist){
			boolean[] questions = {false, false, false};
			boolean loop = true;
			displayTextMilitaryStyle(x,"Receptionist:\n\"Hello!\"\nWhat do you say?\n");
			if(isTerrorist){
				while(loop){
					
						displayTextMilitaryStyle(x,"GET OUT\n");
					
					
				}
			}else{
					while(loop){
						if(!questions[0]){
							displayTextMilitaryStyle(x,"1 No Progress, what more do you have?\n");
							if(!questions[1]){
								displayTextMilitaryStyle(x, "2 I know who the Traitor is\n");
							}
							if(questions[2]){
								displayTextMilitaryStyle(x, "3 Hey how are the kids.\n");
							}
							displayTextMilitaryStyle(x, "4 Goodbye\n");
							int input = waitForProperInput(x, "1 2 3 4");
							if(input == 1){
								displayTextMilitaryStyle(x, "\"Nothing, this is your assignment!\"\n");
								questions[0] = true;
							}else if(input == 2){
								displayTextMilitaryStyle(x, "\"THEN KILL HIM\"\n");
								questions[1] = true;
							}else if(input == 3){
								displayTextMilitaryStyle(x, "\"Good.\"\n");
								questions[2] = true;
							}else{
								loop = false;
							}
					}
				}
			}
			
			
		}
		
	}
	
	

