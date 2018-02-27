package shapes;

import java.util.ArrayList;

/**
 * @author Duray 01306090
 *
 */
public class Text extends Shape {

	private double tRotation;
	private String tText;
	

	/**
	 * constructor
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param rotation
	 * @param text
	 */
	public Text(String name, ArrayList<Double> xCoordinates, 
			ArrayList<Double> yCoordinates, String fill, double rotation, String text) {
		super(xCoordinates, yCoordinates, name, fill, null, 0);
		
		this.tRotation = rotation;
		this.tText = text;
	}


	/**
	 * @return the rotation of the text around the center 
	 * specified by xCoordinates and yCoordinates
	 */
	public double getRotation() {
		return tRotation;
	}

	/**
	 * @param tRotation the rotation of the text around the center to set
	 */
	public void setRotation(double rotation) {
		this.tRotation = rotation;
	}

	/**
	 * @return the written text of the shape text
	 */
	public String getText() {
		return tText;
	}

	/**
	 * @param tText the written text of the shape text
	 */
	public void setText(String text) {
		this.tText = text;
	}

}
