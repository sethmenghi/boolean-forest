/**
 * FOREST PANEL CLASS
 * 
* DESCRIPTION:
* The ForestPanel class extends JPanel and is the layout that displays the
* Boolean Logic Forest with a path and markers for each level. 
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ForestPanel extends JPanel implements MouseListener {
	// Public static final members of ForestPanel class:
	public static final String LEVEL_1 = "Go to Level 1";	// text for Level 1 GameButton
	public static final String LEVEL_2 = "Go to Level 2";	// text for Level 2 GameButton
	public static final String LEVEL_3 = "Go to Level 3";	// text for Level 3 GameButton
	public static final String LEVEL_4 = "Go to Level 4";	// text for Level 4 GameButton
	public static final String LEVEL_5 = "Go to Level 5";	// text for Level 5 GameButton
	
	// Private static final members of ForestPanel class:
	private static final int PANEL_WIDTH = 640;			// width of panel
	private static final int PANEL_HEIGHT = 480;		// height of panel
	
	// Declare members of ForestPanel class:
	private Game theGame;								// reference to Game that instantiates ForestPanel object
	private BobsWindow forestBobsWindow;				// Bob's window for instructions/explanations
	private String bobsMessage;							// Bob's message
	private JTextArea textArea;
	private GameButton forestGameButton;				// button
	private Owl chloe;									// child Owl Chloe
	private Owl david;									// child Owl David
	
	/**
	 * CONSTRUCTOR: The constructor calls initForest() method.
	 * @param game
	 */
	public ForestPanel(Game game) {
		initForest(game);								// calls initForest()
	}
	
	/**
	 * METHOD: Initializes JPanel dimensions and members of ForestPanel
	 * class. Creates a reference to the Game object passed in and calls 
	 * overridden paintComponent() method.
	 * @param game
	 */
	private void initForest(Game game) {
		this.theGame = game;							// assign game to theGame to reference Game instance
		
		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
		
		// Initialize children Owl objects.
		david = new Owl(65, 395, "DAVID");				// set the coordinates of David for level 1
		chloe = new Owl(80, 410, "CHLOE");				// set the coordinates of Chloe for level 1
		
		bobsMessage = "Welcome! Help Chloe and David get through the Boolean Logic Forest. Get started by "
				+ "clicking the button below!";
		
		// Instantiate a BobsWindow with instructions to play Level 1.
		forestBobsWindow = new BobsWindow(BobsWindow.FOREST, bobsMessage);
		add(forestBobsWindow);
	}
	
	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image, children owls, the level markers and stars
	 * earned.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);						// call super method
		
		// Create new image icon and draw the background image.
		Image image = new ImageIcon("Images/LevelMapWithPath.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		paintOwl(g, david);								// paint david
		paintOwl(g, chloe);								// paint chloe
		
//		paintLevelMarkers(g);							// paint yellow level markers for passed levels
		paintStars(g);									// paint stars earned
		
		paintBobsWindow(g);
	}
	
	private void paintBobsWindow(Graphics g) {
		Image image = new ImageIcon("Images/ForestTextWindow.png").getImage();
		g.drawImage(image, forestBobsWindow.getXCoord(), forestBobsWindow.getYCoord(), null);
		Image bob = new ImageIcon("Images/Bob.png").getImage();
		g.drawImage(bob, forestBobsWindow.getBob().getXCoord(), forestBobsWindow.getBob().getYCoord(), null);
		
		addText();
		addButton();
	}
	
	private void addText() {
		if (textArea != null) {
			remove(textArea);
		}
		
		// http://stackoverflow.com/questions/4083322/how-can-i-create-a-jtextarea-with-a-specified-width-and-the-smallest-possible-hei/4083850#4083850
		String forestText = forestBobsWindow.getBobsMessage();
		textArea = new JTextArea();
		Font font = new Font("Verdana", Font.BOLD, 14);
		textArea.setFont(font);
		textArea.setForeground(new Color(12, 68, 159));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setOpaque(false);
		textArea.setSize(BobsWindow.FOREST_WIDTH - 20, BobsWindow.FOREST_HEIGHT - 20);
		textArea.setLocation(BobsWindow.FOREST_XCOORD + 10, BobsWindow.FOREST_YCOORD + 10);		
		textArea.setText(forestText);
		add(textArea);
	}
	
	private void addButton() {
		// Instantiate a GameButton to go on to Level 1.
		forestGameButton = new GameButton(LEVEL_1, "white");
		int boundsXCoord = BobsWindow.FOREST_XCOORD + BobsWindow.FOREST_WIDTH / 2 -
				forestGameButton.getPreferredSize().width / 2;
		int boundsYCoord = BobsWindow.FOREST_YCOORD + BobsWindow.FOREST_HEIGHT - 
				forestGameButton.getPreferredSize().height - 20;
		int boundsWidth = forestGameButton.getPreferredSize().width;
		int boundsHeight = forestGameButton.getPreferredSize().height;
		forestGameButton.setBounds(boundsXCoord, boundsYCoord, boundsWidth, boundsHeight);
		add(forestGameButton);
		forestGameButton.addMouseListener(this);
	}
	
	/**
	 * METHOD: Paints the Owl object passed in at it's x- and
	 * y-coordinates. Only applies to Chloe and David.
	 * @param g
	 * @param owl
	 */
	private void paintOwl(Graphics g, Owl owl) {
		Image owlImage;
		
		// Check to see if Owl is Chloe or David and draw the
		// corresponding resource.
		if (owl.getOwl() == Owl.CHLOE) {
			owlImage = new ImageIcon("Images/ChloeSmall.png").getImage();
			g.drawImage(owlImage, owl.getXCoord(), owl.getYCoord(), null);
		}
		else if (owl.getOwl() == Owl.DAVID) {
			owlImage = new ImageIcon("Images/DavidSmall.png").getImage();
			g.drawImage(owlImage, owl.getXCoord(), owl.getYCoord(), null);
		}
	}
	
	/**
	 * METHOD: Paints yellow markers to indicate a passed level.
	 * @param g
	 */
//	private void paintLevelMarkers(Graphics g) {
//		int gameLevel = theGame.getLevel();				// get the level of the game
//		
//		// Depending on the level of the game, draw the appropriate
//		// number of yellow level markers (yellow indicates passed level).
//		// Only case 1 will break. This way, for each level, it will
//		// continue to draw the level markers for all previous passed
//		// levels.
//		switch (gameLevel) {
//		case 5:
//			// draw marker 5
//		case 4:
//			// draw marker 4
//		case 3:
//			// draw marker 3
//		case 2:
//			// draw marker 2
//		case 1:
//			// draw marker 1
//			break;
//		default:
//			break;
//		}
//	}
		
	/**
	 * METHOD: Paints stars on bottom right of screen for each
	 * passed level.
	 * @param g
	 */
	private void paintStars(Graphics g) {
		int gameLevel = theGame.getLevel();				// get the level of the game
		
		// Depending on the level of the game, draw the appropriate
		// number of stars. Only case 1 will break. This way, for each
		// level, it will continue to draw the star earned for all previous
		// levels.
		switch (gameLevel) {
		case 5:
			// draw star 5
		case 4:
			// draw star 4
		case 3:
			// draw star 3
		case 2:
			// draw star 2
		case 1:
			// draw star 1
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("This should go to Level 1 Layout.");	
		
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