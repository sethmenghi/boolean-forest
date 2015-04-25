/**
 * STAR CLASS
 * 
* DESCRIPTION:
* The Star class is an object that declares the x- and y-coordinates of
* a Star object and indicates which level passed the Star is for.
* 
* SOURCES:
* 
*/

package BooleanForest;

public class Star {
	// Private static final members of Star class:
	private static final String ONE = "ONE";
	private static final String TWO = "TWO";
	private static final String THREE = "THREE";
	private static final String FOUR = "FOUR";
	private static final String FIVE = "FIVE";
	
	// Private static final members of Star class:
	// Coordinates of stars are pre-determined.
	private static final int ONE_XCOORD = 588;		// x-coordinate for level 1
	private static final int TWO_XCOORD = 547;		// x-coordinate for level 2
	private static final int THREE_XCOORD = 506;	// x-coordinate for level 3
	private static final int FOUR_XCOORD = 465;		// x-coordinate for level 4
	private static final int FIVE_XCOORD = 424;		// x-coordinate for level 5
	private static final int STAR_YCOORD = 433;		// y-coordinate for all stars
	
	// Private members of the Star class:
	private int xCoord;								// x-coordinate of Star
	private int yCoord;								// y-coordinate of Star
	
	/**
	 * DEFAULT CONSTRUCTOR: The constructor calls overloaded constructor
	 * with x- and y-coordinates of 0 and the level passed ONE.
	 * @param none
	 */
	public Star() {
		this(ONE);									// call overridden Star()
	}
	
	/**
	 * OVERLOADED CONSTRUCTOR: Instantiates an Owl object and initializes the x-
	 * and y-coordinates.
	 * @param name
	 */
	public Star(String levelPassed) {	
		this.setCoordinates(levelPassed);			// set constant coordinates for Star
	}
	
	/**
	 * SETTER: Sets the xCoord of the Star.
	 * @param xCoord
	 */
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;						// set xCoord value of Star
	}
	
	/**
	 * SETTER: Sets the yCoord of the Star.
	 * @param yCoord
	 */
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;						// set yCoord value of Star
	}
	
	/**
	 * SETTER: Sets the x- and y-coordinate of the Star based on the
	 * levelPassed parameter passed in.
	 * @param levelPassed
	 */
	public void setCoordinates(String levelPassed) {
		// Switch levelPassed and set the xCoord value.
		switch(levelPassed) {
		case ONE:									// level 1 passed
			this.setXCoord(ONE_XCOORD);
			break;
		case TWO:									// level 2 passed
			this.setXCoord(TWO_XCOORD);
			break;
		case THREE:									// level 3 passed
			this.setXCoord(THREE_XCOORD);
			break;
		case FOUR:									// level 4 passed
			this.setXCoord(FOUR_XCOORD);
			break;
		case FIVE:									// level 5 passed
			this.setXCoord(FIVE_XCOORD);
			break;
		default:									// default case
			break;
		}
		
		this.setYCoord(STAR_YCOORD);				// set yCoord of all Stars
	}
	
	/**
	 * GETTER: Returns the xCoord of the Star.
	 * @return xCoord
	 */
	public int getXCoord() {
		return xCoord;								// return xCoord value of Star
	}
	
	/**
	 * GETTER: Returns the yCoord of the Star.
	 * @return yCoord
	 */
	public int getYCoord() {
		return yCoord;								// return yCoord value of Star
	}
}