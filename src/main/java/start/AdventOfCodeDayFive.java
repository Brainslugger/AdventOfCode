package start;

import input.Input;
import tasks.DayFive;

import java.util.Arrays;

public class AdventOfCodeDayFive {

    public static void main(String[] args) {

        DayFive dayFive = new DayFive();
        Input input = new Input();

        System.out.println("Day five, part one: " + Arrays.toString(dayFive.computeProgram(input.intCodeDayFive, 1)));
    }
}
