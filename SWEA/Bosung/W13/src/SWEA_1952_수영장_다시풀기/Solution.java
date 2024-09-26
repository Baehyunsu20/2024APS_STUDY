package SWEA_1952_수영장_다시풀기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			int D = sc.nextInt();
			int M = sc.nextInt();
			int Q = sc.nextInt();
			int Y = sc.nextInt();
			
			int[] plan = new int[12];
			int[] dp = new int[12];
			
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			
			dp[0] = Math.min(plan[0]*D, M);
			dp[1] = dp[0] + Math.min(plan[1]*D, M);
			dp[2] = Math.min(Q, dp[1] + Math.min(plan[2]*D, M));
			
			for (int i = 3; i < 12; i++) {
				dp[i] = Math.min(dp[i-3] + Q, dp[i-1] + Math.min(plan[i]*D, M));
			}
			
			System.out.println("#" + t + " " + Math.min(dp[11], Y));
		}
	}
}
