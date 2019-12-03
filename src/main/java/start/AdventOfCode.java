package start;

import input.Input;
import tasks.DayOne;
import tasks.DayTwo;

import java.util.Arrays;

public class AdventOfCode {

    public static void main(String[] args) {

        DayOne dayOne = new DayOne();
        System.out.println("Day one, part one: " + dayOne.calculateFuelRequirements(Input.dayOne));
        System.out.println(("Day one, part two: " + dayOne.calculateSumOfFuel(Input.dayOne)));

        DayTwo dayTwo = new DayTwo();
        Input input = new Input();
        input.intCode[1] = 12;
        input.intCode[2] = 2;
        System.out.println("Day two, part one: " + Arrays.toString(dayTwo.computeProgram(input.intCode)));
        input = new Input();
        System.out.println("Day two, part two: " + dayTwo.findParameters(input.intCode, 19690720));

    }
}
