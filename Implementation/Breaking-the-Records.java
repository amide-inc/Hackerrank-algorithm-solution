import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] breakingRecords(int[] score) {
        int hr = score[0];
        int lr = score[0];
        int reco[] = new int[2];
        reco[0] = 0;
        reco[1] = 0;
        for(int i=1;i<score.length;i++){
            if(hr<score[i]){
                hr = score[i];
                reco[0] = reco[0] + 1;
            }
             if(lr>score[i]){
                lr = score[i];
                reco[1] = reco[1] + 1;
            }
        }
        return reco;
        
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for(int score_i = 0; score_i < n; score_i++){
            score[score_i] = in.nextInt();
        }
        int[] result = breakingRecords(score);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}
