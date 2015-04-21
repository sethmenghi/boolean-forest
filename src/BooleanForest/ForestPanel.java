package BooleanForest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * ForestPanel
 * 
 * Creates the level map on which the game is centered, includes level data
 */

@SuppressWarnings("serial")
public class ForestPanel extends JPanel {
	
	// Declare 
	private Game theGame;
	private BobsWindow bobsWindow;
	private Owl chloe;
	private Owl david;
	
	/**
	 * ForestPanel()
	 * 
	 * Constructor, calls initForest
	 * 
	 * @param game
	 */
	public ForestPanel(Game game) {
		initForest(game);
	}
	
	/**
	 * initForest()
	 * 
	 * Initializes panel size and variables, calls repaint
	 * 
	 * @param game
	 */
	private void initForest(Game game) {
		setPreferredSize(new Dimension(640,480));
		setDoubleBuffered(true);
		this.theGame = game;
		
		chloe = new Owl(100,150,"SMALL_CHILD");
		add(chloe);
		david = new Owl(90,140,"Big_CHILD");
		add(david);
		
		bobsWindow = new BobsWindow(theGame);
		add(bobsWindow);
		
		repaint();
	}
	
	/**
	 * paintComponenent()
	 * 
	 * Overrides paintComponenent(); draws background image
	 * 
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		// Call super
		super.paintComponent(g);
		
		// Create new image icon, draw the image
		Image image = new ImageIcon("Images/LevelMapWithPath.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		paintOwl(g, chloe);
		
		bobsWindow.paintComponent(g);
	}
	
	private void paintOwl(Graphics g, Owl owl) {
		Image owlImage = new ImageIcon("Images/alice.png").getImage();
		g.drawImage(owlImage, owl.getXCoord(), owl.getYCoord(), null);
	}
}
