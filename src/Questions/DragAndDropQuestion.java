package Questions;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.font.FontRenderContext;
import java.awt.image.ImageObserver;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import BooleanForest.Game;
import Objects.GameButton;

// Sources:
// http://stackoverflow.com/questions/29054963/how-to-make-a-jbutton-not-clickable-in-java
// http://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
// http://bioportal.weizmann.ac.il/course/prog2/tutorial/uiswing/layout/gridbag.html
// http://www.dreamincode.net/forums/topic/277446-dragging-an-image-with-the-mouse/ <-- Used a lot from this 
// http://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
// http://copypastejavacode.blogspot.com/2012/01/code-of-java-that-set-opacity-of-image.html
// https://docs.oracle.com/javase/7/docs/api/java/awt/Image.html

// This class implements the drag and drop questions. Only one instance of this class is instantiated (in Game)
// and then the program changes the necessary content as necessary to move from question to question. It allows
// the user to drag and drop items unto an owl to fit the boolean logic statement. NOTE: this class is set up
// to allow the level class to pass along what items can be dragged. These items are therefore called items and 
// are not referred to by the description (basktball, glasses, hat, etc). 
public class DragAndDropQuestion extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	
	// Public static final members of class:
	// We need to set the location of each draggable dress icon
	// Note: I originally tried to not use null layout but gridbag layout. 
	// This approach did not work with drag and drop 
	private static final int ITEM_ONE_X_COORD=Game.APPLET_WIDTH/2-115;		// Basketball Location
	private static final int ITEM_TWO_X_COORD=Game.APPLET_WIDTH/2-75;		// Glasses location
	private static final int ITEM_THREE_X_COORD=Game.APPLET_WIDTH/2-35;		// Hat location
	private static final int ITEM_FOUR_X_COORD=Game.APPLET_WIDTH/2+5;		// Scarf location
	private static final int ITEM_FIVE_X_COORD=Game.APPLET_WIDTH/2+45;		// Soccer ball location
	private static final int ITEM_SIX_X_COORD=Game.APPLET_WIDTH/2+85;		// Tie location 
	private static final int ITEM_Y_COORD=350;								// The Y location is the same for every item 
	private static final int ITEM_WIDTH = 30; 								// Set the constant width for the draggable icons
	private static final int ITEM_HEIGHT = 30; 								// Set the constant height for the draggable icons
	
	private static final int QUESTION_STRING_Y_COORD=90; 					// The Y coordinate of the question string 
	
	// Constants for the Owl in the middle 
	private static final int OWL_Y_COORD=70;								// Set the Y coordinate of the owl in the middle 
	private static final int OWL_LEFT_BOUND=240;							// Left bound of owl (used to measure drop area)
	private static final int OWL_RIGHT_BOUND=400;							// Right bound of owl (used to measure drop area)
	private static final int OWL_TOP_BOUND=130;								// Top bound of owl (used to measure drop area)
	private static final int OWL_BOTTOM_BOUND=310;							// Bottom bound of owl (used to measure drop area)	

	
	private static String BACKGROUND_IMAGE="/Images/Backgrounds/BackgroundForDragDropQuestion.png";
		
	// The Level class calls setAnswersForEachItem to set each of these values
	// This allows us to have multiple right answers at the same time 
	private boolean isItemOneCorrectAnswer; 
	private boolean isItemTwoCorrectAnswer; 
	private boolean isItemThreeCorrectAnswer; 
	private boolean isItemFourCorrectAnswer; 
	private boolean isItemFiveCorrectAnswer; 
	private boolean isItemSixCorrectAnswer; 

	Game theGame;											// The level class passes the game
	private String questionText;							// This is the question text that is passed by the level class 
	private ArrayList<String> possibleAnswersList; 			// In order to be flexible, the class allows level class to input items at bottom
	
	// When the item is dragged, this the image that is seen
	// It is set using the possibleAnswersList inputed by the game class
	private Image itemOne;
	private Image itemTwo;
	private Image itemThree;
	private Image itemFour;
	private Image itemFive;
	private Image itemSix;
	
	// The dragable dress icons at the bottom are JLabels with action listeners 
	private JLabel itemOneLabel;
	private JLabel itemTwoLabel;
	private JLabel itemThreeLabel;
	private JLabel itemFourLabel;
	private JLabel itemFiveLabel;
	private JLabel itemSixLabel;
	
	// Global variables updated throughout class 
	private int itemSelected=0;																		// When JLabel is clicked we track which item was selected
	private boolean firstSetUp; 																	// The GUI setup is different if it is the first time
	private String instructionText = "Click items to select them. Then drag them over Bob!";		// The instruction text changes depending on state 
	private int numberOfAnswersCorrect;																// We track how many correct items have been dragged on Owl
	private boolean haveSolvedQuestion=false; 														// Once true, show next question button 

	// We also track which item was previously dragged unto the Owl 
	boolean itemOneAdded = false; 									
	boolean itemTwoAdded = false; 
	boolean itemThreeAdded = false; 
	boolean itemFourAdded = false; 
	boolean itemFiveAdded = false; 
	boolean itemSixAdded = false; 

	// Button to go to the next 
	private GameButton nextQuestionButton; 
	
	// Global variables used to control drag drop operation 
	// Note: this compoenent heavily borrowed from source. See above. 
	boolean isMouseDrag=false;		// Is true when mouse is being draggeed							
	int posX;						// The X position of the drag. Used to paint item 
	int posY;						// The Y position of the drag. Used to paint item
	int mouseXPos;					// Tracks the x position of the mouse for the drag
	int mouseYPos;					// Tracks the y position of the mouse for the drag
	
	// Constructor which is called only once 
	public DragAndDropQuestion(Game game) 
	{
		theGame = game; 
		firstSetUp=true;
	}
	
	// Initialized the GUI. Is different if it is first time or not 
	public void initGUI(){
				
		if(firstSetUp==true)
		{
			
			// Set the preferences of the JPANEL 
			setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
			setDoubleBuffered(true);
			setLayout(null);	    
		    initDragDrop();																	// Seperate method to instantiate drag drop components 		
		    
		    // Need to add all the dragabble items at the bottom
		    // They are JLabels with image 
			ImageIcon imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(0)));		// Get the image from the list passed by level class
			itemOneLabel = new JLabel();													// Create new JLabel
			itemOneLabel.setIcon(imageToAddToJLabel);										// Set image
			itemOneLabel.addMouseListener(this);											// Add mouse listener to listen for clicks 
			itemOneLabel.setBounds(ITEM_ONE_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);	// Use null layout to position 
		    add(itemOneLabel);																// Add to panel 
		    
		    // We repeat for the next 5 icons as well... 
		    
			imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(1)));
			itemTwoLabel = new JLabel();
			itemTwoLabel.setIcon(imageToAddToJLabel);
			itemTwoLabel.addMouseListener(this);
			itemTwoLabel.setBounds(ITEM_TWO_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);
		    add(itemTwoLabel);
		    
			imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(2)));
			itemThreeLabel = new JLabel();
			itemThreeLabel.setIcon(imageToAddToJLabel);
			itemThreeLabel.addMouseListener(this);
			itemThreeLabel.setBounds(ITEM_THREE_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);
		    add(itemThreeLabel);

			imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(3)));
			itemFourLabel = new JLabel();
			itemFourLabel.setIcon(imageToAddToJLabel);
			itemFourLabel.addMouseListener(this);
			itemFourLabel.setBounds(ITEM_FOUR_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);
		    add(itemFourLabel);
		    
			imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(4)));
			itemFiveLabel = new JLabel();
			itemFiveLabel.setIcon(imageToAddToJLabel);
			itemFiveLabel.addMouseListener(this);
			itemFiveLabel.setBounds(ITEM_FIVE_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);
		    add(itemFiveLabel);

			imageToAddToJLabel = new ImageIcon(getClass().getResource(possibleAnswersList.get(5)));
			itemSixLabel = new JLabel();
			itemSixLabel.setIcon(imageToAddToJLabel);
			itemSixLabel.addMouseListener(this);
			itemSixLabel.setBounds(ITEM_SIX_X_COORD,ITEM_Y_COORD,ITEM_WIDTH,ITEM_HEIGHT);
		    add(itemSixLabel);
		    
		    // Add next question button 
		    nextQuestionButton= new GameButton("Next >>","WHITE");								// Create new game button
		    nextQuestionButton.setBounds(Game.APPLET_WIDTH-140, Game.APPLET_HEIGHT/2,80,80);	// Set the bounds 
		    nextQuestionButton.setVisible(false);												// Set visible to false until answer correct
		    nextQuestionButton.addActionListener(this);
		    add(nextQuestionButton);
		    
		    firstSetUp=false;																	// This section won't run next time 
		    
		    repaint(); 
		}
			
		else{
			
			// If GUI already set up, we just need to reset some variables
			reset();
		}

		// Repaint so all changes included 
	    repaint(); 

	}
	
	// Everytime we have a new question we need to reset these variables 
	public void reset(){
		
		itemOneAdded = false; 					// No items have been added
		itemTwoAdded = false; 
		itemThreeAdded = false; 
		itemFourAdded = false; 
		itemFiveAdded = false; 
		itemSixAdded = false; 
		haveSolvedQuestion=false; 				// Question has not been solved
		isMouseDrag=false;						// Mouse is not being dragged (for now)
		numberOfAnswersCorrect=0;				// Zero answers correct
		 		 
		itemOneLabel.setOpaque(false);			// We need to set each label as not opaque so coloring from prev Q gone 
		itemTwoLabel.setOpaque(false);	
		itemThreeLabel.setOpaque(false);
		itemFourLabel.setOpaque(false);
		itemFiveLabel.setOpaque(false);
		itemSixLabel.setOpaque(false);
		
		nextQuestionButton.setVisible(false); 	// Don't set visible until have the answer 
		
		instructionText = "Click items to select them. Then drag them over Bob!"; 
		
	}
	
	// Method called every new question
	// Used to set up items used by the drag drop functionality 
	public void initDragDrop(){
		
		// Need to set up the listeners 
	    addMouseListener(this);
	   	addMouseMotionListener(this);
	   	
	   	// We set the icons to the images passed by the class
	   	// Note: they can be changed even within a level 
	   	itemOne = new ImageIcon(getClass().getResource(possibleAnswersList.get(0))).getImage();
	   	itemTwo = new ImageIcon(getClass().getResource(possibleAnswersList.get(1))).getImage();
	   	itemThree = new ImageIcon(getClass().getResource(possibleAnswersList.get(2))).getImage();
	   	itemFour = new ImageIcon(getClass().getResource(possibleAnswersList.get(3))).getImage();
	   	itemFive = new ImageIcon(getClass().getResource(possibleAnswersList.get(4))).getImage();
	   	itemSix = new ImageIcon(getClass().getResource(possibleAnswersList.get(5))).getImage();
	   	 
	}

	// We override the paint component class to display everything in the GUI except the JLabels above
	@Override
	public void paintComponent(Graphics graphics) {
		
		super.paintComponent(graphics);						
		
		// Set the backfround of the panel 
		Image background = new ImageIcon(getClass().getResource(BACKGROUND_IMAGE)).getImage();
		graphics.drawImage(background, 0, 0, null);
		
		// Seperate method is used to draw strings
		drawStrings(graphics);
		
		// Called if the item is dragged over the owl and the user has released the drag 
		if(isOverOwl() && isMouseDrag==false){
					
			checkIfCorrectAnswer(); 				// We check if this is the correct answer
			itemSelected=0;							// We reset the item selected tracker 

			itemOneLabel.setVisible(true);			// We set all the labels as visible again 
			itemTwoLabel.setVisible(true);
			itemThreeLabel.setVisible(true);
			itemFourLabel.setVisible(true);
			itemFiveLabel.setVisible(true);
			itemSixLabel.setVisible(true);
			
			// We redraw thw owl image 
			Image owlImage = new ImageIcon(getClass().getResource(getBobImage())).getImage(); 									// Call different method to get which image
			ImageObserver observer = null;																// Use observer to get the width of the owl image 
			graphics.drawImage(owlImage,Game.APPLET_WIDTH/2-owlImage.getWidth(observer)/2,OWL_Y_COORD, null);	
			
		}
		
		// Called if the dragged item is over owl but is still being dragged
		// Do the same as above but do not reset labels and have low opacity owl
		else if(isOverOwl())
		{
			Image owlImage = new ImageIcon(getClass().getResource(getBobImage())).getImage();
			ImageObserver observer = null;

		    Graphics2D graphicsToSetOpacity = (Graphics2D) graphics;														// We need 2D graphics to change image opacity 
		    float alpha = 0.5f;																								// Set the alpha for the opacity 
		    graphicsToSetOpacity.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		    graphicsToSetOpacity.drawImage(owlImage,Game.APPLET_WIDTH/2-owlImage.getWidth(observer)/2,OWL_Y_COORD,null);
		}
		

		// Called if no dragged item over owl
		// Simply draw the nowmal owl 
		else{
			Image originalOwl = new ImageIcon(getClass().getResource(getBobImage())).getImage();
			ImageObserver observer = null;
			graphics.drawImage(originalOwl,Game.APPLET_WIDTH/2-originalOwl.getWidth(observer)/2,OWL_Y_COORD,null);
		}

		// If an item is selected, we need to draw that icon as it is being dragged
		if(itemSelected>0)
		{
			graphics.drawImage(getSelectedImage(), posX, posY, null);		// We get the x and y coordinates from the listeners below 
		}
				
   	}
	
	// Seperate method used to drawthe string in paintComponent 
	public void drawStrings(Graphics graphics)
	{
		
		// The 5th question has different font to fit size
		if(theGame.levelFive.questionInLevel!=5)
		{
			// We draw a string two display the question text
			Graphics2D graphicsForString = (Graphics2D) graphics;															// Need to create a 2D object to adjust font and color 				
			graphicsForString.setFont(Game.LESSON_STATEMENT);																// Set the font 
			graphicsForString.setColor(Game.DARK_BLUE);																		// Set the color
			graphicsForString.drawString(questionText,																		// Draw the string 
					Game.APPLET_WIDTH/2-measureStringWidth(graphics,questionText)/2,QUESTION_STRING_Y_COORD);	
			
		}
		
		else{
			
			// We draw a string two display the question text
			Graphics2D graphicsForString = (Graphics2D) graphics;															// Need to create a 2D object to adjust font and color 				
			graphicsForString.setFont(Game.SMALL_STATEMENT);																// Set the font 
			graphicsForString.setColor(Game.DARK_BLUE);																		// Set the color
			graphicsForString.drawString(questionText,																		// Draw the string 
					Game.APPLET_WIDTH/2-measureStringWidth(graphics,questionText)/2,QUESTION_STRING_Y_COORD);			
		}
		
		// We follow the same process as above to draw the instruction text 
		Graphics2D graphicsForStringTwo = (Graphics2D) graphics;
		graphicsForStringTwo.setFont(Game.PARAGRAPH_FONT);					
		graphicsForStringTwo.setColor(Game.DARK_BLUE);			
		graphicsForStringTwo.drawString(instructionText, Game.APPLET_WIDTH/2-measureStringWidth(graphics,instructionText)/2, Game.APPLET_HEIGHT-70);


	}
	
	// This returns which image to show based on which item is being dragged 
	public Image getSelectedImage()
	{
		
		// Item selected is a int set when the JLabel is originally clicked 
		switch(itemSelected){
			case 1:
				return itemOne; 
			case 2:
				return itemTwo;
			case 3:
				return itemThree;
			case 4:
				return itemFour;
			case 5:
				return itemFive;
			case 6:
				return itemSix;
			default:
				return itemOne; 
		}
	}
	
	// This method returns which label was last clicked
	// This is used to update the coloring of the labels after the user makes a drag and drop move 
	public JLabel getSelectedLabel()
	{
		switch(itemSelected){
			case 1:
				return itemOneLabel; 
			case 2:
				return itemTwoLabel;
			case 3:
				return itemThreeLabel;
			case 4:
				return itemFourLabel;
			case 5:
				return itemFiveLabel;
			case 6:
				return itemSixLabel;
			default:
				return itemOneLabel; 
		}
	}

	// Called after drag drop is done and don't want the coordinates from previous operation 
	public void resetPositionMarkers()
	{
		posX=0;
		posY=0;
	}
	
	// Returns true if the dragged item is over the owl
	// This is used to change the opacity of the owl and to drop items 
	public boolean isOverOwl()
	{
		// These are the constants that define where the Owl is 
		if(posX>OWL_LEFT_BOUND && posX<OWL_RIGHT_BOUND && posY>OWL_TOP_BOUND && posY<OWL_BOTTOM_BOUND)
		{
			return true;
		}
		
		else{
			return false; 
		}
	}
	
	
	// Called by the paintCompoent class to check if item dragged is the correct one 
	public void checkIfCorrectAnswer(){
		
		// We check it against the correct answer's inputed 
		// If true, change the label color and update variables 
		if(checkAgainstInputedAnswers())
		{
			
			// The instruction text is different if they have the first answer correct of if they have both 
			if(numberOfAnswersCorrect==0)
			{
				instructionText="Correct answer! Drag one more item ";						// Call them to drag another item
			}
			
			else{
				instructionText="Correct answer! Click arrow to move to next question ";	// Button will bow be visible 
			}
			
			getSelectedLabel().setForeground(Color.GREEN);									// Update the labels 
			getSelectedLabel().setBackground(Color.GREEN);									// Update the labels 
			getSelectedLabel().setOpaque(true);
			numberOfAnswersCorrect++; 														// Increment counter of number of answers correct

		}
		
		// If answer incorrect
		else{
			
			instructionText="Incorrect answer. Try again!";									// Text tells them to try again
			getSelectedLabel().setForeground(Color.RED);									// Set the label color to red 
			getSelectedLabel().setBackground(Color.RED);
			getSelectedLabel().setOpaque(true);
			
		}
		
		// If have both answers, show the next level button 
		if(numberOfAnswersCorrect==2){
			
			haveSolvedQuestion=true;
		    nextQuestionButton.setVisible(true);

		}
		
		resetPositionMarkers();																// Drag and drop is over for this item, reset
		repaint();

	}
	
	// The level class tells us which items can be dragged unto Owl
	// Here we check if they were right and also update the boolean itemAdded for that item 
	public boolean checkAgainstInputedAnswers()
	{
		
		// Use the item selected to figure out which item we are talking about 
		switch(itemSelected){
		
			case 1:
				if(isItemOneCorrectAnswer){				// If item one is answer, return true
					itemOneAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 2:
				if(isItemTwoCorrectAnswer){				// If item two is answer, return true	
					itemTwoAdded=true;
					return true;
				}
				
				else{
					return false; 
				}

			case 3:
				if(isItemThreeCorrectAnswer){			// If item three is answer, return true
					itemThreeAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 4:
				if(isItemFourCorrectAnswer){			// If four four is answer, return true
					itemFourAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 5:
				if(isItemFiveCorrectAnswer){			// If item five is answer, return true
					itemFiveAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 6:
				if(isItemSixCorrectAnswer){				// If item six is answer, return true
					itemSixAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			default:
				return false; 
		
		}
	}
	
	// We need to be able to measure the width of a string to position string on screen
	public int measureStringWidth(Graphics g, String inputString) {

		Font font = g.getFont();
        FontRenderContext context = ((Graphics2D) g).getFontRenderContext();
        int stringWidth = (int)(font.getStringBounds(inputString, context).getWidth());
        return stringWidth;
      
	}
	
	// Method that inputs the question text from level class
	public void setQuestionText(String questionTextInput)
	{
		questionText = questionTextInput;
	}
	
	// Method that imports the array list with the draggable icons at bottom
	public void setListOfPossibleAnswers(ArrayList<String> possibleAnswersInput){
		
		possibleAnswersList=possibleAnswersInput;
		
	}
		
	// Method that implements the correct answers passed by the level class	
	public void setAnswersForEachItem(boolean itemOneAnswerInput,boolean itemTwoAnswerInput,
			boolean itemThreeAnswerInput, boolean itemFourAnswerInput,
			boolean itemFiveAnswerInput, boolean itemSixAnswerInput){
			
		isItemOneCorrectAnswer=itemOneAnswerInput; 
		isItemTwoCorrectAnswer=itemTwoAnswerInput; 
		isItemThreeCorrectAnswer=itemThreeAnswerInput; 
		isItemFourCorrectAnswer=itemFourAnswerInput; 
		isItemFiveCorrectAnswer=itemFiveAnswerInput; 
		isItemSixCorrectAnswer=itemSixAnswerInput; 

	}
	

	@Override
	public void mouseDragged(MouseEvent e) {
		
		// If the boolean is true, we update variables 
		// NOTE: code heavily taken from source, see list above
		if (isMouseDrag)
		{

			int currentMX = e.getX();			// We store the current x value of the mouse
			int currentMY = e.getY();			// We store the current y value of the mouse
			
			posX += e.getX() - mouseXPos;		// We update x value of the mouse
			posY += e.getY() - mouseYPos; 		// We update y value of the mouse
			
			mouseXPos = currentMX;				// We then set the x mouse value to the current mouse value
			mouseYPos = currentMY;				// We then set the y mouse value to the current mouse value

			repaint();							// Repaint after values update
			e.consume();	
		}		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
	}

	// Overides to determined when an item is selected 
	@Override
	public void mousePressed(MouseEvent e) {
				
		mouseXPos = e.getX();							// We get the x coordinates of the click
		mouseYPos = e.getY();							// We get the y coordinates of the click
		isMouseDrag = true;								// Set mouse drag to truw 
		e.consume();
		
		if(e.getSource()==itemOneLabel)					// If item one selected
		{
			instructionText="Basketball Selected";		// Update instructions
			itemOneLabel.setVisible(false);				// Hide the label
			itemSelected=1; 							// Set which item is selected
		}
		
		// Repeat for each label 
		
		else if(e.getSource()==itemTwoLabel)
		{
			instructionText="Glasses Selected";
			itemTwoLabel.setVisible(false);
			itemSelected=2; 
		}
		
		else if(e.getSource()==itemThreeLabel)
		{
			instructionText="Hat Selected";
			itemThreeLabel.setVisible(false);
			itemSelected=3; 
		}
		
		else if(e.getSource()==itemFourLabel)
		{
			instructionText="Scarf Selected";
			itemFourLabel.setVisible(false);
			itemSelected=4; 
		}
		
		else if(e.getSource()==itemFiveLabel)
		{
			instructionText="Soccer Ball Selected";
			itemFiveLabel.setVisible(false);
			itemSelected=5; 
		}

		else if(e.getSource()==itemSixLabel){
			instructionText="Tie Selected";
			itemSixLabel.setVisible(false);
			itemSelected=6; 
		}
	
		setPositionOfDraggableIcon();		// Sets the position based on which label was clicked 
		repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		isMouseDrag = false;				// No longer a mouse drag
		e.consume();		
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isMouseDrag = false;				// No longer a mouse drag
		repaint();							// Repaint 

		
	}

	// Overide action lister to check if next quesrtion button is clicked 
	@Override
	public void actionPerformed(ActionEvent event) {

		// If clicked, we go to the next question 
		if(event.getSource()==nextQuestionButton){
			
			theGame.levelFive.nextQuestion();
			
		}
		
	}

	// When a JLabel is clicked, I immediately draw an image in its location to drag
	// These are the locations of those images 
	public void setPositionOfDraggableIcon()
	{
		// Return based on which item was selected
		switch(itemSelected){
		case 1:
			posX=ITEM_ONE_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		case 2:
			posX=ITEM_TWO_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		case 3:
			posX=ITEM_THREE_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		case 4:
			posX=ITEM_FOUR_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		case 5:
			posX=ITEM_FIVE_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		case 6:
			posX=ITEM_SIX_X_COORD; 
			posY=ITEM_Y_COORD;
			break;
		default:
			System.out.println("CALLED DEFAULT");
			posX=100; 
			posY=100;
			break;
		}
	}
	
	// Based on which combinations have been dragged over bob, I return a different image 
	public String getBobImage(){
			
		if(itemOneAdded && itemFourAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobBasketballScarf.png";
		}
		
		else if(itemOneAdded && itemFiveAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobSoccerBallBasketball.png";
		}
		
		else if (itemOneAdded && itemSixAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobBasketballTie.png";
		}
		
		else if (itemOneAdded && itemTwoAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobGlassesBasketball.png";
		}
		
		else if (itemTwoAdded && itemFiveAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobGlassesSoccerBall.png";
		}
		
		else if(itemTwoAdded && itemSixAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobGlassesTie.png";
		}
		
		else if(itemThreeAdded && itemOneAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHatBasketball.png";
		}
		
		else if(itemThreeAdded && itemTwoAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHatGlasses.png";
		}

		else if(itemThreeAdded && itemFourAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHatScarf.png";
		}
		
		else if(itemThreeAdded && itemFiveAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHatSoccerBall.png";
		}
		
		else if(itemThreeAdded && itemSixAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHatTie.png";
		}
		
		else if(itemFourAdded && itemFiveAdded){
			return "/Images/Levels/LevelFive/Questions/BobSoccerballScarf.png";
		}
		
		else if(itemFourAdded && itemTwoAdded){
			return "/Images/Levels/LevelFive/Questions/BobGlassesScarf.png";
		}
		
		else if(itemFiveAdded && itemSixAdded){
			return "/Images/Levels/LevelFive/Questions/BobSoccerballTie.png";
		}
		
		else if(itemOneAdded && itemSixAdded){
			return "/Images/Levels/LevelFive/Questions/BobTieBasketball.png";
		}

		else if(itemTwoAdded && itemSixAdded){
			return "/Images/Levels/LevelFive/Questions/BobTieGlasses.png";
		}
			
		else if(itemFiveAdded && itemSixAdded){
			return "/Images/Levels/LevelFive/Questions/BobTieSoccerBall.png";
		}
		
		else if(itemOneAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobBasketball.png";
		}
		
		else if(itemTwoAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobGlasses.png";
		}
		
		else if(itemThreeAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobHat.png";
		}
		
		else if(itemFourAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobScarf.png";
		}

		else if(itemFiveAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobSoccerBall.png";
		}

		else if(itemSixAdded)
		{
			return "/Images/Levels/LevelFive/Questions/BobTie.png";
		}
		
		else{
			return "/Images/Levels/LevelFive/Questions/Bob.png";
		}
		
	}

} // That's all folks... 
