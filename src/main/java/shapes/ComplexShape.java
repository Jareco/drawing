package shapes;

import java.util.ArrayList;

/**
 * Class, which contains the List of Shapes
 */
public class ComplexShape extends Shape{
	
    private ArrayList<Shape> shapes = new ArrayList<Shape> ();
    private boolean isVisible = true;

    /**
     * constructor
     */
    public ComplexShape() {
        super();
    }

    /**
     * Return the boolean, which shows visibility
     * @return
     */
    public boolean isVisible(){
        return isVisible;
    }

    /**
     * Set Visibility
     * @param res
     */
    public void setVisibility(boolean res){
        isVisible=res;
    }

    /**
     * Add Shape
     * @param s
     */
    public void add (Shape s){
        shapes.add(s);
    }

    /**
     * Remove Shape
     * @param s
     */
    public void remove (Shape s){
        shapes.remove(s);
    }

    /**
     * Getting the List of shapes
     * @return
     */
    public ArrayList<Shape> getAllShapes(){
        return shapes;
    }

    /**
     * Get Child in the List
     * @param i
     * @return
     */
    public Shape getChild(int i) {
        return shapes.get(i);
    }





}
