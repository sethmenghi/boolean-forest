/**
 * OWL PANEL CLASS
 * 
 * DESCRIPTION:
 * The OwlPanel class extends JPanel and is the layout that displays the
 * information about the Owls.
 *    
 * SOURCES:
 * http://stackoverflow.com/questions/16190536/how-to-display-strings-in-
 * jtextarea-jtextfield
 */

package BooleanForest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class OwlPanel extends JPanel implements MouseListener {
	// Private static final members of TeacherPanel class:
	private static final String BACK = "Go back";
	private static final int OWL_BUTTON_YCOORD = 433;
	private static final String ALICE_TEXT = "Hi there! I'm Alice, Bob's wife. Our "
			+ "children were born about a month ago. It's nice to meet you!"; 
	private static final String BOB_TEXT = "Hello there! I'm Bob and this is my "
			+ "family. The children are very excited to start learning and I hope "
			+ "that you will help them get through the Boolean Logic Forest!";
	private static final String CHLOE_TEXT = "My name is Chloe. I am 4 weeks old "
			+ "and just starting to learn to fly. My favorite food to eat is fish!";
	private static final String DAVID_TEXT = "My name is David. I am also 4 weeks "
			+ "old and learning to fly with Chloe. My favorite food to eat are "
			+ "grasshoppers!";
	
	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates OwlPanel object
	private GameButton backButton;						// button to go back to main intro panel
	
	/**
	 * CONSTRUCTOR: The constructor calls initIntro() method.
	 * @param game
	 */
	public OwlPanel(Game game) {
		initOwl(game);									// call initOwl()
	}

	/**
	 * METHOD: Initializes JPanel dimensions and members of ForestPanel
	 * class. Creates a reference to the Game object passed in and calls 
	 * overridden paintComponent() method.
	 * @param game
	 */
	private void initOwl(Game game) {
		this.theGame = game;							// assign game to theGame to reference Game instance
		
		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
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
		Image image = new ImageIcon("Images/OwlBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		// Paint various components on the screen.
		addText();										// add text to each owl's window
		addBackButton();								// add button to go back to intro panel
	}

	/**
	 * METHOD: This method creates JTextAreas and makes the text fit
	 * in the white background for each owl's window with wrapped text
	 * and transparent background. A custom font is created and custom
	 * text color is set.
	 * @param g
	 * NOTE: Source is listed at the beginning of the class file.
	 */
	private void addText() {
		// Add Alice's introduction text.
		// Create a JTextArea to fit inside white window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		JTextArea aliceTextArea = new JTextArea();					// initialize the JTextArea
		aliceTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		aliceTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		aliceTextArea.setLineWrap(true);							// set line wrap to true
		aliceTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		aliceTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		aliceTextArea.setSize(441, 59);
		aliceTextArea.setLocation(161, 36);
		aliceTextArea.setText(ALICE_TEXT);							// set the text
		add(aliceTextArea);											// add to OwlPanel
		
		// Add Bob's introduction text.
		// Create a JTextArea to fit inside white window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		JTextArea bobTextArea = new JTextArea();					// initialize the JTextArea
		bobTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		bobTextArea.setForeground(Game.LIGHT_BLUE);					// set font color
		bobTextArea.setLineWrap(true);								// set line wrap to true
		bobTextArea.setWrapStyleWord(true);							// set words to appear in full on a line
		bobTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobTextArea.setSize(441, 59);
		bobTextArea.setLocation(161, 136);
		bobTextArea.setText(BOB_TEXT);								// set the text
		add(bobTextArea);											// add to OwlPanel
		
		// Add Chloe's introduction text.
		// Create a JTextArea to fit inside white window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		JTextArea chloeTextArea = new JTextArea();					// initialize the JTextArea
		chloeTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		chloeTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		chloeTextArea.setLineWrap(true);							// set line wrap to true
		chloeTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		chloeTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		chloeTextArea.setSize(441, 59);
		chloeTextArea.setLocation(161, 236);
		chloeTextArea.setText(CHLOE_TEXT);							// set the text
		add(chloeTextArea);											// add to OwlPanel
		
		// Add David's introduction text.
		// Create a JTextArea to fit inside white window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		JTextArea davidTextArea = new JTextArea();					// initialize the JTextArea
		davidTextArea.setFont(Game.PARAGRAPH_FONT);					// set the font
		davidTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
		davidTextArea.setLineWrap(true);							// set line wrap to true
		davidTextArea.setWrapStyleWord(true);						// set words to appear in full on a line
		davidTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		davidTextArea.setSize(441, 59);
		davidTextArea.setLocation(161, 336);
		davidTextArea.setText(DAVID_TEXT);							// set the text
		add(davidTextArea);											// add to OwlPanel
	}
	
	/**
	 * METHOD: This method adds the back button to TeacherPanel so
	 * that the screen returns to the initial IntroPanel.
	 * @param none
	 */
	private void addBackButton() {
		// Initialize a GameButton to go on to the Intro Panel.
		backButton = new GameButton(BACK, "white");
		
		// Set the x- and y-coordinates and the button width and height.
		int boundsXCoord = Game.APPLET_WIDTH / 2 - backButton.getPreferredSize().width / 2;
		int boundsYCoord = OWL_BUTTON_YCOORD;
		int boundsWidth = backButton.getPreferredSize().width;
		int boundsHeight = backButton.getPreferredSize().height;
		backButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backButton);											// add to OwlPanel
		backButton.addMouseListener(this);							// add MouseListener
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
		// Get the source of the component that was clicked.
		theGame.changeLayoutCard(Game.INTRO);						// switch to IntroPanel
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