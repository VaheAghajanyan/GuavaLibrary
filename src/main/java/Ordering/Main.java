package Ordering;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // LIST OF NUMBERS

        List<Integer> numbers = Lists.newArrayList(6,4,8,6,2,3);
        Collections.sort(numbers, Ordering.natural());
        System.out.println(numbers);
        // 2, 3, 4, 6, 6, 8

        Collections.sort(numbers, Ordering.natural().reversed());
        System.out.println(numbers);
        // 8, 6, 6, 4, 3, 2

        Integer maxValue = Ordering.natural().max(numbers);
        Integer minValue = Ordering.natural().min(numbers);

        System.out.println(maxValue + " " + minValue);
        // 8 and 2

        // LIST OF STRINGS

        Comparator<String> byLength = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        };

        List<String> stringList = Lists.newArrayList("Welcome", "to", "USA");
        Comparator<String> reversedByLength = Ordering.from(byLength).reversed();
        Collections.sort(stringList, reversedByLength);

        System.out.println(stringList);

        // Welcome, USA, to

        List<String> nullList = Lists.newArrayList(null, "welcome", "to", "USA", null, null);
        Collections.sort(nullList, Ordering.from(byLength).nullsLast());
        System.out.println(nullList);
        // null, null, null, etc...

        List<String> nameList = Lists.newArrayList("Abgar", "Gag", "Arpine");
        Collections.sort(nameList, Ordering.from(byLength).reversed());
        System.out.println(nameList);
    }
}
