package BooleanForest;

import javax.swing.JButton;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

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
import java.util.HashMap;
import java.util.Map;

// SOURCES: 
// https://github.com/kdeloach/labs/blob/master/java/yahtzee/src/Dice.java
// http://stackoverflow.com/questions/5751311/creating-a-custom-button-in-java-with-jbutton
// http://stackoverflow.com/questions/9149992/override-jbutton-paintcomponent-doesnt-work-java
// http://stackoverflow.com/questions/258486/calculate-the-display-width-of-a-string-in-java
// http://www.coderanch.com/t/337333/GUI/java/hex-set-background-color
// http://stackoverflow.com/questions/13345712/string-length-in-pixels-in-java
// http://stackoverflow.com/questions/15281940/set-color-of-jlabel-using-a-string

// This class sets the parameters, actions and the GUI for the 
// various buttons across the entire game 
public class GameButton extends JButton implements MouseListener{
	
	// The button coordinates/ location
	// Had to make int for draw function 
	private int xCoord;
	private int yCoord; 
	
	// The button text and color 
	private String buttonMessage;
	private String colorForText; 
	
	// Action listener for the button
	private ButtonActionListener myButtonListener;
	
	// Values for the size of the button
	int textwidth;
	int textheight;
	
	// Boolean that indicates if the button is pressed \
	boolean buttonPressed =false;
	
	// Used for the color input
	Map<String, Color> colorsList = new HashMap<String, Color>();
	
	
	// Constructor when no arguments are passed 
	public GameButton()
	{
		// We first set up the necessary button listeners
		// and make sure that we can interpret any color inputs
		populateColorHashMap();
		addMouseListener(this);
        enableInputMethods(true);
	}
	
	// Constructor when no location is passed 
	public GameButton(String buttonMessageInput, String colorInput)
	{

		// Take in the constructor arguments
		buttonMessage=buttonMessageInput;
		colorForText=colorInput; 
		
		// We first set up the necessary button listeners
		// and make sure that we can interpret any color inputs
		populateColorHashMap();
		addMouseListener(this);
        enableInputMethods(true);

	}
	
	// Constructor when  location is passed 
	public GameButton(int xCoordInput, int yCoordInput, String buttonMessageInput, String colorInput)
	{
		
		// Take in the constructor arguments
		xCoord=xCoordInput;
		yCoord=yCoordInput;
		buttonMessage=buttonMessageInput;
		colorForText=colorInput; 
		
		// We first set up the necessary button listeners
		// and make sure that we can interpret any color inputs
		populateColorHashMap();
		addMouseListener(this);
        enableInputMethods(true);
		
	}

	// I override the paint components class to make a 
	// custom button. 
	@Override 
    public void paintComponent(Graphics graphics)
    {
		
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
    		GradientPaint blackToGray = new GradientPaint(xCoord+ (textheight/2), yCoord - 10, darkBlue,
    				xCoord+ (textheight/2), yCoord +  textheight + 10, Color.BLUE);
    		graphics2.setPaint(blackToGray);
    		
    		// I fill rectangle with gradient 
    		graphics2.fillRoundRect(xCoord, yCoord, textwidth+16, textheight+11, 15, 15);
            
    		// I draw the string and set its color based on the input 
            graphics.setColor(colorsList.get(colorForText.toLowerCase()));
            graphics.drawString(buttonMessage,xCoord+8,yCoord+18);
    	}
    	
    	// If button is  pressed 
    	else{
    		
    		// I create a gradient and add it to the rectangle
    		Graphics2D g2 = (Graphics2D) graphics;
    	    g2.setPaint(Color.BLUE);
            g2.fillRoundRect(xCoord, yCoord, textwidth+16, textheight+11, 15, 15);
            
    		// I draw the string and set its color based on the input 
            graphics.setColor(colorsList.get(colorForText.toLowerCase()));
            graphics.drawString(buttonMessage,xCoord+8,yCoord+18);
            
    	}
    }
    
	// I measure the length and width of the string 
	// This is used to change the size of the button as the text changes 
	public void measureStringLengthAndWidth(Graphics graphics)
	{
        Font font = graphics.getFont();
        FontRenderContext context = ((Graphics2D) graphics).getFontRenderContext();
        
    	textwidth = (int)(font.getStringBounds(buttonMessage, context).getWidth());
    	textheight = (int)(font.getStringBounds(buttonMessage, context).getHeight());
	}
	
	// Note: code heavily inspired by StackOverflow answer. See link above. 
	// We use this to convert string color inputs into actual colors
	public void populateColorHashMap()
	{
		colorsList.put("blue", Color.BLUE);
		colorsList.put("red", Color.RED);
		colorsList.put("green", Color.GREEN);
		colorsList.put("white", Color.WHITE);
		colorsList.put("black", Color.BLACK);
		colorsList.put("grey", Color.GRAY);
		colorsList.put("yellow", Color.YELLOW);

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
	
	// Note: code heavily inspired by StackOverflow answer. See link above. 
	// Sets the preferred size of the JComponent 
	@Override 
    public Dimension getPreferredSize()
    {    	
		Font font = getFont();
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		FontMetrics fm = img.getGraphics().getFontMetrics(font);
		int width = fm.stringWidth(buttonMessage);
		int height = fm.getHeight();

        Dimension size = new Dimension(width+20, height+11);
        return size;
    }
	
	@Override 
    public Dimension getMinimumSize()
    {
        return getPreferredSize();
    }
	
	@Override 
    public Dimension getMaximumSize()
    {
        return getPreferredSize();
    }
	

	public void setColor(String colorInput)
	{
		colorForText=colorInput;
	}
	
	public void setButtonMessage(String buttonMessageInput)
	{
		buttonMessage=buttonMessageInput;
	}
	
	public void setXCoord(int xCoordInput)
	{
		xCoord=xCoordInput;
	}
	
	public void setYCoord(int yCoordInput)
	{
		xCoord=yCoordInput;
	}
	
	public double getXCoord()
	{
		return xCoord; 
	}
	
	public double getYCoord()
	{
		return yCoord; 
	}
	
}
