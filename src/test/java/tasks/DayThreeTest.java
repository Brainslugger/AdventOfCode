package tasks;

import domain.dayThree.Point;
import domain.dayThree.Wire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DayThreeTest {

    DayThree dayThree;

    @BeforeEach
    void setup() {
        dayThree = new DayThree();
    }

    @Test
    void testsCalculatePositionsStepRight() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(1, 0, 1));
        result.add(new Point(2, 0, 2));
        result.add(new Point(3, 0, 3));

        Wire wire = dayThree.calculatePositionsForWire("R3");
        assertThat(wire.getPositions()).isEqualTo(result);
    }

    @Test
    void testsCalculatePositionsStepLeft() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(-1, 0, 1));
        result.add(new Point(-2, 0, 2));
        result.add(new Point(-3, 0, 3));

        Wire wire = dayThree.calculatePositionsForWire("L3");
        assertThat(wire.getPositions()).isEqualTo(result);
    }

    @Test
    void testsCalculatePositionsStepUp() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(0, 1, 1));
        result.add(new Point(0, 2, 2));
        result.add(new Point(0, 3, 3));

        Wire wire = dayThree.calculatePositionsForWire("U3");
        assertThat(wire.getPositions()).isEqualTo(result);
    }

    @Test
    void testsCalculatePositionsStepDown() {
        List<Point> result = new ArrayList<>();
        result.add(new Point(0, -1, 1));
        result.add(new Point(0, -2, 2));
        result.add(new Point(0, -3, 3));

        Wire wire = dayThree.calculatePositionsForWire("D3");
        assertThat(wire.getPositions()).isEqualTo(result);
    }

    @Test
    void testsCalculateDistanceOfClosestIntersection() {
        Wire one = dayThree.calculatePositionsForWire("R8,U5,L5,D3");
        Wire two = dayThree.calculatePositionsForWire("U7,R6,D4,L4");
        int distance = dayThree.calculateDistanceOfClosestIntersection(one, two);
        assertThat(distance).isEqualTo(6);
    }

    @Test
    void testsCalculateDistanceOfClosestIntersectionForLongerWires() {
        Wire one = dayThree.calculatePositionsForWire("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        Wire two = dayThree.calculatePositionsForWire("U62,R66,U55,R34,D71,R55,D58,R83");
        int distance = dayThree.calculateDistanceOfClosestIntersection(one, two);
        assertThat(distance).isEqualTo(159);
    }

    @Test
    void testsCalculateDistanceOfClosestIntersectionForWires() {
        Wire one = dayThree.calculatePositionsForWire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        Wire two = dayThree.calculatePositionsForWire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        int distance = dayThree.calculateDistanceOfClosestIntersection(one, two);
        assertThat(distance).isEqualTo(135);
    }

    @Test
    void testsCalculateCheapestIntersection() {
        Wire one = dayThree.calculatePositionsForWire("R8,U5,L5,D3");
        Wire two = dayThree.calculatePositionsForWire("U7,R6,D4,L4");
        int steps = dayThree.calculateStepsForCheapestIntersection(one, two);
        assertThat(steps).isEqualTo(30);
    }

    @Test
    void testsCalculateCheapestIntersectionForLongerWires() {
        Wire one = dayThree.calculatePositionsForWire("R75,D30,R83,U83,L12,D49,R71,U7,L72");
        Wire two = dayThree.calculatePositionsForWire("U62,R66,U55,R34,D71,R55,D58,R83");
        int steps = dayThree.calculateStepsForCheapestIntersection(one, two);
        assertThat(steps).isEqualTo(610);
    }

    @Test
    void testsCalculateCheapestIntersectionForWires() {
        Wire one = dayThree.calculatePositionsForWire("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51");
        Wire two = dayThree.calculatePositionsForWire("U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");
        int steps = dayThree.calculateStepsForCheapestIntersection(one, two);
        assertThat(steps).isEqualTo(410);
    }

}
