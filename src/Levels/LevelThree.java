/**
 * LEVELTHREE CLASS
 * 
 * DESCRIPTION: This class contains content for level three explanation
 * and handles the content for the questions for level three.
 * 
 * IMAGE SOURCES:
 * 1) http://41.media.tumblr.com/c3eb422708f7d7691f985f8541945197/
 *    tumblr_mnczrreGAP1s5jjtzo1_1280.png
 * 2) http://www.penguincorner.com/website/coloring/createonline/
 *    clipart/nature/flowers/detailedsunflower.png
 * 3) http://www.clipartbest.com/cliparts/dcr/Kek/dcrKekgc9.png
 * 4) https://derpicdn.net/img/2013/4/30/311987/full.png
 * 5) http://cliparts.co/cliparts/kcM/nAL/kcMnALeki.jpg
 * 6) http://cliparts.co/cliparts/kc8/oKy/kc8oKydji.png
 * 7) http://www.clipartbest.com/cliparts/Bdc/r6k/Bdcr6koT9.jpeg
 * 8) http://www.how-to-draw-funny-cartoons.com/image-files/
 *    cartoon-hippo-8.gif
 */

package Levels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.Game;

public class LevelThree {
	// Declare private String for Bob resource:
	private static final String BOB_SRC = "/Images/Owls/Bob.png";						// Bob url
		
	// Declare static final Strings for explanations:
	public static final String PAGE_OR = "OR";											// page 1	
	public static final String PAGE_TRUE_A = "This is a donut OR a cake.";				// page 2
	public static final String PAGE_TRUE_B = "This is a flower OR a tree.";				// page 3		
	public static final String PAGE_FALSE_A = "This is a book OR a table.";				// page 4
	public static final String PAGE_FALSE_B = "It is eating an apple OR a lemon.";		// page 5	
	public static final String TRUE_STATEMENT = "This is RIGHT!\nOnly one statement needs to be true.";
	public static final String FALSE_STATEMENT = "This is WRONG!\nBoth statements are false.";
	
	// Declare static final Strings for question images:
	private static final String IMAGE_ONE = "/Images/Levels/LevelThree/Questions/Giraffe.png";
	private static final String IMAGE_TWO = "/Images/Levels/LevelThree/Questions/Elephant.png";
	private static final String IMAGE_THREE = "/Images/Levels/LevelThree/Questions/Lion.png";
	private static final String IMAGE_FOUR = "/Images/Levels/LevelThree/Questions/Hippo.png";
	
	// Declare static final String for questions:
	private static final String Q_ONE = "The giraffe is yellow OR pink.";
	private static final String Q_TWO = "The elephant is eating OR sleeping.";
	private static final String Q_THREE = "The lion is ____.";
	private static final String Q_FOUR = "The hippo has ____.";
	
	// Declare static final String for question answer choices for Question 1: 
	private static final String Q_ONE_OPTION_1 = "True";
	private static final String Q_ONE_OPTION_2 = "False";
	
	// Declare static final String for question answer choices for Question 2:
	private static final String Q_TWO_OPTION_1 = "True";
	private static final String Q_TWO_OPTION_2 = "False";
	
	// Declare static final String for question answer choices for Question 3: 
	private static final String Q_THREE_OPTION_1 = "white OR spotted";
	private static final String Q_THREE_OPTION_2 = "yellow OR orange";
	private static final String Q_THREE_OPTION_3 = "running OR growling";
	private static final String Q_THREE_OPTION_4 = "singing OR studying";
	
	// Declare static final String for question answer choices for Question 3: 
	private static final String Q_FOUR_OPTION_1 = "2 OR 4 teeth AND is purple";
	private static final String Q_FOUR_OPTION_2 = "2 OR 4 teeth AND is pink";
	private static final String Q_FOUR_OPTION_3 = "1 OR 4 teeth AND is purple";
	private static final String Q_FOUR_OPTION_4 = "1 OR 2 teeth AND is blue";
	
	// Declare private members of the LevelThree class:
	private Game theGame;											// to create reference to main game
	private int currentQuestion;									// current question being asked
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	// holds list of answers for question 1
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	// holds list of answers for question 2
	private List<String> ANSWERS_THREE = new ArrayList<String>();	// holds list of answers for question 3
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	// holds list of answers for question 4
	
	/**
	 * CONSTRUCTOR: This creates an instance of the LevelThree class
	 * and creates a reference to the main game.
	 * @param game
	 */
	public LevelThree(Game game) {
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
				addPossibleAnswers(ANSWERS_ONE, Q_ONE_OPTION_1, Q_ONE_OPTION_2);// fill answer choice list with choices
				theGame.textQuestion.setQuestion(Q_ONE);						// set to first question
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);				// set image used for first question
				theGame.textQuestion.setAnswerList(ANSWERS_ONE, Q_ONE_OPTION_1);// set the answer
				theGame.textQuestion.initGui();									// call initGui form textQuestion class
				theGame.changeLayoutCard("TEXT_QUESTION");						// change card layout to TextQuestion
			}
			break;
		// For the second question:
		case 2:	
			if (ANSWERS_TWO.size() == 0) {
				addPossibleAnswers(ANSWERS_TWO, Q_TWO_OPTION_1, Q_TWO_OPTION_2);// fill answer choice list with choices
				theGame.textQuestion.setQuestion(Q_TWO);						// set to second question
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);				// set image used for second question
				theGame.textQuestion.setAnswerList(ANSWERS_TWO, Q_TWO_OPTION_2);// set the answer
				theGame.textQuestion.initGui();									// call initGui form textQuestion class
			}
			break;
		// For the third question:
		case 3:	
			if (ANSWERS_THREE.size() == 0) {
				addPossibleAnswers(ANSWERS_THREE, Q_THREE_OPTION_1, Q_THREE_OPTION_2, Q_THREE_OPTION_3, Q_THREE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_THREE);
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);
				theGame.textQuestion.setAnswerList(ANSWERS_THREE, Q_THREE_OPTION_2);
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
		default:
			break;
		}
	}
	
	/**
	 * METHOD: Add the possible answer choices to each question's
	 * List that holds it's possible answer choices.
	 * @param holdsPossibleAnswers
	 * @param option1
	 * @param option2
	 */
	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2){
		holdsPossibleAnswers.add(option1);										// add first string parameter 
		holdsPossibleAnswers.add(option2);										// add second string parameter
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