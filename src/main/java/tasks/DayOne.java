package tasks;

import java.util.Arrays;

public class DayOne {

    public int calculateFuelForMass(int mass) {
        int fuel = 0;

        if (mass > 0) {
            fuel = (mass / 3) - 2;
        }
        return fuel;
    }

    public int calculateFuelRequirements(int[] input) {
        if (input == null) {
            return 0;
        }
        return Arrays.stream(input).map(this::calculateFuelForMass).sum();
    }

    public int calculateFuelForFuel(int mass) {
        int result = 0;
        do {
            mass = calculateFuelForMass(mass);
            if (mass > 0) {
                result += mass;
            }
        } while (mass > 0);

        return result;
    }

    public int calculateSumOfFuel(int[] input){
        return Arrays.stream(input).map(this::calculateFuelForFuel).sum();
    }
}
