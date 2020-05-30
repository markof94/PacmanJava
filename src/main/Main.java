package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		new Window();
	}
}

class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	Game game;

	public Window() {
		new Assets();
		createGameWindow();
		new GameSettings();
		createAndPrepareLevel();
	}
	
	private void createGameWindow() {
		setTitle("Pacboi");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(GameSettings.MAP_SIZE + 16, GameSettings.MAP_SIZE + 39);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createAndPrepareLevel() {
		game = new Game();
		game.setFocusable(true);
		game.requestFocusInWindow();
		game.repaint();
		add(game);
	}
}
