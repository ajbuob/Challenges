package com.abuob.challenges.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class ForEachExamples {

    @Test
    public void list_of_list_toMap() {

        List<Integer> A = List.of(1, 1);
        List<Integer> B = List.of(2, 3);
        List<Integer> C = List.of(2, 1);
        List<Integer> D = List.of(2, 2);
        List<Integer> E = List.of(1, 2);
        List<Integer> F = List.of(3, 1);

        List<List<Integer>> timeEntries = List.of(A, B, C, D, E, F);
        //System.out.println("timeEntries:" + timeEntries);

        Map<Integer, List<Integer>> timeToItemsMap = new TreeMap<>();

        timeEntries.forEach(timeEntry -> {
            List<Integer> listOfItems =
                    timeToItemsMap.getOrDefault(timeEntry.get(0), new ArrayList<>());
            listOfItems.add(timeEntry.get(1));
            timeToItemsMap.put(timeEntry.get(0), listOfItems);
        });

        assertThat(timeToItemsMap)
                .isInstanceOf(TreeMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(timeToItemsMap.get(1)).containsExactlyInAnyOrder(1, 2);
        assertThat(timeToItemsMap.get(2)).containsExactlyInAnyOrder(1, 2, 3);
        assertThat(timeToItemsMap.get(3)).containsExactlyInAnyOrder(1);

        //System.out.println("timeToItemsMap:" + timeToItemsMap);

        //timeToItemsMap.forEach( (k,v) -> {
        //System.out.println("\nProcessing time:" + k);
        //   v.forEach(item -> {
        //       System.out.println("Processing item:" + item);
        //   });
        //});
    }
}
