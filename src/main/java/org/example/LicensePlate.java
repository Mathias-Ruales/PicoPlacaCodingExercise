package org.example;

public class LicensePlate {
    private final String plateNumber;

    public LicensePlate(String plateNumber) {
        String noHyphen = plateNumber.replaceAll("-", "");
        validatePlate(noHyphen);

        this.plateNumber = plateNumber.toUpperCase();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void validatePlate(String noHyphens) {
        if (noHyphens.length() == 6 || noHyphens.length() == 7 ) {
            for (int i = 0; i < 3; i++) {
                if (!Character.isLetter(noHyphens.charAt(i))) {
                    throw new IllegalArgumentException("The first 3 characters must only be letters.");
                }
            }
            for (int i = 3; i < noHyphens.length(); i++) {
                if (!Character.isDigit(noHyphens.charAt(i))){
                    throw new IllegalArgumentException((noHyphens.charAt(i) + " is not a digit. The Last characters must only be digits."));
                }
            }
        } else {
            throw new IllegalArgumentException("Length not met: " + noHyphens.length());
        }
    }

    public int getLastNumber() {
        String numbers = plateNumber.replaceAll("[^0-9]", "");
            char last = numbers.charAt(numbers.length() - 1);
            return Character.getNumericValue(last);
    }


}
