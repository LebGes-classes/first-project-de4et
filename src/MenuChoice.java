public class MenuChoice {
	String str;
	String value;
	boolean isChosen;
	int pos;

	public MenuChoice(String str, String value) {
		this.str = str;
		this.isChosen = false;
		this.value = value;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public void render() {
		String finalString = pos + ". " + this.str;

		if (this.isChosen) {
			finalString += " *";
		}
		Game.screen.renderString(new Point(0, this.pos), finalString);
	}

}
