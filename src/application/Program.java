package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int n = sc.nextInt();
		
		System.out.print("Check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error reservation: Checkout date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(n, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			String err =reservation.updateDate(checkIn, checkOut);
			if(err != null) {
				System.out.println("Error in reservation: " + err);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
	
		sc.close();

	}

}
