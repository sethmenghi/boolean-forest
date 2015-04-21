package BooleanForest;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * The Forest of Boolean Logic: An Adventure
 * 
 * TODO Pretty sure we need the honor statement here and other things
 */

@SuppressWarnings("serial")
public class Game extends JApplet {

	// Declare variables
	public JPanel cards;
	private Dimension windowSize;
	private int level;
	
	/**
	 * init()
	 * 
	 * Default initialization method; calls create GUI on a new thread
	 */
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		}
		catch(Exception e) {
			System.err.println("createGUI did not complete successfully");
		}
	}
	
	/**
	 * createGUI()
	 * 
	 * Initializes applet with size and card layout
	 */
	public void createGUI() {
		
		// Set window size to 640x480
		windowSize = new Dimension(640,480);
	    setPreferredSize(windowSize);
	    setMinimumSize(windowSize);
	    setMaximumSize(windowSize);
	    setSize(windowSize);
		
	    // Create card layout, add to applet
		cards = new JPanel(new CardLayout());
		add(cards);
		
		// Create Intro screen, add to layout
		//IntroPanel introScreen = new IntroPanel(this);
		//cards.add(introScreen, "Intro");
		
		// Create Forest level map, add to layout
		//ForestPanel levelMap = new ForestPanel(this);
		//cards.add(levelMap, "Forest");
		
		// Create Forest level map, add to layout
		LevelOne levelOne = new LevelOne(this);
		cards.add(levelOne, "Level One");
				
		LevelTwo levelTwo = new LevelTwo();
		//cards.add(levelTwo, "Level Two");
		
		LevelThree levelThree = new LevelThree();
		//cards.add(levelThree, "Level Three");
		
		LevelFour levelFour = new LevelFour();
		//cards.add(levelFour, "Level Four");
		
		LevelFive levelFive = new LevelFive();
		//cards.add(levelFive, "Level Five");
		
		// Set level to 1, initially
		level = 1;
	}
	
	/**
	 * changeLayoutCard()
	 * 
	 * Changes the front card on the layout
	 * 
	 * @param whichCard
	 */
	public void changeLayoutCard(String whichCard) {
		// Get the card layout
		CardLayout layout = (CardLayout) (cards.getLayout());
		
		// Flip the desired card to the front
		layout.show(cards, whichCard);
	}
	
	/**
	 * incrementLevel()
	 * 
	 * Increments the level of the game
	 * 
	 * @param level
	 */
	public void incrementLevel() {
		level++;
	}
	
	/**
	 * getLevel()
	 * 
	 * Gets the level of the game
	 * 
	 * @return level
	 */
	public int getLevel() {
		return level;
	}
}
