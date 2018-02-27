package ManagerShape;

import java.util.ArrayList;
import java.util.Iterator;

import shapes.*;

public class Test {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		Layer observe = new Layer();
		int layer1 = 1;
		ManagerShapeInterface m=new MappingShape(layer1);
		observe.Attach(m);
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		x.add(2.1);
		x.add(3.1);
		y.add(2.1);
		y.add(3.1);
		
//		/Shape ln = new Line("line1", x,y,"red",1);
//		observe.addShape(layer1, ln);
		Shape el=new Ellipse("ell",x,y,"yellow", 1, "yellow");
		observe.addShape(layer1, el);
		
		String svg="";
		for(Shape sp: m.getAllShapes()) {
			svg=svg+m.makeSVG(sp);
		}
		
		
		System.out.println(svg);
		
		x.add(4.0); x.add(5.0); x.add(6.0);
		y.add(4.0); y.add(5.0); y.add(6.0);

			
			
		Shape star = new Star(x,y, "star1", "red", "blue", 5.0, "nonzero");
		observe.addShape(layer1, star);
//		System.out.println(m.makeSVG(star));
		
		for(Shape sp: m.getAllShapes()) {
			svg=svg+m.makeSVG(sp);
		}
		
		
		System.out.println(svg);
		
		observe.deleteShape(layer1, "ell");

		/**
		for(Shape sp: m.getAllShapes()) {
			svg=svg+m.makeSVG(sp);
		}
		 **/
		for(Iterator iter = m.getIterator(); iter.hasNext();){
			Shape s = (Shape) iter.next();
			svg=svg+m.makeSVG(s);
		}

		observe.Detach(m);
		
		System.out.println("Last svg: "+svg);
		
		
		System.out.println("Proxy: ");
		MappingShapeProxy msp=new MappingShapeProxy(1);
		msp.addShape(el);
		for(Shape s: msp.getAllShapes())
		System.out.println("Shape: " + s.getName());


	}
}

