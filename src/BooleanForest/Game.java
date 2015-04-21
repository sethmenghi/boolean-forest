package BooleanForest;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Game extends JApplet {

	private String userName = "Student";
	public JPanel cards;
	private Dimension windowSize;
	
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					createGUI();
				}
			});
		}
		catch(Exception e) {
			System.err.println("createGUI did not complete successfully");
		}
	}
	
	public void createGUI() {
		
		windowSize = new Dimension(640,480);
	    setPreferredSize(windowSize);
	    setMinimumSize(windowSize);
	    setMaximumSize(windowSize);
	    setSize(windowSize);
		
		cards = new JPanel(new CardLayout());
		add(cards);
		
		IntroPanel introScreen = new IntroPanel(this);
		cards.add(introScreen, "Intro");
		
		ForestPanel levelMap = new ForestPanel(this);
		cards.add(levelMap, "Forest");
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
    
    // testing
}
