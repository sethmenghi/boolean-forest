package Panels;

import java.awt.Graphics;

import BooleanForest.Game;

public interface Panel {
	
	public void initPanel(Game game);
	
	public void paintBobsWindow(Graphics g);
	
	public void addText();
	
	public void addTitleText();
	
	public void addParagraphText();
	
	public void addButtons();
}
