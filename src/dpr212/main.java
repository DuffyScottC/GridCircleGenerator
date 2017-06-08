package dpr212;

import javax.swing.JFrame;

/**
	This program generates a pixelated circle and displays it on-screen.
*/
public class main {
	public static void main(String[] args) {
		
		int xCoordCent = 150;
		int yCoordCent = 150;
		int radius = 11;
		
	    JFrame frame = new PixelCircleFrame(xCoordCent, yCoordCent, radius);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	 }
}
