package Questions;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BooleanForest.Game;
//import Objects.BobsWindow;
import Objects.GameButton;

// Sources:
// http://stackoverflow.com/questions/29054963/how-to-make-a-jbutton-not-clickable-in-java
// http://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel
// http://bioportal.weizmann.ac.il/course/prog2/tutorial/uiswing/layout/gridbag.html
// http://www.dreamincode.net/forums/topic/277446-dragging-an-image-with-the-mouse/ <-- Used a lot from this 
// http://stackoverflow.com/questions/7867834/get-button-name-from-actionlistener
// http://copypastejavacode.blogspot.com/2012/01/code-of-java-that-set-opacity-of-image.html

public class DragAndDropQuestion extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	
	private String questionText;
	private ArrayList<String> possibleAnswersList; 
	private String originalOwlImage; 
	private String correctOwlImage; 
	private int correctIndexOne; 
	private int correctIndexTwo;
	private String correctImageOne;
	private String correctImageTwo;
	private int itemSelected=0;
	boolean firstTime=true;
	
	Image itemOne;
	Image itemTwo;
	Image itemThree;
	Image itemFour;
	Image itemFive;
	Image itemSix;
	
	JLabel itemOneLabel;
	JLabel itemTwoLabel;
	JLabel itemThreeLabel;
	JLabel itemFourLabel;
	JLabel itemFiveLabel;
	JLabel itemSixLabel;

	GameButton nextLevelButton; 

	JButton itemOneButton;
	JButton itemTwoButton;
	JButton itemThreeButton;
	JButton itemFourButton;
	JButton itemFiveButton;
	JButton itemSixButton;


	private static final String IMAGE_OPTION_ONE="Images/DragDrop/BasketBallImage.png";
	private static final String IMAGE_OPTION_TWO="Images/DragDrop/GlassesImage.png";
	private static final String IMAGE_OPTION_THREE="Images/DragDrop/HatImage.png";
	private static final String IMAGE_OPTION_FOUR="Images/DragDrop/ScarfImage.png";
	private static final String IMAGE_OPTION_FIVE="Images/DragDrop/SoccerBallImage.png";
	private static final String IMAGE_OPTION_SIX="Images/DragDrop/TieImage.png";

	private static final int ITEM_ONE_X_COORD=Game.APPLET_WIDTH/2-100-15;
	private static final int ITEM_ONE_Y_COORD=350;
	
	private static final int ITEM_TWO_X_COORD=Game.APPLET_WIDTH/2-60-15;
	private static final int ITEM_TWO_Y_COORD=350;
	
	private static final int ITEM_THREE_X_COORD=Game.APPLET_WIDTH/2-20-15;
	private static final int ITEM_THREE_Y_COORD=350;
	
	private static final int ITEM_FOUR_X_COORD=Game.APPLET_WIDTH/2+20-15;
	private static final int ITEM_FOUR_Y_COORD=350;
	
	private static final int ITEM_FIVE_X_COORD=Game.APPLET_WIDTH/2+60-15;
	private static final int ITEM_FIVE_Y_COORD=350;

	private static final int ITEM_SIX_X_COORD=Game.APPLET_WIDTH/2+100-15;
	private static final int ITEM_SIX_Y_COORD=350;
	
	boolean itemOneAdded = false; 
	boolean itemTwoAdded = false; 
	boolean itemThreeAdded = false; 
	boolean itemFourAdded = false; 
	boolean itemFiveAdded = false; 
	boolean itemSixAdded = false; 

	boolean isItemOneCorrectAnswer; 
	boolean isItemTwoCorrectAnswer; 
	boolean isItemThreeCorrectAnswer; 
	boolean isItemFourCorrectAnswer; 
	boolean isItemFiveCorrectAnswer; 
	boolean isItemSixCorrectAnswer; 

	boolean haveCorrectAnswerOne=false;
	boolean haveCorrectAnswerTwo=false; 
	
	boolean haveSolvedQuestion=false; 

	MediaTracker mediaTracker; 
	
	boolean isMouseDrag=false;
	
	int posX, posY , width, height, mX, mY;
	
	int numberOfAnswersCorrect;
	
