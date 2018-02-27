package Servlets;
import java.io.IOException;
import java.util.ArrayList;

import ManagerShape.*;
import shapes.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IndexServlet") 
public class IndexServlet extends HttpServlet {
	HttpSession session = null;
	Layer layer = new Layer();
	int layerID = 1;

	AbstractFactory managerFactory = new ManagerCreator();
	AbstractFactory factory = new ShapeObjectCreator();


	ManagerShapeInterface manager = managerFactory.getManager(1);
	ManagerShapeInterface manager2 = managerFactory.getManager(2);
	ManagerShapeInterface manager3 = managerFactory.getManager(3);


	//ShapeObjectCreator factory = new ShapeObjectCreator();
	 
	private static final long serialVersionUID = 1L; 	
	@Override 	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 	{   	
		session=request.getSession(true);
				
		request.getRequestDispatcher("canvas.jsp").include(request, response);
		response.setContentType("text/html"); 	
		}
	
	@Override 	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 	{  
		String negmessage = null;
		try {
			layer.Attach(manager);
			layer.Attach(manager2);
			layer.Attach(manager3);
		} catch (Exception e2) {
			negmessage = "ManagerShapeInterface could not be attached!";
			e2.printStackTrace();
		}
		
		/*
		 * Just to be able to load the Graphic new without really changing anything
		 */
		if (request.getParameter("refresh")!=null);
		
		/*
		 * If move function chosen
		 */
		if (request.getParameter("moveShape")!=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			String nameMoveShape = request.getParameter("nameShape");
			double xMoveShape = Double.parseDouble(request.getParameter("xToMove"));
			double yMoveShape = Double.parseDouble(request.getParameter("yToMove"));
			try {
				layer.moveShape(layerID, nameMoveShape, xMoveShape, yMoveShape);
			} catch (Exception e) {
				negmessage = e.getMessage();
				e.printStackTrace();
			}
		}
		
		/*
		 * If delete function is called
		 */
		if (request.getParameter("deleteShape")!=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			String nameToDelete = request.getParameter("nameShapeDelete");
			try {
				layer.deleteShape(layerID, nameToDelete);
			} catch (Exception e) {
				negmessage = "Could not delete the shape! Probably shape doesn't exist!";			
				e.printStackTrace();
			}
		}
		
		
		//If add or edit button for Circle is pushed
		if (request.getParameter("addCircle")!=null || request.getParameter("editCircle")!=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape circle = null;
			try {
				String name, fill, stroke;
				if(checkEmptyRequestedParameter(name = request.getParameter("nameCircle")))
					name = null;
				double x = Double.parseDouble(request.getParameter("xCircle"));
				double y = Double.parseDouble(request.getParameter("yCircle"));
				fill = request.getParameter("fillCircle");
				double radius = Double.parseDouble(request.getParameter("radiusCircle"));
				stroke = request.getParameter("strokeCircle");
				double strokeWidth = Double.parseDouble(request.getParameter("strokewidthCircle"));
				ArrayList<Double>xcircle=new ArrayList<Double>();
				xcircle.add(x);
				ArrayList<Double>ycircle=new ArrayList<Double>();
				ycircle.add(y);
				
				if(name != null)
					circle = factory.createCircle(name,xcircle,ycircle,fill,radius,stroke,strokeWidth);
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addCircle")!= null){
				if(!addShapeCatchErrors(circle))
					negmessage = "\nCould not add circle!";
			}
				
			if (request.getParameter("editCircle")!= null){
				if(!editShapeCatchErrors(circle))
					negmessage = "\nCould not edit circle!";
			}
		}
		
	
		//If add or edit button for Star is pushed
		if (request.getParameter("addStar")!=null || request.getParameter("editStar")!=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape star = null;
			try {
				String nameStar, fillStar, strokeStar, fillRuleStar;
				if(checkEmptyRequestedParameter(nameStar = request.getParameter("nameStar")))
					nameStar = null;
				double x1 = Double.parseDouble(request.getParameter("xCoordinate1"));
				double x2 = Double.parseDouble(request.getParameter("xCoordinate2"));
				double x3 = Double.parseDouble(request.getParameter("xCoordinate3"));
				double x4 = Double.parseDouble(request.getParameter("xCoordinate4"));
				double x5 = Double.parseDouble(request.getParameter("xCoordinate5"));
				
				double y1 = Double.parseDouble(request.getParameter("yCoordinate1"));
				double y2 = Double.parseDouble(request.getParameter("yCoordinate2"));
				double y3 = Double.parseDouble(request.getParameter("yCoordinate3"));
				double y4 = Double.parseDouble(request.getParameter("yCoordinate4"));
				double y5 = Double.parseDouble(request.getParameter("yCoordinate5"));
				fillStar = request.getParameter("fillStar");
				strokeStar = request.getParameter("strokeStar");
				double strokeWitdthStar= Double.parseDouble(request.getParameter("strokeWidthStar"));
				if(checkEmptyRequestedParameter(fillRuleStar = request.getParameter("fillRule")))
					fillRuleStar = null;
				ArrayList<Double> xStar = new ArrayList<Double>();
				ArrayList<Double> yStar = new ArrayList<Double>();
				xStar.add(x1);
				xStar.add(x2);
				xStar.add(x3);
				xStar.add(x4);
				xStar.add(x5);
				yStar.add(y1);
				yStar.add(y2);
				yStar.add(y3);
				yStar.add(y4);
				yStar.add(y5);
				
				if(nameStar != null && fillRuleStar != null)
					star = factory.createStar(xStar, yStar, nameStar, fillStar, strokeStar, strokeWitdthStar, fillRuleStar); 
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addStar")!= null){
				if(!addShapeCatchErrors(star))
					negmessage = "\nCould not add star!";
			}
				
			if (request.getParameter("editStar")!= null){
				if(!editShapeCatchErrors(star))
					negmessage = "\nCould not edit star!";
			}	
		}

		
		//If add or edit button for Quadrangle is pushed
		if (request.getParameter("addQuadrangle")!=null || request.getParameter("editQuadrangle") !=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape tr = null;
			try {
				String nameQuadrangle, fillQuadrangle, stroke;
				if(checkEmptyRequestedParameter(nameQuadrangle = request.getParameter("nameQuadrangle")))
					nameQuadrangle = null;
				double x1 = Double.parseDouble(request.getParameter("x1Quadrangle"));
				double y1 = Double.parseDouble(request.getParameter("y1Quadrangle"));
				double x2 = Double.parseDouble(request.getParameter("x2Quadrangle"));
				double y2 = Double.parseDouble(request.getParameter("y2Quadrangle"));
				double x3 = Double.parseDouble(request.getParameter("x3Quadrangle"));
				double y3 = Double.parseDouble(request.getParameter("y3Quadrangle"));
				double x4 = Double.parseDouble(request.getParameter("x4Quadrangle"));
				double y4 = Double.parseDouble(request.getParameter("y4Quadrangle"));
				fillQuadrangle = request.getParameter("fillQuadrangle");
					
				stroke = request.getParameter("strokeQuadrangle");
				double strokeWitdthQuadrangle= Double.parseDouble(request.getParameter("strokeWidthQuadrangle"));
				ArrayList<Double> xQuadrangle = new ArrayList<Double>();
				ArrayList<Double> yQuadrangle = new ArrayList<Double>();
				xQuadrangle.add(x1);
				yQuadrangle.add(y1);
				xQuadrangle.add(x2);
				yQuadrangle.add(y2);
				xQuadrangle.add(x3);
				yQuadrangle.add(y3);
				xQuadrangle.add(x4);
				yQuadrangle.add(y4);
//				negmessage += nameQuadrangle + fillQuadrangle + stroke;
				if(nameQuadrangle != null)
					tr = factory.createQuadrangle(nameQuadrangle, xQuadrangle, yQuadrangle, fillQuadrangle, stroke, strokeWitdthQuadrangle); 
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addQuadrangle")!= null){
				if(!addShapeCatchErrors(tr))
					negmessage += "\nCould not add quadrangle!";
			}
				
			if (request.getParameter("editQuadrangle")!= null){
				if(!editShapeCatchErrors(tr))
					negmessage += "\nCould not edit quadrangle!";
			}	
		}
		
		//If add or edit button for Line is pushed
		if(request.getParameter("addLine")!=null || request.getParameter("editLine")!=null) {
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape s = null;
			try {
				String name, stroke_color;
				if(checkEmptyRequestedParameter(name = request.getParameter("nameLine")))
					name = null;
				double x1=Double.parseDouble(request.getParameter("x1Line"));
				double x2=Double.parseDouble(request.getParameter("x2Line"));
				double y1=Double.parseDouble(request.getParameter("y1Line"));
				double y2=Double.parseDouble(request.getParameter("y2Line"));
				stroke_color=request.getParameter("stroke_colorLine");
				double stroke_width=Double.parseDouble(request.getParameter("strokewidthLine"));
				ArrayList<Double>xCoordinates= new ArrayList<Double>();
				xCoordinates.add(x1);
				xCoordinates.add(x2);
				ArrayList<Double>yCoordinates=new ArrayList<Double>();
				yCoordinates.add(y1);
				yCoordinates.add(y2);
				if(name != null)
					s = factory.createLine(name,xCoordinates,yCoordinates,stroke_color, stroke_width); 
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addLine")!= null){
				if(!addShapeCatchErrors(s))
					negmessage = "\nCould not add line!";
			}
				
			if (request.getParameter("editLine")!= null){
				if(!editShapeCatchErrors(s))
					negmessage = "\nCould not edit line!";
			}
		}
		
		//If add or edit button for Triangle is pushed
		if (request.getParameter("addTriangle")!=null || request.getParameter("editTriangle") !=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape tr = null;
			try {
				String nameTriangle, fillTriangle, stroke;
				if(checkEmptyRequestedParameter(nameTriangle = request.getParameter("nameTriangle")))
					nameTriangle = null;
				double x1 = Double.parseDouble(request.getParameter("x1Triangle"));
				double y1 = Double.parseDouble(request.getParameter("y1Triangle"));
				double x2 = Double.parseDouble(request.getParameter("x2Triangle"));
				double y2 = Double.parseDouble(request.getParameter("y2Triangle"));
				double x3 = Double.parseDouble(request.getParameter("x3Triangle"));
				double y3 = Double.parseDouble(request.getParameter("y3Triangle"));
				fillTriangle = request.getParameter("fillTriangle");
				double strokeWitdthTriangle= Double.parseDouble(request.getParameter("strokeWidthTriangle"));
				stroke = request.getParameter("stroke");
				ArrayList<Double> xTriangle = new ArrayList<Double>();
				ArrayList<Double> yTriangle = new ArrayList<Double>();
				xTriangle.add(x1);
				yTriangle.add(y1);
				xTriangle.add(x2);
				yTriangle.add(y2);
				xTriangle.add(x3);
				yTriangle.add(y3);
				
				if(nameTriangle != null)
					tr = factory.createTriangle(nameTriangle, xTriangle, yTriangle, fillTriangle, stroke, strokeWitdthTriangle);
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addTriangle")!= null){
				if(!addShapeCatchErrors(tr))
					negmessage = "\nCould not add triangle!";
			}
				
			if (request.getParameter("editTriangle")!= null){
				if(!editShapeCatchErrors(tr))
					negmessage = "\nCould not edit triangle!";
			}
		}
		
		//If add or edit button for Ellipse is pushed
		if(request.getParameter("addEllipse")!=null || request.getParameter("editEllipse")!=null) {
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape s = null;
			try {
				String name, fill, stroke_color;
				if(checkEmptyRequestedParameter(name = request.getParameter("nameEllipse")))
					name = null;
				double x1=Double.parseDouble(request.getParameter("cxEllipse"));
				double y1=Double.parseDouble(request.getParameter("cyEllipse"));
				double x2=Double.parseDouble(request.getParameter("rxEllipse"));
				double y2=Double.parseDouble(request.getParameter("ryEllipse"));
				stroke_color = request.getParameter("stroke_colorEllipse");
				double stroke_width = Double.parseDouble(request.getParameter("strokewidthEllipses"));
				fill = request.getParameter("fillEllipses");
				ArrayList<Double>xCoordinates= new ArrayList<Double>();
				xCoordinates.add(x1);
				xCoordinates.add(x2);
				ArrayList<Double>yCoordinates=new ArrayList<Double>();
				yCoordinates.add(y1);
				yCoordinates.add(y2);
				
				if(name != null && fill != null && stroke_color != null)
					s = factory.createEllipse(name, xCoordinates, yCoordinates, stroke_color, stroke_width, fill); 
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addEllipse")!= null){
				if(!addShapeCatchErrors(s))
					negmessage += "\nCould not add ellipse!";
			}
				
			if (request.getParameter("editEllipse")!= null){
				if(!editShapeCatchErrors(s))
					negmessage += "\nCould not edit ellipse!";
			}	
		}
		
		//If add or edit button for Polygon is pushed
		if (request.getParameter("addPolygon")!=null || request.getParameter("editPolygon") !=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape tr = null;
			try {
				String namePolygon, fillPolygon, stroke;
				if(checkEmptyRequestedParameter(namePolygon = request.getParameter("namePolygon")))
					namePolygon = null;
				double x1 = Double.parseDouble(request.getParameter("x1Polygon"));
				double y1 = Double.parseDouble(request.getParameter("y1Polygon"));
				double x2 = Double.parseDouble(request.getParameter("x2Polygon"));
				double y2 = Double.parseDouble(request.getParameter("y2Polygon"));
				double x3 = Double.parseDouble(request.getParameter("x3Polygon"));
				double y3 = Double.parseDouble(request.getParameter("y3Polygon"));
				double x4 = Double.parseDouble(request.getParameter("x4Polygon"));
				double y4 = Double.parseDouble(request.getParameter("y4Polygon"));
				double x5 = Double.parseDouble(request.getParameter("x5Polygon"));
				double y5 = Double.parseDouble(request.getParameter("y5Polygon"));
				
				String x6 = request.getParameter("x6Polygon");
				if(checkEmptyRequestedParameter(x6))
					x6 = null;
				String y6 = request.getParameter("y6Polygon");
				if(checkEmptyRequestedParameter(y6))
					y6 = null;
				String x7 = request.getParameter("x7Polygon");
				if(checkEmptyRequestedParameter(x7))
					x7 = null;
				String y7 = request.getParameter("y7Polygon");
				if(checkEmptyRequestedParameter(y7))
					y7 = null;
				String x8 = request.getParameter("x8Polygon");
				if(checkEmptyRequestedParameter(x8))
					x8 = null;
				String y8 = request.getParameter("y8Polygon");
				if(checkEmptyRequestedParameter(y8))
					y8 = null;
				String x9 = request.getParameter("x9Polygon");
				if(checkEmptyRequestedParameter(x9))
					x9 = null;
				String y9 = request.getParameter("y9Polygon");
				if(checkEmptyRequestedParameter(y9))
					y9 = null;
				String x10 = request.getParameter("x10Polygon");
				if(checkEmptyRequestedParameter(x10))
					x10 = null;
				String y10 = request.getParameter("y10Polygon");
				if(checkEmptyRequestedParameter(y10))
					y10 = null;
				
				fillPolygon = request.getParameter("fillPolygon");
				stroke = request.getParameter("strokePolygon");
				double strokeWitdthPolygon = Double.parseDouble(request.getParameter("strokeWidthPolygon"));
					
				ArrayList<Double> xPolygon = new ArrayList<Double>();
				ArrayList<Double> yPolygon = new ArrayList<Double>();
				
				xPolygon.add(x1);
				yPolygon.add(y1);
				xPolygon.add(x2);
				yPolygon.add(y2);
				xPolygon.add(x3);
				yPolygon.add(y3);
				xPolygon.add(x4);
				yPolygon.add(y4);
				xPolygon.add(x5);
				yPolygon.add(y5);
				
				if(x6 != null)
					xPolygon.add(Double.parseDouble(x6));
				if(y6 != null)
					yPolygon.add(Double.parseDouble(y6));
				if(x7 != null)
					xPolygon.add(Double.parseDouble(x7));
				if(y7 != null)
					yPolygon.add(Double.parseDouble(y7));
				if(x8 != null)
					xPolygon.add(Double.parseDouble(x8));
				if(y8 != null)
					yPolygon.add(Double.parseDouble(y8));
				if(x9 != null)
					xPolygon.add(Double.parseDouble(x9));
				if(y9 != null)
					yPolygon.add(Double.parseDouble(y9));
				if(x10 != null)
					xPolygon.add(Double.parseDouble(x10));
				if(y10 != null)
					yPolygon.add(Double.parseDouble(y10));
				
				negmessage += namePolygon + fillPolygon + stroke;
				if(namePolygon != null)
					tr = factory.createPolygon(xPolygon, yPolygon, namePolygon, fillPolygon, stroke, strokeWitdthPolygon);
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addPolygon")!= null){
				if(!addShapeCatchErrors(tr))
					negmessage += "\nCould not add polygon!";
			}
				
			if (request.getParameter("editPolygon")!= null){
				if(!editShapeCatchErrors(tr))
					negmessage += "\nCould not edit polygon!";
			}		
		}
	
		
		// Add or edit button for text is pushed
		if (request.getParameter("addText")!=null || request.getParameter("editText") !=null){
			String layerValue = request.getParameter("editLayer");
			layerID = checkChosenLayer(layerValue);
			
			Shape tr = null;
			try {
				String nameText, fillText, textText;
				if(checkEmptyRequestedParameter(nameText = request.getParameter("nameText")))
					nameText = null;
				double x1 = Double.parseDouble(request.getParameter("x1Text"));
				double y1 = Double.parseDouble(request.getParameter("y1Text"));
				fillText = request.getParameter("fillText");
				double rotation = Double.parseDouble(request.getParameter("rotation"));
				if(checkEmptyRequestedParameter(textText = request.getParameter("textText")))
					textText = null;
					
				ArrayList<Double> xText = new ArrayList<Double>();
				ArrayList<Double> yText = new ArrayList<Double>();
				xText.add(x1);
				yText.add(y1);
				
				if(nameText != null && textText != null)
					tr = factory.createText(nameText, xText, yText, fillText, rotation, textText);
			} catch (NumberFormatException e) {
				negmessage = "Please insert valid numbers (e.g. 2 | 22.0)!";
				e.printStackTrace();
			}
			
			if (request.getParameter("addText")!= null){
				if(!addShapeCatchErrors(tr))
					negmessage = "\nCould not add text!";
			}
				
			if (request.getParameter("editText")!= null){
				if(!editShapeCatchErrors(tr))
					negmessage = "\nCould not edit text!";
			}
		}
		


		String[] selectedLayers = request.getParameterValues("visibleLayer");
		
		String svg = "";
		
		svg = getSVG(selectedLayers);
		
		/**
		 * SVG is created and saved in session.
		 */
		session.setAttribute("svg", svg);

		if (request.getParameter("createSvg")!=null){
			String filename=manager.createSvgFile(svg);

			response.setContentType("text/html");
			   response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

			manager.downloadSvgFile(response.getWriter(),filename);
		}

		/**
		 * It groups by the figures by type (for example by Ellipse or by Line etc)
		 */
		if (request.getParameter("groupByType")!=null){
			String typeOfShape=request.getParameter("TypeOfShape");
			String svg_group_by=" ";

			try {
				for(int i = 0; i < selectedLayers.length; i++) {
					if(selectedLayers[i].equals("layer1"))
						svg_group_by = svg_group_by + layer.managerShapes.get(0).createWholeSvg(layer.managerShapes.get(0).groupByType(typeOfShape));
					if(selectedLayers[i].equals("layer2"))
						svg_group_by = svg_group_by + layer.managerShapes.get(1).createWholeSvg(layer.managerShapes.get(1).groupByType(typeOfShape));
					if(selectedLayers[i].equals("layer3"))
						svg_group_by = svg_group_by + layer.managerShapes.get(2).createWholeSvg(layer.managerShapes.get(2).groupByType(typeOfShape));
				}
			}catch (NullPointerException e){
				System.out.println("ArrayList wurde nicht initiealisiert_groupBy_type");
			}


			String filename=manager.createSvgFile(svg_group_by);

			response.setContentType("text/html");
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

			manager.downloadSvgFile(response.getWriter(),filename);
		}

		request.setAttribute("message", negmessage);
		request.getRequestDispatcher("canvas.jsp").include(request, response);
		response.setContentType("text/html"); 	
	} 	
	
