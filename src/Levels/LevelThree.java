/**
 * IMAGE SOURCES:
 * 1) http://41.media.tumblr.com/c3eb422708f7d7691f985f8541945197/
 *    tumblr_mnczrreGAP1s5jjtzo1_1280.png
 * 2) http://www.penguincorner.com/website/coloring/createonline/
 *    clipart/nature/flowers/detailedsunflower.png
 * 3) http://www.clipartbest.com/cliparts/dcr/Kek/dcrKekgc9.png
 * 4) https://derpicdn.net/img/2013/4/30/311987/full.png
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
	
	// Declare static final Images for explanations:
	public static final Image DONUT = new ImageIcon("Images/Levels/LevelThree/Explanation/Donut.png").getImage();
	public static final Image FLOWER = new ImageIcon("Images/Levels/LevelThree/Explanation/Sunflower.png").getImage();
	public static final Image PENCIL = new ImageIcon("Images/Levels/LevelThree/Explanation/Pencil.png").getImage();
	public static final Image COOKIE = new ImageIcon("Images/Levels/LevelThree/Explanation/Cookie.png").getImage();
	
	//OR LEVEL 
	
	private static final String INSTRUCTIONS = "Level One Instructions";
	// Question One -- text question
	private static final String Q_ONE = "Choose the CORRECT anwer.";
	private static final String IMAGE_ONE = "Images/Levels/LevelThree/Questions/giraffe.png";
	private static final String Q_ONE_OPTION_1 = "The giraffe is lying down or sleeping.";
	private static final String Q_ONE_OPTION_2 = "The giraffe has blue or green spots.";
	private static final String Q_ONE_OPTION_3 = "The giraffe is yellow or pink.";
	private static final String Q_ONE_OPTION_4 = "The giraffe has a short neck or long legs.";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static List<String> CORRECT_ONE = new ArrayList<String>();
	public static final Image GIRAFFE = new ImageIcon(IMAGE_ONE).getImage();
	
	
	
	//http://cliparts.co/cliparts/kc8/oKy/kc8oKydji.png
	private static final String Q_TWO = "Choose the INCORRECT answer.";
	private static final String IMAGE_TWO = "Images/Levels/LevelThree/Questions/elephant.png";
	private static final String Q_TWO_OPTION_1 = "The elephant is sitting or standing.";
	private static final String Q_TWO_OPTION_2 = "The elephant is grey or brown.";
	private static final String Q_TWO_OPTION_3 = "The elephant has white tusks or brown tusks.";
	private static final String Q_TWO_OPTION_4 = "The elephant has blue eyes or green eyes.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
	public static final Image ELEPHANT = new ImageIcon(IMAGE_TWO).getImage();
	
	private static final String Q_THREE = "Choose the correct answer.";
	private static final String IMAGE_THREE = "Images/Levels/LevelThree/Questions/lion.png";
	private static final String Q_THREE_OPTION_1 = "The lion is not white or spotted.";
	private static final String Q_THREE_OPTION_2 = "The lion is not yellow or orange.";
	private static final String Q_THREE_OPTION_3 = "The lion does not have a long mane or a brown mane.";
	private static final String Q_THREE_OPTION_4 = "The lion does not have brown or black whiskers.";
	private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
	private static List<String> CORRECT_THREE = new ArrayList<String>(); 
	public static final Image LION = new ImageIcon(IMAGE_THREE).getImage();
	
	private static final String Q_FOUR = "Choose the correct answer.";
	private static final String IMAGE_FOUR = "Images/Levels/LevelThree/Questions/hippo.png";
	private static final String Q_FOUR_OPTION_1 = "The hippo is not grey or purple.";
	private static final String Q_FOUR_OPTION_2 = "The hippo is swimming and sleeping.";
	private static final String Q_FOUR_OPTION_3 = "The hippo is not purple, but he has stripes and polkadots.";
	private static final String Q_FOUR_OPTION_4 = "The hippo is purple and he has two teeth, but he is not swimming.";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	private static List<String> CORRECT_FOUR = new ArrayList<String>(); 
	public static final Image HIPPO = new ImageIcon(IMAGE_FOUR).getImage();
	
	
	
	//private static final String Q_THREE = "?";
	
	private Game theGame;
	int currentLevel = 1;
	
	public LevelThree(Game game) {
		theGame = game;
		//startLevel();
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
		doQuestion();
	}
	
	public void nextQuestion(){
		if (theGame.textQuestion.questionCompleted == true){
			currentLevel++;
			doQuestion();
		}
		else{
			JLabel warningImage = new JLabel(new ImageIcon("Images/Owls/Bob.png"));
			JOptionPane.showMessageDialog(null, warningImage, "Question", JOptionPane.PLAIN_MESSAGE, null);
		}
	}
	
	public void doQuestion() {
		switch (currentLevel) {
		case 1:
			if (ANSWERS_ONE.size() == 0){
				addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_2, Q_ONE_OPTION_3, Q_ONE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_ONE);
				theGame.textQuestion.setQuestionImage(IMAGE_ONE);
				theGame.textQuestion.setAnswerList(ANSWERS_ONE,Q_ONE_OPTION_3);
				theGame.textQuestion.initGui();
				//theGame.repaint();
				theGame.changeLayoutCard("TEXT_QUESTION");

			}
			break;
		case 2:	
			if (ANSWERS_TWO.size() == 0){
				addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_2, Q_TWO_OPTION_3, Q_TWO_OPTION_4);
				theGame.textQuestion.setQuestion(Q_TWO);
				theGame.textQuestion.setQuestionImage(IMAGE_TWO);
				theGame.textQuestion.setAnswerList(ANSWERS_TWO,Q_TWO_OPTION_3);
				theGame.textQuestion.initGui();
				theGame.repaint();
				theGame.changeLayoutCard("TEXT_QUESTION");
			}
			break;
		case 3:	
			if (ANSWERS_THREE.size() == 0){
				addPossibleAnswers(ANSWERS_THREE,  Q_THREE_OPTION_1, Q_THREE_OPTION_2, Q_THREE_OPTION_3, Q_THREE_OPTION_4);
				theGame.textQuestion.setQuestion(Q_THREE);
				theGame.textQuestion.setQuestionImage(IMAGE_THREE);
				theGame.textQuestion.setAnswerList(ANSWERS_THREE,Q_THREE_OPTION_1);
				theGame.textQuestion.initGui();
				theGame.repaint();
			}
		
		case 4: 
			if (ANSWERS_FOUR.size() == 0){
				addPossibleAnswers(ANSWERS_FOUR,  Q_FOUR_OPTION_1, Q_FOUR_OPTION_2, Q_FOUR_OPTION_3, Q_FOUR_OPTION_4);
				theGame.textQuestion.setQuestion(Q_FOUR);
				theGame.textQuestion.setQuestionImage(IMAGE_FOUR);
				theGame.textQuestion.setAnswerList(ANSWERS_FOUR,Q_FOUR_OPTION_4);
				theGame.textQuestion.initGui();
				theGame.repaint();
				
			}
			//theGame.changeLayoutCard("TEXT_QUESTION");
			break;
		
		
			
		case 5:	
			System.out.println("END OF LEVEL ONE");
			theGame.incrementLevel();
			theGame.forestPanel.repaintForestPanel();
			theGame.changeLayoutCard("FOREST");
			break;
	
		}
	}
}
