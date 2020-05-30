package main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;
import entities.*;
import entities.root.Entity;
import helpers.*;

public class Game extends JPanel {
	private static final long serialVersionUID = 1L;

	public Pacboi pacboi;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	public ArrayList<Wall> walls = new ArrayList<Wall>();
	public ArrayList<FloatingText> floatingTexts = new ArrayList<FloatingText>();
	public ArrayList<ParticleEffect> particles = new ArrayList<ParticleEffect>();

	public CollisionManager collisionManager;

	Timer timerTick, timerFrames;
	Controls controls;
	ScoreManager scoreManager;
	EntityManager entityManager;
	GUI gui;

	public static int currentLevel = 0;
	public int currentLives = GameSettings.STARTING_LIVES;

	public boolean isGameOver = false;

	float timeElapsed = 0;

	public Game() {
		setBackground(new Color(4, 6, 15, 60));
		createTimers();
		scoreManager = new ScoreManager();
		gui = new GUI(this);
		ScoreManager.loadHighscore();
		addKeyListener(new Controls(this));
		entityManager = new EntityManager(this);
		entityManager.generateLevel();
	}

	public void createTimers() {
		createTickLoop();
		createFrameRateLoop();
	}

	public void createTickLoop() {
		timerTick = new Timer();
		timerTick.schedule(new TimerTask() {
			public void run() {
				tickLoop();
			}
		}, (long) 0.5f, GameSettings.TICK_INTERVAL);
	}

	private void tickLoop() {
		if (timeElapsed > 1)
			entityManager.updateEntities();
	}

	public void createFrameRateLoop() {
		timerFrames = new Timer();
		timerFrames.schedule(new TimerTask() {
			public void run() {
				mainLoop();
			}
		}, (long) 0.5f, 1000 / GameSettings.FRAMERATE);
	}

	private void mainLoop() {
		timeElapsed += 1.0 / GameSettings.FRAMERATE;
		if (timeElapsed > 1) {
			collisionManager.checkCollisions();
		}
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		entityManager.renderEntities(g);
		entityManager.renderWalls(g);
		gui.drawGUI(g);
		entityManager.updateAndRenderFloatingTexts(g);
		entityManager.updateAndRenderParticles(g);
	}

	public void checkForNextLevel() {
		if (entityManager.getCollectibleCount() <= 1)
			goToNextLevel();
	}

	private void goToNextLevel() {
		timeElapsed = 0;
		ScoreManager.levelCount++;
		advanceCurrentLevel();
		entityManager.generateLevel();
	}

	private void advanceCurrentLevel() {
		currentLevel++;
		if (currentLevel > GameSettings.LEVELS.length - 1)
			currentLevel = 0;
	}

	public FloatingText createFloatingText(String text, Position position) {
		FloatingText floatingText = new FloatingText(text, position);
		floatingTexts.add(floatingText);
		return floatingText;
	}

	public ParticleEffect createParticle(Position cell) {
		ParticleEffect particle = new ParticleEffect(cell);
		particles.add(particle);
		return particle;
	}

	public void loseLife() {
		if (isGameOver)
			return;

		currentLives--;

		if (currentLives > 0) {
			softReset();
		} else {
			endGame();
		}
	}

	public void softReset() {
		entityManager.softReset();
		timeElapsed = 0;
	}

	public void endGame() {
		isGameOver = true;
		gui.createGameOverScreen();
		pacboi.isActive = false;
	}

	public void restartGame() {
		softReset();
		currentLevel = 0;
		ScoreManager.resetScoreAndLevelCount();
		isGameOver = false;
		currentLives = GameSettings.STARTING_LIVES;
		entityManager.generateLevel();
	}
}
