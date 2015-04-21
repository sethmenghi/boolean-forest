package BooleanForest;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ForestPanel extends JPanel {
	
	private Game theGame;
	
	public ForestPanel(Game game) {
		initForest(game);
	}
	
	private void initForest(Game game) {
		setPreferredSize(new Dimension(640,480));
		setDoubleBuffered(true);
		this.theGame = game;
		JLabel label = new JLabel("Hello!");
		add(label);
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image image = new ImageIcon("Images/LevelMap.jpg").getImage();
		g.drawImage(image, 0, 0, null);
	}
	
}
