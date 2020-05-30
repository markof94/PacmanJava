package helpers;

public class Position {
	public int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distanceTo(Position positionB) {
		double a = Math.pow(positionB.x - x, 2);
		double b = Math.pow(positionB.y - y, 2);
		return Math.sqrt(a + b);
	}
}
