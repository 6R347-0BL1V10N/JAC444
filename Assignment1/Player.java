package jac444.wk1;

/**
 * @author Brian FOurnier (101 451 169)
 */

import java.util.ArrayList;

/**
 * 
 * @author Brian Fournier (101 451 169)
 *
 * Player class will interact with the LottoCentre an/d will own a ArrayList of Ticket(s)<br>
 * {@link jac444.wk1.LottoCentre}
 * {@link jac444.wk1.Ticket}
 * <br>
 * Member variables:<br>
 * -int PlayerMoney = 30; - How much money Player has<br>
 * -int NumberOfCurrentTickets = 0; - How many Tickets the Player Owns/ bought<br>
 * -ArrayList Ticket PlayerPurchasedTickets; //all Generated tickets from Generator class<br>
 * {@link jac444.wk1.LottoCentre.Generator}
 */

public class Player {
	int PlayerMoney = 30;
	int NumberOfCurrentTickets = 0;
	ArrayList<Ticket> PlayerPurchasedTickets;
	/**
	 * Player Constructor will create new ArrayList object of Ticket(s). 
	 */
	public Player()
	{
		PlayerPurchasedTickets = new ArrayList<Ticket>();
	}
	/**
	 * Method used to add a new Generated Ticket to the PlayerPurchasedTickets ArrayList.<br>
	 * This Method can also check if player has sufficient funds to buy a Ticket.<br>
	 * Increments NumberOfCurrentTickets Player has.<br>
	 * <br>
	 * @param LT Passing in LottoCentre Methods for purchasing Ticket<br>
	 * @param amount - How many Ticket(s) Player is adding.<br>
	 * {@link jac444.wk1.LottoCentre.Generator} - Used to Create a Ticket
	 */
	void PurchaseTicket(LottoCentre LT, int amount)
	{
		for(int i = 0; i < amount; i++)
		{
			if(PlayerMoney >= LT.TicketCost)
			{
				PlayerPurchasedTickets.add(new Ticket(LT.GetGenTicket()));
				PlayerMoney -= LT.TicketCost;
				NumberOfCurrentTickets++;
			}
			else
			{
				break;
			}
		}
	}
	/**
	 * This method will check to see if any owned Ticket(s) in PlayerPurchasedTickets ArrayList are winners.<br>
	 * A Winning Ticket's rules are as follows:<br>
	 * 3 correct numbers (1st place prize), 2 correct numbers (2nd place prize), 1 correct number
	 * (3rd place prize)<br>
	 * @param LT - Passes the LottoCentre methods for checking Ticket.<br>
	 * {@link jac444.wk1.LottoCentre}
	 */
	public void CheckTickets(LottoCentre LT)
	{
		int ret = 0;
		for(int i = 0; i < PlayerPurchasedTickets.size(); i++)
		{
			if(PlayerPurchasedTickets.get(i).isChecked == false)
			{
				ret = LT.isWinner(PlayerPurchasedTickets.get(i));
				PlayerPurchasedTickets.get(i).isChecked = true;
			}
			PlayerMoney += ret;		
			
		}
	}
	/**
	 * Unfinished function to remove all checked Tickets regardless of win or loss.<br>
	 */
	public void TossTickets()
	{
		for(int i = 0; i < this.PlayerPurchasedTickets.size(); i++)
		{
			if(this.PlayerPurchasedTickets.get(i).isChecked == true)
			{
				this.PlayerPurchasedTickets.remove(i);
				i--;
			}
		}
	}
}
