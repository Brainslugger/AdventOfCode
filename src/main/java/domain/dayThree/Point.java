package domain.dayThree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private int x;
    private int y;

    public int distance() {
        return Math.abs(x) + Math.abs(y);
    }
}
