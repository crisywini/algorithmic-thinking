package co.crisi.main.uva.compoundwords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

//should use java 8 :c
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String line = "";
        List<String> words = new ArrayList<>();
        Hashtable<Long, List<String>> hashtable = new Hashtable<>();
        line = reader.readLine();

        while(!line.isEmpty()){

            words.add(line);
            long code = ooat(line, line.length(), 17);
            if (hashtable.containsKey(code)) {
                hashtable.get(code).add(line);
            }else{
                hashtable.put(code, new ArrayList<>());
                hashtable.get(code).add(line);
            }
            line = reader.readLine();
        }


        System.out.println(hashtable);
    }


    public static long ooat(String key, int length, int bits) {
        int hash, i;
        for (hash = 0, i = 0; i < length; i++) {
            hash += key.charAt(i);
            hash += (hash << 10);
            hash ^= (hash >> 6);
        }
        hash += (hash << 3);
        hash ^= (hash >> 11);
        hash *= (hash << 15);
        return hash & hashmask(bits);
    }

    private static int hashsize(int n) {
        return 1 << n;
    }

    private static int hashmask(int n) {
        return hashsize(n) - 1;
    }

}
