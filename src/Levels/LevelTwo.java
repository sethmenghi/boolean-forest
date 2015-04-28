/**
 * LEVELONE CLASS
 * 
 * DESCRIPTION: This class contains content for level one explanation
 * and handles the content for the questions for level one.
 * 
 * IMAGE SOURCES:
 * 1) http://images.clipartpanda.com/dogs-clipart-cute_little_
 *    cartoon_puppy_dog_with_a_dog_bone_in_its_mouth_0515-1101-
 *    2819-1202_SMU.jpg
 * 2) http://cliparts.co/cliparts/8TA/6zo/8TA6zoKGc.png
 * 3) http://content.mycutegraphics.com/graphics/duck/birthday-
 *    party-duck.png
 * 4) https://s-media-cache-ak0.pinimg.com/736x/42/78/4a/
 *    42784aaee85ecd3bedd1bd9f436bbb86.jpg
 * 5) https://www.wordans.com/wvc-1374530565/wordansfiles/
 *    images/2013/7/22/200382/200382_340.jpg
 * 6) http://www.wikihow.com/images/d/d4/Draw-an-Octopus-Step-16-
 *    Version-2.jpg
 * 7) http://images.clipartpanda.com/seal-clip-art-seal-clipart
 *    -4.jpg
 * 8) http://www.clipartbest.com/cliparts/ace/M8e/aceM8egc4.png
 */

package Levels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.*;

public class LevelTwo {
	// Declare private String for Bob resource:
	private static final String BOB_SRC = "/Images/Owls/Bob.png";							// Bob url
	
	// Declare static final Strings for explanations:
	public static final String PAGE_AND = "AND";											// page 1
	public static final String PAGE_TRUE_A = "This is a dog AND it has a bone.";			// page 2
	public static final String PAGE_TRUE_B = "The is a teddy bear AND it is brown.";		// page 3 	
	public static final String PAGE_FALSE_A = "This is a cat AND its hat is orange.";		// page 4
	public static final String PAGE_FALSE_B = "This is a pie AND it has a candle.";			// page 5	
	public static final String TRUE_STATEMENT = "This is RIGHT!\nBoth statements are true.";
	public static final String FALSE_STATEMENT = "This is WRONG! Both statements are not\n"
			+ "true. Unless BOTH are true, it is wrong.";	
	
	// Declare static final Strings for question images:
	private static final String IMAGE_ONE = "/Images/Levels/LevelTwo/Questions/DolphinSaxaphone.png";
	private static final String IMAGE_TWO = "/Images/Levels/LevelTwo/Questions/Octopus.png";
	private static final String IMAGE_THREE = "/Images/Levels/LevelTwo/Questions/Seal.png";
	private static final String IMAGE_FOUR = "/Images/Levels/LevelTwo/Questions/Orca.png";
	
	// Declare static final String for questions:
	private static final String Q_ONE = "This is a _____ AND it is playing the _____";
	private static final String Q_TWO = "This is an _____ AND she is _____ ";
	private static final String Q_THREE = "This is a _____ AND she is playing with a ______";
	private static final String Q_FOUR = "This is a _______ AND his eyes are _______";
	
	// Declare static final String for question answer choices for Question 1:	
	private static final String Q_ONE_OPTION_1 = "dolphin, piano";
	private static final String Q_ONE_OPTION_2 = "dolphin, saxophone";
	private static final String Q_ONE_OPTION_3 = "shark, piano";
	private static final String Q_ONE_OPTION_4 = "shark, saxophone";
	
	// Declare static final String for question answer choices for Question 2:	
	private static final String Q_TWO_OPTION_1 = "anglefish, pink";
	private static final String Q_TWO_OPTION_2 = "octopus, blue";
	private static final String Q_TWO_OPTION_3 = "anglefish, purple";
	private static final String Q_TWO_OPTION_4 = "octopus, pink";
	
	// Declare static final String for question answer choices for Question 3:	
	private static final String Q_THREE_OPTION_1 = "dolphin, ball";
	private static final String Q_THREE_OPTION_2 = "seal,yo-yo ";
	private static final String Q_THREE_OPTION_3 = "seal, ball";
	private static final String Q_THREE_OPTION_4 = "fish, ball";
	
	// Declare static final String for question answer choices for Question 4:	
	private static final String Q_FOUR_OPTION_1 = "whale, blue";
	private static final String Q_FOUR_OPTION_2 = "dolphin,bue ";
	private static final String Q_FOUR_OPTION_3 = "whale, brown";
	private static final String Q_FOUR_OPTION_4 = "shark, blue";
	
