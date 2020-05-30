package helpers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import main.Game;

public class Controls extends KeyAdapter {
	Game game;

	public Controls(Game level) {
		this.game = level;
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		handleDirectionInput(key);

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}

		if (key == KeyEvent.VK_ENTER && game.isGameOver) {
			game.restartGame();
		}
	}

	private void handleDirectionInput(int key) {
		boolean isLeftPressed = key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A;
		boolean isRightPressed = key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D;
		boolean isUpPressed = key == KeyEvent.VK_UP || key == KeyEvent.VK_W;
		boolean isDownPressed = key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S;

		if (isLeftPressed) {
			game.pacboi.setPendingDirection(Direction.LEFT);
		}
		if (isRightPressed) {
			game.pacboi.setPendingDirection(Direction.RIGHT);
		}
		if (isUpPressed) {
			game.pacboi.setPendingDirection(Direction.UP);
		}
		if (isDownPressed) {
			game.pacboi.setPendingDirection(Direction.DOWN);
		}
	}
}
