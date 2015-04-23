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
	// Public static final members of TeacherPanel class:
	public static final String BACK = "Go back";
	private static final int TEACHER_BUTTON_YCOORD = 200;
	
	
	// Private static final members of IntroPanel class:
	private static final int PANEL_WIDTH = 640;			// width of panel
	private static final int PANEL_HEIGHT = 480;		// height of panel
	private static final String TEACHER_TEXT = "Welcome to the Boolean "
			+ "Logic Forest! This is a simple interactive game for students "
			+ "in grades 1 - 3. Computer science is becoming a more and more "
			+ "relevant matter as technology becomes exponentially "
			+ "integrated in our lives. Developing skills that would help "
			+ "students eventually further our ability to utilize technology "
			+ "can start at a young age. Understanding the concepts of Boolean "
			+ "Logic from the computer science perspective such as TRUE and "
			+ "FALSE, AND and OR can be taught at a young age. The game itself "
			+ "should be relatively self-explanatory to your student. Some may "
			+ "need a help with reaading. Bob (the father owl) will explain a "
			+ "concept to your student and then a series of questions will need "
			+ "to be answered based on the concept. To pass the level, the "
			+ "student must get at least 75% correct. The student has two "
			+ "chances to answer each question by dragging and dropping one of "
			+ "the children owls (Chloe and David) on the appropriate answer. "
			+ "Hope your student enjoys the game!";
	
	// Declare members of IntroPanel class:
	private Game theGame;								// reference to Game that instantiates IntroPanel object
	private BobsWindow teacherBobsWindow;					// Bob's window for introduction instructions
	private JTextArea textArea;
	private GameButton backButton;
	
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
		
		paintBobsWindow(g);
	}	
	
	private void addBackButton() {
		backButton = new GameButton(BACK, "white");
		int boundsXCoord = BobsWindow.TEACHER_XCOORD / 2 - backButton.getPreferredSize().width / 2;
		int boundsYCoord = TEACHER_BUTTON_YCOORD;
		int boundsWidth = backButton.getPreferredSize().width;
		int boundsHeight = backButton.getPreferredSize().height;
		backButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(backButton);
		backButton.addMouseListener(this);
	}
	
	private void paintBobsWindow(Graphics g) {
		Image image = new ImageIcon("Images/TeacherTextWindow.png").getImage();
		g.drawImage(image, teacherBobsWindow.getXCoord(), teacherBobsWindow.getYCoord(), null);
		Image bob = new ImageIcon("Images/Bob.png").getImage();
		g.drawImage(bob, teacherBobsWindow.getBob().getXCoord(), teacherBobsWindow.getBob().getYCoord(), null);
		
		addText();
		addBackButton();
	}
	
	private void addText() {
		if (textArea != null) {
			remove(textArea);
		}
		
		String introText = teacherBobsWindow.getBobsMessage();
		textArea = new JTextArea();
		Font font = new Font("Verdana", Font.BOLD, 14);
		textArea.setFont(font);
		textArea.setForeground(new Color(12, 68, 159));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setSize(BobsWindow.TEACHER_WIDTH - 20, BobsWindow.TEACHER_HEIGHT - 20);
		textArea.setLocation(BobsWindow.TEACHER_XCOORD + 10, BobsWindow.TEACHER_YCOORD + 10);
		textArea.setText(introText);
		add(textArea);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		theGame.changeLayoutCard(Game.INTRO);
		
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
