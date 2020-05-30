package entities;

import java.awt.Graphics;
import entities.root.Entity;
import helpers.Position;
import main.*;

public class ParticleEffect extends Entity {

	float duration = 0.1f;
	float timer = duration;

	public boolean shouldBeRemoved = false;

	public ParticleEffect(Position cell) {
		super(cell);

		setImage(Assets.effect);
	}

	public void render(Graphics g) {
		super.render(g);

		checkForRemove();
	}

	public void checkForRemove() {
		if (timer <= 0) {
			shouldBeRemoved = true;
		}else {
			timer -= 1.0 / GameSettings.FRAMERATE;
		}
	}
}