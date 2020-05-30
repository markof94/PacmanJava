package entities;

import entities.root.Entity;
import helpers.Position;
import helpers.ScoreManager;
import main.Assets;

public class Collectible extends Entity {
	int type;
	int value = 0;
	
	public boolean makesEnemiesEdible = false;

	public Collectible(Position cell, int type) {
		super(cell);
		this.type = type;
		setImage(Assets.collectibleImages[type]);
		assignValue();
	}

	private void assignValue() {
		switch (type) {
		case 0: {
			value = 10;
			break;
		}
		case 1: {
			value = 400;
			break;
		}
		case 2: {
			value = 800;
			makesEnemiesEdible = true;
			break;
		}
		}
	}

	public void getCollected() {
		isActive = false;

		ScoreManager.addScore(value);
	}

	public int getValue() {
		return value;
	}
	
	public String getCollectText() {
		if(type < 2) {
			return value + "";
		}else {
			return "POWER";
		}
	}

	public int getType() {
		return type;
	}
}