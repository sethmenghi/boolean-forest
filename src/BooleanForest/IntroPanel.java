package BooleanForest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {
	
	private static final String INSTRUCTION_TEXT = "Welcome to the Forest of Boolean Logic! My name is Bob. Let's go on an adventure!";
	
	Game theGame;
	
	/**
	 * IntroPanel()
	 * 
	 * Constructor, calls initIntro()
	 * 
	 * @param game
	 */
	public IntroPanel(Game game) {
		initIntro(game);
	}
	
	/**
	 * initIntro()
	 * 
	 * Initializes intro screen, with the game, an instruction Bob's window, calls repaint
	 * 
	 * @param game
	 */
	private void initIntro(Game game) {
		// Set private game to the current game
		theGame = game;
		
		// Set default settings
		setPreferredSize(new Dimension(640,480));
		setDoubleBuffered(true);
		
		// Create and add instruction Bob's window
		BobsWindow introInstructions = new BobsWindow(INSTRUCTION_TEXT);
		add(introInstructions);
		
		// Repaint screen
		repaint();
	}
	
	/**
	 * paintComponenent()
	 * 
	 * Overrides paintComponenent(); draws background image
	 * 
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		// Call super
		super.paintComponent(g);
		
		// Create new image icon, draw the image
		Image image = new ImageIcon("Images/IntroScreen.jpg").getImage();
		g.drawImage(image, 0, 0, null);
	}
	
}
