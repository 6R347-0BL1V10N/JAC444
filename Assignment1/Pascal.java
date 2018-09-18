/* Author  : Brian Fournier (101 451 169)
 * Date    : September 14, 2018
 * Purpose : JAC444 Assignment 1
 * Class   : JAC444 SAB
 */

package jac444.wk1;

import java.util.Scanner;

/**
 * 
 * @author Brian Fournier (101 451 169)
 * 
 * Class Pascal will store the numbers of the desired size of a pascal triangle.<br>
 * <a href="https://www.mathsisfun.com/pascals-triangle.html">see Pascal-Triangle</a><br>
 * <br>
 * Member variable:<br>
 * static int Triangle[];
 *
 */

public class Pascal {
	
	static int Triangle[];
	
	/**
	 * main will ask user for size of Pascal Triangle.<br>
	 * print out the triangle for the user to see the numbers being stored.<br>
	 * Store the numbers of the triangle into Triangle[] member.<br>
	 * @param args NOT USED!
	 */
	public static void main(String[] args)
	{
		int n = 0;
		int a = 1;
		
		Scanner reader = new Scanner(System.in);
		
		System.out.print("Enetr n : ");
		n = reader.nextInt();
		reader.close();
		
		int p = 0;
		
		for(int iii = n; iii > 0; iii--)
		{
			p += iii;
		}
		
		Triangle = new int[p];
		String tTemp = new String();
		//This Program required much google help
		//As I was very confused on how to make this
		
		for(int i = 0; i < n; i++)
		{
			for(int j = n; j > i; j--)
			{
				System.out.print(" ");
			}
			a = 1;
			for(int jj = 0; jj <= i; jj++)
			{
				System.out.print(a + " ");
				tTemp += a + " ";
				a = a * (i - jj) / (jj + 1);
			}
			System.out.println();
		}
		reader.close();
		
		String num = new String();
		int iterator = 0;
		
		for(int iv = 0; iv < tTemp.length(); iv++)
		{
			if(tTemp.charAt(iv) != ' ')
			{
				num += tTemp.charAt(iv);
			}
			if(tTemp.charAt(iv) == ' ' || iv == tTemp.length())
			{
				Triangle[iterator] = Integer.valueOf(num);
				num = "";
				iterator++;
			}
		}
		System.out.println("\nYour Stored Pascal Triangle -> ");
		
		for(int pr = 0; pr < Triangle.length; pr++)
		{
			System.out.print(Triangle[pr] + " ");
		}
	}

}
