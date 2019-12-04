package domain.dayThree;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Wire {
    private List<Point> positions = new ArrayList<>();
    private HashMap<String, Point> position = new HashMap<>();
}
