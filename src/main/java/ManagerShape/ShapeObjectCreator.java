package ManagerShape;

import java.util.ArrayList;

import shapes.Circle;
import shapes.Ellipse;
import shapes.Line;
import shapes.Polygon;
import shapes.Quadrangle;
import shapes.Star;
import shapes.Text;
import shapes.Triangle;

/**
 * Factory for creating of shapes.
 */
public class ShapeObjectCreator extends AbstractFactory{

	/**
	 * create Cicrle
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param radius
	 * @param stroke
	 * @param strokeWidth
	 * @return
	 */
	public Circle createCircle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill,
			Double radius, String stroke, Double strokeWidth){
		assert (radius>0 && name!=null && strokeWidth<=radius && fill!=null) : "Assertion, wrong parameter for circle";
		
		return new Circle(name, xCoordinates, yCoordinates, fill, radius, stroke, strokeWidth);	
	}
	
	/**
	 * create ellipse
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param stroke_color
	 * @param stroke_width
	 * @param fill
	 * @return
	 */
	public Ellipse createEllipse(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width,
			String fill){
		assert(xCoordinates.get(0)>=0 && yCoordinates.get(0)>=0 && name!=null) : "Assertion, wrong parameter for ellipse";
		
		return new Ellipse(name,xCoordinates, yCoordinates,stroke_color,stroke_width, fill);
	}
	
	/**
	 * create Line
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param stroke_color
	 * @param stroke_width
	 * @return
	 */
	public Line createLine(String name,ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width){
		assert (name!=null && xCoordinates.get(0)>=0 && yCoordinates.get(0)>=0) : "Assertion, wrong parameter for line";
		
		return new Line (name, xCoordinates, yCoordinates, stroke_color, stroke_width);
	}
	
	/**
	 * create polygon
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param name
	 * @param fill
	 * @param stroke_color
	 * @param stroke_widt
	 * @return
	 */
	public Polygon createPolygon(ArrayList<Double> xCoordinates, 
			ArrayList<Double> yCoordinates, String name, String fill, String stroke_color, double stroke_widt){
		assert( xCoordinates.size() > 4 && yCoordinates.size() > 4 && name != null) : "Assertion, wrong parameter for polygon";
		
		return new Polygon(xCoordinates, yCoordinates, name, fill, stroke_color, stroke_widt);
	}
	
	/**
	 * create quadrangle
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param stroke
	 * @param stroke_width
	 * @return
	 */
	public Quadrangle createQuadrangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates,
			String fill, String stroke, double stroke_width){
		assert (xCoordinates.size()==4 && yCoordinates.size()==4): "Assertion, wrong parameter for quadrangle";
		
		return new Quadrangle(name, xCoordinates, yCoordinates, fill, stroke, stroke_width);
	}
	
	/**
	 * create Star
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param name
	 * @param fill
	 * @param stroke
	 * @param strokeWidth
	 * @param fillRule
	 * @return
	 */
	public Star createStar(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill,
			String stroke, Double strokeWidth, String fillRule){
		assert (xCoordinates.size()==5 && yCoordinates.size()==5) : "Assertion, wrong parameter for star";
		
		return new Star(xCoordinates, yCoordinates, name, fill, stroke, strokeWidth, fillRule);
	}
	
	/**
	 * create text
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param rotation
	 * @param text
	 * @return
	 */
	public Text createText(String name, ArrayList<Double> xCoordinates, 
			ArrayList<Double> yCoordinates, String fill, double rotation, String text){
		assert (xCoordinates.size()!=0 && yCoordinates.size()!=0 && text.length()>0) : "Assertion, wrong parameter for text";
		
		return new Text(name, xCoordinates, yCoordinates, fill, rotation, text);
	}
	
	/**
	 * create triangle
	 * @param name
	 * @param xCoordinates
	 * @param yCoordinates
	 * @param fill
	 * @param stroke
	 * @param stroke_width
	 * @return
	 */
	public Triangle createTriangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates,
		String fill, String stroke, double stroke_width){
		assert (xCoordinates.size()==3 && yCoordinates.size()==3) : "Assertion, wrong parameter for triangle";
		
		return new Triangle(name, xCoordinates, yCoordinates, fill, stroke, stroke_width);
	}

	public MappingShapeProxy getManager(int LayerId) {
		return null;
	}
}
