package TestCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Code.Reservation;

public class ReservationTest
{
	final int fstSeats = 10;
	final int busSeats = 20;
	final int ecoSeats = 30;
	Reservation reserve;

	public boolean ReserveAllSeats()
	{
		for (int i = 1; i <= fstSeats; i++)
		{
			try
			{
				reserve.reserveSeat("FST", i);
			} catch (Exception exc)
			{
				return false;
			}
		}
		for (int i = 1; i <= busSeats; i++)
		{
			try
			{
				reserve.reserveSeat("BUS", i);
			} catch (Exception exc)
			{
				return false;
			}
		}
		for (int i = 1; i <= ecoSeats; i++)
		{
			try
			{
				reserve.reserveSeat("ECO", i);
			} catch (Exception exc)
			{
				return false;
			}
		}
		return true;
	}

	@Before
	public void BeforeTestCases()
	{
		reserve = new Reservation(fstSeats, busSeats, ecoSeats);
	}

	@Test
	public void Test1_SeatReservation()
	{
		boolean check;
		for (int i = 1; i <= 10; i++)
		{
			check = reserve.reserveSeat("FST", i);
			if (check == false)
			{
				Assert.assertTrue(false);
				break;
			}
		}
		Assert.assertTrue(true);
	}

	@Test
	public void Test2_ReserveAllSeat_Pos()
	{
		this.ReserveAllSeats();
	}

	@Test
	public void Test3_ReserveEndSeat()
	{
		// Initial Seat
		Assert.assertTrue(reserve.reserveSeat("FST", 1));
		Assert.assertTrue(reserve.reserveSeat("ECO", 1));
		Assert.assertTrue(reserve.reserveSeat("BUS", 1));
		// Last Seats
		Assert.assertTrue(reserve.reserveSeat("FST", fstSeats));
		Assert.assertTrue(reserve.reserveSeat("ECO", ecoSeats));
		Assert.assertTrue(reserve.reserveSeat("BUS", busSeats));
	}

	@Test
	public void Test4_UnReserveSeat()
	{
		this.ReserveAllSeats();
		Assert.assertTrue(reserve.unReserveSeat("FST", 1));
		Assert.assertTrue(reserve.unReserveSeat("FST", 5));
		Assert.assertTrue(reserve.unReserveSeat("FST", 7));
	}

	@Test
	public void Test5_ShowDisplay()
	{
		reserve.showAllSeats();
		reserve.showAvailableSeats();
		reserve.showReservedSeats();
		Assert.assertTrue(true);
	}

	@After
	public void AfterTestCases()
	{
		reserve = null;
		// Memory Collector
	}
}
