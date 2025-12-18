package org.example;
import java.util.Scanner;

public class Main {
    private  static final int SHOW_MENU = 0;
    private static final int OPTION_CHECK_PLACA = 1;
    private  static final int OPTION_EXIT = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = SHOW_MENU;

        System.out.println("Pico y Placa Predictor by Mathias Ruales");

        while (option != OPTION_EXIT) {
            System.out.print("\nOptions: 1 - Check, 2 - Exit" +
                    "\nEnter option: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e ) {
                option = SHOW_MENU;
            }
            switch (option) {
                case OPTION_CHECK_PLACA:
                    PicoPlacaMethods.checkPlaca(scanner);
                    break;
                case OPTION_EXIT:
                    System.out.print("\nThank you for using the application.");
                    break;
                default:
                    System.out.println("Please only enter 1 or 2.");
                    break;
            }
        }
    }
}