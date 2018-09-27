package jac444.wk2;

/**
 * 
 * @author Brian Fournier (101 451 169)<br>
 * Rectangle class extends Shape class and implements Measurable<br>
 * @see Shape
 * @see Measurable
 * Rectangle class info:<br>
 * -LabeledPoint Rpoint object that holds a label and x and y coordinates - @see Point @see LabeledPoint<br>
 * -double width<br>
 * -double height is the 'Length' of a Rectangle object<br>
 * -3 parameter constructor<br>
 * -getCentre() method - @see Shape<br>
 */
public class Rectangle extends Shape implements Measurable{
	double width;
	double height;
	LabeledPoint Rpoint;

	/**
	 * 3 parameter constructor assigns 
	 * @param topLeft holds x and y coordinates for Rpoint member object
	 * @param _width holds the width of a Rectangle object 
	 * @param _hight holds the length of a Rectangle object
	 */
	public Rectangle(Point topLeft, double _width, double _height) {
		Rpoint = new LabeledPoint("Rectangle" + this.hashCode(), topLeft.getX(), topLeft.getY());
		width = _width;
		height = _height;
	}
	
	/**
	 * @see Shape#getCentre()
	 */
	Point getCentre()
	{
		LabeledPoint centre = new LabeledPoint();
		centre.Label = Rpoint.getLabel();
		centre.x = Rpoint.getX();
		centre.y = Rpoint.getY();
		
		centre.x += width / 2;
		centre.y -= height / 2;
		
		return centre;
	}
	
	public String getArea()
	{
		double area = height * width;
		return "Area of Rectangle : " + area;
	}
}
