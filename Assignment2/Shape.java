/**
 * @author Brian Fournier (101 451 169)<br>
 */
package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * Shape is an abstract Class.<br>
 * Shape class info:<br>
 * -Point P member<br>
 * -0 parameter constructor<br>
 * -moveBy method with 2 parameters<br>
 * -declaration of getCentre() method<br>
 */
public abstract class Shape {
	LabeledPoint LP;
	
	/**
	 * 0 parameter constructor that initializes Point P member.<br>
	 */
	public Shape()
	{
		LP = new LabeledPoint();
	}
	
	/**
	 * moveBy method will act as a point movement ie..:<br>
	 * have an xy coordinate of 2,3 and moveBy(1,1) will result in xy being 3,4.<br>
	 * @param dx value to move x by.
	 * @param dy value to move y by.
	 */
	public void moveBy(double dx, double dy)
	{
		LP.x += dx;
		LP.y += dy;
	}
	
	/**
	 * declaration of getCentre() method that will return a Point Object.<br>
	 * @return Point Object with x and y coordinates.<br>
	 */
	abstract Point getCentre();
}
