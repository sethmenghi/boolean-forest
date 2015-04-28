package Questions;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BooleanForest.Game;
import Panels.LevelPanel;


// Drag one baby owl next to answer, if wrong get second change to drag another
// Grid Layout
@SuppressWarnings("serial")
public class TextQuestion extends JPanel implements Question, ActionListener {
	
	String imageResource; // Image that the question references
	String textQuestion; // Question being asked
	String correctAnswer; // String of correct answer
	
	// Buttons that for selection of answers
	JButton answer1;
	JButton answer2;
	JButton answer3;
	JButton answer4;
	
	int questionCount = 0;
	
	// Panels that group the layouts
	JPanel questionPanel; // Overall question panel
	JPanel imagePanel; // Contains the image
	
	// Visual elements of the question
	JLabel imgLabel;
	ImageIcon img;
	
	List<String> possibleAnswers;
	public Boolean questionCompleted = false;

	LevelPanel panel;
	Game theGame;
	
	public TextQuestion(Game game)
	{
		theGame = game;
	}
	
	public void switchLevelPanel(LevelPanel panel){
		this.panel = panel;
	}
	
	// Sets up the GUI for the question 
	public void initGui(){
		initQuestion();
	}
	
	public void initQuestion(){
		questionCompleted = false;
		
		img = new ImageIcon(imageResource);
		// If image doens't load correctly just stop the question
		while(img.getImageLoadStatus() != MediaTracker.COMPLETE){
			if (img.getImageLoadStatus() == MediaTracker.ERRORED || 
				img.getImageLoadStatus() == MediaTracker.ABORTED){
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					String url = classLoader.getResource(".").getPath();
					String errorString = "ERROR: Couldn't load " + imageResource;
					System.out.println(errorString);
					String urlError = "Current directory: " + url;
					System.out.println(urlError);
					break;
			}
		}
		
		if (questionPanel != null){
			questionPanel.setVisible(false);
		}
		
		// Create GridLayout that organizes buttons
		questionPanel = new JPanel();
		answer1 = new JButton(possibleAnswers.get(0));
		answer2 = new JButton(possibleAnswers.get(1));
		answer1.addActionListener(this);
		answer2.addActionListener(this);
		
		if (possibleAnswers.size() == 4){
			questionPanel.setLayout(new GridLayout(2, 2, 1, 1));
			answer3 = new JButton(possibleAnswers.get(2));
			answer4 = new JButton(possibleAnswers.get(3));
			answer3.addActionListener(this);
			answer4.addActionListener(this);
			questionPanel.add(answer3);
			questionPanel.add(answer4);
		}
		else{
			questionPanel.setLayout(new GridLayout(1, 2, 1, 1));
		}
		
		questionPanel.add(answer1);
		questionPanel.add(answer2);
		
		questionPanel.setOpaque(false);
		questionPanel.setBorder(new EmptyBorder(Game.APPLET_HEIGHT-160, 0, 0, 0));
		add(questionPanel);

	}
	
	// Sets the question text
	public void setQuestion(String questionStringInput){
		textQuestion = questionStringInput;
		questionCompleted = false;
	}
	
	/**
	 * Sets image that question references
	 * 
	 * @param questionImage
	 */
	public void setQuestionImage(String questionImage){
		imageResource = questionImage;
	}
	
	/**
	 * Sets the list of possible answers, and a string
	 * 
	 * @param allPossibleAnswers
	 * @param correctAnswerInput
	 */
	public void setAnswerList(List<String> allPossibleAnswers, String correctAnswerInput){
		possibleAnswers = allPossibleAnswers;
		correctAnswer = correctAnswerInput;
		System.out.println(possibleAnswers);
	}

	/**
	 * Checks the 
	 * @param submittedAnswer against the correctAnswer
	 */
	
	 
	
	public Boolean checkAnswer(String submittedAnswer){
		
		
		
		if (submittedAnswer == correctAnswer){
			questionCompleted = true;
			
			
			if (theGame.getLevel() == 0){
				theGame.levelOne.nextQuestion();
			}
			
			if (theGame.getLevel() == 1){
				theGame.levelTwo.nextQuestion();
			}
			
			return true;
		}
		else {
			System.out.println("so wrong");
			questionCompleted = false;
			return false;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == answer1){
			checkAnswer(answer1.getText());
		}
		else if (src == answer2){
			checkAnswer(answer2.getText());
		}
		else if (src == answer3){
			checkAnswer(answer3.getText());
		}
		else if (src == answer4){
			checkAnswer(answer4.getText());
		}
		System.out.println(questionCompleted);
	}
	
	public int measureStringWidth(Graphics g, String inputString) {

		Font font = g.getFont();
        FontRenderContext context = ((Graphics2D) g).getFontRenderContext();
        int stringWidth = (int)(font.getStringBounds(inputString, context).getWidth());
        return stringWidth;
      
	}
	
	@Override 
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		questionPanel.revalidate();
		questionPanel.repaint();

		Image background = new ImageIcon("Images/Backgrounds/BackgroundForTextQuestion.png").getImage();
		g.drawImage(background, 0, 0, null);
		
		//Adds the question text to the middle 
		Image questionImage = img.getImage();
		g.drawImage(questionImage,Game.APPLET_WIDTH/2-questionImage.getWidth(null)/2,125,null);
		
		// Adds the question text above the image
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Game.TITLE_FONT);					
		g2.setColor(Game.DARK_BLUE);			
		g2.drawString(textQuestion,Game.APPLET_WIDTH/2-measureStringWidth(g,textQuestion)/2,90);
		
		//setVisible(true);
    }
}
