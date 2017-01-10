package gui.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Button extends TextLabel implements Clickable{

	private Color color;
	private Action action;
	
	public Button(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text);
		this.color = color;
		this.action = action;
		update();
	}
	public Color getColor(){
		return color;
	}
	
	public void setColor(Color c){
		color = c;
		update();
	}
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(color);
		g.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 25);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 35, 25);
		g.setFont(new Font(getFont(), Font.PLAIN,getSize()));
		if(getText()!=null){
			g.setColor(Color.white);
			g.drawString(getText(), 4, getHeight()-5);
		}
	}

	@Override
	public boolean isHovered(int x, int y) {
		if ((x>=this.getX() && x<= this.getX() + this.getWidth()) && (x>=this.getY() && x<= this.getY() + this.getHeight())){
			return true;
		}
		return false;
	}

	@Override
	public void act() {
		this.action.act();
	}
}
 