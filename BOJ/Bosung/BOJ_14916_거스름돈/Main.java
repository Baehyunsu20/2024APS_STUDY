package BOJ_14916_거스름돈;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] dp = new int[100001];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[1] = -1;
		dp[2] = 1;
		dp[3] = -1;
		dp[4] = 2;
		dp[5] = 1;
		
		for (int i = 6; i <= 100000; i++) {
			if (dp[i-5] != -1) {
				dp[i] = dp[i-5] + 1;	
			}
			if (dp[i-2] != -1) {
				dp[i] = Math.min(dp[i], dp[i-2] + 1);
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		
		Scanner sc = new Scanner(System.in);
		System.out.println(dp[sc.nextInt()]);
	}
}
