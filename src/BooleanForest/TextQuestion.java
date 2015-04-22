package BooleanForest;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.String;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


// Drag one baby owl next to answer, if wrong get second change to drag another
// Grid Layout
public class TextQuestion extends JPanel implements Question {
	
	String imageResource; // Image that the question references
	String textQuestion; // Question being asked
	String correctAnswer;
	String babyOwl1 = "Images/ChloeSmall.png";
	String babyOwl2 = "Images/DavidSmall.png";
	ImageIcon owl1Icon = new ImageIcon(babyOwl1);
	ImageIcon owl2Icon = new ImageIcon(babyOwl2);

	List possibleAnswers;
	Boolean questionCompleted = false;

	public TextQuestion(){
		//super("Text Question"); if JPanel
	}
	
	public void paint(Graphics g){
		g.drawString(textQuestion, 40,20);
	}

	// Sets up the GUI for the question 
	public void displayQuestion(){
		JButton chloe = new JButton();
		JButton david = new JButton();
		chloe.setIcon(owl1Icon);
		david.setIcon(owl2Icon);
		
		initOwls(chloe, david);
		initLayout(chloe, david);
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
	
	public void initLayout(JButton owl1, JButton owl2){
		GridLayout layout = new GridLayout(4, 3, 1, 1);
		this.setLayout(layout);
		this.add();
		this.add
		
		
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
	public void setAnswerList(List allPossibleAnswers, String correctAnswerInput){
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
