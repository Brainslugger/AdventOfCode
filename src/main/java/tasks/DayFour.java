package tasks;

import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class DayFour {

    public boolean isIncreasing(String password) {
        return IntStream
                .range(0, password.length() - 1)
                .mapToObj(i -> Integer.parseInt(password.substring(i, i + 1)) <= Integer.parseInt(password.substring(i + 1, i + 2)))
                .reduce(true, (a, b) -> a && b);
    }

    public boolean hasAdjacentDoubles(String password) {
        return IntStream.range(0, password.length() - 1)
                .anyMatch(i -> password.substring(i, i + 1).equals(password.substring(i + 1, i + 2)));
    }

    public boolean hasTrueDoubles(String password) {

        for (int i = 0; i <= 9; i++) {
            if (Pattern.compile("(?<![" + i + "])([" + i + "]{2})(?![" + i + "])").matcher(password).find()) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidPassword(String password) {
        return isIncreasing(password) && hasAdjacentDoubles(password);
    }

    public boolean isValidPasswordPartTwo(String password) {
        return isIncreasing(password) && hasTrueDoubles(password);
    }

}
