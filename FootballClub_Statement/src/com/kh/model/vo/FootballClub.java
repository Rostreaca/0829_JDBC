package com.kh.model.vo;

import java.sql.Date;
import java.util.Objects;

public class FootballClub {
	
	
	private int playerNo;
	private String playerName;
	private char gender;
	private String position;
	private int height;
	private int weight;
	private String dominantFoot;
	private int salary;
	private Date contractDate;
	private Date expiryDate;
	
	public FootballClub(int playerNo, String playerName, char gender, String position, int height, int weight,
			String dominantFoot, int salary, Date contractDate, Date expiryDate) {
		super();
		this.playerNo = playerNo;
		this.playerName = playerName;
		this.gender = gender;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.dominantFoot = dominantFoot;
		this.salary = salary;
		this.contractDate = contractDate;
		this.expiryDate = expiryDate;
	}

	public FootballClub() {
		super();
	}

	@Override
	public String toString() {
		return "FootballClub [playerNo=" + playerNo + ", playerName=" + playerName + ", gender=" + gender
				+ ", position=" + position + ", height=" + height + ", weight=" + weight + ", dominantFoot="
				+ dominantFoot + ", salary=" + salary + ", contractDate=" + contractDate + ", expiryDate=" + expiryDate
				+ "]";
	}

	public int getPlayerNo() {
		return playerNo;
	}

	public void setPlayerNo(int playerNo) {
		this.playerNo = playerNo;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

	public String getDominantFoot() {
		return dominantFoot;
	}

	public void setDominantFoot(String dominantFoot) {
		this.dominantFoot = dominantFoot;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractDate, dominantFoot, expiryDate, gender, height, playerName, playerNo, position,
				salary, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FootballClub other = (FootballClub) obj;
		return Objects.equals(contractDate, other.contractDate) && Objects.equals(dominantFoot, other.dominantFoot)
				&& Objects.equals(expiryDate, other.expiryDate) && gender == other.gender && height == other.height
				&& Objects.equals(playerName, other.playerName) && playerNo == other.playerNo
				&& Objects.equals(position, other.position) && salary == other.salary && weight == other.weight;
	}
	
	
	
	
}
