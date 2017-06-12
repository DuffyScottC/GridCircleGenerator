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
		
		GenerateSphere s = new GenerateSphere(1007, 66, 790, 1, "stained_glass 3");
		
		//testMineHollow(1007, 66, 790, 7, "wool 5");
		//testMineHollowCorners(1007, 66, 790, 7, "wool 6");
//		ArrayList<Point3D> testWedge = GenerateSphere.generateHollowSphere(980, 65, 779, 5);
//		for (int i = 0; i < testWedge.size(); i++) {
//			System.out.println("setblock " + testWedge.get(i).x + " " + testWedge.get(i).y + " " + testWedge.get(i).z + " minecraft:wool 3");
//		}
		
//	    JFrame frame = new PixelCircleFrame(xCoordCent, yCoordCent, radius);
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	    frame.setVisible(true);
	    
	    
	    
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
	}
	
	private static void testMineHollowCorners(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Integer> ocInfo = GenerateCircle.getOctantInfo(radius);
		boolean firstLayer = true;
		int nextUp = ocInfo.get(1)+1;
		//xz-plane
		for (int j = 1; j < ocInfo.size(); j++) {
			for (int i = 0; i < ocInfo.get(j); i++) {
				System.out.println("Layers " + j);
				if (firstLayer) {
					firstLayer = false;
					Minecraft.holCirCornerAbsCoordXZ(xCent, yCent+i+nextUp, zCent, radius+1-j, blockType);
					Minecraft.holCirCornerAbsCoordXZ(xCent, yCent-i-nextUp, zCent, radius+1-j, blockType);
				} else {
					Minecraft.holCirCornerAbsCoordXZ(xCent, yCent+i+nextUp, zCent, radius-j, blockType);
					Minecraft.holCirCornerAbsCoordXZ(xCent, yCent-i-nextUp, zCent, radius-j, blockType);
				}
			}
			nextUp += ocInfo.get(j);
		}
	}
	
	private static void testMineHollow(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Integer> ocInfo = GenerateCircle.getOctantInfo(radius);
		int base = ocInfo.get(0) - 1;
		//xz-plane
		for (int i = yCent-base; i <= yCent+base; i++) {
			Minecraft.holCirAbsCoordXZ(xCent, i, zCent, radius, blockType);
		}
				
	    //yz-plane
	    for (int i = xCent-base; i <= xCent+base; i++) {
	    	Minecraft.holCirAbsCoordYZ(i, yCent, zCent, radius, blockType);
	    }
	    
	    //xy-plane
	    for (int i = zCent-base; i <= zCent+base; i++) {
	    	Minecraft.holCirAbsCoordXY(xCent, yCent, i, radius, blockType);
	    }
	    
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
