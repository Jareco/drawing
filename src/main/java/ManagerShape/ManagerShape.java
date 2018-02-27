/**
 * 
 */
package ManagerShape;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import shapes.*;


/**
 * Implementation of ManagerShapeInterface
 */
public abstract class ManagerShape implements ManagerShapeInterface {

	public static long id_svgfile=0;
	int LayerID;

	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	
	/**
	 * constructor 
	 * @param LayerID 
	 */
	public ManagerShape(int LayerID) {
		this.LayerID = LayerID;
	}
	
	/**
	 * @return LayerID
	 */
	public int getManagerShape(){
		return LayerID;
	}

	/**
	 * Returns iterator for the list shape.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Iterator getIterator(){ return shapes.iterator();}
	
	/**
	 * @return returns all created shapes
	 */
	public ArrayList<Shape> getAllShapes(){
		return shapes;
	}
	
	/**
	 * @param name of shape (it is the identifier for our implementation)
	 * @return a specific shape
	 */
	@SuppressWarnings("rawtypes")
	public Shape getShapeByName(String name){
		Shape shape = null;

		for(Iterator iter = getIterator(); iter.hasNext();) {
			Shape s = (Shape) iter.next();
			if (s.getName().equals(name)){
				shape = s;
			}
		}
		return shape;
	}
	
	/**
	 * @param s the shape that will be added to the manager
	 */
	public boolean addShape(Shape s) throws Exception {
		if(!(s instanceof Polygon)){
			if(checkCoordinatesInRangeOfCanvas(s.getxCoordinates()) && checkCoordinatesInRangeOfCanvas(s.getyCoordinates()));
			else
				throw new Exception("Coordinates out of range of canvas window. You wouldn't see the shape!");
			
			if(shapes == null)
				shapes = new ArrayList<Shape>();
			
			if (getShapeByName(s.getName()) == null)
				return shapes.add(s);
			return false;
		} else {
			ArrayList<Double> notNullPolyCoords = new ArrayList<Double>();
			for(int i = 0; i < s.getxCoordinates().size(); i++){
				if(s.getxCoordinates().get(i) != null)
					notNullPolyCoords.add(s.getxCoordinates().get(i));
			}
			if(checkCoordinatesInRangeOfCanvas(notNullPolyCoords) && checkCoordinatesInRangeOfCanvas(notNullPolyCoords));
			else
				throw new Exception("Coordinates out of range of canvas window. You wouldn't see the shape!");
			
			if(shapes == null)
				shapes = new ArrayList<Shape>();
			
			if (getShapeByName(s.getName()) == null)
				return shapes.add(s);
			return false;
		}
		
	}

	/**
	 * @param name of shape to delete
	 */
	public boolean deleteShape(String name) throws Exception {
		if (getShapeByName(name)!=null){
			return shapes.remove(getShapeByName(name));
		}
		else throw new Exception("Shape mit diesem Namen existiert nicht");

	}

	/**
	 * @param name of the shape that will be moved
	 * @param xPlus move shape by value of xPlus in horizontal direction
	 * @param yPlus move shape by value of yPlus in vertical direction
	 */
	public boolean moveShape(String name, Double xPlus, Double yPlus) throws Exception {
		
		if (getShapeByName(name)==null){
			throw new Exception ("Shape not found");
		}
		
		Shape s = getShapeByName(name);
		
		ArrayList<Double> newxCoordinates = new ArrayList<Double>();
		for (int i =0; i<s.getxCoordinates().size(); i++){
			if(s.getxCoordinates().get(i) != null)
				newxCoordinates.add(s.getxCoordinates().get(i) + xPlus);
			else
				newxCoordinates.add(null);
		}
		
		ArrayList<Double> newyCoordinates = new ArrayList<Double>();
		for (int i =0; i<s.getyCoordinates().size(); i++){
			if(s.getyCoordinates().get(i) != null)
				newyCoordinates.add(s.getyCoordinates().get(i) + yPlus);
			else
				newyCoordinates.add(null);
		}
		
		if(checkCoordinatesInRangeOfCanvas(newyCoordinates) && checkCoordinatesInRangeOfCanvas(newxCoordinates)){
			s.setxCoordinates(newxCoordinates);
			s.setyCoordinates(newyCoordinates);
		}
		else
			throw new Exception("Coordinates out of range of canvas window. You wouldn't see the shape!");
		
		return true;
	}
	
