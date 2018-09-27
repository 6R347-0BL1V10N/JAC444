package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * 
 * Line class extends shape - @see Shape<br>
 * Line class info:<br>
 * -LabeledPoint A object which represents start of a Line object<br>
 * -LabeledPoint B object which represents end of a Line object<br>
 * -3 parameter constructor<br>
 * -getCentre() method that returns a Point object - @seeShape<br>
 */
public class Line extends Shape implements Measurable{
	LabeledPoint A;
	LabeledPoint B;
	
	/**
	 * 3 parameter constructor that assigns A and B member with the passes parameters.<br>
	 * @param from Represents start of a Line object
	 * @param to Represents end of a Line object
	 */
	public Line(Point from, Point to) {
		A = new LabeledPoint("LineStart" + this.hashCode(), from.getX(), from.getY());
		B = new LabeledPoint("LineEnd" + this.hashCode(), to.getX(), to.getY());
	}
	
	/**
	 * @see Shape#getCentre()
	 */
	Point getCentre()
	{	
		LabeledPoint centre = new LabeledPoint();
		centre.Label = "Line" + A.hashCode() + B.hashCode();
		centre.x = A.getX() + B.getX();
		centre.x /= 2;
		
		centre.y = A.getY() + B.getY();
		centre.y /= 2;
		
		return centre;
	}
	
	public String getArea()
	{
		return "Line object CANNOT have area";
	}
}
