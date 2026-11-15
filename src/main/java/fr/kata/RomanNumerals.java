package fr.kata;

public class RomanNumerals {
    public String convert(int number){
        StringBuilder result = new StringBuilder();

        if (number == 5){
            return "V";
        }

        for (int i = 1; i <= number; i++){
            result.append("I");
        }

        return result.toString();
    }
}
