package com.abuob.challenges.codility;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DayOfWeekCalculator {

    public String solution(String S, int K) {

        int move = K % 7;

        Map<String, Integer> dayToNumberMap = new HashMap<>();
        dayToNumberMap.put("Mon", 1);
        dayToNumberMap.put("Tue", 2);
        dayToNumberMap.put("Wed", 3);
        dayToNumberMap.put("Thu", 4);
        dayToNumberMap.put("Fri", 5);
        dayToNumberMap.put("Sat", 6);
        dayToNumberMap.put("Sun", 7);

        int dayNumber = dayToNumberMap.get(S);

        Map<Integer, String> numberToDayMap = dayToNumberMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

        return numberToDayMap.get((dayNumber + move) % 7);
    }
//              -- write your code in PostgreSQL 9.4
//    SELECT p.id as id, p.title as title, SUM (r.number_of_tickets) as reserved_tickets
//    from plays p
//    INNER JOIN reservations r
//    ON p.id = r.play_id
//    GROUP BY p.id, p.title
//    ORDER BY reserved_tickets DESC, p.id ASC;
}