	private boolean checkEmptyRequestedParameter(String requestedParameter){
		if(requestedParameter == "")
			return true;
		return false;
	}
	
	private int checkChosenLayer(String layerValue){
		if(layerValue.equals("layer1"))
			return 1;
		if(layerValue.equals("layer2"))
			return 2;
		if(layerValue.equals("layer3"))
			return 3;
		return 1; // default layer
	}
	
	private String getSVG(String[] selectedLayers) {
		String svg = "";
		try {
			for(int i = 0; i < selectedLayers.length; i++) {
				if(selectedLayers[i].equals("layer1"))
					svg = svg + layer.managerShapes.get(0).createWholeSvg(layer.managerShapes.get(0).getAllShapes());
				if(selectedLayers[i].equals("layer2"))
					svg = svg + layer.managerShapes.get(1).createWholeSvg(layer.managerShapes.get(1).getAllShapes());
				if(selectedLayers[i].equals("layer3"))
					svg = svg + layer.managerShapes.get(2).createWholeSvg(layer.managerShapes.get(2).getAllShapes());	
			}
		}catch (NullPointerException e){
		 	e.printStackTrace();
		}
		return svg;
	}
	
	private boolean addShapeCatchErrors(Shape shape) {
		try {
			layer.addShape(layerID, shape);
			return true;
		}catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	private boolean editShapeCatchErrors(Shape shape) {
		try {
			layer.editShape(layerID, shape);
			return true;
		}catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
}