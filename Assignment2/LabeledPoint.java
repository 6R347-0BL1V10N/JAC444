/**
 * @author Brian Fournier (101 451 169)<br>
 */
package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * 
 * LabeledPoint class 'extends' Point class and provides a String 'Label' for the x and y coordinates.<br>
 * @see Point
 * <br>
 * LabeledPoint class info:<br>
 * -String Label<br>
 * -1 parameter constructor<br>
 * -3 parameter constructor<br>
 * -3 Overridden methods:
 * 		-toString()
 * 		-equals()
 * 		-hasCode()
 */
public class LabeledPoint extends Point {
	protected String Label;
	
	/**
	 * 1 parameter constructor creates Label String object.<br>
	 */
	public LabeledPoint()
	{
		Label = new String();
	}

	/**
	 * 3 parameter constructor assigns values to Label and calls super() constructor for Point.<br>
	 * @see Point
	 * @param label String that will be the x and y coordinate label(name).<br>
	 * @param _x {@link Point#x}
	 * @param _y {@link Point#y}
	 */
	public LabeledPoint(String label, double _x, double _y) {
		super(_x, _y);
		Label = new String();
		Label = label;	
	}
	
	/**
	 * getLabel() getter.<br>
	 * @return return String holding label(name).<br>
	 */
	public String getLabel()
	{
		return Label;
	}
	
	/**
	 * @see Point#toString()
	 */
	public String toString()
	{
		return Label + "\n" + super.toString();
	}
	
	/**
	 * see also {@link Point#equals(Point)}
	 * @param LP LabeledPoint object
	 * @return boolean
	 */
	public boolean equals(LabeledPoint LP)
	{
		if(this.getLabel().equals(LP.getLabel()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * @see Point#hashCode()
	 */
	public int hashCode()
	{
		int hash = 0;
		String Tstring = new String();
		Tstring = this.getLabel();
		
		for(int i = 0; i < Tstring.length(); i++)
		{
			hash += 31 * hash + Tstring.charAt(i);
		}
		return hash;
	}
}
