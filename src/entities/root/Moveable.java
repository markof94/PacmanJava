package entities.root;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import helpers.*;
import main.*;

public abstract class Moveable extends Entity {
	public ArrayList<BufferedImage> imgUp = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> imgDown = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> imgLeft = new ArrayList<BufferedImage>();
	public ArrayList<BufferedImage> imgRight = new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> currentArray = imgUp;
	int currentImageIndex = 0;

	public Direction direction = Direction.RIGHT;

	float animationInterval = 0.1f;
	float animationTimer = animationInterval;

	boolean canMove = true;
	double tickProgress = 0;

	Position positionModifier = new Position(0, 0);

	public Moveable(Position cell) {
		super(cell);
	}

	public void update() {
		super.update();
		tickProgress = 0;
		handleMovement();
	}

	public void render(Graphics g) {
		if (isActive) {
			handleAnimation();
			handleMovementInterpolation();
			updateCurrentImageArray();

			g.drawImage(getImage(), positionModifier.x, positionModifier.y, size, size, null);
		}
	}

	public void handleAnimation() {
		animationTimer -= 1.0 / GameSettings.FRAMERATE;

		if (animationTimer <= 0) {
			advanceImage();
			animationTimer = animationInterval;
		}
	}

	public void advanceImage() {
		currentImageIndex++;
		if (currentImageIndex > getCurrentArray().size() - 1) {
			currentImageIndex = 0;
		}
		setImage(getCurrentArray().get(currentImageIndex));
	}

	public void updateCurrentImageArray() {
		switch (direction) {
		case RIGHT: {
			setCurrentArray(imgRight);
			break;
		}
		case UP: {
			setCurrentArray(imgUp);
			break;
		}
		case DOWN: {
			setCurrentArray(imgDown);
			break;
		}
		case LEFT: {
			setCurrentArray(imgLeft);
			break;
		}
		default:
			break;
		}
	}

	public void handleMovementInterpolation() {
		position.x = cell.x * size;
		position.y = cell.y * size;

		if (CanMove()) {
			tickProgress += 1.0 / GameSettings.FRAMERATE / GameSettings.TICK_INTERVAL * 1000;
		} else {
			tickProgress = 1;
		}

		if (tickProgress > 1)
			tickProgress = 1;

		Position nextCell = getNextCell(direction);
		int pendingX = nextCell.x * size;
		int pendingY = nextCell.y * size;

		int incrementX = pendingX - position.x;
		int incrementY = pendingY - position.y;

		positionModifier.x = (int) (incrementX * tickProgress + (position.x - incrementX));
		positionModifier.y = (int) (incrementY * tickProgress + (position.y - incrementY));
	}

	// To be overridden
	public void handleMovement() {
	}

	public void checkIfCanMove() {
		canMove = IsNextCellFree(direction);
	}

	public void move() {
		switch (direction) {
		case RIGHT: {
			cell.x++;
			break;
		}
		case UP: {
			cell.y--;
			break;
		}
		case DOWN: {
			cell.y++;
			break;
		}
		case LEFT: {
			cell.x--;
			break;
		}
		default:
			break;
		}
	}

	public boolean IsNextCellFree(Direction direction) {
		Position nextCell = getNextCell(direction);
		Level currentLevel = GameSettings.LEVELS[Game.currentLevel];
		int gridElementToCheck = currentLevel.getMap()[nextCell.y][nextCell.x];
		return gridElementToCheck != 1;
	}

	public Position getNextCell(Direction direction) {
		Position nextCell = new Position(cell.x, cell.y);
		switch (direction) {
		case RIGHT: {
			nextCell.x++;
			break;
		}
		case UP: {
			nextCell.y--;
			break;
		}
		case DOWN: {
			nextCell.y++;
			break;
		}
		case LEFT: {
			nextCell.x--;
			break;
		}
		default:
			break;
		}

		return nextCell;
	}

	public Position getPositionModifier() {
		return positionModifier;
	}

	public boolean CanMove() {
		return canMove;
	}

	public double getTickProgress() {
		return tickProgress;
	}

	public ArrayList<BufferedImage> getCurrentArray() {
		return currentArray;
	}

	public void setCurrentArray(ArrayList<BufferedImage> currentArray) {
		this.currentArray = currentArray;
	}
}
