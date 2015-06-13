package com.bayviewglen.maingame;

public class General extends NPC {

	public General(String name) {
		super(name);

	}

	public void TalkTo(Display x, Boolean isTerrorist) {             // Method for talking to this character
		displayTextMilitaryStyle(x, "DON'T TALK TO ME, YA WASTE, DO YOUR ASSIGNMENT!");
	}
}
