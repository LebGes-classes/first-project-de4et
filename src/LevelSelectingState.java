public class LevelSelectingState extends MenuState {
	private Level currentLevel;

	public LevelSelectingState() {
		this.currentLevel = new Level(1);

		MenuChoice[] choices = new MenuChoice[] {
				new MenuChoice("Уровень 1", "1"),
				new MenuChoice("Уровень 2", "2"),
				new MenuChoice("Уровень 3", "3")
		};

		setChoices(choices);
		this.choices[0].isChosen = true;
	}

	public Level getCurrentLevel() {
		return this.currentLevel;
	}

	public String update() {
		if (this.enteredChoice) {
			this.currentLevel = new Level(Integer.parseInt(this.choices[this.cursorPosition].value));

			this.enteredChoice = false;
			return "play";
		}

		return "";
	}
}
