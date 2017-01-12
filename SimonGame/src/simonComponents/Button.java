package simonComponents;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import gui.simon.ButtonInterfaceMichael;

public class Button extends Component implements ButtonInterfaceMichael {

	public Button(int x, int y, int w, int h) {
		super(x,y,w,h);
	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub

	}

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAnimated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setX(int xCoors) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setY(int yCoors) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAction(Action action) {
		// TODO Auto-generated method stub

	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public ButtonInterfaceMichael getButton() {
		return null;
	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

}
