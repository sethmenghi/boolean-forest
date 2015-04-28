/**
 * IMAGE SOURCES:
 * 1) https://encrypted-tbn2.gstatic.com/
 *    images?q=tbn:ANd9GcThb_mOe9Ue3yC7v6slqhqdlr8s97hZ8MhfQqfXPbG_8MDN4aV3
 * 2) http://www.clipartlord.com/wp-content/uploads/2013/03/alien2.png
 * 3) http://www.clker.com/cliparts/1/9/c/7/
 *    12344057871071110537kablam_Heart_-_Glossy_Two.svg.hi.png
 * 4) http://cliparts.co/cliparts/pi7/K46/pi7K46AxT.png
 * 
 */
package Levels;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BooleanForest.*;
import Objects.*;

public class LevelFour {
	// Declare static final Strings for explanations:
	public static final String PAGE_NOT = "NOT";							// page 1	
	public static final String PAGE_TRUE_A = "This is NOT an apple.";		// page 2
	public static final String PAGE_TRUE_B = "This is NOT a person.";		// page 3		
	public static final String PAGE_FALSE_A = "These are NOT hearts.";		// page 5
	public static final String PAGE_FALSE_B = "It is NOT raining.";		// page 6	
	public static final String TRUE_STATEMENT = "This is RIGHT! ";
	public static final String FALSE_STATEMENT = "This is WRONG!";

	// Declare static final Images for explanations:
	public static final Image PUMPKIN = new ImageIcon("Images/Levels/LevelFour/Explanation/Pumpkin.png").getImage();
	public static final Image ALIEN = new ImageIcon("Images/Levels/LevelFour/Explanation/Alien.png").getImage();
	public static final Image HEART = new ImageIcon("Images/Levels/LevelFour/Explanation/Hearts.png").getImage();
	public static final Image RAIN = new ImageIcon("Images/Levels/LevelFour/Explanation/Rain.png").getImage();

	//http://www.how-to-draw-funny-cartoons.com/image-files/cartoon-camel-12.gif
	private static final String Q_ONE = "Choose the correct answer.";
	private static final String IMAGE_ONE = "Images/Levels/LevelFour/Questions/Camel.png";
	private static final String Q_ONE_OPTION_1 = "The camel is not standing.";
	private static final String Q_ONE_OPTION_2 = "The camel does not have three humps.";
	private static final String Q_ONE_OPTION_3 = "This is not a camel.";
	private static final String Q_ONE_OPTION_4 = "The camel is not brown.";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	public static final Image CAMEL = new ImageIcon(IMAGE_ONE).getImage();


	//http://cliparts.co/cliparts/6cy/Xxo/6cyXxopdi.jpg
	private static final String Q_TWO = "Choose the CORRECT answer.";
	private static final String IMAGE_TWO = "Images/Levels/LevelFOUR/Questions/vulture.png";
	private static final String Q_TWO_OPTION_1 = "This is not a bird."; 
	private static final String Q_TWO_OPTION_2 = "The animal is not flying." ;
	private static final String Q_TWO_OPTION_3 = "The animal is not brown.";
	private static final String Q_TWO_OPTION_4 = "The animal is not eating.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	public static final Image VULTURE = new ImageIcon(IMAGE_TWO).getImage();

	//http://www.clipartbest.com/cliparts/eiM/n89/eiMn89Lin.jpeg
	private static final String Q_THREE = "Choose the INCORRECT answer.";
	private static final String IMAGE_THREE = "Images/Levels/LevelFour/Questions/Cactus.png";
	private static final String Q_THREE_OPTION_1 = "This is not a christmas tree."; 
	private static final String Q_THREE_OPTION_2 = "This plant does not have prickly needles." ;
	private static final String Q_THREE_OPTION_3 = "This plant does not grow in the desert.";
	private static final String Q_THREE_OPTION_4 = "This plant is not green.";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	public static final Image CACTUS = new ImageIcon(IMAGE_THREE).getImage();

