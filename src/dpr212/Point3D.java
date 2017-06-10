package dpr212;

public class Point3D {
	public int x;
	public int y;
	public int z;
	
	public Point3D (int nX, int nY, int nZ) {
		x = nX;
		y = nY;
		z = nZ;
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	
	public boolean compareTo(Point3D p) {
		if (p.x == x) {
			if (p.y == y) {
				if (p.z == z) {
					return true;
				}
			}
		}
		return false; //Only runs if one of the values is not equal
	}
}
