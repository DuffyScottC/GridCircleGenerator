package dpr212;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Generates the coordinates of a circle on a grid where each grid square is 10x10 pixels. 
 * @author Scott
 *
 */
public class GenerateCircle {
	public static final int SQUARE = 10; //The size of each grid square
	
	/**
	 * This function generates a set of coordinates of the circle's pixels. 
	 * 
	 * @param x0 - x-coordinate of center of circle
	 * @param y0 - y-coordinate of center of circle
	 * @param radius - the radius of the circle
	 * @return a string containing a list of all the coordinates of the first octant
	 */
	public static ArrayList<Point> generateHollowCircle(int x0, int y0, int radius) {
		int x = radius; //The x-coordinate of the pixel being drawn
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		ArrayList<Point> coordinates = new ArrayList(); //This ArrayList will hold all the points of the circle
		
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
				x -= 1; //x decrements only sometimes (when the error is greater than 0)
	            err += 2*(y - x) + 1;
			}
			
			
		}
//		for(int i = 0; i < coordinates.size(); i++) {
//			System.out.println("(" + (coordinates.get(i).getX()-x0) + "," + (coordinates.get(i).getY()-y0) + ")");
//		}
		return coordinates;
	}
	
	public static ArrayList<Point> generateHollowCircleCorners(int x0, int y0, int radius) {
		boolean offBase = false; //We only want to start adding coordinates when the we've moved on from the base of the circle
		int x = radius; //The x-coordinate of the pixel being drawn
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		ArrayList<Point> coordinates = new ArrayList(); //This ArrayList will hold all the points of the circle
		
		while (x >= y) { //When the x=y then we are at a 45º angle from the origin
			if (offBase) {//We only want to start adding coordinates when the we've moved on from the base of the circle
				coordinates.add(new Point(x + x0, -y + y0)); //octant 1
				coordinates.add(new Point(y + x0, -x + y0)); //octant 2
				coordinates.add(new Point(-y + x0, -x + y0)); //octant 3
				coordinates.add(new Point(-x + x0, -y + y0)); //octant 4
				coordinates.add(new Point(-x + x0, y + y0)); //octant 5
				coordinates.add(new Point(-y + x0, x + y0)); //octant 6
				coordinates.add(new Point(y + x0, x + y0)); //octant 7
				coordinates.add(new Point(x + x0, y + y0)); //octant 8
			}
			
			y += 1; //y increments by 1 every time no matter what
			if (err <= 0) {
				err += 2*y + 1;
			} else { //err > 0
				offBase = true;
				x -= 1; //x decrements only sometimes (when the error is greater than 0)
	            err += 2*(y - x) + 1;
			}
			
			
		}
//		for(int i = 0; i < coordinates.size(); i++) {
//			System.out.println("(" + (coordinates.get(i).getX()-x0) + "," + (coordinates.get(i).getY()-y0) + ")");
//		}
		return coordinates;
	}
	
	public static ArrayList<Integer> getOctantInfo(int radius) {
		ArrayList<Integer> sizes = new ArrayList<Integer>(); //Holds the sizes of each incrementation of the circle
		
		int counter = 0; //Keeps track of the sizes of each incrementation of the circle to be added to "sizes"
		int x = radius;
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		int baseSize = 0; //This holds the 1/2 the size of the base section of the sphere/circle - 1. That number is used
		//to calculate how thick of each ring should be, and where the origin for the corner planes should be
		
		while (x >= y) {
			counter++;
			y += 1; //y increments by 1 every time no matter what
			if (err <= 0) {
				err += 2*y + 1;
			} else { //err > 0
				sizes.add(counter);
				counter = 0;
				x -= 1; //x decrements only sometimes (when the error is greater than 0)
	            err += 2*(y - x) + 1;
			}
			
			
		}
		
		return sizes; //y holds the octantSize for this radius
	}
	
	/**
	 * This function returns an OctantInfo object that holds:
	 * 1. The size of the base of the circle in Minecraft. (That number + 1) can be added to x, y, and z 
	 * to get the coordinates of the first corner origin point, from which we will generate a corner plane. Also, that number
	 * can be used to calculate how thick the three rings should be by adding and subtracting the base size
	 * from the origin's x, y and z coordinates.
	 * 2. The height of the octant, since that will be used to iterate the decreasing sections of the "corner" circles
	 * 
	 * 
	 * @param radius - the radius of the circle
	 * @return the base size
	 */
	public static OctantInfo getOctantInfoOld(int radius) {
		int x = radius;
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		int baseSize = 0; //This holds the 1/2 the size of the base section of the sphere/circle - 1. That number is used
		//to calculate how thick of each ring should be, and where the origin for the corner planes should be
		
		while (x >= y) {
			if (x == radius) { //Only add to the base until x goes down by 1
				baseSize++; //Every time there is a new gridpoint, we add to the count
			}
			
			y += 1; //y increments by 1 every time no matter what
			if (err <= 0) {
				err += 2*y + 1;
			} else { //err > 0
				x -= 1; //x decrements only sometimes (when the error is greater than 0)
	            err += 2*(y - x) + 1;
			}
			
			
		}
		
		
		return new OctantInfo(baseSize-1, y); //y holds the octantSize for this radius
	}
	
}
