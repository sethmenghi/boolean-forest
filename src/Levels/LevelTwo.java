package Levels;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import BooleanForest.*;
import Objects.*;

public class LevelTwo extends JPanel {
	
	private static final String INSTRUCTIONS = "Level One Instructions";
	// Question One -- text question
	private static final String Q_ONE = "This is a _____ and it is playing the _____";
	private static final String IMAGE_ONE = "Images/Levels/LevelOne/Question/purpleDolphinSaxophone.png";
	private static final String Q_ONE_OPTION_1 = "dolphin, piano";
	private static final String Q_ONE_OPTION_2 = "dolphin, saxophone";
	private static final String Q_ONE_OPTION_3 = "shark, piano";
	private static final String Q_ONE_OPTION_4 = "shark, saxophone";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static List<String> CORRECT_ONE = new ArrayList<String>();
	public static final Image DOLPHIN = new ImageIcon(IMAGE_ONE).getImage();
	
	
	//Question Two -- text question
	private static final String Q_TWO = "This is an _____ and she is _____ ";
	private static final String IMAGE_TWO = "Images/Levels/LevelOne/Question/pinkOctopus.png";
	private static final String Q_TWO_OPTION_1 = "anglefish, pink";
	private static final String Q_TWO_OPTION_2 = "octopus, blue";
	private static final String Q_TWO_OPTION_3 = "anglefish, purple";
	private static final String Q_TWO_OPTION_4 = "octopus, pink";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
	public static final Image OCTOPUS = new ImageIcon(IMAGE_TWO).getImage();
	
	//Question Three -- text question 
	private static final String Q_THREE = "This is a _____ and she is playing with a ______";

	private static final String IMAGE_THREE = "Images/Levels/LevelOne/Question/seal.png";
	private static final String Q_THREE_OPTION_1 = "dolphin, ball";
	private static final String Q_THREE_OPTION_2 = "seal,yo-yo ";
	private static final String Q_THREE_OPTION_3 = "seal, ball";
	private static final String Q_THREE_OPTION_4 = "fish, ball";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	private static List<String> CORRECT_THREE = new ArrayList<String>();
	public static final Image SEAL = new ImageIcon(IMAGE_THREE).getImage();
	
	private static final String Q_FOUR = "This is a _______ and his eyes are _______";
	private static final String IMAGE_FOUR = "Images/Levels/LevelOne/Question/orca.png";
	private static final String Q_FOUR_OPTION_1 = "whale, blue";
	private static final String Q_FOUR_OPTION_2 = "dolphin,bue ";
	private static final String Q_FOUR_OPTION_3 = "whale, brown";
	private static final String Q_FOUR_OPTION_4 = "shark, blue";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	private static List<String> CORRECT_FOUR = new ArrayList<String>();
	public static final Image SHARK = new ImageIcon(IMAGE_FOUR).getImage();
	
	
	
	private static final String Q_FIVE = "?";
	
	
	
	
	private static final int TEXT = 0;
	private static final int IMAGE = 1;
	
	private Game theGame;
	private BobsWindow bobsWindow;
	
	
	public LevelTwo(Game game) {
		
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
			addCorrectAnswers(CORRECT_ONE, Q_ONE_OPTION_2);
			//theGame.imageQuestion.setQuestion(Q_ONE);
			//theGame.imageQuestion.setAnswerList(); sets correct answer too
		case Q_TWO:	
			addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_2,  Q_TWO_OPTION_3,  Q_TWO_OPTION_4);
			addCorrectAnswers(CORRECT_TWO, Q_TWO_OPTION_4);
			
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