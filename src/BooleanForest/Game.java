package BooleanForest;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class Game extends JApplet {
// 640 x 480 JFrame
    
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
		ForestPanel myForest = new ForestPanel(this);
		add(myForest);
	}
    
    // testing
}
