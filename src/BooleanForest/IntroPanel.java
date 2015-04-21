package BooleanForest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {
	
	private static final String INSTRUCTION_TEXT = "Welcome to the Forest of Boolean Logic! My name is Bob. What is your name?";
	private static final String text = "d";
	
	Game theGame;
	
	public IntroPanel(Game game) {
		initIntro(game);
	}
	
	private void initIntro(Game game) {
		theGame = game;
		
		setPreferredSize(new Dimension(640,480));
		setDoubleBuffered(true);
		
		BobsWindow introInstructions = new BobsWindow(INSTRUCTION_TEXT);
		add(introInstructions);
		
		GameButton startButton = new GameButton();
		add(startButton);
		
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("Images/IntroScreen.jpg").getImage();
		g.drawImage(image, 0, 0, null);
	}
	
}
