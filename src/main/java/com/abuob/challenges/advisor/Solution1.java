package com.abuob.challenges.advisor;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static int maxTrailing(List<Integer> levels) {

        if (levels == null || levels.isEmpty()) {
            return 0;
        }

        int levelsSize = levels.size();
        int maxLevel = Collections.max(levels);

        if (maxLevel == levels.get(0)) {
            return -1;
        }

        List<Integer> trailingRecords = new ArrayList<>();

        List<Integer> testRecords;
        int currentLevel;
        int currentMin;

        for (int i = 1; i <= levelsSize - 1; i++) {
            currentLevel = levels.get(i);
            testRecords = levels.subList(0, i + 1);

            currentMin = Collections.min(testRecords);

            if (currentLevel - currentMin > 0) {
                trailingRecords.add(currentLevel - currentMin);
            }
        }
        return Collections.max(trailingRecords);
    }
}
