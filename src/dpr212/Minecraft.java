package dpr212;

import java.awt.Point;
import java.util.ArrayList;

public class Minecraft {
	/**
	 * Minecraft circle from absolute coordinates of center along the xz-plane
	 * @param xCent - The x-coord of the center of the circle
	 * @param yCent - The y-coord of the center of the circle
	 * @param zCent - The z-coord of the center of the circle
	 * @param radius - the radius of the circle
	 * @param blockType - The type of block the circle should be made of
	 */
	public static void holCirAbsCoordXZ(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Point> coords = GenerateCircle.generate(xCent, zCent, radius);
		
		//Print the commands to the screen
		for (int i = 0; i < coords.size(); i++) {
			System.out.println("setblock " + coords.get(i).x + " " + yCent + " " + coords.get(i).y + " minecraft:" + blockType);
		}
		
	}
	
	/**
	 * Minecraft circle from absolute coordinates of center along the yz-plane
	 * @param xCent - The x-coord of the center of the circle
	 * @param yCent - The y-coord of the center of the circle
	 * @param zCent - The z-coord of the center of the circle
	 * @param radius - the radius of the circle
	 * @param blockType - The type of block the circle should be made of
	 */
	public static void holCirAbsCoordYZ(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Point> coords = GenerateCircle.generate(zCent, yCent, radius);
		
		//Print the commands to the screen
		for (int i = 0; i < coords.size(); i++) {
			System.out.println("setblock " + xCent + " " + coords.get(i).y + " " + coords.get(i).x + " minecraft:" + blockType);
		}
		
	}
	
	/**
	 * Minecraft circle from absolute coordinates of center along the xy-plane
	 * @param xCent - The x-coord of the center of the circle
	 * @param yCent - The y-coord of the center of the circle
	 * @param zCent - The z-coord of the center of the circle
	 * @param radius - the radius of the circle
	 * @param blockType - The type of block the circle should be made of
	 */
	public static void holCirAbsCoordXY(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Point> coords = GenerateCircle.generate(xCent, yCent, radius);
		
		//Print the commands to the screen
		for (int i = 0; i < coords.size(); i++) {
			System.out.println("setblock " + coords.get(i).x + " " + coords.get(i).y + " " + zCent + " minecraft:" + blockType);
		}
		
	}
	
	/**
	 * This function generates a set of coordinates of the circle's pixels. 
	 * 
	 * @param x0 - x-coordinate of center of circle
	 * @param y0 - y-coordinate of center of circle
	 * @param radius - the radius of the circle
	 * @return a string containing a list of all the coordinates of the first octant
	 */
	public static ArrayList<Point> generateCorner(int x0, int y0, int radius) {
		int x = radius; //The x-coordinate of the pixel being drawn
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		ArrayList<Point> coordinates = new ArrayList(); //This ArrayList will hold all the points of the circle
		boolean first = true; //If this is the first, eliminate the corners
		
		while (x >= y) { //When the x=y then we are at a 45º angle from the origin
			
			coordinates.add(new Point(x + x0, -y + y0)); //octant 1
			coordinates.add(new Point(y + x0, -x + y0)); //octant 2
			coordinates.add(new Point(-y + x0, -x + y0)); //octant 3
			coordinates.add(new Point(-x + x0, -y + y0)); //octant 4
			coordinates.add(new Point(-x + x0, y + y0)); //octant 5
			coordinates.add(new Point(-y + x0, x + y0)); //octant 6
			coordinates.add(new Point(y + x0, x + y0)); //octant 7
			coordinates.add(new Point(x + x0, y + y0)); //octant 8
			
			y += 1; //y increments by 1 every time no matter what
			if (err <= 0) {
				err += 2*y + 1;
			} else { //err > 0
				if (first) {
					first = false;
					int index = coordinates.size();
					for (int i = 1; i <= 8; i++) {
						coordinates.remove(index-i); //Remove the last 8 added
					}
				}
				x -= 1; //x decrements only sometimes (when the error is greater than 0)
	            err += 2*(y - x) + 1;
			}
			
			
		}
//		for(int i = 0; i < coordinates.size(); i++) {
//			System.out.println("(" + (coordinates.get(i).getX()-x0) + "," + (coordinates.get(i).getY()-y0) + ")");
//		}
		return coordinates;
	}
}
