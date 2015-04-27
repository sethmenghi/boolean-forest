/**
 * QUESTIONPANEL CLASS
 * 
 * DESCRIPTION:
 * The QuestionPanel class extends JPanel and is the layout that displays the
 * question layout, which is just a background gradient.
 *    
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 */

package Panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import BooleanForest.Game;

@SuppressWarnings("serial")
public class QuestionPanel extends JPanel implements Panel {
	// Declare static final members of IntroPanel class:
	private static final String BACKGROUND_SRC = "Images/Backgrounds/EmptyGradientBackground.jpg";
	
	// Declare members of QuestionPanel class:
	@SuppressWarnings("unused")
	private Game theGame;											// reference to main Game
	
	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public QuestionPanel(Game game){
		initPanel(game);											// call initPanel()
	}

	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions of QuestionPanel
	 * class. Creates a reference to the Game object passed in.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		this.theGame = game;										// create reference to game passed in
		
		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
	}
	
	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image.
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon(BACKGROUND_SRC).getImage();
		g.drawImage(image, 0, 0, null);
	}	

	@Override
	public void addText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addParagraphText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addButtons() {
		// TODO Auto-generated method stub
	}
}
