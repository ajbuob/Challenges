package com.abuob.challenges.streams;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamGroupingByExamples {

    @Test
    public void empty_list_groupingBy_map() {

        List<String> strings = List.of();

        Map<Integer, List<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(0);
    }

    @Test
    public void list_groupingBy_map() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, List<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).containsExactly("a");
        assertThat(result.get(2)).containsExactly("bb", "cc");
        assertThat(result.get(3)).containsExactly("ddd");
    }

    @Test
    public void list_groupingBy_map_custom() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, List<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new,Collectors. toList()));

        assertThat(result)
                .isInstanceOf(TreeMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).containsExactly("a");
        assertThat(result.get(2)).containsExactly("bb", "cc");
        assertThat(result.get(3)).containsExactly("ddd");
    }

    @Test
    public void list_groupingBy_collection() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, TreeSet<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toCollection(TreeSet::new)));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).isInstanceOf(TreeSet.class).containsExactly("a");
        assertThat(result.get(2)).isInstanceOf(TreeSet.class).containsExactly("bb", "cc");
        assertThat(result.get(3)).isInstanceOf(TreeSet.class).containsExactly("ddd");
    }

    @Test
    public void list_groupingBy_counting() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, Long> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).isEqualTo(1);
        assertThat(result.get(2)).isEqualTo(2);
        assertThat(result.get(3)).isEqualTo(1);
    }

    @Test
    public void list_int_grouping_map() {

        List<Integer> list = List.of(1, 2, 3, 3);

        Map<Integer, Long> result = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        assertThat(result)
                .hasSize(3);

        assertThat(result.get(1)).isEqualTo(1);
        assertThat(result.get(2)).isEqualTo(1);
        assertThat(result.get(3)).isEqualTo(2);
    }

    @Test
    public void list_groupingBy_joining() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, String> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining(",", "[", "]")));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).isEqualTo("[a]");
        assertThat(result.get(2)).isEqualTo("[bb,cc]");
        assertThat(result.get(3)).isEqualTo("[ddd]");
    }

    @Test
    public void list_groupingBy_filtering() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, List<String>> result = strings.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.filtering(x -> !x.contains("b"),
                                Collectors.toList())));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).containsExactly("a");
        assertThat(result.get(2)).containsExactly("cc");
        assertThat(result.get(3)).containsExactly("ddd");
    }

    @Test
    public void list_groupingBy_average() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, Double> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.averagingInt(String::hashCode)));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).isGreaterThan(0);
        assertThat(result.get(2)).isGreaterThan(0);
        assertThat(result.get(3)).isGreaterThan(0);
    }

    @Test
    public void list_groupingBy_sum() {

        List<String> strings = List.of("a", "bb", "cc", "ddd");

        Map<Integer, Integer> result = strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.summingInt(String::hashCode)));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(result.get(1)).isGreaterThan(0);
        assertThat(result.get(2)).isGreaterThan(0);
        assertThat(result.get(3)).isGreaterThan(0);
    }
}
