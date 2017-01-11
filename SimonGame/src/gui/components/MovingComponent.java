package gui.components;

import java.awt.Color;
import java.awt.Graphics2D;

public class MovingComponent extends Component implements Runnable {

	private long moveTime; 
	private double vx;
	private double vy;
	private double posx;
	private double posy;
	private boolean running;
	
	public static final int REFRESH_RATE = 20;
	
	public MovingComponent(int x, int y, int w, int h) {
		super(x, y, w, h);
		vx=0;
		vy=0;
	}
	
	public boolean isAnimated(){
		return true;
	}

	@Override
	public void run() {
		posx = getX();
		posy = getY();
		running = true;
		moveTime = System.currentTimeMillis();
		while(running){
			try {
				Thread.sleep(REFRESH_RATE);
				checkBehaviors();
				update();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void checkBehaviors() {
		if(getY()>300){
			setY(300);
			setVy(-vy);
		}
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}
	
	public void setX(int x) {
		super.setX(x);// now the actual position is synced with the pixel (screen) position
		posx=x;
	}

	public void setY(int y) {
		super.setY(y); // now the actual position is synced with the pixel (screen) position
		posy = y;
	}

	public boolean isRunning(){
		return running;
	}
	
	public void setRunning(boolean bool){
		this.running = bool;
	}
	@Override
	public void update(Graphics2D g) {
		long currentTime = System.currentTimeMillis();
		int difference = (int) (currentTime-moveTime);
		if(difference >= REFRESH_RATE){
			//update movetime since a move is happening
			moveTime = currentTime;
			//calcute the new position
			posx += vx * (double)difference/REFRESH_RATE;
			posy += vy * (double)difference/REFRESH_RATE;
			//note for a low velocity, the position might no change by very much, 
			//so rounding down to an int might make it look like nothing changed,
			//but posx and posy will keep track of fractions of a change
			super.setX((int)posx);
			super.setX((int)posy);
		}
		drawImage(g);
	}

	private void drawImage(Graphics2D g) {
		g.setColor(Color.black);
		g.fillOval(0, 0, getWidth(), getHeight());
	}

	public void play(){
		if(!running){
			Thread go = new Thread(this);
			go.start();
		}
	}
}
