package shapes;

import java.util.ArrayList;

/**
 * @author Duray 01306090
 * 
 */
public class Polygon extends Shape {
	
	/**
	 * constructor
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param name
	 * @param fill
	 * @param stroke_color
	 * @param stroke_width
	 */
	public Polygon(ArrayList<Double> xCoordinates, 
			ArrayList<Double> yCoordinates, String name, String fill, String stroke_color, double stroke_width){
		super(xCoordinates, yCoordinates, name, fill, stroke_color, stroke_width);
		while(xCoordinates.size() < 10)
			xCoordinates.add(null);
		while(yCoordinates.size() < 10)
			yCoordinates.add(null);

		setxCoordinates(xCoordinates);
		setyCoordinates(yCoordinates);

	}

}
