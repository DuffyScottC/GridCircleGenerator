package dpr212;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
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
	
	private int x; //The x-coordinate of the center of the circle
	private int y; //The y-coordinate of the center of the circle
	private int radius; //The radius of the circle
	private PixelCircleComponent pixelCircle; //The JComponent object that draws the circle

	
	/**
	 * 
	 * @param newX - The x-coordinate of the center of the circle
	 * @param newY - The y-coordinate of the center of the circle
	 * @param newR - The radius of the circle
	 */
	public PixelCircleFrame (int newX, int newY, int newR) {
		x = newX;
		y = newY;
		radius = newR;
		
		createPixelCircle();
		
		add(pixelCircle);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	
	
	private void createPixelCircle() {
		pixelCircle = new PixelCircleComponent(x, y, radius);
	}
	
}
