package tasks;

import com.sun.istack.internal.Nullable;

public class DayFive {

    public int interpretCodeAndCalculate(int[] intCode, int start, @Nullable Integer input) {
        int steps = 0;
        int instruction = intCode[start];
        int opcode = instruction % 10;
        instruction /= 100;
        int parameterOneMode = instruction % 10;
        instruction /= 10;
        int parameterTwoMode = instruction % 10;
        int paramOne = 0;
        int paramTwo = 0;
        int paramThree = 0;

        switch (opcode) {
            case 1:
            case 2:
                paramOne = getValueForParam(intCode, start + 1, parameterOneMode);
                paramTwo = getValueForParam(intCode, start + 2, parameterTwoMode);
                paramThree = getValueForParam(intCode, start + 3, 1);
                break;
            case 3:
                paramThree = getValueForParam(intCode, start + 3, 1);
                break;
            case 4:
                paramOne = getValueForParam(intCode, start + 1, parameterOneMode);

        }

        switch (opcode) {
            case 1:
                intCode[paramThree] = add(paramOne, paramTwo);
                steps = 4;
                break;
            case 2:
                intCode[paramThree] = multiply(paramOne, paramTwo);
                steps = 4;
                break;
            case 3:
                intCode[paramThree] = input;
                steps = 2;
                break;
            case 4:
                output(paramOne);
                steps = 2;

        }
        return steps;
    }

    public void output(int paramOne) {
        System.out.print(paramOne);
    }

    public int multiply(int paramOne, int paramTwo) {
        return paramOne * paramTwo;
    }

    public int add(int paramOne, int paramTwo) {
        return paramOne + paramTwo;
    }

    public int getValueForParam(int[] intCode, int position, int parameterMode) {
        int result = 0;
        switch (parameterMode) {
            case 0:
                result = intCode[intCode[position]];
                break;
            case 1:
                result = intCode[position];
                break;
        }
        return result;
    }

    public int[] computeProgram(int[] program, @Nullable Integer input) {
        try {
            int steps;
            for (int i = 0; i < program.length; ) {
                if (program[i] == 99) {
                    return program;
                } else {
                    steps = interpretCodeAndCalculate(program, i, input);
                    i += steps;
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
