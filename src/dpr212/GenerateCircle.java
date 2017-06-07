package dpr212;

/**
 * Generates the coordinates of a pixel circle
 * @author Scott
 *
 */
public class GenerateCircle {
	/**
	 * 
	 * @param x0 - x-coordinate of center of circle
	 * @param y0 - y-coordinate of center of circle
	 * @param radius - the radius of the circle
	 * @return a string containing a list of all the coordinates of the first octant
	 */
	public static String generate(int x0, int y0, int radius) {
		int x = radius; //The x-coordinate of the pixel being drawn
		int y = 0; //The y-coordinate of the pixel being drawn
		int err = 1 - x;
		String result = "";
		
		while (x >= y) { //When the x=y then we are at a 45º angle from the origin
			
			result = result + "(" + (x0 + x) + "," + (y0 + y) + ")\n";
			
			y += 1; //y increments by 1 every time no matter what
			if (err <= 0) {
				err += 2*y + 1;
			} else { //err > 0
				x -= 1;
	            err += 2*(y - x) + 1;
			}
			
			
		}
		return result;
	}
	
}
