package Tests;
import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import BooleanForest.TextQuestion;


public class TextQuestionTest {
	
	String testQuestion;
	List<String> possibleAnswers = new ArrayList<String>();
	String answer;
	JFrame frame = new JFrame();
	
	@Before
	public void setUp() throws Exception {
		testQuestion = "Who would win, Abe Lincoln or Winston Churchill?";
		answer = "Lincoln";
		possibleAnswers.add("Lincoln");
		possibleAnswers.add("Churchill");
		possibleAnswers.add("Tie.");
		possibleAnswers.add("Washington");
	}

	@Test
	public void test() {
		TextQuestion tq = new TextQuestion();
		tq.setQuestion(testQuestion);
		tq.setAnswerList(possibleAnswers, answer);
		tq.setQuestionImage("src/Images/Bob.png");
		tq.displayQuestion();
		frame.add(tq, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		while(true){
			continue;
		}
	}

}
