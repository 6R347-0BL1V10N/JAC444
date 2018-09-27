/**
 * @author Brian Fournier (101 451 169)
 * 
 */
package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * Circle extends Shape class and implements Measurable Interface.<br>
 * @see Shape
 * @see Measurable
 * <br>
 * Circle class info:
 * -Point Cpoint object<br>
 * -double radius<br>
 * -2 parameter constructor<br>
 * -getCenter() method<br>
 * -getArea() method<br>
 * 
 */

public class Circle extends Shape implements Measurable {
	LabeledPoint Cpoint;
	double radius;

	/**
	 * Assigns radius value and initializes Cpoint object.<br>
	 * @param centre Point object with x and y coordinates.<br>
	 * @param _radius double value.<br>
	 */
	public Circle(Point centre, double _radius) {
		Cpoint = new LabeledPoint("Circle" + this.hashCode(), centre.getX(),centre.getY());
		radius = _radius;
	}
	
	/**
	 * @return Cpoint Point object with x and y coordinate that represents the center of a circle object.<br>
	 */
	Point getCentre()
	{
		return Cpoint;
	}
	
	/**
	 * @return String that represents the area of a circle (Units Squared).<br>
	 */
	public String getArea()
	{
		double Temp = Math.PI * Math.pow(radius, 2);
		return "Area of Circle: " + Temp + " Units Squared.";
	}
}
