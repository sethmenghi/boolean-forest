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
import Levels.LevelFive;
import Levels.LevelFour;
import Levels.LevelOne;
import Levels.LevelThree;
import Levels.LevelTwo;
import Objects.GameButton;

@SuppressWarnings("serial")
public class LevelPanel extends JPanel implements Panel, MouseListener {
	private static final String FORWARD = ">>";			// text for forward button
	private static final String BACKWARD = "<<";		// text for backward button
	private static final String BACK = "Back to forest";// text for back to forestPanel

	private static final int LEVEL_WIDTH = 420;			// width of LevelPanel BobsWindow
	private static final int LEVEL_HEIGHT = 433;		// height of LevelPanel BobsWindow
	private static final int LEVEL_XCOORD = 22;			// pre-determined xCoord of LevelPanel BobsWindow
	private static final int LEVEL_YCOORD = 24;			// pre-determined yCoord of LevelPanel BobsWindow
	private static final int BOB_XCOORD = 464;			// pre-determined xCoord of LevelPanel Bob
	private static final int BOB_YCOORD = 304;			// pre-determined yCoord of LevelPanel Bob


	private static final int FORWARD_XCOORD = LEVEL_XCOORD + LEVEL_WIDTH - 50;
	private static final int FORWARD_YCOORD = LEVEL_YCOORD + LEVEL_HEIGHT - 40;
	private static final int BACKWARD_XCOORD = LEVEL_XCOORD + LEVEL_WIDTH - 100;
	private static final int BACKWARD_YCOORD = LEVEL_YCOORD + LEVEL_HEIGHT - 40;

