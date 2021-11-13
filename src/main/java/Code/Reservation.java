package Code;

public class Reservation
{
	Seats fstSeats;
	Seats busSeats;
	Seats ecoSeats;

	public Reservation(int totalFstSeats, int totalBusSeats, int totalEcoSeats)
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

	public boolean reserveSeat(String SeatClass, int seatNo)
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

	public void showReservedSeats()
	{
		System.out.println("[--- " + fstSeats.getSeatType() + " ---]");
		fstSeats.showReservedSeats();
		System.out.println("[--- " + busSeats.getSeatType() + " ---]");
		busSeats.showReservedSeats();
		System.out.println("[--- " + ecoSeats.getSeatType() + " ---]");
		ecoSeats.showReservedSeats();
	}

	public void showAvailableSeats()
	{
		System.out.println("[--- " + fstSeats.getSeatType() + " ---]");
		fstSeats.showAvaliableSeats();
		System.out.println("[--- " + busSeats.getSeatType() + " ---]");
		busSeats.showAvaliableSeats();
		System.out.println("[--- " + ecoSeats.getSeatType() + " ---]");
		ecoSeats.showAvaliableSeats();
	}

}
