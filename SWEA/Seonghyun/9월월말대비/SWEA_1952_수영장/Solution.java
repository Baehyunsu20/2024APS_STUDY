
import java.util.Scanner;

public class Solution {
    
    public static int mincal(int[] cal, int D, int M, int M3, int Y) {
    	int [] dp = new int [12];

    	for(int i = 0; i < 12; i++) {
    		int Ds = dp[i] + cal[i]*D;
    		int Ms = dp[i] + M;
    		int M3s = 0;
    		if(i > 2) {
    			M3s = dp[i-3] + M3;
    		} else {
    			M3s = M3;
    		}
    		int Ys = Y;
    		
    		dp[i] = Math.min(Math.min(Ds, Ms), Math.min(M3s, Ys));
    	}
    	return dp[11];
    }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int tc = 1; tc <= T; tc++) {
        	
        	int D = sc.nextInt();
        	int M = sc.nextInt();
        	int M3 = sc.nextInt();
        	int Y = sc.nextInt();
        	
        	int [] cal = new int [12];
        	for(int i = 0; i < 12; i++) cal[i] = sc.nextInt();
        	
        	int min = mincal(cal, D, M, M3, Y);
          
        	System.out.println("#" + tc + " " + min);
        }
        sc.close();
    }
}
