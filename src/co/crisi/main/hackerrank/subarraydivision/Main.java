package co.crisi.main.hackerrank.subarraydivision;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        var s = List.of(2,3,4,4,2,1,2,5,3,4,4,3,4,1,3,5,4,5,3,1,1,5,4,3,5,3,5,3,4,4,2,4,5,2,3,2,5,3,4,2,4,3,3,4,3,5,2,5,1,3,1,4,2,2,4,3,3,3,3,4,1,1,4,3,1,5,2,5,1,3,5,4,3,3,1,5,3,3,3,4,5,2);
        System.out.println(birthday(s, 26, 8));
    }


    public static int birthday(List<Integer> s, int d, int m) {
        if(s.size() == m){
            return s.stream().reduce(Integer::sum).get() == d ? 1 : 0;
        }
        int ways = 0;
        for(int i=0; i<s.size() && i+m < s.size()+1; i++) {
            var sublist = s.subList(i, (i+m));
            var sum = sublist.stream().reduce(Integer::sum).get();
            if (sum == d) {
                ways++;
            }
        }
        return ways;
    }

}
