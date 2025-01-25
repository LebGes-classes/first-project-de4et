public class MenuState implements State {
	int cursorPosition = 0;
	MenuChoice[] choices;

	boolean enteredChoice = false;

	public MenuState() {
		MenuChoice[] choices = new MenuChoice[] {
				new MenuChoice("Выбрать уровень", "levelSelecting"),
				new MenuChoice("Выйти", "exit")
		};

		setChoices(choices);
		this.choices[0].isChosen = true;
	}

	protected void setChoices(MenuChoice[] choices) {
		this.choices = choices;
		for (int i = 0; i < choices.length; i++) {
			this.choices[i].setPos(i);
		}
	}

	public String update() {
		if (this.enteredChoice) {
			this.enteredChoice = false;
			return this.choices[this.cursorPosition].value;
		}
		return "";
	}

	public void render() {
		for (int i = 0; i < this.choices.length; i++) {
			this.choices[i].render();
		}
	}

	public void handleKey(char key) {
		switch (key) {
			case 'w':
				moveChosenUp();
				break;
			case 's':
				moveChosenDown();
				break;
			case 'e':
				enterChoice();
				break;
		}
	}

	private void enterChoice() {
		this.enteredChoice = true;
	}

	private void moveChosenUp() {
		if (this.cursorPosition == 0) {
			return;
		}
		this.choices[this.cursorPosition].isChosen = false;

		this.cursorPosition--;
		this.choices[this.cursorPosition].isChosen = true;
	}

	private void moveChosenDown() {
		if (this.cursorPosition + 1 == this.choices.length)
			return;
		this.choices[this.cursorPosition].isChosen = false;

		this.cursorPosition++;
		this.choices[this.cursorPosition].isChosen = true;
	}
}
