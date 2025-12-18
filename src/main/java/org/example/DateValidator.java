package org.example;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class DateValidator {
    private static final LocalTime PICO_MORNING_START = LocalTime.of(6, 0);
    private static final LocalTime PICO_MORNING_END = LocalTime.of(9, 30);
    private static final LocalTime PICO_AFTERNOON_START = LocalTime.of(16, 0);
    private static final LocalTime PICO_AFTERNOON_END = LocalTime.of(20, 0);

    public boolean canDrive(LicensePlate plate, LocalDate date, LocalTime time) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }
        if (!isPicoDay(plate.getLastNumber(), dayOfWeek)){
            return true;
        }
        if (!isPicoTime(time)){
            return true;
        }
        return false;
    }

    public boolean isPicoDay(int lastDigit, DayOfWeek dayOfWeek){
        switch(dayOfWeek){
            case MONDAY: return lastDigit == 1 || lastDigit == 2;
            case TUESDAY: return lastDigit == 3 || lastDigit == 4;
            case WEDNESDAY: return lastDigit == 5 || lastDigit == 6;
            case THURSDAY: return lastDigit == 7 || lastDigit == 8;
            case FRIDAY: return lastDigit == 9 || lastDigit == 0;
            default: return false;
        }
    }

    public boolean isPicoTime(LocalTime time){
        return (!time.isBefore(PICO_MORNING_START) && !time.isAfter(PICO_MORNING_END)) ||
                (!time.isBefore(PICO_AFTERNOON_START) && !time.isAfter(PICO_AFTERNOON_END));
    }
}
