package com.bayviewglen.maingame;

public class Item {

	private String name;
	private String[] lables;

	public Item(String name, String[] lables) {
		super();
		this.name = name;
		this.lables = lables;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String[] getLables() {
		return lables;
	}

	public void setLables(String[] lables) {
		this.lables = lables;
	}
	
	
}
