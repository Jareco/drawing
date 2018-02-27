package ManagerShape;

import java.util.ArrayList;

import shapes.*;

/**
 * @author Duray
 * although the name is Layer but for now you find here the subject implementation for 
 * the Observer Pattern (see status_update.pdf)
 */
public class Layer {
	

	public ArrayList<ManagerShapeInterface> managerShapes;
	
	/**
	 * default constructor
	 */
	public Layer() {
		super();
	}
	
	/**
	 * @param shapeManager the shape manager that gets attached
	 * @throws Exception
	 */
	public boolean Attach(ManagerShapeInterface shapeManager)throws Exception{
		if(managerShapes == null)
			managerShapes = new ArrayList<ManagerShapeInterface>();
		
		return managerShapes.add(shapeManager);
	}
	
	/**
	 * @param shapeManager the shape manager that gets detached
	 * @throws Exception
	 */
	public boolean Detach(ManagerShapeInterface shapeManager) throws Exception{
		if(managerShapes == null)
			throw new Exception("No Layers avaible!");
		
		for (ManagerShapeInterface mS: managerShapes){
			if (mS.getManagerShape() == shapeManager.getManagerShape()){
				return managerShapes.remove(mS);
			}
		}
		return false;
	}
	
	/**
	 * notifies the ManagerShapeInterface to add a Shape from a specific Layer
	 * @param LayerID ID of the specific layer
	 * @param s Shape to add
	 * @throws Exception
	 */
	public boolean addShape(int LayerID, Shape s) throws Exception{
		if(managerShapes == null)
			throw new Exception("No Layers avaible to add shapes!");
		
		for (ManagerShapeInterface mS: managerShapes){
			if (mS.getManagerShape() == LayerID){
				return mS.addShape(s);
			}
		}
		
		return false;
	}
	
	/**
	 * notifies the ManagerShapeInterface to delete a Shape from a specific Layer
	 * @param LayerID ID of the specific layer
	 * @param shapeName
	 * @throws Exception
	 */
	public boolean deleteShape(int LayerID, String shapeName) throws Exception{
		if(managerShapes == null)
			throw new Exception("No Layers avaible to delete shapes!");
		
		for (ManagerShapeInterface mS: managerShapes){
			if (mS.getManagerShape() == LayerID){
				return mS.deleteShape(shapeName);
			}
		}
		
		return false;
	}
	
	/**
	 * notifies the ManagerShapeInterface to move a Shape from a specific Layer
	 * @param LayerID
	 * @param shapeName
	 * @param xPlus the movement on the x axes
	 * @param yPlus the movement on the y axes
	 * @throws Exception
	 */
	public boolean moveShape(int LayerID, String shapeName, Double xPlus, Double yPlus) throws Exception{
		if(managerShapes == null)
			throw new Exception("No Layers avaible to move shapes!");
		
		for (ManagerShapeInterface mS: managerShapes){
			if (mS.getManagerShape() == LayerID){
				return mS.moveShape(shapeName, xPlus, yPlus);
			}
		}
		
		return false;
	}
	
	/**
	 * notifies the ManagerShapeInterface to edit a Shape from a specific Layer
	 * @param LayerID
	 * @param s the Sshape to edit
	 * @throws Exception
	 */
	public boolean editShape(int LayerID, Shape s) throws Exception{
		if(managerShapes == null)
			throw new Exception("No Layers avaible to edit shapes!");
		
		for (ManagerShapeInterface mS: managerShapes){
			if (mS.getManagerShape() == LayerID){
				return mS.editShape(s);
			}
		}
		
		return false;
	}

}
