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

        assertThat(resultForTen).isEqualTo("X");
        assertThat(resultForSixteen).isEqualTo("XVI");
        assertThat(resultForTwenty).isEqualTo("XX");
        assertThat(resultForThirty).isEqualTo("XXX");
    }
}
