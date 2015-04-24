/**
 * TEACHER PANEL CLASS
 * 
 * DESCRIPTION:
 * The Teacher class extends JPanel and is the layout that displays the
 * information for teachers and parents.
 *    
 * SOURCES:
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 */

package BooleanForest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class TeacherPanel extends JPanel implements MouseListener {
	// Private static final members of TeacherPanel class:
	private static final String FORWARD = ">>";
	private static final String BACKWARD = "<<";
	private static final String BACK = "Go back";
	private static final int TEACHER_BUTTON_YCOORD = 200;
	private static final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 14);
	private static final Font PARAGRAPH_FONT = new Font("Verdana", Font.PLAIN, 12);
	private static final Color DARK_BLUE = new Color(12, 68, 159);
	private static final Color LIGHT_BLUE = new Color(57, 119, 222);

	// Private static final members of IntroPanel class:
	private static final int PANEL_WIDTH = 640;			// width of panel
	private static final int PANEL_HEIGHT = 480;		// height of panel
	private static final String TEACHER_TEXT = "Welcome to the Boolean "
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
	private static final String INTRODUCING_BOB = "This is Bob to the left. He "
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
	private Game theGame;								// reference to Game that instantiates IntroPanel object
	private GameButton backButton;						// button to go back to main intro panel
	private BobsWindow teacherBobsWindow;				// Bob's window for introduction instructions
	private JTextArea bobsTextAreaTitle;				// JTextArea for title of page
	private JTextArea bobsTextArea;						// JTextArea for Bob's Window
	private GameButton forwardButton;					// button to go forward in instructions
	private GameButton backwardButton;					// button to go backward in instructions
	
	/**
	 * CONSTRUCTOR: The constructor calls initIntro() method.
	 * @param game
	 */
	public TeacherPanel(Game game) {
		initTeacher(game);								// call initTeacher()
	}
	
	/**
	 * METHOD: Initializes JPanel dimensions and members of ForestPanel
	 * class. Creates a reference to the Game object passed in and calls 
	 * overridden paintComponent() method.
	 * @param game
	 */
	private void initTeacher(Game game) {
		this.theGame = game;							// assign game to theGame to reference Game instance
		
		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
		
		// Instantiate a BobsWindow with introduction text and instructions.
		teacherBobsWindow = new BobsWindow(BobsWindow.TEACHER, TEACHER_TEXT);
		add(teacherBobsWindow);
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
		Image image = new ImageIcon("Images/TeacherBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		// Paint various components on the screen.
		paintBobsWindow(g);								// paint Bob's Window and Bob
	}	
	
	/**
	 * METHOD: This  method paints Bob's Window white and Bob, as well
	 * as calls methods to add the text and buttons.
	 * @param g
	 */
	private void paintBobsWindow(Graphics g) {
		// Draw the white background for Bob's Window.
		Image image = new ImageIcon("Images/TeacherTextWindow.png").getImage();
		g.drawImage(image, teacherBobsWindow.getXCoord(), teacherBobsWindow.getYCoord(), null);
		
		// Draw Bob.
		Image bob = new ImageIcon("Images/Bob.png").getImage();
		g.drawImage(bob, teacherBobsWindow.getBob().getXCoord(), teacherBobsWindow.getBob().getYCoord(), null);
		
		// Add text and button.
		addBackButton();								// add button to go back to intro panel
		addText();										// add text to Bob's Window
		addForwardAndBackwardButtons();					// add buttons to go forward or backwards in instructions
	}

	/**
	 * METHOD: This method creates two JTextAreas and makes the text fit
	 * in the white background for Bob's Window with wrapped text and
	 * transparent background. A custom font is created and custom
	 * text color is set.
	 * @param g
	 * NOTE: Source is listed at the beginning of the class file.
	 */
	private void addText() {
		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextAreaTitle != null && bobsTextArea != null) {
			remove(bobsTextAreaTitle);					// remove from TeacherPanel
			remove(bobsTextArea);						// remove from TeacherPanel
		}
				
		// Create a JTextArea for title of page. Add JTextArea to JPanel.
		String pageTitle = "Teachers & Parents";		// initialize the title
		bobsTextAreaTitle = new JTextArea();			// initialize the JTextArea
		bobsTextAreaTitle.setFont(TITLE_FONT);			// set the font
		bobsTextAreaTitle.setForeground(DARK_BLUE);		// set font color
		bobsTextAreaTitle.setOpaque(false);				// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextAreaTitle.setSize(BobsWindow.TEACHER_WIDTH - 20, 40);
		bobsTextAreaTitle.setLocation(BobsWindow.TEACHER_XCOORD + 10, BobsWindow.TEACHER_YCOORD + 10);
		bobsTextAreaTitle.setText(pageTitle);			// set the text
		add(bobsTextAreaTitle);							// add to TeacherPanel
		
		// Create a JTextArea to fit inside Bob's Window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		String teacherText = teacherBobsWindow.getBobsMessage();	// get the message from teacherBobsWindow
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		bobsTextArea.setFont(PARAGRAPH_FONT);						// set the font
		bobsTextArea.setForeground(LIGHT_BLUE);						// set font color
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
	 * METHOD: This method adds the forward and backward buttons to
	 * Bob's Window to view teacher instructions and adds a 
	 * MouseListener to each button.
	 * @param none
	 */
	private void addForwardAndBackwardButtons() {
		// Initialize a GameButton to view more instructions.
		forwardButton = new GameButton(FORWARD, "white");
		
		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = BobsWindow.TEACHER_XCOORD + BobsWindow.TEACHER_WIDTH - 50;
		int boundsYCoord = BobsWindow.TEACHER_YCOORD + BobsWindow.TEACHER_HEIGHT - 40;
		int boundsWidth = forwardButton.getPreferredSize().width;
		int boundsHeight = forwardButton.getPreferredSize().height;
		forwardButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(forwardButton);										// add to TeacherPanel
		forwardButton.addMouseListener(this);					// add MouseListener

		// Initialize a GameButton to go back in instructions.
		backwardButton = new GameButton(BACKWARD, "white");
		
		// Set the x- and y-coordinates and the button width and height.		
		boundsXCoord = BobsWindow.TEACHER_XCOORD + BobsWindow.TEACHER_WIDTH - 100;
		boundsYCoord = BobsWindow.TEACHER_YCOORD + BobsWindow.TEACHER_HEIGHT - 40;
		boundsWidth = backwardButton.getPreferredSize().width;
		boundsHeight = backwardButton.getPreferredSize().height;
		backwardButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backwardButton);									// add to TeacherPanel
		backwardButton.addMouseListener(this);					// add MouseListener
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
		int boundsYCoord = TEACHER_BUTTON_YCOORD;
		int boundsWidth = backButton.getPreferredSize().width;
		int boundsHeight = backButton.getPreferredSize().height;
		backButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backButton);;									// add to TeacherPanel
		backButton.addMouseListener(this);					// add MouseListener
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Get the source of the component that was clicked.
		GameButton source = (GameButton) e.getSource();
		
		// If back button is clicked, go back to IntroPanel.
		if (source.getButtonMessage() == BACK) {
			theGame.changeLayoutCard(Game.INTRO);					// switch to IntroPanel
		}
		// If forward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == FORWARD) {
			teacherBobsWindow.setBobsMessage(INTRODUCING_BOB);		// change text to introduce Bob
			repaint();
		}	
		// If backward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == BACKWARD) {
			teacherBobsWindow.setBobsMessage(TEACHER_TEXT);			// change back to original teacher text
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
