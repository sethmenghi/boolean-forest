package Levels;

import java.awt.List;
import java.util.ArrayList;

import BooleanForest.Game;
import Questions.DragAndDropQuestion;

// This level controls the content of the level five quesions and calls 
// drag and drop question to update teh content 
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

	// Variables for the class  
	Game theGame;								// The game itself 
	public int questionInLevel; 				// Counter that checks which question we are on 
	private ArrayList <String> listOfOptions;	// A list of possible draggable items 
	
	// Constructor just passes the game. Is called in the game class
	public LevelFive(Game game)
	{
		theGame = game;
	}

	// We initialize the level when we want it displayed
	public void initLevel(){
		
		questionInLevel=1; 					// Set counter to first question
		populateListWithOptions(); 			// We create the array list of options
		setContent();						// Set the level content
	}
	
	
	// This is the main method of the level that controls everything
	// It switched from questiont to question and updates the content 
	public void setContent(){
		
		
		switch(questionInLevel){
			case 1:
				
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_ONE_TEXT);								// Set question text
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);						// Pass list of possible answers
				theGame.dragAndDropQuestion.setAnswersForEachItem(false,true,false,false,true,false);		// Pass list of answers that are right and wrong 
				theGame.dragAndDropQuestion.initGUI();														// Initialize the GUI
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");											// Switch to the card
                break;
                
			case 2: 																						// Repeat for each question
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_TWO_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setAnswersForEachItem(true,true,false,true,true,false);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
                break;
                
			case 3:
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_THREE_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setAnswersForEachItem(true,false,false,false,true,true);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
				break;
				
			case 4:
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_FOUR_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setAnswersForEachItem(false,true,true,true,false,true);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
				break;
				
			case 5:
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_FIVE_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setAnswersForEachItem(true,false,true,false,true,false);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
				break;
				
			case 6:
				theGame.incrementLevel();
				theGame.changeLayoutCard("FOREST");
				break;
				
            default:
            	break; 

		}	
		
	}
	
	// Called by the DragAndDropQuestion class to move to next question
	public void nextQuestion(){
		
		questionInLevel++;			// Increment counter
		setContent(); 				// Update the content 
		
	}
	
	// Called once to create the arraylist with all the possible options 
	public void populateListWithOptions(){
		
		listOfOptions= new ArrayList<String>();
		listOfOptions.add(IMAGE_OPTION_ONE);
		listOfOptions.add(IMAGE_OPTION_TWO);
		listOfOptions.add(IMAGE_OPTION_THREE);
		listOfOptions.add(IMAGE_OPTION_FOUR);
		listOfOptions.add(IMAGE_OPTION_FIVE);
		listOfOptions.add(IMAGE_OPTION_SIX);

	}
	
}
