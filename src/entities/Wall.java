package entities;
import entities.root.Entity;
import helpers.Position;
import main.Assets;

public class Wall extends Entity {

	public Wall(Position position) {
		super(position);
		
		setImage(Assets.wall);
	}

	public void update() {}
}
