package dpr212;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;

public class PixelCircleComponent extends JComponent {
	private int x; //The x-coordinate of the center
	private int y; //The y-coordinate of the center
	private int radius; //The radius of the circle
	private ArrayList<Point> coordinates;
	
	/**
	 * Creates a new circle object
	 * @param newX - x-coord of center
	 * @param newY - y coord of center
	 * @param newR - radius of circle
	 */
	public PixelCircleComponent (int newX, int newY, int newR) {
		x = newX;
		y = newY;
		radius = newR;
	}
	
	/**
	 * This function uses the GenerateCircle object's generate() method to generate a graphical 
	 * representation of a rasterize circle
	 */
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		coordinates = GenerateCircle.generate(x, y, radius); //Calculate the coordinates of the circle's pixels and put them in an array
		for (int i = 0; i < coordinates.size(); i++) { //Keep adding rectangles while there are still coordinates in the array
			g.fillRect(coordinates.get(i).x, coordinates.get(i).y, 1, 1); //Add a new rectangle to represent those coordinates
		}
	}
	
	@Override
	public Dimension getPreferredSize () {
		return new Dimension(radius*2, radius*2);
	}
	
//	@Override
//	public Point getLocation () {
//		return new Point(x,y);
//	}
}
