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
 * The organization of this project is that the Game class of the
 * BooleanForest package is the "controller" of the game. The overall level
 * of the game is handled here, which will keep the ForestPanel updated.
 * The Levels packages includes Level classes, which essentially declares
 * the content for each level of the game. The Objects package contain
 * classes that are objects used throughout the game. The Panels package
 * contains different Panels that make up the CardLayout in the Game class.
 * Panel is an interface which is implemented by each type of panel. The
 * Questions package contains a Question interface which is implemented
 * by each of the two Question types.
 *    
 * SOURCES:
 * 
 */

package BooleanForest;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Panels.*;
import Questions.*;
import Levels.*;

@SuppressWarnings("serial")
public class Game extends JApplet {
	// Public static final members of Game class:
	public static final int APPLET_WIDTH = 640;										// width of applet
	public static final int APPLET_HEIGHT = 480;									// height of applet
	public static final Font TITLE_FONT = new Font("Verdana", Font.BOLD, 14);		// font used for titles
	public static final Font PARAGRAPH_FONT = new Font("Verdana", Font.PLAIN, 12);	// font used for paragraph text
	public static final Font TOPICS_FONT = new Font("Verdana", Font.BOLD, 100);		// used for lesson topics
	public static final Font LESSON_STATEMENT = new Font("Verdana", Font.PLAIN, 20);// used for lesson statements
	public static final Color DARK_BLUE = new Color(12, 68, 159);					// color used for titles
	public static final Color LIGHT_BLUE = new Color(57, 119, 222);					// color used for paragraph text
	
	public static final String INTRO = "INTRO";										// name of introPanel
	public static final String FOREST = "FOREST";									// name of forestPanel
	public static final String TEACHER = "TEACHER";									// name of teacherPanel
	public static final String OWLS = "OWLS";										// name of owlPanel
	public static final String LEVEL_ONE = "LEVEL_ONE";								// name of levelPanelOne
	public static final String LEVEL_TWO = "LEVEL_TWO";								// name of levelPanelTwo
	public static final String LEVEL_THREE = "LEVEL_THREE";							// name of levelPanelThree
	public static final String LEVEL_FOUR = "LEVEL_FOUR";							// name of levelPanelFour
	public static final String LEVEL_FIVE = "LEVEL_FIVE";							// name of levelPanelFive
	public static final String IMAGE_QUESTION = "IMAGE_QUESTION";
	public static final String TEXT_QUESTION = "TEXT_QUESTION";
	public static final String DRAG_AND_DROP_QUESTION = "DRAG_AND_DROP_QUESTION";

	// Declare members of Game class: 
	private Dimension windowSize;							// dimensions of JPanel
	private JPanel cards;									// JPanel object to use card layout
	private IntroPanel introPanel;							// intro panel
	private ForestPanel forestPanel;						// forest panel
	private OwlPanel owlPanel;								// owl panel
	private TeacherPanel teacherPanel;						// teacher panel
	private LevelPanel levelPanelOne;						// level 1 panel
	private LevelPanel levelPanelTwo;						// level 2 panel
	private LevelPanel levelPanelThree;						// level 3 panel
	private LevelPanel levelPanelFour;						// level 4 panel
	private LevelPanel levelPanelFive;						// level 5 panel
<<<<<<< HEAD
	public LevelFive levelFive;								// level 5 declaration
	private ImageQuestion imageQuestion;					// image question panel
	private TextQuestion textQuestion;						// text question panel
	public DragAndDropQuestion dragAndDropQuestion;			// drag and drop question panel
=======
	public TextQuestion textQuestion;						// text question panel
>>>>>>> dfb69b20913f246146dfc7c6841483bd64908bab
	private int level;										// current level passed
	
	/**
	 * CONSTRUCTOR: The constructor calls the init() function.
	 * @param none
	 */
	public Game() {
		init();												// call init()
	}

