/**
 * FOREST PANEL CLASS
 * 
 * DESCRIPTION:
 * The ForestPanel class extends JPanel and is the layout that displays the
 * level map for where the student needs to get through. When levels are
 * passed, the level markers turn yellow and a star is added at the bottom
 * right of the screen. Collect five stars to win the game!
 *    
 * SOURCES:
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 */

package Panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import BooleanForest.Game;
import Objects.BobsWindow;
import Objects.GameButton;
import Objects.Owl;
import Objects.Star;

@SuppressWarnings("serial")
public class ForestPanel extends JPanel implements Panel, MouseListener {
	// Declare static final members of ForestPanel class:
	private static final String LEVEL_1 = "Go to Level 1";	// text for Level 1 GameButton
	private static final String LEVEL_2 = "Go to Level 2";	// text for Level 2 GameButton
	private static final String LEVEL_3 = "Go to Level 3";	// text for Level 3 GameButton
	private static final String LEVEL_4 = "Go to Level 4";	// text for Level 4 GameButton
	private static final String LEVEL_5 = "Go to Level 5";	// text for Level 5 GameButton
	private static final int MARKER_1_XCOORD = 24;			// x-coordinate for marker 1
	private static final int MARKER_2_XCOORD = 157;			// x-coordinate for marker 2
	private static final int MARKER_3_XCOORD = 307;			// x-coordinate for marker 3
	private static final int MARKER_4_XCOORD = 437;			// x-coordinate for marker 4
	private static final int MARKER_5_XCOORD = 587;			// x-coordinate for marker 5	
	private static final int MARKER_1_YCOORD = 366;			// y-coordinate for marker 1
	private static final int MARKER_2_YCOORD = 290;			// y-coordinate for marker 2
	private static final int MARKER_3_YCOORD = 254;			// y-coordinate for marker 3
	private static final int MARKER_4_YCOORD = 176;			// y-coordinate for marker 4
	private static final int MARKER_5_YCOORD = 144;			// y-coordinate for marker 5

	// Declare members of ForestPanel class:
	private Game theGame;								// reference to Game that instantiates ForestPanel object
	private int theLevel;								// the current level passed in theGame
	private BobsWindow forestBobsWindow;				// Bob's window for instructions/explanations
	private String bobsMessage;							// Bob's message
	private JTextArea bobsTextArea;						// text area for Bob's message
	private GameButton forestGameButton;				// button to continue to levels
	private Owl chloe;									// child Owl Chloe
	private Owl david;									// child Owl David
	private List<Star> stars;							// list of Stars
	public Boolean levelOnePassed = false;				// initialize level one passed to false
	public Boolean levelTwoPassed = false;				// initialize level two passed to false
	public Boolean levelThreePassed = false;			// initialize level three passed to false
	public Boolean levelFourPassed = false;				// initialize level four passed to false
	public Boolean levelFivePassed = false;				// initialize level five passed to false

	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public ForestPanel(Game game) {
		initPanel(game);											// calls initPanel()
	}

	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions and members of
	 * ForestPanel class. Creates a reference to the Game object passed in
	 * and initializes Bob's Window.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		this.theGame = game;										// create reference to game passed in
		this.theLevel = theGame.getLevel();							// get current level passed of theGame

		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		// Initialize children Owl objects.
		david = new Owl(65, 395, "DAVID");							// set the coordinates of David for level 1
		chloe = new Owl(80, 410, "CHLOE");							// set the coordinates of Chloe for level 1

		// Initialize Bob's message.
		bobsMessage = "Welcome! Help Chloe and David get through the Boolean Logic Forest. Get started by "
				+ "clicking the button below!";

		// Initialize a BobsWindow with instructions to play Level 1.
		forestBobsWindow = new BobsWindow("FOREST", bobsMessage);
		add(forestBobsWindow);

