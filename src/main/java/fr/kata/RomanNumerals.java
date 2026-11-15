package fr.kata;

import fr.kata.dto.RomanSymbol;

import java.util.List;

public class RomanNumerals {

    private static final List<RomanSymbol> ROMAN_SYMBOLS = List.of(
            new RomanSymbol(900, "CM"),
            new RomanSymbol(400, "CD"),
            new RomanSymbol(100, "C"),
            new RomanSymbol(90, "XC"),
            new RomanSymbol(50, "L"),
            new RomanSymbol(40, "XL"),
            new RomanSymbol(10, "X"),
            new RomanSymbol(9, "IX"),
            new RomanSymbol(5, "V"),
            new RomanSymbol(4, "IV"),
            new RomanSymbol(1, "I")
    );

    public String convert(int number) {
        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (RomanSymbol romanSymbol : ROMAN_SYMBOLS) {
            while (remaining >= romanSymbol.value()) {
                result.append(romanSymbol.symbol());
                remaining -= romanSymbol.value();
            }
        }

        return result.toString();
    }
}
