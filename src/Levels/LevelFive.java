/**
 * LEVELFIVE CLASS
 * 
 * DESCRIPTION: This class contains content for level five explanation
 * and handles the content for the questions for level five.
 * 
 * IMAGE SOURCES:
 * All images drawn by Leslie Kim.
 */

package Levels;

import java.util.ArrayList;

import BooleanForest.Game;

public class LevelFive {
	
	// The different image options that the user can select
	private static final String IMAGE_OPTION_ONE="/Images/DragDrop/BasketBallImage.png";
	private static final String IMAGE_OPTION_TWO="/Images/DragDrop/GlassesImage.png";
	private static final String IMAGE_OPTION_THREE="/Images/DragDrop/HatImage.png";
	private static final String IMAGE_OPTION_FOUR="/Images/DragDrop/ScarfImage.png";
	private static final String IMAGE_OPTION_FIVE="/Images/DragDrop/SoccerBallImage.png";
	private static final String IMAGE_OPTION_SIX="/Images/DragDrop/TieImage.png";
	
	// The different question texts 
	private static final String QUESTION_ONE_TEXT= "The Owl is wearing glasses AND has a soccer ball.";
	private static final String QUESTION_TWO_TEXT= "The Owl is NOT wearing a hat and a tie.";
	private static final String QUESTION_THREE_TEXT= "The Owl is wearing a tie AND has a ball.";
	private static final String QUESTION_FOUR_TEXT= "The Owl is wearing 2 items AND has no balls.";
	private static final String QUESTION_FIVE_TEXT= "The Owl is wearing a hat AND has a basketball OR soccerball.";
	
	public static final String LEVEL_5_INTRO="Let's put it all together!";

	// Declare static final Strings for questions:
	private static final String Q_ONE= "Bob is wearing glasses AND has a soccer ball.";
	private static final String Q_TWO= "Bob is NOT wearing a hat AND a tie.";
	private static final String Q_THREE= "Bob is wearing a tie AND has a ball.";
	private static final String Q_FOUR= "Bob is wearing 2 items of clothing AND has no balls.";
	private static final String Q_FIVE= "Bob is wearing a hat AND has a basketball OR soccerball";

	// Declare private members of the LevelFive class:  
	private Game theGame;											// to create reference to main game 
	public int currentQuestion;									// current question being asked 
	private ArrayList <String> listOfOptions;						// list of possible draggable icons 

	/**
	 * CONSTRUCTOR: This creates an instance of the LevelThree class
	 * and creates a reference to the main game.
	 * @param game
	 */
	public LevelFive(Game game) {
		this.theGame = game;										// creates a reference to the main game
	}

	/**
	 * METHOD: Initialize the level by setting the currentQuestion
	 * to 1 and populating listOfOptions with the icons. Also sets
	 * the level content.
	 * @param none
	 */
	public void initLevel() {
		currentQuestion = 1;										// set currentQuestion to 1
		populateListWithOptions(); 									// create the array list of options
		setContent();												// set the level content
	}

	/**
	 * METHOD: Populates the arraylist with the icon images.
	 * @param none
	 */
	public void populateListWithOptions() {
		listOfOptions= new ArrayList<String>();						// initialize the ArrayList
		listOfOptions.add(IMAGE_OPTION_ONE);						// add basketball
		listOfOptions.add(IMAGE_OPTION_TWO);						// add glasses
		listOfOptions.add(IMAGE_OPTION_THREE);						// add hat
		listOfOptions.add(IMAGE_OPTION_FOUR);						// add scarf
		listOfOptions.add(IMAGE_OPTION_FIVE);						// add soccer ball
		listOfOptions.add(IMAGE_OPTION_SIX);						// add tie
	}

	/**
	 * METHOD: This method controls the level and switches from
	 * question to question and updates the content.
	 * @param none
	 */
	public void setContent() {
		switch(currentQuestion) {
		// For the first question:
		case 1:
			theGame.dragAndDropQuestion.setQuestionText(Q_ONE);
			theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
			theGame.dragAndDropQuestion.setAnswersForEachItem(false, true, false, false, true, false); 
			theGame.dragAndDropQuestion.initGUI();												
			theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");									
			break;
		// For the second question:
		case 2: 																	
			theGame.dragAndDropQuestion.setQuestionText(Q_TWO);
			theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
			theGame.dragAndDropQuestion.setAnswersForEachItem(true, true ,false, true, true, false);
			theGame.dragAndDropQuestion.initGUI();
			theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
			break;
		// For the third question:
		case 3:
			theGame.dragAndDropQuestion.setQuestionText(Q_THREE);
			theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
			theGame.dragAndDropQuestion.setAnswersForEachItem(true,false,false,false,true,true);
			theGame.dragAndDropQuestion.initGUI();
			theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
			break;
		// For the fourth question:
		case 4:
			theGame.dragAndDropQuestion.setQuestionText(Q_FOUR);
			theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
			theGame.dragAndDropQuestion.setAnswersForEachItem(false, true, true, true, false, true);
			theGame.dragAndDropQuestion.initGUI();
			theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
			break;
		// For the fifth question:
		case 5:
			theGame.dragAndDropQuestion.setQuestionText(Q_FIVE);
			theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
			theGame.dragAndDropQuestion.setAnswersForEachItem(true, false, true, false, true, false);
			theGame.dragAndDropQuestion.initGUI();
			theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
			break;
			// After completing the questions:
		case 6:
			theGame.incrementLevel();											// increment the level of the game
			theGame.changeLayoutCard("FOREST");									// go back to the ForestPanel
			break;
		default:
			break; 
		}	
	}

	/**
	 * METHOD: This method is called by the DragAndDropQuestion
	 * class to move to the next question.
	 * @param none
	 */
	public void nextQuestion(){
		currentQuestion++;														// increment currentQuestion
		setContent(); 															// update the content 
	}
}
