package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room Number: ");
        int roomNumber = input.nextInt();

        System.out.print("Check-In Date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(input.next());

        System.out.print("Check-Out Date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(input.next());

        if (!checkout.after(checkin)) {
            System.out.println("\nError in reservation: Check-Out Date must be after Check-In Date !\n");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("\nReservation: " + reservation);
            System.out.println();

            // Update Dates

            System.out.println("Enter Data to update the reservation:");

            System.out.print("Check-In Date (dd/MM/yyyy): ");
            checkin = sdf.parse(input.next());

            System.out.print("Check-Out Date (dd/MM/yyyy): ");
            checkout = sdf.parse(input.next());

            Date now = new Date();

            if (checkin.before(now) || checkout.before(now)) {
                System.out.println("\nError in reservation: Reservation Dates for update must be future Dates !\n");

            } else if (!checkout.after(checkin)) {
                System.out.println("\nError in reservation: Check-Out Date must be after Check-In Date !\n");

            } else {
                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }
        }

    }
}
