package co.crisi.main.dmoj.foodlines;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String line = reader.readLine();
        var lineL = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
        var n = lineL.get(0);
        var m = lineL.get(1);

        line = reader.readLine();
        var lines = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        solve(lines, m);
    }
    public static void solve(List<Integer> lines, int m){
       for (int i=0; i<m; i++){
           int minIndex = findMinElementIndex(lines);
           System.out.println(lines.get(minIndex));
           lines.set(minIndex, lines.get(minIndex)+1);
       }

    }

    private static int findMinElementIndex(List<Integer> lines) {
        AtomicInteger minIndex = new AtomicInteger();
        IntStream.range(0, lines.size()).forEach(e -> {
            if (lines.get(e)<lines.get(minIndex.get())){
                minIndex.set(e);
            }
        });
        return minIndex.get();
    }

}
