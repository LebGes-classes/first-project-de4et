public class Map {
	private int width;
	private int height;

	private Point startPoint;
	private Point endPoint;

	private int[][] arr; // 0 - space, 1 - wall

	public Map(int width, int height) {
		this.width = width;
		this.height = height;

		this.arr = new int[height][width];

		this.startPoint = new Point(0, 1);
		this.endPoint = new Point(width - 1, height - 2);
	}

	public static Map emptyMap(int width, int height) {
		Map map = new Map(width, height);
		map.putHorizontalLine(new Point(0, 0), new Point(width - 1, 0), 1);
		map.putHorizontalLine(new Point(0, height - 1), new Point(width - 1, height - 1), 1);
		map.putVerticalLine(new Point(0, 0), new Point(0, height - 1), 1);
		map.putVerticalLine(new Point(width - 1, 0), new Point(width - 1, height - 1), 1);
		return map;
	}

	public static Map generateMap(int width, int height) {
		Map map = new Map(width, height);
		MazeGenerator mazeGenerator = new MazeGenerator(height, width);
		int[][] maze = mazeGenerator.generateMaze();
		map.setArr(maze);
		return map;
	}

	public void render() {
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				switch (this.arr[y][x]) {
					case 0:
						Game.screen.putChar(x, y, ' ');
						break;
					case 1:
						Game.screen.putChar(x, y, '#');
						break;
					case 2:
						Game.screen.putChar(x, y, '@');
						break;
				}
			}
		}
	}

	public boolean moveCheck(Point curPos, int x, int y) {
		if (curPos.x + x < 0 || curPos.x + x > width - 1 || curPos.y + y < 0 || curPos.y + y > height - 1) {
			return false;
		}

		return arr[curPos.y + y][curPos.x + x] != 1;
	}

	public int[][] getArray() {
		return this.arr;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public Point getStartPoint() {
		return this.startPoint;
	}

	public Point getEndPoint() {
		return this.endPoint;
	}

	private void putHorizontalLine(Point start, Point end, int type) {
		if (start.y != end.y) {
			System.out.println("Wrong");
		}

		for (int x = start.x; x <= end.x; x++) {
			this.arr[start.y][x] = type;
		}
	}

	private void putVerticalLine(Point start, Point end, int type) {
		if (start.x != end.x) {
			System.out.println("Wrong");
		}

		for (int y = start.y; y <= end.y; y++) {
			this.arr[y][start.x] = type;
		}
	}

	private void setArr(int[][] newArr) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				this.arr[i][j] = newArr[i][j];
			}
		}
	}
}
