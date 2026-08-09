package co.crisi.main.hackerrank.angryprofessor;

import java.util.List;

public class Main {


    static void main() {
        System.out.println(angryProfessor(3, List.of(-2,-1,0,1,2)));
    }


    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here

        int counter = 0;

        for(int i=0; i<a.size(); i++){
            if(a.get(i) <=0){
                counter++;
            }
        }
        return counter >= k ? "NO": "YES";

    }

}
