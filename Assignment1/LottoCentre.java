package jac444.wk1;
/**
 * @author Brian Fournier (101 451 169)
 * LottoCentre and Generator Classes use:<br>
 * -java.util.Scanner<br>
 * -java.util.Random<br>
 * -java.util.ArrayList<br>
 */

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author Brian Fournier (101 451 169)
 *
 * LottoCentre class will handle interactions between Player and Generator classes.<br>
 * <br>
 * LottoCentre member variabes/objects:<br>
 * 	int LotteryBalance = 14000<br>
 *	int LotteryLoans = 0<br>
 *	int DrawsCompleted = 0<br>
 *	final int TicketCost = 5<br>
 *	final int Place1 = 150<br>
 *	final int Place2 = 75<br>
 *	final int Place3 = 5<br>
 *	Generator Gen<br>
 *	Ticket DrawTicket<br>
 */
public class LottoCentre {
	int LotteryBalance = 14000;
	int LotteryLoans = 0;
	int DrawsCompleted = 0;
	final int TicketCost = 5;
	final int Place1 = 150;
	final int Place2 = 75;
	final int Place3 = 5;
	Generator Gen;
	Ticket DrawTicket;
	
	/**
	 * 
	 * @author Brian Fournier (101 451 169)
	 * 
	 * Class Generator has 2 functionalities:<br>
	 * - Create Player owned Ticket(s) ({@link jac444.wk1.Player})<br>
	 * - Creates DrawTicket object that will be compared against Player owned Ticket(s).<br>
	 */
	public static class Generator {
		
		/**
		 * Generates new Ticket Object and returns the Ticket.<br>
		 * @return Returns a Ticket object to be copied to Player.<br>
		 */
		public Ticket GenerateTicket()
		{
			Ticket ticket = new Ticket();
			return ticket;
		}
	}
	/**
	 * This method will call Generator.GenerateTicket() method to create a new Ticket.<br>
	 * Then this method will create another temporary Ticket and copy GenerateTicket() Ticket object to this Ticket.<br>
	 * Then Return the newest created Ticket object to the player method that called it.<br>
	 * @return ticket - Newest Ticket Copy
	 */
	public Ticket GetGenTicket()
	{
		Gen = new Generator();
		Ticket ticket = new Ticket(Gen.GenerateTicket());
		LotteryBalance += TicketCost;
		return ticket;
	}
	
