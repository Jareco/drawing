<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<html>
<%
	String g = null;
	g=(String)session.getAttribute("svg");
%>
<h1 align=center>Graphic</h1>

<p>Message: ${message}</p>

<center><svg width="500" height="500">
<% if(g!=null){ %>
<%=g  %>

<% } %>

</svg></center>

<form action="IndexServlet" method="POST" accept-charset=utf-8> 
<fieldset>
    <p>Choose a layer to edit:</p> 
    <input type="radio" id="layer1" name="editLayer" value="layer1" checked> 
    <label for="layer1"> Layer 1 </label> 
    <input type="radio" id="layer2" name="editLayer" value="layer2"> 
    <label for="layer2"> Layer 2 </label> 
    <input type="radio" id="layer3" name="editLayer" value="layer3"> 
    <label for="layer3"> Layer 3 </label>
    </br>
    <p>Choose layers to show (only checked layers will used for "Create SVG" and "Create SVG - by Type"):</p>
    <label> 
    <input type="checkbox" name="visibleLayer" value="layer1" id="check1" checked> Layer 1 
    </label>
    <label> 
    <input type="checkbox" name="visibleLayer" value="layer2" id="check2" checked> Layer 2 
    </label>
    <label> 
    <input type="checkbox" name="visibleLayer" value="layer3" id="check3" checked> Layer 3 
    </label>
    <input type="submit" name="refresh" value="Refresh Graphic" /></td>
	</br>
	</br>
	
	<tr class="active">
		<td><input type="submit" name="createSvg" value="Create SVG" /></td>
	</tr>
	</br>
	</br>
	
	<tr class="active">
		<td><select name="TypeOfShape">
			<option value="cirle">Circle</option>
			<option value="ellipse">Ellipse</option>
			<option value="line">Line</option>
			<option value="polygon">Polygon</option>
			<option value="quadrangle">Quadrangle</option>
			<option value="star">Star</option>
			<option value="text">Text</option>
			<option value="triange">Triangle</option>

		</select></td>
		<td><input type="submit" name="groupByType" value="Create SVG - by Type" /></td>
	</tr>
	</br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameShapeDelete"	placeholder="Name of Shape"  size="15"/></td> 
		<td><input type="submit" name="deleteShape" value="Delete" /></td>
	</tr>
    </br>
	</br>	
		
	<tr class="active">
		<td><input type="text" name="nameShape"	placeholder="Name of Shape"  size="15"/></td> 
		<td><input type="text" name="xToMove" 	placeholder="x to move" size="15"/></td> 
		<td><input type="text" name="yToMove" 	 placeholder="y to move" size="15"/></td> 
		<td><input type="submit" name="moveShape" value="Move" /></td>
	</tr>
	</br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameCircle"  	placeholder="Circle's name"	 size="15"/></td> 
		<td><input type="text" name="xCircle" placeholder="x coordinate"	 size="15"/></td> 
		<td><input type="text" name="yCircle"   placeholder="y coordinate"  size="15"/></td> 
		<td><input type="text" name="radiusCircle"	placeholder="radius"  size="15"/></td> 
		
		<td>Shape color:<input type="color" name="fillCircle"></td> 
		<td>Stroke color:<input type="color" name="strokeCircle"></td> 
		<td><input type="text" name="strokewidthCircle" 	 placeholder="Stroke width" size="15"/></td> 
		
		<td><input type="submit" name="addCircle" 	value="Add" /></td>
		<td><input type="submit" name="editCircle" 	value="Edit" /></td>
	</tr>
    </br>
	</br>
		
	<tr class="active">
		<td><input type="text" name="nameStar"  placeholder="Star's name" size="15"/></td> 
		<td><input type="text" name="xCoordinate1" 	value="100" size="5"/></td> 
		<td><input type="text" name="yCoordinate1"    value="10" size="5"/></td> 
		<td><input type="text" name="xCoordinate2"    value="40" size="5"/></td> 
		<td><input type="text" name="yCoordinate2"    value="198" size="5"/></td> 
		<td><input type="text" name="xCoordinate3"    value="190" size="5"/></td> 
		<td><input type="text" name="yCoordinate3"    value="78" size="5"/></td>
		<td><input type="text" name="xCoordinate4"    value="10" size="5"/></td>
		<td><input type="text" name="yCoordinate4"    value="78" size="5"/></td>
		<td><input type="text" name="xCoordinate5"    value="160" size="5"/></td>
		<td><input type="text" name="yCoordinate5"    value="198" size="5"/></td>
	
		<td>Shape color:<input type="color" name="fillStar"></td> 
		<td>Stroke color:<input type="color" name="strokeStar"></td>  
		<td><input type="text" name="strokeWidthStar" 	placeholder="Stroke-width"   size="15"/></td> 
		<td><input type="text" name="fillRule" 	value="nonzero"   size="15"/></td>
		
		<td><input type="submit" name="addStar" value="Add" /></td>
		<td><input type="submit" name="editStar" 	value="Edit" /></td>
	</tr>
	</br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameLine"  			    placeholder="Line's name"	 size="15"/></td> 
		<td><input type="text" name="x1Line" 			   	placeholder="x1 coordinate"	 size="15"/></td> 
		<td><input type="text" name="y1Line"  				placeholder="y1 coordinate"  size="15"/></td>
		<td><input type="text" name="x2Line" 				placeholder="x2 coordinate"	 size="15"/></td> 
		<td><input type="text" name="y2Line"  				placeholder="y2 coordinate"  size="15"/></td>  
		
		<td>Stroke color:<input type="color" name="stroke_colorLine"></td>  
		<td><input type="text" name="strokewidthLine"        placeholder="Stroke width (number)" size="15"/></td> 
		<td><input type="submit" name="addLine" 	value="Add" /></td>
		<td><input type="submit" name="editLine" 	value="Edit" /></td>
	</tr>
    </br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameEllipse"  			    placeholder="Ellipse's name"	 size="15"/></td> 
		<td><input type="text" name="cxEllipse" 			   	placeholder="cx coordinate"	 size="15"/></td> 
		<td><input type="text" name="cyEllipse"  				placeholder="cy coordinate"  size="15"/></td>
		<td><input type="text" name="rxEllipse" 				placeholder="rx coordinate"	 size="15"/></td> 
		<td><input type="text" name="ryEllipse"  				placeholder="ry coordinate"  size="15"/></td>  
		
		<td>Shape color:<input type="color" name="fillEllipses"></td> 
		<td>Stroke color:<input type="color" name="stroke_colorEllipse"></td> 
		<td><input type="text" name="strokewidthEllipses"       placeholder="Stroke width (number)" size="15"/></td>
		
		<td><input type="submit" name="addEllipse" 	value="Add" /></td>
		<td><input type="submit" name="editEllipse" 	value="Edit" /></td>
	</tr>
    </br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameTriangle"  placeholder="Triangle's name" size="15"/></td> 
		<td><input type="text" name="x1Triangle" placeholder="x1"	size="5"/></td> 
		<td><input type="text" name="y1Triangle" placeholder="y1"  size="5"/></td> 
		<td><input type="text" name="x2Triangle" placeholder="x2"  size="5"/></td> 
		<td><input type="text" name="y2Triangle" placeholder="y2"  size="5"/></td> 
		<td><input type="text" name="x3Triangle" placeholder="x3"  size="5"/></td> 
		<td><input type="text" name="y3Triangle" placeholder="y3"  size="5"/></td>
		
		<td>Shape color:<input type="color" name="fillTriangle"></td> 
		<td>Stroke color:<input type="color" name="strokeTriangle"></td>
		<td><input type="text" name="strokeWidthTriangle" 		placeholder="Width" size="15"/></td>
			
		<td><input type="submit" name="addTriangle" value="Add" /></td>
		<td><input type="submit" name="editTriangle" 	value="Edit" /></td>
	</tr>
    </br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="nameQuadrangle"  placeholder="Quadrangle's name" size="15"/></td> 
		<td><input type="text" name="x1Quadrangle"     placeholder="x1"	 size="5"/></td> 
		<td><input type="text" name="y1Quadrangle"     placeholder="y1"     size="5"/></td> 
		<td><input type="text" name="x2Quadrangle"     placeholder="x2"     size="5"/></td> 
		<td><input type="text" name="y2Quadrangle"     placeholder="y2"     size="5"/></td> 
		<td><input type="text" name="x3Quadrangle"     placeholder="x3"     size="5"/></td> 
		<td><input type="text" name="y3Quadrangle"     placeholder="y3"     size="5"/></td>
		<td><input type="text" name="x4Quadrangle"     placeholder="x4"     size="5"/></td> 
		<td><input type="text" name="y4Quadrangle"     placeholder="y4"     size="5"/></td>
	
		<td>Shape color:<input type="color" name="fillQuadrangle"></td> 
		<td>Stroke color:<input type="color" name="strokeQuadrangle"></td>
		<td><input type="text" name="strokeWidthQuadrangle" 		placeholder="Width" size="15"/></td>
		
		<td><input type="submit" name="addQuadrangle" value="Add" /></td>
		<td><input type="submit" name="editQuadrangle" 	value="Edit" /></td>
	</tr>
    </br>
	</br>
	
	<tr class="active">
		<td><input type="text" name="namePolygon"	placeholder="Polygon's name" size="15"/></td> 
		<td><input type="text" name="x1Polygon"     placeholder=" x1 "		size="5"/></td> 
		<td><input type="text" name="y1Polygon"     placeholder=" y1 "     size="5"/></td> 
		<td><input type="text" name="x2Polygon"     placeholder=" x2 "     size="5"/></td> 
		<td><input type="text" name="y2Polygon"     placeholder=" y2 "     size="5"/></td> 
		<td><input type="text" name="x3Polygon"     placeholder=" x3 "     size="5"/></td> 
		<td><input type="text" name="y3Polygon"     placeholder=" y3 "     size="5"/></td>
		<td><input type="text" name="x4Polygon"     placeholder=" x4 "     size="5"/></td> 
		<td><input type="text" name="y4Polygon"     placeholder=" y4 "     size="5"/></td>
		<td><input type="text" name="x5Polygon"     placeholder=" x5 "	    size="5"/></td> 
		<td><input type="text" name="y5Polygon"     placeholder=" y5 "     size="5"/></td>
		<td>additional values for</td></br> <td>Hexagon:</td>
		<td><input type="text" name="x6Polygon"     placeholder=" x6 "	size="5"/></td> 
		<td><input type="text" name="y6Polygon"     placeholder=" y6 "	size="5"/></td> 
		<td>Heptagon:</td>
		<td><input type="text" name="x7Polygon"     placeholder=" x7 "	size="5"/></td> 
		<td><input type="text" name="y7Polygon"     placeholder=" y7 "	size="5"/></td>
		<td>Octagon:</td>
		<td><input type="text" name="x8Polygon"     placeholder=" x8 "	size="5"/></td> 
		<td><input type="text" name="y8Polygon"     placeholder=" y8 "	size="5"/></td> 
		<td>Nonagon:</td>
		<td><input type="text" name="x9Polygon"     placeholder=" x9 "	size="5"/></td> 
		<td><input type="text" name="y9Polygon"     placeholder=" y9 "	size="5"/></td>
		<td>Decagon:</td>
		<td><input type="text" name="x10Polygon"    placeholder=" x10 "	size="5"/></td> 
		<td><input type="text" name="y10Polygon"    placeholder=" y10 "	size="5"/></td>
		</br>
		<td>Shape color:<input type="color" name="fillPolygon"></td> 
		<td>Stroke color:<input type="color" name="strokePolygon"></td> 
		<td><input type="text" name="strokeWidthPolygon" 	placeholder="Stroke-width"   size="15"/></td> 
		<td><input type="submit" name="addPolygon" 	value="Add" /></td>
		<td><input type="submit" name="editPolygon" value="Edit" /></td>
	</tr>
    </br>
    </br>
    
	<tr class="active">
		<td><input type="text" name="nameText"  placeholder="Text's name" size="15"/></td> 			
		<td><input type="text" name="x1Text" 	placeholder="x Coordinate"	size="15"/></td> 
		<td><input type="text" name="y1Text"    placeholder="y Coordinate"	size="15"/></td>

		<td>Shape color:<input type="color" name="fillText"></td> 
		<td><input type="text" name="rotation" 		placeholder="rotation" size="15"/></td>
		<td><input type="text" name="textText" 		placeholder="Your text!" size="15"/></td>
		<td><input type="submit" name="addText" 	value="Add" /></td>
		<td><input type="submit" name="editText" 	value="Edit" /></td>
	</tr>
</fieldset>
</form>
		
</html>