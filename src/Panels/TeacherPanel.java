/**
 * TEACHER PANEL CLASS
 * 
 * DESCRIPTION:
 * The TeacherPanel class extends JPanel and is the layout that displays the
 * information for teachers and parents.
 *    
 * CODE SOURCES:
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
import Objects.GameButton;

@SuppressWarnings("serial")
public class TeacherPanel extends JPanel implements Panel, MouseListener {
	// Declare static final members of TeacherPanel class:
	private static final String BACK = "Go back";									// text for backButton
	private static final String FORWARD = ">>";										// text for forwardButton
	private static final String BACKWARD = "<<";									// text for backwardButton
	
	private static final String TITLE = "Teachers & Parents";						// title text
	private static final String PAGE_ONE_TEXT = "Welcome to the Boolean "			// page one of teacher text
			+ "Logic Forest! This is a simple interactive game for students "
			+ "in grades 1 - 3. Computer science is becoming a more and more "
			+ "relevant matter as technology becomes exponentially "
			+ "integrated in our lives.\n\nDeveloping skills that would help "
			+ "students eventually further our ability to utilize technology "
			+ "can start at a young age. Understanding the concepts of Boolean "
			+ "Logic from the computer science perspective such as TRUE and "
			+ "FALSE, AND and OR can be introduced at a young age.\n\nThe game "
			+ "itself should be relatively self-explanatory to your student, but "
			+ "click the next button for more instructions. Younger students may "
			+ "need a little help with reading.";
	private static final String PAGE_TWO_TEXT = "This is Bob to the left. He "		// page two of teacher text
			+ "wants your student to help his children owls Chloe and David "
			+ "through the Boolean Logic Forest. To do so, Bob will explain a "
			+ "Boolean Logic concept to your student. The four conepts are:\n"
			+ "1) True and False\n2) And\n3) Or\n4) Not\n\nHe will then ask your "
			+ "student a series of questions based on what was just explained.\n\n"
			+ "There are three to five questions in each level. Your student "
			+ "will be able to answer until the chosen answer is selected.";
	private static final String PAGE_THREE_TEXT = "There are five levels, the "		// page three of teacher text
			+ "last one being cumulative. When your student gets the children owls "
			+ "through the forest, they will receive a special helper certificate.";
	
	private static final String BACKGROUND_SRC = "/Images/Backgrounds/TeacherBackground.jpg";	// background url
	private static final String BOB_SRC = "/Images/Owls/Bob.png";								// Bob url
	
	private static final int TEXT_WINDOW_WIDTH = 404;		// width of TeacherPanel BobsWindow
	private static final int TEXT_WINDOW_HEIGHT = 425;		// height of TeacherPanel BobsWindow
	private static final int TEXT_WINDOW_XCOORD = 207;		// pre-determined xCoord of TeacherPanel BobsWindow
	private static final int TEXT_WINDOW_YCOORD = 34;		// pre-determined yCoord of TeacherPanel BobsWindow
	private static final int BOB_XCOORD = 31;				// pre-determined xCoord of TeacherPanel Bob
	private static final int BOB_YCOORD = 25;				// pre-determined yCoord of TeacherPanel Bob
	private static final int BACK_YCOORD = 200;				// pre-determined yCoord for backButton					
	
	// Declare members of IntroPanel class:
	private Game theGame;								// reference to main Game
	private String bobsMessage;							// String for Bob's message
	private int currentPage;							// current page displayed
	private JTextArea titleTextArea;					// JTextArea for title
	private JTextArea bobsTextArea;						// JTextArea for Bob's message
	private GameButton forwardButton;					// button to go forward in instructions
	private GameButton backwardButton;					// button to go backward in instructions
	private GameButton backButton;						// button to go back to main IntroPanel

	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public TeacherPanel(Game game) {
		initPanel(game);											// call initPanel()
	}

	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions and members of 
	 * TeacherPanel class. Creates a reference to the Game object passed  
	 * in.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		this.theGame = game;										// create reference to game passed in
		bobsMessage = PAGE_ONE_TEXT;								// initializes Bob's message
		currentPage = 1;											// initialize current page to 1
		
		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
	}

	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image, Bob and calls methods to add the text and
	 * buttons.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon(getClass().getResource(BACKGROUND_SRC)).getImage();
		g.drawImage(image, 0, 0, null);

		// Draw Bob.
		Image bobImage = new ImageIcon(getClass().getResource(BOB_SRC)).getImage();
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
		if (titleTextArea != null) {
			remove(titleTextArea);									// remove from TeacherPanel
		}
		
		// If introTextArea is not null, remove it from the JPanel.
		if (bobsTextArea != null) {
			remove(bobsTextArea);									// remove from TeacherPanel
		}

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
		// Create a JTextArea for title of page and add to JPanel.
		titleTextArea = new JTextArea();						// initialize the JTextArea
		titleTextArea.setFont(Game.TITLE_FONT);					// set the font
		titleTextArea.setForeground(Game.DARK_BLUE);			// set font color
		titleTextArea.setOpaque(false);							// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		titleTextArea.setSize(TEXT_WINDOW_WIDTH - 20, 30);
		titleTextArea.setLocation(TEXT_WINDOW_XCOORD + 10, TEXT_WINDOW_YCOORD + 10);
		titleTextArea.setText(TITLE);							// set the text
		add(titleTextArea);										// add to TeacherPanel
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
		// Create a JTextArea to fit inside Bob's Window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		bobsTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		bobsTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		bobsTextArea.setLineWrap(true);								// set line wrap to true
		bobsTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		bobsTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea.setSize(TEXT_WINDOW_WIDTH - 20, TEXT_WINDOW_HEIGHT - 80);
		bobsTextArea.setLocation(TEXT_WINDOW_XCOORD + 10, TEXT_WINDOW_YCOORD + 40);
		bobsTextArea.setText(bobsMessage);							// set the text
		add(bobsTextArea);											// add to TeacherPanel
	}

	/**
	 * METHOD: This method adds the forwardButton, backwardButton and
	 * teacherButton and adds MouseListeners to each button.
	 * @param none
	 */
	@Override
	public void addButtons() {
		addForwardAndBackwardButtons();								// add forward and backward buttons
		addBackButton();											// add back button
	}
	
	/**
	 * METHOD: This method adds the forward and backward buttons to
	 * Bob's Window to view teacher instructions and adds a 
	 * MouseListener to each button.
	 * @param none
	 */
	private void addForwardAndBackwardButtons() {
		// Initialize a GameButton to view later pages of instructions.
		forwardButton = new GameButton(FORWARD, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsWidth = forwardButton.getPreferredSize().width;
		int boundsHeight = forwardButton.getPreferredSize().height;
		int boundsXCoord = TEXT_WINDOW_XCOORD + TEXT_WINDOW_WIDTH - 50;
		int boundsYCoord = TEXT_WINDOW_YCOORD + TEXT_WINDOW_HEIGHT - 40;
		forwardButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(forwardButton);											// add to TeacherPanel
		forwardButton.addMouseListener(this);						// add MouseListener

		// Initialize a GameButton to view previous pages in instructions.
		backwardButton = new GameButton(BACKWARD, "white");

		// Set the x- and y-coordinates and the button width and height.		
		boundsWidth = backwardButton.getPreferredSize().width;
		boundsHeight = backwardButton.getPreferredSize().height;
		boundsXCoord = TEXT_WINDOW_XCOORD + TEXT_WINDOW_WIDTH - 100;
		boundsYCoord = TEXT_WINDOW_YCOORD + TEXT_WINDOW_HEIGHT - 40;
		backwardButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backwardButton);										// add to TeacherPanel
		backwardButton.addMouseListener(this);						// add MouseListener
	}

	/**
	 * METHOD: This method adds the back button to TeacherPanel so
	 * that the screen returns to the initial IntroPanel.
	 * @param none
	 */
	private void addBackButton() {
		// Initialize a GameButton to go on to the Forest Panel.
		backButton = new GameButton(BACK, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = TEXT_WINDOW_XCOORD / 2 - backButton.getPreferredSize().width / 2;
		int boundsYCoord = BACK_YCOORD;
		int boundsWidth = backButton.getPreferredSize().width;
		int boundsHeight = backButton.getPreferredSize().height;
		backButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backButton);											// add to TeacherPanel
		backButton.addMouseListener(this);							// add MouseListener
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mousePressed() by
	 * getting the source of the button pressed and switching to the
	 * corresponding panel or changing the displayed text.
	 * @param e
	 */  
	@Override
	public void mousePressed(MouseEvent e) {
		GameButton source = (GameButton) e.getSource();				// get source of component that was clicked

		// If back button is clicked, go back to IntroPanel.
		if (source.getButtonMessage() == BACK) {
			theGame.changeLayoutCard("INTRO");						// switch to IntroPanel
		}
		
		// If forward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == FORWARD) {
			// Check which page it is currently on and go forward from there.
			// If page one, go to page two.
			if (currentPage == 1) {
				bobsMessage = PAGE_TWO_TEXT;						// change text to page two
				currentPage++;										// update currentPage
			}
			// If page two, go to page three.
			else if (currentPage == 2) {
				bobsMessage = PAGE_THREE_TEXT;						// change text to page three
				currentPage++;										// update currentPage
			}
			repaint();												// repaint with updated text
		}	
		// If backward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == BACKWARD) {
			// Check which page it is currently on and go backward from there.
			// If page three, go to page two.
			if (currentPage == 3) {
				bobsMessage = PAGE_TWO_TEXT;						// change text to page two
				currentPage--;										// update currentPage
			}
			// If page two, go to page one.
			else if (currentPage == 2) {
				bobsMessage = PAGE_ONE_TEXT;						// change text to page one
				currentPage--;										// update currentPage
			}
			repaint();												// repaint with updated text
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