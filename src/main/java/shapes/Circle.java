package shapes;

import java.util.ArrayList;

public class Circle extends Shape{


	private Double radius;	
	
	/**
	 * constructor
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param radius
	 * @param stroke
	 * @param strokeWidth
	 */
	public Circle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill,
			Double radius, String stroke, Double strokeWidth) {
		super(xCoordinates, yCoordinates, name, fill, stroke, strokeWidth);
		this.radius = radius;
	}
	
	
	/**
	 * @return the radius
	 */
	public Double getRadius() {
		return radius;
	}



	/**
	 * @param radius the radius to set
	 */
	public void setRadius(Double radius) {
		this.radius = radius;
	}



	
}
