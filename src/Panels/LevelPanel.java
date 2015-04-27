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
import Levels.LevelFour;
import Levels.LevelOne;
import Levels.LevelThree;
import Levels.LevelTwo;
import Objects.GameButton;
import Objects.Owl;

@SuppressWarnings("serial")
public class LevelPanel extends JPanel implements Panel, MouseListener {
	private static final String FORWARD = ">>";										// text for forward button
	private static final String BACKWARD = "<<";									// text for backward button
	private static final String BACK = "BACK TO FOREST";							// text for back to forestPanel
	
	public static final int LEVEL_WIDTH = 420;				// width of LevelPanel BobsWindow
	public static final int LEVEL_HEIGHT = 433;				// height of LevelPanel BobsWindow
	public static final int LEVEL_XCOORD = 22;				// pre-determined xCoord of LevelPanel BobsWindow
	public static final int LEVEL_YCOORD = 24;				// pre-determined yCoord of LevelPanel BobsWindow
	private static final int BOB_XCOORD = 464;			// pre-determined xCoord of LevelPanel Bob
	private static final int BOB_YCOORD = 304;			// pre-determined yCoord of LevelPanel Bob
	
	
	private static final int FORWARD_XCOORD = LEVEL_XCOORD + LEVEL_WIDTH - 50;
	private static final int FORWARD_YCOORD = LEVEL_YCOORD + LEVEL_HEIGHT - 40;
	private static final int BACKWARD_XCOORD = LEVEL_XCOORD + LEVEL_WIDTH - 100;
	private static final int BACKWARD_YCOORD = LEVEL_YCOORD + LEVEL_HEIGHT - 40;

	private Game theGame;								// reference to Game that instantiates LevelPanel object
	private int theLevel;								// the current level passed in theGame
private Owl bob;										// Bob
	private JTextArea bobsTextArea;						// JTextArea for Bob's Window
	private JTextArea bobsTextArea2;					// JTextArea for Bob's Window (if there are two statements)
	private String currentShownText;					// current text being shown for explanations
	private int currentPage;							// current page being shown for explanations
	private GameButton backButton;						// back to forestPanel button
	private GameButton forwardButton;					// forward button
	private GameButton backwardButton;					// backward button

	LevelOne levelOne;
	LevelTwo levelTwo;
	//LevelThree levelThree;
	LevelFour levelFour;
	
	public LevelPanel(Game game, int levelToPlay) {
		initPanel(game, levelToPlay);
	}

	@Override
	public void initPanel(Game game) {
		// TODO Auto-generated method stub
	}

	public void initPanel(Game game, int levelToPlay) {
		this.theGame = game;
		this.theLevel = levelToPlay;
		bob = new Owl(BOB_XCOORD, BOB_YCOORD, Owl.BOB);				// initialize Bob

		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		currentPage = 1;
		
		// Initialize currentShownText to first page String for level being played.
		switch (theLevel) {
		case 1:
			currentShownText = LevelOne.PAGE_TRUE;					// set currentShownText to Level 1 page 1
			break;
		case 2:
//			currentShownText = LevelTwo.PAGE;						// set currentShownText to Level 2 page 1
			break;
		case 3:
//			currentShownText = LevelThree.PAGE;						// set currentShownText to Level 3 page 1
			break;
		case 4:
//			currentShownText = LevelFour.PAGE;						// set currentShownText to Level 4 page 1
			break;
		case 5:
//			currentShownText = LevelFive.PAGE;						// set currentShownText to Level 5 page 1
			break;	
		default:
			break;
		}
		
	}

	public void nextQuestion(){
		switch(theLevel){
		case 1:
			levelOne.nextQuestion();
			break;
		case 2:
			break;
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/Backgrounds/LevelBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);

		Image bobImage = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bobImage, BOB_XCOORD, BOB_YCOORD, null);

