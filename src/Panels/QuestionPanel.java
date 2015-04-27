package Panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import BooleanForest.Game;

public class QuestionPanel extends JPanel implements Panel {
	
	private static final String BACKGROUND_SRC = "Images/Backgrounds/EmptyGradientBackground.jpg";
	
	private Game theGame;
	
	public QuestionPanel(Game game){
		initPanel(game);
	}

	@Override
	public void initPanel(Game game) {
		this.theGame = game;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);									// call super method

		// Create new image icon and draw the background image.
		Image image = new ImageIcon(BACKGROUND_SRC).getImage();
		g.drawImage(image, 0, 0, null);
	}	

	@Override
	public void paintBobsWindow(Graphics g) {
		// TODO Auto-generated method stub
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
}
