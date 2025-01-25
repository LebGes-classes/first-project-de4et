import java.util.Random;

public class MazeGenerator {
	private int height;
	private int width;
	private int[][] maze;
	private Random rand = new Random();

	public MazeGenerator(int height, int width) {
		this.height = height;
		this.width = width;
		this.maze = new int[height][width];
	}

	public int[][] generateMaze() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				maze[i][j] = 1;
			}
		}

		int startX = 1;
		int startY = 1;
		maze[startX][startY] = 0;

		carvePassage(startX, startY);

		maze[1][0] = 0;
		maze[height - 2][width - 1] = 0;

		return maze;
	}

	private void carvePassage(int x, int y) {
		int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		shuffleArray(directions);

		for (int[] dir : directions) {
			int nx = x + dir[0] * 2;
			int ny = y + dir[1] * 2;

			if (nx >= 0 && nx < height && ny >= 0 && ny < width && maze[nx][ny] == 1) {
				maze[nx][ny] = 0;
				maze[x + dir[0]][y + dir[1]] = 0;
				carvePassage(nx, ny);
			}
		}
	}

	private void shuffleArray(int[][] array) {
		for (int i = array.length - 1; i > 0; i--) {
			int index = rand.nextInt(i + 1);
			int[] temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
}