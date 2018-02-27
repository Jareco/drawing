import org.junit.Test;

import ManagerShape.*;
import shapes.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class TestPortal {

    Layer layer = new Layer();
    int layerID = 1;

    AbstractFactory managerFactory = new ManagerCreator();
    AbstractFactory factory = new ShapeObjectCreator();


    ManagerShapeInterface manager = managerFactory.getManager(1);
    ManagerShapeInterface manager2 = managerFactory.getManager(2);
    ManagerShapeInterface manager3 = managerFactory.getManager(3);    

    @Test
    public void addManager() throws Exception{
    	layer.Attach(manager);
    }
    /**
     * Test for creating of Circle using a factory.
     */
    @Test
    public void createCircle(){        
        String name="C1";
        ArrayList<Double> xcircle = new ArrayList<Double>();
        xcircle.add((double) 50);
        ArrayList<Double> ycircle = new ArrayList<Double>();
        ycircle.add((double) 50);
        String fill="red";
        double radius=40;
        String stroke="black";
        double strokeWidth=3;

        Shape circle = factory.createCircle(name,xcircle,ycircle,fill,radius,stroke,strokeWidth);
        assertEquals(circle.getName(), name);
        assertEquals(circle.getFill(), fill);
        assertEquals(circle.getStroke_color(), stroke);
        assertEquals(circle.getStroke_width(), strokeWidth,0);
    }

    /**
     * Test for creating of Text using a factory.
     */
    @Test
    public void createText(){        
        String name="T1";
        ArrayList<Double> xtext = new ArrayList<Double>();
        xtext.add((double) 50);
        ArrayList<Double> ytext = new ArrayList<Double>();
        ytext.add((double) 50);
        String fill="black";
        double rotation=0;
        String text="Hello world";
        

        Text t1 = factory.createText(name,xtext,ytext,fill,rotation,text);
        
        assertEquals(t1.getName(), name);
        assertEquals(t1.getFill(), fill);
        assertEquals(t1.getText(), text);

    }

    /**
     * Test for creating of Triangle using a factory.
     */
    @Test
    public void createTriangle(){        
        String name="Tr1";
        ArrayList<Double> xtriangle = new ArrayList<Double>();
        
        xtriangle.add((double) 50);
        xtriangle.add((double) 150);
        xtriangle.add((double) 90);
        
        ArrayList<Double> ytriangle = new ArrayList<Double>();
        ytriangle.add((double) 50);
        ytriangle.add((double) 170);
        ytriangle.add((double) 95);
        String fill="yellow";
        String stroke="red";
        double strokeWidth=3;

        Triangle t1 = factory.createTriangle(name,xtriangle,ytriangle,fill,stroke,strokeWidth);
        
        assertEquals(t1.getName(), name);
        assertEquals(t1.getFill(), fill);
        assertEquals(t1.getStroke_color(), stroke);
        assertEquals(t1.getStroke_width(), strokeWidth, 0);
       
        

    }
    
    
    
    /**
     * Test for creating of Star using a factory.
     */
    @Test
    public void createStar(){
        ArrayList<Double> xStar = new ArrayList<Double>();
        xStar.add(100.0);
        xStar.add(40.0);
        xStar.add(190.0);
        xStar.add(10.0);
        xStar.add(160.0);
        ArrayList<Double> yStar = new ArrayList<Double>();
        yStar.add(10.0);
        yStar.add(198.0);
        yStar.add(78.0);
        yStar.add(78.0);
        yStar.add(198.0);

        String nameStar="S1";
        String fillStar="yellow";
        String strokeStar="green";
        double strokeWitdthStar=5;
        String fillRuleStar="evenodd";
        Shape star= factory.createStar(xStar, yStar, nameStar, fillStar, strokeStar, strokeWitdthStar, fillRuleStar);

        assertEquals(star.getName(), nameStar);
        assertEquals(star.getFill(), fillStar);
        assertEquals(star.getStroke_color(), strokeStar);
        assertEquals(star.getStroke_width(), strokeWitdthStar,0);

    }

    /**
     * Test for creating of Ellipse using a factory.
     */
    @Test
    public void createEllipse(){
        String name="Ell1";
        ArrayList<Double> xCoordinates = new ArrayList<Double>();
        xCoordinates.add(200.0);
        xCoordinates.add(100.0);

        ArrayList<Double> yCoordinates = new ArrayList<Double>();
        yCoordinates.add(80.0);
        yCoordinates.add(50.0);

        String stroke_color="yellow";
        double stroke_width=10.0;
        String fill="red";
        Shape ellipse=factory.createEllipse(name, xCoordinates, yCoordinates, stroke_color, stroke_width, fill);

        assertEquals(ellipse.getName(), name);
        assertEquals(ellipse.getFill(), fill);
        assertEquals(ellipse.getStroke_color(), stroke_color);
        assertEquals(ellipse.getStroke_width(), stroke_width,0);
    }

    /**
     * Test for creating of Line using a factory.
     */
    @Test
    public void createLine(){
        String name="Line1";
        ArrayList<Double> xCoordinates = new ArrayList<Double>();
        xCoordinates.add(0.0);
        xCoordinates.add(200.0);

        ArrayList<Double> yCoordinates = new ArrayList<Double>();
        yCoordinates.add(0.0);
        yCoordinates.add(200.0);

        String stroke_color="green";
        double stroke_width=1.0;

        Shape line=factory.createLine(name, xCoordinates, yCoordinates, stroke_color, stroke_width);

        assertEquals(line.getName(), name);
        assertEquals(line.getStroke_color(), stroke_color);
        assertEquals(line.getStroke_width(), stroke_width,0);
    }
    
    /**
     * expected Exception when adding a line with invalid input
     * @throws Exception
     */
    @Test (expected = Exception.class)
    public void exceptionAddLine() throws Exception {
  	
    	layer.Attach(manager);
    	
    	String name="Line2";
        ArrayList<Double> xCoordinates = new ArrayList<Double>();
        xCoordinates.add(0.0);
        xCoordinates.add(600.0); // canvas coordinates 0.0 to 500.0

        ArrayList<Double> yCoordinates = new ArrayList<Double>();
        yCoordinates.add(0.0);
        yCoordinates.add(200.0);

        String stroke_color="green";
        double stroke_width = 10.0;

        Shape line=factory.createLine(name, xCoordinates, yCoordinates, stroke_color, stroke_width);
        
        layer.addShape(layerID, line); // Exception takes place here, because shape can not be added
    }
    
    /**
     * successful adding line with valid input
     * @throws Exception
     */
    @Test
    public void successAddLine() throws Exception {
  	
    	layer.Attach(manager);
    	
    	String name="Line2";
        ArrayList<Double> xCoordinates = new ArrayList<Double>();
        xCoordinates.add(0.0);
        xCoordinates.add(200.0);

        ArrayList<Double> yCoordinates = new ArrayList<Double>();
        yCoordinates.add(0.0);
        yCoordinates.add(200.0);

        String stroke_color="green";
        double stroke_width = 10.0;

        Shape line=factory.createLine(name, xCoordinates, yCoordinates, stroke_color, stroke_width);
        
        layer.addShape(layerID, line);
    }
    
    /**
     * successfully creating SVG after adding a shape line
     * @throws Exception
     */
    @Test
    public void successfulCreateSVG() throws Exception{
    	
    	layer.Attach(manager);
    	
    	String name="Line2";
        ArrayList<Double> xCoordinates = new ArrayList<Double>();
        xCoordinates.add(0.0);
        xCoordinates.add(200.0);

        ArrayList<Double> yCoordinates = new ArrayList<Double>();
        yCoordinates.add(0.0);
        yCoordinates.add(200.0);

        String stroke_color="green";
        double stroke_width = 10.0;

        Shape line=factory.createLine(name, xCoordinates, yCoordinates, stroke_color, stroke_width);
        
        layer.addShape(layerID, line);
        
    	String svg = "";
    	svg = svg + layer.managerShapes.get(0).createWholeSvg(layer.managerShapes.get(0).getAllShapes());
    	assertEquals(svg, "<line x1=\"0.0\" y1=\"0.0\" x2=\"200.0\" y2=\"200.0\" style=\"stroke:green;stroke-width:10.0  \" />\n\n");   	
    	
    }

}
