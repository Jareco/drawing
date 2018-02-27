package ManagerShape;


import shapes.*;


/**
 * Class for Creating of SVG-Code for different shapes.
 */
public class MappingShape extends ManagerShape {

	public MappingShape(int LayerID) {
		super(LayerID);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * creates an SVG text format for a circle
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public String makeSvgCircle(Circle c) throws Exception{
		
//		Example: <circle cx="50" cy="50" r="40" stroke="black" stroke-width="3" fill="red" />
		String svg = "<circle cx=";
		svg = svg + "\"" + c.getxCoordinates().get(0) + "\" ";
		svg = svg + "cy=" + "\"" + c.getxCoordinates().get(0) + "\" ";
		svg = svg + "r=\"" + c.getRadius() + "\" ";
		svg = svg + "stroke=" + "\"" + c.getStroke_color() + "\" ";
		svg = svg + "stroke-width=" + "\"" + c.getStroke_width() + "\" ";
		svg = svg + "fill=" + "\"" + c.getFill() + "\" " + "/>";
			
		return svg;
	}
	
	/**
	 * creates an SVG text format for a star
	 * @param c
	 * @return
	 * @throws Exception
	 */
	public String makeSvgStar(Star c) throws Exception{
		
//		Example: <polygon points="100,10 40,198 190,78 10,78 160,198" style="fill:lime;stroke:purple;stroke-width:5;fill-rule:nonzero;" />
		String svg = "<polygon points=";
		double x1 = c.getxCoordinates().get(0);
		double x2 = c.getxCoordinates().get(1);
		double x3 = c.getxCoordinates().get(2);
		double x4 = c.getxCoordinates().get(3);
		double x5 = c.getxCoordinates().get(4);
		
		double y1= c.getyCoordinates().get(0);
		double y2 = c.getyCoordinates().get(1);
		double y3 = c.getyCoordinates().get(2);
		double y4 = c.getyCoordinates().get(3);
		double y5 = c.getyCoordinates().get(4);
				
		svg = svg + "\"" 
				  + x1 + "," + y1 + " " 
				  + x2 + "," + y2 + " " 
				  + x3 + "," + y3 + " " 
				  + x4 + "," + y4 + " " 
				  + x5 + "," + y5 + "\""
				  + " ";
		svg = svg + "style=\"fill:" + c.getFill() 
				  + ";stroke:" + c.getStroke_color() 
				  + ";stroke-width:" + c.getStroke_width() 
				  + ";fill-rule:" + c.getFillRule() + "\" />";
	
		return svg;
	}
	
	/**
	 * creates an SVG text format for a quadrangle
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String makeSvgQuadrangle (Quadrangle t) throws Exception{
		
//		String svg = "<quadrangle points: =";
		StringBuilder sb = new StringBuilder();
		sb.append("<polygon points=\"");
		sb.append(t.getxCoordinates().get(0));
		sb.append(",");
		sb.append(t.getyCoordinates().get(0));
		sb.append(",");
		sb.append(t.getxCoordinates().get(1));
		sb.append(",");
		sb.append(t.getyCoordinates().get(1));
		sb.append(",");
		sb.append(t.getxCoordinates().get(2));
		sb.append(",");
		sb.append(t.getyCoordinates().get(2));
		sb.append(",");
		sb.append(t.getxCoordinates().get(3));
		sb.append(",");
		sb.append(t.getyCoordinates().get(3));
		sb.append("\"style=\"fill:");
		sb.append(t.getFill());
		sb.append(";stroke:");
		sb.append(t.getStroke_color());
		sb.append(";stroke-width:");
		sb.append(t.getStroke_width());
		sb.append("\" />");
		System.out.println(sb);
		
		return sb.toString();
		
	}
	
	/**
	 * creates an SVG text format for a triangle
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String makeSvgTriangle(Triangle t) throws Exception{
		
//		String svg = "<triangle points: =";
		StringBuilder sb = new StringBuilder();
		sb.append("<polygon points=\"");
		sb.append(t.getxCoordinates().get(0));
		sb.append(",");
		sb.append(t.getyCoordinates().get(0));
		sb.append(",");
		sb.append(t.getxCoordinates().get(1));
		sb.append(",");
		sb.append(t.getyCoordinates().get(1));
		sb.append(",");
		sb.append(t.getxCoordinates().get(2));
		sb.append(",");
		sb.append(t.getyCoordinates().get(2));
		sb.append("\"style=\"fill:");
		sb.append(t.getFill());
		sb.append(";stroke:");
		sb.append(t.getStroke_color());
		sb.append(";stroke-width:");
		sb.append(t.getStroke_width());
		sb.append("\" />");
		System.out.println(sb);
		
		return sb.toString();
	}
	
	/**
	 * creates an SVG text format for a line
	 * @param l
	 * @return
	 * @throws Exception
	 */
	public String makeSvgLine(Line l) throws Exception {

		double x1=l.getxCoordinates().get(0);
		double x2=l.getxCoordinates().get(1);
		double y1=l.getyCoordinates().get(0);
		double y2=l.getyCoordinates().get(1);
	
		String svg = "<line x1=\"" + x1 +
					 "\" y1=\"" + y1 +
					 "\" x2=\"" + x2 +
					 "\" y2=\"" + y2 +
					 "\" style=\"stroke:" + l.getStroke_color() + 
					 ";stroke-width:" + l.getStroke_width() + "  \" />\n" ;
		
		return svg;		
	}
	
	/**
	 * creates an SVG text format for an ellipse
	 * @param e
	 * @return
	 * @throws Exception
	 */
	public String makeSvgEllipse(Ellipse e) throws Exception { 
		
		double cx=e.getxCoordinates().get(0);
		double cy=e.getyCoordinates().get(0);
		double rx=e.getxCoordinates().get(1);
		double ry=e.getyCoordinates().get(1);
		
		String svg = "<ellipse cx=\"" + cx + 
				     "\" cy=\"" + cy + 
				     "\" rx=\"" + rx + 
				     "\" ry=\"" + ry + 
				     "\"\n" + 
				     "style=\"fill:" + e.getFill() +
				     ";stroke:" + e.getStroke_color() +
				     ";stroke-width: " + e.getStroke_width() +  " \" />\n" ;

		return svg;
	}
	
	/**
	 * creates an SVG text format for a text
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public String makeSvgText(Text t) throws Exception{
		String svg = "<text x=\""
				+ t.getxCoordinates().get(0) + 
				" \" y=\""
				+ t.getyCoordinates().get(0) +
				" \" fill= \"" 
				+ t.getFill() + 
				" \" transform=\"rotate(" 
				+ t.getRotation() +  
				", "
				+ t.getxCoordinates().get(0) +
				", "
				+ t.getyCoordinates().get(0) +
				")\" >" 
				+ t.getText() + "</text>" ;
		
		return svg;
	}
	
	/**
	 * creates an SVG text format for a polygon (penta to decagon)
	 * @param p
	 * @return
	 * @throws Exception
	 */
	public String makeSvgPolygon(Polygon p) throws Exception{
		
		if(p.getxCoordinates().get(9) != null && p.getyCoordinates().get(9) != null) {
			String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " 
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " 	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " 
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " 
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + " " 
					+ p.getxCoordinates().get(5) +
				"," + p.getyCoordinates().get(5) + " " 
					+ p.getxCoordinates().get(6) +
				"," + p.getyCoordinates().get(6) + " " 	
					+ p.getxCoordinates().get(7) +
				"," + p.getyCoordinates().get(7) + " "
					+ p.getxCoordinates().get(8) +
				"," + p.getyCoordinates().get(8) + " " 
					+ p.getxCoordinates().get(9) +
				"," + p.getyCoordinates().get(9) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />" 
				+ p.getName();
			
			return svg;
		}
		
		if(p.getxCoordinates().get(8) != null && p.getyCoordinates().get(8) != null) {
			String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " 
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " 	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " 
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " 
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + " " 
					+ p.getxCoordinates().get(5) +
				"," + p.getyCoordinates().get(5) + " " 
					+ p.getxCoordinates().get(6) +
				"," + p.getyCoordinates().get(6) + " " 	
					+ p.getxCoordinates().get(7) +
				"," + p.getyCoordinates().get(7) + " "
					+ p.getxCoordinates().get(8) +
				"," + p.getyCoordinates().get(8) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />" 
				+ p.getName();
			
			return svg;
		}
		
		if(p.getxCoordinates().get(7) != null && p.getyCoordinates().get(7) != null) {
			String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " 
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " 	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " 
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " 
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + " " 
					+ p.getxCoordinates().get(5) +
				"," + p.getyCoordinates().get(5) + " " 
					+ p.getxCoordinates().get(6) +
				"," + p.getyCoordinates().get(6) + " " 	
					+ p.getxCoordinates().get(7) +
				"," + p.getyCoordinates().get(7) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />" 
				+ p.getName();
			
			return svg;
		}
		
		if(p.getxCoordinates().get(6) != null && p.getyCoordinates().get(6) != null) {
			String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " 
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " 	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " 
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " 
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + " " 
					+ p.getxCoordinates().get(5) +
				"," + p.getyCoordinates().get(5) + " " 
					+ p.getxCoordinates().get(6) +
				"," + p.getyCoordinates().get(6) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />" 
				+ p.getName();
			
			return svg;
		}
		
		if(p.getxCoordinates().get(5) != null && p.getyCoordinates().get(5) != null) {
			String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " 
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " 	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " 
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " 
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + " " 
					+ p.getxCoordinates().get(5) +
				"," + p.getyCoordinates().get(5) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />"  
				+ p.getName();
			
			return svg;
		}
		
		String svg = "<polygon points=\""
					+ p.getxCoordinates().get(0) +
				"," + p.getyCoordinates().get(0) + " " +
					+ p.getxCoordinates().get(1) +
				"," + p.getyCoordinates().get(1) + " " +	
					+ p.getxCoordinates().get(2) +
				"," + p.getyCoordinates().get(2) + " " +
					+ p.getxCoordinates().get(3) +
				"," + p.getyCoordinates().get(3) + " " +
					+ p.getxCoordinates().get(4) +
				"," + p.getyCoordinates().get(4) + "\" " +
				"style=\"fill: " + p.getFill() +
				";stroke:" + p.getStroke_color() +
				";stroke-width:" + p.getStroke_width() + "\" />" 
				+ p.getName();
		return svg;
	}

	
	
	
	
	
	/**
	 * Creates an SVG text form of shape object
	 */
	@Override
	public String makeSVG(Shape s) throws Exception {
	
	if (s instanceof Circle)  return makeSvgCircle((Circle)s);
	if (s instanceof Line)  return makeSvgLine((Line)s);
	if (s instanceof Star)  return makeSvgStar((Star)s);
	if (s instanceof Ellipse)  return makeSvgEllipse((Ellipse)s);
	if (s instanceof Text)  return makeSvgText((Text)s);
	if (s instanceof Polygon)  return makeSvgPolygon((Polygon)s);
	if (s instanceof Triangle)  return makeSvgTriangle((Triangle)s);
	if (s instanceof Quadrangle)  return makeSvgQuadrangle((Quadrangle)s);
	
	return null;
	}
}
