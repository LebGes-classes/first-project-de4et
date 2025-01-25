public class GameState {
	MenuState menuState;
	LevelSelectingState levelSelectingState;
	PlayState playState;

	State currentState;

	public GameState() {
		this.levelSelectingState = new LevelSelectingState();
		this.playState = new PlayState(this.levelSelectingState.getCurrentLevel().getMap());
		this.menuState = new MenuState();
		this.currentState = this.menuState;
	}

	public String update() {
		String stateNext = this.currentState.update();
		switch (stateNext) {
			case "":
				break;
			case "play":
				this.playState.setMap(this.levelSelectingState.getCurrentLevel().getMap());
				this.currentState = this.playState;
				break;
			case "levelSelecting":
				this.currentState = this.levelSelectingState;
				break;
			case "exit":
				return "exit";
			case "menu":
				this.currentState = this.menuState;
				break;
		}
		return "";
	}

	public void draw() {
		this.currentState.render();
	}

	public void handleKey(char key) {
		this.currentState.handleKey(key);
	}
}
