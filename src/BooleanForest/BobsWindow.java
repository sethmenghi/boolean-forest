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
	private static final int BOBS_WINDOW_WIDTH = 567;
	private static final int BOBS_WINDOW_HEIGHT = 310;
	private static final String LEVEL_1 = "Go to Level 1";
	private static final String LEVEL_2 = "Go to Level 2";
	private static final String LEVEL_3 = "Go to Level 3";
	private static final String LEVEL_4 = "Go to Level 4";
	private static final String LEVEL_5 = "Go to Level 5";
	private static final String PLAY_LEVEL = "Play Level";
	
	// Private members of BobsWindow class:
	private String instructions = "";
	private String buttonMessage = "";
	private GameButton gameButton;
	private Game game = new Game();
	
	public BobsWindow(Game game, String instructions, String buttonMessage) {
		this.game = game;
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
													// Pause the game
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