//	BobsWindow dragAndDropBobsWindow; 
	
	String instructionText = "Click items to select them. Then drag them over Bob!";
	
	Game theGame;
	
	boolean firstSetUp; 
	
	
	public DragAndDropQuestion(Game game) 
	{
		theGame = game; 
		firstSetUp=true;
	}
	
	public void initGUI(){
		
		
		if(firstSetUp==true)
		{
			setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
			setDoubleBuffered(true);
			setLayout(null);	    
		    initDragDrop();
		    
			ImageIcon optionIcon = new ImageIcon(possibleAnswersList.get(0));
			itemOneLabel = new JLabel();
			itemOneLabel.setIcon(optionIcon);
			itemOneLabel.addMouseListener(this);
			itemOneLabel.setBounds(ITEM_ONE_X_COORD,ITEM_ONE_Y_COORD,30,30);
			itemOneLabel.addMouseListener(this);
		    add(itemOneLabel);
		    	    
			optionIcon = new ImageIcon(possibleAnswersList.get(1));
			itemTwoLabel = new JLabel();
			itemTwoLabel.setIcon(optionIcon);
			itemTwoLabel.addMouseListener(this);
			itemTwoLabel.setBounds(ITEM_TWO_X_COORD,ITEM_TWO_Y_COORD,30,30);
			itemTwoLabel.addMouseListener(this);
		    add(itemTwoLabel);
		    
			optionIcon = new ImageIcon(possibleAnswersList.get(2));
			itemThreeLabel = new JLabel();
			itemThreeLabel.setIcon(optionIcon);
			itemThreeLabel.addMouseListener(this);
			itemThreeLabel.setBounds(ITEM_THREE_X_COORD,ITEM_THREE_Y_COORD,30,30);
			itemThreeLabel.addMouseListener(this);
		    add(itemThreeLabel);

			optionIcon = new ImageIcon(possibleAnswersList.get(3));
			itemFourLabel = new JLabel();
			itemFourLabel.setIcon(optionIcon);
			itemFourLabel.addMouseListener(this);
			itemFourLabel.setBounds(ITEM_FOUR_X_COORD,ITEM_FOUR_Y_COORD,30,30);
			itemFourLabel.addMouseListener(this);
		    add(itemFourLabel);
		    
			optionIcon = new ImageIcon(possibleAnswersList.get(4));
			itemFiveLabel = new JLabel();
			itemFiveLabel.setIcon(optionIcon);
			itemFiveLabel.addMouseListener(this);
			itemFiveLabel.setBounds(ITEM_FIVE_X_COORD,ITEM_FIVE_Y_COORD,30,30);
			itemFiveLabel.addMouseListener(this);
		    add(itemFiveLabel);

			optionIcon = new ImageIcon(possibleAnswersList.get(5));
			itemSixLabel = new JLabel();
			itemSixLabel.setIcon(optionIcon);
			itemSixLabel.addMouseListener(this);
			itemSixLabel.setBounds(ITEM_SIX_X_COORD,ITEM_SIX_Y_COORD,30,30);
			itemSixLabel.addMouseListener(this);
		    add(itemSixLabel);
		    
		    nextLevelButton= new GameButton("Next >>","WHITE");
		    nextLevelButton.setBounds(Game.APPLET_WIDTH-140, Game.APPLET_HEIGHT/2,80,80);
		    nextLevelButton.setVisible(false);
		    add(nextLevelButton);
		    nextLevelButton.addActionListener(this);
		    
		    firstSetUp=false;
		}
			
		else{
			reset();
		}

	    
	    repaint(); 

	}
	
	public void reset(){
		
		
		instructionText="Click items to select them. Then drag them over Bob!";
		
		 itemOneAdded = false; 
		 itemTwoAdded = false; 
		 itemThreeAdded = false; 
		 itemFourAdded = false; 
		 itemFiveAdded = false; 
		 itemSixAdded = false; 
		 haveCorrectAnswerOne=false;
		 haveCorrectAnswerTwo=false; 
		 haveSolvedQuestion=false; 
		 isMouseDrag=false;
		 numberOfAnswersCorrect=0;
		 		 
		itemOneLabel.setOpaque(false);
		itemTwoLabel.setOpaque(false);
		itemThreeLabel.setOpaque(false);
		itemFourLabel.setOpaque(false);
		itemFiveLabel.setOpaque(false);
		itemSixLabel.setOpaque(false);

		 
	}
	
	public void initDragDrop(){
		
	    addMouseListener(this);
	   	addMouseMotionListener(this);
	   	
	   	itemOne = new ImageIcon(IMAGE_OPTION_ONE).getImage();
	   	itemTwo = new ImageIcon(IMAGE_OPTION_TWO).getImage();
	   	itemThree = new ImageIcon(IMAGE_OPTION_THREE).getImage();
	   	itemFour = new ImageIcon(IMAGE_OPTION_FOUR).getImage();
	   	itemFive = new ImageIcon(IMAGE_OPTION_FIVE).getImage();
	   	itemSix = new ImageIcon(IMAGE_OPTION_SIX).getImage();
	   	 
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);						
		
		Image background = new ImageIcon("Images/Backgrounds/BackgroundForDragDropQuestion.png").getImage();
		g.drawImage(background, 0, 0, null);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setFont(Game.TITLE_FONT);					
		g2.setColor(Game.DARK_BLUE);			
		g2.drawString(questionText,Game.APPLET_WIDTH/2-measureStringWidth(g,questionText)/2,90);
		
		Graphics2D g3 = (Graphics2D) g;
		g3.setFont(Game.PARAGRAPH_FONT);					
		g3.setColor(Game.DARK_BLUE);			
		g3.drawString(instructionText, Game.APPLET_WIDTH/2-measureStringWidth(g,instructionText)/2, Game.APPLET_HEIGHT-70);

		
		if(isOverOwl() && isMouseDrag==false){
			
			
			checkIfCorrectAnswer(); 
			itemSelected=0;

			itemOneLabel.setVisible(true);
			itemTwoLabel.setVisible(true);
			itemThreeLabel.setVisible(true);
			itemFourLabel.setVisible(true);
			itemFiveLabel.setVisible(true);
			itemSixLabel.setVisible(true);
			
			Image originalOwl = new ImageIcon(getBobImage()).getImage();
			ImageObserver observer = null;
			g.drawImage(originalOwl,Game.APPLET_WIDTH/2-originalOwl.getWidth(observer)/2,70, null);
			

		}
		
		else if(isOverOwl())
		{
			Image originalOwl = new ImageIcon(getBobImage()).getImage();
			ImageObserver observer = null;

		    Graphics2D g2d = (Graphics2D) g;
		    float alpha = 0.5f;
		    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		    g2d.drawImage(originalOwl,Game.APPLET_WIDTH/2-originalOwl.getWidth(observer)/2,70,null);
		}
		

		else{
			Image originalOwl = new ImageIcon(getBobImage()).getImage();
			ImageObserver observer = null;
			g.drawImage(originalOwl,Game.APPLET_WIDTH/2-originalOwl.getWidth(observer)/2,70,null);
		}

		if(itemSelected>0)
		{
			g.drawImage(getSelectedImage(), posX, posY, null);		
		}
		
		
		//g.drawRoundRect(240, 130, 160, 170, 0, 0);
		//g.drawRoundRect(280, 170, 80, 40, 0, 0);

		
   	}
	
	public Image getSelectedImage()
	{
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

	public void resetPositionMarkers()
	{
		posX=0;
		posY=0;
	}
	
	public boolean isOverOwl()
	{
		if(posX>240 && posX<400 && posY>130 && posY<310)
		{
			return true;
		}
		
		else{
			return false; 
		}
	}
	
	public boolean isOverDropArea()
	{
		if(posX>280 && posX<360 && posY>170 && posY<200)
		{
			return true;
		}
		
		else{
			return false; 
		}
	}
	
	public void checkIfCorrectAnswer(){
		
		
		if(checkIfCorrectAnswerTwo())
		{
			numberOfAnswersCorrect++; 
			instructionText="Correct answer!";
			haveSolvedQuestion=true;
			getSelectedLabel().setForeground(Color.GREEN);
			getSelectedLabel().setBackground(Color.GREEN);
			getSelectedLabel().setOpaque(true);

		}
		
		else{
			
			instructionText="Incorrect answer. Try again!";
			getSelectedLabel().setForeground(Color.RED);
			getSelectedLabel().setBackground(Color.RED);
			getSelectedLabel().setOpaque(true);
			
		}
		
		if(numberOfAnswersCorrect==2){
			
			haveSolvedQuestion=true;
		    nextLevelButton.setVisible(true);

		}
		
		resetPositionMarkers();
		repaint();

		
//		if(correctIndexOne==itemSelected)
//		{
//			
//			if(haveCorrectAnswerTwo)
//			{
//				instructionText="Correct answer!";
//				haveSolvedQuestion=true;
//			    nextLevelButton.setVisible(true);
//			}
//			
//			else{
//				instructionText="Correct answer! What's the other item?";
//			}
//			
//			getSelectedLabel().setForeground(Color.GREEN);
//			getSelectedLabel().setBackground(Color.GREEN);
//			getSelectedLabel().setOpaque(true);
//			haveCorrectAnswerOne=true;
//		}
//		
//		else if(correctIndexTwo==itemSelected)
//		{
//
//			if(haveCorrectAnswerOne)
//			{
//				instructionText="Correct answer!";
//				haveSolvedQuestion=true;
//			    nextLevelButton.setVisible(true);
//			}
//			
//			else{
//				instructionText="Correct answer! What's the other item?";
//			}
//
//			
//			getSelectedLabel().setForeground(Color.GREEN);
//			getSelectedLabel().setBackground(Color.GREEN);
//			getSelectedLabel().setOpaque(true);
//			haveCorrectAnswerTwo=true;
//		}
//		
//		else if (itemSelected!=0){
//			
//			instructionText="Incorrect answer. Try again!";
//			getSelectedLabel().setForeground(Color.RED);
//			getSelectedLabel().setBackground(Color.RED);
//			getSelectedLabel().setOpaque(true);
//
//		}
//		
//		resetPositionMarkers();
//		repaint();

	}
	
	
	public boolean checkIfCorrectAnswerTwo()
	{
		switch(itemSelected){
		
			case 1:
				if(isItemOneCorrectAnswer){
					itemOneAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 2:
				if(isItemTwoCorrectAnswer){
					itemTwoAdded=true;
					return true;
				}
				
				else{
					return false; 
				}

			case 3:
				if(isItemThreeCorrectAnswer){
					itemThreeAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 4:
				if(isItemFourCorrectAnswer){
					itemFourAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 5:
				if(isItemFiveCorrectAnswer){
					itemFiveAdded=true;
					return true;
				}
				
				else{
					return false; 
				}
				
			case 6:
				if(isItemSixCorrectAnswer){
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
	
	public int measureStringWidth(Graphics g, String inputString) {

		Font font = g.getFont();
        FontRenderContext context = ((Graphics2D) g).getFontRenderContext();
        int stringWidth = (int)(font.getStringBounds(inputString, context).getWidth());
        return stringWidth;
      
	}
	

	
	public void setQuestionText(String questionTextInput)
	{
		questionText = questionTextInput;
	}
	
	public void setListOfPossibleAnswers(ArrayList<String> possibleAnswersInput){
		
		possibleAnswersList=possibleAnswersInput;
		
	}
	
	public void setOriginalOwlImage(String originalOwlImageInput){
		
		originalOwlImage=originalOwlImageInput;
		
	}
	
	public void setCorrectOwlImage(String correctOwlImageInput){
		
		correctOwlImage = correctOwlImageInput;
		
	}
	
	public void setCorrectAnswerIndexes(int correctIndexOneInput, int correctIndexTwoInput){
		
		correctIndexOne=correctIndexOneInput;
		correctIndexTwo=correctIndexTwoInput;
		
	}
	
	public void setCorrectAnswerImages(String answerOneInput, String answerTwoInput){
		
		correctImageOne=answerOneInput;
		correctImageTwo=answerTwoInput;
		
	}
	
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
	
	public String getOwlImage(){
		
		if(haveCorrectAnswerOne && haveCorrectAnswerTwo){
			return correctOwlImage;
		}
		
		else if(haveCorrectAnswerOne)
		{
			return correctImageOne;
		}
		
		else if(haveCorrectAnswerTwo)
		{
			return correctImageTwo;
		}
		
		else{
			return originalOwlImage;
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
				
		
		System.out.println(isMouseDrag);

		if (isMouseDrag)
		{

			int currentMX = e.getX();
			int currentMY = e.getY();
			
			posX += e.getX() - mX;
			posY += e.getY() - mY; 
			
			mX = currentMX;
			mY = currentMY;

			repaint();
			e.consume();	
		}		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
				
		mX = e.getX();
		mY = e.getY();	
		isMouseDrag = true;
		e.consume();
		
		System.out.println(isMouseDrag);

		
		if(e.getSource()==itemOneLabel)
		{
			instructionText="Basketball Selected";
			itemOneLabel.setVisible(false);
			itemSelected=1; 
		}
		
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
	

		setPositionOfDraggableIcon();
		repaint();

		
		
	}
	
	public void setPositionOfDraggableIcon()
	{
		switch(itemSelected){
		case 1:
			posX=ITEM_ONE_X_COORD; 
			posY=ITEM_ONE_Y_COORD;
			break;
		case 2:
			posX=ITEM_TWO_X_COORD; 
			posY=ITEM_TWO_Y_COORD;
			break;
		case 3:
			posX=ITEM_THREE_X_COORD; 
			posY=ITEM_THREE_Y_COORD;
			break;
		case 4:
			posX=ITEM_FOUR_X_COORD; 
			posY=ITEM_FOUR_Y_COORD;
			break;
		case 5:
			posX=ITEM_FIVE_X_COORD; 
			posY=ITEM_FIVE_Y_COORD;
			break;
		case 6:
			posX=ITEM_SIX_X_COORD; 
			posY=ITEM_SIX_Y_COORD;
			break;
		default:
			System.out.println("CALLED DEFAULT");
			posX=100; 
			posY=100;
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		isMouseDrag = false;
		System.out.println(isMouseDrag);
		e.consume();		
		repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(isMouseDrag);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isMouseDrag = false;
		System.out.println(isMouseDrag);
		repaint();

		
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if(event.getSource()==nextLevelButton){
			
			System.out.println("Go to next question");
			theGame.levelFive.nextQuestion();
			
		}
		
	}
	
	public String getBobImage(){
		
		// 1:  Basketball 
		// 2:  Glasses 
		// 3:  Hat 
		// 4:  Scarf 
		// 5:  Soccer Ball  
		// 6:  Tie //
	
		if(itemOneAdded && itemFourAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobBasketballScarf.png";
		}
		
		else if (itemOneAdded && itemSixAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobBasketballTie.png";
		}
		
		else if (itemOneAdded && itemTwoAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobGlassesBasketball.png";
		}
		
		else if (itemTwoAdded && itemFiveAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobGlassesSoccerBall.png";
		}
		
		else if(itemTwoAdded && itemSixAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobGlassesTie.png";
		}
		
		else if(itemThreeAdded && itemOneAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHatBasketball.png";
		}
		
		else if(itemThreeAdded && itemTwoAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHatGlasses.png";
		}

		else if(itemThreeAdded && itemFourAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHatScarf.png";
		}
		
		else if(itemThreeAdded && itemFiveAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHatSoccerBall.png";
		}
		
		else if(itemThreeAdded && itemSixAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHatTie.png";
		}
		
		else if(itemFourAdded && itemFiveAdded){
			return "Images/Levels/LevelFive/Questions/BobSoccerballScarf.png";
		}
		
		else if(itemFourAdded && itemTwoAdded){
			return "Images/Levels/LevelFive/Questions/BobGlassesScarf.png";
		}
		
		else if(itemFiveAdded && itemSixAdded){
			return "Images/Levels/LevelFive/Questions/BobSoccerballTie.png";
		}
		
		else if(itemOneAdded && itemSixAdded){
			return "Images/Levels/LevelFive/Questions/BobTieBasketball.png";
		}

		else if(itemTwoAdded && itemSixAdded){
			return "Images/Levels/LevelFive/Questions/BobTieGlasses.png";
		}
			
		else if(itemFiveAdded && itemSixAdded){
			return "Images/Levels/LevelFive/Questions/BobTieSoccerBall.png";
		}
		
		else if(itemOneAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobBasketball.png";
		}
		
		else if(itemTwoAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobGlasses.png";
		}
		
		else if(itemThreeAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobHat.png";
		}
		
		else if(itemFourAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobScarf.png";
		}

		else if(itemFiveAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobSoccerBall.png";
		}

		else if(itemSixAdded)
		{
			return "Images/Levels/LevelFive/Questions/BobTie.png";
		}
		
		else{
			return "Images/Levels/LevelFive/Questions/Bob.png";
		}
		
	}

}
