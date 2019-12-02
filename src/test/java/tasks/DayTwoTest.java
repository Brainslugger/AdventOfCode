package tasks;

import input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DayTwoTest {
        private DayTwo dayTwo;

    @BeforeEach
    void setUp() {
        dayTwo = new DayTwo();


    }

    @Test
    void testsBasicCalculateAddition(){
        int[] line = new int[]{1, 1, 2, 0};
        int[] result = dayTwo.calculate(line, 0);
        assertThat(result[0]).isEqualTo(3);
    }

    @Test
    void testsBasicCalculateMultiplicaton(){
        int[] line = new int[]{2, 1, 2, 3};
        int[] result = dayTwo.calculate(line, 0);
        assertThat(result[3]).isEqualTo(2);
    }

    @Test
    void testsComputeProgram(){
        int[] program = new int[]{1,9,10,3,2,3,11,0,99,30,40,50};
        int[] endstate = new int[]{3500,9,10,70,
                2,3,11,0,
                99,
                30,40,50};
        int[] result = dayTwo.computeProgram(program);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAddition(){
        int[] program = new int[]{1,0,0,0,99};
        int[] endstate = new int[]{2,0,0,0,99};
        int[] result = dayTwo.computeProgram(program);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultiplication(){
        int[] program = new int[]{2,3,0,3,99};
        int[] endstate = new int[]{2,3,0,6,99};
        int[] result = dayTwo.computeProgram(program);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAnotherMultiplication(){
        int[] program = new int[]{2,4,4,5,99,0};
        int[] endstate = new int[]{2,4,4,5,99,9801};
        int[] result = dayTwo.computeProgram(program);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultipleEndpoints(){
        int[] program = new int[]{1,1,1,4,99,5,6,0,99};
        int[] endstate = new int[]{30,1,1,4,2,5,6,0,99};
        int[] result = dayTwo.computeProgram(program);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsFindParameters(){
        Input input = new Input();
        int result = dayTwo.findParameters(input.intCode, 3101878);
        assertThat(result).isEqualTo(1202);
    }
}