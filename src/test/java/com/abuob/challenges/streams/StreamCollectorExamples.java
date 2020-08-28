package com.abuob.challenges.streams;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class StreamCollectorExamples {

    @Test
    public void array_stream_list() {

        int integers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        long longs[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        List<Integer> integerList = Arrays.stream(integers).boxed().collect(Collectors.toList());

        List<Long> longList = Arrays.stream(longs).boxed().collect(Collectors.toList());

        assertThat(integerList).isNotNull();
        assertThat(integerList).hasSize(20);

        assertThat(longList).isNotNull();
        assertThat(longList).hasSize(20);
    }

    @Test
    public void list_collect_list() {

        List<Integer> list = List.of();

        List<Integer> result = list.stream()
                .collect(Collectors.toList());

        assertThat(result).isNotNull();
        assertThat(result).hasSize(0);
    }

    @Test
    public void empty_list_collect_list() {

        List<Integer> list = List.of(1, 2, 3);

        List<Integer> result = list.stream()
                .collect(Collectors.toList());

        assertThat(result).hasSize(3).containsOnly(1, 2, 3);
    }


    @Test
    public void empty_list_collect_set() {

        List<Integer> list = List.of();

        Set<Integer> result = list.stream()
                .collect(Collectors.toSet());

        assertThat(result).isNotNull();
        assertThat(result).hasSize(0);
    }

    @Test
    public void list_collect_set() {

        List<Integer> list = List.of(1, 2, 3, 3);

        Set<Integer> result = list.stream()
                .collect(Collectors.toSet());

        assertThat(result)
                .hasSize(3)
                .containsOnly(1, 2, 3);
    }

    @Test
    public void list_collect_collection() {

        List<Integer> list = List.of(1, 2, 3);

        LinkedList<Integer> result = list.stream()
                .collect(Collectors.toCollection(LinkedList::new));
        assertThat(result)
                .hasSize(3)
                .isInstanceOf(LinkedList.class)
                .containsOnly(1, 2, 3);
    }

    @Test
    public void empty_list_collect_map() {

        List<String> list = List.of();

        Map<String, Integer> result = list.stream()
                .collect(Collectors.toMap(e -> e, e -> e.length()));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .hasSize(0)
                .isNotNull();
    }

    @Test
    public void list_collect_map() {

        List<String> list = List.of("one", "two", "three");

        Map<String, Integer> result = list.stream()
                .collect(Collectors.toMap(e -> e, e -> e.length()));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .hasSize(3)
                .containsEntry("one", 3)
                .containsEntry("two", 3)
                .containsEntry("three", 5);
    }

    @Test
    public void list_collect_map_conflict() {

        List<String> list = List.of("one", "two", "three");

        Map<Integer, String> result = list.stream()
                .collect(Collectors.toMap(String::length, e -> e, String::concat));

        assertThat(result)
                .isInstanceOf(HashMap.class)
                .hasSize(2)
                .containsEntry(3, "onetwo")
                .containsEntry(5, "three");
    }

    @Test
    public void list_collect_map_conflict_custom_map() {

        List<String> list = List.of("one", "two", "three");

        Map<Integer, String> result = list.stream()
                .collect(Collectors.toMap(String::length, e -> e, String::concat, TreeMap::new));

        assertThat(result)
                .isInstanceOf(TreeMap.class)
                .hasSize(2)
                .containsEntry(3, "onetwo")
                .containsEntry(5, "three");
    }

    @Test
    public void list_joining() {

        List<String> list = List.of("one", "two", "three");

        String result = list.stream().collect(Collectors.joining());

        assertThat(result).isEqualTo("onetwothree");
    }

    @Test
    public void list_joining_prefix_suffix() {

        List<String> list = List.of("one", "two", "three");

        String result = list.stream().collect(Collectors.joining(",", "[", "]"));

        assertThat(result).isEqualTo("[one,two,three]");
    }

    @Test
    public void list_partitioningBy() {

        List<String> list = List.of("one", "two", "three");

        Map<Boolean, List<String>> result = list.stream()
                .collect(Collectors.partitioningBy(i -> i.length() == 3));

        assertThat(result)
                .hasSize(2)
                .containsEntry(true, List.of("one", "two"))
                .containsEntry(false, List.of("three"));
    }

    @Test
    public void list_partitioningBy_transform() {
        List<String> list = List.of("one", "two", "three");

        Map<Boolean, Set<String>> result = list.stream()
                .collect(Collectors.partitioningBy(i -> i.length() == 3, Collectors.toSet()));

        assertThat(result)
                .hasSize(2)
                .containsEntry(true, Set.of("one", "two"))
                .containsEntry(false, Set.of("three"));
    }

    @Test
    public void list_counting() {
        List<String> list = List.of("one", "two", "three", "four", "five");

        Long result = list.stream().collect(Collectors.counting());

        assertThat(result).isEqualTo(5);

        result = list.stream().count();

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void list_reduce_optional() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Optional<Integer> intOptional = list.stream().collect(Collectors.reducing((x, y) -> x + y));

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(15);

        intOptional = list.stream().reduce((x, y) -> x + y);

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(15);
    }

    @Test
    public void list_reduce_int() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Integer result = list.stream().collect(Collectors.reducing(0, (x, y) -> x + y));

        assertThat(result).isEqualTo(15);

        result = list.stream().reduce(0, (x, y) -> x + y);

        assertThat(result).isEqualTo(15);

    }

    @Test
    public void list_max() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Optional<Integer> intOptional = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(5);

        intOptional = list.stream().max(Comparator.naturalOrder());

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(5);
    }

    @Test
    public void list_min() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        Optional<Integer> intOptional = list.stream().collect(Collectors.minBy(Comparator.naturalOrder()));

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(1);

        intOptional = list.stream().min(Comparator.naturalOrder());

        assertThat(intOptional).isPresent();
        assertThat(intOptional.get()).isEqualTo(1);
    }

    @Test
    public void list_filter() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<Integer> resultList = list.stream()
                .collect(Collectors.filtering(i -> i > 3, Collectors.toList()));

        assertThat(resultList)
                .hasSize(2)
                .isInstanceOf(ArrayList.class)
                .containsOnly(4, 5);

        resultList = list.stream().filter(x -> x > 3).collect(Collectors.toList());

        assertThat(resultList)
                .hasSize(2)
                .isInstanceOf(ArrayList.class)
                .containsOnly(4, 5);
    }

    @Test
    public void list_map() {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        List<Integer> resultList = list.stream()
                .collect(Collectors.mapping(i -> i + 2, Collectors.toList()));

        assertThat(resultList)
                .hasSize(5)
                .isInstanceOf(ArrayList.class)
                .containsOnly(3, 4, 5, 6, 7);

        resultList = list.stream().map(x -> x + 2).collect(Collectors.toList());

        assertThat(resultList)
                .hasSize(5)
                .isInstanceOf(ArrayList.class)
                .containsOnly(3, 4, 5, 6, 7);
    }


    @Test
    public void list_sum() {
        List<String> list = List.of("one", "three", "four");

        Integer result = list.stream()
                .collect(Collectors.summingInt(String::length));

        assertThat(result).isEqualTo(12);

        result = list.stream().mapToInt(String::length).sum();

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void map_keys() {

        Map<Integer, Integer> testMap = Map.of(1, 2, 2, 4, 3, 7);

        Set<Integer> resultSet = testMap.keySet().stream().collect(Collectors.toSet());

        assertThat(resultSet)
                .isInstanceOf(HashSet.class)
                .isNotNull()
                .hasSize(3);

        assertThat(resultSet).containsExactlyInAnyOrder(1, 2, 3);
    }

    @Test
    public void map_values() {

        Map<Integer, Integer> testMap = Map.of(1, 2, 2, 4, 3, 7);

        List<Integer> resultList = testMap.values().stream().collect(Collectors.toList());

        assertThat(resultList)
                .isInstanceOf(ArrayList.class)
                .isNotNull()
                .hasSize(3);

        assertThat(resultList).containsExactlyInAnyOrder(2, 4, 7);
    }

    @Test
    public void map_subtract1_toMap() {

        Map<Integer, Integer> testMap = Map.of(1, 2, 2, 4, 3, 7);

        Map<Integer, Integer> resultMap = testMap.entrySet()
                .stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue() - 1));

        assertThat(resultMap)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(resultMap.get(1)).isEqualTo(1);
        assertThat(resultMap.get(2)).isEqualTo(3);
        assertThat(resultMap.get(3)).isEqualTo(6);
    }

    @Test
    public void map_switch_toMap() {

        Map<Integer, Integer> testMap = Map.of(1, 2, 2, 4, 3, 7);

        Map<Integer, Integer> resultMap = testMap.entrySet()
                .stream().collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()));

        assertThat(resultMap)
                .isInstanceOf(HashMap.class)
                .isNotNull()
                .hasSize(3);

        assertThat(resultMap.get(2)).isEqualTo(1);
        assertThat(resultMap.get(4)).isEqualTo(2);
        assertThat(resultMap.get(7)).isEqualTo(3);
    }

}
