package start;

import domain.dayThree.Wire;
import input.Input;
import tasks.DayOne;
import tasks.DayThree;
import tasks.DayTwo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class AdventOfCodeDayOne {

    public static void main(String[] args) {

        DayOne dayOne = new DayOne();
        System.out.println("Day one, part one: " + dayOne.calculateFuelRequirements(Input.dayOne));
        System.out.println(("Day one, part two: " + dayOne.calculateSumOfFuel(Input.dayOne)));
    }
}
