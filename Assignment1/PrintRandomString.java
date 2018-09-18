package jac444.wk1;
/**
 * @author Brian Fournier (101 451 169)
 */

/* Author  : Brian Fournier (101 451 169)
 * Date    : September 11, 2018
 * Purpose : JAC444 Assignment 1
 * Class   : JAC444 SAB
 */

import java.util.Random; //Used to generate random long number

/**
 * PrintRandomString will only have a Constructor and no methods
 */

public class PrintRandomString
{
	/**
	 * Default Constructor uses java.util.Random.<br>
	 * PrintRandomString Constructor will Random a long integer.<br>
	 * Print that Long int to the user.<br>
	 * Print that Long int to the user in base 36 using:  Long.toString(Value, 36));<br>
	 * @see #toString()
	 */
	public PrintRandomString() //default constructor
	{ //All processes will be done within constructor
		Random Randomizer = new Random(); //Random object
		long Value = Randomizer.nextLong(); //Get a Random number and store it
		
		//print Random long number then print long as a base36 string
		//DOES NOT store Base36 String, as it is not necessary
		System.out.println("Randomly Generated Long Number : " + Value);
		System.out.println("Random String : " + Long.toString(Value, 36));
	};

	/**
	 * Creates PrintRandomString object
	 * 
	 * @param args NOT USED
	 */
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		PrintRandomString PRS = new PrintRandomString(); //create PrintRandomString object
														 //Constructor will be invoked and process
														 //will begin within constructor
	};
};
