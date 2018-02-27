package ManagerShape;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import shapes.*;

/**
 * 
 * abstract class for ManagerShape
 * see documentation of ManagerShape for more information
 */
public interface ManagerShapeInterface {
	
	public int getManagerShape();
	public ArrayList<Shape> getAllShapes();
	public Shape getShapeByName(String name);
	public boolean addShape(Shape s) throws Exception;
	public boolean deleteShape(String name) throws Exception;
	public boolean moveShape(String name, Double xPlus, Double yPlus) throws Exception;
	public boolean editShape(Shape s) throws Exception;
	public String makeSVG(Shape s) throws Exception;
	@SuppressWarnings("rawtypes")
	public Iterator getIterator();
	public String createSvgFile(String data) throws FileNotFoundException, UnsupportedEncodingException;
	public void downloadSvgFile(PrintWriter out, String filename);
	public ArrayList<Shape> groupByType(String type);
    public String createWholeSvg(ArrayList<Shape> shapes);
}