	// Declare private members of the LevelOne class:
	private Game theGame;											// to create reference to main game
	private int currentQuestion;									// current question being asked
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	// holds list of answers for question 1
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	// holds list of answers for question 2
	private List<String> ANSWERS_THREE = new ArrayList<String>();	// holds list of answers for question 3
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	// holds list of answers for question 4
	
	/**
	 * CONSTRUCTOR: This creates an instance of the LevelTwo class
	 * and creates a reference to the main game.
	 * @param game
	 */
	public LevelTwo(Game game) {
		this.theGame = game;										// creates a reference to the main game
	}
	
	/**
	 * METHOD: This method is called from the LevelPanel for Level
	 * 1 and calls the doQuestion method to go through the questions
	 * for LevelOne class.
	 * @param none
	 */
	public void startLevel() {
		currentQuestion = 1;										// set currentQuestion to 1
		doQuestion();												// call doQuestion
	}
	
	/**
	 * METHOD: This goes through and fills the Lists for each question
	 * with the correct answer choices and sets the text question with
	 * the proper content.
	 * @param none
	 */
	public void doQuestion() {
		switch (currentQuestion) {
		// For the first question:
		case 1:
			if (ANSWERS_ONE.size() == 0) {
				addPossibleAnswers(ANSWERS_ONE, Q_ONE_OPTION_1, Q_ONE_OPTION_2, Q_ONE_OPTION_3, Q_ONE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_ONE);
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);
				theGame.textQuestion.setAnswerList(ANSWERS_ONE, Q_ONE_OPTION_2);
				theGame.textQuestion.initGui();
			}
			break;
		// For the second question:
		case 2:	
			if (ANSWERS_TWO.size() == 0) {
				addPossibleAnswers(ANSWERS_TWO, Q_TWO_OPTION_1, Q_TWO_OPTION_2, Q_TWO_OPTION_3, Q_TWO_OPTION_4);
				theGame.textQuestion.setQuestion(Q_TWO);
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);
				theGame.textQuestion.setAnswerList(ANSWERS_TWO, Q_TWO_OPTION_4);
				theGame.textQuestion.initGui();
			}
			break;
		// For the third question:
		case 3:	
			if (ANSWERS_THREE.size() == 0) {
				addPossibleAnswers(ANSWERS_THREE, Q_THREE_OPTION_1, Q_THREE_OPTION_2, Q_THREE_OPTION_3, Q_THREE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_THREE);
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);
				theGame.textQuestion.setAnswerList(ANSWERS_THREE, Q_THREE_OPTION_3);
				theGame.textQuestion.initGui();
			}
			break;
		// For the fourth question:
		case 4:	
			if (ANSWERS_FOUR.size() == 0) {
				addPossibleAnswers(ANSWERS_FOUR,  Q_FOUR_OPTION_1, Q_FOUR_OPTION_2, Q_FOUR_OPTION_3, Q_FOUR_OPTION_4);
				theGame.textQuestion.setQuestion(Q_FOUR);
				theGame.textQuestion.setQuestionImage(IMAGE_FOUR);
				theGame.textQuestion.setAnswerList(ANSWERS_FOUR, Q_FOUR_OPTION_1);
				theGame.textQuestion.initGui();
			}
			break;
		// After completing the questions:
		case 5:	
			theGame.incrementLevel();											// increment the level of the game
			theGame.changeLayoutCard("FOREST");									// go back to the ForestPanel
			break;
		}
	}
	
	/**
	 *METHOD: Add the possible answer choices to each question's
	 * List that holds it's possible answer choices.
	 * @param holdsPossibleAnswers
	 * @param option1
	 * @param option2
	 * @param option3
	 * @param option4
	 */
	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2,
			                       String option3, String option4) {
		holdsPossibleAnswers.add(option1);										// add first string parameter 
		holdsPossibleAnswers.add(option2);										// add second string parameter
		holdsPossibleAnswers.add(option3);										// add first third parameter 
		holdsPossibleAnswers.add(option4);										// add second fourth parameter
	}
	
	/**
	 * METHOD: This method calls the next question once the correct
	 * answer is selected from the previous question.
	 * @param none
	 */
	public void nextQuestion() {
		// Once the correct answer is selected, increment currentQuestion
		// and call doQuestion again.
		if (theGame.textQuestion.questionCompleted == true) {
			currentQuestion++;													// increment currentQuestion
			doQuestion();														// call doQuestion
		}
		// Otherwise, it throws an error.
		else {
			JLabel warningImage = new JLabel(new ImageIcon(getClass().getResource(BOB_SRC)));
			JOptionPane.showMessageDialog(null, warningImage, "Question", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
}