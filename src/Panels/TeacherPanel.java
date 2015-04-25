/**
 * TEACHER PANEL CLASS
 * 
 * DESCRIPTION:
 * The TeacherPanel class extends JPanel and is the layout that displays the
 * information for teachers and parents.
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
public class TeacherPanel extends JPanel implements Panel, MouseListener {
	// Declare static final members of TeacherPanel class:
	private static final String FORWARD = ">>";										// text for forward button
	private static final String BACKWARD = "<<";									// text for backward button
	private static final String BACK = "Go back";									// text for backButton
	private static final int FORWARD_XCOORD = BobsWindow.TEACHER_XCOORD + BobsWindow.TEACHER_WIDTH - 50;
	private static final int FORWARD_YCOORD = BobsWindow.TEACHER_YCOORD + BobsWindow.TEACHER_HEIGHT - 40;
	private static final int BACKWARD_XCOORD = BobsWindow.TEACHER_XCOORD + BobsWindow.TEACHER_WIDTH - 100;
	private static final int BACKWARD_YCOORD = BobsWindow.TEACHER_YCOORD + BobsWindow.TEACHER_HEIGHT - 40;
	private static final int BACK_YCOORD = 200;										// y-coordinate for backButton
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
			+ "Boolean Logic concept to your student. He will then ask your "
			+ "student a series of questions based on what was just explained.\n\n"
			+ "There are five questions in each level. Your student has two chances "
			+ "answer each question. Your student will drag and drop one of the "
			+ "children owls onto the correct answer. If the answer is incorrect, "
			+ "your student has another chance to drop the second owl onto the "
			+ "correct answer. Overall, an 80% is needed to pass the level. If "
			+ "the level is passed, the children owls will move on to the next "
			+ "level and your student will continue on to the next level.\n\n"
			+ "There are five levels, the last one being cumulative. When your "
			+ "student gets the children owls through the forest, they will "
			+ "receive a special helper certificate."; 

	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates TeacherPanel object
	private BobsWindow teacherBobsWindow;				// Bob's window for introduction instructions
	private JTextArea bobsTextAreaTitle;				// JTextArea for title of page
	private JTextArea bobsTextArea;						// JTextArea for Bob's Window
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
	 * in and calls overridden paintComponent() method.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		this.theGame = game;										// create reference to game passed in

		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		// Instantiate a BobsWindow with introduction text and instructions.
		teacherBobsWindow = new BobsWindow("TEACHER", PAGE_ONE_TEXT);
		add(teacherBobsWindow);
		repaint();
	}

	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image and BobsWindow with INSTRUCTION_TEXT.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/Backgrounds/TeacherBackground.jpg").getImage();
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
		Image image = new ImageIcon("Images/TextWindows/TeacherTextWindow.png").getImage();
		g.drawImage(image, teacherBobsWindow.getXCoord(), teacherBobsWindow.getYCoord(), null);

		// Draw Bob.
		Image bob = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bob, teacherBobsWindow.getBob().getXCoord(), teacherBobsWindow.getBob().getYCoord(), null);

		// Add text and button.
		addText();													// add text to Bob's Window
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
		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextAreaTitle != null && bobsTextArea != null) {
			remove(bobsTextAreaTitle);								// remove from TeacherPanel
			remove(bobsTextArea);									// remove from TeacherPanel
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
		String pageTitle = "Teachers & Parents";					// initialize the title
		bobsTextAreaTitle = new JTextArea();						// initialize the JTextArea
		bobsTextAreaTitle.setFont(Game.TITLE_FONT);					// set the font
		bobsTextAreaTitle.setForeground(Game.DARK_BLUE);			// set font color
		bobsTextAreaTitle.setOpaque(false);							// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextAreaTitle.setSize(BobsWindow.TEACHER_WIDTH - 20, 40);
		bobsTextAreaTitle.setLocation(BobsWindow.TEACHER_XCOORD + 10, BobsWindow.TEACHER_YCOORD + 10);
		bobsTextAreaTitle.setText(pageTitle);						// set the text
		add(bobsTextAreaTitle);										// add to TeacherPanel
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
		String teacherText = teacherBobsWindow.getBobsMessage();	// get the message from teacherBobsWindow
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		bobsTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		bobsTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		bobsTextArea.setLineWrap(true);								// set line wrap to true
		bobsTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		bobsTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea.setSize(BobsWindow.TEACHER_WIDTH - 20, BobsWindow.TEACHER_HEIGHT - 80);
		bobsTextArea.setLocation(BobsWindow.TEACHER_XCOORD + 10, BobsWindow.TEACHER_YCOORD + 40);
		bobsTextArea.setText(teacherText);							// set the text
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
		// Initialize a GameButton to view page two of instructions.
		forwardButton = new GameButton(FORWARD, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsWidth = forwardButton.getPreferredSize().width;
		int boundsHeight = forwardButton.getPreferredSize().height;
		forwardButton.setBounds(FORWARD_XCOORD, FORWARD_YCOORD, boundsWidth, boundsHeight);
		add(forwardButton);											// add to TeacherPanel
		forwardButton.addMouseListener(this);						// add MouseListener

		// Initialize a GameButton to go back in instructions.
		backwardButton = new GameButton(BACKWARD, "white");

		// Set the x- and y-coordinates and the button width and height.		
		boundsWidth = backwardButton.getPreferredSize().width;
		boundsHeight = backwardButton.getPreferredSize().height;
		backwardButton.setBounds(BACKWARD_XCOORD, BACKWARD_YCOORD, boundsWidth, boundsHeight);
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
		int boundsXCoord = BobsWindow.TEACHER_XCOORD / 2 - backButton.getPreferredSize().width / 2;
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
			theGame.changeLayoutCard(Game.INTRO);					// switch to IntroPanel
		}
		// If forward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == FORWARD) {
			teacherBobsWindow.setBobsMessage(PAGE_TWO_TEXT);		// change text to page two
			repaint();
		}	
		// If backward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == BACKWARD) {
			teacherBobsWindow.setBobsMessage(PAGE_ONE_TEXT);		// change back to page one
			repaint();
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