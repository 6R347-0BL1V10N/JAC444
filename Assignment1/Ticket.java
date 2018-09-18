/**
 * @author Brian Fournier (101 451 169)
 */

package jac444.wk1;

import java.util.Random;
import java.util.Date;

/**
 * <p>
 * Class Ticket will be used by both Player and LottoCentre class
 * Contains :<br>
 * -3 unique numbers that serve as Lotto Numbers to be compared against
 * 		a Draw Ticket.<br>
 * -A boolean variable that represents if the ticket was checked for winner
 * 		already<br>
 * -The Draw Date
 * </p>
 */
public class Ticket {

	int Tnum1 = 0;
	int Tnum2 = 0;
	int Tnum3 = 0;
	boolean isChecked = false;
	Date PurchaseDate;
	
	/**
	 * Default Constructor will set the Date and assign 3 random numbers to the ticket
	 */
	public Ticket()
	{
		PurchaseDate = new Date();
		Random randomNumber = new Random();
		
		Tnum1 = randomNumber.nextInt(11);
		while(Tnum2 == 0 || Tnum2 == Tnum3 || Tnum2 == Tnum1)
		{
			Tnum2 = randomNumber.nextInt(11);
		}
		while(Tnum3 == 0 || Tnum3 == Tnum1 || Tnum3 == Tnum2)
		{
			Tnum3 = randomNumber.nextInt(11);
		}
	}
	
	/**
	 * 1 Parameter Constructor that creates a Ticket object
	 * @param ticket Is a Ticket created by the static Generator class
	 * 
	 */
	public Ticket(Ticket ticket)
	{
		this.PurchaseDate = new Date();
		this.PurchaseDate.equals(ticket.PurchaseDate);
		this.Tnum1 = ticket.Tnum1;
		this.Tnum2 = ticket.Tnum2;
		this.Tnum3 = ticket.Tnum3;
	}
}
