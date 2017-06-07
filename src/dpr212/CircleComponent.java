package dpr212;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;


public class CircleComponent extends JComponent {
	private int x; //The x-coordinate of the position
	private int y; //The y-coordinate of the position
	private int width;
	private int height;
	
	public CircleComponent (int newX, int newY, int w, int h) {
		x = newX;
		y = newY;
		width = w;
		height = h;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, width, height);
	}
	
	@Override
	public Dimension getPreferredSize () {
		return new Dimension(width, height);
	}
	
	@Override
	public Point getLocation () {
		return new Point(x,y);
	}
}
