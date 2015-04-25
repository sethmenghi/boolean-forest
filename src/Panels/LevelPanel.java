package Panels;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import BooleanForest.Game;
import Objects.BobsWindow;

@SuppressWarnings("serial")
public class LevelPanel extends JPanel implements Panel, MouseListener {
	private Game theGame;
	private int level;
	private BobsWindow levelBobsWindow;
	private String currentShownText;
	
	public LevelPanel(Game game, int levelToPlay) {
		initPanel(game, levelToPlay);
	}

	@Override
	public void initPanel(Game game) {
		// TODO Auto-generated method stub
	}
	
	public void initPanel(Game game, int levelToPlay) {
		this.theGame = game;
		this.level = levelToPlay;
		
		// Set the dimensions and layout of the JPanel.
		setPreferredSize(new Dimension(Game.APPLET_WIDTH, Game.APPLET_HEIGHT));
		setDoubleBuffered(true);
		setLayout(null);

		// Initialize a BobsWindow with introduction text and instructions.
		levelBobsWindow = new BobsWindow("LEVEL", currentShownText);
		add(levelBobsWindow);
	}

	@Override
	public void paintComponent(Graphics g) {
		
	}
	
	@Override
	public void paintBobsWindow(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void addText() {
		// TODO Auto-generated method stub
	}

	@Override
	public void addTitleText() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void addParagraphText() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void addButtons() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