	/**
	 * SETTER: Sets the level of the game.
	 * @param level
	 */
	public void setLevel(int level) {
		// Output error message if attempting to set to illegal level.
		if (level < 0 || level > 5) {
			System.err.println("ERROR: Invalid level.");
		}
		// Otherwise, set the level of the game.
		else {
			this.level = level;								// set the level of the game
		}
	}
	
	/**
	 * GETTER: Returns the level of the game.
	 * @return level
	 */
	public int getLevel() {
		return level;										// return the level of the game
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
					createGUI();							// call createGUI()
				}
			});
		}	
		catch (Exception error) {
			// Print error message if createGUI() does not complete successfully.
			System.err.println("ERROR: createGUI() did not complete successfully.");
		}
	}

	/**
	 * METHOD: Initializes applet with specified size and card layout.
	 * Initialize the level to 0 (no levels have been passed yet).
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
		cards = new JPanel(new CardLayout());				// initialize cards to card layout
		add(cards);											// add JPanel to applet
		cards.setVisible(true);								// make cards visible
		
		level = 0;											// set the level to 0 (no levels passed yet)
		
		// Create each layout panel and add to cards.
		introPanel = new IntroPanel(this);					// initialize introPanel
		cards.add(introPanel, INTRO);						// add to cards
		forestPanel = new ForestPanel(this);				// initialize forestPanel
		cards.add(forestPanel, FOREST);						// add to cards
		owlPanel = new OwlPanel(this);						// initialize owlPanel
		cards.add(owlPanel, OWLS);							// add to cards
		teacherPanel = new TeacherPanel(this);				// initialize teacherPanel
		cards.add(teacherPanel, TEACHER);					// add to cards
		
		levelPanelOne = new LevelPanel(this, 1);			// initialize level 1 panel
		cards.add(levelPanelOne, LEVEL_ONE);				// add to cards
		levelPanelTwo = new LevelPanel(this, 2);			// initialize level 2 panel
		cards.add(levelPanelTwo, LEVEL_TWO);				// add to cards
		levelPanelThree = new LevelPanel(this, 3);			// initialize level 3 panel
		cards.add(levelPanelThree, LEVEL_THREE);			// add to cards
		levelPanelFour = new LevelPanel(this, 4);			// initialize level 4 panel
		cards.add(levelPanelFour, LEVEL_FOUR);				// add to cards
		levelPanelFive = new LevelPanel(this, 5);			// initialize level 5 panel
		cards.add(levelPanelFive, LEVEL_FIVE);				// add to cards
		
<<<<<<< HEAD
		levelFive = new LevelFive(this);
		
		imageQuestion = new ImageQuestion();				// initialize imageQuestion
		cards.add(imageQuestion, IMAGE_QUESTION);			// add to cards
=======
>>>>>>> dfb69b20913f246146dfc7c6841483bd64908bab
		textQuestion = new TextQuestion();					// initialize textQuestion
		cards.add(textQuestion, TEXT_QUESTION);				// add to cards
		dragAndDropQuestion = new DragAndDropQuestion(this);	// initialize DRAG_AND_DROP_QUESTION
		cards.add(dragAndDropQuestion, DRAG_AND_DROP_QUESTION);	// add to cards
	}
	
	/**
	 * METHOD: Increments the level of the game.
	 * @param none
	 */
	public void incrementLevel() {
		// Only increment the level if private member level is between
		// 0 and 4.
		if (level >= 0 && level < 5) {
			level++;										// increment level
		}
		// Otherwise, there is something wrong and output error message.
		else {
			System.err.println("ERROR: Invalid level.");	// output error message
		}
	}

	/**
	 * METHOD: Changes the layout that is current being shown to the
	 * parameter passed in.
	 * @param layoutToChangeTo
	 */
	public void changeLayoutCard(String layoutToChangeTo) {
		// Get the card layout and flip the desired card to the front.
		CardLayout layout = (CardLayout) (cards.getLayout());
		layout.show(cards, layoutToChangeTo);
	}
}