package gui.simon;

import java.awt.Color;
import java.util.ArrayList;

import gui.components.TextLabel;
import gui.components.Visible;
import gui.screens.ClickableScreen;

public class SimonScreenMichael extends ClickableScreen implements Runnable {

	private TextLabel text;
	private ButtonInterfaceMichael[] btnList;
	private ProgressInterfaceMichael progress;
	private ArrayList<MoveInterfaceMichael> moveList;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenMichael(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(ArrayList<Visible> list) {
		addButtons();
		progress = getProgress();
		text = new TextLabel(130,230,300,40,"Let's play Simon!");
		moveList = new ArrayList<MoveInterfaceMichael>();
		//add 2 moves to start
		lastSelectedButton = -1;
		moveList.add(randomMove());
		moveList.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);

	}

	private MoveInterfaceMichael randomMove() {
		ButtonInterfaceMichael b;
		int rand = -1;
		while (rand == lastSelectedButton || rand == -1){
			rand = (int) (Math.random() * btnList.length);
		}
		b = btnList[rand];
		
		return getMove(b);
	}

	
	/**
	Placeholder until partner finishes implementation of MoveInterface
	*/
	private MoveInterfaceMichael getMove(ButtonInterfaceMichael b) {
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	private ProgressInterfaceMichael getProgress() {
		return null;
	}

	private void addButtons() {
		int numberOfButtons = 6;
		Color[] buttonColors = {Color.blue, Color.red, Color.yellow, Color.orange, Color.green, Color.pink};
		int[] xCoors = {350,365,435,450,435,365};
		int[] yCoors = {300,335,335,300,265,265};
		for(int i = 0; i < numberOfButtons; i++){
			ButtonInterfaceMichael b;
			b = getAButton();
			b.setColor(buttonColors[i]);
			b.setX(xCoors[i]);
			b.setY(yCoors[i]);
		}
	}

}
