
public class PlayState implements State {
	private Map map;
	private Player player;

	private boolean quit = false;

	public PlayState(Map map) {
		this.map = map;

		this.player = new Player(this.map.getStartPoint());

	}

	public String update() {
		if (player.getPosition().equals(map.getEndPoint())) {
			System.out.println("Ты победил!");
			Game.sleep(2);
			return "menu";
		}

		if (this.quit) {
			this.quit = false;
			return "menu";
		}

		return "";
	}

	public void render() {
		this.map.render();
		this.player.render();
	}

	public void setMap(Map map) {
		this.map = map;
		this.player.setPos(map.getStartPoint());
	}

	public void handleKey(char key) {
		switch (key) {
			case 'w':
				if (this.map.moveCheck(this.player.getPosition(), 0, -1)) {
					this.player.move(0, -1);
				}
				break;
			case 'a':
				if (this.map.moveCheck(this.player.getPosition(), -1, 0)) {
					this.player.move(-1, 0);
				}
				break;
			case 's':
				if (this.map.moveCheck(this.player.getPosition(), 0, 1)) {
					this.player.move(0, 1);
				}
				break;
			case 'd':
				if (this.map.moveCheck(this.player.getPosition(), 1, 0)) {
					this.player.move(1, 0);
				}
				break;
			case 'q':
				this.quit = true;
				break;
		}
	}
}
