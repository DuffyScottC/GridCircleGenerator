package dpr212;

import javax.swing.JFrame;

/**
	This program generates a pixelated circle and displays it on-screen.
*/
public class main {
	public static void main(String[] args) {
		
//		System.out.println(GenerateCircle.generate(0, 0, 11));
		
	    JFrame frame = new PixelCircleFrame(225, 225, 50); //(x-coord of center, y-coord of center, radius) of a circle
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    
	    frame.setVisible(true);
	 }
}
