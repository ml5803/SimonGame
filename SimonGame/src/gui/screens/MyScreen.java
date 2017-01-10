package gui.screens;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import gui.Screen;
import gui.components.Action;
import gui.components.Button;
import gui.components.ClickableGraphics;
import gui.components.Graphic;
import gui.components.TextArea;
import gui.components.Visible;
import gui.sampleGames.MouseFollower;

public class MyScreen extends Screen implements MouseMotionListener, MouseListener {
	private TextArea msg;
	private int hitCount;
	private Color backgroundColor;
	private ClickableGraphics img;
	private Button background;
	
	public MyScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initObjects(ArrayList<Visible> viewObjects) {
		msg= new TextArea(200,100,200,200,"I'm a ninja. I come to kill you.");
		viewObjects.add(msg);
		
		img = new ClickableGraphics(300,300, "resources/sampleImages/ninja.png");
		viewObjects.add(img);
	}

	public int randGen(int lower, int upper){
		return (int) (Math.random() * upper + lower);
		
	}
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	public MouseListener getMouseListener(){
		return this;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(img.isHovered(e.getX(), e.getY())){
			img.act();
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
