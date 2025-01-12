public class Player {
	private Point pos;

	public Player(Point pos) {
		this.pos = pos;
	}

	public void render() {
		Game.screen.putChar(pos.x, pos.y, '@');
	}

	public void setPos(Point pos) {
		this.pos = pos;
	}

	public Point getPosition() {
		return pos;
	}

	public void move(int x, int y) {
		pos.x += x;
		pos.y += y;
	}
}