		// Initialize ArrayList of Star objects.
		stars = new ArrayList<Star>();								// no stars added because no levels passed yet
	}

	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image, children owls, Bob's Window, the level markers
	 * and stars earned.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image background = new ImageIcon("Images/Backgrounds/ForestBackground.jpg").getImage();
		g.drawImage(background, 0, 0, null);

		// Paint various components on the screen.
		paintOwl(g, david);											// paint David
		paintOwl(g, chloe);											// paint Chloe
		paintLevelMarkers(g, theLevel);								// paint yellow level markers for passed levels
		paintBobsWindow(g);											// paint Bob's Window and Bob
		paintStars(g);												// paint a star for each level passed
	}

	/**
	 * METHOD: Paints the Owl object passed in at it's x- and
	 * y-coordinates. Only applies to Chloe and David.
	 * @param g
	 * @param owl
	 */
	private void paintOwl(Graphics g, Owl owl) {
		Image owlImage;

		// Check to see if Owl is Chloe or David and draw the Owl.
		if (owl.getOwlName() == "CHLOE") {
			owlImage = new ImageIcon("Images/Owls/ChloeSmall.png").getImage();
			g.drawImage(owlImage, owl.getXCoord(), owl.getYCoord(), null);
		}
		else if (owl.getOwlName() == "DAVID") {
			owlImage = new ImageIcon("Images/Owls/DavidSmall.png").getImage();
			g.drawImage(owlImage, owl.getXCoord(), owl.getYCoord(), null);
		}
	}

	/**
	 * OVERRIDDEN METHOD: This  method paints Bob's Window white and Bob,
	 * as well as calls method to add the text and button.
	 * @param g
	 */
	@Override
	public void paintBobsWindow(Graphics g) {
		// Draw the white background for Bob's window.
		Image textBackground = new ImageIcon("Images/TextWindows/ForestTextWindow.png").getImage();
		g.drawImage(textBackground, forestBobsWindow.getXCoord(), forestBobsWindow.getYCoord(), null);

		// Draw Bob.
		Image bob = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bob, forestBobsWindow.getBob().getXCoord(), forestBobsWindow.getBob().getYCoord(), null);

		// Add text and button.
		addText();													// add text to Bob's Window
		addButtons();												// add button to Bob's Window
	}

	/**
	 * OVERRIDDEN METHOD: This method adds the paragraph text to Bob's
	 * Window.
	 * @param g
	 * NOTE: Source is listed at the beginning of the class file.
	 */
	@Override
	public void addText() {
		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea != null) {
			remove(bobsTextArea);									// remove from TeacherPanel
		}

		addParagraphText();											// add paragraph
	}

	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub
	}

	/**
	 * OVERRIDDEN METHOD: This method creates a JTextArea for the text
	 * that fits inside the white box of Bob's Window. A custom font and
	 * color are used for the text and the background is transparent. The
	 * text is wrapped and words will always appear in full on a line.
	 */
	@Override
	public void addParagraphText() {
		// Create a JTextArea to fit inside Bob's Window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		String forestText = forestBobsWindow.getBobsMessage();		// get the message from forestBobsWindow
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		Font font = new Font("Verdana", Font.BOLD, 14);				// create custom font
		bobsTextArea.setFont(font);									// set the font
		bobsTextArea.setForeground(new Color(12, 68, 159));			// set font color
		bobsTextArea.setLineWrap(true);								// set line wrap to true
		bobsTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		bobsTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea.setSize(BobsWindow.FOREST_WIDTH - 20, BobsWindow.FOREST_HEIGHT - 20);
		bobsTextArea.setLocation(BobsWindow.FOREST_XCOORD + 10, BobsWindow.FOREST_YCOORD + 10);
		bobsTextArea.setText(forestText);							// set the text
		add(bobsTextArea);											// add to ForestPanel
	}

	/**
	 * METHOD: This method adds the forestGameButton and adds
	 * MouseListener to button.
	 * @param none
	 */
	@Override
	public void addButtons() {
		addForestButton();
	}

	private void addForestButton() {
		// Initialize a GameButton to go on to Level 1.
		forestGameButton = new GameButton(LEVEL_1, "WHITE");

		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = BobsWindow.FOREST_XCOORD + BobsWindow.FOREST_WIDTH / 2 -
				forestGameButton.getPreferredSize().width / 2;
		int boundsYCoord = BobsWindow.FOREST_YCOORD + BobsWindow.FOREST_HEIGHT -
				forestGameButton.getPreferredSize().height - 20;
		int boundsWidth = forestGameButton.getPreferredSize().width;
		int boundsHeight = forestGameButton.getPreferredSize().height;
		forestGameButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

		add(forestGameButton);										// add to ForestPanel
		forestGameButton.addMouseListener(this);					// add MouseListener
	}

	/**
	 * METHOD: Paints yellow markers to indicate a passed level.
	 * @param g
	 * @param int
	 */
	private void paintLevelMarkers(Graphics g, int level) {		
		theLevel = 3;		// for diagnostics

		// Depending on the level of the game, draw the appropriate
		// number of yellow level markers (yellow indicates passed level).
		// Only case 1 will break. This way, for each level, it will
		// continue to draw the level markers for all previous passed
		// levels.
		Image yellowButton = new ImageIcon("Images/ButtonYellow.png").getImage();
		switch (theLevel) {
		case 5:
			// draw marker 5
			g.drawImage(yellowButton, MARKER_5_XCOORD, MARKER_5_YCOORD, null);
		case 4:
			// draw marker 4
			g.drawImage(yellowButton, MARKER_4_XCOORD, MARKER_4_YCOORD, null);
		case 3:
			// draw marker 3
			g.drawImage(yellowButton, MARKER_3_XCOORD, MARKER_3_YCOORD, null);
		case 2:
			// draw marker 2
			g.drawImage(yellowButton, MARKER_2_XCOORD, MARKER_2_YCOORD, null);
		case 1:
			// draw marker 1
			g.drawImage(yellowButton, MARKER_1_XCOORD, MARKER_1_YCOORD, null);
			break;
		default:
			break;
		}
	}

	/**
	 * METHOD: Paints stars on bottom right of screen for each
	 * passed level.
	 * @param g
	 */
	private void paintStars(Graphics g) {
		// Depending on the level of the game, draw the appropriate
		// number of stars. Only case 1 will break. This way, for each
		// level, it will continue to draw the star earned for all previous
		// levels.

		theLevel = 3;												// for diagnostics
		stars.add(new Star("ONE"));									// for diagnostics
		stars.add(new Star("TWO"));									// for diagnostics
		stars.add(new Star("THREE"));								// for diagnostics

		// Go through the stars ArrayList and paint each star at their
		// x- and y- coordinates.
		for (int index = 0; index < theLevel; index++) {
			Image starImage = new ImageIcon("Images/Star.png").getImage();
			g.drawImage(starImage, stars.get(index).getXCoord(), stars.get(index).getYCoord(), null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * OVERRIDDEN METHOD:
	 * @param e
	 */  
	@Override
	public void mousePressed(MouseEvent e) {
		GameButton source = (GameButton) e.getSource();

		if (source.getButtonMessage() == LEVEL_1) {
			System.out.println("this should go to level 1");
			//theGame.changeLayoutCard(Game.LEVEL_FIVE);
			theGame.levelFive.initLevel();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}