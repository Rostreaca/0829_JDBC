package com.kh.model.dto;

public class FootballClubDTO {

	
	private int playerNo;
	private int height;
	private int weight;
	
	public FootballClubDTO() {
		super();
	}

	public FootballClubDTO(int playerNo, int height, int weight) {
		super();
		this.playerNo = playerNo;
		this.height = height;
		this.weight = weight;
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "FootballClubDTO [playerNo=" + playerNo + ", height=" + height + ", weight=" + weight + "]";
	}
	
}
