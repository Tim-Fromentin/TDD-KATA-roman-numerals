package fr.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RomainNumeralsTest {

    private final RomainNumerals romainNumerals = new RomainNumerals();

    @Test
    void shouldRepeatI_forOneToThree(){
        String resultForOne = romainNumerals.convert(1);
        String resultForTwo = romainNumerals.convert(2);

        assertThat(resultForOne).isEqualTo("I");
        assertThat(resultForTwo).isEqualTo("II");
    }
}
