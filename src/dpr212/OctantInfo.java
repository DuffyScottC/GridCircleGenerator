package dpr212;

/**
 * This class contains information about a circle's first octant that can be used to generate the "corners" of the sphere. 
 * @author Scott
 *
 */
public class OctantInfo {
	/*
	 * The size of the base of the circle in Minecraft. (That number + 1) can be added to x, y, and z 
	 * to get the coordinates of the first corner origin point, from which we will generate a corner plane. Also, that number
	 * can be used to calculate how thick the three rings should be by adding and subtracting the base size
	 * from the origin's x, y and z coordinates. 
	 */
	public int baseSize; //The size of the base
	//The height of the octant, since that will be used to iterate the decreasing sections of the "corner" circles.
	public int octantSize; //The full size of the octant
	
	/*
	 * Example:
	 * first octant when r=11:
	 * H
	 *  H
	 *  H
	 *   H
	 *   H
	 *    H
	 *    H
	 *    H
	 *    H
	 * baseSize = 4
	 * octantSize = 9
	 */
	
	public OctantInfo() {
		baseSize = 1;
		octantSize = 1;
	}
	
	public OctantInfo(int base, int octant) {
		baseSize = base;
		octantSize = octant;
	}
}
