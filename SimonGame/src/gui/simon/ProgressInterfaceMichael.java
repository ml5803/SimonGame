package gui.simon;

import gui.components.Visible;

public interface ProgressInterfaceMichael extends Visible {
	void gameOver();

	void setRoundInt(int roundNumber);

	void setSequenceSize(int size);

	ButtonInterfaceMichael get(int sequenceIndex);
}
