package co.crisi.main.leetcode.groupanagrams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static List<List<String>> groupAnagrams(String[] strs) {

        var table = new Hashtable<Integer, List<String>>();
        var test = new Hashtable<Integer, Hashtable<Character, Integer>>();
        for (int i = 0; i < strs.length; i++) {
            var tableWord = createHashtable(strs[i]);
            var hash = tableWord.hashCode();
            if(!table.containsKey(hash)){
                var list = new ArrayList<String>();
                list.add(strs[i]);
                table.put(hash, list);
                test.put(hash, tableWord);
            }else{
                if(test.get(hash).equals(tableWord)){
                    table.get(hash).add(strs[i]);
                }else{
                    var list = new ArrayList<String>();
                    list.add(strs[i]);
                    test.put(hash+strs[i].hashCode(), tableWord);
                    table.put(hash+strs[i].hashCode(), list);
                }

            }
        }

        var iterator = table.keySet().iterator();
        List<List<String>> groups = new ArrayList<>();
        while(iterator.hasNext()){

            groups.add(table.get(iterator.next()));
        }

        return groups;
    }

    public static Hashtable<Character, Integer> createHashtable(String s) {
        var table = new Hashtable<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                table.replace(c, table.get(c) + 1);
            } else {
                table.put(c, 1);
            }
        }
        return table;
    }

    public static void main(String[] args) {
        List<String> words = List.of("tho","tin","erg","end","pug","ton","alb","mes","job","ads","soy","toe","tap","sen","ape","led","rig","rig","con","wac","gog","zen","hay","lie","pay","kid","oaf","arc","hay","vet","sat","gap","hop","ben","gem","dem","pie","eco","cub","coy","pep","wot","wee");
        System.out.println(groupAnagrams(words.toArray(new String[0])));
    }

}
