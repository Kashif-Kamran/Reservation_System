package Code;

import exception.ReservationException;

public class Seats
{
	private String type;
	private int totalSeats;
	private boolean[] seatArray;
	private int reservedSeats;

	// Public Constructors
	public Seats(String tpe, int total) throws IndexOutOfBoundsException
	{
		if (total < 0)
		{
			throw new IndexOutOfBoundsException("--- Invalid Size of Array ---");
		}
		type = tpe;
		totalSeats = total;
		seatArray = new boolean[total];
		reservedSeats = 0;
	}

	public void reserveSeat(int seatNo) throws Exception
	{
		boolean ReturnState = false;
		int actualSeat = seatNo - 1;
		if (reservedSeats == totalSeats)
		{
			throw new ReservationException("--- All Seats Are Reserved ---");
		}
		if (actualSeat >= totalSeats || actualSeat < 0)
		{
			throw new IndexOutOfBoundsException("--- Wrong Seat Number ---");

		} else if (seatArray[actualSeat] == true)
		{
			throw new ReservationException("--- Seat Is Already Reserved ---");
		} else
		{
			seatArray[actualSeat] = true;
			reservedSeats++;
		}
	}

	public void showAllSeats()
	{
		for (int i = 0; i < totalSeats; i++)
		{
			if ((i + 1) % 5 == 0)
			{
				System.out.println();
			}
			if (seatArray[i] == true)
			{
				System.out.print((i + 1) + "|RV  ");
			} else if (seatArray[i] == false)
			{
				System.out.print((i + 1) + "|AV  ");
			}
		}
		System.out.println();
	}

	public void showAvaliableSeats()
	{
		if (reservedSeats == totalSeats)
		{
			System.out.println("-- No Seats Are Available --");
		}
		int j = 1;
		for (int i = 0; i < totalSeats; i++)
		{
			if (j % 5 == 0)
			{
				System.out.println();
			}
			if (seatArray[i] == false)
			{
				System.out.print((i + 1) + "|AV  ");
				j++;
			}
		}
		System.out.println();
	}

	public void showReservedSeats()
	{
		if (reservedSeats == 0)
		{
			System.out.println("-- No Reserved Seats --");
		}
		int j = 1;
		for (int i = 0; i < totalSeats; i++)
		{
			if (j % 5 == 0)
			{
				System.out.println();
			}
			if (seatArray[i] == true)
			{
				System.out.print((i + 1) + "|RV  ");
				j++;
			}
		}
		System.out.println();
	}

	public void unreserveSeat(int seatNo) throws Exception
	{
		int actualSeat = seatNo - 1;
		if (actualSeat < 0 || actualSeat >= totalSeats)
		{
			throw new IndexOutOfBoundsException("--- Wrong Seat Number ---");
		} else if (reservedSeats == 0)
		{
			throw new ReservationException("--- All Seats Are Free ---");
		} else if (seatArray[actualSeat] == false)
		{
			throw new ReservationException("--- Seat is Already Free ---");
		} else
		{
			seatArray[actualSeat] = false;
			reservedSeats--;
		}
	}

	public int getTotalSeats()
	{
		return totalSeats;
	}

	public int getReservedSeats()
	{
		return reservedSeats;
	}

	public String getSeatType()
	{
		return type;
	}
}
