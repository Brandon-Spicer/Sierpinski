/**
*
*	Sierpinski.java
*	Brandon Spicer
*	11/01/19
*
*	Draw a Sierpinski Triangle with a given number of levels
*
**/


import java.util.*;
import java.awt.*;


public class Sierpinski {
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("========== Sierpinski Triangle ==========");
		System.out.println();
		System.out.print("Enter the number of levels: ");
		int level = input.nextInt();

		DrawingPanel panel = new DrawingPanel(1000, 750);
		Graphics g = panel.getGraphics();
		drawRecursive(g, 400, 0, 800, 650, 0, 650, level);
	}

	/*  drawTriangle takes in a Graphics object and 3 pairs of x,y points
	*	and draws a triangle with the given coordinates
	*/
	public static void drawTriangle(Graphics g, 
		int x_top, int y_top, 
		int x_right, int y_right, 
		int x_left, int y_left) {

		g.drawLine(x_top, y_top, x_right, y_right);
		g.drawLine(x_right, y_right, x_left, y_left);
		g.drawLine(x_left, y_left, x_top, y_top);
	}

	/*	drawRecursive takes in a Graphics object, x,y points for outer triangle,
	*	the number of levels, and draws a Sierpinski triangle with the given
	*	number of levels.
	*/
	public static void drawRecursive(Graphics g, 
		int x_top, int y_top, 
		int x_right, int y_right, 
		int x_left, int y_left, int level) {

		if (level < 0) {
			throw new IllegalArgumentException("level cannot be less than 0!");
		} else if (level == 0) {
			// base case: draw a triangle with the given coordinates
			drawTriangle(g, 
				x_top, y_top, 
				x_right, y_right, 
				x_left, y_left);
		} else {
			// recursive case: draw three triangles inside the given triangle coordinates
			drawRecursive(g, 
				x_top, y_top, 
				x_top + (x_right - x_top) / 2, y_top + (y_right - y_top) / 2,
				x_top - (x_top - x_left) / 2, y_top + (y_left - y_top) / 2, level - 1);
			drawRecursive(g,
				x_top + (x_right - x_top) / 2, y_top + (y_right - y_top) / 2,
				x_right, y_right,
				x_top, y_left, level - 1);	
			drawRecursive(g,
				x_top - (x_top - x_left) / 2, y_top + (y_left - y_top) / 2,
				x_top, y_left,
				x_left, y_left, level - 1);
		}
	}
}


