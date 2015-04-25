/**
 * INTRO PANEL CLASS
 * 
 * DESCRIPTION:
 * The IntroPanel class extends JPanel and is the layout that displays the
 * introduction screen with brief introduction text and instructions. 
 *    
 * SOURCES:
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 */

package Panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import BooleanForest.Game;
import Objects.BobsWindow;
import Objects.GameButton;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel implements Panel, MouseListener {
	// Declare static final members of IntroPanel class:
	private static final String PLAY = "Let's go learn some boolean logic!";	// text for playButton
	private static final String OWLS = "Meet the owls";							// text for owlButton
	private static final String TEACHER = "Teachers & Parents";					// text for teacherButton
	private static final String INSTRUCTION_TEXT = "Welcome to the Boolean "	// introduction text
			+ "Logic Forest! This is my family: Alice, my wife, and our two "
			+ "children, David and Chloe. Our children need to get through "
			+ "the Boolean Logic Forest and need your help! Let's go on an "
			+ "adventure!";

	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates IntroPanel object
	private BobsWindow introBobsWindow;					// Bob's Window for introduction instructions
	private JTextArea bobsTextAreaTitle;				// JTextArea for title of page				
	private JTextArea bobsTextArea;						// JTextArea for Bob's Window
	private GameButton playButton;						// play button
	private GameButton owlButton;						// button to meet the owls
	private GameButton teacherButton;					// button for teachers and parents page

	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public IntroPanel(Game game) {
		initPanel(game);											// call initPanel()
	}

	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions and members of
	 * IntroPanel class. Creates a reference to the Game object passed in
	 * and initializes Bob's Window.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		this.theGame = game;										// create reference to game passed in

		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		// Initialize a BobsWindow with introduction text and instructions.
		introBobsWindow = new BobsWindow(BobsWindow.INTRO, INSTRUCTION_TEXT);
		add(introBobsWindow);
	}

	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image and Bob's Window and buttons.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/Backgrounds/IntroBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);

		// Paint various components on the screen.
		paintBobsWindow(g);											// paint Bob's Window and Bob
	}	

	/**
	 * OVERRIDDEN METHOD: This  method paints Bob's Window white and Bob,
	 * as well as calls method to add the text and button.
	 * @param g
	 */
	@Override
	public void paintBobsWindow(Graphics g) {
		// Draw the white background for Bob's Window.
		Image image = new ImageIcon("Images/TextWindows/IntroTextWindow.png").getImage();
		g.drawImage(image, introBobsWindow.getXCoord(), introBobsWindow.getYCoord(), null);

		// Draw Bob.
		Image bob = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bob, introBobsWindow.getBob().getXCoord(), introBobsWindow.getBob().getYCoord(), null);

		// Add text and button.
		addText();													// add text to Bob's Window
		addButtons();												// add button to Bob's Window
	}

	/**
	 * OVERRIDDEN METHOD: This method adds the title text and paragraph
	 * text to Bob's Window.
	 * @param g
	 * NOTE: Source is listed at the beginning of the class file.
	 */
	@Override
	public void addText() {
		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea != null) {
			remove(bobsTextArea);									// remove from IntroPanel
		}

		addTitleText();												// add title
		addParagraphText();											// add paragraph
	}

	/**
	 * OVERRIDDEN METHOD: This method creates a JTextArea for the title
	 * that fits inside the white box of Bob's Window. A custom font and
	 * color are used for the text and the background is transparent.
	 */
	@Override
	public void addTitleText() {
		// Create a JTextArea for title of page. Add JTextArea to JPanel.
		String pageTitle = "Boolean Logic Forest";					// initialize the title
		bobsTextAreaTitle = new JTextArea();						// initialize the JTextArea
		bobsTextAreaTitle.setFont(Game.TITLE_FONT);					// set the font
		bobsTextAreaTitle.setForeground(Game.DARK_BLUE);			// set font color
		bobsTextAreaTitle.setOpaque(false);							// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextAreaTitle.setSize(BobsWindow.INTRO_WIDTH - 20, 40);
		bobsTextAreaTitle.setLocation(BobsWindow.INTRO_XCOORD + 10, BobsWindow.INTRO_YCOORD + 10);
		bobsTextAreaTitle.setText(pageTitle);						// set the text
		add(bobsTextAreaTitle);										// add to IntroPanel
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
		String introText = introBobsWindow.getBobsMessage();		// get the message from forestBobsWindow
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		bobsTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		bobsTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		bobsTextArea.setLineWrap(true);								// set line wrap to true
		bobsTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		bobsTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea.setSize(BobsWindow.INTRO_WIDTH - 20, BobsWindow.INTRO_HEIGHT - 20);
		bobsTextArea.setLocation(BobsWindow.INTRO_XCOORD + 10, BobsWindow.INTRO_YCOORD + 40);
		bobsTextArea.setText(introText);							// set the text
		add(bobsTextArea);											// add to IntroPanel
	}

	/**
	 * METHOD: This method adds the playButton, owlButton and TeacherButton
	 * and adds MouseListeners to each button.
	 * @param none
	 */
	@Override
	public void addButtons() {
		addPlayButton();											// add playButton
		addTeacherButton();											// add teacherButton
		addOwlButton();												// add owlButton
	}

	/**
	 * METHOD: This method adds the playButton and add MouseListeners to 
	 * each button.
	 * @param none
	 */
	private void addPlayButton() {
		// Initialize the playButton to go to the ForestPanel.
		playButton = new GameButton(PLAY, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = BobsWindow.INTRO_XCOORD + BobsWindow.INTRO_WIDTH / 2 -
				playButton.getPreferredSize().width / 2;
		int boundsYCoord = BobsWindow.INTRO_YCOORD + BobsWindow.INTRO_HEIGHT - 
				playButton.getPreferredSize().height - 20;
		int boundsWidth = playButton.getPreferredSize().width;
		int boundsHeight = playButton.getPreferredSize().height;
		playButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

		add(playButton);											// add to IntroPanel
		playButton.addMouseListener(this);							// add MouseListener
	}

	/**
	 * METHOD: This method adds the owlButton and add MouseListeners to 
	 * each button.
	 * @param none
	 */
	private void addOwlButton() {
		// Initialize a GameButton to go to the Owl Panel.
		owlButton = new GameButton(OWLS, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = (teacherButton.getPreferredSize().width - owlButton.getPreferredSize().width) / 2 + 468;
		int boundsYCoord = 391;
		int boundsWidth = owlButton.getPreferredSize().width;
		int boundsHeight = owlButton.getPreferredSize().height;
		owlButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

		add(owlButton);												// add to IntroPanel
		owlButton.addMouseListener(this);							// add MouseListener
	}

	/**
	 * METHOD: This method adds the teacherButton and add MouseListeners to 
	 * each button.
	 * @param none
	 */
	private void addTeacherButton() {
		// Initialize a GameButton to go on to the TeacherPanel.
		teacherButton = new GameButton(TEACHER, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = 468;
		int boundsYCoord = 426;
		int boundsWidth = teacherButton.getPreferredSize().width;
		int boundsHeight = teacherButton.getPreferredSize().height;
		teacherButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

		add(teacherButton);											// add to IntroPanel
		teacherButton.addMouseListener(this);						// add MouseListener
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mousePressed() by
	 * getting the source of the button pressed and switching to the
	 * corresponding panel.
	 * @param e
	 */  
	@Override
	public void mousePressed(MouseEvent e) {
		GameButton source = (GameButton) e.getSource();				// get source of component that was clicked

		// if playButton is clicked, go to ForestPanel.
		if (source.getButtonMessage() == PLAY) {
			theGame.changeLayoutCard("FOREST");						// switch to ForestPanel
		}
		// If owlButton is clicked, go to OwlPanel.
		else if (source.getButtonMessage() == OWLS) {
			theGame.changeLayoutCard("OWLS");						// switch to OwlPanel
		}
		// If teacherButton is clicked, go to TeacherPanel.
		else if (source.getButtonMessage() == TEACHER) {
			theGame.changeLayoutCard("TEACHER");					// switch to TeacherPanel
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