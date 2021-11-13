package Code;

public class Flight
{
	int flightId;
	// Aeroplane
	Reservation reservations;
	// Deal with date
	// Location Managment

	public Flight(int flId, int fSeats, int bSeats, int eSeats)
	{
		flightId = flId;
		reservations = new Reservation(fSeats, bSeats, eSeats);
	}

	public boolean reServeSeat(String seatType, int seatNo)
	{
		return reservations.ReserveSeat(seatType, seatNo);
	}

	public static void main(String[] arg)
	{
		Reservation res = new Reservation(10, 10, 10);
		res.ReserveSeat("FST", 1);
		res.ReserveSeat("FST", 2);
		res.ReserveSeat("BUS", 1);
		res.ReserveSeat("ECO", 1);
		res.showAllSeats();
		System.out.println("----------------------------");
		System.out.println("--- Available Seats ---");
		res.showAvailableSeats();
		System.out.println("--- Booked seats ---");
		res.showReservedSeats();
	}
}