	private Game theGame;								// reference to Game that instantiates LevelPanel object
	private int theLevel;								// the current level passed in theGame
	private JTextArea bobsTextArea1;					// JTextArea for Bob's Window
	private JTextArea bobsTextArea2;					// JTextArea for Bob's Window (if there are two statements)
	private int currentPage;							// current page being shown for explanations
	private GameButton backButton;						// back to forestPanel button
	private GameButton forwardButton;					// forward button
	private GameButton backwardButton;					// backward button

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

		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		currentPage = 1;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);										// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/Backgrounds/LevelBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);

		Image bobImage = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bobImage, BOB_XCOORD, BOB_YCOORD, null);

		// Add text and button.
		addText(g);														// add text
		addButtons();													// add buttons
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
		switch(theGame.getLevel()) {
		case 0:
			showLevelOneContent(g);
			break;
		case 4:
			showLevelFiveContent(g);
			break;
		default:
			showLevelContent(g, theGame.getLevel());
			break;
		}
	}

	private void showLevelOneContent(Graphics g) {
		String levelTextOne = "";										// String for first line of text
		String levelTextTwo = "";										// String for second line of text

		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea1 != null ) {
			remove(bobsTextArea1);
		}
		if (bobsTextArea2 != null) {
			remove(bobsTextArea2);
		}

		// If page 1 or 4 of explanation, it is a topic String so paint with
		// topic font style.
		if (currentPage == 1 || currentPage == 4) {
			if (currentPage == 1) {
				levelTextOne = LevelOne.PAGE_TRUE;						// get the first page from LevelOne class
			}
			else {
				levelTextOne = LevelOne.PAGE_FALSE;						// get the fourth page from LevelOne class
			}		

			// Create a JTextArea to fit inside white text window with custom font
			// and transparent background. Add JTextArea to the JPanel.
			bobsTextArea1 = new JTextArea();							// initialize the JTextArea
			bobsTextArea1.setFont(Game.TOPICS_FONT);					// set the font
			bobsTextArea1.setForeground(Game.DARK_BLUE);				// set font color
			bobsTextArea1.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea1.setSize(LEVEL_WIDTH - 20, 150);
			bobsTextArea1.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 120);
			bobsTextArea1.setText(levelTextOne);						// set the text
			add(bobsTextArea1);											// add to LevelPanel		
		}
		// All other pages of explanation are statements with images.
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
			else if (currentPage == 6) {
				levelTextOne = LevelOne.PAGE_FALSE_B;					// get the sixth page from LevelOne class
				g.drawImage(LevelOne.PINK, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
				levelTextTwo = LevelOne.FALSE_STATEMENT;				// get the second line of text
			}

			// Create JTextAreas to fit inside white text window with custom font
			// and transparent background. Add JTextAreas to the JPanel.
			bobsTextArea1 = new JTextArea();							// initialize the JTextArea
			bobsTextArea1.setFont(Game.LESSON_STATEMENT);				// set the font
			bobsTextArea1.setForeground(Game.LIGHT_BLUE);				// set font color
			bobsTextArea1.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea1.setSize(LEVEL_WIDTH - 20, 50);
			bobsTextArea1.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 30);
			bobsTextArea1.setText(levelTextOne);							// set the text
			add(bobsTextArea1);											// add to LevelPanel

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

	private void showLevelContent(Graphics g, int level) {
		System.out.println("Level: "+level);	

		
		String levelTextOne = "";										// String for first line of text
		String levelTextTwo = "";										// String for second line of text

		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea1 != null ) {
			remove(bobsTextArea1);
		}
		if (bobsTextArea2 != null) {
			remove(bobsTextArea2);
		}

		// If page 1 of explanation, it is a topic String so paint with topic
		// font style.
		if (currentPage == 1) {
			if (level == 1) {
				levelTextOne = LevelTwo.PAGE_AND;						// get the first page from LevelTwo class
			}
			else if (level == 2) {
				levelTextOne = LevelThree.PAGE_OR;						// get the first page from LevelThree class
			}
			else {
				levelTextOne = LevelFour.PAGE_NOT;						// get the first page from LevelFour class
			}

			// Create JTextAreas to fit inside white text window with custom font
			// and transparent background. Add JTextAreas to the JPanel.
			bobsTextArea1 = new JTextArea();							// initialize the JTextArea
			bobsTextArea1.setFont(Game.TOPICS_FONT);					// set the font
			bobsTextArea1.setForeground(Game.DARK_BLUE);				// set font color
			bobsTextArea1.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea1.setSize(LEVEL_WIDTH - 20, 150);
			bobsTextArea1.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 120);
			bobsTextArea1.setText(levelTextOne);						// set the text
			add(bobsTextArea1);											// add to LevelPanel		
		}
		// All other pages of explanation are statements with images.
		else {
			if (currentPage == 2) {
				// Get resources for Level 2.
				if (level == 1) {
					levelTextOne = LevelTwo.PAGE_TRUE_A;
					g.drawImage(LevelTwo.DOG, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelTwo.TRUE_STATEMENT;
				}
				// Get resources for Level 3.
				else if (level == 2) {
					levelTextOne = LevelThree.PAGE_TRUE_A;
					g.drawImage(LevelThree.DONUT, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelThree.TRUE_STATEMENT;
				}
				// Get resources for Level 4.
				else if (level == 3) {
					levelTextOne = LevelFour.PAGE_TRUE_A;
					g.drawImage(LevelFour.PUMPKIN, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelFour.TRUE_STATEMENT;
				}
			}
			else if (currentPage == 3) {
				// Get resources for Level 2.
				if (level == 1) {
					levelTextOne = LevelTwo.PAGE_TRUE_B;
					g.drawImage(LevelTwo.TEDDY_BEAR, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelTwo.TRUE_STATEMENT;
				}
				// Get resources for Level 3.
				else if (level == 2) {
					levelTextOne = LevelThree.PAGE_TRUE_B;
					g.drawImage(LevelThree.FLOWER, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelThree.TRUE_STATEMENT;
				}
				// Get resources for Level 4.
				else if (level == 4) {
					levelTextOne = LevelFour.PAGE_TRUE_B;
					g.drawImage(LevelFour.ALIEN, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelFour.TRUE_STATEMENT;
				}
			}
			else if (currentPage == 4) {
				// Get resources for Level 2.
				if (level == 1) {
					levelTextOne = LevelTwo.PAGE_FALSE_A;
					g.drawImage(LevelTwo.DUCK, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelTwo.FALSE_STATEMENT;
				}
				// Get resources for Level 3.
				else if (level == 2) {
					levelTextOne = LevelThree.PAGE_FALSE_A;
					g.drawImage(LevelThree.PENCIL, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelThree.FALSE_STATEMENT;
				}
				// Get resources for Level 4.
				else if (level == 3) {
					levelTextOne = LevelFour.PAGE_FALSE_A;
					g.drawImage(LevelFour.HEART, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelFour.FALSE_STATEMENT;
				}
			}
			else if (currentPage == 5) {
				// Get resources for Level 2.
				if (level == 1) {
					levelTextOne = LevelTwo.PAGE_FALSE_B;
					g.drawImage(LevelTwo.CUPCAKE, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelTwo.FALSE_STATEMENT;
				}
				// Get resources for Level 3.
				else if (level == 2) {
					levelTextOne = LevelThree.PAGE_FALSE_B;
					g.drawImage(LevelThree.COOKIE, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelThree.FALSE_STATEMENT;
				}
				// Get resources for Level 4.
				else if (level == 3) {
					levelTextOne = LevelFour.PAGE_FALSE_B;
					g.drawImage(LevelFour.RAIN, LEVEL_XCOORD + 50, LEVEL_YCOORD + 80, null);
					levelTextTwo = LevelFour.FALSE_STATEMENT;
				}
			}

			// Create JTextAreas to fit inside white text window with custom font
			// and transparent background. Add JTextAreas to the JPanel.
			bobsTextArea1 = new JTextArea();							// initialize the JTextArea
			bobsTextArea1.setFont(Game.LESSON_STATEMENT);				// set the font
			bobsTextArea1.setForeground(Game.LIGHT_BLUE);				// set font color
			bobsTextArea1.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea1.setSize(LEVEL_WIDTH - 20, 50);
			bobsTextArea1.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 30);
			bobsTextArea1.setText(levelTextOne);						// set the text
			add(bobsTextArea1);											// add to LevelPanel

			bobsTextArea2 = new JTextArea();							// initialize the JTextArea
			bobsTextArea2.setFont(Game.SMALL_STATEMENT);				// set the font
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

	private void showLevelFiveContent(Graphics g) {
		String levelTextOne = "";										// String for first line of text
		String levelTextTwo = "";										// String for second line of text

		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea1 != null ) {
			remove(bobsTextArea1);
		}
		if (bobsTextArea2 != null) {
			remove(bobsTextArea2);
		}

		// Show only page of content for explanation.
		levelTextOne = LevelFive.LEVEL_5_INTRO;	

		// Create a JTextArea to fit inside white text window with custom font
		// and transparent background. Add JTextArea to the JPanel.
		bobsTextArea1 = new JTextArea();							// initialize the JTextArea
		bobsTextArea1.setFont(Game.LESSON_STATEMENT);				// set the font
		bobsTextArea1.setForeground(Game.DARK_BLUE);				// set font color
		bobsTextArea1.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea1.setSize(LEVEL_WIDTH - 20, 150);
		bobsTextArea1.setLocation(LEVEL_XCOORD + 50, LEVEL_YCOORD + 120);
		bobsTextArea1.setText(levelTextOne);						// set the text
		add(bobsTextArea1);											// add to LevelPanel		
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

		if (theGame.getLevel() == 5)
			setMousePressedLevelFive(source);
		else
			setMousePressedLevel(source);
	}

	private void setMousePressedLevel(GameButton source) {
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
				switch (theGame.getLevel()) {
				case 1:
					theGame.levelTwo.startLevel();
					theGame.changeLayoutCard("TEXT_QUESTION");
					System.out.println("This should go to questions.");
					break;
				case 2:
					theGame.levelThree.startLevel(); 
					theGame.changeLayoutCard("TEXT_QUESTION");
					System.out.println("This should go to questions.");
					break;
				case 3:
					theGame.levelFour.startLevel(); 
					theGame.changeLayoutCard("TEXT_QUESTION");
					System.out.println("This should go to questions.");
					break;
				default:
					break;
				}
				currentPage++;
				repaint();
				break;
			case 6:
				theGame.levelOne.startLevel(); 
				theGame.changeLayoutCard("TEXT_QUESTION");
				System.out.println("This should go to questions.");
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

	private void setMousePressed(GameButton source, int level) {
		// If back button is clicked, go back to IntroPanel.
		
		System.out.println("this is source" + source);
		System.out.println("this is level" + level);
		
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
				//theGame.levelTwo.startLevel(); 
				//theGame.changeLayoutCard("TEXT_QUESTION");
				
				System.out.println("This should go to questions.");
				System.out.println("This should go to questions.");
				System.out.println("HERE???");
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
			default:
				break;
			}
		}	
		else {
			theGame.changeLayoutCard("FOREST");
		}
	}

	private void setMousePressedLevelFive(GameButton source) {
		// If back button is clicked, go back to IntroPanel.
		if (source.getButtonMessage() == FORWARD) {
			System.out.println("This should go to questions.");
		}	
		// If backward button is clicked in instructions, change text.
		else if (source.getButtonMessage() == BACKWARD) {
			// Does nothing.
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
