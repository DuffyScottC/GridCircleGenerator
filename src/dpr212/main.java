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
		
//	    JFrame frame = new PixelCircleFrame(xCoordCent, yCoordCent, radius);
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    frame.setVisible(true);
	    
		testMineHollow(959, 64, 732, 7, "wool 3");
//		testMineFilled();
//		testMinePlane(962,67,735, 3, "wool 3");
		
		//xz plane
//		Minecraft.holCirAbsCoordXZ(959, 69, 732, 5, "wool 4");
//		Minecraft.holCirAbsCoordXZ(959, 70, 732, 4, "wool 4");
		//xy plane
//		Minecraft.holCirAbsCoordXY(959, 64, 737, 5, "wool 4");
//		Minecraft.holCirAbsCoordXY(959, 64, 738, 4, "wool 4");
		//yz plane 954 64 732
//		Minecraft.holCirAbsCoordYZ(964, 64, 732, 5, "wool 4");
//		Minecraft.holCirAbsCoordYZ(954, 64, 732, 5, "wool 4");
//		Minecraft.holCirAbsCoordYZ(965, 64, 732, 4, "wool 4");
//		Minecraft.holCirAbsCoordYZ(953, 64, 732, 4, "wool 4");
	    
	    
	 }
	
	private static void testMinePlane(int xOrig, int yOrig, int zOrig, int baseSize, String blockType) {
		for (int x = 0; x <= baseSize; x++) {
			for (int y = 0; y <= baseSize; y++) {
				for (int z = 0; z <= baseSize; z++) {
					if ((x+y+z) == baseSize) {
						System.out.println("setblock " + (xOrig+baseSize+x) + " " + (yOrig+baseSize+y) + " " + (zOrig+baseSize+z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig+baseSize+x) + " " + (yOrig+baseSize+y) + " " + (zOrig-baseSize-z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig+baseSize+x) + " " + (yOrig-baseSize-y) + " " + (zOrig+baseSize+z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig+baseSize+x) + " " + (yOrig-baseSize-y) + " " + (zOrig-baseSize-z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig-baseSize-x) + " " + (yOrig+baseSize+y) + " " + (zOrig+baseSize+z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig-baseSize-x) + " " + (yOrig+baseSize+y) + " " + (zOrig-baseSize-z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig-baseSize-x) + " " + (yOrig-baseSize-y) + " " + (zOrig+baseSize+z) + " minecraft:" + blockType);
						System.out.println("setblock " + (xOrig-baseSize-x) + " " + (yOrig-baseSize-y) + " " + (zOrig-baseSize-z) + " minecraft:" + blockType);
					}
				}
			}
		}
//	    testMinePlane(xCent+baseSize, yCent+baseSize, zCent+baseSize, baseSize, blockType); //1
//	    testMinePlane(xCent+baseSize, yCent+baseSize, zCent-baseSize, baseSize, blockType); //2
//	    testMinePlane(xCent+baseSize, yCent-baseSize, zCent+baseSize, baseSize, blockType); //3
//	    testMinePlane(xCent+baseSize, yCent-baseSize, zCent-baseSize, baseSize, blockType); //4
//	    testMinePlane(xCent-baseSize, yCent+baseSize, zCent+baseSize, baseSize, blockType); //5
//	    testMinePlane(xCent-baseSize, yCent+baseSize, zCent-baseSize, baseSize, blockType); //6
//	    testMinePlane(xCent-baseSize, yCent-baseSize, zCent+baseSize, baseSize, blockType); //7
//	    testMinePlane(xCent-baseSize, yCent-baseSize, zCent-baseSize, baseSize, blockType); //8
	}
	
	private static void testMineHollow(int xCent, int yCent, int zCent, int radius, String blockType) {
		int baseSize = GenerateCircle.getBaseSize(radius);
		//xz-plane
//	    for (int i = 62; i <= 66; i++) {
		for (int i = yCent-baseSize; i <= yCent+baseSize; i++) {
	    	Minecraft.holCirAbsCoordXZ(xCent, i, zCent, radius, blockType);
	    }
	    //yz-plane
	    System.out.println("");
	    for (int i = xCent-baseSize; i <= xCent+baseSize; i++) {
//	    for (int i = 996; i <= 1002; i++) {
	    	Minecraft.holCirAbsCoordYZ(i, yCent, zCent, radius, blockType);
	    }
	    //xy-plane
	    System.out.println("");
	    for (int i = zCent-baseSize; i <= zCent+baseSize; i++) {
//	    for (int i = 735; i <= 741; i++) {
	    	Minecraft.holCirAbsCoordXY(xCent, yCent, i, radius, blockType);
	    }
	    
	    //Corner planes
	    System.out.println("\n\n\n");
//	    System.out.println("setblock " + (xCent+baseSize) + " " + (yCent+baseSize) + " " + (zCent+baseSize) + " minecraft:wool 1");
//	    System.out.println("setblock " + (xCent+baseSize) + " " + (yCent+baseSize) + " " + (zCent-baseSize) + " minecraft:wool 2");
//	    System.out.println("setblock " + (xCent+baseSize) + " " + (yCent-baseSize) + " " + (zCent+baseSize) + " minecraft:wool 3");
//	    System.out.println("setblock " + (xCent+baseSize) + " " + (yCent-baseSize) + " " + (zCent-baseSize) + " minecraft:wool 4");
//	    System.out.println("setblock " + (xCent-baseSize) + " " + (yCent+baseSize) + " " + (zCent+baseSize) + " minecraft:wool 5");
//	    System.out.println("setblock " + (xCent-baseSize) + " " + (yCent+baseSize) + " " + (zCent-baseSize) + " minecraft:wool 6");
//	    System.out.println("setblock " + (xCent-baseSize) + " " + (yCent-baseSize) + " " + (zCent+baseSize) + " minecraft:wool 7");
//	    System.out.println("setblock " + (xCent-baseSize) + " " + (yCent-baseSize) + " " + (zCent-baseSize) + " minecraft:wool 8");
	    
	    testMinePlane(xCent, yCent, zCent, baseSize+1, blockType); //1
	}
	
	private static void testMineFilled() {
		//xz-plane
	    for (int i = 62; i <= 66; i++) {
	    	Minecraft.filCirAbsCoordXZ(959, i, 732, 7, "wool 3");
	    }
	    //yz-plane
	    System.out.println("");
	    for (int i = 957; i <= 961; i++) {
	    	Minecraft.filCirAbsCoordYZ(i, 64, 732, 7, "wool 3");
	    }
	    //xy-plane
	    System.out.println("");
	    for (int i = 730; i <= 734; i++) {
	    	Minecraft.filCirAbsCoordXY(959, 64, i, 7, "wool 3");
	    }
	}
	
	
}
