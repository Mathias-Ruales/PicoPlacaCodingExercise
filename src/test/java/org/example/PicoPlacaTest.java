package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalTime;

public class PicoPlacaTest {
public DateValidator dateValidator = new DateValidator();

    @Test
    public void emptyPlateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LicensePlate("");
        });
    }

    @Test
    public void allLetterPlateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LicensePlate("PPPPPPP");
        });
    }

    @Test
    public void numerAtTheStartPlateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new LicensePlate("123PPP");
        });
    }

    @Test
    public void validPlateTest() {
        new LicensePlate("PBL-4013");
    }

    @Test
    public void validPlateTestNoHyphen() {
        new LicensePlate("PBL4013");
    }

    @Test
    public void canDriveWeekDay() {
        LicensePlate plate = new LicensePlate("PBL-4013");
        LocalDate date = LocalDate.of(2025, 12, 18);
        LocalTime time = LocalTime.of(12, 30);
        Assertions.assertTrue(dateValidator.canDrive(plate, date, time));
    }

    @Test
    public void canDriveWeekend() {
        LicensePlate plate = new LicensePlate("PBL-4013");
        LocalDate date = LocalDate.of(2025, 12, 14);
        LocalTime time = LocalTime.of(7, 30);
        Assertions.assertTrue(dateValidator.canDrive(plate, date, time));
    }


    @Test
    public void cantDrive() {
        LicensePlate plate = new LicensePlate("PBL-4013");
        LocalDate date = LocalDate.of(2025, 12, 16);
        LocalTime time = LocalTime.of(7, 30);
        Assertions.assertFalse(dateValidator.canDrive(plate, date, time));
    }


}
