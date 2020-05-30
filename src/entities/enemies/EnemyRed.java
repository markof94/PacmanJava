package entities.enemies;

import helpers.Position;
import main.Assets;

public class EnemyRed extends Enemy {
	public EnemyRed(Position cell) {
		super(cell);
	}

	public void assignImages() {
		super.assignImages();
		imgUp.add(Assets.enemyRedUp);
		imgDown.add(Assets.enemyRedDown);
		imgLeft.add(Assets.enemyRedLeft);
		imgRight.add(Assets.enemyRedRight);
		imgUp.add(Assets.enemyRedUp2);
		imgDown.add(Assets.enemyRedDown2);
		imgLeft.add(Assets.enemyRedLeft2);
		imgRight.add(Assets.enemyRedRight2);
	}
}