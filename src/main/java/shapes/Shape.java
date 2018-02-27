package shapes;

import java.util.ArrayList;

/**
 * Abstract class Shape
 */
public abstract class Shape {

	private	ArrayList<Double> xCoordinates;
	private ArrayList<Double> yCoordinates;
	private String name;
	private String fill;
	
	private String stroke_color;
	private double stroke_width;
	
	
	/**
	 * constructor
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param name
	 * @param fill
	 * @param stroke_color
	 * @param stroke_width
	 */
	public Shape(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill, String stroke_color, double stroke_width) {
		this.xCoordinates = xCoordinates;
		this.yCoordinates = yCoordinates;
		this.name = name;
		this.fill = fill;
		this.stroke_color = stroke_color;
		this.stroke_width  =stroke_width;
	}

	public Shape(){}
	
	
	
	/**
	 *
	 * @return the xCoordinates
	 */
	public ArrayList<Double> getxCoordinates() {
		return xCoordinates;
	}
	/**
	 * @param xCoordinates the xCoordinates to set
	 */
	public void setxCoordinates(ArrayList<Double> xCoordinates) {
		this.xCoordinates = xCoordinates;
	}
	/**
	 * @return the yCoordinates
	 */
	public ArrayList<Double> getyCoordinates() {
		return yCoordinates;
	}
	/**
	 * @param yCoordinates the yCoordinates to set
	 */
	public void setyCoordinates(ArrayList<Double> yCoordinates) {
		this.yCoordinates = yCoordinates;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the fill
	 */
	public String getFill() {
		return fill;
	}
	/**
	 * @param fill the fill to set
	 */
	public void setFill(String fill) {
		this.fill = fill;
	}



	/**
	 * @return the stroke_color
	 */
	public String getStroke_color() {
		return stroke_color;
	}



	/**
	 * @param stroke_color the stroke_color to set
	 */
	public void setStroke_color(String stroke_color) {
		this.stroke_color = stroke_color;
	}



	/**
	 * @return the stroke_width
	 */
	public double getStroke_width() {
		return stroke_width;
	}



	/**
	 * @param stroke_width the stroke_width to set
	 */
	public void setStroke_width(double stroke_width) {
		this.stroke_width = stroke_width;
	}
	
	
}
