package simonComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import gui.components.Component;
import gui.simon.ProgressInterfaceMichael;

public class Progress extends Component implements ProgressInterfaceMichael {

	private boolean gameOver;
	private String round;
	private String sequence;

	public Progress() {
		super(60,60,300,100);
	}

	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	public void setSequenceLength(int size) {
		sequence = "Sequence length "+size;
		update();
	}

	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g = clear();
		g.setFont(new Font("Papyrus",Font.PLAIN,20));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(gameOver){
			g.setColor(Color.red);
			g.fillRect(0, 0, 200, 100);
			g.setColor(Color.black);
			g.drawRect(0, 0, 199, 99);
			g.drawString("Game Over!!",5,35);
			g.drawString(""+round,5,55);
			g.drawString(""+sequence,5,75);

		}else{
			g.setColor(Color.green);
			g.fillRect(0, 0, 200, 100);
			g.setColor(Color.black);
			g.drawRect(0, 0, 199, 99);
			g.drawString(""+round,5,35);
			g.drawString(""+sequence,5,55);
		}
		
	}

}