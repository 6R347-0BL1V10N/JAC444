/**
 * @author Brian Fournier (101 451 169)
 * 
 * This class Point acts as an X and Y coordinates that will be used by Shape types.<br>
 * @see Line
 * @see Circle
 * @see Rectangle
 * 
 * Point is Parent to the LabeledPoint Class which adds a Label to each Point.<br>
 * @see LabeledPoint
 */
package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)
 *
 * Point class Info:<br>
 * -protected double X<br>
 * -protected double Y<br>
 * -0 parameter constructor<br>
 * -2 parameter constructor<br>
 * -getX getter<br>
 * -getY getter<br>
 * -3 overridden methods:<br>
 * 		-toString()<br>
 * 		-equals()<br>
 * 		-hashCode()<br>
 */
public class Point {
	protected double x = 0.0;
	protected double y = 0.0;
	
	/**
	 * Sets x and y member variables to 0.0.<br>
	 */
	public Point()
	{
		x = 0.0;
		y = 0.0;
	}
	
	/**
	 * Assigns x and y member variables to passes parameter's values.<br>
	 * @param _x x coordinate.
	 * @param _y y coordinate.
	 */
	public Point(double _x, double _y)
	{
		x = _x;
		y = _y;
	}
	
	/**
	 * Returns x member variable value.<br>
	 * @return x member variable.
	 */
	public double getX()
	{
		return x;
	}
	/**
	 * Returns y member variable value.<br>
	 * @return y member variable.
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Overridden toString() method.<br>
	 * @return returns x and y member variable's values with String representation.
	 */
	public String toString()
	{
		return "Center:\nX: " + getX() + "\nY: " + getY();
	}
	
	/**
	 * Overridden equals() method that takes in a Point parameter and returns a boolean.<br>
	 * if ~this~ == parameter P, return true, else, return false.<br>
	 * @param P Point object.<br>
	 * @see Point
	 * @return boolean type
	 */
	public boolean equals(Point P)
	{
		if(this.getX() == P.getX() &&
			this.getY() == P.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Overridden hashCode() method.<br>
	 * @return unique integer that represent an object ID.<br>
	 */
	public int hashCode()
	{
		int hash = 0;
		
		hash += 31 * hash + getX();
		hash += 31 * hash + getY();
		
		return hash;
	}
}
