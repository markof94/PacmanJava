package entities.enemies;

import helpers.Position;
import main.Assets;

public class EnemyPink extends Enemy {
	public EnemyPink(Position cell) {
		super(cell);
	}

	public void assignImages() {
		super.assignImages();
		imgUp.add(Assets.enemyPinkUp);
		imgDown.add(Assets.enemyPinkDown);
		imgLeft.add(Assets.enemyPinkLeft);
		imgRight.add(Assets.enemyPinkRight);
		imgUp.add(Assets.enemyPinkUp2);
		imgDown.add(Assets.enemyPinkDown2);
		imgLeft.add(Assets.enemyPinkLeft2);
		imgRight.add(Assets.enemyPinkRight2);
	}
}