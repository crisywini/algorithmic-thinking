package co.crisi.main.leetcode.containsduplicate;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Main {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        var table = createTable(nums);

        var rule1 = false;
        var rule2 = false;
        var keySet = table.keySet().iterator();
        while(keySet.hasNext() && !rule2){
            var key = keySet.next();
            rule1 = table.get(key).size() > 1;
            if (rule1) {
                var tableIndexes = getTable(table.get(key));
                rule2 = tableIndexes.keySet().parallelStream().anyMatch(c -> c <= k);

            }
        }
        return rule1 && rule2;
    }

    public static Hashtable<Integer, List<Integer>> getTable(List<Integer> indexes) {
        var table = new Hashtable<Integer, List<Integer>>();

        for (int i = 0; i < indexes.size(); i++) {
            for (int j = 0; j < indexes.size(); j++) {
                var key = Math.abs(indexes.get(i) - indexes.get(j));
                if (i != j && !table.containsKey(key)) {
                    var arrayList = new ArrayList<Integer>();
                    arrayList.add(indexes.get(i));
                    arrayList.add(indexes.get(j));
                    table.put(key, arrayList);
                }
            }
        }
        return table;
    }

    public static Hashtable<Integer, List<Integer>> createTable(int[] nums) {

        var table = new Hashtable<Integer, List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(nums[i])) {
                var arrayList = new ArrayList<Integer>();
                arrayList.add(i);
                table.put(nums[i], arrayList);
            } else {
                table.get(nums[i]).add(i);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        //int[] nums = {0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0};
        //var num = 1;
        //int[] nums = {1,2,3,1,2,3};
        //var num = 2;
        int[] nums = {313,64,612,515,412,661,244,164,492,744,233,579,62,786,342,817,838,396,230,79,570,702,124,727,586,542,919,372,187,626,869,923,103,932,368,891,411,125,724,287,575,326,88,125,746,117,363,8,881,441,542,653,211,180,620,175,747,276,832,772,165,733,574,186,778,586,601,165,422,956,357,134,857,114,450,64,494,679,495,205,859,136,477,879,940,139,903,689,954,335,859,78,20};
        var num = 22;
        System.out.println(containsNearbyDuplicate(nums, num));
    }

}
