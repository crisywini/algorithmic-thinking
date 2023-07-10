package co.crisi.main.dmoj.snowflakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String line = reader.readLine();
        var n = Integer.parseInt(line);
        long[][] array = new long[n][6];

        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            var snowflake = Arrays.stream(line.split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            fillArray(snowflake, array, i);
        }
        System.out.println(solve(array));

    }

    public static String solve(long[][] arr){
        String out = "No two snowflakes are alike.";
        boolean left = false;
        boolean right = false;
        boolean equal = false;
        for(int i = 0; i<arr.length-1 && (!left &&!right&&!equal); i++){

            for(int j = i; j<arr.length-1; j++){
                left = identifyLeft(arr[i], arr[j+1]);
                right = identifyRight(arr[i], arr[j+1]);
                equal = Arrays.equals(arr[i], arr[j+1]);
                if(left || right || equal){
                    out = "Twin snowflakes found.";
                }
            }
        }

        return out;
    }

    private static boolean identifyRight(long[] arr1, long[] arr2) {
        var indexOf = indexOf(arr2, arr1[0]);
        if(indexOf < 0){
            return false;
        }
        var j = indexOf;
        for(int i = 0; i<arr1.length; i++){
            if(arr1[i] != arr2[j]){
                return false;
            }
            j++;
            if(j>=arr2.length){
                j = 0;
            }

        }
        return true;

    }

    private static boolean identifyLeft(long[] arr1, long[] arr2) {
        var indexOf = indexOf(arr2, arr1[0]);
        if(indexOf < 0){
            return false;
        }
        var j = indexOf;
        for(int i = 0; i<arr1.length; i++){
            if(arr1[i] != arr2[j]){
                return false;
            }
            j--;
            if(j<0){
                j = 5;
            }

        }
        return true;
    }

    public static int indexOf(long[] arr, long e){
        for (int i = 0; i<arr.length; i++){
            if(arr[i] == e){
                return i;
            }
        }
        return -1;
    }

    public static void fillArray(List<Long> snowflake, long[][] snowflakes, int i) {
        for (int j = 0; j < snowflake.size(); j++) {
            snowflakes[i][j] = snowflake.get(j);
        }
    }



}
