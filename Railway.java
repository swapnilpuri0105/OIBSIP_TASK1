import java.util.*;

public class RailwayReservationSystem {
    // Define static variables
    private static int seatsAvailable = 50;
    private static ArrayList<String> passengerList = new ArrayList<String>();
    private static Scanner input = new Scanner(System.in);

    // Define main method
    public static void main(String[] args) {
        System.out.println("Welcome to the Railway Reservation System");

        // Start reservation process
        while (true) {
            System.out.println("Enter 1 to reserve a seat, 2 to cancel a reservation, 3 to view available seats, 4 to view passenger list, or 5 to exit:");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    cancelReservation();
                    break;
                case 3:
                    viewAvailableSeats();
                    break;
                case 4:
                    viewPassengerList();
                    break;
                case 5:
                    System.out.println("Thank you for using the Railway Reservation System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Define reserveSeat method
    public static void reserveSeat() {
        if (seatsAvailable > 0) {
            System.out.println("Enter passenger name:");
            String name = input.next();
            passengerList.add(name);
            seatsAvailable--;
            System.out.println("Reservation successful. Seat number: " + (50 - seatsAvailable));
        } else {
            System.out.println("Sorry, no seats available.");
        }
    }

    // Define cancelReservation method
    public static void cancelReservation() {
        if (passengerList.size() > 0) {
            System.out.println("Enter passenger name:");
            String name = input.next();
            if (passengerList.contains(name)) {
                passengerList.remove(name);
                seatsAvailable++;
                System.out.println("Reservation cancelled successfully.");
            } else {
                System.out.println("Passenger not found. Please try again.");
            }
        } else {
            System.out.println("No reservations found.");
        }
    }

    // Define viewAvailableSeats method
    public static void viewAvailableSeats() {
        System.out.println("Number of available seats: " + seatsAvailable);
    }

    // Define viewPassengerList method
    public static void viewPassengerList() {
        if (passengerList.size() > 0) {
            System.out.println("Passenger list:");
            for (int i = 0; i < passengerList.size(); i++) {
                System.out.println((i+1) + ". " + passengerList.get(i));
            }
        } else {
            System.out.println("No reservations found.");
        }
    }
}
