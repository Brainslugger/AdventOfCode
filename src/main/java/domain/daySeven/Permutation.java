package domain.daySeven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {

    public static void permutInput(List<Integer> arrayList, int element, List<List<Integer>> permutations) {

        for (int i = element; i < arrayList.size(); i++) {
            Collections.swap(arrayList, i, element);
            permutInput(arrayList, element + 1, permutations);
            Collections.swap(arrayList, element, i);
        }
        if (element == arrayList.size() - 1) {

            permutations.add(new ArrayList<>(arrayList));
        }
    }
}
