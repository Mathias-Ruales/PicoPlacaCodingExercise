package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PicoPlacaMethods {

    public static void checkPlaca (Scanner scanner) {
        System.out.print("\nEnter a license plate: ");
        String input = scanner.nextLine();

        try {
            LicensePlate licensePlate = new LicensePlate(input);

            DateValidator dateValidator = new DateValidator();

            LocalDate date = parseDate(scanner);
            LocalTime time = parseTime(scanner);

            if (dateValidator.canDrive(licensePlate, date, time)){
                System.out.println("You can drive.");
            } else {
                System.out.println("You can't drive.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid. " + e.getMessage());
        }
    }

    public static LocalDate parseDate(Scanner scanner) {
        while (true) {
            System.out.print("\nEnter the date you plan on driving: (dd/mm/yyyy): ");
            String date = scanner.nextLine();
            try {
                return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid date format. Please use dd/MM/yyyy");
            }
        }
    }

    public static LocalTime parseTime(Scanner scanner){
        while (true) {
            System.out.print("\nEnter the time you plan on driving: (hh:mm): ");
            String time = scanner.nextLine();
            try{
                return LocalTime.parse(time);
            } catch (java.time.format.DateTimeParseException e) {
                System.out.println("Invalid time format. Please use hh:mm");
            }
        }
    }
}
