package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            // Create Reservation

            System.out.print("Room Number: ");
            int roomNumber = input.nextInt();
            System.out.print("Check-In Date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(input.next());
            System.out.print("Check-Out Date (dd/MM/yyyy): ");
            Date checkout = sdf.parse(input.next());
            Reservation reservation = new Reservation(roomNumber, checkin, checkout);
            System.out.println("\nReservation: " + reservation);
            System.out.println();

            // Update Dates

            System.out.println("Enter Data to update the reservation:");
            System.out.print("Check-In Date (dd/MM/yyyy): ");
            checkin = sdf.parse(input.next());
            System.out.print("Check-Out Date (dd/MM/yyyy): ");
            checkout = sdf.parse(input.next());
            reservation.updateDates(checkin, checkout);
            System.out.println("\nUpdated Reservation: " + reservation);

        } catch (ParseException e) {
            System.out.println("Invalid Date Format !");

        } catch (DomainException e) {
            System.out.println("Reservation Error: " + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("Unexpected Error !");
        }

    }
}
