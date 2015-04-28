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

	//http://www.how-to-draw-funny-cartoons.com/image-files/cartoon-camel-12.gif
	private static final String Q_ONE = "The camel ____.";
	private static final String IMAGE_ONE = "/Images/Levels/LevelFour/Questions/Camel.png";
	private static final String Q_ONE_OPTION_1 = "is not standing";
	private static final String Q_ONE_OPTION_2 = "does not have three humps";
	private static final String Q_ONE_OPTION_3 = "does not have hair";
	private static final String Q_ONE_OPTION_4 = "is not brown";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	public final Image CAMEL = new ImageIcon(getClass().getResource(IMAGE_ONE)).getImage();


	//http://cliparts.co/cliparts/6cy/Xxo/6cyXxopdi.jpg
	private static final String Q_TWO = "Choose the CORRECT answer.";
	private static final String IMAGE_TWO = "/Images/Levels/LevelFOUR/Questions/vulture.png";
	private static final String Q_TWO_OPTION_1 = "This is not a bird."; 
	private static final String Q_TWO_OPTION_2 = "The animal is not sitting." ;
	private static final String Q_TWO_OPTION_3 = "The animal is not brown.";
	private static final String Q_TWO_OPTION_4 = "The animal is not eating.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	public final Image VULTURE = new ImageIcon(getClass().getResource(IMAGE_TWO)).getImage();

	//http://www.clipartbest.com/cliparts/eiM/n89/eiMn89Lin.jpeg
	private static final String Q_THREE = "The cactus is ____.";
	private static final String IMAGE_THREE = "/Images/Levels/LevelFour/Questions/Cactus.png";
	private static final String Q_THREE_OPTION_1 = "not a tree or animal"; 
	private static final String Q_THREE_OPTION_2 = "not a plant or green";
	private static final String Q_THREE_OPTION_3 = "not prickly or painful";
	private static final String Q_THREE_OPTION_4 = "not found in a desert";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	public final Image CACTUS = new ImageIcon(getClass().getResource(IMAGE_THREE)).getImage();

	//http://cliparts.co/cliparts/8T6/86E/8T686EEyc.png
	private static final String Q_FOUR = "The animal is not a ____ and ____.";
	private static final String IMAGE_FOUR = "/Images/Levels/LevelFour/Questions/Snake.png";
	private static final String Q_FOUR_OPTION_1 = "snake, green";
	private static final String Q_FOUR_OPTION_2 = "snake, blue";
	private static final String Q_FOUR_OPTION_3 = "squirrel, green";
	private static final String Q_FOUR_OPTION_4 = "squirrel, blue";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	public final Image SNAKE = new ImageIcon(getClass().getResource(IMAGE_FOUR)).getImage();

	//http://www.clker.com/cliparts/6/e/a/5/1318356706177123419Coyote%20Cartoon.svg.hi.png
	private static final String Q_FIVE = "The coyote is ____ and not ____";
	private static final String IMAGE_FIVE = "/Images/Levels/LevelFour/Questions/Coyote.png";
	private static final String Q_FIVE_OPTION_1 = "brown, sitting";
	private static final String Q_FIVE_OPTION_2 = "black, sitting";
	private static final String Q_FIVE_OPTION_3 = "brown, standing";
	private static final String Q_FIVE_OPTION_4 = "black, standing";
	private List<String> ANSWERS_FIVE = new ArrayList<String>(); 	
	public final Image COYOTE = new ImageIcon(getClass().getResource(IMAGE_FIVE)).getImage();


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
			JLabel warningImage = new JLabel(new ImageIcon(getClass().getResource("/Images/Owls/Bob.png")));
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
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_THREE_OPTION_1);
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
				theGame.textQuestion.setAnswerList(ANSWERS_FIVE,Q_FIVE_OPTION_1);
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