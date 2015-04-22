/**
 * INTRO PANEL CLASS
 * 
 * DESCRIPTION:
 * The IntroPanel class extends JPanel and is the layout that displays the
 * introduction screen with brief introduction text and instructions. 
 *    
 * SOURCES:
 * 
 */

package BooleanForest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel {
	// Private static final members of IntroPanel class:
	private static final int PANEL_WIDTH = 640;			// width of panel
	private static final int PANEL_HEIGHT = 480;		// height of panel
	private static final String INSTRUCTION_TEXT = "Welcome to the Boolean "
			+ "Logic Forest! This is my family: Alice, my wife and our two "
			+ "children, David and Chloe. Our children need to get through "
			+ "the Boolean Logic Forest and need your help! Let's go on an "
			+ "adventure!";
	
	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates IntroPanel object
	private BobsWindow introBobsWindow;					// Bob's window for introduction instructions
	
	/**
	 * CONSTRUCTOR: The constructor calls initIntro() method.
	 * @param game
	 */
	public IntroPanel(Game game) {
		initIntro(game);								// call initIntro()
	}
	
	/**
	 * METHOD: Initializes JPanel dimensions and members of ForestPanel
	 * class. Creates a reference to the Game object passed in and calls 
	 * overridden paintComponent() method.
	 * @param game
	 */
	private void initIntro(Game game) {
		this.theGame = game;							// assign game to theGame to reference Game instance
		
		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setDoubleBuffered(true);
		
//		// Instantiate a BobsWindow with introduction text and instructions.
//		introBobsWindow = new BobsWindow(game, BobsWindow.INTRO, INSTRUCTION_TEXT, BobsWindow.PLAY_GAME);
//		add(introBobsWindow);
		
//		// Repaint screen
//		repaint();										// repaint the JPanelrepaint();
	}
	
	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image and BobsWindow with INSTRUCTION_TEXT.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);						// call super method
		
		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/IntroScreen.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		paintBobsWindow(g);
	}	
	
	private void paintBobsWindow(Graphics g) {
		Image image = new ImageIcon("Images/IntroTextWindow.png").getImage();
//		g.drawImage(image, introBobsWindow.getXCoord(), introBobsWindow.getYCoord(), null);
		Image bob = new ImageIcon("Images/Bob.png").getImage();
//		g.drawImage(bob, introBobsWindow.getBob().getXCoord(), introBobsWindow.getBob().getYCoord(), null);
	}
}