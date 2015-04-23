/**
 * INTRO PANEL CLASS
 * 
 * DESCRIPTION:
 * The IntroPanel class extends JPanel and is the layout that displays the
 * introduction screen with brief introduction text and instructions. 
 *    
 * SOURCES:
 * 
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
public class IntroPanel extends JPanel implements MouseListener {
	// Public static final members of IntroPanel class:
	public static final String PLAY_GAME = "Let's go learn some boolean logic!";		// text for Play GameButton
	public static final String TEACHER = "Teachers & Parents";
	
	// Private static final members of IntroPanel class:
	private static final int PANEL_WIDTH = 640;			// width of panel
	private static final int PANEL_HEIGHT = 480;		// height of panel
	private static final String INSTRUCTION_TEXT = "Welcome to the Boolean "
			+ "Logic Forest! This is my family: Alice, my wife and our two "
			+ "children, David and Chloe. Our children need to get through "
			+ "the Boolean Logic Forest and need your help! Let's go on an "
			+ "adventure!";
	
	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates IntroPanel object
	private BobsWindow introBobsWindow;					// Bob's window for introduction instructions
	private JTextArea textArea;
	private GameButton introScreenButton;
	private GameButton teacherButton;
	
	/**
	 * CONSTRUCTOR: The constructor calls initIntro() method.
	 * @param game
	 */
	public IntroPanel(Game game) {
		initIntro(game);								// call initIntro()
	}
	
	/**
	 * METHOD: Initializes JPanel dimensions and members of ForestPanel
	 * class. Creates a reference to the Game object passed in and calls 
	 * overridden paintComponent() method.
	 * @param game
	 */
	private void initIntro(Game game) {
		this.theGame = game;							// assign game to theGame to reference Game instance
		
		// Set the dimensions of the JPanel.
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
		
		// Instantiate a BobsWindow with introduction text and instructions.
		introBobsWindow = new BobsWindow(BobsWindow.INTRO, INSTRUCTION_TEXT);
		add(introBobsWindow);
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
		Image image = new ImageIcon("Images/IntroScreen.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		paintBobsWindow(g);
	}	
	
	private void addTeacherButton() {
		teacherButton = new GameButton(TEACHER, "white");
		int boundsXCoord = 468;
		int boundsYCoord = 426;
		int boundsWidth = teacherButton.getPreferredSize().width;
		int boundsHeight = teacherButton.getPreferredSize().height;
		teacherButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(teacherButton);
		teacherButton.addMouseListener(this);
	}
	
	private void paintBobsWindow(Graphics g) {
		Image image = new ImageIcon("Images/IntroTextWindow.png").getImage();
		g.drawImage(image, introBobsWindow.getXCoord(), introBobsWindow.getYCoord(), null);
		Image bob = new ImageIcon("Images/Bob.png").getImage();
		g.drawImage(bob, introBobsWindow.getBob().getXCoord(), introBobsWindow.getBob().getYCoord(), null);
		
		addText();
		addButton();
		addTeacherButton();
	}
	
	private void addText() {
		if (textArea != null) {
			remove(textArea);
		}
		
		String introText = introBobsWindow.getBobsMessage();
		textArea = new JTextArea();
		Font font = new Font("Verdana", Font.BOLD, 14);
		textArea.setFont(font);
		textArea.setForeground(new Color(12, 68, 159));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setSize(BobsWindow.INTRO_WIDTH - 20, BobsWindow.INTRO_HEIGHT - 20);
		textArea.setLocation(BobsWindow.INTRO_XCOORD + 10, BobsWindow.INTRO_YCOORD + 10);
		textArea.setText(introText);
		add(textArea);
	}
	
	private void addButton() {
		introScreenButton = new GameButton(PLAY_GAME, "white");
		int boundsXCoord = BobsWindow.INTRO_XCOORD + BobsWindow.INTRO_WIDTH / 2 -
				introScreenButton.getPreferredSize().width / 2;
		int boundsYCoord = BobsWindow.INTRO_YCOORD + BobsWindow.INTRO_HEIGHT - 
				introScreenButton.getPreferredSize().height - 20;
		int boundsWidth = introScreenButton.getPreferredSize().width;
		int boundsHeight = introScreenButton.getPreferredSize().height;
		introScreenButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(introScreenButton);
		introScreenButton.addMouseListener(this);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Here");
		GameButton source = (GameButton) e.getSource();
		System.out.println(source.getButtonMessage());
		if (source.getButtonMessage() == PLAY_GAME) {
			theGame.changeLayoutCard(Game.FOREST);
			
		}
		else if (source.getButtonMessage()==TEACHER) {
			theGame.changeLayoutCard("Teacher");
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