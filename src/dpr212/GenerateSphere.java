package dpr212;

import java.awt.Point;
import java.util.ArrayList;

public class GenerateSphere {
	public static void generate() {
		int xCent = 0;
		int yCent = 0;
		int zCent = 0;
		int r = 5;
		
		
		
	}
	
	public static ArrayList<Point3D> generateHollowSphere(int x0, int y0, int z0, int radius) {
		
		int z = 0;
		int x = radius; //The x-coordinate of the pixel being drawn
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		
		ArrayList<Point3D> coordinates = new ArrayList(); //This ArrayList will hold all the points of the circle
		
		while (z <= radius) {
			x = radius; //The x-coordinate of the pixel being drawn
			y = 0; //The y-coordinate of the pixel being drawn
			err = 1 - x;
			
			while (x >= y) { //When x=y then we are at a 45º angle from the origin
				
				coordinates.add(new Point3D(x + x0, -y + y0, z + z0)); //octant 1
				coordinates.add(new Point3D(y + x0, -x + y0, z + z0)); //octant 2
				coordinates.add(new Point3D(-y + x0, -x + y0, z + z0)); //octant 3
				coordinates.add(new Point3D(-x + x0, -y + y0, z + z0)); //octant 4
				coordinates.add(new Point3D(-x + x0, y + y0, z + z0)); //octant 5
				coordinates.add(new Point3D(-y + x0, x + y0, z + z0)); //octant 6
				coordinates.add(new Point3D(y + x0, x + y0, z + z0)); //octant 7
				coordinates.add(new Point3D(x + x0, y + y0, z + z0)); //octant 8
				
				coordinates.add(new Point3D(x + x0, -y + y0, -z + z0)); //octant 1
				coordinates.add(new Point3D(y + x0, -x + y0, -z + z0)); //octant 2
				coordinates.add(new Point3D(-y + x0, -x + y0, -z + z0)); //octant 3
				coordinates.add(new Point3D(-x + x0, -y + y0, -z + z0)); //octant 4
				coordinates.add(new Point3D(-x + x0, y + y0, -z + z0)); //octant 5
				coordinates.add(new Point3D(-y + x0, x + y0, -z + z0)); //octant 6
				coordinates.add(new Point3D(y + x0, x + y0, -z + z0)); //octant 7
				coordinates.add(new Point3D(x + x0, y + y0, -z + z0)); //octant 8
				
				y += 1; //y increments by 1 every time no matter what
				if (err <= 0) {
					err += 2*y + 1;
				} else { //err > 0
					x -= 1; //x decrements only sometimes (when the error is greater than 0)
		            err += 2*(y - x) + 1;
				}
				
			}
			z++;
			radius--;
			
		}
//		for(int i = 0; i < coordinates.size(); i++) {
//			System.out.println("(" + (coordinates.get(i).getX()-x0) + "," + (coordinates.get(i).getY()-y0) + ")");
//		}
		return coordinates;
	}
}
