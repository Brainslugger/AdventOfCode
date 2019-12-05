package tasks;

import com.sun.istack.internal.Nullable;

public class DayFive {

    public int calculate(int[] intCode, int start, @Nullable Integer input) {
        int steps = 0;
        switch (intCode[start]) {
            case 1:
                intCode[intCode[start + 3]] = add(intCode[intCode[start + 1]], intCode[intCode[start + 2]]);
                steps = 4;
                break;
            case 2:
                intCode[intCode[start + 3]] = multiply(intCode[intCode[start + 1]], intCode[intCode[start + 2]]);
                steps = 4;
                break;
            case 3:
                intCode[intCode[start + 1]] = input;
                steps = 2;
                break;
            case 4:
                write(intCode[intCode[start + 1]]);
                steps = 2;
                break;
            default:
                steps = interpretCodeAndCalculate(intCode, start);
        }
        return steps;
    }

    public int interpretCodeAndCalculate(int[] intCode, int start) {
        int steps = 0;
        String code = String.valueOf(intCode[start]);
        while (code.length() < 4)
            code = "0" + code;
        String opcode = code.substring(code.length() - 2, code.length());
        String parameterOneMode = code.substring(code.length() - 3, code.length() - 2);
        int paramTwo = 0;
        int paramThree = 0;
        if (!opcode.equals("04")) {
            String parameterTwoMode = code.substring(code.length() - 4, code.length() - 3);
            paramTwo = getValueForParam(intCode, start + 2, parameterTwoMode);
            paramThree = getValueForParam(intCode, start + 3, "0");
        }

        int paramOne = getValueForParam(intCode, start + 1, parameterOneMode);

        switch (opcode) {
            case "01":
                intCode[paramThree] = add(paramOne, paramTwo);
                steps = 4;
                break;
            case "02":
                intCode[paramThree] = multiply(paramOne, paramTwo);
                steps = 4;
                break;
            case "04":
                write(paramOne);
                steps = 2;

        }
        return steps;
    }

    public void write(int paramOne) {
        System.out.print(paramOne);
    }

    public int multiply(int paramOne, int paramTwo) {
        return paramOne * paramTwo;
    }

    public int add(int paramOne, int paramTwo) {
        return paramOne + paramTwo;
    }

    public int getValueForParam(int[] intCode, int position, String parameterMode) {
        int result = 0;
        switch (parameterMode) {
            case "0":
                result = intCode[intCode[position]];
                break;
            case "1":
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
                    steps = calculate(program, i, input);
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
