/**
 * TEXTQUESTION CLASS
 * 
 * DESCRIPTION:
 * A text question about an image with either true/false or 
 * four length multiple-choice questions. 
 * 
 * SOURCES: 
 * ClassLoader - https://docs.oracle.com/javase/7/docs/api/java/lang/ClassLoader.html
 * 
 */

package Questions;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.lang.String;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BooleanForest.Game;
import Panels.LevelPanel;

@SuppressWarnings("serial")
public class TextQuestion extends JPanel implements ActionListener {
	
	// Constants
	private final static int MAX_BUTTON_WIDTH = 100;
	private final static int MAX_BUTTON_HEIGHT = 40;
	
	// Visual Elements 
	String imageResource; 							// Image that the question references
	String textQuestion; 							// Question being asked
	String correctAnswer; 							// String of correct answer
	ImageIcon img; 
	List<String> possibleAnswers;					// All possible answers to textQuestion

	JPanel questionPanel; 							// Contains GridLayout for all buttons
													// See initQuestions()
	
	// Buttons that contain string answers
	JButton answer1;								
	JButton answer2;
	JButton answer3;
	JButton answer4;
	
	public Boolean questionCompleted = false;		// Completeness of question
	
	// Controllers
	LevelPanel panel;								// LevelPanel to communicate with (Dynamic)
	Game theGame;									// Game Controller to communicate with
	
	/**
	 * CONSTRUCTOR: attaches the question to the
	 * game controller.  
	 * @param game
	 */
	public TextQuestion(Game game){
		theGame = game;
	}
	
	/**
	 * SETTER: Changes the level panel that
	 * the textQuestion is attached to. 
	 * @param panel
	 */
	public void switchLevelPanel(LevelPanel panel){
		this.panel = panel;
	}
	
	/**
	 * METHOD: Initializes the GUI by calling initGui().
	 * @param none
	 */
	public void initGui(){
		initQuestion();
	}
	
	/**
	 * METHOD: Initializes the layout that
	 * the buttons are in and loads the images.
	 * @param none
	 */
	public void initQuestion(){
		questionCompleted = false;
		
		img = new ImageIcon(getClass().getResource(imageResource));
		
		if (questionPanel != null){
			questionPanel.setVisible(false);
		}
		
		// Create GridLayout that organizes buttons
		questionPanel = new JPanel();
		answer1 = new JButton(possibleAnswers.get(0));
		answer2 = new JButton(possibleAnswers.get(1));
		answer1.setSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		answer2.setSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
		answer1.addActionListener(this);
		answer2.addActionListener(this);
		
		if (possibleAnswers.size() == 4){
			// 4-Length multiple choice
			questionPanel.setLayout(new GridLayout(2, 2, 1, 1));
			answer3 = new JButton(possibleAnswers.get(2));
			answer4 = new JButton(possibleAnswers.get(3));
			answer3.setSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
			answer4.setSize(MAX_BUTTON_WIDTH, MAX_BUTTON_HEIGHT);
			answer3.addActionListener(this);
			answer4.addActionListener(this);
			questionPanel.add(answer3);
			questionPanel.add(answer4);
		}
		else{
			// True or False questions
			questionPanel.setLayout(new GridLayout(1, 2, 1, 1));
		}
		
		questionPanel.add(answer1);
		questionPanel.add(answer2);
		
		questionPanel.setOpaque(false);
		questionPanel.setBorder(new EmptyBorder(Game.APPLET_HEIGHT-160, 0, 0, 0));
		add(questionPanel);
		
		repaint(); 

	}
	
	/**
	 * SETTER: Sets the text question
	 * @param questionStringInput
	 */
	public void setQuestion(String questionStringInput){
		textQuestion = questionStringInput;
		questionCompleted = false;
	}
	
	/**
	 * SETTER: Sets image that question references
	 * @param questionImage
	 */
	public void setQuestionImage(String questionImage){
		imageResource = questionImage;
	}
	
	/**
	 * SETTER: Sets the list of possible answers, 
	 * and the correct answer
	 * @param allPossibleAnswers
	 * @param correctAnswerInput
	 */
	public void setAnswerList(List<String> allPossibleAnswers, String correctAnswerInput){
		possibleAnswers = allPossibleAnswers;
		correctAnswer = correctAnswerInput;
	}

	/**
	 * METHOD: Checks the against the correctAnswer,
	 * if wrong sets button color to red
	 * @param submittedAnswer 
	 * @param answer
	 */
	public Boolean checkAnswer(String submittedAnswer, JButton answer){
		if (submittedAnswer == correctAnswer){
			questionCompleted = true;
			
			if (theGame.getLevel() == 0){
				theGame.levelOne.nextQuestion();
			}
			
			if (theGame.getLevel() == 1){
				theGame.levelTwo.nextQuestion();
			}
			
			if (theGame.getLevel() == 2){
				theGame.levelThree.nextQuestion();
			}
			
			if (theGame.getLevel() == 3){
				theGame.levelFour.nextQuestion();
			}
			return true;
		}
		else {
			answer.setBackground(Color.RED);
			answer.setOpaque(true);
			questionCompleted = false;
			return false;
		}
	}

	/**
	 * OVERRIDDEN METHOD: Action listener for buttons, checks answer selected
	 * @param event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == answer1){
			checkAnswer(answer1.getText(), answer1);
		}
		else if (src == answer2){
			checkAnswer(answer2.getText(), answer2);
		}
		else if (src == answer3){
			checkAnswer(answer3.getText(), answer3);
		}
		else if (src == answer4){
			checkAnswer(answer4.getText(), answer4);
		}
	}
	
	/**
	 * METHOD: Checks the length of a string, used for
	 * painting the coordinates of the string
	 * @param g
	 * @param inputString
	 * @return stringWidth
	 */
	public int measureStringWidth(Graphics g, String inputString) {
		Font font = g.getFont();
        FontRenderContext context = ((Graphics2D) g).getFontRenderContext();
        int stringWidth = (int)(font.getStringBounds(inputString, context).getWidth());
        return stringWidth;
	}
	
	/**
	 * OVERRIDDEN METHOD: Overrides paintComponent() by drawing the
	 * background image, the question image, and the question.
	 * @param graphic
	 */
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		questionPanel.revalidate();
		questionPanel.repaint();

		Image background = new ImageIcon(getClass().getResource("/Images/Backgrounds/BackgroundForTextQuestion.png")).getImage();
		g.drawImage(background, 0, 0, null);
		
		//Adds the question text to the middle 
		Image questionImage = img.getImage();
		g.drawImage(questionImage,Game.APPLET_WIDTH/2-questionImage.getWidth(null)/2,125,null);
		
		// Adds the question text above the image
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Game.TITLE_FONT);					
		g2.setColor(Game.DARK_BLUE);			
		g2.drawString(textQuestion,Game.APPLET_WIDTH/2-measureStringWidth(g,textQuestion)/2,90);
		
    }
}
