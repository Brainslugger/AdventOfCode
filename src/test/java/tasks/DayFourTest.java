package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayFourTest {

    DayFour dayFour;

    @BeforeEach
    void setup() {
        dayFour = new DayFour();
    }

    @Test
    void testsNumbersIncreasingForSameDigits() {
        boolean result = dayFour.isIncreasing("111111");
        assertThat(result).isTrue();
    }

    @Test
    void testsNumbersIncreasingForDifferentDigits() {
        boolean result = dayFour.isIncreasing("111123");
        assertThat(result).isTrue();
    }

    @Test
    void testsNumbersIncreasingForAllDifferentDigits() {
        boolean result = dayFour.isIncreasing("135679");
        assertThat(result).isTrue();
    }

    @Test
    void testsNumbersNotIncreasing() {
        boolean result = dayFour.isIncreasing("223450");
        assertThat(result).isFalse();
    }

    @Test
    void testsDoubles() {
        boolean result = dayFour.hasAdjacentDoubles("111123");
        assertThat(result).isTrue();
    }

    @Test
    void testsValidPassword() {
        boolean result = dayFour.isValidPassword("111123");
        assertThat(result).isTrue();
    }

    @Test
    void testsInvalidPassword() {
        boolean result = dayFour.isValidPassword("223450");
        assertThat(result).isFalse();
    }

    @Test
    void testsDoublesAllDigitsTheSame() {
        boolean result = dayFour.hasAdjacentDoubles("111111");
        assertThat(result).isTrue();
    }

    @Test
    void testsDoublesTwoDigitsTheSame() {
        boolean result = dayFour.hasAdjacentDoubles("122345");
        assertThat(result).isTrue();
    }

    @Test
    void testsNoDoubles() {
        boolean result = dayFour.hasAdjacentDoubles("123789");
        assertThat(result).isFalse();
    }

    @Test
    void testsTrueDoubles() {
        boolean result = dayFour.hasTrueDoubles("111122");
        assertThat(result).isTrue();
    }

    @Test
    void testsNoTrueDoubles() {
        boolean result = dayFour.hasTrueDoubles("123444");
        assertThat(result).isFalse();
    }

    @Test
    void testsIsValidPasswordPartTwo() {
        boolean result = dayFour.isValidPasswordPartTwo("112233");
        assertThat(result).isTrue();
    }

    @Test
    void testsIsInvalidPasswordPartTwo() {
        boolean result = dayFour.isValidPasswordPartTwo("123444");
        assertThat(result).isFalse();
    }

}