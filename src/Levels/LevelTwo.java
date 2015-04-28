/**
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
 */

package Levels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import BooleanForest.*;


public class LevelTwo {
	// Declare static final Strings for explanations:
	public static final String PAGE_AND = "AND";											// page 1
	public static final String PAGE_TRUE_A = "This is a dog AND it has a bone.";			// page 2
	public static final String PAGE_TRUE_B = "The is a teddy bear AND it is brown.";		// page 3 	
	public static final String PAGE_FALSE_A = "This is a cat AND its hat is orange.";		// page 4
	public static final String PAGE_FALSE_B = "This is a pie AND it has a candle.";			// page 5	
	public static final String TRUE_STATEMENT = "This is RIGHT!\nBoth statements are true.";
	public static final String FALSE_STATEMENT = "This is WRONG! Both statements are not\n"
			+ "true. Unless BOTH are true, it is wrong.";
	
	// Declare static final Images for explanations:
	public static final Image DOG = new ImageIcon("Images/Levels/LevelTwo/Explanation/DogBone.png").getImage();
	public static final Image TEDDY_BEAR = new ImageIcon("Images/Levels/LevelTwo/Explanation/TeddyBear.png").getImage();
	public static final Image DUCK = new ImageIcon("Images/Levels/LevelTwo/Explanation/DuckWithHat.png").getImage();
	public static final Image CUPCAKE = new ImageIcon("Images/Levels/LevelTwo/Explanation/Cupcake.png").getImage();
	
	
	private static final String INSTRUCTIONS = "Level One Instructions";
	// Question One -- text question
	private static final String Q_ONE = "This is a _____ and it is playing the _____";
	private static final String IMAGE_ONE = "Images/Levels/LevelTwo/Questions/purpleDolphinSaxophone.png";
	private static final String Q_ONE_OPTION_1 = "dolphin, piano";
	private static final String Q_ONE_OPTION_2 = "dolphin, saxophone";
	private static final String Q_ONE_OPTION_3 = "shark, piano";
	private static final String Q_ONE_OPTION_4 = "shark, saxophone";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static List<String> CORRECT_ONE = new ArrayList<String>();
	

	//Question Two -- text question
	private static final String Q_TWO = "This is an _____ and she is _____ ";
	private static final String IMAGE_TWO = "Images/Levels/LevelTwo/Questions/pinkOctopus.png";
	private static final String Q_TWO_OPTION_1 = "anglefish, pink";
	private static final String Q_TWO_OPTION_2 = "octopus, blue";
	private static final String Q_TWO_OPTION_3 = "anglefish, purple";
	private static final String Q_TWO_OPTION_4 = "octopus, pink";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
	public static final Image OCTOPUS = new ImageIcon(IMAGE_TWO).getImage();
	
	//Question Three -- text question 
	private static final String Q_THREE = "This is a _____ and she is playing with a ______";

	private static final String IMAGE_THREE = "Images/Levels/LevelTwo/Questions/seal.png";
	private static final String Q_THREE_OPTION_1 = "dolphin, ball";
	private static final String Q_THREE_OPTION_2 = "seal,yo-yo ";
	private static final String Q_THREE_OPTION_3 = "seal, ball";
	private static final String Q_THREE_OPTION_4 = "fish, ball";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	
	
	private static final String Q_FOUR = "This is a _______ and his eyes are _______";
	private static final String IMAGE_FOUR = "Images/Levels/LevelTwo/Questions/orca.png";
	private static final String Q_FOUR_OPTION_1 = "whale, blue";
	private static final String Q_FOUR_OPTION_2 = "dolphin,bue ";
	private static final String Q_FOUR_OPTION_3 = "whale, brown";
	private static final String Q_FOUR_OPTION_4 = "shark, blue";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	
	
	
	private Game theGame;
	private int currentQuestion;
	
	public LevelTwo(Game game) {
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
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_THREE_OPTION_3);
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