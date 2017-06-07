package dpr212;

import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
	A frame that displays the generated circle
*/
public class PixelCircleFrame extends JFrame {
	private static final int FRAME_WIDTH = 550;
	private static final int FRAME_HEIGHT = 550;
	
	private JPanel panel;
	private JLabel testLabel;
	private CircleComponent circle;
	
	public PixelCircleFrame (int x, int y) {
		
		createCircle();
		createTestLabel(x, y);
		
		createPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createCircle() {
		circle = new CircleComponent(0, 0, 50, 50);
	}
	
	private void createTestLabel(int x, int y) {
		testLabel = new JLabel("Circle with center (" + x + "," + y + ")");
	}
	
	private void createPanel()
	   {
	      panel = new JPanel();
	      panel.add(testLabel);
	      panel.add(circle);
	      add(panel);
	   } 
	
}
