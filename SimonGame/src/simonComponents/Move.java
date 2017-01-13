package simonComponents;

import gui.simon.ButtonInterfaceMichael;
import gui.simon.MoveInterfaceMichael;

public class Move implements MoveInterfaceMichael {

	private ButtonInterfaceMichael b; 
	
	public Move(ButtonInterfaceMichael b) {
		this.b = b;
	}

	public ButtonInterfaceMichael getButton() {
		return b;
	}

}
