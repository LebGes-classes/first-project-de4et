public interface State {
	String update();

	void render();

	void handleKey(char key);
}
