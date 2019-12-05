package start;

import input.Input;
import tasks.DayFive;

public class AdventOfCodeDayFive {

    public static void main(String[] args) {

        DayFive dayFive = new DayFive();
        Input input = new Input();

        dayFive.computeProgram(input.intCodeDayFive, 1);
    }
}
