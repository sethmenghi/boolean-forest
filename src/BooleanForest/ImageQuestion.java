package BooleanForest;
import java.lang.String;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.List;

public class ImageQuestion extends JComponent implements Question {
	String imageResourceOne;
	String imageResourceTwo;
	String imageResourceThree;
	String imageResourceFour;

	List<String> answerListOne;
	List<String> answerListTwo;

	@Override 
	void paint(Graphic g){

	}

	// Sets up the GUI for the question
	@Override
	void displayQuestion(){
		
	}
	
	// Sets the question text
	void setQuestion(String questionStringInput){

	}
	
	// Sets the different answer possibilities 
	void setAnswerList(List answerListInput){

	}
	
	// Determines if it is an image  or text question
	void setQuestionLayout(String questionLayoutInput){

	}
	
	// Submits the question after knowing if the user got the correct answer 
	void submitQuestion(Boolean questionCorrectOrNot){

	}
	
	// Checks two objects against each other to check the answer 
	void checkAnswer(Object submittedAnswer, Object correctAnswer){
		if (submittedAnser != correctAnswer){

		}
	}
}