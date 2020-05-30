package helpers;

import java.util.ArrayList;
import entities.*;
import entities.enemies.Enemy;
import entities.root.*;
import main.Game;

public class CollisionManager {
	ArrayList<Entity> entities;
	Game level;

	public CollisionManager(ArrayList<Entity> entities, Game level) {
		this.entities = entities;
		this.level = level;
	}

	public void checkCollisions() {
		checkPlayerEnemyCollision();
		checkPlayerCollectibleCollision();
	}

	private void checkPlayerEnemyCollision() {
		ArrayList<Enemy> enemies = getEnemies();
		Pacboi pacboi = getPacboi();
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).isActive && isCollidingMoveable(pacboi, enemies.get(i))) {
				handleCollision(enemies.get(i));
			}
		}
	}

	private void handleCollision(Enemy enemy) {
		if (enemy.isEdible()) {
			enemy.getCollected();
			FloatingText floatingText = level.createFloatingText(enemy.getValue() + "",
					new Position(enemy.getPosition().x, enemy.getPosition().y));
			floatingText.setColor(ColorManager.getAppropriateColor(enemy));
		} else {
			level.loseLife();
		}
	}

	private void checkPlayerCollectibleCollision() {
		ArrayList<Collectible> collectibles = getCollectibles();
		Pacboi pacboi = getPacboi();
		for (int i = 0; i < collectibles.size(); i++) {
			if (isCollidingStatic(pacboi, collectibles.get(i)) && collectibles.get(i).isActive) {
				handleCollision(collectibles.get(i));
			}
		}
	}

	private void handleCollision(Collectible collectible) {
		level.checkForNextLevel();
		if (collectible.getType() > 0) {
			createFloatingTextForCollectible(collectible);
		}
		level.createParticle(new Position(collectible.getCell().x, collectible.getCell().y));

		if (collectible.makesEnemiesEdible) {
			activateEdibleEnemies();
		}

		collectible.getCollected();
	}

	private void createFloatingTextForCollectible(Collectible collectible) {
		Position floatingTextPosition = new Position(collectible.getPosition().x + collectible.getSize() / 2,
				collectible.getPosition().y + collectible.getSize() / 2);
		FloatingText floatingText = level.createFloatingText(collectible.getCollectText(), floatingTextPosition);
		floatingText.setColor(ColorManager.getAppropriateColor(collectible));
	}

	private Pacboi getPacboi() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Pacboi)
				return (Pacboi) entities.get(i);
		}
		return null;
	}

	private ArrayList<Enemy> getEnemies() {
		ArrayList<Enemy> tempList = new ArrayList<Enemy>();

		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Enemy) {
				tempList.add((Enemy) entities.get(i));
			}
		}

		return tempList;
	}

	private ArrayList<Collectible> getCollectibles() {
		ArrayList<Collectible> tempList = new ArrayList<Collectible>();

		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Collectible)
				tempList.add((Collectible) entities.get(i));
		}

		return tempList;
	}

	private boolean isCollidingMoveable(Moveable entityA, Moveable entityB) {
		float radiusToCheck = (entityA.getSize() + entityB.getSize()) / 3f;
		double distance = entityA.getPositionModifier().distanceTo(entityB.getPositionModifier());
		return distance <= radiusToCheck;
	}

	private boolean isCollidingStatic(Entity entityA, Entity entityB) {
		float radiusToCheck = (entityA.getSize() + entityB.getSize()) / 3f;
		double distance = entityA.getPosition().distanceTo(entityB.getPosition());
		return distance <= radiusToCheck;
	}

	private void activateEdibleEnemies() {
		ArrayList<Enemy> enemies = getEnemies();
		for (int i = 0; i < enemies.size(); i++) {
			enemies.get(i).activateEdible();
		}
	}
}
