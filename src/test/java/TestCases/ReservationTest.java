package TestCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Code.Reservation;

public class ReservationTest
{

	Reservation reserve;

	@Before
	public void BeforeTestCases()
	{
		reserve = new Reservation(10, 20, 30);
	}

	@Test
	public void SeatReservation_Test1()
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

	@After
	public void AfterTestCases()
	{
		reserve = null;
	}
}
