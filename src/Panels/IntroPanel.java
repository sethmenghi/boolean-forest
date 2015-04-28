/**
 * INTROPANEL CLASS
 * 
 * DESCRIPTION:
 * The IntroPanel class extends JPanel and is the layout that displays the
 * introduction screen with brief introduction text and instructions. There
 * are buttons that go to the teacherPanel, owlPanel and forestPanel.
 *    
 * CODE SOURCES:
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 * 
 * IMAGE SOURCES:
 * 1) http://images.clipartpanda.com/rainforest-trees-clipart-dT6MdxpT9.png
 * 
 * NOTE: Owl and background images were drawn by Leslie Kim. No source
 * required.
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
import Objects.GameButton;

@SuppressWarnings("serial")
public class IntroPanel extends JPanel implements Panel, MouseListener {
	// Declare static final members of IntroPanel class:
	private static final String PLAY = "Let's go learn some boolean logic!";				// text for playButton
	private static final String OWLS = "Meet the owls";										// text for owlButton
	private static final String TEACHER = "Teachers & Parents";								// text for teacherButton

	private static final String TITLE = "Boolean Logic Forest";								// title text
	private static final String INTRODUCTION = "Welcome to the Boolean Logic Forest! This "	// introduction text
			+ "is my family: Alice, my wife, and our two children, David and Chloe. Our "
			+ "children need to get through the Boolean Logic Forest and need your help! "
			+ "Let's go on an adventure!";

	private static final String BACKGROUND_SRC = "Images/Backgrounds/IntroBackground.jpg";	// background url
	private static final String BOB_SRC = "Images/Owls/Bob.png";							// Bob url

	private static final int TEXT_WINDOW_WIDTH = 404;				// width of white text window
	private static final int TEXT_WINDOW_HEIGHT = 199;				// height of white text window
	private static final int TEXT_WINDOW_XCOORD = 53;				// pre-determined xCoord of white text window
	private static final int TEXT_WINDOW_YCOORD = 67;				// pre-determined yCoord of white text window
	private static final int BOB_XCOORD = 462;						// pre-determined xCoord of Bob
	private static final int BOB_YCOORD = 218;						// pre-determined yCoord of Bob

	// Declare members of IntroPanel class:
	private Game theGame;											// reference to main Game
	private JTextArea titleTextArea;								// JTextArea for title				
	private JTextArea introTextArea;								// JTextArea for intro
	private GameButton playButton;									// play button
	private GameButton owlButton;									// button to meet the owls
	private GameButton teacherButton;								// button for teachers and parents page

	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public IntroPanel(Game game) {
		initPanel(game);											// call initPanel()
	}

	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions of IntroPanel
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
	 * background image, Bob and calls methods to add the text and
	 * buttons.
	 * @param g
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image background = new ImageIcon(BACKGROUND_SRC).getImage();
		g.drawImage(background, 0, 0, null);

		// Draw Bob.
		Image bobImage = new ImageIcon(BOB_SRC).getImage();
		g.drawImage(bobImage, BOB_XCOORD, BOB_YCOORD, null);

		// Add text and button.
		addText();													// add text
		addButtons();												// add buttons
	}	

	/**
	 * OVERRIDDEN METHOD: This method adds the title text and paragraph
	 * text to Bob's Window.
	 * @param g
	 * NOTE: Source is listed at the beginning of the class file.
	 */
	@Override
	public void addText() {
		// If titleTextArea is not null, remove it from the JPanel.
//		if (titleTextArea != null) {
//			remove(titleTextArea);									// remove from IntroPanel
//		}
//
//		// If introTextArea is not null, remove it from the JPanel.
//		if (introTextArea != null) {
//			remove(introTextArea);									// remove from IntroPanel
//		}

		addTitleText();												// add title
		addParagraphText();											// add paragraph
	}

	/**
	 * OVERRIDDEN METHOD: This method creates a JTextArea for the title
	 * that fits inside the white text box. A custom font and color are
	 * used for the text and the background is transparent.
	 * @param none
	 */
	@Override
	public void addTitleText() {
		if (titleTextArea == null) {
			// Create a JTextArea for title of page and add to JPanel.
			titleTextArea = new JTextArea();							// initialize the JTextArea
			titleTextArea.setFont(Game.TITLE_FONT);						// set the font
			titleTextArea.setForeground(Game.DARK_BLUE);				// set font color
			titleTextArea.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			titleTextArea.setSize(TEXT_WINDOW_WIDTH - 20, 30);
			titleTextArea.setLocation(TEXT_WINDOW_XCOORD + 10, TEXT_WINDOW_YCOORD + 10);
			titleTextArea.setText(TITLE);								// set the text
			add(titleTextArea);											// add to IntroPanel
		}
	}

	/**
	 * OVERRIDDEN METHOD: This method creates a JTextArea for the text
	 * that fits inside the white text box. A custom font and color are
	 * used for the text and the background is transparent. The text is
	 * wrapped and words will always appear in full on a line (no
	 * hyphenated words).
	 * @param none
	 */
	@Override
	public void addParagraphText() {
		if (introTextArea == null) {
			// Create a JTextArea to fit inside white text window with wrapped
			// text, custom font and transparent background and add to JPanel.
			introTextArea = new JTextArea();							// initialize the JTextArea
			introTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
			introTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
			introTextArea.setLineWrap(true);							// set line wrap to true
			introTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
			introTextArea.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			introTextArea.setSize(TEXT_WINDOW_WIDTH - 20, TEXT_WINDOW_HEIGHT - 20);
			introTextArea.setLocation(TEXT_WINDOW_XCOORD + 10, TEXT_WINDOW_YCOORD + 40);
			introTextArea.setText(INTRODUCTION);						// set the text
			add(introTextArea);											// add to IntroPanel
		}
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
	 * METHOD: This method adds the playButton and adds a MouseListener.
	 * @param none
	 */
	private void addPlayButton() {
		if (playButton == null) {
			// Initialize the playButton to go to the ForestPanel.
			playButton = new GameButton(PLAY, "WHITE");

			// Set the x- and y-coordinates and the button width and height.
			int boundsWidth = playButton.getPreferredSize().width;
			int boundsHeight = playButton.getPreferredSize().height;
			int boundsXCoord = TEXT_WINDOW_XCOORD + TEXT_WINDOW_WIDTH / 2 - boundsWidth / 2;
			int boundsYCoord = TEXT_WINDOW_YCOORD + TEXT_WINDOW_HEIGHT - boundsHeight - 20;
			playButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

			add(playButton);											// add to IntroPanel
			playButton.addMouseListener(this);							// add MouseListener
		}
	}

	/**
	 * METHOD: This method adds the teacherButton and adds a MouseListener.
	 * @param none
	 */
	private void addTeacherButton() {
		if (teacherButton == null) {
			// Initialize a GameButton to go on to the TeacherPanel.
			teacherButton = new GameButton(TEACHER, "WHITE");

			// Set the x- and y-coordinates and the button width and height.
			int boundsXCoord = 468;
			int boundsYCoord = 426;
			int boundsWidth = teacherButton.getPreferredSize().width;
			int boundsHeight = teacherButton.getPreferredSize().height;
			teacherButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

			add(teacherButton);											// add to IntroPanel
			teacherButton.addMouseListener(this);						// add MouseListener
		}
	}

	/**
	 * METHOD: This method adds the owlButton and adds a MouseListener.
	 * @param none
	 */
	private void addOwlButton() {
		if (owlButton == null) {
			// Initialize a GameButton to go to the Owl Panel.
			owlButton = new GameButton(OWLS, "WHITE");

			// Set the x- and y-coordinates and the button width and height.
			int boundsWidth = owlButton.getPreferredSize().width;
			int boundsHeight = owlButton.getPreferredSize().height;
			int boundsXCoord = (teacherButton.getPreferredSize().width - boundsWidth) / 2 + TEXT_WINDOW_XCOORD
					+ TEXT_WINDOW_WIDTH + 10;
			int boundsYCoord = 391;
			owlButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);

			add(owlButton);												// add to IntroPanel
			owlButton.addMouseListener(this);							// add MouseListener
		}
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

		// If playButton is clicked, go to ForestPanel.
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