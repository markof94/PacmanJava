package entities;

import java.awt.*;
import entities.root.Drawable;
import helpers.ColorManager;
import helpers.Position;
import main.GameSettings;

public class FloatingText implements Drawable {
	String text;
	Font font;
	Color color;
	int fontSize = 16;
	
	Position position;
	float velocityY = -1;
	
	float duration = 0.5f;
	float timer = duration;

	public boolean shouldBeRemoved = false;
	public boolean isInfinite = false;

	public FloatingText(String text, Position position) {
		this.text = text;
		this.position = position;
		font = new Font("Emulogic", Font.PLAIN, fontSize);
		color = ColorManager.defaultColor;
	}

	public void update() {
		if (isInfinite)
			return;

		timer -= 1.0 / GameSettings.FRAMERATE;

		if (timer <= 0) {
			shouldBeRemoved = true;
		}
	}

	public void render(Graphics g) {
		handleMovement();
		drawText(g);
	}
	
	private void handleMovement() {
		if(!isInfinite) {
			position.y += velocityY;
		}
	}

	private void drawText(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setColor(color);
		g2d.setFont(font);
		
		FontMetrics fm = g2d.getFontMetrics();
        int x = position.x - fm.stringWidth(text) / 2;
        int y = position.y - fm.getHeight() / 2 + fm.getAscent();

		g2d.drawString(text, x, y);	
	}
	
	public void setSize(int size) {
		fontSize = size;
		font = new Font("Emulogic", Font.PLAIN, fontSize);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}