	/**
	 * @param s: existing shape with new values for its attributes
	 */
	public boolean editShape(Shape s) throws Exception {
		if(checkCoordinatesInRangeOfCanvas(s.getxCoordinates()) && checkCoordinatesInRangeOfCanvas(s.getyCoordinates()));
		else
			throw new Exception("Coordinates out of range of canvas window. You wouldn't see the shape!");
		
		for(int i = 0; i < shapes.size(); i++) {
			if(shapes.get(i).getName().equals(s.getName())){
				shapes.remove(i);
				shapes.add(i, s);
				return true;
			}				
		}
		return false;
	}

	/**
	 * It creats an svg file
	 * @param data
	 * @return
	 */
	public String createSvgFile(String data) {
		PrintWriter writer = null;
		String fileName = "name" + id_svgfile + ".svg";
		try {
			writer = new PrintWriter(fileName, "UTF-8");
			id_svgfile++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println ("<?xml version=\"1.0\" encoding=\"iso-8859-1\" ?>");
		writer.println("<svg width=\"500\" height=\"500\">");
		writer.println(data);
		writer.println("</svg>");
		writer.close();

		return fileName;
	}

	/**
	 * It's a method for downloading SVG file.
	 * @param out
	 * @param filename
	 */
	public void downloadSvgFile(PrintWriter out, String filename){

		java.io.FileInputStream fileInputStream = null;
		try {
			fileInputStream = new java.io.FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int i;
		try {
			while ((i=fileInputStream.read()) != -1) {
                out.write(i);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();

		File file = new File(filename);
		file.delete();

	}

	/**
	 * It groups shapes by Type
	 * @param type
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<Shape> groupByType(String type){
		ComplexShape circles = new ComplexShape();
		ComplexShape ellipses = new ComplexShape();
		ComplexShape lines = new ComplexShape();
		ComplexShape polygons = new ComplexShape();
		ComplexShape quadrangles = new ComplexShape();
		ComplexShape stars = new ComplexShape();
		ComplexShape texts = new ComplexShape();
		ComplexShape triangles = new ComplexShape();

		if(shapes == null)
			shapes = new ArrayList<Shape>();

		for(Iterator iter = getIterator(); iter.hasNext();) {
			Shape s = (Shape) iter.next();

			if(s instanceof Circle) circles.add(s);
			if(s instanceof Ellipse) ellipses.add(s);
			if(s instanceof Line) lines.add(s);
			if(s instanceof Polygon) polygons.add(s);
			if(s instanceof Quadrangle) quadrangles.add(s);
			if(s instanceof Star) stars.add(s);
			if(s instanceof Text) texts.add(s);
			if(s instanceof Triangle) triangles.add(s);
		}

		if(type.equals("circle")) return circles.getAllShapes();
		if(type.equals("ellipse")) return ellipses.getAllShapes();
		if(type.equals("line")) return lines.getAllShapes();
		if(type.equals("polygon")) return polygons.getAllShapes();
		if(type.equals("quadrangle")) return quadrangles.getAllShapes();
		if(type.equals("star")) return stars.getAllShapes();
		if(type.equals("text")) return texts.getAllShapes();
		if(type.equals("triangle")) return triangles.getAllShapes();

		return null;
	}

	/**
	 * Create a whole SVG for output
	 * @param inputShapes
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String createWholeSvg(ArrayList<Shape> inputShapes){
		String svg="";
        try {
            for (Iterator iter = inputShapes.iterator(); iter.hasNext(); ) {
                Shape s = (Shape) iter.next();
                try {
                    svg = svg + makeSVG(s) + "\n";
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }catch (NullPointerException e){
        	e.printStackTrace();
        }

        return svg;
    }

	/**
	 * implemented in MappingShape
	 * @param 
	 * @return creates an SVG text format for a specific shape
	 */
	public abstract String makeSVG(Shape s) throws Exception;
	
	/**
	 * canvas is of width x height: 500 x 500 to see the whole shape, coordinates shouldn't be out of range
	 * @param coordinates
	 * @return
	 * @throws Exception 
	 */
	private boolean checkCoordinatesInRangeOfCanvas(ArrayList<Double> coordinates) throws Exception{
		
		for(int i = 0; i < coordinates.size(); i++)
			if(coordinates.get(i) < 0 || coordinates.get(i) > 500)
				return false;
		return true;
	}

}
