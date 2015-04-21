/**
 * Project 4:  Boolean Logic Forest Applet
 * Names:      Julia Hockett, Leslie Kim, Megan Martin, Seth Menghi,
 *             Marcus Stromeyer
 * E-mails:    jlh279@georgetown.edu, lk584@georgetown.edu,
 *             mtm96@georgetown.edu, swm36@georgetown.edu,
 *             mls267@georgetown.edu
 * Instructor: Singh
 * COSC 150
 *
 * In accordance with the class policies and Georgetown's Honor Code,
 * we certify that, with the exceptions of the lecture notes and those
 * items noted below, we have neither given nor received any assistance
 * on this project.
 *
 * DESCRIPTION:
 * This interactive applet is intended to be a teaching tool for first
 * to third graders which aid in educating children the basics of Boolean
 * logic in an interactive, fun and self-explanatory way.
 * 
 * When the applet is started, the student is greeted by a family of owls.
 * An Owl named Bob will interact with the student. The student needs to
 * help the children owls get through the Boolean Logic Forest by learning
 * the Boolean concepts explained by Bob and playing the levels to pass
 * the level. The student must get an 75% (on levels with 4 questions) or
 * an 80% (on levels with 5 questions) to pass. If the student passes,
 * (s)he will move  on to the next level (5 levels total). If the student
 * fails, (s)he must replay the level and pass.
 * 
 * A card layout is used to switch between layouts. The initial layout is
 * an introduction screen (IntroPanel). There is a layout that contains the
 * level map where the student passes each level to get through the Boolean
 * Logic Forest (ForestPanel). There is also a layout that will display the
 * questions for each level (QuestionPanel). The final layout is for the
 * teacher/parent's page which explains the applet to the teacher/parent
 * (TeachersPanel).
 * 
 * Once the student helps the children owls pass Level 5, a certificate of
 * completion will be displayed.
 * 
 * The three over-arching objectives of this apple are:
 * 1) The applet is fun/interactive
 * 2) Increases awareness for computer science
 * 3) Kids should be able to go through this game with minimal or no help
 *    from a teacher/parent
 *    
 * SOURCES:
 * 
 */

package BooleanForest;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Game extends JApplet {
	// Private static final members of Game class:
	private static final int APPLET_WIDTH = 640;			// width of applet
	private static final int APPLET_HEIGHT = 480;			// height of applet

	// Declare members of Game class:
	public JPanel cards;									// JPanel member
	private Dimension windowSize;							// dimensions of JPanel
	private int level;										// current level
	
	/**
	 * CONSTRUCTOR: The constructor calls the init() function.
	 * @param none
	 */
	public Game() {
		init();												// call init()
	}

	/**
	 * SETTER: Sets the level of the game.
	 * param level
	 */
	public void setLevel(int level) {
		this.level = level;									// set the level of the game
	}
	
	/**
	 * GETTER: Returns the level of the game.
	 * @return level
	 */
	public int getLevel() {
		return level;										// return the level of the game
	}
	
	/**
	 * METHOD: Increments the level of the game.
	 * @param none
	 */
	public void incrementLevel() {
		// Only increment the level if private member level is between
		// 1 and 4.
		if (level >= 0 && level < 5) {
			level++;
		}
		// Otherwise, there is something wrong and output error message.
		else {
			System.out.println("ERROR: Invalid level.");
		}
	}

	/**
	 * METHOD: Initializes applet by creating a new thread which will
	 * call createGUI().
	 * @param none
	 */
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {	// create new thread
				public void run() {
					createGUI();
				}
			});
		}
		
		catch(Exception error) {
			// Print error message if createGUI() does not complete successfully.
			System.err.println("ERROR: createGUI() did not complete successfully.");
		}
	}

	/**
	 * METHOD: Initializes applet with specified size and card layout.
	 * @param none
	 */
	public void createGUI() {
		// Set panel size to 640 x 480.
		windowSize = new Dimension(APPLET_WIDTH, APPLET_HEIGHT);
		setPreferredSize(windowSize);
		setMinimumSize(windowSize);
		setMaximumSize(windowSize);
		setSize(windowSize);

		// Create card layout and add to applet.
		cards = new JPanel(new CardLayout());
		add(cards);
		
		// Create Intro layout and add to cards.
		IntroPanel introLayout = new IntroPanel(this);
		cards.add(introLayout, "Intro");

		// Create Forest layout and add to cards.
		ForestPanel forestLayout = new ForestPanel(this);
		cards.add(forestLayout, "Forest");
		
//		// Create Question layout and add to cards.
//		QuestionPanel questionLayout = new QuestionPanel(this);
//		cards.add(questionLayout, "Question");
		
//		// Create Teacher layout and add to cards.
//		TeacherPanel teacherLayout = new TeacherPanel(this);
//		cards.add(teacherLayout, "Teacher");
		
		
		level = 0;											// set the level to 0
		cards.setVisible(true);								// make cards visible
		
		
		

		// ARE THESE NEEDED? SHOULD THERE BE A QUESTION LAYOUT AND DEPENDING ON THE LEVEL
		// DIFFERENT LEVEL QUESTIONS ARE DISPLAYED? THE LAYOUTS FOR REACH LEVEL SHOULD
		// BE THE SAME...
		
//		// Create Forest level map, add to layout
//		LevelOne levelOne = new LevelOne(this);
//		cards.add(levelOne, "Level One");
//
//		LevelTwo levelTwo = new LevelTwo();
//		//cards.add(levelTwo, "Level Two");
//
//		LevelThree levelThree = new LevelThree();
//		//cards.add(levelThree, "Level Three");
//
//		LevelFour levelFour = new LevelFour();
//		//cards.add(levelFour, "Level Four");
//
//		LevelFive levelFive = new LevelFive();
//		//cards.add(levelFive, "Level Five");
	}

	/**
	 * METHOD: Changes the layout that is current being shown to the
	 * parameter passed in.
	 * @param layoutToChangeTo
	 */
	public void changeLayoutCard(String layoutToChangeTo) {
		// Get the card layout.
		CardLayout layout = (CardLayout) (cards.getLayout());

		// Flip the desired card to the front.
		layout.show(cards, layoutToChangeTo);
	}
}