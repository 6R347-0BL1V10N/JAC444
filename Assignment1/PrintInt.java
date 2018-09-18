/**
 * @author Brian Fournier (101 451 169)
 */
package jac444.wk1;

/*
 *  Author  : Brian Fournier (101 451 169)
 * Date    : September 11, 2018
 * Purpose : JAC444 Assignment 1
 * Class   : JAC444 SAB
 */

import java.util.Scanner; //imported java utility scanner to get input from user

/**
 * PrintInt class has one member variable:<br>
 * static int MyInt <br> which is: Integer used to store user input and convert to Binary, Octal,
 * 			<br>Hexadecimal and reciprocal as a Hexadecimal
 */
public class PrintInt 
{
	static int MyInt; //Integer used to store user input and convert to Binary, Octal,
					  //Hexadecimal and reciprocal as a Hexadecimal
	
	/**
	 * This Constructor will assign the member variable MyInt to the paramater value
	 * @param _MyInt represents an integer
	 */
	public PrintInt(int _MyInt) //Constructor with 1 parameter. This will set member MyInt to user input
	{
		MyInt = _MyInt;
	}
	
	/**
	 * This function will take advantage of Integer class to represent MyInt as <br>
	 * Binary, Octal, Hexadecimal, and print its reciprocal as a hexadecimal floating point number
	 */
	void PrintAsBOH_RH() //This function will convert the user input to Binary, Octal, Hexadecimal, and
	{					 //print its reciprocal as a hexadecimal floating point number
		System.out.println("Your Integer in Binary Representation : " + Integer.toBinaryString(MyInt));  //Integer as Binary
		System.out.println("Your Integer in Octal Representation : " + Integer.toOctalString(MyInt));    //Integer as Octal
		System.out.println("Your Integer in Hexadecimal Representation : " + Integer.toHexString(MyInt));//Integer as Hexadecimal
		
		float MyIntAsFloat = 1 /(float) MyInt; //Casting MyInt to a float called MyintAsFloat
		System.out.println("\nYout Integer in it's reciprocal as a Hexadecimal floationg point number " + Float.toHexString(MyIntAsFloat));
	}

	/**
	 * Main will not use parameter args.<br>
	 * Main will use java.util.Scanner for user input and pauses<br>
	 * Main will ask for MyInt the call method: PrintAsBOH_RH()<br>
	 * @see #PrintAsBOH_RH()
	 * @param args Not Used!
	 */
	public static void main(String[] args)
	{
		//create Scanner objects for getting input
		//and to add a pause before convert
		Scanner reader = new Scanner(System.in); 
		Scanner pause = new Scanner(System.in);
		
		//Get user input
		System.out.print("Enter an Integer : ");
		int num = reader.nextInt();
		
		//Create Convert object and set MyInt
		//as user input from previous step
		PrintInt Convert = new PrintInt(num);
		
		//pause for dramatic appearance
		System.out.println("Your Integer is : " + num + "\n~Press Any Key to Convert...");
		pause.nextLine();
		
		//After pause, output MyInt as Binary, Octal, Hexadecimal, and reciprocal as Hexadecimal
		Convert.PrintAsBOH_RH();
		
		//Clean up Scanner objects
		//by closing objects
		reader.close();
		pause.close();
	}

}
