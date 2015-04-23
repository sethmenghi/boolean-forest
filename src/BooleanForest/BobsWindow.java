/**
 * BOBS WINDOW CLASS
 * 
* DESCRIPTION:
* The BobsWindow class creates an object with a text window background
* and sets the text that will be drawn.
* 
* SOURCES:
* 
*/

package BooleanForest;

import java.awt.Dimension;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BobsWindow extends JPanel {
	// Public static final members of BobsWindow class:
	public static final String INTRO = "Intro";				// indicates BobsWindow for IntroPanel
	public static final String FOREST = "Forest";			// indicates BobsWindow for ForestPanel
	public static final String TEACHER = "Teacher";
	public static final int INTRO_WIDTH = 404;				// width of IntroPanel BobsWindow
	public static final int INTRO_HEIGHT = 199;				// height of IntroPanel BobsWindow
	public static final int FOREST_WIDTH = 350;				// width of ForestPanel BobsWindow
	public static final int FOREST_HEIGHT = 177;			// height of ForestPanel BobsWindow
	public static final int TEACHER_WIDTH = 404;			// width of TeacherPanel BobsWindow
	public static final int TEACHER_HEIGHT = 425;			// height of TeacherPanel BobsWindow
	public static final int INTRO_XCOORD = 53;				// pre-determined xCoord of IntroPanel BobsWindow
	public static final int INTRO_YCOORD = 67;				// pre-determined yCoord of IntroPanel BobsWindow
	public static final int INTRO_BOB_XCOORD = 462;			// pre-determined xCoord of IntroPanel Bob
	public static final int INTRO_BOB_YCOORD = 218;			// pre-determined yCoord of IntroPanel Bob
	public static final int FOREST_XCOORD = 70;				// pre-determined xCoord of ForestPanel BobsWindow
	public static final int FOREST_YCOORD = 107;			// pre-determined yCoord of ForestPanel BobsWindow
	public static final int FOREST_BOB_XCOORD = 418;		// pre-determined xCoord of ForestPanel Bob
	public static final int FOREST_BOB_YCOORD = 268;		// pre-determined yCoord of ForestPanel Bob
	public static final int TEACHER_XCOORD = 207;				// pre-determined xCoord of IntroPanel BobsWindow
	public static final int TEACHER_YCOORD = 34;				// pre-determined yCoord of IntroPanel BobsWindow
	public static final int TEACHER_BOB_XCOORD = 31;			// pre-determined xCoord of IntroPanel Bob
	public static final int TEACHER_BOB_YCOORD = 25;			// pre-determined yCoord of IntroPanel Bob
	
	// Declare members of BobsWindow class:
//	private Game theGame;									// reference of main Game object
	@SuppressWarnings("unused")
	private String panelType;								// stores which panel type BobsWindow is for
	private int xCoord;										// x-coordinate of BobsWindow
	private int yCoord;										// y-coordinate of BobsWindow
	private String bobsMessage;								// Bob's message
//	private GameButton gameButton;							// button in BobsWindow
//	private String buttonMessage;							// text for button
	private Owl bob;										// Bob
	
	/**
	 * CONSTRUCTOR: The constructor creates a reference to the main Game
	 * object, sets the panelType, bobsMessage and buttonMessage and 
	 * initializes gameButton with the text from buttonMessage. Add an
	 * actionListener to the button and then calls the initBobsWindow() method.
	 * @param panelType
	 * @param bobsMessage
	 */
	public BobsWindow(String panelType, String bobsMessage) {
		this.panelType = panelType;							// sets the panelType value
		this.bobsMessage = bobsMessage;						// sets the bobsMessage value
		
		initBobsWindow(panelType);							// call initBobsWindow for panelType
	}
	
//	/**
//	 * CONSTRUCTOR: The constructor creates a reference to the main Game
//	 * object, sets the panelType, bobsMessage and buttonMessage and 
//	 * initializes gameButton with the text from buttonMessage. Add an
//	 * actionListener to the button and then calls the initBobsWindow() method.
//	 * @param game
//	 * @param panelType
//	 * @param bobsMessage
//	 * @param buttonMessage
//	 */
//	public BobsWindow(Game game, String panelType, String bobsMessage) {
//		this.theGame = game;								// create reference of main Game object
//		this.panelType = panelType;							// sets the panelType value
//		this.bobsMessage = bobsMessage;						// sets the bobsMessage value
//		this.buttonMessage = buttonMessage;					// sets the buttonMessage value
//		gameButton = new GameButton(buttonMessage, "white");// initialize gameButton with buttonMessage as text
//		gameButton.addActionListener(this);					// add actionListener for button
//		
//		initBobsWindow(panelType);							// call initBobsWindow for panelType
//	}
	
	/**
	 * SETTER: Sets the xCoord of the BobsWindow.
	 * @param xCoord
	 */
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;								// sets the xCoord value
	}
	
	/**
	 * SETTER: Sets the yCoord of the BobsWindow.
	 * @param yCoord
	 */
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;								// sets the yCoord value
	}
	
	/**
	 * SETTER: Sets the bobsMessage of the bobsMessage.
	 * @param bobsMessage
	 */
	public void setBobsMessage(String bobsMessage) {
		this.bobsMessage = bobsMessage;						// sets the bobsMessage value
	}
	
