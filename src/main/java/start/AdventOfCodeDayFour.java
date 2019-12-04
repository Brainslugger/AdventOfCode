package start;

import tasks.DayFour;

import java.util.stream.IntStream;

public class AdventOfCodeDayFour {

    public static void main(String[] args) {

        DayFour dayFour = new DayFour();
        int counter = IntStream.rangeClosed(264793, 803935).map(i -> dayFour.isValidPassword(String.valueOf(i)) ? 1 : 0).sum();
        System.out.println("Day four, part one: " + counter);
        counter = IntStream.rangeClosed(264793, 803935).map(i -> dayFour.isValidPasswordPartTwo(String.valueOf(i)) ? 1 : 0).sum();
        System.out.println("Day four, part two: " + counter);
    }
}
