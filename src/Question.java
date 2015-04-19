import java.awt.List;

// This interface is used by both the ImageQuestion and TextQuestion classes
// to display the different types of questions to the user. 
interface Question {

	// Sets up the GUI for the question 
	void displayQuestion();
	
	// Sets the question text
	void setQuestion(String questionStringInput); 
	
	// Sets the different answer possibilities 
	void setAnswerList(List answerListInput); 
	
	// Determines if it is an image or text question
	void setQuestionLayout(String questionLayoutInput);
	
	// Submits the question after knowing if the user got the correct answer 
	void submitQuestion(Boolean questionCorrectOrNot);
	
	// Checks two objects against each other to check the answer 
	void checkAnswer(Object submittedAnswer, Object correctAnswer); 
	
}
