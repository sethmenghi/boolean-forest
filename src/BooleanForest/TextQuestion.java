package BooleanForest;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.List;
import java.lang.String;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

// Grid Layout
public class TextQuestion extends JPanel implements Question {
	String imageResource;
	String textQuestion;
	List answerListOne;
	List answerListTwo;

	public TextQuestion(){
		//super("Text Question"); if JPanel
	}
	
	public void paint(Graphics g){
		g.drawString(textQuestion, 40,20);
	}

	// Sets up the GUI for the question 
	public void displayQuestion(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		setVisible(true);
	}
	
	// Sets the question text
	public void setQuestion(String questionStringInput){
		
	}

	// Sets the different answer possibilities 
	public void setAnswerList(List allAnswers, List correctAnswer){
		
	}
	
	// Determines if it is an image  or text question
	public void setQuestionLayout(String questionLayoutInput){
		
	}
	
	// Submits the question after knowing if the user got the correct answer 
	public void submitQuestion(Boolean questionCorrectOrNot){
		
	}
	
	// Checks two objects against each other to check the answer 
	public void checkAnswer(Object submittedAnswer, Object correctAnswer){
		
	}
}
