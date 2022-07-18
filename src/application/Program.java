package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int n = sc.nextInt();
			
			System.out.print("Check-in (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			System.out.println("Error reservation: Checkout date must be after check-in date.");
			
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDate(checkIn, checkOut);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
	
		
	
		sc.close();

	}

}
