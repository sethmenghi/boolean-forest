package BooleanForest;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LevelOne extends JPanel {
	
	private static final String INSTRUCTIONS = "Level One Instructions";
	private static final String Q_ONE = "?";
	private static final String Q_TWO = "?";
	private static final String Q_THREE = "?";
	private static final String Q_FOUR = "?";
	private static final String Q_FIVE = "?";
	private static final int TEXT = 0;
	private static final int IMAGE = 1;
	
	
	private Game theGame;
	private BobsWindow bobsWindow;
	
	public LevelOne(Game game) {
		
		theGame = game;
		
		//bobsWindow = new BobsWindow(theGame, INSTRUCTIONS);
		
		startLevel();
	}
	
	private void startLevel() {
		doQuestion(Q_ONE);
		doQuestion(Q_TWO);
		doQuestion(Q_ONE);
		doQuestion(Q_ONE);
		doQuestion(Q_ONE);
	}
	
	public void doQuestion(String question) {
		switch (question) {
		case Q_ONE:
			// Create answer list NEW METHOD
			
			//theGame.imageQuestion.setQuestion(Q_ONE);
			//theGame.imageQuestion.setAnswerList();
			//theGame.imageQuestion.setCorrectAnswer();
			
			theGame.changeLayoutCard("Image Question");
			break;
		
		}
		
		//updateScore();
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
		
		bobsWindow.paintComponents(g);
	}
}
