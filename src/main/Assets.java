package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets {

	public static BufferedImage wall, pacboiUp1, pacboiUp2, pacboiDown1, pacboiDown2, pacboiLeft1, pacboiLeft2,
			pacboiRight1, pacboiRight2, enemyRedUp, enemyRedDown, enemyRedLeft, enemyRedRight, enemyBlueUp,
			enemyBlueDown, enemyBlueLeft, enemyBlueRight, enemyPinkUp, enemyPinkDown, enemyPinkLeft, enemyPinkRight,
			enemyYellowUp, enemyYellowDown, enemyYellowLeft, enemyYellowRight, enemyRedUp2, enemyRedDown2,
			enemyRedLeft2, enemyRedRight2, enemyBlueUp2, enemyBlueDown2, enemyBlueLeft2, enemyBlueRight2, enemyPinkUp2,
			enemyPinkDown2, enemyPinkLeft2, enemyPinkRight2, enemyYellowUp2, enemyYellowDown2, enemyYellowLeft2,
			enemyYellowRight2, enemyEdible1, enemyEdible2, effect;

	public static BufferedImage[] collectibleImages = new BufferedImage[3];
	public static String assetPath = "assets\\";

	public Assets() {
		try {
			loadImages();
			loadFont();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadImages() throws IOException {
		wall = ImageIO.read(new File(assetPath, "wall.png"));
		
		pacboiUp1 = ImageIO.read(new File(assetPath, "Pacman\\up1.png"));
		pacboiUp2 = ImageIO.read(new File(assetPath, "Pacman\\up2.png"));
		pacboiDown1 = ImageIO.read(new File(assetPath, "Pacman\\down1.png"));
		pacboiDown2 = ImageIO.read(new File(assetPath, "Pacman\\down2.png"));
		pacboiRight1 = ImageIO.read(new File(assetPath, "Pacman\\right1.png"));
		pacboiRight2 = ImageIO.read(new File(assetPath, "Pacman\\right2.png"));
		pacboiLeft1 = ImageIO.read(new File(assetPath, "Pacman\\left1.png"));
		pacboiLeft2 = ImageIO.read(new File(assetPath, "Pacman\\left2.png"));

		enemyRedUp = ImageIO.read(new File(assetPath, "\\Enemies\\redUp.png"));
		enemyRedDown = ImageIO.read(new File(assetPath, "\\Enemies\\redDown.png"));
		enemyRedLeft = ImageIO.read(new File(assetPath, "\\Enemies\\redLeft.png"));
		enemyRedRight = ImageIO.read(new File(assetPath, "\\Enemies\\redRight.png"));
		
		enemyRedUp2 = ImageIO.read(new File(assetPath, "\\Enemies\\redUp2.png"));
		enemyRedDown2 = ImageIO.read(new File(assetPath, "\\Enemies\\redDown2.png"));
		enemyRedLeft2 = ImageIO.read(new File(assetPath, "\\Enemies\\redLeft2.png"));
		enemyRedRight2 = ImageIO.read(new File(assetPath, "\\Enemies\\redRight2.png"));

		enemyBlueUp = ImageIO.read(new File(assetPath, "\\Enemies\\blueUp.png"));
		enemyBlueDown = ImageIO.read(new File(assetPath, "\\Enemies\\blueDown.png"));
		enemyBlueLeft = ImageIO.read(new File(assetPath, "\\Enemies\\blueLeft.png"));
		enemyBlueRight = ImageIO.read(new File(assetPath, "\\Enemies\\blueRight.png"));
		
		enemyBlueUp2 = ImageIO.read(new File(assetPath, "\\Enemies\\blueUp2.png"));
		enemyBlueDown2 = ImageIO.read(new File(assetPath, "\\Enemies\\blueDown2.png"));
		enemyBlueLeft2 = ImageIO.read(new File(assetPath, "\\Enemies\\blueLeft2.png"));
		enemyBlueRight2 = ImageIO.read(new File(assetPath, "\\Enemies\\blueRight2.png"));

		enemyPinkUp = ImageIO.read(new File(assetPath, "\\Enemies\\pinkUp.png"));
		enemyPinkDown = ImageIO.read(new File(assetPath, "\\Enemies\\pinkDown.png"));
		enemyPinkLeft = ImageIO.read(new File(assetPath, "\\Enemies\\pinkLeft.png"));
		enemyPinkRight = ImageIO.read(new File(assetPath, "\\Enemies\\pinkRight.png"));
		
		enemyPinkUp2 = ImageIO.read(new File(assetPath, "\\Enemies\\pinkUp2.png"));
		enemyPinkDown2 = ImageIO.read(new File(assetPath, "\\Enemies\\pinkDown2.png"));
		enemyPinkLeft2 = ImageIO.read(new File(assetPath, "\\Enemies\\pinkLeft2.png"));
		enemyPinkRight2 = ImageIO.read(new File(assetPath, "\\Enemies\\pinkRight2.png"));

		enemyYellowUp = ImageIO.read(new File(assetPath, "\\Enemies\\yellowUp.png"));
		enemyYellowDown = ImageIO.read(new File(assetPath, "\\Enemies\\yellowDown.png"));
		enemyYellowLeft = ImageIO.read(new File(assetPath, "\\Enemies\\yellowLeft.png"));
		enemyYellowRight = ImageIO.read(new File(assetPath, "\\Enemies\\yellowRight.png"));

		enemyYellowUp2 = ImageIO.read(new File(assetPath, "\\Enemies\\yellowUp2.png"));
		enemyYellowDown2 = ImageIO.read(new File(assetPath, "\\Enemies\\yellowDown2.png"));
		enemyYellowLeft2 = ImageIO.read(new File(assetPath, "\\Enemies\\yellowLeft2.png"));
		enemyYellowRight2 = ImageIO.read(new File(assetPath, "\\Enemies\\yellowRight2.png"));

		enemyEdible1 = ImageIO.read(new File(assetPath, "\\Enemies\\enemyEdible1.png"));
		enemyEdible2 = ImageIO.read(new File(assetPath, "\\Enemies\\enemyEdible2.png"));

		collectibleImages[0] = ImageIO.read(new File(assetPath, "collectible1.png"));
		collectibleImages[1] = ImageIO.read(new File(assetPath, "collectible2.png"));
		collectibleImages[2] = ImageIO.read(new File(assetPath, "collectible3.png"));
		
		effect = ImageIO.read(new File(assetPath, "effect.png"));
	}

	private void loadFont() throws FontFormatException, IOException {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(assetPath, "Emulogic.ttf")));
	}
}
