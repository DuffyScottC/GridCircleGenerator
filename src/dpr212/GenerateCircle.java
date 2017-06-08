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
	 * 
	 * @param x0 - x-coordinate of center of circle
	 * @param y0 - y-coordinate of center of circle
	 * @param radius - the radius of the circle
	 * @return a string containing a list of all the coordinates of the first octant
	 */
	public static ArrayList<Point> generate(int x0, int y0, int radius) {
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
				x -= 1;
	            err += 2*(y - x) + 1;
			}
			
			
		}
		for(int i = 0; i < coordinates.size(); i++) {
			System.out.println("(" + (coordinates.get(i).getX()-x0) + "," + (coordinates.get(i).getY()-y0) + ")");
		}
		return coordinates;
	}
	
}
