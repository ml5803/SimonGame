package whackAMole;

import java.util.ArrayList;

import gui.components.Action;
import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class WhackAMoleScreen extends ClickableScreen implements Runnable{
	
	 private ArrayList<MoleInterface> moles;
	 private PlayerInterface player;
	 private TextLabel label;
	 private TextLabel timeLabel;
	 private double timeLeft;


	public WhackAMoleScreen(int width, int height) {
		super(width, height);
		timeLeft=30.0;
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> list) {
		moles = new ArrayList<MoleInterface>();
		player = getAPlayer();
		label = new TextLabel(350,220,100,40,"Let's go!");
		timeLabel = new TextLabel(360,40,80,40,"30.0");
		viewObjects.add(timeLabel);
		viewObjects.add(label);
		viewObjects.add(player);
	}


	/**
	 *to implement later, after Character Team implements PlayerInterface
	 */
	public PlayerInterface getAPlayer() {
		return new Player();
	}

	/**
	 *to implement later, after EnemyTeam implements MoleInterface
	 */
	public MoleInterface getAMole() {
		return new Mole((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
	}

	@Override
	public void run() {
		changeText("Ready...");
		changeText("Set...");
		changeText("CLICK!");
		label.setText("");
		
		while(timeLeft > 0){
			updateTimer();
			updateAllMole();
			appearNewMole();
		}
	}

	private void appearNewMole() {
		double chance = .1*((60-timeLeft)/60);
		if(Math.random() < chance){
			//create a mole
			final MoleInterface mole = getAMole();
			mole.setAppearanceTime((int)(500+Math.random()*2000));
			//tell mole what to do when clicked.
			
			mole.setAction(new Action(){
				public void act() {
					player.increaseScore(1);
					remove(mole);
					moles.remove(mole);
				}
				
			});
			
			addObject(mole);
			moles.add(mole);
		}
	}

	private void updateAllMole() {
		for (int i =0; i < moles.size(); i++){
			MoleInterface m = moles.get(i);
			int screenTime = m.getAppearanceTime()-100;
			m.setAppearanceTime(screenTime);
			if(m.getAppearanceTime() <=0){
				remove(m);//remove from screen
				i--;
			}
		}
		
	}

	private void updateTimer() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		timeLeft-=.1;
		timeLabel.setText("" + (int)(timeLeft*10)/10.0);
	}

	private void changeText(String string) {
		label.setText(string);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
