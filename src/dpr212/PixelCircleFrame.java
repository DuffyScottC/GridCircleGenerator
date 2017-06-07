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
	
//	private CircleComponent circle;
	private PixelCircleComponent pixelCircle;
	
	public PixelCircleFrame (int x, int y) {
		
		createPixelCircle();
		add(pixelCircle);
		
//		createCircle();
//		add(circle);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private void createPixelCircle() {
		pixelCircle = new PixelCircleComponent(100, 100, 11);
	}
	
//	private void createCircle() {
//		circle = new CircleComponent((FRAME_WIDTH/2)-35, (FRAME_HEIGHT/2)-35, 70, 70);
//	}
	
}
