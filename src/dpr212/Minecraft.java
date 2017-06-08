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
	public static void cirAbsCoordXZ(int xCent, int yCent, int zCent, int radius, String blockType) {
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
	public static void cirAbsCoordYZ(int xCent, int yCent, int zCent, int radius, String blockType) {
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
	public static void cirAbsCoordXY(int xCent, int yCent, int zCent, int radius, String blockType) {
		ArrayList<Point> coords = GenerateCircle.generate(xCent, yCent, radius);
		
		//Print the commands to the screen
		for (int i = 0; i < coords.size(); i++) {
			System.out.println("setblock " + coords.get(i).x + " " + coords.get(i).y + " " + zCent + " minecraft:" + blockType);
		}
		
	}
}
