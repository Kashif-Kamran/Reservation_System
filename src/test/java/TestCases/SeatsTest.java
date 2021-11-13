package TestCases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Code.Seats;
import exception.ReservationException;
import junit.framework.Assert;

public class SeatsTest
{

	Seats seat;

	@Before
	public void BeforeTest()
	{

		seat = new Seats("FST", 30);
	}

	// Reservation TestCases
	@SuppressWarnings("deprecation")
	@Test // Simple Positive Testing
	public void test1_ReserveSeat_Pos1()
	{
		for (int i = 1; i < 29; i++)
			try
			{
				seat.reserveSeat(i);
				Assert.assertTrue(true);
			} catch (Exception exc)
			{
				Assert.assertTrue(false);
			}
	}

	@Test(expected = ReservationException.class)
	public void test2_ReserveSeat_Neg1() throws Exception
	{
		seat.reserveSeat(10);
		seat.reserveSeat(10);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test3_ReserveSeat_Neg2() throws Exception
	{
		seat.reserveSeat(0);
		seat.reserveSeat(1);
	}

	@Test(expected = ReservationException.class)
	public void test4_ReserveSeat_Pos2() throws Exception
	{

		for (int i = 1; i <= 30; i++)
		{
			seat.reserveSeat(i);
		}
		seat.reserveSeat(1);

	}

	// Unreserve TestCases
	@Test
	public void test5_unreserveTest_Pos3()
	{
		for (int i = 1; i < 30; i++)
		{
			try
			{
				seat.reserveSeat(i);
			} catch (Exception exc)
			{
				System.out.println("Get there");
			}
		}
		for (int i = 10; i < 30; i++)
		{
			try
			{
				seat.unreserveSeat(i);
				Assert.assertTrue(true);
			} catch (Exception ec)
			{
				Assert.assertTrue(false);
			}
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test6_UnReserveSeat_Neg3() throws Exception
	{
		seat.unreserveSeat(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void test7_UnReserveSeat_Neg4() throws Exception
	{
		seat.unreserveSeat(31);
	}

	@Test(expected = ReservationException.class)
	public void test8_UnReserveSeat_Neg5() throws Exception
	{
		seat.unreserveSeat(8);
	}

	@Test
	public void test9_DisplayFunctions()
	{
		System.out.println("[== Show All Seats ==]");
		seat.showAllSeats();
		System.out.println();
		System.out.println("[== Show Reserved Seats ==]");
		seat.showReservedSeats();
		System.out.println();
		System.out.println("[== Show Available Seats ==]");
		seat.showAvaliableSeats();
		System.out.println();
		Assert.assertTrue(true);
	}

	@Test
	public void test10_getTotalSeats()
	{
		Assert.assertEquals(seat.getTotalSeats(), 30);
	}

	@After
	public void AfterTestCases()
	{
		seat = null;
	}
}
