package dpr212;

import javax.swing.JFrame;

/**
	This program generates a pixelated circle and displays it on-screen.
*/
public class main {
	public static void main(String[] args) {
		
		int xCoordCent = 100;
		int yCoordCent = 100;
		int radius = 50;
		
	    JFrame frame = new PixelCircleFrame(xCoordCent, yCoordCent, radius);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	 }
}
