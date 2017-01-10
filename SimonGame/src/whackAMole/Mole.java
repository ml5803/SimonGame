package whackAMole;

import gui.components.ClickableGraphics;

public class Mole extends ClickableGraphics implements MoleInterface {

	private int appearanceTime;
	public Mole(int x, int y) {
		super(x, y,.9, "resources/sampleImages/pen.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAppearanceTime() {
		return appearanceTime;
	}

	@Override
	public void setAppearanceTime(int screenTime) {
		appearanceTime = screenTime;

	}

}
