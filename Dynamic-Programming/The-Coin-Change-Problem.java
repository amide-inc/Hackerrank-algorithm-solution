import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total = in.nextInt();
		int n = in.nextInt();
		long coins[] = new long[n];
		for(int i=0;i<n;i++) {
			coins[i] = in.nextInt();
		}
		System.out.println(getWays(total, coins));

	}
	  public static long getWays(int total, long coins[]){
	        long temp[][] = new long[coins.length+1][total+1];
	        for(int i=0; i <= coins.length; i++){
	            temp[i][0] = 1;
	        }
	        for(int i=1; i <= coins.length; i++){
	            for(int j=1; j <= total ; j++){
	                if(coins[i-1] > j){
	                    temp[i][j] = temp[i-1][j];
	                }
	                else{
	                    temp[i][j] = temp[i][j-(int)coins[i-1]] + temp[i-1][j];
	                }
	            }
	        }
	        return temp[coins.length][total];
	    }


}
