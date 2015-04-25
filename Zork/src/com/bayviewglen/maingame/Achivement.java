package com.bayviewglen.maingame;

public class Achivement {

	private boolean[] myAchivements;
	
	public Achivement(boolean[] achivements) {
		super();
		myAchivements = achivements;
		
	}

	public boolean[] getMyAchivements() {
		return myAchivements;
	}

	public void setMyAchivements(boolean[] myAchivements) {
		this.myAchivements = myAchivements;
	}

	public String achivementAsString(int index){
		if(myAchivements[index])
			return "true";
		else
			return "false";
	}
	
	
	
}
