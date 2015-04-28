package Panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import BooleanForest.Game;

@SuppressWarnings("serial")
public class CertificatePanel extends JPanel implements Panel, MouseListener {
	
	// Declare private string for the image resource
	private static final String BACKGROUND_SRC = "/Images/Backgrounds/CertificateBackground.jpg";	// background url

	/**
	 * CONSTRUCTOR: The constructor calls initPanel() method.
	 * @param game
	 */
	public CertificatePanel(Game game) {
		initPanel(game);
	}
	
	/**
	 * OVERRIDDEN METHOD: Initializes JPanel dimensions and members of
	 * Certificate class.
	 * @param game
	 */
	@Override
	public void initPanel(Game game) {
		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);
	}
	
	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image.
	 * @param graphic
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image background = new ImageIcon(getClass().getResource(BACKGROUND_SRC)).getImage();
		g.drawImage(background, 0, 0, null);
	}

	@Override
	public void addText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void addParagraphText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addButtons() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
