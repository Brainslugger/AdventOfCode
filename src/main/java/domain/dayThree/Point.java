package domain.dayThree;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {

    private int x;
    private int y;
    private int steps;

    public int distance() {
        return Math.abs(x) + Math.abs(y);
    }

    public String toString() {
        return ("Point(x=" + x + ", y=" + y + ")");
    }

    @Override
    public boolean equals(Object obj) {
        Point point;
        if (obj == null) {
            return false;
        }
        if (obj instanceof Point) {
            point = (Point) obj;
        } else {
            return false;
        }

        return point.getX() == this.getX() && point.getY() == this.getY();
    }
}
