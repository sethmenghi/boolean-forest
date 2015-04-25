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

package Objects;

import java.awt.Dimension;

import javax.swing.JPanel;

import BooleanForest.Game;

@SuppressWarnings("serial")
public class BobsWindow extends JPanel {
	// Public static final members of BobsWindow class:	
	public static final int INTRO_WIDTH = 404;				// width of IntroPanel BobsWindow
	public static final int INTRO_HEIGHT = 199;				// height of IntroPanel BobsWindow
	public static final int INTRO_XCOORD = 53;				// pre-determined xCoord of IntroPanel BobsWindow
	public static final int INTRO_YCOORD = 67;				// pre-determined yCoord of IntroPanel BobsWindow
	public static final int INTRO_BOB_XCOORD = 462;			// pre-determined xCoord of IntroPanel Bob
	public static final int INTRO_BOB_YCOORD = 218;			// pre-determined yCoord of IntroPanel Bob
	
	public static final int FOREST_WIDTH = 350;				// width of ForestPanel BobsWindow
	public static final int FOREST_HEIGHT = 177;			// height of ForestPanel BobsWindow
	public static final int FOREST_XCOORD = 70;				// pre-determined xCoord of ForestPanel BobsWindow
	public static final int FOREST_YCOORD = 107;			// pre-determined yCoord of ForestPanel BobsWindow
	public static final int FOREST_BOB_XCOORD = 418;		// pre-determined xCoord of ForestPanel Bob
	public static final int FOREST_BOB_YCOORD = 268;		// pre-determined yCoord of ForestPanel Bob
	
	public static final int TEACHER_WIDTH = 404;			// width of TeacherPanel BobsWindow
	public static final int TEACHER_HEIGHT = 425;			// height of TeacherPanel BobsWindow
	public static final int TEACHER_XCOORD = 207;			// pre-determined xCoord of TeacherPanel BobsWindow
	public static final int TEACHER_YCOORD = 34;			// pre-determined yCoord of TeacherPanel BobsWindow
	public static final int TEACHER_BOB_XCOORD = 31;		// pre-determined xCoord of TeacherPanel Bob
	public static final int TEACHER_BOB_YCOORD = 25;		// pre-determined yCoord of TeacherPanel Bob
	
	public static final int LEVEL_WIDTH = 420;				// width of LevelPanel BobsWindow
	public static final int LEVEL_HEIGHT = 433;				// height of LevelPanel BobsWindow
	public static final int LEVEL_XCOORD = 22;				// pre-determined xCoord of LevelPanel BobsWindow
	public static final int LEVEL_YCOORD = 24;				// pre-determined yCoord of LevelPanel BobsWindow
	public static final int LEVEL_BOB_XCOORD = 464;			// pre-determined xCoord of LevelPanel Bob
	public static final int LEVEL_BOB_YCOORD = 304;			// pre-determined yCoord of LevelPanel Bob
	
	// Declare members of BobsWindow class:
	@SuppressWarnings("unused")
	private String panelType;								// stores which panel type BobsWindow is for
	private int xCoord;										// x-coordinate of BobsWindow
	private int yCoord;										// y-coordinate of BobsWindow
	private String bobsMessage;								// Bob's message
	private Owl bob;										// Bob
	
	/**
	 * CONSTRUCTOR: The constructor sets the panelType and bobsMessage
	 * and then calls the initBobsWindow() method.
	 * @param panelType
	 * @param bobsMessage
	 */
	public BobsWindow(String panelType, String bobsMessage) {
		this.panelType = panelType;							// sets the panelType value
		this.bobsMessage = bobsMessage;						// sets the bobsMessage value
		
		initBobsWindow(panelType);							// call initBobsWindow for panelType
	}
	
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
		if (panelType == Game.INTRO) {
			setPreferredSize(new Dimension(INTRO_WIDTH, INTRO_HEIGHT));
		}
		// If this is a BobsWindow for ForestPanel, set size to
		// FOREST_WIDTH and FOREST_HEIGHT.
		else if (panelType == Game.FOREST) {
			setPreferredSize(new Dimension(FOREST_WIDTH, FOREST_HEIGHT));
		}
		// If this is a BobsWindow for TeacherPanel, set size to
		// TEACHER_WIDTH and TEACHER_HEIGHT.
		else if (panelType == Game.TEACHER) {
			setPreferredSize(new Dimension(TEACHER_WIDTH, TEACHER_HEIGHT));
		}
		// If this is a BobsWindow for LevelPanel, set size to
		// LEVEL_WIDTH and LEVEL_HEIGHT.
		else {
			setPreferredSize(new Dimension(LEVEL_WIDTH, LEVEL_HEIGHT));
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
		if (panelType == Game.INTRO) {
			setXCoord(INTRO_XCOORD);						// set xCoord to INTRO_XCOORD
			setYCoord(INTRO_YCOORD);						// set yCoord to INTRO_YCOORD
		}
		// If this is a BobsWindow for ForestPanel, set x- and y-coordinates
		// to FOREST_XCOORD and FOREST_YCOORD.
		else if (panelType == Game.FOREST) {
			setXCoord(FOREST_XCOORD);						// set xCoord to FOREST_XCOORD
			setYCoord(FOREST_YCOORD);						// set xCoord to FOREST_YCOORD
		}
		// If this is a BobsWindow for TeacherPanel, set x- and y-coordinates
		// to TEACHER_XCOORD and TEACHER_YCOORD.
		else if (panelType == Game.TEACHER) {
			setXCoord(TEACHER_XCOORD);						// set xCoord to TEACHER_XCOORD
			setYCoord(TEACHER_YCOORD);						// set yCoord to TEACHER_YCOORD
		}
		// If this is a BobsWindow for LevelPanel, set x- and y-coordinates
		// to LEVEL_XCOORD and LEVEL_YCOORD.
		else {
			setXCoord(LEVEL_XCOORD);						// set xCoord to LEVEL_XCOORD
			setYCoord(LEVEL_YCOORD);						// set yCoord to LEVEL_YCOORD
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
		if (panelType == Game.INTRO) {
			bob = new Owl(INTRO_BOB_XCOORD, INTRO_BOB_YCOORD, Owl.BOB);
		}
		// If this is a BobsWindow for ForestPanel, set x- and y-coordinates
		// for Bob to FOREST_BOB_XCOORD and FOREST_BOB_YCOORD.
		else if (panelType == Game.FOREST) {
			bob = new Owl(FOREST_BOB_XCOORD, FOREST_BOB_YCOORD, Owl.BOB);
		}
		// If this is a BobsWindow for TeacherPanel, set x- and y-coordinates
		// for Bob to TEACHER_BOB_XCOORD and TEACHER_BOB_YCOORD.
		else if (panelType == Game.TEACHER) {
			bob = new Owl(TEACHER_BOB_XCOORD, TEACHER_BOB_YCOORD, Owl.BOB);
		}
		// If this is a BobsWindow for LevelPanel, set x- and y-coordinates
		// for Bob to LEVEL_BOB_XCOORD and LEVEL_BOB_XCOORD.
		else {
			bob = new Owl(LEVEL_BOB_XCOORD, LEVEL_BOB_YCOORD, Owl.BOB);
		}
	}
}