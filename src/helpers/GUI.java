package helpers;

import java.awt.*;
import java.awt.image.BufferedImage;
import entities.FloatingText;
import main.*;

public class GUI {
	Font font;
	int fontSize = 24;
	Game level;

	public GUI(Game level) {
		this.level = level;
		font = new Font("Emulogic", Font.PLAIN, fontSize);
	}

	public void drawGUI(Graphics g) {
		drawScore(g);
		drawHighscore(g);
		drawLevelCount(g);
		drawLives(g);

		if (level.isGameOver) {
			drawDarkerScreen(g);
		}
	}

	public void drawScore(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int x = GameSettings.BASE_SIZE;
		int y = 32;

		g2d.setColor(ColorManager.defaultColor);
		g2d.setFont(font);
		g2d.drawString(ScoreManager.score + "", x, y);
	}

	public void drawHighscore(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int x = GameSettings.BASE_SIZE * 4;
		int y = GameSettings.MAP_SIZE - 12;

		g2d.setColor(ColorManager.defaultColor);
		g2d.setFont(font);
		g2d.drawString("HIGH SCORE " + ScoreManager.highscore, x, y);
	}

	public void drawLevelCount(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		int x = GameSettings.MAP_SIZE - fontSize * 12;
		int y = 32;

		g2d.setColor(ColorManager.defaultColor);
		g2d.setFont(font);
		g2d.drawString("LEVEL " + ScoreManager.levelCount, x, y);
	}

	public void drawLives(Graphics g) {
		BufferedImage imgLife = Assets.pacboiRight1;

		for (int i = 0; i < level.currentLives; i++) {
			int size = (int) (GameSettings.BASE_SIZE * 0.75f);
			int x = (int) (size * 1.2f * i) + GameSettings.BASE_SIZE;
			int y = (int) (GameSettings.MAP_SIZE - size * 1.2f);
			g.drawImage(imgLife, x, y, size, size, null);
		}
	}

	private void drawDarkerScreen(Graphics g) {
		g.setColor(ColorManager.gameOverOverlayColor);
		g.fillRect(0, 0, GameSettings.MAP_SIZE, GameSettings.MAP_SIZE);
	}

	public void createGameOverScreen() {
		createGameOverText();
		createContinueText();
		createExitText();
	}

	private void createGameOverText() {
		int x = GameSettings.MAP_SIZE / 2;
		int y = GameSettings.MAP_SIZE / 2;
		Position floatingTextPosition = new Position(x, y);
		FloatingText floatingText = level.createFloatingText("GAME OVER", floatingTextPosition);
		floatingText.setSize(32);
		floatingText.isInfinite = true;
		floatingText.setColor(ColorManager.gameOverColor);
	}

	private void createContinueText() {
		int x = GameSettings.MAP_SIZE / 2;
		int y = GameSettings.MAP_SIZE / 2 + GameSettings.BASE_SIZE;
		Position floatingTextPosition = new Position(x, y);
		FloatingText floatingText = level.createFloatingText("Enter -> Restart", floatingTextPosition);
		floatingText.setSize(16);
		floatingText.isInfinite = true;
		floatingText.setColor(ColorManager.defaultColor);
	}

	private void createExitText() {
		int x = GameSettings.MAP_SIZE / 2;
		int y = GameSettings.MAP_SIZE / 2 + GameSettings.BASE_SIZE * 2;
		Position floatingTextPosition = new Position(x, y);
		FloatingText floatingText = level.createFloatingText("Escape -> Exit", floatingTextPosition);
		floatingText.setSize(16);
		floatingText.isInfinite = true;
		floatingText.setColor(ColorManager.defaultColor);
	}
}
