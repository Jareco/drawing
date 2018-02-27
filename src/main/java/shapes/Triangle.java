package shapes;

import java.util.ArrayList;

/**
 * @author Olena Dankova
 */

public class Triangle extends Shape{
	
	/**
	 * constructor
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param stroke
	 * @param stroke_width
	 */
	public Triangle (String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates,
		String fill, String stroke, double stroke_width)
	{
		super(xCoordinates,yCoordinates,name,fill, stroke, stroke_width);
	}



}
