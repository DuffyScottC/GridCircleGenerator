package dpr212;

import java.awt.Point;
import java.util.ArrayList;
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
	    
	    testMine();
	    
	    
	 }
	
	private static void testMine() {
		//xz-plane
	    for (int i = 62; i <= 66; i++) {
	    	Minecraft.holCirAbsCoordXZ(959, i, 732, 7, "wool 3");
	    }
	    //yz-plane
	    System.out.println("");
	    for (int i = 957; i <= 961; i++) {
	    	Minecraft.holCirAbsCoordYZ(i, 64, 732, 7, "wool 3");
	    }
	    //xy-plane
	    System.out.println("");
	    for (int i = 730; i <= 734; i++) {
	    	Minecraft.holCirAbsCoordXY(959, 64, i, 7, "wool 3");
	    }
	}
	
	
}
