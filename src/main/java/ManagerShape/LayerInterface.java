package ManagerShape;

import shapes.Shape;

/**
 * @author Duray
 * abstract class for Layer
 * see documentation of Layer for more information
 */
public abstract class LayerInterface {
	
	public abstract boolean Attach(ManagerShapeInterface shapeManager)throws Exception;
	public abstract boolean Detach(ManagerShapeInterface shapeManager) throws Exception;
	public abstract boolean addShape(int LayerID, Shape s) throws Exception;
	public abstract boolean deleteShape(int LayerID, String shapeName) throws Exception;
	public abstract boolean moveShape(int LayerID, String shapeName, Double xPlus, Double yPlus) throws Exception;
	public abstract boolean editShape(int LayerID, Shape s) throws Exception;
}
