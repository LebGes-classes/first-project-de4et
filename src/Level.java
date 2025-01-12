public class Level {
	static final int DEFAULT_LEVEL_WIDTH = 30;
	static final int DEFAULT_LEVEL_HEIGHT = 10;

	Map map;
	Player player;
	int width;
	int height;

	public Level(int number) {
		this.width = DEFAULT_LEVEL_WIDTH * number;
		this.height = (int) ((float) DEFAULT_LEVEL_HEIGHT * (1.0 + (float) number * 0.5));

		this.map = Map.generateMap(this.width, this.height);
	}

	public Map getMap() {
		return this.map;
	}
}
