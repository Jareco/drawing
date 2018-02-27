package shapes;

import java.util.ArrayList;

/**
 * Basic class Line
 * @author Vitalii Romanov
 *The basic Class line, which has needed parameters of the line and genereal get and set methods. 
 */
public class Line extends Shape{
	
	/**
	 * constructor
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param stroke_color
	 * @param stroke_width
	 */
	public Line(String name,ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width) {
		super(xCoordinates,yCoordinates,name,null, stroke_color, stroke_width);

	}

}
