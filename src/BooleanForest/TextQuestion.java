package BooleanForest;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.String;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;


// Drag one baby owl next to answer, if wrong get second change to drag another
// Grid Layout
@SuppressWarnings("serial")
public class TextQuestion extends JPanel implements Question {
	
	String imageResource; // Image that the question references
	String textQuestion; // Question being asked
	String correctAnswer;
	String babyOwl1 = "src/Images/ChloeSmall.png";
	String babyOwl2 = "src/Images/DavidSmall.png";
	ImageIcon owl1Icon = new ImageIcon(babyOwl1);
	ImageIcon owl2Icon = new ImageIcon(babyOwl2);

	List<String> possibleAnswers;
	Boolean questionCompleted = false;

//	public TextQuestion(){
//		//super("Text Question"); if JPanel
//	}
	
//	public void paint(Graphics g){
//		g.drawString(textQuestion, 40,20);
//	}

	// Sets up the GUI for the question 
	public void displayQuestion(){
		this.setOpaque(true);
	    this.setBackground(Color.WHITE);
	    
	    
		JLabel questionLabel = new JLabel(textQuestion);
	    // questionLabel.setHorizontalAlignment(JLabel.CENTER);
	    // questionLabel.setVerticalAlignment(JLabel.CENTER);
		
	    // Set buttons for draggable owls
		JButton chloe = new JButton();
		JButton david = new JButton();
	    chloe.setIcon(owl1Icon);
		david.setIcon(owl2Icon);
		while(owl1Icon.getImageLoadStatus() != MediaTracker.COMPLETE){
			if (owl1Icon.getImageLoadStatus() == MediaTracker.ERRORED || 
				owl1Icon.getImageLoadStatus() == MediaTracker.ABORTED){
					ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
					String url = classLoader.getResource(".").getPath();
					System.out.println("ERROR IN LOADING IMAGES!");
					System.out.println(url);
					return;
			}
		}
		//initOwls(chloe, david);
		initQuestions(chloe, david, questionLabel);
		setVisible(true);
	}
	
	//Sets Listeners for drag and drop and transfer
	public void initOwls(JButton owl1, JButton owl2){
		// JButton owl1 = new JButton();
		// JButton owl2 = new JButton();
		// JLabel owl1Label = new JLabel(owl1Icon);
		// JLabel owl2Label = new JLabel(owl2Icon);

		TransferHandler transferOwl1 = new TransferHandler(babyOwl1);
		TransferHandler transferOwl2 = new TransferHandler(babyOwl2);
		
		// Set TransferHandlers for drag and drop
		owl1.setTransferHandler(transferOwl1);
		owl2.setTransferHandler(transferOwl2);
		
		//add MouseListeners to initiate the Drag on the appropriate owl
		owl1.addMouseListener(new MouseAdapter(){
		     public void mousePressed(MouseEvent e){
		    	 JButton button = (JButton)e.getSource();
		         TransferHandler handle = button.getTransferHandler();
		         handle.exportAsDrag(button, e, TransferHandler.COPY);
		     }
		});
		
		owl2.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
		         JButton button = (JButton)e.getSource();
		         TransferHandler handle = button.getTransferHandler();
		         handle.exportAsDrag(button, e, TransferHandler.MOVE);
		    }
		});
	}
	
	public void initQuestions(JButton owl1, JButton owl2, JLabel questionLabel){

		
		// Question Image Panel 
		JPanel imagePanel = new JPanel();
		ImageIcon img = new ImageIcon(imageResource);
		JLabel imgLabel = new JLabel(img);
		imagePanel.setLayout(new GridLayout(1,1));
		imagePanel.setOpaque(true);
		imagePanel.setBackground(Color.WHITE);
		imagePanel.add(imgLabel);
		
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(imagePanel);

		// Add Question above the answers
		// and below the question image
		add(questionLabel);
		
		////////////////////
		// Question Panel //
		JPanel questionPanel = new JPanel();
		questionPanel.setLayout(new GridLayout(2, 2, 1, 1));
		JButton answer1 = new JButton(possibleAnswers.get(0));
		JButton answer2 = new JButton(possibleAnswers.get(1));
		JButton answer3 = new JButton(possibleAnswers.get(2));
		JButton answer4 = new JButton(possibleAnswers.get(3));
		// Add and finish questionLayout
		//add(owl1);
		questionPanel.add(answer1);
		questionPanel.add(answer2);
		//add(owl2);
		questionPanel.add(answer3);
		questionPanel.add(answer4);
		questionPanel.setOpaque(true);
		questionPanel.setBackground(Color.WHITE);
		add(questionPanel);
	}
	
	// Sets the question text
	public void setQuestion(String questionStringInput){
		textQuestion = questionStringInput;
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
	}
	
	
	/**
	 * Submits the answer
	 * @param questionCorrectOrNot
	 */
	public void submitQuestion(Boolean questionCorrectOrNot){
		
	}
	

	/**
	 * Checks the 
	 * @param submittedAnswer against the correctAnswer
	 */
	public void checkAnswer(String submittedAnswer){
		if (submittedAnswer == correctAnswer){
			questionCompleted = true;
		}
		else {
			questionCompleted = false;
		}
	}
}
