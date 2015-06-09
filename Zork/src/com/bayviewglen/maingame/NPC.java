package com.bayviewglen.maingame;

public class NPC {

	public String name;
	
	public NPC() {
		
	}

	
	public NPC(String name) {
		this.name = name;
	}

	
	
	protected static int waitForProperInput(Display x, String str) {
		// TODO Auto-generated method stub
		boolean loop = false;
		while(!loop){
		while(x.textSent.equals("")){
			 try {                                                                                                                                                                                                             
	                Thread.sleep(1000); //3000 milliseconds is three seconds.                                                                                                                                                   
	            } catch (InterruptedException ex) {                                                                                                                                                                            
	                Thread.currentThread().interrupt();                                                                                                                                                                        
	            }   
		}
		String[] commandWords = x.textSent.split(" ");
		String[] possibleInputs = str.split(" ");
	//	Command typed = new Command(commandWords[0], commandWords[1]);
		// TODO Check if command is valid
		for(int i = 0; i < possibleInputs.length; i++){
			if(commandWords[0].equalsIgnoreCase(possibleInputs[i])){
				loop = true;
				x.textSent = ("");
				return i+1;
				
			}
		}
		// TODO Outcome if valid
		}
		x.textSent = ("");
		return 0;
	}
	
	protected static void TalkTo(Display x, boolean isTerrorist){
		
		
	}
	
	protected static void displayTextMilitaryStyle(Display x, String str) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < str.length(); i++){
			if(str.substring(i, i+1).equals("\n")){
				x.display(str.substring(i, i+1));
				sleep(300);
			}else{
				x.display(str.substring(i, i+1));
				sleep(25);
			}
		}
	}

	
	protected static void sleep(int time){
		 try {                                                                                                                                                                                                          
            Thread.sleep(time); //3000 milliseconds is three seconds.                                                                                                                                                   
        } catch (InterruptedException ex) {                                                                                                                                                                            
            Thread.currentThread().interrupt();                                                                                                                                                                        
        }   
	}
	
}
