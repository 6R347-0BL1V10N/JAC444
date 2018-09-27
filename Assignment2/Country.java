package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * 
 * Country class info:<br>
 * -String name object that holds the 'Name' of a Country object<br>
 * -double area that holds the 'Area' in Squared Kilometers of a Country object<br>
 * -0 parameter constructor<br>
 * -2 parameter constructor<br>
 */
public class Country {
	String name;
	double area;
	
	/**
	 * 0 parameter constructor that initializes name to an empty string and sets area to 0.0.<br>
	 */
	public Country()
	{
		name = new String();
		area = 0.0;
	}
	
	/**
	 * 2 parameter constructor that sets name to passes String value and sets area to passes double value.<br>
	 * @param _name String object holding 'Name' of a Country
	 * @param _area double holding area of a Country
	 */
	public Country(String _name, double _area)
	{
		name = new String(_name);
		area = _area;
	}
}
