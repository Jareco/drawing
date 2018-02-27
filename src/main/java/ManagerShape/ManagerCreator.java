package ManagerShape;

import shapes.*;

import java.util.ArrayList;

/**
 * Factory for creating Manager
 */
public class ManagerCreator extends AbstractFactory{

    /**
     * Manager using MappingShapeProxy is created.
     * @param LayerId
     * @return
     */
    @Override
    public MappingShapeProxy getManager(int LayerId){
        if(LayerId>=1 && LayerId<=3)
            return new MappingShapeProxy((LayerId));

        return null;
    }

    public Circle createCircle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill, Double radius, String stroke, Double strokeWidth) {
        return null;
    }

    public Ellipse createEllipse(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width, String fill) {
        return null;
    }

    public Line createLine(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String stroke_color, double stroke_width) {
        return null;
    }

    public Polygon createPolygon(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill, String stroke_color, double stroke_widt) {
        return null;
    }

    public Quadrangle createQuadrangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill, String stroke, double stroke_width) {
        return null;
    }

    public Star createStar(ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String name, String fill, String stroke, Double strokeWidth, String fillRule) {
        return null;
    }

    public Text createText(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill, double rotation, String text) {
        return null;
    }

    public Triangle createTriangle(String name, ArrayList<Double> xCoordinates, ArrayList<Double> yCoordinates, String fill, String stroke, double stroke_width) {
        return null;
    }

}
