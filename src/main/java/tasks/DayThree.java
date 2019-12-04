package tasks;

import domain.dayThree.Point;
import domain.dayThree.Wire;

import java.util.Arrays;

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
            lastPosition = new Point(0, 0);
        }
        String direction = instruction.substring(0, 1);
        Point point = new Point(lastPosition.getX(), lastPosition.getY());
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
            wire.getPositions().add(point);
            lastPosition = wire.getPositions().get(wire.getPositions().size() - 1);
            point = new Point(lastPosition.getX(), lastPosition.getY());
        }
        return wire;
    }

    public int calculateDistanceOfClosestIntersection(Wire first, Wire second) {
        int distance = Integer.MAX_VALUE;
        for (Point position : first.getPositions()) {
            for (Point secondPosition : second.getPositions()) {
                if (secondPosition.equals(position)) {
                    distance = Math.min(distance, secondPosition.distance());
                    break;
                }
            }
        }
        return distance;
    }
}
