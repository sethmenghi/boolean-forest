package BooleanForest;

import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class Owl extends JComponent {
	// Private static final members of Owl class are Strings that
	// will determine the size of the Owl image.
	private static final String BOB = "BOB";
	private static final String ALICE = "ALICE";
	private static final String CHLOE = "CHLOE";
	private static final String DAVID = "DAVID";
	
	// Private members of the Owl class:
	private int xCoord;						// x-coordinate of Owl
	private int yCoord;						// y-coordinate of Owl
	private String name;					// name of Owl
	
	// Default constructor
	public Owl() {
		this(0, 0, BOB);
	}
	
	// Overridden constructor
	public Owl(int xCoord, int yCoord, String name) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.name = name;
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
	public void setOwl(String name) {
		this.name = name;
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
	public String getOwl() {
		return name;
	}
	
	@Override
	public void paintComponent(Graphics panel) {
		super.paintComponent(panel);			// Override super method

	}
}
