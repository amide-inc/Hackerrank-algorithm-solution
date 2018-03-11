import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int pickingNumbers(int[] a) {
      int ar[] = sort(a);
        int com_max = 0;
        int max = 0;
        int in = ar[0];
        for(int i=1;i<ar.length;i++){
            if(ar[i]-in <= 1){
                max++;
               
            }else{
                in = ar[i];
                if(com_max < max)
                    com_max = max;
                max = 0;
            }
        }
        if(max+1 == ar.length)
            com_max = max;
        return com_max+1;
    }
    static int[] sort(int a[]){
        for(int i=1;i<a.length;i++){
            int value = a[i];
            int j = i-1;
            while(j>=0 && a[j]>value){
                a[j+1] = a[j];
                j = j-1;
            }
            a[j+1] = value;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
