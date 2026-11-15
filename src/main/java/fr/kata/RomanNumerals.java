package fr.kata;

public class RomanNumerals {
    public String convert(int number){
        StringBuilder result = new StringBuilder();
        int remaining = number;

        while (remaining >= 10){
            result.append("X");
            remaining -= 10;
        }

        while (remaining >= 9){
            result.append("IX");
            remaining -= 9;
        }

        while (remaining >= 5){
            result.append("V");
            remaining -= 5;
        }

        while (remaining >= 4){
            result.append("IV");
            remaining -= 4;
        }

        while (remaining >= 1){
            result.append("I");
            remaining -= 1;
        }

        return result.toString();
    }
}
