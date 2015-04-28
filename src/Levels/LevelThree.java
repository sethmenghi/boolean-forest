/**
 * IMAGE SOURCES:
 * 1) http://41.media.tumblr.com/c3eb422708f7d7691f985f8541945197/
 *    tumblr_mnczrreGAP1s5jjtzo1_1280.png
 * 2) http://www.penguincorner.com/website/coloring/createonline/
 *    clipart/nature/flowers/detailedsunflower.png
 * 3) http://www.clipartbest.com/cliparts/dcr/Kek/dcrKekgc9.png
 * 4) https://derpicdn.net/img/2013/4/30/311987/full.png
 * 
 */
package Levels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.Game;

//Not question
public class LevelThree {
	// Declare static final Strings for explanations:
	public static final String PAGE_OR = "OR";											// page 1	
	public static final String PAGE_TRUE_A = "This is a donut OR a cake.";				// page 2
	public static final String PAGE_TRUE_B = "This is a flower OR a tree.";				// page 3		
	public static final String PAGE_FALSE_A = "This is a book OR a table.";				// page 4
	public static final String PAGE_FALSE_B = "It is eating an apple OR a lemon.";		// page 5	
	public static final String TRUE_STATEMENT = "This is RIGHT!\nOnly one statement needs to be true.";
	public static final String FALSE_STATEMENT = "This is WRONG!\nBoth statements are false.";
	
	//OR LEVEL 
	
	
	// Question One -- text question
	//http://cliparts.co/cliparts/kcM/nAL/kcMnALeki.jpg
	private static final String Q_ONE = "Choose the CORRECT anwer.";
	private static final String IMAGE_ONE = "/Images/Levels/LevelThree/Questions/giraffe.png";
	private static final String Q_ONE_OPTION_1 = "The giraffe is lying down or he is sleeping.";
	private static final String Q_ONE_OPTION_2 = "The giraffe has blue spots or green spots.";
	private static final String Q_ONE_OPTION_3 = "The giraffe is yellow or pink.";
	private static final String Q_ONE_OPTION_4 = "The giraffe has a short neck or long legs.";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	public static final Image GIRAFFE = new ImageIcon(IMAGE_ONE).getImage();
	
	
	
	//http://cliparts.co/cliparts/kc8/oKy/kc8oKydji.png
	private static final String Q_TWO = "Choose the INCORRECT answer.";
	private static final String IMAGE_TWO = "/Images/Levels/LevelThree/Questions/elephant.png";
	private static final String Q_TWO_OPTION_1 = "The elephant is sitting or standing.";
	private static final String Q_TWO_OPTION_2 = "The elephant is gray or brown.";
	private static final String Q_TWO_OPTION_3 = "The elephant has white tusks or brown tusks.";
	private static final String Q_TWO_OPTION_4 = "The elephant has blue eyes or green eyes.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	
	//http://www.clipartbest.com/cliparts/Bdc/r6k/Bdcr6koT9.jpeg
	private static final String Q_THREE = "Choose the correct answer.";
	private static final String IMAGE_THREE = "/Images/Levels/LevelThree/Questions/lion.png";
	private static final String Q_THREE_OPTION_1 = "The lion is white or spotted.";
	private static final String Q_THREE_OPTION_2 = "The lion is yellow or orange.";
	private static final String Q_THREE_OPTION_3 = "The lion has a purple mane or a pink mane.";
	private static final String Q_THREE_OPTION_4 = "The lion has blue whiskers or green whiskers.";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	
	
	//http://www.how-to-draw-funny-cartoons.com/image-files/cartoon-hippo-8.gif
	private static final String Q_FOUR = "Choose the correct answer.";
	private static final String IMAGE_FOUR = "/Images/Levels/LevelThree/Questions/hippo.png";
	private static final String Q_FOUR_OPTION_1 = "The hippo has two teeth or four teeth.";
	private static final String Q_FOUR_OPTION_2 = "The hippo is swimming or he is sleeping.";
	private static final String Q_FOUR_OPTION_3 = "The hippo is eating cupakes or donuts.";
	private static final String Q_FOUR_OPTION_4 = "The hippo does not have red nail polish or blue nail polish on.";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	public final Image HIPPO = new ImageIcon(getClass().getResource(IMAGE_FOUR)).getImage();
	
	
	
	private Game theGame;
	private int currentQuestion;
	
	public LevelThree(Game game) {
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
				theGame.textQuestion.setAnswerList(ANSWERS_ONE,Q_ONE_OPTION_3);
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
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_THREE_OPTION_2);
				theGame.textQuestion.initGui();
			}
			break;
		
		case 4:	
			if (ANSWERS_FOUR.size() == 0){
				addPossibleAnswers(ANSWERS_FOUR,  Q_FOUR_OPTION_1,  Q_FOUR_OPTION_2, Q_FOUR_OPTION_3, Q_FOUR_OPTION_4);
				theGame.textQuestion.setQuestion(Q_FOUR);
				theGame.textQuestion.setQuestionImage(IMAGE_FOUR);
				theGame.textQuestion.setAnswerList(ANSWERS_FOUR,Q_FOUR_OPTION_1);
				theGame.textQuestion.initGui();
			}
			break;
			
		case 5:	
			theGame.incrementLevel();
			System.out.println("Level Number in Level Two: " + theGame.getLevel());
			theGame.changeLayoutCard("FOREST");
			break;
	
		}
	}
}