		// Add text and button.
		addText();													// add text
		addButtons();												// add buttons
	}

	@Override
	public void addText() {
		// TODO Auto-generated method stub
	}

	/**
	 * OVERLOADED METHOD:
	 * @param g
	 */
	private void addText(Graphics g) {
		String levelTextOne = "";										// String for first line of text
		String levelTextTwo = "";										// String for second line of text

		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea != null ) {
			remove(bobsTextArea);
		}
		if (bobsTextArea2 != null) {
			remove(bobsTextArea2);
		}

		// Create a JTextArea to fit inside Bob's Window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		if (currentPage == 1 || currentPage == 4) {
			if (currentPage == 1) {
				levelTextOne = LevelOne.PAGE_TRUE;						// get the first page from LevelOne class
			}
			else {
				levelTextOne = LevelOne.PAGE_FALSE;						// get the fourth page from LevelOne class
			}		
			bobsTextArea = new JTextArea();								// initialize the JTextArea
			bobsTextArea.setFont(Game.TOPICS_FONT);						// set the font
			bobsTextArea.setForeground(Game.DARK_BLUE);					// set font color
			bobsTextArea.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea.setSize(LEVEL_WIDTH - 20, 150);
			bobsTextArea.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 120);
			bobsTextArea.setText(levelTextOne);							// set the text
			add(bobsTextArea);											// add to LevelPanel		
		}
		else {
			if (currentPage == 2) {
				levelTextOne = LevelOne.PAGE_TRUE_A;					// get the second page from LevelOne class
				g.drawImage(LevelOne.PENGUIN, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
				levelTextTwo = LevelOne.TRUE_STATEMENT;					// get the second line of text
			}
			else if (currentPage == 3) {
				levelTextOne = LevelOne.PAGE_TRUE_B;					// get the third page from LevelOne class
				g.drawImage(LevelOne.BLUE, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
				levelTextTwo = LevelOne.TRUE_STATEMENT;					// get the second line of text
			}
			else if (currentPage == 5) {
				levelTextOne = LevelOne.PAGE_FALSE_A;					// get the fifth page from LevelOne class
				g.drawImage(LevelOne.TABLE, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
				levelTextTwo = LevelOne.FALSE_STATEMENT;				// get the second line of text
			}
			else if (currentPage == 6){
				levelTextOne = LevelOne.PAGE_FALSE_B;					// get the sixth page from LevelOne class
				g.drawImage(LevelOne.PINK, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
				levelTextTwo = LevelOne.FALSE_STATEMENT;				// get the second line of text
			}
			else if (currentPage == 7){
				if (levelOne == null){
					levelOne = new LevelOne(theGame);
					theGame.textQuestion.switchLevelPanel(this);
					System.out.println("Instantiated Level One in addText(Graphics)");
				}
			}
			else if (currentPage == 8){
				
			}
			bobsTextArea = new JTextArea();								// initialize the JTextArea
			bobsTextArea.setFont(Game.LESSON_STATEMENT);				// set the font
			bobsTextArea.setForeground(Game.LIGHT_BLUE);				// set font color
			bobsTextArea.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea.setSize(LEVEL_WIDTH - 20, 50);
			bobsTextArea.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 30);
			bobsTextArea.setText(levelTextOne);							// set the text
			add(bobsTextArea);											// add to LevelPanel

			bobsTextArea2 = new JTextArea();							// initialize the JTextArea
			bobsTextArea2.setFont(Game.LESSON_STATEMENT);				// set the font
			bobsTextArea2.setForeground(Game.LIGHT_BLUE);				// set font color
			bobsTextArea2.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea2.setSize(LEVEL_WIDTH - 20, 50);
			bobsTextArea2.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 350);
			bobsTextArea2.setText(levelTextTwo);						// set the text
			add(bobsTextArea2);											// add to LevelPanel
		}
	}
	
	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void addParagraphText() {

	}

	/**
	 * METHOD: This method adds the forestGameButton and adds
	 * MouseListener to button.
	 * @param none
	 */
	@Override
	public void addButtons() {
		addBackButton();											// add button to go back to forestPanel
		addForwardAndBackwardButtons();								// add forward and backward buttons	
	}
	
	/**
	 * METHOD: This method adds the button to go back to the
	 * forestPanel card.
	 * @param none
	 */
	private void addBackButton() {
		// Initialize a GameButton to view page two of instructions.
		backButton = new GameButton(BACK, "white");

		// Set the x- and y-coordinates and the button width and height.
		int boundsWidth = backButton.getPreferredSize().width;
		int boundsHeight = backButton.getPreferredSize().height;
		backButton.setBounds(480, 80, boundsWidth, boundsHeight);
		add(backButton);											// add to TeacherPanel
		backButton.addMouseListener(this);							// add MouseListener

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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GameButton source = (GameButton) e.getSource();				// get source of component that was clicked

		// If back button is clicked, go back to IntroPanel.
		if (source.getButtonMessage() == FORWARD) {
			switch (currentPage) {
			case 1:
				currentPage++;
				repaint();
				break;
			case 2:
				currentPage++;
				repaint();
				break;
			case 3:
				currentPage++;
				repaint();
				break;
			case 4:
				currentPage++;
				repaint();
				break;
			case 5:
				currentPage++;
				repaint();
				break;
			case 6:
				currentPage++;
				System.out.println("This should go to questions.");
				break;
			case 7:
				currentPage++;
				break;
			default:
				break;
			}
		}	
		// If backward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == BACKWARD) {
			switch (currentPage) {
			case 1:
				break;
			case 2:
				currentPage--;
				repaint();
				break;
			case 3:
				currentPage--;
				repaint();
				break;
			case 4:
				currentPage--;
				repaint();
				break;
			case 5:
				currentPage--;
				repaint();
				break;
			case 6:
				currentPage--;
				repaint();
				break;
			default:
				break;
			}
		}	
		else {
			theGame.changeLayoutCard("FOREST");
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
