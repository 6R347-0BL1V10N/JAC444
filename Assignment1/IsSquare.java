/* Author  : Brian Fournier (101 451 169)
 * Date    : September 14, 2018
 * Purpose : JAC444 Assignment 1
 * Class   : JAC444 SAB
 */
package jac444.wk1;

/**
 * @author Brian Fournier (101 451 169)
 */
import java.util.Scanner;

/**
 * 
 * Class IsSquare takes user input in rows of integer inputs<br>
 * (ie.. 3 56 2, or 25 84 2 6 45 34) any number of inputs per row allowed<br>
 * <br>
 * IsSquare has little error checking so input must remain consistent<br>
 * <br>
 * Members:<br>
 * -int MagicSquare[][];<br>
 *-boolean UpDown = false;<br>
 *-boolean LeftRight = false;<br>
 *-boolean Diagonals = false;<br>
 *-int dimentions = 1;
 */
public class IsSquare
{
	int MagicSquare[][];
	boolean UpDown = false;
	boolean LeftRight = false;
	boolean Diagonals = false;
	int dimentions = 1;
	
	/**
	 * Constructor retrieves line of input for each row.<br>
	 * First line of input determines dimentions.<br>
	 * Will then accept appropriate number of inputs to fill MagicSquare,<br>
	 * but will not error check values.<br>
	 * Will then Create square that is ready to be checked
	 */
	public IsSquare()
	{
		boolean firstInput = true;
		boolean getInput = true;
		Scanner reader = new Scanner(System.in);
		String MagicSquareValues = new String();
		@SuppressWarnings("unused")
		String addline = new String();
		
		System.out.print("Please Enter set of Values for MagicSquare\nSeparate each value with a WhiteSpace (' ') : ");
		MagicSquareValues = reader.nextLine();
		
		while(firstInput)
		{
			if(MagicSquareValues != null && MagicSquareValues != "")
			{
				for(int i = 0; i < MagicSquareValues.length(); i++)
				{
					if(MagicSquareValues.charAt(i) != ' ')
					{
						addline += MagicSquareValues.charAt(i);
					}
					if(MagicSquareValues.charAt(i) == ' ')
					{
						dimentions++;
						addline += MagicSquareValues.charAt(i);
					}
				}
				firstInput = false;
			}
		}
		MagicSquare = new int[dimentions][dimentions];
		
		String num = new String();
		int inc = 0;
		for(int i = 0; i < MagicSquareValues.length(); i++)
		{
			if(MagicSquareValues.charAt(i)!= ' ')
			{
				num+=MagicSquareValues.charAt(i);
			}
			if(MagicSquareValues.charAt(i) == ' ' || i == MagicSquareValues.length() - 1)
			{
				MagicSquare[0][inc] = Integer.valueOf(num);
				num = "";
				inc++;
			}
		}
		
		String num2 = new String();
		int incRow = 1;
		int incCol = 0;
		int cont = 1;
		
		while(getInput)
		{
			System.out.print("\nPlease Enter Next set of Values for MagicSquare.\nSeparate each value with a WhiteSpace (' ') : ");
			MagicSquareValues = reader.nextLine();
			

			
			for(int i = 0; i < MagicSquareValues.length(); i++)
			{
				if(MagicSquareValues.charAt(i)!= ' ')
				{
					num2+=MagicSquareValues.charAt(i);
				}
				if(MagicSquareValues.charAt(i) == ' ' || i == MagicSquareValues.length() - 1)
				{
					MagicSquare[incRow][incCol] = Integer.valueOf(num2);
					num2 = "";
					incCol++;
				}
			}
			cont++;
			if(cont == dimentions)
			{
				getInput = false;
			}
			incRow++;
			incCol = 0;
		}
		reader.close();
	}
	
	/**
	 * LeftRight will check all rows sums and if all rows sums are the same,<br>
	 * LeftRight will set LeftRight member variable to true, else false
	 */
	void LeftRight()
	{
		int Sums[] = new int [MagicSquare.length];
		int iterator = 0;
		
		for(int i = 0 ; i < MagicSquare.length; i++)
		{
			for(int j = 0; j < MagicSquare[0].length; j++)
			{
				Sums[iterator] += MagicSquare[i][j];
			}
			if(iterator < MagicSquare.length)
			{
			iterator++;
			}
		}
		for(int i = 1; i < Sums.length; i++)
		{
			if(Sums[0] == Sums[i])
			{
				LeftRight = true;
			}
			else
			{
				LeftRight = false;
				break;
			}
			
		}
	}
	/**
	 * UpDown is the same as LeftRight but will check all columns,<br>
	 * and be setting UpDown member variable.
	 */
	void UpDown()
	{
		int Sums[] = new int[MagicSquare.length];
		int iterator = 0;
		
		for(int i = 0; i < MagicSquare.length; i++)
		{
			for(int ii = 0; ii < MagicSquare[0].length; ii++)
			{
				Sums[iterator] += MagicSquare[ii][i];
			}
			if(iterator < MagicSquare.length)
			{
			iterator++;
			}
		}
		for(int i = 1; i < Sums.length; i++)
		{
			if(Sums[0] == Sums[i])
			{
				UpDown = true;
			}
			else
			{
				UpDown = false;
				break;
			}
			
		}
	}
	
	/**
	 * Diagonal will check diagonal lines of the square from corner to opposite corner.<br>
	 * This will set the member variable Diagonals to either true or false.
	 */
	void Diagonal()
	{
		int Sums[] = new int[MagicSquare.length];
		int Sums2[] = new int[MagicSquare.length];
		int iterator = 0;
		int iterator2 = 0;
		int i = 0;
		int j = 0;
		
		while(i != dimentions)
		{
			Sums[iterator] += MagicSquare[i][i];
			i++;
			iterator++;
		}
		
		for(int ii = dimentions -1; ii >= 0; ii--)
		{
			Sums2[iterator2] += MagicSquare[j][ii];
			j++;
		}
		
		for(int iii = 1; iii < Sums.length; iii++)
		{
			if(Sums[0] == Sums[iii])
			{
				Diagonals = true;
			}
			else
			{
				Diagonals = false;
				break;
			}
			
		}
		
		
		
	}
	/**
	 * IsMagic is the method to check if the MagicSquare is in fact Magic.<br>
	 * if all boolean member variables are true, the Square is Magic, else not Magic.
	 * @return -boolean -return represents or not the MagicSquare is Magic
	 */
	boolean IsMagic()
	{
		UpDown();
		LeftRight();
		Diagonal();
		if(UpDown && LeftRight && Diagonals)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * Creates IsSquare object.<br>
	 * Call IsSquare and print result to user.
	 * @param args NOT USED!
	 */
	public static void main(String[] args)
	{
		IsSquare square = new IsSquare();
		System.out.print("\nIs Your Square Actually Magic? : ");
		System.out.println(square.IsMagic());
	}

}