	/**
	 * This Method will check to see if the passes _ticket is a winner when compared to DrawTicket.<br>
	 * This method can also do error checking to see if LottoCentre has sufficient funds to redeem winnings.<br>
	 * LotteryLoans will handle how much money the LottoCentre owes for not having sufficient funds for Player.<br>
	 * <br>
	 * @param _ticket Is the Ticket being compared to DrawTicket.<br>
	 * @return returns the winnings of the Ticket, which is then added to Player.money.<br>
	 */
	public int isWinner(Ticket _ticket)
	{
		int i= 0;
		
		if(DrawTicket != null)
		{
			
			if(_ticket.Tnum1 == DrawTicket.Tnum1 || _ticket.Tnum1 == DrawTicket.Tnum2
					|| _ticket.Tnum1 == DrawTicket.Tnum3)
			{
				i++;
			}
		
			if(_ticket.Tnum2 == DrawTicket.Tnum1 || _ticket.Tnum2 == DrawTicket.Tnum2
					|| _ticket.Tnum2 == DrawTicket.Tnum3)
			{
				i++;
			}
		
			if(_ticket.Tnum3 == DrawTicket.Tnum1 || _ticket.Tnum3 == DrawTicket.Tnum2
					|| _ticket.Tnum3 == DrawTicket.Tnum3)
			{
				i++;
			}
				
			if(i == 3)
			{
				if(this.LotteryBalance < Place1)
				{
					if(this.LotteryLoans < Place1)
					{
						this.LotteryLoans += 500;
					}
					this.LotteryLoans -= Place1;
				}
				else
				{
					this.LotteryBalance -= Place1;
				}
				return Place1;
			}
			else if(i == 2)
			{
				if(this.LotteryBalance < Place2)
				{
					if(this.LotteryLoans < Place2)
					{
						this.LotteryLoans += 500;
					}
					
					this.LotteryLoans -= Place2;
				}
				else
				{
					this.LotteryBalance -= Place2;
				}
				return Place2;
			}
			else if(i == 1)
			{
				if(this.LotteryBalance < Place3)
				{
					if(this.LotteryLoans < Place3)
					{
						this.LotteryLoans += 500;
					}
					
					this.LotteryLoans -= Place3;
				}
				else
				{
					this.LotteryBalance -= Place3;
				}
				return Place3;
			}
			else
			{
				return i;
			}
		}
		else
		{
			return i;
		}
	}
/**
 * main will create 10 Player(s).<br>
 * main will create a LottoCentre.<br>
 * main will assign each player a random amount of tickets between 0 and 6 by calling PurchaseTickets.<br>
 * Then will conduct a DrawCard with Generator.<br>
 * Then will Check all players Ticket(s) and allot winnings.<br>
 * main will repeat 50 times(for 50 draws).<br>
 * main will then finally print all the LottoCentre info for user to see.<br>
 * @param args NOT USED!
 */
	public static void main(String[] args)
	{
		//String YN = new String();
		Random randomTicketNumber = new Random();
		Scanner pauser = new Scanner(System.in);
		Scanner reader = new Scanner(System.in);
		ArrayList<Player> players = new ArrayList<Player>();
		LottoCentre LT = new LottoCentre();
		System.out.println("LottoCentre Info:\nStart Balance: " + LT.LotteryBalance);
		
		for(int i = 0; i < 10; i++)
		{
			players.add(new Player());
			System.out.println("Player" + (i + 1) + " Balance : " + players.get(i).PlayerMoney);
		}		
		
		while(LT.DrawsCompleted < 50)
		{
			if( LT.DrawsCompleted % 2 != 0)
			{
				for(int PayDay = 0; PayDay < players.size(); PayDay++)
				{
					if(players.get(PayDay).PlayerMoney <= 25)
					{
						players.get(PayDay).PlayerMoney += 25;
					}
				}
			}
			for(int ii = 0; ii < players.size(); ii++)
			{
				players.get(ii).PurchaseTicket(LT, randomTicketNumber.nextInt(6));
			}
		
			LT.DrawTicket = new Ticket(LT.GetGenTicket());
			LT.DrawsCompleted++;
		
			for(int iii = 0; iii < players.size(); iii++)
			{
				players.get(iii).CheckTickets(LT);
			}
			
/*			System.out.print("Would you like to throw out all players old tickets now? ");
			while(YN.isEmpty())
			{
				System.out.print("\nY or N : ");
				YN = reader.nextLine();
				if(YN.length() == 1)
				{
					if(YN.charAt(0) == 'Y' || YN.charAt(0) == 'y')
					{
						for(int iv = 0; iv < players.size(); iv++)
						{
							players.get(iv).TossTickets();
						}
					}
					else if(YN.charAt(0) == 'N' || YN.charAt(0) == 'n')
					{
						YN = "N";
					}
					else
					{
						YN = "";
					}
				}
				else
				{
					YN = "";
				}
			}
			YN = "";*/
		}
		System.out.println("\nDraws Complete");

		System.out.println();
		for(int iv = 0; iv < players.size(); iv++)
		{
			System.out.println("Player" + (iv + 1) + " Balance after purchase and check : " + players.get(iv).PlayerMoney);
		}
		
		System.out.println();
		System.out.println("LottoCentre Info:\nEnd Balance: " + LT.LotteryBalance);
		System.out.println("LottoCentre Loans Owed: " + LT.LotteryLoans);
		pauser.nextLine();
		pauser.close();
		reader.close();
	}
}
