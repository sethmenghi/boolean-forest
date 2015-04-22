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
* 
*/

package BooleanForest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import java.util.HashMap;
import java.util.Map;

public class GameButton extends JButton implements MouseListener {
	// Declare members of the GameButton class:
	private int xCoord;								// button x-coordinate
	private int yCoord; 							// button y-coordinate
	private int width;								// button width
	private int height;								// button height
	private String buttonMessage;					// button text
	private String textColor; 						// button text color
	private ButtonActionListener myButtonListener;	// action listener for button
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
	 * OVERLOADED CONSTRUCTOR: Sets up necessary button listeners and
	 * make sure we can interpret an color inputs. Sets the x- and
	 * y-coordinates, buttonMessage and textColor values.
	 * @param xCoord
	 * @param yCoord
	 * @param buttonMessageInput
	 * @param colorInput
	 */
	public GameButton(int xCoord, int yCoord, String buttonMessage, String textColor) {
		this.xCoord = xCoord;						// set the xCoord value
		this.yCoord = yCoord;						// set the yCoord value
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
	
	// Note: code heavily inspired by StackOverflow answer. See link above. 
	// We use this to convert string color inputs into actual colors
	public void populateColorHashMap() {
		colorsList.put("blue", Color.BLUE);
		colorsList.put("red", Color.RED);
		colorsList.put("green", Color.GREEN);
		colorsList.put("white", Color.WHITE);
		colorsList.put("black", Color.BLACK);
		colorsList.put("grey", Color.GRAY);
		colorsList.put("yellow", Color.YELLOW);

	}
	
	// I measure the length and width of the string 
	// This is used to change the size of the button as the text changes 
	public void measureStringLengthAndWidth(Graphics graphics) {
        Font font = graphics.getFont();
        FontRenderContext context = ((Graphics2D) graphics).getFontRenderContext();
        
    	width = (int)(font.getStringBounds(buttonMessage, context).getWidth());
    	height = (int)(font.getStringBounds(buttonMessage, context).getHeight());
	}
	
	// Note: code heavily inspired by StackOverflow answer. See link above. 
	// Sets the preferred size of the JComponent 
	@Override 
    public Dimension getPreferredSize() {    	
		Font font = getFont();
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		int width = fm.stringWidth(buttonMessage);
		int height = fm.getHeight();

        Dimension size = new Dimension(width+20, height+11);
        return size;
    }
	
	@Override 
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
	
	@Override 
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }
	
	// Mouse listener. 
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Do nothing 
	}

	// Mouse listener. Note that we repaint after change. 
	@Override
	public void mouseExited(MouseEvent arg0) {
		buttonPressed=false;
		repaint();				
	}

	// Mouse listener. Note that we repaint after change. 
	@Override
	public void mouseReleased(MouseEvent arg0) {
		buttonPressed=false;
		repaint();		
	}

	// Mouse listener. Note that we repaint after change. 
	@Override
	public void mouseClicked(MouseEvent e) {
		buttonPressed=false;
		repaint();				
	}

	// Mouse listener. Note that we repaint after change. 
	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("Hi there");
		buttonPressed=true;
		repaint();	    
	}
	
	// I override the paint components class to make a 
	// custom button. 
	@Override 
    public void paintComponent(Graphics graphics) {
		
		// I first need to measure the width of my string to 
		// adjust the size of the button accordingly
		measureStringLengthAndWidth(graphics);
    	
		// I display a different button color if the button is 
		// pressed versus when it is not pressed 
    	if(buttonPressed==false)
    	{
    		
    		// I create another graphics object and create a custom color 
    		Graphics2D graphics2 = (Graphics2D) graphics;
    		Color darkBlue = Color.decode("#000080");

    		// I create a gradient and add it to the rectangle
    		GradientPaint blackToGray = new GradientPaint(xCoord+ (height/2), yCoord - 10, darkBlue,
    				xCoord+ (height/2), yCoord +  height + 10, Color.BLUE);
    		graphics2.setPaint(blackToGray);
    		
    		// I fill rectangle with gradient 
    		graphics2.fillRoundRect(xCoord, yCoord, width+16, height+11, 15, 15);
            
    		// I draw the string and set its color based on the input 
            graphics.setColor(colorsList.get(textColor.toLowerCase()));
            graphics.drawString(buttonMessage,xCoord+8,yCoord+18);
    	}
    	
    	// If button is  pressed 
    	else{
    		
    		// I create a gradient and add it to the rectangle
    		Graphics2D g2 = (Graphics2D) graphics;
    	    g2.setPaint(Color.BLUE);
            g2.fillRoundRect(xCoord, yCoord, width+16, height+11, 15, 15);
            
    		// I draw the string and set its color based on the input 
            graphics.setColor(colorsList.get(textColor.toLowerCase()));
            graphics.drawString(buttonMessage,xCoord+8,yCoord+18);
            
    	}
    }
}