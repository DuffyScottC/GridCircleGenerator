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
}
