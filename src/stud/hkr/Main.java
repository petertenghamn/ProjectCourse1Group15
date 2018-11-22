package stud.hkr;

import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main hotelApp = new Main();
        hotelApp.runProgram();
    }

    private void runProgram() {


        boolean running = true;

        do {
            drawMenu();
            HotelLogic logic = new HotelLogic();

            System.out.print("\nSelect Action: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Making A Reservation");
                    break;

                case 2:
                    System.out.println("Changing A Reservation");
                    break;

                case 3:
                    System.out.println("Viewing Reservations");
                    break;

                case 4:
                    System.out.println("Cancelling Reservations");
                    break;

                case 5:
                    System.out.println("Program is now shut down");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice.\nPlease enter a valid choice between 1-5");
                    break;
            }
        } while (running);
    }

    private void drawMenu() {

        System.out.println("_____________________________");
        System.out.println("|   Welcome Dear Employee   |");
        System.out.println("|                           |");
        System.out.println("|  1.) Make A Reservation   |");
        System.out.println("|  2.) Change Reservation   |");
        System.out.println("|  3.) View Reservations    |");
        System.out.println("|  4.) Cancel Reservations  |");
        System.out.println("|  5.) Exit                 |");
        System.out.println("-----------------------------");

    }
}
