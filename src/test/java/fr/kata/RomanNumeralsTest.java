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
}
