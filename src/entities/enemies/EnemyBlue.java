package entities.enemies;

import helpers.Position;
import main.Assets;

public class EnemyBlue extends Enemy {
	public EnemyBlue(Position cell) {
		super(cell);
	}

	public void assignImages() {
		super.assignImages();
		imgUp.add(Assets.enemyBlueUp);
		imgDown.add(Assets.enemyBlueDown);
		imgLeft.add(Assets.enemyBlueLeft);
		imgRight.add(Assets.enemyBlueRight);
		imgUp.add(Assets.enemyBlueUp2);
		imgDown.add(Assets.enemyBlueDown2);
		imgLeft.add(Assets.enemyBlueLeft2);
		imgRight.add(Assets.enemyBlueRight2);
	}
}