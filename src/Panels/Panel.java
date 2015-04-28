package Panels;

import java.awt.Graphics;

import BooleanForest.Game;

public interface Panel {
	
	// Initializes panel (called from constructor)
	public void initPanel(Game game);
	
	// Adds text to panel
	public void addText();
	
	// Adds large text to panel
	public void addTitleText();
	
	// Adds a paragraph of text to panel
	public void addParagraphText();
	
	// Adds appropriate buttons to panel
	public void addButtons();
}
