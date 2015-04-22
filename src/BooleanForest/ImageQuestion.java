package BooleanForest;
import java.lang.String;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.List;

public class ImageQuestion extends JComponent implements Question {
	String imageResourceOne;
	String imageResourceTwo;
	String imageResourceThree;
	String imageResourceFour;

	List answerListOne;
	List answerListTwo;

	
	@Override 
	public void paint(Graphics g){
		
	}

	// Sets up the GUI for the question
	@Override
	public void displayQuestion(){
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        this.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		
		setVisible(true);
	}
	
	// Sets the question text
	public void setQuestion(String questionStringInput){

	}
	
	// Sets the different answer possibilities 
	public void setAnswerList(List possibleAnswers, List correctAnwsers){

	}
	
	// Determines if it is an image  or text question
	public void setQuestionLayout(String questionLayoutInput){

	}
	
	// Submits the question after knowing if the user got the correct answer 
	public void submitQuestion(Boolean questionCorrectOrNot){

	}
	
	// Checks two objects against each other to check the answer 
	public void checkAnswer(Object submittedAnswer, Object correctAnswer){
		if (submittedAnswer != correctAnswer){

		}
	}
}