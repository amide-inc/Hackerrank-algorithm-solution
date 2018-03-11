import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String kangaroo(int x1, int v1, int x2, int v2) {
        String res ="";
        if(x1==x2){
            res = "YES";
        }else{
        if(x1>x2){
            if(v2>v1){
                x1 = x1+v1;
                x2 = x2+v2;
                return kangaroo(x1,v1,x2,v2);
            }else{
                res = "NO";
            }
        }else if(x2>x1){
            if(v1>v2) {
                  x1 = x1+v1;
                x2 = x2+v2;
                return kangaroo(x1,v1,x2,v2);
            }else{
                res = "NO";
            }
        }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
