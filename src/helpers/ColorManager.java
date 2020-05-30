package helpers;

import java.awt.Color;
import entities.Collectible;
import entities.enemies.Enemy;

public class ColorManager {
	public static Color gameOverColor = new Color(255, 0, 0, 255);
	public static Color gameOverOverlayColor = new Color(0, 0, 0, 150);
	public static Color defaultColor = new Color(255, 255, 255, 255);
	public static Color collectibleTier2Color = new Color(51, 255, 255, 255);
	public static Color collectibleTier3Color = new Color(255, 0, 0, 255);

	public static Color getAppropriateColor(Collectible collectible) {
		if (collectible.getType() == 1) {
			return collectibleTier2Color;
		}
		if (collectible.getType() == 2) {
			return collectibleTier3Color;
		}

		return defaultColor;
	}

	public static Color getAppropriateColor(Enemy enemy) {
		return collectibleTier3Color;
	}
}
