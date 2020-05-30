package entities.enemies;

import helpers.Position;
import main.Assets;

public class EnemyYellow extends Enemy {
	public EnemyYellow(Position cell) {
		super(cell);
	}

	public void assignImages() {
		super.assignImages();
		imgUp.add(Assets.enemyYellowUp);
		imgDown.add(Assets.enemyYellowDown);
		imgLeft.add(Assets.enemyYellowLeft);
		imgRight.add(Assets.enemyYellowRight);
		imgUp.add(Assets.enemyYellowUp2);
		imgDown.add(Assets.enemyYellowDown2);
		imgLeft.add(Assets.enemyYellowLeft2);
		imgRight.add(Assets.enemyYellowRight2);
	}
}