//	/**
//	 * SETTER: Sets the buttonMessage of the BobsWindow.
//	 * @param buttonMessage
//	 */
//	public void setButtonMessage(String buttonMessage) {
//		this.buttonMessage = buttonMessage;					// sets the buttonMessage value
//	}
	
	/**
	 * GETTER: Returns the xCoord of the BobsWindow.
	 * @return xCoord
	 */
	public int getXCoord() {
		return xCoord;										// returns xCoord value
	}
	
	/**
	 * GETTER: Returns the yCoord of the BobsWindow.
	 * @return yCoord
	 */
	public int getYCoord() {
		return yCoord;										// returns yCoord value
	}
	
	/**
	 * GETTER: Returns the bobsMessage of the BobsWindow.
	 * @return bobsMessage
	 */
	public String getBobsMessage() {
		return bobsMessage;									// returns bobsMessage value
	}
	
//	/**
//	 * GETTER: Returns the buttonMessage of the BobsWindow.
//	 * @return buttonMessage
//	 */
//	public String getButtonMessage() {
//		return buttonMessage;								// returns buttonMessage value
//	}
	
	/**
	 * GETTER: Returns bob of the BobsWindow.
	 * @return bob
	 */
	public Owl getBob() {
		return bob;											// returns Bob
	}
	
	/**
	 * METHOD: Initializes BobsWindow's x- and y-coordinates, sets the
	 * coordinates for Bob and sets the dimensions of BobsWindow which
	 * depends on the panelType passed in. Pre-determined declared
	 * coordinates are used.
	 * @param panelType
	 */
	public void initBobsWindow(String panelType) {
		setWindowCoords(panelType);							// set window coordinates
		setBobCoords(panelType);							// set Bob's coordinates
		
		// If this is a BobsWindow for IntroPanel, set size to
		// INTRO_WIDTH and INTRO_HEIGHT.
		if (panelType == INTRO) {
			setPreferredSize(new Dimension(INTRO_WIDTH, INTRO_HEIGHT));
		}
		// If this is a BobsWindow for ForestPanel, set size to
		// FOREST_WIDTH and FOREST_HEIGHT.
		else {
			setPreferredSize(new Dimension(FOREST_WIDTH, FOREST_HEIGHT));
		}
		setVisible(false);
	}
	
	/**
	 * METHOD: Sets the x- and y-coordinates of BobsWindow depending
	 * on the panelType passed in.
	 * @param panelType
	 */
	public void setWindowCoords(String panelType) {
		// If this is a BobsWindow for IntroPanel, set x- and y-coordinates
		// to INTRO_XCOORD and INTRO_YCOORD.
		if (panelType == INTRO) {
			setXCoord(INTRO_XCOORD);						// set xCoord to INTRO_XCOORD
			setYCoord(INTRO_YCOORD);						// set yCoord to INTRO_YCOORD
		}
		// If this is a BobsWindow for ForestPanel, set x- and y-coordinates
		// to FOREST_XCOORD and FOREST_YCOORD.
		else if (panelType == FOREST) {
			setXCoord(FOREST_XCOORD);					// set xCoord to FOREST_XCOORD
			setYCoord(FOREST_YCOORD);					// set xCoord to FOREST_YCOORD
		}
		else {
			setXCoord(TEACHER_XCOORD);
			setYCoord(TEACHER_YCOORD);
		}
		setVisible(true);
	}
	
	/**
	 * METHOD: Sets the x- and y-coordinates of Bob depending on the
	 * panelType passed in.
	 * @param panelType
	 */
	public void setBobCoords(String panelType) {
		// If this is a BobsWindow for IntroPanel, set x- and y-coordinates
		// for Bob to INTRO_BOB_XCOORD and INTRO_BOB_YCOORD.
		if (panelType == INTRO) {
			bob = new Owl(INTRO_BOB_XCOORD, INTRO_BOB_YCOORD, Owl.BOB);
		}
		// If this is a BobsWindow for ForestPanel, set x- and y-coordinates
		// for Bob to FOREST_BOB_XCOORD and FOREST_BOB_YCOORD.
		else if (panelType == FOREST) {
			bob = new Owl(FOREST_BOB_XCOORD, FOREST_BOB_YCOORD, Owl.BOB);
		}
		else {
			bob = new Owl(TEACHER_BOB_XCOORD, TEACHER_BOB_YCOORD, Owl.BOB);
		}
	}
}