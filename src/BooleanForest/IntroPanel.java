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
		initIntro(game);
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
		
<<<<<<< HEAD
		// Instantiate a BobsWindow with introduction text and instructions.
		introBobsWindow = new BobsWindow(game, BobsWindow.INTRO, INSTRUCTION_TEXT, BobsWindow.PLAY_GAME);
		add(introBobsWindow);
=======
//		// Instantiate a BobsWindow with introduction text and instructions.
//		introBobsWindow = new BobsWindow(game, BobsWindow.INTRO, INSTRUCTION_TEXT, BobsWindow.PLAY_GAME);
//		add(introBobsWindow);
>>>>>>> lesliekimm
		
//		// Repaint screen
//		repaint();										// repaint the JPanelrepaint();
	}
	
	/**
	 * paintComponenent()
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
		
<<<<<<< HEAD
		introBobsWindow.repaint();
=======
		paintBobsWindow(g);
>>>>>>> lesliekimm
	}	
	
	private void paintBobsWindow(Graphics g) {
		Image image = new ImageIcon("Images/IntroTextWindow.jpg").getImage();
		g.drawImage(image, introBobsWindow.getXCoord(), introBobsWindow.getYCoord(), null);
		Image bob = new ImageIcon("Images/Bob.png").getImage();
		g.drawImage(bob, introBobsWindow.getBob().getXCoord(), introBobsWindow.getBob().getYCoord(), null);
		String introText = introBobsWindow.getBobsMessage();
		
//		// http://stackoverflow.com/questions/4083322/how-can-i-create-a-jtextarea-with-a-specified-width-and-the-smallest-possible-hei/4083850#4083850
//		JTextArea textArea = new JTextArea();
//		textArea.setLineWrap(true);
//		textArea.setWrapStyleWord(true);
//		textArea.setText(introText);
//		textArea.setSize(BobsWindow.INTRO_WIDTH - 20, BobsWindow.INTRO_HEIGHT - 20);
//		textArea.setLocation(BobsWindow.INTRO_XCOORD + 10, BobsWindow.INTRO_YCOORD + 10);
//		
	}
}