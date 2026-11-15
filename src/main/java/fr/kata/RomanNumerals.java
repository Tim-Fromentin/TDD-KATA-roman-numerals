package fr.kata;

public class RomanNumerals {
    public String convert(int number){
        StringBuilder result = new StringBuilder();
        int remaining = number;

        if (number == 10){
            return "X";
        }

        if (remaining >= 5){
            result.append("V");
            remaining -= 5;
        }

        for (int i = 1; i <= remaining; i++){
            result.append("I");
        }

        return result.toString();
    }
}
