package jac444.wk2;

/**
 * @author Brian Fournier (101 451 169)<br>
 * Measurable is an interface.<br>
 * Measurable has one method: getArea() which returns a String that represents area of a Country in Units Squared.<br>
 */
public interface Measurable {
	
	/**
	 * declaration of getArea() method.<br>
	 * @see Circle
	 * @see Line
	 * @see Rectangle
	 * @return String object
	 */
	public String getArea();
	
	/**
	 * Main is a Test run of All shapes.<br> Intended for Instructor use.<br>
	 * @param args NOT USED!
	 */
	public static void main(String[] args)
	{
		Point A = new Point(9.5,12.5);
		Point B = new Point(12.5,14.9);
		
		Circle C = new Circle(A,5.8);
		Rectangle R = new Rectangle(A,3.5,9.5);
		Line L = new Line(A,B);
		
		System.out.println(C.getArea());
		System.out.println(C.getCentre());
		System.out.println("\n\n" + R.getArea());
		System.out.println(R.getCentre());
		System.out.println("\n\n" + L.getArea());
		System.out.println(L.getCentre());
	}

}
