package start;

import input.Input;
import tasks.DaySeven;

import java.util.ArrayList;
import java.util.Arrays;

public class AdventOfCodeDaySeven {

    public static void main(String[] args) {
        DaySeven daySeven = new DaySeven();
        Input input = new Input();
        System.out.println("\nDay seven, part one:" + daySeven
            .calculateMaxThrusterSignal(input.amplifierControllerSoftware,
                                        new ArrayList<>(Arrays.asList(4, 3, 2, 1, 0))));
    }
}


