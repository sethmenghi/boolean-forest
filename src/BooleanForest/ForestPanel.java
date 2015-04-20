package BooleanForest;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;


public class ForestPanel extends JPanel {
	
	private Game theGame;
	
	public ForestPanel(Game game) {
		initForest(game);
	}
	
	private void initForest(Game game) {
		setPreferredSize(new Dimension(640,480));
		setDoubleBuffered(true);
		this.theGame = game;
		JLabel label = new JLabel("Hello!");
		add(label);
	}
	
}
