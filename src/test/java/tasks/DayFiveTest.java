package tasks;

import input.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class DayFiveTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private DayFive dayFive;

    @BeforeEach
    void setUp() {
        dayFive = new DayFive();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void shutDown() {
        System.setOut(originalOut);
    }

    @Test
    void testsBasicCalculateAddition() {
        int[] line = new int[]{1, 1, 2, 0};
        int[] result = dayFive.calculate(line, 0, null);
        assertThat(result[0]).isEqualTo(3);
    }

    @Test
    void testsBasicCalculateMultiplicaton() {
        int[] line = new int[]{2, 1, 2, 3};
        int[] result = dayFive.calculate(line, 0, null);
        assertThat(result[3]).isEqualTo(2);
    }

    @Test
    void testsComputeProgram() {
        int[] program = new int[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        int[] endstate = new int[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAddition() {
        int[] program = new int[]{1, 0, 0, 0, 99};
        int[] endstate = new int[]{2, 0, 0, 0, 99};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultiplication() {
        int[] program = new int[]{2, 3, 0, 3, 99};
        int[] endstate = new int[]{2, 3, 0, 6, 99};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAnotherMultiplication() {
        int[] program = new int[]{2, 4, 4, 5, 99, 0};
        int[] endstate = new int[]{2, 4, 4, 5, 99, 9801};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultipleEndpoints() {
        int[] program = new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99};
        int[] endstate = new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramWithoutEndpoints() {
        int[] program = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int[] result = dayFive.computeProgram(program, null);
        assertThat(result).isNull();
    }

    @Test
    void testsFindParameters() {
        Input input = new Input();
        int result = dayFive.findParameters(input.intCode, 3101878);
        assertThat(result).isEqualTo(1202);
    }

    @Test
    void testsFindParametersNoParametersFound() {
        Input input = new Input();
        int result = dayFive.findParameters(input.intCode, -1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testsBasicInput() {
        int[] program = new int[]{3, 0};
        int[] result = dayFive.calculate(program, 0, 30);
        assertThat(result[0]).isEqualTo(30);
    }

    @Test
    void testsBasicOutput() {
        int[] program = new int[]{4, 0};
        dayFive.calculate(program, 0, 30);
        assertThat(outContent.toString()).isEqualTo("Output: 4");
    }

    @Test
    void testsBasicProgramWithInput() {
        int[] program = new int[]{3, 0, 4, 0, 99};
        int[] result = dayFive.computeProgram(program, 42);
        assertThat(result[0]).isEqualTo(42);
        assertThat(outContent.toString()).isEqualTo("Output: 42");

    }
}
