import java.util.Random;
import java.util.Scanner;

public class Game {
	static Random random;
	static GameState state;
	static Screen screen;

	public static void main(String[] args) {
		System.out.println("Starting game...");

		random = new Random();
		screen = new Screen();
		state = new GameState();

		System.out.println("Starting main loop");
		run();
	}

	public static void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			clearScreen();

			if (state.update() == "exit") {
				break;
			}

			state.draw();
			drawManual();
			screen.render();

			if (sc.hasNext()) {
				char key = sc.next().charAt(0);
				state.handleKey(key);
			}
		}
		sc.close();
	}

	public static void drawManual() {
		String[] description = new String[] {
				"Инструкция:",
				"В связи с тем что у Java нет \"получения символа в реальном времени\" ",
				"из-под коробки, то каждое нажатие нужно сопровождать Enter'ом\n",
				"Передвижение в меню:",
				"    w - наверх",
				"    s - вниз",
				"    e - выбрать\n",
				"Передвижение в лабиринте:",
				"    w - наверх",
				"    a - налево",
				"    s - вниз",
				"    d - направо",
				"    q - выйти в меню\n",
				"Для использования нужно развернуть консоль во весь экран\n",
				"------------------"
		};

		int lines = description.length;
		int height = screen.getHeight();

		int curPos = height - 1 - lines;
		for (int i = 0; i < lines; i++) {
			screen.renderString(new Point(0, curPos), description[i]);
			curPos++;
		}

	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception E) {
			System.out.println(E);
		}
	}

	public static void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
			System.out.println(E);
		}
		screen.clear();
	}
}
