package co.crisi.main.hackerrank.drawingbook;

public class Main {

    public static void main(String[] args) {


        System.out.println(pageCount(2, 1));

        //System.out.println(pageCount(10, 5));
    }

    public static int pageCount(int n, int p) {
        // Write your code here
        //n -> pages
        //p -> page to turn to

        if(p==1){
            return 0;
        }

        if(n%2==0 && p == (n-1)) {
             return 1;
        }
        if(p == n ||  p == (n-1) || p > n){
            return 0;
        }

        var counter = 0;
        var v1 = 0;
        var stopper1 = false;
        for(int i=1; i<n && !stopper1; i+=2){
            if(i == p || (p == i-1)){
                v1 = counter;
                stopper1 = true;
            }else{
                counter++;
            }
        }
        var counter2 = 0;
        for(int i=n; i>=1; i-=2){
            if(i == p || (p == i-1)){
                var v2 = counter2;
                return Math.min(v1, v2);
            }else {
                counter2++;
            }
        }

        return counter;

    }
}
