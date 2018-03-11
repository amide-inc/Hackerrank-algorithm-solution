import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int migratoryBirds(int n, int[] ar) {
        int[] bi = new int[5];
        for(int i=0;i<5;i++) {
            int myb = i+1;
             int count=0;
            for(int k=0;k<n; k++) {
                if(ar[k] == myb){
                    count++;
                }
            }
            bi[i] = count;
        }
        int res = 0;
        for(int i=1;i<5;i++) {
         
            if(bi[i] > bi[res]){
                res = i;
            }
        }
        return res+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
