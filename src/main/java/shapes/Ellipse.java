package shapes;

import java.util.ArrayList;

/**
 * Basic class Ellipse
 * @author Vitalii Romanov
 *
 */
public class Ellipse extends Shape{

	/**
	 * constructor
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param stroke_color
	 * @param stroke_width
	 * @param fill
	 */
	public Ellipse(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width,
			String fill) {
		super(xCoordinates, yCoordinates, name, fill, stroke_color, stroke_width);
	}


}