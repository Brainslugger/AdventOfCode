package start;

import input.Input;
import tasks.DayFive;

public class AdventOfCodeDayFive {

    public static void main(String[] args) {

        DayFive dayFive = new DayFive();
        Input input = new Input();

        System.out.print("Day five, part one: ");
        dayFive.computeProgram(input.intCodeDayFive, 1);
        System.out.print("\nDay five, part two: ");
        input = new Input();
        dayFive.computeProgram(input.intCodeDayFive, 5);
    }
}
