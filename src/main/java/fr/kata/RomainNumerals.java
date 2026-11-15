package fr.kata;

public class RomainNumerals {
    public String convert(Integer number){
        StringBuilder result = new StringBuilder();
        if (number == 2){
            return "II";
        }
        for (int i = 1; i <= number; i++){
            result.append("I");
        }
        return result.toString();
    }
}
