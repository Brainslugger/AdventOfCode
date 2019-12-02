package tasks;

public class DayTwo {

    public int[] calculate(int[] intCode, int start) {
        switch (intCode[start]) {
            case 1:
                intCode[intCode[start + 3]] = intCode[intCode[start + 1]] + intCode[intCode[start + 2]];
                break;
            case 2:
                intCode[intCode[start + 3]] = intCode[intCode[start + 1]] * intCode[intCode[start + 2]];
                break;
        }
        return intCode;
    }

    public int[] computeProgram(int[] program) {
        try {
            for (int i = 0; i < program.length; i += 4) {
                if (program[i] == 99) {
                    return program;
                } else {
                    program = calculate(program, i);
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
                trial = computeProgram(trial);
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
