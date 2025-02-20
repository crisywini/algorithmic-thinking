package co.crisi.main.hackerrank.formingamagicsquare;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        var s = List.of(List.of(4, 8, 2), List.of(4, 5, 7), List.of(6, 1, 6));
        System.out.println(formingMagicSquare(s));
    }

    public static int formingMagicSquare(List<List<Integer>> s) {

        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);

        s.forEach(integers -> {
            var rowSum = integers.stream().reduce(Integer::sum).get();
            var difference = Math.abs(rowSum - 15);
            min.set(Math.min(difference, min.get()));
        });
        var j = s.size()-1;
        var sumDiagonal = 0;
        var sumReverseDiagonal = 0;

        for(int i = 0; i<s.size(); i++, j--){
            sumDiagonal += s.get(i).get(i);
            sumReverseDiagonal += s.get(i).get(j);
        }
        var diagonalDifference = Math.abs(sumDiagonal - 15);
        var diagonal2Difference = Math.abs(sumReverseDiagonal - 15);
        min.set(Math.min(diagonalDifference, min.get()));
        min.set(Math.min(diagonal2Difference, min.get()));

        for(int i=0; i<s.size(); i++){
            var columnSum = 0;
            for( j=0; j<s.get(i).size(); j++){
                columnSum += s.get(j).get(i);
            }
            var difference = Math.abs(columnSum-min.get());
            min.set(Math.min(difference, min.get()));
        }

        return min.get() == 0 ? 1 : min.get();
    }

    public static boolean isMagicSquare(List<List<Integer>> s){
        final int MAGIC_CONSTANT = 15;
        for(int i=0; i<s.size(); i++){
            var columnSum = 0;
            for(int j=0; j<s.get(i).size(); j++){
                columnSum += s.get(j).get(i);
            }
            if(columnSum != MAGIC_CONSTANT){
                return false;
            }
        }
        var columns = s.stream().allMatch( row -> row.stream().reduce(Integer::sum).get() == MAGIC_CONSTANT);
        var sumDiagonal = 0;
        var sumReverseDiagonal = 0;
        var j = s.size()-1;
        for(int i = 0; i<s.size(); i++, j--){
            sumDiagonal += s.get(i).get(i);
            sumReverseDiagonal += s.get(i).get(j);
        }

        return columns && sumDiagonal == MAGIC_CONSTANT && sumReverseDiagonal ==MAGIC_CONSTANT ;
    }

}
