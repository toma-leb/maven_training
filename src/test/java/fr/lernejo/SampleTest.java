package fr.lernejo;

import fr.lernejo.Sample;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {

    @ParameterizedTest
    @CsvSource({
        "ADD, 1, 1, 2",
        "ADD, -1, 10, 9",
        "MULT, 1, 0, 0",
        "MULT, 0, 10, 0",
        "MULT, 10, 10, 100",
        "MULT, -5, -5, 25",
        "MULT, -5, 10, -50"
    })
    void op(Sample.Operation opTest, int n1, int n2, int expectedResult) {
        int result = Sample.op(opTest, n1, n2);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void fact() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Sample.fact(-1))
            .withMessage("N should be positive");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "13, 1932053504"
    })
    void fact_test_cases(int n, int expectedResult) {
        int result = Sample.fact(n);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}
