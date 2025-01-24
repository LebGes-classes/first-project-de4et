public class Screen {
	static final int DEFAULT_SCREEN_WIDTH = 100;
	static final int DEFAULT_SCREEN_HEIGHT = 50;

	private char[][] arr;

	private int width = DEFAULT_SCREEN_WIDTH;
	private int height = DEFAULT_SCREEN_HEIGHT;

	public Screen() {
		this.arr = new char[DEFAULT_SCREEN_HEIGHT][DEFAULT_SCREEN_WIDTH];
	}

	public void putChar(int x, int y, char c) {
		this.arr[y][x] = c;
	}

	public void render() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				System.out.print(this.arr[y][x]);
			}
			System.out.println();
		}
	}

	public void renderString(Point pos, String text) {
		for (int i = 0; i < text.length(); i++) {
			this.putChar(pos.x + i, pos.y, text.charAt(i));
		}
	}

	public void clear() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.arr[y][x] = ' ';
			}
		}
	}

	public int getHeight() {
		return this.height;
	}

}
