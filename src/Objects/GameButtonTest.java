package Objects;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class GameButtonTest {
	
	private GameButton button;
	private String message;
	private String newMessage;
	private String color;
	private String newTextColor;
	private Dimension size;
	
	/**
	 * METHOD: GameButtonTest Constructor.
	 */
	public GameButtonTest(String message, String color, 
							int dimWidth, int dimHeight,
							String newMessage) {		
		this.message = message;
		this.color = color;
		this.size = new Dimension(dimWidth,dimHeight);
		this.newMessage = newMessage;
	}
	
	/**
	 * METHOD: This method specifies all of the parameters to test. 
	 * There are 4 tests. For each test, there is a message, a color, 
	 * and x and y coordinate, and a message to change to.
	 * @return a list of parameters
	 */
	@Parameters
	public static Collection<Object[]> getTestParameters() {

		// Each test has four sets of XY coordinates
		// The parameters are initially stored in a two dimensional object
		Object [][] myTestParameters = new Object [][] {
				{"Bob the Owl", "blue", 95, 27, "I am Bob."},
				{"Alice the Owl", "red", 103, 27, "I am Alice."},
				{"Chloe the Owl", "yellow", 108, 27, "I am Chloe."},
				{"David the Owl", "green", 108, 27, "I am David."}
		};

		// Returning a single dimension list
		return Arrays.asList(myTestParameters);
	}
	
	/**
	 * METHOD: This method sets up the test method
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		button = new GameButton(message,color);
	}
	
	/**
	 * TEST: This tests the button message GETTER method
	 */
	@Test
	public void getButtonMessageTest() {		
		assertEquals(button.getButtonMessage(), message);
	}
	
	/**
	 * TEST: This tests the maximum size GETTER method
	 */
	@Test
	public void getMaximumSizeTest() {
		assertEquals(button.getMaximumSize(),size);
	}
	
	/**
	 * TEST: This tests the minimum size GETTER method
	 */
	@Test
	public void getMinimumSizeTest() {
		assertEquals(button.getMinimumSize(),size);
	}
	
	/**
	 * TEST: This tests the preferred size GETTER method
	 */
	@Test
	public void getPreferredSizeTest() {
		assertEquals(button.getPreferredSize(),size);
	}
	
	/** 
	 * TEST: This tests the button message SETTER method
	 */
	@Test
	public void setButtonMessageTest() {
		button.setButtonMessage(newMessage);
		assertEquals(button.getButtonMessage(),newMessage);
	}

}
