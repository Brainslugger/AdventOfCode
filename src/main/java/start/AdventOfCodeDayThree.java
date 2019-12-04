package start;

import domain.dayThree.Wire;
import input.Input;
import tasks.DayThree;

public class AdventOfCodeDayThree {

    public static void main(String[] args) {


        Input input = new Input();
        DayThree dayThree = new DayThree();
        Wire one = dayThree.calculatePositionsForWire(input.wire1);
        Wire two = dayThree.calculatePositionsForWire(input.wire2);
        System.out.println("Day three, part one: " + dayThree.calculateDistanceOfClosestIntersection(one, two));
        System.out.println("Day three, part two: " + dayThree.calculateStepsForCheapestIntersection(one, two));
    }
}
