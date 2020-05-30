package helpers;

import java.io.IOException;
import java.nio.file.*;

import main.Assets;

public class ScoreManager {
	public static int score = 0;
	public static int highscore = 0;
	public static int levelCount = 1;

	public static void addScore(int value) {
		score += value;
		checkForHighscore();
	}

	public static void checkForHighscore() {
		if (score > highscore) {
			highscore = score;
			saveHighscore();
		}
	}

	public static void saveHighscore() {
		try {
			Path path = Paths.get(Assets.assetPath + "highscore.dat");
			Files.write(path, (highscore + "").getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadHighscore() {
		try {
			Path path = Paths.get(Assets.assetPath + "highscore.dat");
			String value = Files.readString(path);
			parseHighscore(value);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void parseHighscore(String value) {
		try {
			highscore = Integer.parseInt(value);
		} catch (Exception e) {
			highscore = 0;
			System.out.println("Error loading highscore - not a number! Fallback to 0.");
		}
	}

	public static void resetScoreAndLevelCount() {
		score = 0;
		levelCount = 1;
	}
}
