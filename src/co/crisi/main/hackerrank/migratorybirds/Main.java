package co.crisi.main.hackerrank.migratorybirds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Main {


    class Result {

        /*
         * Complete the 'migratoryBirds' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY arr as parameter.
         */

        public static int migratoryBirds(List<Integer> arr) {

            var sightsClassified = getSightsClassified(arr);

            var sightsClassifiedCounts =sightsClassified.entrySet().stream()
                    .collect(Collectors.groupingBy(
                            Map.Entry::getValue,
                            Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                    ));

            var mostSighted = sightsClassifiedCounts.entrySet().stream().max(Map.Entry.comparingByKey());

            return mostSighted.map(value -> value.getValue().stream().min(Integer::compareTo).orElse(0)).orElse(0);

        }

        public static Map<Integer, Integer> getSightsClassified(List<Integer> arr){
            return arr.stream().collect(Collectors.toMap(
                    num -> num,
                    num -> 1,
                    Integer::sum
            ));
        }

    }

    public static void main(String[] args) throws IOException {
        var sights = List.of(1,2,3,4,5,4,3,2,1,3,4);

        System.out.println(Result.migratoryBirds(sights));
    }


}
