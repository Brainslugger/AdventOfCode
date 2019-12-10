package start;

import input.Input;
import tasks.DaySix;

public class AdventOfCodeDaySix {

    public static void main(String[] args) {
        DaySix daySix = new DaySix();
        Input input = new Input();
        daySix.createOrbitMap(input.orbitMap);
        System.out.println("Day Six, part one: " + daySix.countOrbits());
        System.out.println("Day Six, part two: " + daySix.calculateMinimumNumberOfOrbitalTransfers());

    }
}


