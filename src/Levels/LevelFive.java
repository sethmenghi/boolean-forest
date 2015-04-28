/**
 * IMAGE SOURCES:
 * 1) http://images.all-free-download.com/images/graphiclarge/
 *    gioppino_basketball_clip_art_18990.jpg
 * 2) http://www.clker.com/cliparts/S/3/L/6/C/v/black-glasses-
 *    hi.png
 * 3) http://cliparts.co/cliparts/rTj/K5B/rTjK5BKkc.svg
 * 4) http://cliparts.co/cliparts/8iz/KnX/8izKnX94T.png
 * 5) http://www.how-to-draw-funny-cartoons.com/image-files/
 *    cartoon-soccer-6.jpg
 * 6) https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQjMjlbF
 *    -N8pl1mq_z2uafR9d0s8F6J5k0wjvQo-CFsyzgKj4nt4kG8u7Q
 */

package Levels;

import java.awt.List;
import java.util.ArrayList;

import BooleanForest.Game;
import Questions.DragAndDropQuestion;

public class LevelFive {
	// Declare static final Strings for explanations:
	public static final String LEVEL_5_INTRO = "Let's put it all together!";					// page 1
	
	// The different image options that the user can select
	private static final String IMAGE_OPTION_ONE="Images/DragDrop/BasketBallImage.png";
	private static final String IMAGE_OPTION_TWO="Images/DragDrop/GlassesImage.png";
	private static final String IMAGE_OPTION_THREE="Images/DragDrop/HatImage.png";
	private static final String IMAGE_OPTION_FOUR="Images/DragDrop/ScarfImage.png";
	private static final String IMAGE_OPTION_FIVE="Images/DragDrop/SoccerBallImage.png";
	private static final String IMAGE_OPTION_SIX="Images/DragDrop/TieImage.png";
	
	// The different question texts 
	private static final String QUESTION_ONE_TEXT= "The Owl is wearing glasses AND has a soccer ball";
	private static final String QUESTION_TWO_TEXT= "The Owl is NOT wearing a hat and a tie";
	private static final String QUESTION_THREE_TEXT= "The Owl is wearing a tie AND has a ball";

	
	private static final String ORIGINAL_OWL = "Images/Levels/LevelFive/Questions/Bob.png";
	private static final String CORRECT_ANSWER_OWL = "Images/Levels/LevelFive/Questions/BobGlassesSoccerBall.png";


	private static final int QUESTION_ONE_CORRECT_ANSWER_ONE=2;
	private static final int QUESTION_ONE_CORRECT_ANSWER_TWO=5;
	
	private static final String QUESTION_ONE_CORRECT_IMAGE_ONE="Images/Levels/LevelFive/Questions/BobGlasses.png";
	private static final String QUESTION_ONE_CORRECT_IMAGE_TWO="Images/Levels/LevelFive/Questions/BobSoccerBall.png";

	Game theGame;

	private int questionInLevel; 
	private ArrayList <String> listOfOptions;
	
	public LevelFive(Game game)
	{
		theGame = game;
	}

	public void initLevel(){
		
		questionInLevel=1; 
		populateListWithOptions(); 
		setContent();
	}
	
	public void setContent(){
		
		switch(questionInLevel){
			case 1:
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_ONE_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setOriginalOwlImage(ORIGINAL_OWL);
				theGame.dragAndDropQuestion.setCorrectOwlImage(CORRECT_ANSWER_OWL);
				theGame.dragAndDropQuestion.setCorrectAnswerIndexes(QUESTION_ONE_CORRECT_ANSWER_ONE,QUESTION_ONE_CORRECT_ANSWER_TWO);
				theGame.dragAndDropQuestion.setCorrectAnswerImages(QUESTION_ONE_CORRECT_IMAGE_ONE,QUESTION_ONE_CORRECT_IMAGE_TWO);
				theGame.dragAndDropQuestion.setAnswersForEachItem(false,true,false,false,true,false);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
                break;
                
			case 2: 
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_TWO_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setOriginalOwlImage(ORIGINAL_OWL);
				theGame.dragAndDropQuestion.setCorrectOwlImage(CORRECT_ANSWER_OWL);
				theGame.dragAndDropQuestion.setCorrectAnswerIndexes(QUESTION_ONE_CORRECT_ANSWER_ONE,QUESTION_ONE_CORRECT_ANSWER_TWO);
				theGame.dragAndDropQuestion.setCorrectAnswerImages(QUESTION_ONE_CORRECT_IMAGE_ONE,QUESTION_ONE_CORRECT_IMAGE_TWO);
				theGame.dragAndDropQuestion.setAnswersForEachItem(true,true,false,true,true,false);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
                break;
                
			case 3:
				theGame.dragAndDropQuestion.setQuestionText(QUESTION_THREE_TEXT);
				theGame.dragAndDropQuestion.setListOfPossibleAnswers(listOfOptions);
				theGame.dragAndDropQuestion.setOriginalOwlImage(ORIGINAL_OWL);
				theGame.dragAndDropQuestion.setCorrectOwlImage(CORRECT_ANSWER_OWL);
				theGame.dragAndDropQuestion.setCorrectAnswerIndexes(QUESTION_ONE_CORRECT_ANSWER_ONE,QUESTION_ONE_CORRECT_ANSWER_TWO);
				theGame.dragAndDropQuestion.setCorrectAnswerImages(QUESTION_ONE_CORRECT_IMAGE_ONE,QUESTION_ONE_CORRECT_IMAGE_TWO);
				theGame.dragAndDropQuestion.setAnswersForEachItem(true,false,false,false,true,true);
				theGame.dragAndDropQuestion.initGUI();
				theGame.changeLayoutCard("DRAG_AND_DROP_QUESTION");
				break;
				//

            default:
            	break; 

		}	
		
	}
	
	public void nextQuestion(){
		
		questionInLevel++;
		setContent(); 
		
	}
	
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
