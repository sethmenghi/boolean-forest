package BooleanForest;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Owl extends JComponent {
	// Private static final members of Owl class are Strings that
	// will determine the size of the Owl image.
	private static final String ADULT = "ADULT";
	private static final String SMALL_CHILD = "SMALL_CHILD";
	private static final String BIG_CHILD = "BIG_CHILD";
	
	// Private members of the Owl class:
	private int xCoord;						// x-coordinate of Owl
	private int yCoord;						// y-coordinate of Owl
	private String size;					// size of Owl
	
	// Default constructor
	public Owl() {
		this(0, 0, ADULT);
	}
	
	// Overridden constructor
	public Owl(int xCoord, int yCoord, String size) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.size = size;
	}
	
	// Setter: set xCoord
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;
	}
	
	// Setter: set yCoord
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;
	}
	
	// Setter: set size
	public void setOwlSize(String size) {
		this.size = size;
	}
	
	// Getter: return xCoord
	public int getXCoord() {
		return xCoord;
	}
	
	// Getter: return yCoord
	public int getYCoord() {
		return yCoord;
	}
	
	// Getter: return size
	public String getOwlSize() {
		return size;
	}
	
	@Override
	public void paintComponent(Graphics panel) {
		super.paintComponent(panel);			// Override super method

	}
}
