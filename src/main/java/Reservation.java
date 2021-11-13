
public class Reservation
{
	Seats fstSeats;
	Seats busSeats;
	Seats ecoSeats;

	Reservation(int totalFstSeats, int totalBusSeats, int totalEcoSeats)
	{
		try
		{
			fstSeats = new Seats("First-Class", totalFstSeats);
			busSeats = new Seats("Business-Class", totalBusSeats);
			ecoSeats = new Seats("Economy-Class", totalEcoSeats);
		} catch (Exception exc)
		{
			System.out.println("Assigning TotalSeats Exception : " + exc);
		}

	}

	public boolean ReserveSeat(String SeatClass, int seatNo)
	{
		boolean result = true;
		if (SeatClass.equals("FST") == true)
		{
			try
			{
				fstSeats.reserveSeat(seatNo);
			} catch (Exception exc)
			{
				System.out.println(exc);
				result = false;
			}
		} else if (SeatClass.equals("BUS") == true)
		{
			try
			{
				busSeats.reserveSeat(seatNo);
			} catch (Exception exc)
			{
				System.out.println(exc);
				result = false;
			}
		} else if (SeatClass.equals("ECO") == true)
		{
			try
			{
				ecoSeats.reserveSeat(seatNo);
			} catch (Exception exc)
			{
				System.out.println(exc);
				result = false;
			}
		}
		return result;
	}

	public boolean unReserveSeat(String SeatClass, int seatNo)
	{
		{
			boolean result = true;
			if (SeatClass.equals("FST") == true)
			{
				try
				{
					fstSeats.unreserveSeat(seatNo);
				} catch (Exception exc)
				{
					System.out.println(exc);
					result = false;
				}
			} else if (SeatClass.equals("BUS") == true)
			{
				try
				{
					busSeats.unreserveSeat(seatNo);
				} catch (Exception exc)
				{
					System.out.println(exc);
					result = false;
				}
			} else if (SeatClass.equals("ECO") == true)
			{
				try
				{
					ecoSeats.unreserveSeat(seatNo);
				} catch (Exception exc)
				{
					System.out.println(exc);
					result = false;
				}
			}
			return result;
		}

	}

	public void showAllSeats()
	{
		System.out.println("[--- " + fstSeats.getSeatType() + " ---]");
		fstSeats.showAllSeats();
		System.out.println("[--- " + busSeats.getSeatType() + " ---]");
		busSeats.showAllSeats();
		System.out.println("[--- " + ecoSeats.getSeatType() + " ---]");
		ecoSeats.showAllSeats();
	}

	public static void main(String[] args)
	{
		Reservation res = new Reservation(5, 5, 5);
		res.ReserveSeat("FST", 1);
		res.ReserveSeat("FST", 2);
		res.ReserveSeat("BUS", 1);
		res.ReserveSeat("ECO", 1);
		res.showAllSeats();
		System.out.println("----------------------------");
		res.unReserveSeat("FST", 1);
		res.unReserveSeat("FST", 2);
		res.unReserveSeat("BUS", 1);
		res.unReserveSeat("ECO", 1);
		res.showAllSeats();
	}

}
