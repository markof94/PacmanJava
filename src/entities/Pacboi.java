package entities;

import java.awt.Graphics;
import entities.root.Moveable;
import helpers.*;
import main.Assets;

public class Pacboi extends Moveable {
	Direction pendingDirection;

	public Pacboi(Position position) {
		super(position);
		
		imgUp.add(Assets.pacboiUp1);
		imgUp.add(Assets.pacboiUp2);
		imgDown.add(Assets.pacboiDown1);
		imgDown.add(Assets.pacboiDown2);
		imgLeft.add(Assets.pacboiLeft1);
		imgLeft.add(Assets.pacboiLeft2);
		imgRight.add(Assets.pacboiRight1);
		imgRight.add(Assets.pacboiRight2);

		direction = Direction.NONE;
		pendingDirection = direction;
	}

	public void handleMovement() {
		checkIfCanMove();
		if (CanMove()) {
			move();
		}
	}

	public void setPendingDirection(Direction newDirection) {
		pendingDirection = newDirection;
	}

	public void render(Graphics g) {
		super.render(g);

		if (getTickProgress() >= 1 && IsNextCellFree(pendingDirection)) {
			direction = pendingDirection;
		}
	}
}
