package shapes;

import java.util.ArrayList;

public class Star extends Shape {


	private String fillRule; //empty or not
	
	/**
	 * constructor
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param name
	 * @param fill
	 * @param stroke
	 * @param strokeWidth
	 * @param fillRule: even-odd or nonzero
	 */
	public Star(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill,
			String stroke, Double strokeWidth, String fillRule) {
		super(xCoordinates, yCoordinates, name, fill, stroke, strokeWidth);
		
		this.fillRule = fillRule;
	}
	
	

	/**
	 * @return the fillRule
	 */
	public String getFillRule() {
		return fillRule;
	}

	/**
	 * @param fillRule the fillRule to set
	 */
	public void setFillRule(String fillRule) {
		this.fillRule = fillRule;
	}
	
}
