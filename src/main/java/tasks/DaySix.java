package tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DaySix {

    private HashMap<String, String> directOrbit = new HashMap<>();

    public void createOrbitMap(String[] input) {
        for (String s : input) {
            String[] split = s.split("\\)");
            directOrbit.put(split[1], split[0]);
        }
    }

    public HashMap<String, String> getDirectOrbit() {
        return directOrbit;
    }

    public int countOrbits() {
        return directOrbit.keySet().stream().mapToInt(this::countOrbits).sum();
    }

    private int countOrbits(String orbiter) {
        String target;
        target = directOrbit.get(orbiter);
        if (target == null) {
            return 0;
        }
        return 1 + countOrbits(target);
    }

    public int calculateMinimumNumberOfOrbitalTransfers() {
        int transfers = 0;
        List<String> youRoute = getAllOrbits("YOU");
        List<String> santaRoute = getAllOrbits("SAN");
        for (String orbit : youRoute) {
            if (santaRoute.contains(orbit)) {
                transfers = youRoute.indexOf(orbit) + santaRoute.indexOf(orbit);
                break;
            }
        }
        return transfers;
    }

    public List<String> getAllOrbits(String start) {
        List<String> route = new ArrayList<>();
        String value = directOrbit.get(start);
        while (null != value) {
            route.add(value);
            value = directOrbit.get(value);
        }
        return route;
    }
}
