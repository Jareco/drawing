package ManagerShape;

import shapes.*;

import java.util.ArrayList;

/**
 * Abstract Factory, which is an abstract class for ManagerCreator and ShapeObjectCreator
 */
public abstract class AbstractFactory {
    /**
     * Getting "Manager" for a Layer.
     * @param LayerId
     * @return
     */
    public abstract MappingShapeProxy getManager(int LayerId);

    /**
     * Create Circle
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param fill
     * @param radius
     * @param stroke
     * @param strokeWidth
     * @return
     */
    public abstract Circle createCircle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill,
                                        Double radius, String stroke, Double strokeWidth);

    /**
     * Create Ellipse
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param stroke_color
     * @param stroke_width
     * @param fill
     * @return
     */
    public abstract Ellipse createEllipse(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width,
                                          String fill);

    /**
     * Create Line
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param stroke_color
     * @param stroke_width
     * @return
     */
    public abstract Line createLine(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width);

    /**
     * Create Polygon
     * @param xCoordinates
     * @param yCoordinates
     * @param name
     * @param fill
     * @param stroke_color
     * @param stroke_widt
     * @return
     */
    public abstract Polygon createPolygon(ArrayList<Double> xCoordinates,
                                          ArrayList<Double> yCoordinates, String name, String fill, String stroke_color, double stroke_widt);

    /**
     * Create Qadrangle
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param fill
     * @param stroke
     * @param stroke_width
     * @return
     */
    public abstract Quadrangle createQuadrangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates,
                                                String fill, String stroke, double stroke_width);

    /**
     * Create Star
     * @param xCoordinates
     * @param yCoordinates
     * @param name
     * @param fill
     * @param stroke
     * @param strokeWidth
     * @param fillRule
     * @return
     */
    public abstract Star createStar(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill,
                                    String stroke, Double strokeWidth, String fillRule);

    /**
     * Create Text
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param fill
     * @param rotation
     * @param text
     * @return
     */
    public abstract Text createText(String name, ArrayList<Double> xCoordinates,
                                    ArrayList<Double> yCoordinates, String fill, double rotation, String text);

    /**
     * Create Triangle
     * @param name
     * @param xCoordinates
     * @param yCoordinates
     * @param fill
     * @param stroke
     * @param stroke_width
     * @return
     */
    public abstract Triangle createTriangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates,
                                            String fill, String stroke, double stroke_width);


}
