package BooleanForest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BobsWindow extends JPanel implements ActionListener {
	// Private members of BobsWindow class:
	private String instructions;
	private GameButton gameButton;
	
	public BobsWindow() {
		
	}
	
	public BobsWindow(String instructions) {
		this.instructions = instructions;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	@Override
	public void paintComponent(Graphics panel) {
		super.paintComponent(panel);			// Override super method

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
