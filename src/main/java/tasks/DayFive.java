package tasks;

import com.sun.istack.internal.Nullable;

public class DayFive {

    public int[] calculate(int[] intCode, int start, @Nullable Integer input) {
        switch (intCode[start]) {
            case 1:
                intCode[intCode[start + 3]] = intCode[intCode[start + 1]] + intCode[intCode[start + 2]];
                break;
            case 2:
                intCode[intCode[start + 3]] = intCode[intCode[start + 1]] * intCode[intCode[start + 2]];
                break;
            case 3:
                intCode[intCode[start + 1]] = input;
                break;
            case 4:
                System.out.print("Output: " + intCode[intCode[start + 1]]);
                break;
        }
        return intCode;
    }

    public int[] computeProgram(int[] program, @Nullable Integer input) {
        try {
            for (int i = 0; i < program.length; i += 4) {
                if (program[i] == 99) {
                    return program;
                } else {
                    program = calculate(program, i, input);
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int findParameters(final int[] program, int result) {
        int[] trial = program.clone();
        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                trial[1] = noun;
                trial[2] = verb;
                trial = computeProgram(trial, null);
                if (trial[0] == result) {
                    return 100 * trial[1] + trial[2];
                } else {
                    trial = program.clone();
                }
            }
        }
        return 0;
    }
}
