package fr.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RomanNumeralsTest {

    private final RomanNumerals romanNumerals = new RomanNumerals();

    @Test
    void shouldRepeatI_forOneToThree(){
        String resultForOne = romanNumerals.convert(1);
        String resultForTwo = romanNumerals.convert(2);
        String resultForThree = romanNumerals.convert(3);

        assertThat(resultForOne).isEqualTo("I");
        assertThat(resultForTwo).isEqualTo("II");
        assertThat(resultForThree).isEqualTo("III");
    }

    @Test
    void shouldConvertFive(){
        String resultForFive = romanNumerals.convert(5);

        assertThat(resultForFive).isEqualTo("V");
    }

    @Test
    void shouldAddIAfterV(){
        String resultForSix = romanNumerals.convert(6);
        String resultForSeven = romanNumerals.convert(7);
        String resultForEight = romanNumerals.convert(8);

        assertThat(resultForSix).isEqualTo("VI");
        assertThat(resultForSeven).isEqualTo("VII");
        assertThat(resultForEight).isEqualTo("VIII");
    }

    @Test
    void shouldConvertTens(){
        String resultForTen = romanNumerals.convert(10);
        String resultForSixteen = romanNumerals.convert(16);
        String resultForTwenty = romanNumerals.convert(20);
        String resultForThirty = romanNumerals.convert(30);
        String resultForThirtyEight = romanNumerals.convert(38);

        assertThat(resultForTen).isEqualTo("X");
        assertThat(resultForSixteen).isEqualTo("XVI");
        assertThat(resultForTwenty).isEqualTo("XX");
        assertThat(resultForThirty).isEqualTo("XXX");
        assertThat(resultForThirtyEight).isEqualTo("XXXVIII");
    }

    @Test
    void shouldUseSubtractiveNotation(){
        String resultForFour = romanNumerals.convert(4);
        String resultForNine = romanNumerals.convert(9);
        String resultForForty = romanNumerals.convert(40);
        String resultForNinety = romanNumerals.convert(90);
        String resultForFourHundred = romanNumerals.convert(400);
        String resultForNineHundred = romanNumerals.convert(900);

        assertThat(resultForFour).isEqualTo("IV");
        assertThat(resultForNine).isEqualTo("IX");
        assertThat(resultForForty).isEqualTo("XL");
        assertThat(resultForNinety).isEqualTo("XC");
        assertThat(resultForFourHundred).isEqualTo("CD");
        assertThat(resultForNineHundred).isEqualTo("CM");
    }

    @Test
    void shouldConvertBaseSymbols(){
        String resultForOne = romanNumerals.convert(1);
        String resultForFive = romanNumerals.convert(5);
        String resultForTen = romanNumerals.convert(10);
        String resultForFifty = romanNumerals.convert(50);
        String resultForOneHundred = romanNumerals.convert(100);
        String resultForFiveHundred = romanNumerals.convert(500);
        String resultForThousand = romanNumerals.convert(1000);

        assertThat(resultForOne).isEqualTo("I");
        assertThat(resultForTen).isEqualTo("X");
        assertThat(resultForFive).isEqualTo("V");
        assertThat(resultForFifty).isEqualTo("L");
        assertThat(resultForOneHundred).isEqualTo("C");
        assertThat(resultForFiveHundred).isEqualTo("D");
        assertThat(resultForThousand).isEqualTo("M");
    }

    @Test
    void shouldConvertLargeNumbers(){
        String resultForOneThousandNineHundredNinetyfour = romanNumerals.convert(1994);
        String resultForTwoThousandTwentysix = romanNumerals.convert(2026);
        String resultForThreeThousandNineHundredNinetynine = romanNumerals.convert(3999);

        assertThat(resultForOneThousandNineHundredNinetyfour).isEqualTo("MCMXCIV");
        assertThat(resultForTwoThousandTwentysix).isEqualTo("MMXXVI");
        assertThat(resultForThreeThousandNineHundredNinetynine).isEqualTo("MMMCMXCIX");
    }
}
