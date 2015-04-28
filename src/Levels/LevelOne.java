/**
 * LEVELONE CLASS
 * 
 * DESCRIPTION:
 * 
 * IMAGE SOURCES:
 * http://yunus.hacettepe.edu.tr/~osert/Hotpot_2014_02/02_erdemli_batibay/coffee%20table.jpg
 * http://sweetclipart.com/multisite/sweetclipart/files/penguin_cute.png
 */

package Levels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.Game;

public class LevelOne {
	// Declare static final Strings for explanations:
	public static final String PAGE_TRUE = "TRUE";						// page 1	
	public static final String PAGE_TRUE_A = "This is a penguin.";		// page 2
	public static final String PAGE_TRUE_B = "The color is blue.";		// page 3	
	public static final String PAGE_FALSE = "FALSE";					// page 4	
	public static final String PAGE_FALSE_A = "This is a cup.";			// page 5
	public static final String PAGE_FALSE_B = "The color is yellow.";	// page 6	
	public static final String TRUE_STATEMENT = "This is a TRUE statement.";
	public static final String FALSE_STATEMENT = "This is a FALSE statement.";
	
	// Declare static final Images for explanations:
	public static final Image PENGUIN = new ImageIcon("Images/Levels/LevelOne/Explanation/Penguin.png").getImage();
	public static final Image BLUE = new ImageIcon("Images/Levels/LevelOne/Explanation/Blue.png").getImage();
	public static final Image TABLE = new ImageIcon("Images/Levels/LevelOne/Explanation/Table.png").getImage();
	public static final Image PINK = new ImageIcon("Images/Levels/LevelOne/Explanation/Pink.png").getImage();
	
	private static final String Q_FOUR = "This is a monkey.";
	private static final String IMAGE_FOUR = "Images/Levels/LevelOne/Questions/lion.png";
	private static final String Q_FOUR_OPTION_1 = "True.";
	private static final String Q_FOUR_OPTION_2 = "False.";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	private static final String CORRECT_FOUR = Q_FOUR_OPTION_2;
	//public static final Image MONKEY = new ImageIcon(IMAGE_ONE).getImage();
	
	
	//public static final Image ZEBRA = new ImageIcon(IMAGE_TWO).getImage();

	//These are the four string options for the answer to question 2, level 
	
//	
	
	// Question One -- text question
	private static final String Q_ONE = "This is a monkey.";
	private static final String IMAGE_ONE = "Images/Levels/LevelOne/Questions/Monkey.png";
	private static final String Q_ONE_OPTION_1 = "True";
	private static final String Q_ONE_OPTION_2 = "False";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static final String CORRECT_ONE = Q_ONE_OPTION_1;
	
	private static final String Q_TWO = "This animal has stripes.";
	private static final String IMAGE_TWO = "Images/Levels/LevelOne/Questions/Zebra.png";
	private static final String Q_TWO_OPTION_1 = "True.";
	private static final String Q_TWO_OPTION_2 = "False.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static final String CORRECT_TWO = Q_TWO_OPTION_1;
	
	private static final String  Q_THREE = "This animal is purple.";
	private static final String IMAGE_THREE = "Images/Levels/LevelOne/Questions/Flamingo.png";
	private static final String Q_THREE_OPTION_1 = "True.";
	private static final String Q_THREE_OPTION_2 = "False.";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	private static final String CORRECT_THREE = Q_TWO_OPTION_2;
	
//	
//	//Question Two -- text question
//	private static final String Q_TWO = "This is an _____ and she is _____ ";
//	private static final String IMAGE_TWO = "Images/pinkOctopus.png";
//	private static final String Q_TWO_OPTION_1 = "anglefish, pink";
//	private static final String Q_TWO_OPTION_2 = "octopus, blue";
//	private static final String Q_TWO_OPTION_3 = "anglefish, purple";
//	private static final String Q_TWO_OPTION_4 = "octopus, pink";
//	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
//	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
//	
//	private static final String Q_FIVE = "?";
//	private static final int TEXT = 0;
//	private static final int IMAGE = 1;
	
	private Game theGame;
	int currentLevel = 1;
	
	public LevelOne(Game game) {
		theGame = game;
		//startLevel();
	}
	
	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2, String option3, String option4){
		holdsPossibleAnswers.add(option1);
		holdsPossibleAnswers.add(option2);
		holdsPossibleAnswers.add(option3);
		holdsPossibleAnswers.add(option4);
	}
	
	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2){
		holdsPossibleAnswers.add(option1);
		holdsPossibleAnswers.add(option2);
	}

	public void startLevel() {
		doQuestion();
	}
	
	public void nextQuestion(){
		if (theGame.textQuestion.questionCompleted == true){
			currentLevel++;
			doQuestion();
		}
		else{
			JLabel warningImage = new JLabel(new ImageIcon("Images/Owls/Bob.png"));
			JOptionPane.showMessageDialog(null, warningImage, "Question", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	public void doQuestion() {
		switch (currentLevel) {
		case 1:
			if (ANSWERS_ONE.size() == 0){
				addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_2);
				theGame.textQuestion.setQuestion(Q_ONE);
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);
				theGame.textQuestion.setAnswerList(ANSWERS_ONE,Q_ONE_OPTION_2);
				theGame.textQuestion.initGui();
				theGame.repaint();
				theGame.changeLayoutCard("TEXT_QUESTION");

			}
			break;
		case 2:	
			if (ANSWERS_TWO.size() == 0){
				addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_2);
				theGame.textQuestion.setQuestion(Q_TWO);
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);
				theGame.textQuestion.setAnswerList(ANSWERS_TWO,Q_TWO_OPTION_1);
				theGame.textQuestion.initGui();
				theGame.repaint();
				theGame.changeLayoutCard("TEXT_QUESTION");
			}
			break;
		case 3:	
			if (ANSWERS_THREE.size() == 0){
			addPossibleAnswers(ANSWERS_THREE,  Q_THREE_OPTION_1,  Q_THREE_OPTION_2);
			theGame.textQuestion.setQuestion(Q_THREE);
			theGame.textQuestion.setQuestionImage(IMAGE_THREE);
			theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_TWO_OPTION_2);
			theGame.textQuestion.initGui();
			theGame.repaint();
			}
			//theGame.changeLayoutCard("TEXT_QUESTION");
			break;
		
		
			
		case 4:	
			System.out.println("END OF LEVEL ONE");
			theGame.incrementLevel();
			theGame.forestPanel.repaintForestPanel();
			theGame.changeLayoutCard("FOREST");
			break;
	
		}
	}
}