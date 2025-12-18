package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.example.LicensePlate;
import org.example.DateValidator;

public class Main {
    private  static final int SHOW_MENU = 0;
    private static final int OPTION_CHECK_PLACA = 1;
    private  static final int OPTION_EXIT = 2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = SHOW_MENU;
        System.out.println("Pico y Placa Predictor");

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
                    checkPlaca(scanner);
                    break;
                case OPTION_EXIT:
                    System.out.print("\nThank you");
                    break;
                default:
                    System.out.println("Please only enter 1 or 2.");
                    break;
            }
        }
    }

    public static void checkPlaca (Scanner scanner) {
        System.out.print("\nEnter a license plate: ");
        String input = scanner.nextLine();

        try {
            LicensePlate licensePlate = new LicensePlate(input);
            System.out.println("License Plate: " +licensePlate.getPlateNumber() + " last number: " + licensePlate.getLastNumber());
            DateValidator dateValidator = new DateValidator();

            System.out.print("\nEnter the date you plan on driving: (dd/mm/yyyy): ");
            String date = scanner.nextLine();
            LocalDate dateFormat = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            System.out.print("\nEnter the time you plan on driving: (hh:mm): ");
            String time = scanner.nextLine();
            LocalTime timeFormat = LocalTime.parse(time);

            if (dateValidator.canDrive(licensePlate, dateFormat, timeFormat)){
                System.out.println("You can drive.");
            } else {
                System.out.println("You can't drive.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid. " + e.getMessage());
        }
        catch (java.time.format.DateTimeParseException e) {
            System.out.println("Invalid Date/Time format. Please use dd/MM/yyyy and HH:mm");
        }

    }
}