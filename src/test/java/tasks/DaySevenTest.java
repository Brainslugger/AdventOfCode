package tasks;

import input.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DaySevenTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private DaySeven daySeven;

    @BeforeEach
    void setUp() {
        daySeven = new DaySeven();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void shutDown() {
        System.setOut(originalOut);
    }

    @Test
    void testsComputeProgram() {
        int[] program = new int[]{1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50};
        int[] endstate = new int[]{3500, 9, 10, 70, 2, 3, 11, 0, 99, 30, 40, 50};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAddition() {
        int[] program = new int[]{1, 0, 0, 0, 99};
        int[] endstate = new int[]{2, 0, 0, 0, 99};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultiplication() {
        int[] program = new int[]{2, 3, 0, 3, 99};
        int[] endstate = new int[]{2, 3, 0, 6, 99};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramAnotherMultiplication() {
        int[] program = new int[]{2, 4, 4, 5, 99, 0};
        int[] endstate = new int[]{2, 4, 4, 5, 99, 9801};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramMultipleEndpoints() {
        int[] program = new int[]{1, 1, 1, 4, 99, 5, 6, 0, 99};
        int[] endstate = new int[]{30, 1, 1, 4, 2, 5, 6, 0, 99};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isEqualTo(endstate);
    }

    @Test
    void testsComputeProgramWithoutEndpoints() {
        int[] program = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int[] result = daySeven.computeProgram(program, null);
        assertThat(result).isNull();
    }

    @Test
    void testsFindParameters() {
        Input input = new Input();
        int result = daySeven.findParameters(input.intCode, 3101878);
        assertThat(result).isEqualTo(1202);
    }

    @Test
    void testsFindParametersNoParametersFound() {
        Input input = new Input();
        int result = daySeven.findParameters(input.intCode, -1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void testsBasicProgramWithInput() {
        int[] program = new int[]{3, 0, 4, 0, 99};
        int[] result = daySeven.computeProgram(program, new int[]{42});
        assertThat(result[0]).isEqualTo(42);
        assertThat(outContent.toString()).isEqualTo("42");
    }

    @Test
    void testsInterpretCodeAndCalculateMixedModeAdd() {
        int[] program = new int[]{1001, 4, 3, 2, 5};
        daySeven.interpretCodeAndCalculate(program, 0, null);
        assertThat(program[2]).isEqualTo(8);
    }

    @Test
    void testsInterpretCodeAndCalculateImmediateModeAdd() {
        int[] program = new int[]{1101, 4, 3, 4, 0};
        daySeven.interpretCodeAndCalculate(program, 0, null);
        assertThat(program[4]).isEqualTo(7);
    }

    @Test
    void testsInterpretCodeAndCalculateMixedModeMultiply() {
        int[] program = new int[]{1002, 4, 3, 4, 33};
        daySeven.interpretCodeAndCalculate(program, 0, null);
        assertThat(program[4]).isEqualTo(99);
    }

    @Test
    void testsInterpretCodeAndCalculateImmediateModeOutput() {
        int[] program = new int[]{104, 2, 1, 2};
        daySeven.interpretCodeAndCalculate(program, 0, null);
        assertThat(outContent.toString()).isEqualTo("2");
    }

    @Test
    void testsInterpretCodeAndCalculatePositionModeOutput() {
        int[] program = new int[]{4, 2, 1, 5};
        daySeven.interpretCodeAndCalculate(program, 0, null);
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsInterpretCodeAndCalculateInput() {
        int[] program = new int[]{3, 2, 1, 2};
        daySeven.interpretCodeAndCalculate(program, 0, new int[]{100});
        assertThat(program[2]).isEqualTo(100);
    }

    @Test
    void testsJumpIfTrueValueIsZero() {
        int result = daySeven.jumpIfTrue(0, 1, 0);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testsJumpIfFalseValueIsZero() {
        int result = daySeven.jumpIfFalse(0, 1, 0);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void testsJumpIfFalseValueIsNotZero() {
        int result = daySeven.jumpIfFalse(20, 1, 0);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void testLessThanIsTrue() {
        int[] program = new int[]{7, 1, 2, 0};
        daySeven.lessThan(program[1], program[2], program[3], program);
        assertThat(program[0]).isEqualTo(1);
    }

    @Test
    void testLessThanIsFalse() {
        int[] program = new int[]{7, 2, 1, 0};
        daySeven.lessThan(program[1], program[2], program[3], program);
        assertThat(program[0]).isEqualTo(0);
    }

    @Test
    void testisEqualIsTrue() {
        int[] program = new int[]{7, 1, 1, 0};
        daySeven.isEqual(program[1], program[2], program[3], program);
        assertThat(program[0]).isEqualTo(1);
    }

    @Test
    void testisEqualIsFalse() {
        int[] program = new int[]{7, 2, 1, 0};
        daySeven.lessThan(program[1], program[2], program[3], program);
        assertThat(program[0]).isEqualTo(0);
    }

    @Test
    void testsBasicProgramForIsEqualWithInputPositionMode() {
        int[] program = new int[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8};
        daySeven.computeProgram(program, new int[]{8});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsBasicProgramForIsNotEqualWithInputPositionMode() {
        int[] program = new int[]{3, 9, 8, 9, 10, 9, 4, 9, 99, -1, 8};
        daySeven.computeProgram(program, new int[]{7});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForIsEqualWithInputImmediateMode() {
        int[] program = new int[]{3, 3, 1108, -1, 8, 3, 4, 3, 99};
        daySeven.computeProgram(program, new int[]{8});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsBasicProgramForIsNotEqualWithInputImmediateMode() {
        int[] program = new int[]{3, 3, 1108, -1, 8, 3, 4, 3, 99};
        daySeven.computeProgram(program, new int[]{7});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForLessThanWithInputPositionMode() {
        int[] program = new int[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8};
        daySeven.computeProgram(program, new int[]{7});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsBasicProgramForIsNotLessThanWithInputPositionMode() {
        int[] program = new int[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8};
        daySeven.computeProgram(program, new int[]{8});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForLessThanWithInputImmediateMode() {
        int[] program = new int[]{3, 9, 7, 9, 10, 9, 4, 9, 99, -1, 8};
        daySeven.computeProgram(program, new int[]{7});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsBasicProgramForIsNotLessThanWithInputImmediateMode() {
        int[] program = new int[]{3, 3, 1107, -1, 8, 3, 4, 3, 99};
        daySeven.computeProgram(program, new int[]{8});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForJumpsWithInputZeroPositionMode() {
        int[] program = new int[]{3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9};
        daySeven.computeProgram(program, new int[]{0});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForJumpsWithInputOnePositionMode() {
        int[] program = new int[]{3, 12, 6, 12, 15, 1, 13, 14, 13, 4, 13, 99, -1, 0, 1, 9};
        daySeven.computeProgram(program, new int[]{2});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsBasicProgramForJumpsWithInputZeroImmediateMode() {
        int[] program = new int[]{3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1};
        daySeven.computeProgram(program, new int[]{0});
        assertThat(outContent.toString()).isEqualTo("0");
    }

    @Test
    void testsBasicProgramForJumpsWithInputOneImmediateMode() {
        int[] program = new int[]{3, 3, 1105, -1, 9, 1101, 0, 0, 12, 4, 12, 99, 1};
        daySeven.computeProgram(program, new int[]{1});
        assertThat(outContent.toString()).isEqualTo("1");
    }

    @Test
    void testsIfInputNumberIsBelowEight() {
        int[] program = new int[]{3,
                                  21,
                                  1008,
                                  21,
                                  8,
                                  20,
                                  1005,
                                  20,
                                  22,
                                  107,
                                  8,
                                  21,
                                  20,
                                  1006,
                                  20,
                                  31,
                                  1106,
                                  0,
                                  36,
                                  98,
                                  0,
                                  0,
                                  1002,
                                  21,
                                  125,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  104,
                                  999,
                                  1105,
                                  1,
                                  46,
                                  1101,
                                  1000,
                                  1,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  98,
                                  99};
        daySeven.computeProgram(program, new int[]{7});
        assertThat(outContent.toString()).isEqualTo("999");
    }

    @Test
    void testsIfInputNumberIsEqualToEight() {
        int[] program = new int[]{3,
                                  21,
                                  1008,
                                  21,
                                  8,
                                  20,
                                  1005,
                                  20,
                                  22,
                                  107,
                                  8,
                                  21,
                                  20,
                                  1006,
                                  20,
                                  31,
                                  1106,
                                  0,
                                  36,
                                  98,
                                  0,
                                  0,
                                  1002,
                                  21,
                                  125,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  104,
                                  999,
                                  1105,
                                  1,
                                  46,
                                  1101,
                                  1000,
                                  1,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  98,
                                  99};
        daySeven.computeProgram(program, new int[]{8});
        assertThat(outContent.toString()).isEqualTo("1000");
    }

    @Test
    void testsIfInputNumberIsAboveEight() {
        int[] program = new int[]{3,
                                  21,
                                  1008,
                                  21,
                                  8,
                                  20,
                                  1005,
                                  20,
                                  22,
                                  107,
                                  8,
                                  21,
                                  20,
                                  1006,
                                  20,
                                  31,
                                  1106,
                                  0,
                                  36,
                                  98,
                                  0,
                                  0,
                                  1002,
                                  21,
                                  125,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  104,
                                  999,
                                  1105,
                                  1,
                                  46,
                                  1101,
                                  1000,
                                  1,
                                  20,
                                  4,
                                  20,
                                  1105,
                                  1,
                                  46,
                                  98,
                                  99};
        daySeven.computeProgram(program, new int[]{9});
        assertThat(outContent.toString()).isEqualTo("1001");
    }

    @Test
    void testsCalculateMaxThrusterSignalForInput() {
        //given
        int[] program = new int[]{3, 15, 3, 16, 1002, 16, 10, 16, 1, 16, 15, 15, 4, 15, 99, 0, 0};
        List<Integer> initialPhaseSettings = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0));
        //when
        int result = daySeven.calculateMaxThrusterSignal(program, initialPhaseSettings);
        //then
        assertThat(result).isEqualTo(43210);
    }

    @Test
    void testsCalculateMaxThrusterSignalForSecondInput() {
        //given
        int[] program =
            new int[]{3, 23, 3, 24, 1002, 24, 10, 24, 1002, 23, -1, 23, 101, 5, 23, 23, 1, 24, 23, 23, 4, 23, 99, 0, 0};
        List<Integer> initialPhaseSettings = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0));
        //when
        int result = daySeven.calculateMaxThrusterSignal(program, initialPhaseSettings);
        //then
        assertThat(result).isEqualTo(54321);
    }

    @Test
    void testsCalculateMaxThrusterSignalForThirdInput() {
        //given
        int[] program = new int[]{3,
                                  31,
                                  3,
                                  32,
                                  1002,
                                  32,
                                  10,
                                  32,
                                  1001,
                                  31,
                                  -2,
                                  31,
                                  1007,
                                  31,
                                  0,
                                  33,
                                  1002,
                                  33,
                                  7,
                                  33,
                                  1,
                                  33,
                                  31,
                                  31,
                                  1,
                                  32,
                                  31,
                                  31,
                                  4,
                                  31,
                                  99,
                                  0,
                                  0,
                                  0};
        List<Integer> initialPhaseSettings = new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0));
        //when
        int result = daySeven.calculateMaxThrusterSignal(program, initialPhaseSettings);
        //then
        assertThat(result).isEqualTo(65210);
    }
}
