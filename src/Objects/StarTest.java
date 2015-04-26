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
public class StarTest {
	
	private Star star;
	private String level;
	private int xCoord, yCoord;
	private String newLevel;
	private int newXCoord, newYCoord;
	
	/**
	 * METHOD: StarTest Constructor.
	 */
	public StarTest(String level, int xCoord, int yCoord,
					String newLevel, int newXCoord, int newYCoord) {		
		this.level = level;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.newLevel = newLevel;
		this.newXCoord = newXCoord;
		this.newYCoord = newYCoord;
	}
	
	/**
	 * METHOD: This method specifies all of the parameters to test. 
	 * There are 5 tests. For each test, there is a level designator string,
	 * and x coordinate, and a y coordinate to correspond to the ones set by
	 * the method
	 * @return a list of parameters
	 */
	@Parameters
	public static Collection<Object[]> getTestParameters() {

		// Each test has four sets of XY coordinates
		// The parameters are initially stored in a two dimensional object
		Object [][] myTestParameters = new Object [][] {
				{"ONE", 588, 433, "TWO", 547, 433},
				{"TWO", 547, 433, "THREE", 506, 433},
				{"THREE", 506, 433, "FOUR", 465, 433},
				{"FOUR", 465, 433, "FIVE", 424, 433},
				{"FIVE", 424, 433, "ONE", 588, 433}
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
		star = new Star(level);
	}
	
	/**
	 * TEST: This tests the x coordinate GETTER method
	 */
	@Test
	public void getXCoordTest() {		
		assertEquals(star.getXCoord(), xCoord);
	}
	
	/**
	 * TEST: This tests the y coordinate GETTER method
	 */
	@Test
	public void getYCoordTest() {		
		assertEquals(star.getYCoord(), yCoord);
	}

	/**
	 * TEST: This tests the owl name SETTER method
	 */
	@Test
	public void setCoordinatesTest() {		
		star.setCoordinates(newLevel);
		assertEquals(star.getXCoord(), newXCoord);
		assertEquals(star.getYCoord(), newYCoord);
	}
	
	/**
	 * TEST: This tests the x coordinate SETTER method
	 */
	@Test
	public void setXCoordTest() {
		star.setXCoord(newXCoord);
		assertEquals(star.getXCoord(), newXCoord);
	}
	
	/**
	 * TEST: This tests the y coordinate SETTER method
	 */
	@Test
	public void setYCoordTest() {		
		star.setYCoord(newYCoord);
		assertEquals(star.getYCoord(), newYCoord);
	}
}