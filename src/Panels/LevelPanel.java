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
import Levels.LevelOne;
import Objects.BobsWindow;
import Objects.GameButton;

@SuppressWarnings("serial")
public class LevelPanel extends JPanel implements Panel, MouseListener {
	private static final String FORWARD = ">>";										// text for forward button
	private static final String BACKWARD = "<<";									// text for backward button
	private static final int FORWARD_XCOORD = BobsWindow.LEVEL_XCOORD + BobsWindow.LEVEL_WIDTH - 50;
	private static final int FORWARD_YCOORD = BobsWindow.LEVEL_YCOORD + BobsWindow.LEVEL_HEIGHT - 40;
	private static final int BACKWARD_XCOORD = BobsWindow.LEVEL_XCOORD + BobsWindow.LEVEL_WIDTH - 100;
	private static final int BACKWARD_YCOORD = BobsWindow.LEVEL_YCOORD + BobsWindow.LEVEL_HEIGHT - 40;
	
	private Game theGame;
	private int level;
	private BobsWindow levelBobsWindow;
	private JTextArea bobsTextArea;						// JTextArea for Bob's Window
	private String currentShownText;
	private int currentPage;
	private GameButton forwardButton;
	private GameButton backwardButton;
	
	public LevelPanel(Game game, int levelToPlay) {
		initPanel(game, levelToPlay);
	}

	@Override
	public void initPanel(Game game) {
		// TODO Auto-generated method stub
	}
	
	public void initPanel(Game game, int levelToPlay) {
		this.theGame = game;
		this.level = levelToPlay;
		
		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		currentPage = 1;
		currentShownText = LevelOne.PAGE_TRUE;
		
		// Initialize a BobsWindow with introduction text and instructions.
		levelBobsWindow = new BobsWindow("LEVEL", currentShownText);
		add(levelBobsWindow);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/Backgrounds/LevelBackground.jpg").getImage();
		g.drawImage(image, 0, 0, null);

		// Paint various components on the screen.
		paintBobsWindow(g);											// paint Bob's Window and Bob
	}
	
	@Override
	public void paintBobsWindow(Graphics g) {
		// Draw the white background for Bob's Window.
		Image image = new ImageIcon("Images/TextWindows/LevelTextWindow.png").getImage();
		g.drawImage(image, levelBobsWindow.getXCoord(), levelBobsWindow.getYCoord(), null);

		// Draw Bob.
		Image bob = new ImageIcon("Images/Owls/Bob.png").getImage();
		g.drawImage(bob, levelBobsWindow.getBob().getXCoord(), levelBobsWindow.getBob().getYCoord(), null);

		// Add text and button.
		addText();													// add text to Bob's Window
		addButtons();												// add button to Bob's Window
	}

	@Override
	public void addText() {
		// If the JTextArea is not null, remove it from the JPanel.
		if (bobsTextArea != null) {
			remove(bobsTextArea);									// remove from TeacherPanel
		}

		addTitleText();												// add title
		addParagraphText();											// add paragraph
	}

	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void addParagraphText() {
		if (bobsTextArea != null) {
			remove(bobsTextArea);
		}
		
		// Create a JTextArea to fit inside Bob's Window with wrapped text,
		// custom font and transparent background. Add JTextArea to the JPanel.
		if (currentPage == 1) {
		String levelText = levelBobsWindow.getBobsMessage();		// get the message from levelBobsWindow
		bobsTextArea = new JTextArea();								// initialize the JTextArea
		bobsTextArea.setFont(Game.TOPICS_FONT);						// set the font
		bobsTextArea.setForeground(Game.DARK_BLUE);					// set font color
		bobsTextArea.setOpaque(false);								// set background to transparent
		// Set the size and location of the text to have margin of 10 pixels
		// from the edge of the white background. 
		bobsTextArea.setSize(BobsWindow.LEVEL_WIDTH - 20, 150);
		bobsTextArea.setLocation(BobsWindow.LEVEL_XCOORD + 50, BobsWindow.LEVEL_YCOORD + 120);
		bobsTextArea.setText(levelText);							// set the text
		add(bobsTextArea);											// add to LevelPanel		
		}
		else if (currentPage == 2) {
			levelBobsWindow.setBobsMessage(LevelOne.PAGE_TRUE_A);
			String levelText = levelBobsWindow.getBobsMessage();		// get the message from levelBobsWindow
			bobsTextArea = new JTextArea();								// initialize the JTextArea
			bobsTextArea.setFont(Game.LESSON_STATEMENT);						// set the font
			bobsTextArea.setForeground(Game.LIGHT_BLUE);					// set font color
			bobsTextArea.setOpaque(false);								// set background to transparent
			// Set the size and location of the text to have margin of 10 pixels
			// from the edge of the white background. 
			bobsTextArea.setSize(BobsWindow.LEVEL_WIDTH - 20, 50);
			bobsTextArea.setLocation(BobsWindow.LEVEL_XCOORD + 50, BobsWindow.LEVEL_YCOORD + 50);
			bobsTextArea.setText(levelText);							// set the text
			add(bobsTextArea);											// add to LevelPanel
			
//			g.drawImage(LevelOne.PENGUIN, )
		}
	}

	@Override
	public void addButtons() {
		addForwardAndBackwardButtons();								// add forward and backward buttons	
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
				showPage2();
				break;
			case 2:
				showPage3();
				break;
			case 3:
				showPage4();
				break;
			case 4:
				showPage5();
				break;
			case 5:
				showPage6();
				break;
			case 6:
				goToQuestion();
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
				showPage1();
				break;
			case 3:
				showPage2();
				break;
			case 4:
				showPage3();
				break;
			case 5:
				showPage4();
				break;
			case 6:
				showPage5();
				break;
			default:
				break;
			}
		}	
	}
	
	private void showPage1() {
		
	}
	
	private void showPage2() {
		currentPage = 2;
		
//		String levelText = LevelOne.PAGE_TRUE_A;		// get the message from levelBobsWindow
//		JTextArea newbobsTextArea = new JTextArea();								// initialize the JTextArea
//		newbobsTextArea.setFont(Game.LESSON_STATEMENT);						// set the font
//		newbobsTextArea.setForeground(Game.LIGHT_BLUE);					// set font color
//		newbobsTextArea.setOpaque(false);								// set background to transparent
//		// Set the size and location of the text to have margin of 10 pixels
//		// from the edge of the white background. 
//		newbobsTextArea.setSize(BobsWindow.LEVEL_WIDTH - 20, 50);
//		newbobsTextArea.setLocation(BobsWindow.LEVEL_XCOORD + 10, BobsWindow.LEVEL_YCOORD + 10);
//		newbobsTextArea.setText(levelText);							// set the text
//		add(newbobsTextArea);											// add to LevelPanel
//		
//		
//		
		repaint();
	}
	
	private void showPage3() {
		
	}
	
	private void showPage4() {
		
	}
	
	private void showPage5() {
		
	}
	
	private void showPage6() {
		
	}
	
	private void goToQuestion() {
		
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
