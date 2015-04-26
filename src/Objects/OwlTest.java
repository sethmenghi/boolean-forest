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
public class OwlTest {
	
	private Owl owl;
	private int xCoord, yCoord;
	private String name;
	private int newXCoord, newYCoord;
	private String newName;
	
	/**
	 * METHOD: OwlTest Constructor.
	 */
	public OwlTest(int xCoord, int yCoord, String name,
					int newXCoord, int newYCoord, String newName) {		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.name = name;
		this.newXCoord = newXCoord;
		this.newYCoord = newYCoord;
		this.newName = newName;
	}
	
	/**
	 * METHOD: This method specifies all of the parameters to test. 
	 * There are 4 tests. For each test, there is and x and a y 
	 * coordinate, the owl name, an x and y coordinate to change to, 
	 * and a name to change to.
	 * @return a list of parameters
	 */
	@Parameters
	public static Collection<Object[]> getTestParameters() {

		// Each test has four sets of XY coordinates
		// The parameters are initially stored in a two dimensional object
		Object [][] myTestParameters = new Object [][] {
				{160, 95, "Bob", 355, 10, "New Bob"},
				{45, 180, "Alice", 100, 245, "New Alice"},
				{250, 135, "Chloe", 210, 50, "New Chloe"},
				{190, 220, "David", 320, 300, "New David"}
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
		owl = new Owl(xCoord, yCoord, name);
	}
	
	/**
	 * TEST: This tests the owl name GETTER method
	 */
	@Test
	public void getOwlNameTest() {		
		assertEquals(owl.getOwlName(), name);
	}
	
	/**
	 * TEST: This tests the x coordinate GETTER method
	 */
	@Test
	public void getXCoordTest() {		
		assertEquals(owl.getXCoord(), xCoord);
	}
	
	/**
	 * TEST: This tests the y coordinate GETTER method
	 */
	@Test
	public void getYCoordTest() {		
		assertEquals(owl.getYCoord(), yCoord);
	}

	/**
	 * TEST: This tests the owl name SETTER method
	 */
	@Test
	public void setOwlNameTest() {		
		owl.setOwlName(newName);
		assertEquals(owl.getOwlName(), newName);
	}
	
	/**
	 * TEST: This tests the x coordinate SETTER method
	 */
	@Test
	public void setXCoordTest() {
		owl.setXCoord(newXCoord);
		assertEquals(owl.getXCoord(), newXCoord);
	}
	
	/**
	 * TEST: This tests the y coordinate SETTER method
	 */
	@Test
	public void setYCoordTest() {		
		owl.setYCoord(newYCoord);
		assertEquals(owl.getYCoord(), newYCoord);
	}
}