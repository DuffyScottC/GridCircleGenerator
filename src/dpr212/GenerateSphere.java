package dpr212;

import java.awt.Point;
import java.util.ArrayList;

/**
 * This code is translated into java from the following two websites:
 * 
 * https://stackoverflow.com/questions/41656006/how-to-rasterize-a-sphere
 * https://jsfiddle.net/mtimmerm/ay2adpwb/
 * 
 * and converted into a form that can be used to generate spheres in minecraft
 * 
 * @author Scott
 *
 */
public class GenerateSphere {
	
	//JavaScript
	private double radiusInVoxels;
	private int x0; //The x-coord of the center of the circle
	private int y0; //The y-coord of the center of the circle
	private int z0; //The z-coord of the center of the circle
	private ArrayList<Point3D> group; //holds the coordinates of each block in the sphere
	
	/**
	 * 
	 * @param newX0 - The x-coord of the center of the circle
	 * @param newY0 - The y-coord of the center of the circle
	 * @param newZ0 - The z-coord of the center of the circle
	 * @param radius - The radius of the circle
	 */
	public GenerateSphere(int newX0, int newY0, int newZ0, int radius, String blockType) {
		group = new ArrayList<Point3D>();
		
		x0 = newX0;
		y0 = newY0;
		z0 = newZ0;
		radiusInVoxels = ((double) (radius))+.5;//10.5;
//	    System.out.println(radiusInVoxels);
		
		//Now actually generate the sphere:
		drawSphere(radiusInVoxels);
		
		for (int i = 0; i < group.size(); i++) {
			System.out.println(" setblock " + group.get(i).x + " " + group.get(i).y + " " + group.get(i).z + " minecraft:" + blockType + " keep");
		}
		
	}
	
	//radiusInVoxels is passed into R when this function is called
public void drawSphere(double R) {
	int maxR2 = (int) (R*R); //max radius squared
	int x,y,z;
	int zx = (int) R; //truncate the value R
	for (x=0; ;x++) {
		//max z for this x value.
		while(x*x+zx*zx > maxR2 && zx>=x) {
			--zx;
		}
		
		if (zx<x) {
			break; //with this x, z can't be largest
		}
		
		z=zx;
		for(y=0; ;++y) {
			while(x*x+y*y+z*z > maxR2 && z>=x && z>=y)
				--z;
			if (z<x||z<y)
				break; //with this x and y, z can't be largest
      			fillAll(x,y,z); //... and up to 23 reflections of it
    	}
	}
}


/**
 * 
 * @param x
 * @param y
 * @param z
 */
public void fillSigns(int x, int y, int z) {
	group.add(new Point3D(x+x0, y+y0, z+z0));
	while(true) {
		
		//without lines A, B and C, we would only generate octant 1
		//A
		z = -z; //This line reflects every point to octant 2
		if (z >= 0) {
			//B
			y = -y; //this line reflects every point to octant 5
			if (y >= 0) {
				//C
				x = -x; //This line reflects every point to octant 4
				if (x >= 0) {
					break;
				}
			}
		}
		group.add(new Point3D(x+x0, y+y0, z+z0));
		/*
		 * Lines A and B combine together to form octants 1, 2, 5, and 6
		 * Lines A and C combine together to form octants 1, 2, 3, and 4
		 * Lines B and C combine together to form octants 1, 4, 5, and 8
		 * Lines A, B, and C combine toghether to form octants 1, 2, 3, 4, 5, 6, 7, and 8
		 */
  	}
}

/**
 * Runs fillSigns commands for
 * 1. z-axis
 * 2. y-axis
 * 3. x-axis
 * 
 * @param x
 * @param y
 * @param z
 */
public void fillAll(int x, int y, int z) {
	//1. z-axis
	fillSigns(x,y,z); //wool 3 (blue)
	if (z>y) {
		//2. y-axis
		fillSigns(x,z,y); //wool 4 (yellow)
	}
	if (z>x && z>y) {
		//3. x-axis
		fillSigns(z,y,x); //wool 5 (green)
	}
}
//End of JavaScript
	
	
}

