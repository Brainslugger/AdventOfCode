package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DayOneTest {

    private DayOne dayOne;
    private int result;

    @BeforeEach
    public void setUp() {
        dayOne = new DayOne();
        result = 0;
    }

    @Test
    public void testsCalculateFuelForMass0() {
        result = dayOne.calculateFuelForMass(0);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testsCalculateFuelForMass12() {
        result = dayOne.calculateFuelForMass(12);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testsCalculateFuelForMass14() {
        result = dayOne.calculateFuelForMass(14);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void testsCalculateFuelForMass1969() {
        result = dayOne.calculateFuelForMass(1969);
        assertThat(result).isEqualTo(654);
    }

    @Test
    void testsCalculateFuelForMass100756() {
        result = dayOne.calculateFuelForMass(100756);
        assertThat(result).isEqualTo(33583);
    }

    @Test
    void testsCalculateFuelRequirementsForNullInput() {
        result = dayOne.calculateFuelRequirements(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testsCalculateFuelRequirementsForEmptyInput() {
        result = dayOne.calculateFuelRequirements(new int[]{});
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testsCalculateFuelRequirementsForInput() {
        int[] input = new int[]{12, 14, 1969, 100756};
        result = dayOne.calculateFuelRequirements(input);
        assertThat(result).isEqualTo(34241);
    }

    @Test
    void testsCalculateFuelForFuelForMass1969() {
        result = dayOne.calculateFuelForFuel(1969);
        assertThat(result).isEqualTo(966);
    }

    @Test
    void testsCalculateFuelForFuelForMass100756() {
        result = dayOne.calculateFuelForFuel(100756);
        assertThat(result).isEqualTo(50346);
    }

    @Test
    void testsCalculateSumOfFuel() {
        int[] input = new int[]{12, 14, 1969, 100756};
        result = dayOne.calculateSumOfFuel(input);
        assertThat(result).isEqualTo(2 + 2 + 966 + 50346);
    }

}
