package Levels;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

//Not question
public class LevelThree {

	private static final String Q_ONE = "Choose the correct answer.";
	private static final String IMAGE_ONE = "Images/Levels/LevelFour/Questions/giraffe.png";
	private static final String Q_ONE_OPTION_1 = "The camel is not standing.";
	private static final String Q_ONE_OPTION_2 = "This is not a horse.";
	private static final String Q_ONE_OPTION_3 = "This is not a camel.";
	private static final String Q_ONE_OPTION_4 = "The camel is not brown.";
	private List<String> ANSWERS_ONE = new ArrayList<String>(); 	
	private static List<String> CORRECT_ONE = new ArrayList<String>();
	public static final Image CAMEL = new ImageIcon(IMAGE_ONE).getImage();
	
	
	//Question Two -- text question
	private static final String Q_TWO = "Choose the CORRECT answer.";
	private static final String IMAGE_TWO = "Images/Levels/LevelThree/Question/cactus.png";
	private static final String Q_TWO_OPTION_1 = "This is not a bird."; 
	private static final String Q_TWO_OPTION_2 = "The animal is not flying." ;
	private static final String Q_TWO_OPTION_3 = "This animal is not brown";
	private static final String Q_TWO_OPTION_4 = "The animal is not black.";
	private List<String> ANSWERS_TWO = new ArrayList<String>(); 	
	private static List<String> CORRECT_TWO = new ArrayList<String>(); 
	public static final Image VULTURE = new ImageIcon(IMAGE_TWO).getImage();
	
	//Question Two -- text question
		private static final String Q_THREE = "Choose the INCORRECT answer.";
		private static final String IMAGE_THREE = "Images/Levels/LevelThree/Question/cactus.png";
		private static final String Q_THREE_OPTION_1 = "This is not a christmas tree."; 
		private static final String Q_THREE_OPTION_2 = "This plant doesn't have prickly needles." ;
		private static final String Q_THREE_OPTION_3 = "This is not a cactus";
		private static final String Q_THREE_OPTION_4 = "This plant is not yellow.";
		private List<String> ANSWERS_THREE = new ArrayList<String>(); 	
		private static List<String> CORRECT_THREE = new ArrayList<String>(); 
		public static final Image CACTUS = new ImageIcon(IMAGE_THREE).getImage();
	
	//Question Three -- text question 
	private static final String Q_FOUR = "Choose the correct answer.";
	private static final String IMAGE_FOUR = "Images/Levels/LevelThree/Questions/snake .png";
	private static final String Q_FOUR_OPTION_1 = "This is lizard and he is green. ";
	private static final String Q_FOUR_OPTION_2 = "This is a snake and he is green. ";
	private static final String Q_FOUR_OPTION_3 = "This is squirrel and he is blue.";
	private static final String Q_FOUR_OPTION_4 = "This is a snake and he is brown.";
	private List<String> ANSWERS_FOUR = new ArrayList<String>(); 	
	private static List<String> CORRECT_FOUR = new ArrayList<String>();
	public static final Image SNAKE = new ImageIcon(IMAGE_FOUR).getImage();
	
	private static final String Q_FIVE = "Choose the correct answer.";
	private static final String IMAGE_FIVE = "Images/Levels/LevelThree/Questions/coyote .png";
	private static final String Q_FIVE_OPTION_1 = "This is not a coyote and the animal is brown.";
	private static final String Q_FIVE_OPTION_2 = "This animal does not live in the ocean and he is a coyote.";
	private static final String Q_FIVE_OPTION_3 = "This is a cactus and it not green.";
	private static final String Q_FIVE_OPTION_4 = "This is a coyote and he is not brown.";
	private List<String> ANSWERS_FIVE = new ArrayList<String>(); 	
	private static List<String> CORRECT_FIVE = new ArrayList<String>();
	public static final Image COYOTE = new ImageIcon(IMAGE_FIVE).getImage();
}