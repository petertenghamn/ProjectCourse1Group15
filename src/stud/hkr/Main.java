package stud.hkr;


import java.util.Scanner;

public class Main {

    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
	    Main hotelApp = new Main();
	    hotelApp.runProgram();
    }

    private void runProgram(){
        HotelLogic logic = new HotelLogic();

        boolean running = true;

        while (running) {
            drawMenu();
            int menuChoice = input.nextInt();

            switch (menuChoice){
                case 1: {
                    // make a costumer menu
                    break;
                }
                case 2: {
                    // make a room menu
                    break;
                }
                case 3: {
                    // make a booking menu
                    break;
                }
                case 4: {
                    running = false;
                }
            }
        }

    }

    private void drawMenu(){

        System.out.println("---------------------------------");
        System.out.println("\tWelcome Valued Employee");
        System.out.println("\nWhat will you be doing today?");
        System.out.println("1) Customer");
        System.out.println("2) Room");
        System.out.println("3) Booking");
        System.out.println("4) Nothing\n");
        System.out.println("-----------------------------------");
    }
}
