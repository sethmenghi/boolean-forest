package BooleanForest;
import java.util.List;

// This interface is used by both the ImageQuestion and TextQuestion classes
// to display the different types of questions to the user. 
interface Question {

	// Sets up the GUI for the question 
	void displayQuestion();
	
	// Sets the question text
	void setQuestion(String questionStringInput); 
	
	// Sets the different answer possibilities 
	void setAnswerList(List<String> allPossibleAnswers, String correctAnswer); 
	
	// Submits the question after knowing if the user got the correct answer 
	void submitQuestion(Boolean questionCorrectOrNot);
	
	// Checks two objects against each other to check the answer 
	void checkAnswer(String submittedAnswer); 
	
}
