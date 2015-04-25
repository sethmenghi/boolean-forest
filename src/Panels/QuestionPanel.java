package Panels;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import BooleanForest.Game;

@SuppressWarnings("serial")
public class QuestionPanel extends JPanel implements Panel, MouseListener {
	private Game theGame;
	
	public QuestionPanel(Game game) {
		initPanel(game);
	}

	@Override
	public void initPanel(Game game) {
		this.theGame = game;
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
