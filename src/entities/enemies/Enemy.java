package entities.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import entities.root.Moveable;
import helpers.*;
import main.*;

public class Enemy extends Moveable {

	ArrayList<BufferedImage> imgEdible = new ArrayList<BufferedImage>();

	float edibleDuration = 5f;
	float edibleTimer = 0;
	int value = 1200;

	public Enemy(Position cell) {
		super(cell);
		assignImages();
	}

	public void assignImages() {
		imgEdible.add(Assets.enemyEdible1);
		imgEdible.add(Assets.enemyEdible2);
	}

	public void updateCurrentImageArray() {
		super.updateCurrentImageArray();

		if (isEdible()) {
			setCurrentArray(imgEdible);
		}
	}

	public void handleMovement() {
		checkIfCanMove();

		while (!CanMove()) {
			direction = Direction.getRandomDirection();
			checkIfCanMove();
		}

		move();
	}

	public void render(Graphics g) {
		super.render(g);
		updateEdibleTimer();
	}

	public void updateEdibleTimer() {
		if (edibleTimer > 0) {
			edibleTimer -= 1.0 / GameSettings.FRAMERATE;
		}
	}

	public void activateEdible() {
		edibleTimer = edibleDuration;
	}

	public boolean isEdible() {
		return edibleTimer > 0;
	}

	public void getCollected() {
		isActive = false;
		ScoreManager.addScore(value);
	}

	public int getValue() {
		return value;
	}

	public void reset() {
		super.reset();
		edibleTimer = 0;
	}
}