package gui.screens;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.Graphic;
import gui.components.MovingComponent;
import gui.components.TextArea;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class CoordinateScreen extends Screen implements MouseMotionListener, MouseListener {

	private Button myButton;
	private TextLabel text;
	private TextArea area;
	private Graphic penguin;
	
	public CoordinateScreen(int width, int height) {
		super(width, height);

	}

	public void initObjects(ArrayList<Visible> viewObjects) {
		text = new TextLabel(10, 25, 500, 40, "Some text");
		viewObjects.add(text);
		area = new TextArea(400, 50, 300, 100, "This is really long text. It prints more than a single line. Looks good man :)");
		viewObjects.add(area);
		
		myButton = new Button(10,100,250,50,"Click to change screen",new Color(0,76,153), new Action(){
			public void act(){
				MouseFollower.game.setScreen(MouseFollower.screen);
			}
		});
		viewObjects.add(myButton);
		
		MovingComponent c = new MovingComponent(20,20,100,100);
		viewObjects.add(c);
		c.setVy(2);
		c.setVx(1);
		c.play();
		
		//penguin = new Graphic(30,30,"resources/sampleImages/penguin.jpg");
		//viewObjects.add(penguin);
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int mx = e.getX();
		int my = e.getY();
		text.setText("Mouse at : " + mx + " , " + my);
	}

	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(myButton.isHovered(e.getX(), e.getY())){
			myButton.act();
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
