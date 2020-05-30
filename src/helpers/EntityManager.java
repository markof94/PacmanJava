package helpers;

import java.awt.Graphics;
import entities.*;
import entities.enemies.*;
import entities.root.Entity;
import main.*;

public class EntityManager {
	Game game;
	
	public EntityManager(Game game) {
		this.game = game;
	}
	
	public void generateLevel() {
		clearEntities();
		spawnWallsAndCollectibles();
		spawnPlayerAndEnemies();
	}

	private void spawnWallsAndCollectibles() {
		int map[][] = GameSettings.LEVELS[Game.currentLevel].getMap();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				int elementID = map[i][j];
				Position position = new Position(j, i);

				if (elementID == GameSettings.ELEMENT_WALL) {
					game.walls.add(new Wall(position));
				}

				if (elementID > GameSettings.ELEMENT_WALL) {
					game.entities.add(new Collectible(position, elementID - 2));
				}
			}
		}
	}

	private void clearEntities() {
		game.floatingTexts.clear();
		game.entities.clear();
		game.walls.clear();
		game.particles.clear();
	}

	public void spawnPlayerAndEnemies() {
		game.pacboi = new Pacboi(new Position(7, 5));
		game.entities.add(game.pacboi);
		spawnEnemies();
		game.collisionManager = new CollisionManager(game.entities, game);
	}

	public void spawnEnemies() {
		game.entities.add(new EnemyRed(new Position(1, 1)));
		game.entities.add(new EnemyBlue(new Position(1, 13)));
		game.entities.add(new EnemyPink(new Position(13, 1)));
		game.entities.add(new EnemyYellow(new Position(13, 13)));
	}
	
	public void softReset() {
		game.pacboi.reset();
		resetEnemies();
	}
	
	public void resetEnemies() {
		for (Entity entity : game.entities) {
			if (entity instanceof Enemy)
				entity.reset();
		}
	}
	
	public int getCollectibleCount() {
		int collectibleCount = 0;

		for (int i = 0; i < game.entities.size(); i++) {
			if (game.entities.get(i) instanceof Collectible && game.entities.get(i).isActive) {
				collectibleCount++;
			}
		}

		return collectibleCount;
	}
	
	public void updateEntities() {
		if (game.isGameOver)
			return;

		for (Entity entity : game.entities) {
			entity.update();
		}
	}

	public void renderEntities(Graphics g) {
		for (Entity entity : game.entities) {
			entity.render(g);
		}
	}

	public void renderWalls(Graphics g) {
		for (Wall wall : game.walls) {
			wall.render(g);
		}
	}

	public void updateAndRenderFloatingTexts(Graphics g) {
		for (FloatingText floatingText : game.floatingTexts) {
			floatingText.update();
			floatingText.render(g);
		}

		cleanupFloatingTexts();
	}

	private void cleanupFloatingTexts() {
		for (int i = game.floatingTexts.size() - 1; i >= 0; i--) {
			if (game.floatingTexts.get(i).shouldBeRemoved)
				game.floatingTexts.remove(i);
		}
	}

	public void updateAndRenderParticles(Graphics g) {
		for (ParticleEffect particle : game.particles) {
			particle.update();
			particle.render(g);
		}

		cleanupParticles();
	}

	private void cleanupParticles() {
		for (int i = game.particles.size() - 1; i >= 0; i--) {
			if (game.particles.get(i).shouldBeRemoved)
				game.particles.remove(i);
		}
	}
}