	//http://cliparts.co/cliparts/8T6/86E/8T686EEyc.png
	private static final String Q_FOUR = "Choose the correct answer.";
	private static final String IMAGE_FOUR = "Images/Levels/LevelFour/Questions/Snake.png";
	private static final String Q_FOUR_OPTION_1 = "This is a lizard and he is not green. ";
	private static final String Q_FOUR_OPTION_2 = "This is not a snake and he is green. ";
	private static final String Q_FOUR_OPTION_3 = "This is not a squirrel and he is blue.";
	private static final String Q_FOUR_OPTION_4 = "This is a snake and he is not brown.";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	public static final Image SNAKE = new ImageIcon(IMAGE_FOUR).getImage();

	//http://www.clker.com/cliparts/6/e/a/5/1318356706177123419Coyote%20Cartoon.svg.hi.png
	private static final String Q_FIVE = "Choose the correct answer.";
	private static final String IMAGE_FIVE = "Images/Levels/LevelFour/Questions/Coyote.png";
	private static final String Q_FIVE_OPTION_1 = "This is not a coyote and the animal is brown.";
	private static final String Q_FIVE_OPTION_2 = "This animal does not live in the ocean and he is a coyote.";
	private static final String Q_FIVE_OPTION_3 = "This is a bird and it is not brown.";
	private static final String Q_FIVE_OPTION_4 = "This is a coyote and he is not brown.";
	private List<String> ANSWERS_FIVE = new ArrayList<String>(); 	
	public static final Image COYOTE = new ImageIcon(IMAGE_FIVE).getImage();


	private Game theGame;
	private int currentQuestion;
	
	public LevelFour(Game game) {
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
		currentQuestion = 1;
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
		
		System.out.println(currentQuestion); 
		
		switch (currentQuestion) {
		case 1:
			if (ANSWERS_ONE.size() == 0){
				addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_2, Q_ONE_OPTION_3, Q_ONE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_ONE);
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);
				theGame.textQuestion.setAnswerList(ANSWERS_ONE,Q_ONE_OPTION_2);
				theGame.textQuestion.initGui();
			}
			break;
		case 2:	
			if (ANSWERS_TWO.size() == 0){
				addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_2, Q_TWO_OPTION_3, Q_TWO_OPTION_4);
				theGame.textQuestion.setQuestion(Q_TWO);
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);
				theGame.textQuestion.setAnswerList(ANSWERS_TWO,Q_TWO_OPTION_4);
				theGame.textQuestion.initGui();
			}
			break;
		case 3:	
			if (ANSWERS_THREE.size() == 0){
				addPossibleAnswers(ANSWERS_THREE,  Q_THREE_OPTION_1,  Q_THREE_OPTION_2, Q_THREE_OPTION_3, Q_THREE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_THREE);
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_THREE_OPTION_4);
				theGame.textQuestion.initGui();
			}
			break;
		
		case 4:	
			if (ANSWERS_FOUR.size() == 0){
				addPossibleAnswers(ANSWERS_FOUR,  Q_FOUR_OPTION_1,  Q_FOUR_OPTION_2, Q_FOUR_OPTION_3, Q_FOUR_OPTION_4);
				theGame.textQuestion.setQuestion(Q_FOUR);
				theGame.textQuestion.setQuestionImage(IMAGE_FOUR);
				theGame.textQuestion.setAnswerList(ANSWERS_FOUR,Q_FOUR_OPTION_4);
				theGame.textQuestion.initGui();
			}
			break;
			
		case 5:	
			if (ANSWERS_FIVE.size() == 0){
				addPossibleAnswers(ANSWERS_FIVE,  Q_FIVE_OPTION_1,  Q_FIVE_OPTION_2, Q_FIVE_OPTION_3, Q_FIVE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_FIVE);
				theGame.textQuestion.setQuestionImage(IMAGE_FIVE);
				theGame.textQuestion.setAnswerList(ANSWERS_FIVE,Q_FIVE_OPTION_2);
				theGame.textQuestion.initGui();
			}
			break;
			
		case 6:	
			theGame.incrementLevel();
			theGame.changeLayoutCard("FOREST");
			break;
	
		}
	}
}