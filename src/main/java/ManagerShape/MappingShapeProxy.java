package ManagerShape;

import shapes.Shape;

/**
 * Proxy of MappingShape
 */
public class MappingShapeProxy extends ManagerShape{
	private MappingShape ms=null;

	public MappingShapeProxy(int LayerID) {
		super(LayerID);
	}


	/**
	 * MappingShape is initialized. The method makeSVG is colled.
	 * @param s
	 * @return
	 * @throws Exception
	 */
	@Override
	public String makeSVG(Shape s) throws Exception {
		if(ms==null) 
			ms=new MappingShape(LayerID);

		return ms.makeSVG(s);
	}
	 

}
