/**
 * OWL CLASS
 * 
* DESCRIPTION:
* The Owl class is an object that declares the x- and y-coordinates of
* an Owl object and the name of the Owl.
* 
* SOURCES:
* 
*/

package BooleanForest;

public class Owl {
	// Public static final members of Owl class:
	public static final String BOB = "BOB";			// dimensions of image file are 158 x 159
	public static final String ALICE = "ALICE";		// dimensions of image file are 158 x 159
	public static final String CHLOE = "CHLOE";		// dimensions of image file are 87 x 88
	public static final String DAVID = "DAVID";		// dimensions of image file are 106 x 107
	
	// Private members of the Owl class:
	private int xCoord;								// x-coordinate of Owl
	private int yCoord;								// y-coordinate of Owl
	private String name;							// name of Owl
	
	/**
	 * DEFAULT CONSTRUCTOR: The constructor calls overloaded constructor
	 * with x- and y-coordinates of 0 and the name BOB.
	 * @param none
	 */
	public Owl() {
		this(0, 0, BOB);							// call overridden Owl(int, int, name)
	}
	
	/**
	 * OVERLOADED CONSTRUCTOR: Instantiates an Owl object and initializes the x-
	 * and y-coordinates and name members.
	 * @param xCoord
	 * @param yCoord
	 * @param name
	 */
	public Owl(int xCoord, int yCoord, String name) {
		this.xCoord = xCoord;						// initialize xCoord value
		this.yCoord = yCoord;						// initialize yCoord value
		this.name = name;							// initialize name value
	}
	
	/**
	 * SETTER: Sets the xCoord of the Owl.
	 * @param xCoord
	 */
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;						// set xCoord value of Owl
	}
	
	/**
	 * SETTER: Sets the yCoord of the Owl.
	 * @param yCoord
	 */
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;						// set yCoord value of Owl
	}
	
	/**
	 * SETTER: Sets the name of the Owl.
	 * @param name
	 */
	public void setOwl(String name) {
		this.name = name;							// set name value of Owl
	}
	
	/**
	 * GETTER: Returns the xCoord of the Owl.
	 * @return xCoord
	 */
	public int getXCoord() {
		return xCoord;								// return xCoord value of Owl
	}
	
	/**
	 * GETTER: Returns the yCoord of the Owl.
	 * @return yCoord
	 */
	public int getYCoord() {
		return yCoord;								// return yCoord value of Owl
	}
	
	/**
	 * GETTER: Returns the name of the Owl.
	 * @return name
	 */
	public String getOwl() {
		return name;								// return name value of Owl
	}
}