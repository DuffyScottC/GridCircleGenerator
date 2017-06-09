package dpr212;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
 * This object is the JComponent that actually holds the graphical elements of the rasterized circle
 * 
 * @author Scott
 */
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
		radius = newR;//GenerateCircle.SQUARE; //This is multiplied by SQUARE to keep the scale of the rasterized circle
	}
	
	/**
	 * This function uses the GenerateCircle object's generate() method to generate a graphical 
	 * representation of a rasterize circle
	 */
	@Override
	public void paintComponent(Graphics g) {
		coordinates = GenerateCircle.generateHollowCircle(x, y, radius); //Calculate the coordinates of the circle's pixels and put them in an array
		for (int i = 0; i < coordinates.size(); i++) { //Keep adding rectangles while there are still coordinates in the array
			//Convert the coordinates found in generate() to appropriately sized squares
			int xCoord = (coordinates.get(i).x - x)*GenerateCircle.SQUARE + x;
			int yCoord = (coordinates.get(i).y - y)*GenerateCircle.SQUARE + y;
			g.setColor(Color.RED);
			//Add a new rectangle to represent those coordinates
			g.fillRect(xCoord, yCoord, GenerateCircle.SQUARE, GenerateCircle.SQUARE);
			g.setColor(Color.LIGHT_GRAY);
			//Put a boarder around the pixels
			g.drawRect(xCoord, yCoord, GenerateCircle.SQUARE, GenerateCircle.SQUARE);
		}
	}
	
//	/**
//	 * This function uses the GenerateCircle object's generate() method to generate a graphical 
//	 * representation of a rasterize circle
//	 */
//	@Override
//	public void paintComponent(Graphics g) {
//		coordinates = GenerateCircle.generateHollowCircle(x, y, radius); //Calculate the coordinates of the circle's pixels and put them in an array
//		for (int i = 0; i < coordinates.size(); i++) { //Keep adding rectangles while there are still coordinates in the array
//			//Convert the coordinates found in generate() to appropriately sized squares
//			int xCoord = (coordinates.get(i).x - x)*GenerateCircle.SQUARE + x;
//			int yCoord = (coordinates.get(i).y - y)*GenerateCircle.SQUARE + y;
//			g.setColor(Color.RED);
//			//Add a new rectangle to represent those coordinates
//			g.fillRect(xCoord, yCoord, GenerateCircle.SQUARE, GenerateCircle.SQUARE);
//			g.setColor(Color.LIGHT_GRAY);
//			//Put a boarder around the pixels
//			g.drawRect(xCoord, yCoord, GenerateCircle.SQUARE, GenerateCircle.SQUARE);
//		}
//	}
	
	@Override
	public Dimension getPreferredSize () {
		return new Dimension(radius*2, radius*2);
	}
	
//	@Override
//	public Point getLocation () {
//		return new Point(x,y);
//	}
}
