package Levels;

import java.awt.Image;

import javax.swing.ImageIcon;

public class LevelOne {
	// Declare static final Strings for explanations:
	public static final String PAGE_TRUE = "TRUE";						// page 1	
	public static final String PAGE_TRUE_A = "This is a penguin.";		// page 2
	public static final String PAGE_TRUE_B = "The color is blue.";		// page 3	
	public static final String PAGE_FALSE = "FALSE";					// page 4	
	public static final String PAGE_FALSE_A = "This is a cup.";			// page 5
	public static final String PAGE_FALSE_B = "The color is yellow.";	// page 6	
	public static final String TRUE_STATEMENT = "This is a TRUE statement.";
	public static final String FALSE_STATEMENT = "This is a FALSE statement.";
	
	// Declare static final Images for explanations:
	public static final Image PENGUIN = new ImageIcon("Images/Levels/LevelOne/Explanation/Penguin.png").getImage();
	public static final Image BLUE = new ImageIcon("Images/Levels/LevelOne/Explanation/Blue.png").getImage();
	public static final Image TABLE = new ImageIcon("Images/Levels/LevelOne/Explanation/Table.png").getImage();
	public static final Image PINK = new ImageIcon("Images/Levels/LevelOne/Explanation/Pink.png").getImage();
	
	// Declare static final Strings for TextQuestions:
	
	// Declare static final Images for TextQuestions:
	
	// Declare static final Strings for ImageQuestions:
	
	// Declare static final Images for ImageQuestions:
	
	
//	
//	private static final String INSTRUCTIONS = "Level One Instructions";
//	// Question One -- text question
//	private static final String Q_ONE = "This is a _____ and it is playing the _____";
//	private static final String IMAGE_ONE = "Images/purpleDolphinSaxophone.png";
//	private static final String Q_ONE_OPTION_1 = "dolphin, piano";
//	private static final String Q_ONE_OPTION_2 = "dolphin, saxophone";
//	private static final String Q_ONE_OPTION_3 = "shark, piano";
//	private static final String Q_ONE_OPTION_4 = "shark, saxophone";
//	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
//	private static List<String> CORRECT_ONE = new ArrayList<String>(); 
//	
//	//Question Two -- text question
//	private static final String Q_TWO = "This is an _____ and she is _____ ";
//	private static final String IMAGE_TWO = "Images/pinkOctopus.png";
//	private static final String Q_TWO_OPTION_1 = "anglefish, pink";
//	private static final String Q_TWO_OPTION_2 = "octopus, blue";
//	private static final String Q_TWO_OPTION_3 = "anglefish, purple";
//	private static final String Q_TWO_OPTION_4 = "octopus, pink";
//	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
//	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
//	
//	
//	
//	private static final String Q_THREE = "?";
//	private static final String Q_FOUR = "?";
//	private static final String Q_FIVE = "?";
//	
//	
//	private static final int TEXT = 0;
//	private static final int IMAGE = 1;
//	
//	private Game theGame;
//	private BobsWindow bobsWindow;
//	
//	
//	public LevelOne(Game game) {
//		
//		theGame = game;
//		
//		//bobsWindow = new BobsWindow(theGame, INSTRUCTIONS);
//		
//		startLevel();
//	}
//	
//	public void addPossibleAnswers(List<String> holdsPossibleAnswers, String option1, String option2, String option3, String option4){
//		holdsPossibleAnswers.add(option1);
//		holdsPossibleAnswers.add(option2);
//		holdsPossibleAnswers.add(option3);
//		holdsPossibleAnswers.add(option4);
//	}
//	
//	public static void addCorrectAnswers(List<String> correctAnswer, String correctOption){
//		
//		correctAnswer.add(correctOption);
//	}
//	
//	
//	private void startLevel() {
//		doQuestion(Q_ONE);
//		doQuestion(Q_TWO);
//		doQuestion(Q_ONE);
//		doQuestion(Q_ONE);
//		doQuestion(Q_ONE);
//	}
//	
//	public void doQuestion(String question) {
//		switch (question) {
//		case Q_ONE:
//			
//			addPossibleAnswers(ANSWERS_ONE,  Q_ONE_OPTION_1,  Q_ONE_OPTION_1,  Q_ONE_OPTION_1,  Q_ONE_OPTION_1);
//			addCorrectAnswers(CORRECT_ONE, Q_ONE_OPTION_2);
//			//theGame.imageQuestion.setQuestion(Q_ONE);
//			//theGame.imageQuestion.setAnswerList(); sets correct answer too
//		case Q_TWO:	
//			addPossibleAnswers(ANSWERS_TWO,  Q_TWO_OPTION_1,  Q_TWO_OPTION_1,  Q_TWO_OPTION_1,  Q_TWO_OPTION_1);
//			addCorrectAnswers(CORRECT_TWO, Q_TWO_OPTION_4);
//			
//			//theGame.changeLayoutCard("Image Question");
//	
//			theGame.changeLayoutCard("Image Question");
//			break;
//		
//		}
//		
//		//updateScore();
//	}
//	
//	/**
//	 * paintComponenent()
//	 * 
//	 * Overrides paintComponenent(); draws background image
//	 * 
//	 * @param graphic
//	 */
//	@Override
//	public void paintComponent(Graphics g) {
//		// Call super
//		super.paintComponent(g);
//		
//		// Create new image icon, draw the image
//		Image image = new ImageIcon("Images/LevelMapWithPath.jpg").getImage();
//		g.drawImage(image, 0, 0, null);
//		
//		bobsWindow.paintComponents(g);
//	}
}