package tasks;

import domain.dayThree.Point;
import domain.dayThree.Wire;

import java.util.Arrays;
import java.util.HashMap;

public class DayThree {

    public Wire calculatePositionsForWire(String input) {
        Wire wire = new Wire();
        String[] instructions = input.split(",");
        Arrays.stream(instructions).forEach(x -> calculatePosition(x, wire));
        return wire;
    }

    private Wire calculatePosition(String instruction, Wire wire) {
        Point lastPosition;
        if (wire.getPositions().size() > 0) {
            lastPosition = wire.getPositions().get(wire.getPositions().size() - 1);
        } else {
            lastPosition = new Point(0, 0, 0);
        }
        String direction = instruction.substring(0, 1);
        Point point = new Point(lastPosition.getX(), lastPosition.getY(), lastPosition.getSteps());
        int steps = Integer.parseInt(instruction.substring(1));
        for (int i = 0; i < steps; i++) {
            switch (direction) {
                case "R":
                    point.setX(point.getX() + 1);
                    break;
                case "L":
                    point.setX(point.getX() - 1);
                    break;
                case "U":
                    point.setY(point.getY() + 1);
                    break;
                case "D":
                    point.setY(point.getY() - 1);
                    break;
            }
            point.setSteps(point.getSteps() + 1);
            wire.getPositions().add(point);
            wire.getPosition().put(point.toString(), point);
            lastPosition = wire.getPositions().get(wire.getPositions().size() - 1);
            point = new Point(lastPosition.getX(), lastPosition.getY(), lastPosition.getSteps());
        }
        return wire;
    }

    public int calculateDistanceOfClosestIntersection(Wire first, Wire second) {
        int distance = Integer.MAX_VALUE;

        HashMap<String, Point> intersections = calculateIntersections(first, second);
        for (Point point : intersections.values()) {
            distance = Math.min(point.distance(), distance);
        }
        return distance;
    }

    public int calculateStepsForCheapestIntersection(Wire first, Wire second) {
        int steps = Integer.MAX_VALUE;
        HashMap<String, Point> intersections = calculateIntersections(first, second);
        for (Point point : intersections.values()) {
            int stepHelper = 0;
            stepHelper += first.getPositions().get(first.getPositions().indexOf(point)).getSteps();
            stepHelper += second.getPositions().get(second.getPositions().indexOf(point)).getSteps();
            steps = Math.min(steps, stepHelper);
        }
        return steps;
    }

    public HashMap<String, Point> calculateIntersections(Wire first, Wire second) {
        HashMap<String, Point> intersections = new HashMap<>();
        for (Point position : first.getPositions()) {
            if (second.getPosition().containsKey(position.toString())) {
                if (!intersections.containsKey(position.toString())) {
                    intersections.put(position.toString(), position);
                }
            }
        }
        return intersections;
    }

}
