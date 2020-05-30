package helpers;

import java.util.Random;

public enum Direction {
	UP, DOWN, RIGHT, LEFT, NONE;

	public static Direction getRandomDirection() {
		Random random = new Random();
		return values()[random.nextInt(values().length - 1)];
	}
}
