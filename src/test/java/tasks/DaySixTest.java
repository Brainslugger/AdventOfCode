package tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class DaySixTest {

    private DaySix daySix;
    private HashMap<String, List<String>> hashMapForTestInput;

    @BeforeEach
    void setUp() {
        daySix = new DaySix();
    }

    @Test
    void testsPlanetBOrbitsPlanetA() {

    }

    @Test
    void testsCreationOfOrbitMapOneEntry() {
        //given
        String[] input = new String[]{"COM)B", "B)C"};
        HashMap<String, String> result = new HashMap<>();
        result.put("B", "COM");
        result.put("C", "B");

        //when
        daySix.createOrbitMap(input);

        //then
        assertThat(daySix.getDirectOrbit()).isEqualTo(result);
    }

    @Test
    void testsCreationOfOrbitMapMultipleEntry() {
        //given
        String[] input = new String[]{"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
        HashMap<String, String> result = new HashMap<>();
        result.put("B", "COM");
        result.put("C", "B");
        result.put("D", "C");
        result.put("E", "D");
        result.put("F", "E");
        result.put("G", "B");
        result.put("H", "G");
        result.put("I", "D");
        result.put("J", "E");
        result.put("K", "J");
        result.put("L", "K");

        //when
        daySix.createOrbitMap(input);

        //then
        assertThat(daySix.getDirectOrbit()).isEqualTo(result);
    }

    @Test
    void testsCountDirectAndIndirectOrbit() {
        //given
        String[] input = new String[]{"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
        HashMap<String, String> result = new HashMap<>();
        result.put("B", "COM");
        result.put("C", "B");
        result.put("D", "C");
        result.put("E", "D");
        result.put("F", "E");
        result.put("G", "B");
        result.put("H", "G");
        result.put("I", "D");
        result.put("J", "E");
        result.put("K", "J");
        result.put("L", "K");

        //when
        daySix.createOrbitMap(input);
        int checksum = daySix.countOrbits();
        //then
        assertThat(checksum).isEqualTo(42);
    }
}
