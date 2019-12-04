package start;

import domain.dayThree.Wire;
import input.Input;
import tasks.DayOne;
import tasks.DayThree;
import tasks.DayTwo;

import java.time.LocalDateTime;
import java.util.Arrays;

public class AdventOfCodeDayThree {

    public static void main(String[] args) {


        Input input = new Input();
        DayThree dayThree = new DayThree();
        System.out.println(("Day Three start: " + LocalDateTime.now()));
        Wire one = dayThree.calculatePositionsForWire(input.wire1);
        System.out.println(("Day Three Wire one ready: " + LocalDateTime.now()));
        Wire two = dayThree.calculatePositionsForWire(input.wire2);
        System.out.println(("Day Three Wire two ready: " + LocalDateTime.now()));
        System.out.println("Day three, part one: " + dayThree.calculateDistanceOfClosestIntersection(one, two));
        System.out.println(("Day Three finished: " + LocalDateTime.now()));
    }
}
