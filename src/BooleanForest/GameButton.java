/**
 * GAME BUTTON CLASS
 * 
* DESCRIPTION:
* The GameButton class sets the parameters, actions and the GUI for
* various buttons across the entire game.
* 
* SOURCES:
* https://github.com/kdeloach/labs/blob/master/java/yahtzee/src/Dice.java
* http://stackoverflow.com/questions/5751311/creating-a-custom-button-in-java-with-jbutton
* http://stackoverflow.com/questions/9149992/override-jbutton-paintcomponent-doesnt-work-java
* http://stackoverflow.com/questions/258486/calculate-the-display-width-of-a-string-in-java
* http://www.coderanch.com/t/337333/GUI/java/hex-set-background-color
* http://stackoverflow.com/questions/13345712/string-length-in-pixels-in-java
* http://stackoverflow.com/questions/15281940/set-color-of-jlabel-using-a-string
*/

package BooleanForest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class GameButton extends JButton implements MouseListener {
	// Declare members of the GameButton class:
	private int xCoord;								// button x-coordinate
	private int yCoord; 							// button y-coordinate
	private String buttonMessage;					// button text
	private String textColor; 						// button text color
	private int textWidth;							// button text width
	private int textHeight;							// button text height
	private boolean buttonPressed = false;			// indicates if button has been pressed	
	// Used for the color input
	private Map<String, Color> colorsList = new HashMap<String, Color>();
	
	/**
	 * DEFAULT CONSTRUCTOR: Sets up necessary button listeners and
	 * make sure we can interpret an color inputs.
	 * @param none
	 */
	public GameButton() {
		populateColorHashMap();						// create color hash map
		addMouseListener(this);						// add mouse listener
        enableInputMethods(true);					// enable input interpreter
	}
	
	/**
	 * OVERLOADED CONSTRUCTOR: Sets up necessary button listeners and
	 * make sure we can interpret an color inputs. Sets the buttonMessage
	 * and textColor values.
	 * @param buttonMessageInput
	 * @param colorInput
	 */
	public GameButton(String buttonMessage, String textColor) {
		this.buttonMessage = buttonMessage;			// set buttonMessage value
		this.textColor = textColor; 				// set textColor value
		
		populateColorHashMap();						// create color hash map
		addMouseListener(this);						// add mouse listener
        enableInputMethods(true);					// enable input interpreter
	}
	
	/**
	 * SETTER: Sets the xCoord of the button.
	 * @param xCoord
	 */
	public void setXCoord(int xCoord) {
		this.xCoord = xCoord;						// set the xCoord of the button
	}
	
	/**
	 * SETTER: Sets the yCoord of the button.
	 * @param yCoord
	 */
	public void setYCoord(int yCoord) {
		this.yCoord = yCoord;						// set the yCoord of the button
	}

	/**
	 * SETTER: Sets the buttonMessage of the button.
	 * @param buttonMessage
	 */
	public void setButtonMessage(String buttonMessage) {
		this.buttonMessage = buttonMessage;			// set the buttonMessage of the button
	}
	
	/**
	 * SETTER: Sets the textColor of the button.
	 * @param textColor
	 */
	public void setColor(String textColor) {
		this.textColor = textColor;					// set the textColor of the button
	}
	
	/**
	 * GETTER: Returns the xCoord of the button.
	 * @return xCoord
	 */
	public double getXCoord() {
		return xCoord; 								// return the xCoord of the button
	}
	
	/**
	 * GETTER: Returns the yCoord of the button.
	 * @return yCoord
	 */
	public double getYCoord() {
		return yCoord; 								// return the yCoord of the button
	}
	
	/**
	 * GETTER: Returns the buttonMessage of the button.
	 * @return buttonMessage
	 */
	public String getButtonMessage() {
		return buttonMessage;						// return the buttonMessage of the button
	}
	
	/**
	 * METHOD: This method converts the textColor member into an
	 * actual color.
	 * @param none
	 * NOTE: Code heavily adapted from StackOverflow source listed above.
	 */
	public void populateColorHashMap() {
		colorsList.put("blue", Color.BLUE);			// add blue
		colorsList.put("red", Color.RED);			// add red
		colorsList.put("green", Color.GREEN);		// add green
		colorsList.put("white", Color.WHITE);		// add white
		colorsList.put("black", Color.BLACK);		// add black
		colorsList.put("grey", Color.GRAY);			// add grey
		colorsList.put("yellow", Color.YELLOW);		// add yellow
	}
	
	/**
	 * METHOD: This method measures the length and width of the string
	 * and is used to change the size of the button as the text changes.
	 * @param g
	 */
	public void measureButtonTextLengthAndWidth(Graphics g) {
		// Get the font and render the context.
        Font font = g.getFont();
        FontRenderContext context = ((Graphics2D) g).getFontRenderContext();
        
        // Set the width and height of the 
    	textWidth = (int)(font.getStringBounds(buttonMessage, context).getWidth());
    	textHeight = (int)(font.getStringBounds(buttonMessage, context).getHeight());
	}
	
	/**
	 * OVERRIDDEN METHOD: This method overrides getPreferredSize() and
	 * sets the preferred size of the JComponent.
	 * @return size
	 * NOTE: Code heavily adapted from StackOverflow source listed above.
	 */
	@Override 
    public Dimension getPreferredSize() {    
		// Get the font and construct a BufferedImage of one of type TYPE_INT_ARGB.
		Font font = getFont();
		BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		
		// Get the width and height of the buttonMessage
		FontMetrics fontMetrics = bufferedImage.getGraphics().getFontMetrics(font);
		int fmWidth = fontMetrics.stringWidth(buttonMessage);
		int fmHeight = fontMetrics.getHeight();

		// Instantiate Dimension object with fmWidth and fmHeight and return.
        Dimension size = new Dimension(fmWidth + 20, fmHeight + 11);
        return size;
    }
	
	/**
	 * OVERRIDDEN METHOD: This method overrides getMinimumSize() and
	 * calls overridden getPreferredSize().
	 * @return size 
	 */
	@Override 
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
	
	/**
	 * OVERRIDDEN METHOD: This method overrides getMaximumSize() and
	 * calls overridden getPreferredSize().
	 * @return size 
	 */
	@Override 
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mouseExited() and
	 * sets buttonPressed to false and calls repaint().
	 * @param arg0
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		buttonPressed = false;						// set buttonPressed to false
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mouseReleased() and
	 * sets buttonPressed to false and calls repaint().
	 * @param arg0
	 */ 
	@Override
	public void mouseReleased(MouseEvent arg0) {
		buttonPressed = false;						// set buttonPressed to false
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mouseClicked() and
	 * sets buttonPressed to false and calls repaint().
	 * @param e
	 */  
	@Override
	public void mouseClicked(MouseEvent e) {
		buttonPressed = false;						// set buttonPressed to false
	}

	/**
	 * OVERRIDDEN METHOD: This method overrides mousePressed() and
	 * sets buttonPressed to false and calls repaint().
	 * @param e
	 */  
	@Override
	public void mousePressed(MouseEvent e) {
		buttonPressed = true;						// set buttonPressed to true
	}
	
	/**
	 * OVERRIDDEN METHOD: This method overrides paintComponent() by
	 * setting the width and height of the button, adding a gradient
	 * to the button background and drawing the buttonMessage on the
	 * button. If the button is pressed, the background color of the 
	 * button will change to indicate to the user that the button has
	 * been pressed.
	 * @param g
	 */  
	@Override 
    public void paintComponent(Graphics g) {
		measureButtonTextLengthAndWidth(g);			// measure and set the textWidth and textHeight members
    	 
		// If buttonPressed == true (indicating that button has been pressed),
		// change the button background color to indicate to the user that the
		// button has been pressed.
    	if (buttonPressed == false) {
    		// Create another graphics object and create a custom color.
    		Graphics2D graphics2 = (Graphics2D) g;
    		Color darkBlue = Color.decode("#000080");

    		// Create a gradient for the button background and fill rounded
    		// rectangle with the gradient.
    		GradientPaint blackToGray = new GradientPaint(xCoord + (textHeight / 2), yCoord - 10, darkBlue,
    													  xCoord + (textHeight / 2), yCoord + textHeight + 10,
    													  Color.BLUE);
    		graphics2.setPaint(blackToGray);
    		graphics2.fillRoundRect(xCoord, yCoord, textWidth + 16, textHeight + 11, 15, 15);
            
    		// Set the buttonMessage color to textColor and draw the string. 
            g.setColor(colorsList.get(textColor.toLowerCase()));
            g.drawString(buttonMessage, xCoord + 8, yCoord + 18);
    	}
    	
    	// If buttonPressed == false (indicating that button has not been pressed),
    	// use the default background color set below.
    	else {
    		// Create another graphics object, set the background color and
    		// fill rounded rectangle.
    		Graphics2D g2 = (Graphics2D) g;
    	    g2.setPaint(Color.BLUE);
            g2.fillRoundRect(xCoord, yCoord, textWidth + 16, textHeight + 11, 15, 15);
            
            // Set the buttonMessage color to textColor and draw the string. 
            g.setColor(colorsList.get(textColor.toLowerCase()));
            g.drawString(buttonMessage, xCoord + 8, yCoord + 18);
    	}
    }
}