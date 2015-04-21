package BooleanForest;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ForestPanel extends JPanel {
	
	// Declare 
	private Game theGame;
	private BobsWindow bobsWindow;
	
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
		
		bobsWindow = new BobsWindow();
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
		Image image = new ImageIcon("Images/LevelMap.jpg").getImage();
		g.drawImage(image, 0, 0, null);
	}
	
}
