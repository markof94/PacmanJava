package entities.root;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import helpers.Position;
import main.GameSettings;

public abstract class Entity implements Drawable {
	Position position;
	Position cell;
	int size = GameSettings.BASE_SIZE;
	private BufferedImage image;
	public boolean isActive = true;
	Position startingCell;
	
	public Entity(Position cell){
		this.cell = cell;	
		position = new Position(cell.x * GameSettings.BASE_SIZE, cell.y * GameSettings.BASE_SIZE);
		startingCell = new Position(cell.x, cell.y);
	}
	
	public void update() {
		position.x = cell.x * size;
		position.y = cell.y * size;
	}
	
	public void render(Graphics g) {
		if(image != null && isActive) {
			g.drawImage(image, position.x, position.y, size, size, null);
		}
	}
	
	public void reset() {
		isActive = true;
		cell = new Position(startingCell.x, startingCell.y);
	}

	public Position getCell() {
		return cell;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Position getPosition() {
		return position;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
