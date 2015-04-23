package BooleanForest;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class LevelFour extends JPanel {
	//OR LEVEL 
	
	private static final String INSTRUCTIONS = "Level One Instructions";
	// Question One -- text question
	private static final String Q_ONE = "Select the correct statement about the walrus";
	private static final String IMAGE_ONE = "Images/walrus";
	private static final String Q_ONE_OPTION_1 = "The walrus caught a fish or a seal to eat.";
	private static final String Q_ONE_OPTION_2 = "The walrus is gray or he is black.";
	private static final String Q_ONE_OPTION_3 = "The walrus has pink or blue tusks.";
	private static final String Q_ONE_OPTION_4 = "The walrus is swimming or he is sleeping.";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static List<String> CORRECT_ONE = new ArrayList<String>(); 
	
	//Question Two -- text question
	//http://thumbs.dreamstime.com/z/cartoon-polar-bear-iceberg-illustration-eating-frozen-treat-49419664.jpg
	private static final String Q_TWO = "Select the correct statement about the polar bear:";
	private static final String IMAGE_TWO = "Images/polarbear.png";
	private static final String Q_TWO_OPTION_1 = "The polar is standing on grass or swimming.";
	private static final String Q_TWO_OPTION_2 = "The polar bear is standing on an iceberg or swimming.";
	private static final String Q_TWO_OPTION_3 = "The polar bear's nose is green or yellow.";
	private static final String Q_TWO_OPTION_4 = "The polar bear is eating a sandwich or an iceberg.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
	
	
	
	private static final String Q_THREE = "?";
	private static final String Q_FOUR = "?";
	private static final String Q_FIVE = "?";
	
	
	private static final int TEXT = 0;
	private static final int IMAGE = 1;
	
	private Game theGame;
	private BobsWindow bobsWindow;
	
	
	public LevelFour(Game game) {
		
		theGame = game;
		
		//bobsWindow = new BobsWindow(theGame, INSTRUCTIONS);
		
		startLevel();
	}
	
	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2, String option3, String option4){
		holdsPossibleAnswers.add(option1);
		holdsPossibleAnswers.add(option2);
		holdsPossibleAnswers.add(option3);
		holdsPossibleAnswers.add(option4);
	}
	
	public static void addCorrectAnswers(List<String> correctAnswer, String correctOption){
		
		correctAnswer.add(correctOption);
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
			
			addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_2,  Q_ONE_OPTION_3,  Q_ONE_OPTION_4);
			addCorrectAnswers(CORRECT_ONE, Q_ONE_OPTION_1);
			//theGame.imageQuestion.setQuestion(Q_ONE);
			//theGame.imageQuestion.setAnswerList(); sets correct answer too
		case Q_TWO:	
			addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_2,  Q_TWO_OPTION_3,  Q_TWO_OPTION_4);
			addCorrectAnswers(CORRECT_TWO, Q_TWO_OPTION_2);
			
			//theGame.changeLayoutCard("Image Question");
	
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
		Image image = new ImageIcon("Images/LevelMapWithPath.jpg").getImage();
		g.drawImage(image, 0, 0, null);
		
		bobsWindow.paintComponents(g);
	}
}
