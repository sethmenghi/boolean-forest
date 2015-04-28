/**
 * LEVELONE CLASS
 * 
 * DESCRIPTION: This class contains content for level one explanation
 * and handles the content for the questions for level one.
 * 
 * IMAGE SOURCES:
 * 1) http://sweetclipart.com/multisite/sweetclipart/files/penguin_
 *    cute.png
 * 2) http://yunus.hacettepe.edu.tr/~osert/Hotpot_2014_02/02_erdemli_
 *    batibay/coffee%20table.jpg 
 * 3) https://s-media-cache-ak0.pinimg.com/236x/6b/c5/37/
 *    6bc537a241ffc746acb7d2180d2253d8.jpg
 * 4) http://www.wpclipart.com/cartoon/animals/horse/horse_cartoon_
 *    zebra.png
 * 5) http://www.how-to-draw-funny-cartoons.com/image-files/cartoon-
 *    flamingo-8.gif
 */

package Levels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.Game;

public class LevelOne {
	// Declare private String for Bob resource:
	private static final String BOB_SRC = "/Images/Owls/Bob.png";		// Bob url
	
	// Declare static final Strings for explanations:
	public static final String PAGE_TRUE = "TRUE";						// page 1	
	public static final String PAGE_TRUE_A = "This is a penguin.";		// page 2
	public static final String PAGE_TRUE_B = "The color is blue.";		// page 3	
	public static final String PAGE_FALSE = "FALSE";					// page 4	
	public static final String PAGE_FALSE_A = "This is a cup.";			// page 5
	public static final String PAGE_FALSE_B = "The color is yellow.";	// page 6	
	public static final String TRUE_STATEMENT = "This is a TRUE statement.";
	public static final String FALSE_STATEMENT = "This is a FALSE statement.";
	
	// Declare static final Strings for question images:
	private static final String IMAGE_ONE = "/Images/Levels/LevelOne/Questions/Monkey.png";
	private static final String IMAGE_TWO = "/Images/Levels/LevelOne/Questions/Zebra.png";
	private static final String IMAGE_THREE = "/Images/Levels/LevelOne/Questions/Flamingo.png";
	
	// Declare static final String for questions:
	private static final String Q_ONE = "This is a monkey.";
	private static final String Q_TWO = "The zebra has stripes.";
	private static final String Q_THREE = "The flamingo is blue.";
	
	// Declare static final String for question answer choices:
	private static final String ANSWER_TRUE = "True";
	private static final String ANSWER_FALSE = "False";
	
	// Declare private members of the LevelOne class:
	private Game theGame;											// to create reference to main game
	private int currentQuestion;									// current question being asked
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	// holds list of answers for question 1
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	// holds list of answers for question 2
	private List<String> ANSWERS_THREE = new ArrayList<String>();	// holds list of answers for question 3
	
	/**
	 * CONSTRUCTOR: This creates an instance of the LevelOne class
	 * and creates a reference to the main game.
	 * @param game
	 */
	public LevelOne(Game game) {
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
				addPossibleAnswers(ANSWERS_ONE, ANSWER_TRUE, ANSWER_FALSE);		// fill answer choice list with choices
				theGame.textQuestion.setQuestion(Q_ONE);						// set to first question
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);				// set image used for first question
				theGame.textQuestion.setAnswerList(ANSWERS_ONE, ANSWER_TRUE);	// set the answer
				theGame.textQuestion.initGui();									// call initGui form textQuestion class
				theGame.changeLayoutCard("TEXT_QUESTION");						// change card layout to TextQuestion
			}
			break;
		// For the second question:
		case 2:	
			if (ANSWERS_TWO.size() == 0) {
				addPossibleAnswers(ANSWERS_TWO, ANSWER_TRUE, ANSWER_FALSE);		// fill answer choice list with choices
				theGame.textQuestion.setQuestion(Q_TWO);						// set to second question
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);				// set image used for second question
				theGame.textQuestion.setAnswerList(ANSWERS_TWO, ANSWER_TRUE);	// set the answer
				theGame.textQuestion.initGui();									// call initGui form textQuestion class
			}
			break;
		// For the third question:
		case 3:	
			if (ANSWERS_THREE.size() == 0) {
				addPossibleAnswers(ANSWERS_THREE, ANSWER_TRUE, ANSWER_FALSE);	// fill answer choice list with choices
				theGame.textQuestion.setQuestion(Q_THREE);						// set to third question
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);				// set image used for third question
				theGame.textQuestion.setAnswerList(ANSWERS_THREE, ANSWER_FALSE);	// set the answer
				theGame.textQuestion.initGui();									// call initGui form textQuestion class
			}
			break;
		// After completing the questions:
		case 4:	
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