package com.abuob.challenges.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CacheContents {

    public static List<Integer> cacheContents(List<List<Integer>> callLogs) {

        List<Integer> defaultList = new ArrayList<>();
        defaultList.add(-1);

        Map<Integer, List<Integer>> timeToItemsMap = new TreeMap<>();

        Map<Integer, Integer> itemToPriorityMap = new TreeMap<>();

        //Populate each time with all items updated
        callLogs.forEach(callLog -> {
            List<Integer> listOfItems =
                    timeToItemsMap.getOrDefault(callLog.get(0), new ArrayList<>());
            listOfItems.add(callLog.get(1));
            timeToItemsMap.put(callLog.get(0), listOfItems);
        });

        Integer currentTime;
        Map<Integer, Long> itemsFrequencyMap;

        List<Integer> currentItems;

        //Process timeToPrioritiesMap -> itemToPriorityMap
        for (Map.Entry<Integer, List<Integer>> entry : timeToItemsMap.entrySet()) {
            currentTime = entry.getKey();
            currentItems = entry.getValue();

            //Adjust priority map to take in account the current passage of time
            itemToPriorityMap = itemToPriorityMap.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey,
                            e -> e.getValue() > 0 ? e.getValue() - 1 : e.getValue()));

            //for each time, compute the priority
            itemsFrequencyMap = currentItems.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Integer currentItem;
            Integer currentPriority, newPriority;
            Long frequency;

            //compute the frequency/newPriority of each item at the current time
            for (Map.Entry<Integer, Long> frequencyEntry : itemsFrequencyMap.entrySet()) {
                currentItem = frequencyEntry.getKey();
                frequency = frequencyEntry.getValue();

                currentPriority = itemToPriorityMap.getOrDefault(currentItem, 0);
                newPriority = Math.toIntExact(currentPriority + frequency * currentTime);

                itemToPriorityMap.put(currentItem, newPriority);
            }
        }

        //Find Items in the cache and return them
        List<Integer> results = itemToPriorityMap.entrySet().stream()
                .filter(e -> e.getValue() >= 5).map(e -> e.getKey()).collect(Collectors.toList());

        return !results.isEmpty() ? results : List.of(-1);
    }
}
