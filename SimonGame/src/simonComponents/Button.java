package simonComponents;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import gui.components.Action;
import gui.components.Component;
import gui.simon.ButtonInterfaceMichael;

public class Button extends Component implements ButtonInterfaceMichael {

	private Action action;
	private Color displayColor;
	private boolean highlight;
	private String name;
	
	public Button() {
		super(0,0,60,60);
	}

	public boolean isHovered(int x, int y) {
		return ((x>this.getX() && x<(this.getX()+this.getWidth())) && (y>this.getY() && y<(this.getY()+this.getHeight())));
	}
	
	public void setAction(Action action) {
		this.action = action;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	public String toString(){
		return name;
	}
	
	public void act() {
		action.act();
	}

	public void setColor(Color color) {
		displayColor = color;
		update();
	}

	public void highlight() {
		highlight = true;
		update();
	}

	public void dim() {
		highlight = false;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(highlight) 
		{
			g.setColor(this.displayColor);
		}else{
			g.setColor(Color.gray);
		}
		g.fillOval(0, 0, 60, 60);
		g.setColor(Color.black);
		g.drawOval(0, 0, 59, 59);
	}

}