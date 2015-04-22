/**
 * BOBS WINDOW CLASS
 * 
* DESCRIPTION:
* The BobsWindow class creates an object with a text window background
* and sets the text that will be drawn.
* 
* SOURCES:
* 
*/

package BooleanForest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BobsWindow extends JPanel implements ActionListener {
	// Private static final members of BobsWindow class:
	private static final int INTRO_WIDTH = 404;				// width of IntroPanel BobsWindow
	private static final int INTRO_HEIGHT = 199;			// height of IntroPanel BobsWindow
	private static final int FOREST_WIDTH = 350;			// width of ForestPanel BobsWindow
	private static final int FOREST_HEIGHT = 177;			// height of ForestPanel BobsWindow
	private static final int INTRO_XCOORD = 53;				// pre-determined xCoord of IntroPanel BobsWindow
	private static final int INTRO_YCOORD = 67;				// pre-determined yCoord of IntroPanel BobsWindow
	private static final int FOREST_XCOORD = 70;			// pre-determined xCoord of ForestPanel BobsWindow
	private static final int FOREST_YCOORD = 107;			// pre-determined yCoord of ForestPanel BobsWindow
	private static final String LEVEL_1 = "Go to Level 1";	// text for Level 1 GameButton
	private static final String LEVEL_2 = "Go to Level 2";	// text for Level 2 GameButton
	private static final String LEVEL_3 = "Go to Level 3";	// text for Level 3 GameButton
	private static final String LEVEL_4 = "Go to Level 4";	// text for Level 4 GameButton
	private static final String LEVEL_5 = "Go to Level 5";	// text for Level 5 GameButton
	private static final String PLAY_LEVEL = "Play Level";	// text for Play GameButton (used in IntroPanel)
	
	// Declare members of BobsWindow class:
	private String instructions;
	private String buttonMessage;
	private GameButton gameButton;
	private Game theGame;
	
	public BobsWindow(Game game, String instructions, String buttonMessage) {
		this.theGame = game;
		this.instructions = instructions;
		this.buttonMessage = buttonMessage;
		gameButton = new GameButton(buttonMessage, "white");
		
		initBobsWindow();
	}
	
	public void initBobsWindow() {
		setPreferredSize(new Dimension(BOBS_WINDOW_WIDTH, BOBS_WINDOW_HEIGHT));				// Set size of SidePanel
		setLayout(new BorderLayout());
		
		gameButton.addActionListener(this);
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public void setButtonMessage(String buttonMessage) {
		this.buttonMessage = buttonMessage;
	}
	
	public String getInstructions() {
		return instructions;
	}
	
	public String getButtonMessage() {
		return buttonMessage;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == gameButton) {
			String buttonMessage = gameButton.getText();
			if (buttonMessage == LEVEL_1) {	

			}
			else if (buttonMessage == LEVEL_2) {
				
			}
			else if (buttonMessage == LEVEL_3) {
				
			}
			else if (buttonMessage == LEVEL_4) {
				
			}
			else if (buttonMessage == LEVEL_5) {
				
			}
			else if (buttonMessage == PLAY_LEVEL) {
				
			}
			else {
				// throw error
			}
		}
		else {
			// throw exception
		}
		
	}

}
