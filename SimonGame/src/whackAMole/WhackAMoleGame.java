package whackAMole;

import gui.GUIApplication;

public class WhackAMoleGame extends GUIApplication{

	public WhackAMoleGame(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		WhackAMoleGame wamg = new WhackAMoleGame(800,500);
		Thread game = new Thread(wamg);
		game.start();
	}

	@Override
	public void initScreen() {
		WhackAMoleScreen wams = new WhackAMoleScreen(getWidth(),getHeight());
		setScreen(wams);
	}

}
