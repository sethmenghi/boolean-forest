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
	
	// https://s-media-cache-ak0.pinimg.com/236x/6b/c5/37/6bc537a241ffc746acb7d2180d2253d8.jpg
	private static final String Q_ONE = "This is a monkey.";
	private static final String IMAGE_ONE = "Images/Levels/LevelOne/Questions/Monkey.png";
	private static final String Q_ONE_OPTION_1 = "True";
	private static final String Q_ONE_OPTION_2 = "False";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	
	//http://www.wpclipart.com/cartoon/animals/horse/horse_cartoon_zebra.png
	private static final String Q_TWO = "The zebra has stripes.";
	private static final String IMAGE_TWO = "Images/Levels/LevelOne/Questions/Zebra.png";
	private static final String Q_TWO_OPTION_1 = "True.";
	private static final String Q_TWO_OPTION_2 = "False.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	
	//http://www.how-to-draw-funny-cartoons.com/image-files/cartoon-flamingo-8.gif
	private static final String  Q_THREE = "The flamingo is blue.";
	private static final String IMAGE_THREE = "Images/Levels/LevelOne/Questions/Flamingo.png";
	private static final String Q_THREE_OPTION_1 = "True.";
	private static final String Q_THREE_OPTION_2 = "False.";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	

	private Game theGame;
	private int currentQuestion = 1;
	
	public LevelOne(Game game) {
		theGame = game;
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
			currentQuestion++;
			doQuestion();
		}
		else{
			JLabel warningImage = new JLabel(new ImageIcon("Images/Owls/Bob.png"));
			JOptionPane.showMessageDialog(null, warningImage, "Question", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	public void doQuestion() {
		switch (currentQuestion) {
		case 1:
			if (ANSWERS_ONE.size() == 0){
				addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_2);
				theGame.textQuestion.setQuestion(Q_ONE);
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);
				theGame.textQuestion.setAnswerList(ANSWERS_ONE,Q_ONE_OPTION_1);
				theGame.textQuestion.initGui();
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
			}
			break;
		case 3:	
			if (ANSWERS_THREE.size() == 0){
				addPossibleAnswers(ANSWERS_THREE,  Q_THREE_OPTION_1,  Q_THREE_OPTION_2);
				theGame.textQuestion.setQuestion(Q_THREE);
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_TWO_OPTION_2);
				theGame.textQuestion.initGui();
			}
			break;
		
		
			
		case 4:	
			theGame.incrementLevel();
			System.out.println("Level Number in Level One: " + theGame.getLevel());
			theGame.changeLayoutCard("FOREST");
			break;
	
		}
	}
}